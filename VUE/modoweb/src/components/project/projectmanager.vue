/**
* created by lifeng on 2019-05-22
* create time :2019-05-22 10:21
*/

<template>
    <div class='main'>
      <Modal
        width="800px"
        :mask-closable="false"
        :scrollable="true"
        v-model="isview"
        title="项目">
        <addproject></addproject>
        <div slot="footer">
        </div>
      </Modal>
      <card>
        <p slot="title">项目管理</p>
        <Table class="table" highlight-row border :columns="thead" :data="tdata"></Table>
        <!--img :src='isview?"http://localhost:8081/static/img/logo.2073d63.png":"http://icme.club/npma/themes/pmahomme/img/logo_right.png"'/-->
        <!--Button left type="primary" @click="addProject">新建项目</Button-->
      </card>
      <card v-if="manageview">
        <Form :label-width="80">
          <Row>
            <Col span="8">
              <FormItem label="项目名称:">
                <Input v-model="projectname" placeholder="Enter something..." style="width: 150px"/>
              </FormItem>
            </Col>
            <Col span="8">
              <FormItem label="开始时间:">
                <DatePicker v-model="sdate" type="date" placeholder="Select date"></DatePicker>
              </FormItem>
            </Col>
            <Col span="8">
              <FormItem label="结束时间:">
                <DatePicker v-model="edate" type="date" placeholder="Select date"></DatePicker>
              </FormItem>
            </Col>
          </Row>
          <Row>
            <Col offset="2" span="20">
              <Slider v-model="process" show-input></Slider>
            </Col>
          </Row>
          <Row>
            <Col offset="8" span="4">
              <FormItem>
                <Button type="primary" @click="modifyprojectHandler">确定修改</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </card>
    </div>
</template>

<script>
import Addproject from './addproject'
import loader from '../../utils/loader'
export default {
  name: 'projectmanager',
  props: [],
  data () {
    return {
      isview: false,
      manageview: false,
      process: 0,
      projectname: '',
      sdate: '',
      edate: '',
      thead: [
        {
          title: '项目名称',
          key: 'pname'
        },
        {
          title: '起始时间',
          key: 'startdate'
        },
        {
          title: '结束时间',
          key: 'enddate'
        },
        {
          title: '进度',
          key: 'progress'
        },
        {
          title: '操作',
          key: 'action',
          width: 160,
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
                    console.log(params.row)
                    this.projectname = params.row.pname
                    this.sdate = params.row.startdate
                    this.edate = params.row.enddate
                    this.process = Number(params.row.progress)
                    this.id = params.row.id

                    this.manageview = true
                  }
                }
              }, '管理')
            ])
          }
        }
      ],
      tdata: []
    }
  },
  components: {Addproject},
  methods: {
    // 该属性中申明方法
    modifyprojectHandler () {
      // this.isview = !this.isview
      loader.post('/dataserver/modo/teacher/u_project_process.php', {
        id: this.id,
        pname: this.projectname,
        sdate: this.sdate,
        edate: this.edate,
        process: this.process
      }, (res) => {
        if (res.data.result === '1') {
          this.getprojectlist()
        }
      })
    },
    getprojectlist () {
      loader.post('/dataserver/modo/teacher/projectList.php', {

      }, (res) => {
        console.log(res)

        this.tdata = res.data.data
      })
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    this.getprojectlist()
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

  }
}
</script>

<style scoped>

</style>
