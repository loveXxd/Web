/**
* created by wqc on 2019-05-23
* create time :2019-05-18 9:18
*/

<template>
  <div class='main'>
    <modal v-model="modall" @on-ok="ok"
           @on-cancel="cancel" :type="modalltype"><p style="text-align: center;">{{modallerro}}</p></modal>
    <Card>
      <h5>日期选择</h5>
      <DatePicker type="date" @on-change="tadehasselectcourse"  :value="datetime" split-panels placeholder="Select date" :clearable="false" style="width: 200px"></DatePicker>
      <p slot="title">已选课程</p>
      <!--<Button class="button_cl" v-for="(item,index) in selectcourse" :key="index" :type="item.type" @click="selectHandler($event)">{{item.time}}-->
        <!--<icon v-if="item.type=='primary'&&item.students==0" type="close-circled" size="20" style="padding: 0 5px 0 5px"></icon>-->
        <!--<Badge v-if="item.students!=0"  class="demo_badge" style="padding: 0 5px 0 5px"  :count="item.students"></Badge>-->
      <!--</Button>-->
    </Card>
    <Card>
      <p slot="title">备选课程</p>
      <div style="display: inline-block;width: 100%">
        <Button class="button_cl" v-for="(item,index) in courselist" :key="index" :type="item.type" @click="courseselectHandler($event)">{{item.coursename}}<icon v-if="item.type=='primary'" type="close-circled" size="20" style="padding: 0 5px 0 5px;margin-right: 5px;float: right"></icon>
        </Button>
        <!--<Button class="button_cl" v-for="(item,index) in courselist" :key="index" :type="item.type" @click="selectHandler($event)">{{item.time}}-->
          <!--<icon v-if="item.type=='primary'&&item.students==0" type="close-circled" size="20" style="padding: 0 5px 0 5px"></icon>-->
          <!--<Badge v-if="item.students!=0"  class="demo_badge" style="padding: 0 5px 0 5px"  :count="item.students"></Badge>-->
        <!--</Button>-->
      </div>
    </Card>
  </div>
