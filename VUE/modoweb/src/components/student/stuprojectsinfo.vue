/**
* created by lifeng on 2019-05-24
* create time :2019-05-24 13:24
*/

<template>
  <div class='main'>
    <Card>
      <p slot="title">
        项目分配
      </p>

      <Modal
        width="400px"
        :mask-closable="false"
        :scrollable="true"
        v-model="isview"
        title="学生基本信息">
        <updatestudentproject :teacherlist="teacherlist" :clist="clist" :project="currentproject" @updateover="updateoverhandler"></updatestudentproject>
        <div slot="footer">
        </div>
      </Modal>
      <Form :label-width="80">
        <!---FormItem label="姓名:">
          <span>{{username}}</span>
        </FormItem-->
        <Table class="table" highlight-row border :columns="thead" :data="tdata"></Table>
        <Divider/>
        <Row>
          <Col span="7">
            <FormItem label="项目名称:">
              <Input v-model="projectname" placeholder="Enter something..." style="width: 150px"/>
            </FormItem>
          </Col>
          <Col span="7">
            <FormItem label="任课教师:">
              <Select v-model="teacher" style="width:150px" @on-change="teacherselecthandler">
                <Option v-for="(item,index) in teacherlist" :value="item.id" :key="index">{{ item.name }}</Option>
              </Select>
            </FormItem>
          </Col>
          <Col span="9">
            <FormItem label="分配课时:">
              <Select v-model="ctype" style="width:150px" @on-change="changehandler">
                <Option v-for="(item,index) in clist" :value="item.name" :key="index">{{ item.name }}   ( {{item.number}} )</Option>
              </Select>
              <InputNumber v-model="cnum" style="width: 50px"></InputNumber>
            </FormItem>
          </Col>
        </Row>
        <Row>
          <Col span="7">
            <FormItem label="开始时间:">
              <DatePicker v-model="startdate" type="date" placeholder="Select date"></DatePicker>
            </FormItem>
          </Col>
          <Col span="7">
            <FormItem label="结束时间:">
              <DatePicker v-model="enddate" type="date" placeholder="Select date"></DatePicker>
            </FormItem>
          </Col>
          <Col span="1">
            <FormItem>
              <Button type="primary" @click="addprojectHandler">增加</Button>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Card>
  </div>
</template>

<script>
import loader from '../../utils/loader'
import Updatestudentproject from './updatestudentproject'
import date from '../../utils/date'

