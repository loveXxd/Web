/**
* created by lifeng on 2019-06-04
* create time :2019-06-04 20:48
*/

<template>
    <div class='main' style="white-space:nowrap;overflow:auto;">
      <!--Table border large  :columns="theader" :data="dates"></Table-->

      <div style="margin-left: 100px;margin-top: 20px;text-align: center;">
        <div style="display: inline-block;width: 100px; text-align: center;color: #2d8cf0;" v-for="index in 24" :key="index">
          <span>{{index-1}} (时)</span>
        </div>
      </div>

      <div v-for="(item,index) in dates" :key="index">
        <div style="color: #2d8cf0;" ><span>{{item.date}}</span></div>
        <div style="margin-left:100px;">
          <div style="white-space: initial;text-align: center;display: inline-block;width: 100px;border:1px dotted green;"  v-for="(col_item,i) in item.col" :key="i">
            <Tag color="orange" v-for="(col,index) in col_item" :key="index">{{col}}</Tag>
          </div>
        </div>
      </div>

    </div>
</template>

<script>
import date from '../../utils/date'
import loader from '../../utils/loader'
export default {
  name: 'teachertime',
  props: [],
  data () {
    return {
      dates: [],
      times: [],
      theader: [
        {title: '日期', key: 'date', width: 120, fixed: 'left'},
        {title: '0', key: '0', width: 100}, {title: '1', key: '1', width: 100}, {title: '2', key: '2', width: 100}, {title: '3', key: '3', width: 100}, {title: '4', key: '4', width: 100}, {title: '5', key: '5', width: 100}, {title: '6', key: '6', width: 100}, {title: '7', key: '7', width: 100}, {title: '8', key: '8', width: 100}, {title: '9', key: '9', width: 100}, {title: '10', key: '10', width: 100}, {title: '11', key: '11', width: 100}, {title: '12', key: '12', width: 100}, {title: '13', key: '13', width: 100}, {title: '14', key: '14', width: 100}, {title: '15', key: '15', width: 100}, {title: '16', key: '16', width: 100}, {title: '17', key: '17', width: 100}, {title: '18', key: '18', width: 100}, {title: '19', key: '19', width: 100}, {title: '20', key: '20', width: 100}, {title: '21', key: '21', width: 100}, {title: '22', key: '22', width: 100}, {title: '23', key: '23', width: 100}
      ]
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    getDays () {
      let now = new Date()
      let datearr = []
      for (let i = 0; i < 15; i++) {
        let lastdate = new Date()
        lastdate.setDate(now.getDate() + i)
        console.log(date.formatDate(lastdate))
        datearr.push(date.formatDate(lastdate))
      }
      return datearr
    },
    getdateindex (date) {
      for (let i = 0; i < this.dates.length; i++) {
        if (this.dates[i].date === date) {
          return i
        }
      }
    },
    createTags (str, name) {
      if (str) {
        if (str.indexOf(name) !== -1) {

        } else {
          str.push(name)
        }
      } else {
        str = []
        str.push(name)
      }
      return str
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    let dates = this.getDays()

    for (let k = 0; k < dates.length; k++) {
      this.dates.push({date: dates[k], col: Array(24).fill('')})
    }
    console.log('AAA', this.dates)
    /* loader.post('/dataserver/modo/timemanager/timelist.php', {
    }, (res) => {
      console.log(res.data)
      this.times = res.data.data
    }) */

    loader.post('/dataserver/modo/teacher/all_teacher_time.php', {

    }, (res) => {
      if (res.data.result === '1') {
        let ds = res.data.data
        let arr = []
        for (let i = 0; i < ds.length; i++) {
          let obj = ds[i]
          let index = this.getdateindex(obj.date)
          let tdobj = this.dates[index]

          let time = obj.time
          let h = Number(time.split('-')[0].split(':')[0])
          tdobj.col['' + h] = this.createTags(tdobj.col['' + h], obj.name)
          arr.push(tdobj)
          console.log(this.dates)
        }

        let darr = []
        for (let k = 0; k < this.dates.length; k++) {
          darr.push(this.dates[k])
        }

        this.dates = []
        this.dates = darr
        console.log('BBB', this.dates)
      }
    })

    let arr = []
    for (let i = 0; i < 24; i++) {
      arr.push('{title:"' + i + '",key:"' + i + '" ,width:100}')
    }
    console.log(arr.join(','))
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