</template>
<script>
import loader from '../utils/loader'
import date from '../utils/date'
export default {
  name: 'course',
  props: ['initdate'],
  data () {
    return {
      modall: false,
      modalltype: 'default',
      modallerro: '',
      datetime: date.getNowFormatDate(),
      selectcourse: [],
      courselist: []
      // courselist: [{time: '00:00-00:30', type: 'primary', students: 2}, {time: '00:30-01:00', type: 'primary', students: 3}, {time: '01:00-01:30', type: 'primary', students: 0}, {time: '01:30-02:00', type: 'primary', students: 0}, {time: '02:00-02:30', type: 'default', students: 0}, {time: '02:30-03:00', type: 'default', students: 0}, {time: '03:00-03:30', type: 'default', students: 0}, {time: '03:30-04:00', type: 'default', students: 0}, {time: '04:00-04:30', type: 'default', students: 0}, {time: '04:30-05:00', type: 'default', students: 0}, {time: '05:00-05:30', type: 'default', students: 0}, {time: '05:30-06:00', type: 'default', students: 0}, {time: '06:00-06:30', type: 'default', students: 0}, {time: '06:30-07:00', type: 'default', students: 0}, {time: '07:00-07:30', type: 'default', students: 0}, {time: '07:30-08:00', type: 'default', students: 0}, {time: '08:00-08:30', type: 'default', students: 0}, {time: '08:30-09:00', type: 'default', students: 0}, {time: '09:00-09:30', type: 'default', students: 0}, {time: '09:30-10:00', type: 'default', students: 0}, {time: '10:00-10:30', type: 'default', students: 0}, {time: '10:30-11:00', type: 'default', students: 0}, {time: '11:00-11:30', type: 'default', students: 0}, {time: '11:30-12:00', type: 'default', students: 0}, {time: '12:00-12:30', type: 'default', students: 0}, {time: '12:30-13:00', type: 'default', students: 0}, {time: '13:00-13:30', type: 'default', students: 0}, {time: '13:30-14:00', type: 'default', students: 0}, {time: '14:00-14:30', type: 'default', students: 0}, {time: '14:30-15:00', type: 'default', students: 0}, {time: '15:00-15:30', type: 'default', students: 0}, {time: '15:30-16:00', type: 'default', students: 0}, {time: '16:00-16:30', type: 'default', students: 0}, {time: '16:30-17:00', type: 'default', students: 0}, {time: '17:00-17:30', type: 'default', students: 0}, {time: '17:30-18:00', type: 'default', students: 0}, {time: '18:00-18:30', type: 'default', students: 0}, {time: '18:30-19:00', type: 'default', students: 0}, {time: '19:00-19:30', type: 'default', students: 0}, {time: '19:30-20:00', type: 'default', students: 0}, {time: '20:00-20:30', type: 'default', students: 0}, {time: '20:30-21:00', type: 'default', students: 0}, {time: '21:00-21:30', type: 'default', students: 0}, {time: '21:30-22:00', type: 'default', students: 0}, {time: '22:00-22:30', type: 'default', students: 0}, {time: '22:30-23:00', type: 'default', students: 0}, {time: '23:00-23:30', type: 'default', students: 0}, {time: '23:30-24:00', type: 'default'}]
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    selectHandler (e) {
      let timetxt = e.currentTarget.innerText.substring(0, 11)
      let isorno = this.hasincourse(timetxt)
      let index = this.getcoursindex(timetxt)
      let obj = this.courselist[index]
      if (isorno === -1) {
        this.courselist[index].type = 'primary'
        this.selectcourse.push(obj)
      } else {
        if (obj.students > 0) {
          this.modall = true
          this.modallerro = '本课程已经有' + obj.students + '个学生选择，请您不要辜负学生们的期待哦！！'
        } else {
          this.selectcourse.splice(this.selectcourse.indexOf(obj), 1)
          this.courselist[index].type = 'default'
        }
      }
      this.modalltype = 'primary'
      this.$emit('change', this.selectcourse, this.datetime)
    },
    courseselectHandler (e) {
      let coursetxt = e.currentTarget.innerText
      let isorno = this.hasincourse(coursetxt)
      let index = this.getcoursindex(coursetxt)
      let obj = this.courselist[index]
      console.log(index)
      if (isorno === -1) {
        this.courselist[index].type = 'primary'
        this.selectcourse.push(obj)
        console.log(this.selectcourse[0].coursename.length)
      } else {
        this.selectcourse.splice(this.selectcourse.indexOf(obj), 1)
        console.log(this.selectcourse.indexOf(obj))
        this.courselist[index].type = 'default'
      }
      this.$emit('change', this.selectcourse, this.datetime)
    },
    hasincourse (text) {
      let result = -1
      if (this.selectcourse) {
        for (let i = 0; i < this.selectcourse.length; i++) {
          if (this.selectcourse[i].coursename === text) {
            result = i
            return result
          }
        }
      }
      return result
    },
    getcoursindex (text) {
      // console.log(text)
      let result = -1
      for (let i = 0; i < this.courselist.length; i++) {
        if (this.courselist[i].coursename === text) {
          result = i
          return result
        }
      }
      return result
    },
    tadehasselectcourse (e) {
      this.datetime = e
    },
    ok () {},
    cancel () {}
  },
  computed: {
  },
  watch: {
    // datetime (val) {
    //   console.log(val)
    // }
  },
  beforeCreate: function () {

  },
  created: function () {
    loader.post('/dataserver/modo/timemanager/timelist.php', {
    }, (res) => {
      if (res.data.result === '1') {
        // console.log(res.data.data)
        for (let i = 0; i < res.data.data.length; i++) {
          let obj = res.data.data[i]
          obj['type'] = 'default'
        }
        for (var i = 0; i < this.courselist.length; i++) {
          let obj = this.courselist[i]
          if (obj.type === 'primary') {
            // obj['type'] = 'primary'
            this.selectcourse.push(obj)
          }
        }
      } else {

      }
    })
    // this.$emit('initover', this)
    loader.post('/dataserver/modo/timemanager/timecourse.php', {
      name: '李二狗', time: '2019-05-01'
    }, (res) => {
      if (res.data.result === '1') {
        let obj = res.data.data
        this.datetime = obj[0].time
        console.log(obj[0])
        if (obj[0].allcourse) {
          let arr = obj[0].allcourse.split(',')
          if (arr) {
            for (var i = 0; i < arr.length; i++) {
              let obj = {coursename: '', type: 'default'}
              obj.coursename = arr[i]
              this.courselist.push(obj)
            }
          }
          if (obj[0].selectcourse) {
            let arr = obj[0].selectcourse.split(',')
            if (arr) {
              for (var j = 0; j < arr.length; j++) {
                let obj = {coursename: '', type: 'primary'}
                console.log(arr[j])
                obj.coursename = this.courselist[arr[j]].coursename
                this.courselist[arr[j]].type = 'primary'
                this.selectcourse.push(obj)
              }
            }
          }
        }
      } else {

      }
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
  .cancelimg{
    display: inline-block;
    width: 20px;
    vertical-align: middle;
    margin-left: 10px;
  }
  .demo_badge{
    position: absolute;
    top: -10px;
    padding: 0;
    width: 0;
  }
  .button_cl{
    width:100px ; margin:
    5px 10px;padding:
    5px 0 5px 5px;
  }
</style>