export default {
  name: 'stuprojectsinfo',
  props: [],
  data () {
    return {
      username: '',
      projectname: '',
      teacher: '',
      ctype: '',
      cnum: 0,
      isview: false,
      teacherlist: [],
      currentproject: {},
      startdate: date.formatDate(new Date()),
      enddate: '',
      clist: [],
      thead: [
        {
          title: '项目名称',
          width: 350,
          key: 'pname'
        },
        {
          title: '任课教师',
          width: 100,
          key: 'name'
        },
        {
          title: '课程类型',
          width: 100,
          key: 'cname'
        },
        {
          title: '课时',
          width: 70,
          align: 'center',
          key: 'cnumber'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'warning',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.isview = true
                    this.currentproject = params.row
                    console.log(this.currentproject)
                  }
                }
              }, '修改')
            ])
          }
        }
      ],
      tdata: []
    }
  },
  components: {Updatestudentproject},
  methods: {
    // 该属性中申明方法
    addprojectHandler () {
      loader.post('/dataserver/modo/student/i_stu_projects.php', {
        uid: this.currentid,
        pname: this.projectname,
        tid: this.teacher,
        cname: this.ctype,
        number: this.cnum,
        sdate: this.startdate,
        edate: this.enddate

      }, (res) => {
        this.loadprojectlist()
      })
    },
    updateoverhandler () {
      console.log('over')
      this.loadprojectlist()
      this.isview = false
    },
    changehandler (name) {

    },
    teacherselecthandler (id) {

    },
    loadprojectlist () {
      this.currentid = this.$route.params.id
      loader.post('/dataserver/modo/student/stu_projectlist.php', {
        id: this.currentid
      }, (res) => {
        if (res.data.result === '1') {
          this.tdata = res.data.data
        }
      })
    }

  },
  beforeCreate: function () {

  },
  created: function () {
    this.username = this.$route.query.name
    this.currentid = this.$route.params.id
    loader.post('/dataserver/modo/student/teacherlist.php', {}, (res) => {
      if (res.data.result === '1') {
        this.teacherlist = res.data.data
      }
    })

    loader.post('/dataserver/modo/student/student_couse_info.php', {
      id: this.currentid
    }, (res) => {
      if (res.data.result === '1') {
        let data = res.data.data
        if (data.length > 0) {
          data = data[0]
          this.clist = []
          let coach = {name: 'COACH', number: Number(data.coach)}
          let studio = {name: 'STUDIO', number: Number(data.studio)}
          let zj = {name: '助教', number: Number(data.zj)}
          let review = {name: 'REVIEW', number: Number(data.review)}
          let ds = {name: '导师', number: Number(data.ds)}
          this.clist.push(coach)
          this.clist.push(studio)
          this.clist.push(review)
          this.clist.push(zj)
          this.clist.push(ds)
        } else {
          this.clist = []
          let coach = {name: 'COACH', number: 0}
          let studio = {name: 'STUDIO', number: 0}
          let zj = {name: '助教', number: 0}
          let review = {name: 'REVIEW', number: 0}
          let ds = {name: '导师', number: 0}
          this.clist.push(coach)
          this.clist.push(studio)
          this.clist.push(review)
          this.clist.push(zj)
          this.clist.push(ds)
        }
      }
    })
    this.loadprojectlist()
  },
  beforeMount: function () {

  },
  mounted: function () {

  },
  beforeUpdate: function () {

  },
  updated: function () {

  },
  beforeDestroy: function () {

  },
  destroyed: function () {

  },
  watch: {
    '$route' (to, from) {
      // 刷新参数放到这里里面去触发就可以刷新相同界面了
      this.username = this.$route.query.name
      this.currentid = this.$route.params.id

      loader.post('/dataserver/modo/student/student_couse_info.php', {
        id: this.currentid
      }, (res) => {
        if (res.data.result === '1') {
          let data = res.data.data
          if (data.length > 0) {
            data = data[0]
            this.clist = []
            let coach = {name: 'COACH', number: Number(data.coach)}
            let studio = {name: 'STUDIO', number: Number(data.studio)}
            let zj = {name: '助教', number: Number(data.zj)}
            let review = {name: 'REVIEW', number: Number(data.review)}
            let ds = {name: '导师', number: Number(data.ds)}
            this.clist.push(coach)
            this.clist.push(studio)
            this.clist.push(review)
            this.clist.push(zj)
            this.clist.push(ds)
          } else {
            this.clist = []
            let coach = {name: 'COACH', number: 0}
            let studio = {name: 'STUDIO', number: 0}
            let zj = {name: '助教', number: 0}
            let review = {name: 'REVIEW', number: 0}
            let ds = {name: '导师', number: 0}
            this.clist.push(coach)
            this.clist.push(studio)
            this.clist.push(review)
            this.clist.push(zj)
            this.clist.push(ds)
          }
        }
      })

      loader.post('/dataserver/modo/student/stu_projectlist.php', {
        id: this.currentid
      }, (res) => {
        if (res.data.result === '1') {
          this.tdata = res.data.data
        }
      })
      /* loader.post('/dataserver/modo/student/student_couse_info.php', {
          id: this.currentid
        }, (res) => {
          if (res.data.result === '1') {
            let data = res.data.data
            if (data.length > 0) {
              data = data[0]
              this.numcoach = Number(data.coach)
              this.numstudio = Number(data.studio)
              this.numzj = Number(data.zj)
              this.numreview = Number(data.review)
              this.num1v1 = Number(data.ds)
            } else {
              this.numcoach = 0
              this.numstudio = 0
              this.numzj = 0
              this.numreview = 0
              this.num1v1 = 0
            }
          }
        }) */
    }
  }
}
</script>

<style scoped>

</style>
