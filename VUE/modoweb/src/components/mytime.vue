/**
* created by lifeng on 2019-05-17
* create time :2019-05-17 20:31
*
* change by weiqingche on 2019-05-23
* change time :2019-05-23 20:31
*
*/

<template>
    <div class='main'>
      <!--div>{{timelist}}</div-->
      <Modal
        v-model="popwindowvisible"
        title="给学生打分"
        @on-ok="pjok"
        @on-cancel="pjcancel">
        <div style="text-align: center">
          <p>评分</p>
          <span>
            <Row>
            <Col span="12" offset="6">
              <Rate show-text v-model="valueHalf">
                <span style="color: #f5a623">{{ valueHalf }}</span>
              </Rate>
            </Col>
          </Row>
          </span>
        </div>
      </Modal>
      <Card>
        <p slot="title">时间管理</p>
        <timeselect @click="clickHandelr"></timeselect>
      </Card>
    </div>
</template>

<script>
import Timeselect from './timeselect'
// import Courseselect from './courseselect'
import date from '../utils/date'

export default {
  name: 'mytime',
  props: [],
  data () {
    return {
      date: date.getNowFormatDate(),
      timelist: [],
      pjitem: {},
      valueHalf: 5,
      popwindowvisible: false
    }
  },
  components: {Timeselect},
  methods: {
    // 该属性中申明方法
    clickHandelr (item) {
      this.pjitem = item
      this.popwindowvisible = true
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
