/**
* created by lifeng on 2019-05-24
* create time :2019-05-24 10:03
*/

<template>
    <div class='main'>
      <Card>
        <p slot="title">
          课时分配
        </p>
        <Form :label-width="180">
          <FormItem label="姓名:">
            <span>{{username}}</span>
          </FormItem>
          <Divider />
          <FormItem label="COACH:">
            <InputNumber :min="0" large v-model="numcoach"></InputNumber>
          </FormItem>
          <FormItem label="STUDIO:">
            <InputNumber :min="0" large v-model="numstudio"></InputNumber>
          </FormItem>
          <FormItem label="助教:">
            <InputNumber :min="0" large v-model="numzj"></InputNumber>
          </FormItem>
          <FormItem label="REVIEW:">
            <InputNumber :min="0" large v-model="numreview"></InputNumber>
          </FormItem>
          <FormItem label="导师1V1:">
            <InputNumber :min="0" large v-model="num1v1"></InputNumber>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="submitHandler">提交</Button>
          </FormItem>
        </Form>
      </Card>
    </div>
</template>

<script>
import loader from '../../utils/loader'
export default {
  name: 'classperiodsinfo',
  props: [],
  data () {
    return {
      username: '',
      numcoach: 0,
      numstudio: 0,
      numzj: 0,
      numreview: 0,
      num1v1: 0,
      currentid: ''
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    submitHandler () {
      if (this.currentid) {
        loader.post('/dataserver/modo/student/i_student_couse.php', {
          id: this.currentid,
          coach: this.numcoach,
          studio: this.numstudio,
          zj: this.numzj,
          review: this.numreview,
          ds: this.num1v1
        }, (res) => {
          console.log(res)
        })
      }
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
    '$route' (to, from) {
      // console.log(to)
      // console.log(from)
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
      })
    }
  }
}
</script>

<style scoped>

</style>
