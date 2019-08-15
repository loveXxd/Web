/**
* created by wqc on 2019-05-23
* create time :2019-05-23 20:31
*/

<template>
  <div class='main'>
    <Card>
      <p slot="title">选课</p>
      <courseselect @change="coursechange"></courseselect>
      <Button type="primary" @click="submit">提交</Button>
    </Card>
  </div>
</template>

<script>
import Courseselect from './courseselect'
import loader from '../utils/loader'
import date from '../utils/date'

export default {
  name: 'mytime',
  props: [],

  data () {
    return {
      date: date.getNowFormatDate(),
      timelist: [],
      courselist: []
    }
  },
  components: {Courseselect},
  methods: {
    // 该属性中申明方法
    datechange (date, e) {
      let arr = []
      for (let i = 0; i < e.length; i++) {
        let obj = e[i]
        // delete obj.type
        arr.push(obj)
      }
      this.date = date
      this.timelist = arr
    },
    coursechange (selected, datetime) {
      let arr = []
      for (let i = 0; i < selected.length; i++) {
        let obj = selected[i]
        // delete obj.type
        arr.push(obj)
      }
      this.courselist = arr
      this.datetime = datetime
    },
    submit () {
      loader.post('/dataserver/modo/timemanager/i_opendate.php', {
        date: this.date,
        timelist: this.timelist
      }, (res) => {
        console.log(res.data)
      })
    }
  },
  watch: {
    $route (to, from) {
      console.log(to, from)
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    console.log('created')
    loader.post('/dataserver/modo/timemanager/opendate.php', {
      date: this.date
    }, (res) => {
      console.log(res)
    })
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
  .main{
    padding: 10px;
  }
</style>
