/**
* created by lifeng on 2019-05-27
* create time :2019-05-27 21:18
*/

<template>
  <div class='main'>
    <Form :label-width="120">
      <FormItem label="项目名称:">
        <Input v-model="projectname" placeholder="Enter something..." style="width: 150px"/>
      </FormItem>
      <FormItem label="任课教师:">
        <Select v-model="teacher" style="width:150px" @on-change="teacherselecthandler">
          <Option v-for="(item,index) in teacherlist" :value="item.name" :key="index">{{ item.name }}</Option>
        </Select>
      </FormItem>
      <FormItem label="分配课时:">
        <Select v-model="ctype" style="width:150px" @on-change="changehandler">
          <Option v-for="(item,index) in clist" :value="item.name" :key="index">{{ item.name }} ( {{item.number}} )
          </Option>
        </Select>
        <InputNumber v-model="cnum" style="width: 50px"></InputNumber>
      </FormItem>
      <FormItem label="开始时间:">
        <DatePicker v-model="sdate" type="date" placeholder="Select date"></DatePicker>
      </FormItem>
      <FormItem label="结束时间:">
        <DatePicker v-model="edate" type="date" placeholder="Select date"></DatePicker>
      </FormItem>
      <FormItem>
        <Button type="primary" @click="updateprojectHandler">提交</Button>
      </FormItem>
    </Form>
  </div>
</template>

<script>
import loader from '../../utils/loader'

export default {
  name: 'updatestudentproject',
  props: ['teacherlist', 'clist', 'project'],
  data () {
    return {
      username: '',
      projectname: '',
      teacher: '',
      ctype: '',
      cnum: 0,
      sdate: '',
      edate: ''
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    updateprojectHandler () {
      let id = this.getTeachID(this.teacher)

      loader.post('/dataserver/modo/student/u_stu_projects.php', {
        id: this.project.id,
        pname: this.projectname,
        tid: id,
        cname: this.ctype,
        number: this.cnum,
        sdate: this.sdate,
        edate: this.edate
      }, (res) => {
        this.$emit('updateover')
      })
    },
    changehandler (name) {

    },
    teacherselecthandler (id) {

    },
    getTeachID (name) {
      let id = null
      for (let i = 0; i < this.teacherlist.length; i++) {
        if (this.teacherlist[i].name === name) {
          id = this.teacherlist[i].id
        }
      }
      return id
    }

  },
  beforeCreate: function () {

  },
  created: function () {

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
    project (val) {
      // console.log('watch', val)
      this.projectname = this.project.pname
      this.teacher = this.project.name
      this.ctype = this.project.cname
      this.cnum = Number(this.project.cnumber)
      this.sdate = this.project.startdate
      this.edate = this.project.enddate
    },
    teacherlist (val) {
      // console.log('w', val)
    }
  }
}
</script>

<style scoped>

</style>
