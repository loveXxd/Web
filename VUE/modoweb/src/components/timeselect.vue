/**
* created by lifeng on 2019-05-18
* create time :2019-05-18 22:18
*/

<template>
<<<<<<< .mine
    <div class='main'>
      <modal v-model="modall" @on-ok="ok"
             @on-cancel="cancel" :type="modalltype"><p style="text-align: center;">{{modallerro}}</p></modal>
      <div style="padding: 5px">
        <h5 style="margin-top: 30px;margin-bottom: 10px">日期选择</h5>
        <DatePicker type="date" :value="datetime" @on-change="tadehasselectcourse" split-panels placeholder="Select date" :clearable="false" style="width: 200px;margin-bottom: 10px;"></DatePicker>
        <Button @click="addHandler($event)" type="primary"><Icon type="md-add" />
          添加</Button>
        <Button @click="removeHandler($event)" type="error"><Icon type="ios-remove-circle-outline" />
          取消</Button>
||||||| .r100
    <div class='main'>
      <modal v-model="modall" @on-ok="ok"
             @on-cancel="cancel" :type="modalltype"><p style="text-align: center;">{{modallerro}}</p></modal>
      <div style="padding: 5px">
        <h5 style="margin-top: 30px;margin-bottom: 10px">日期选择</h5>
        <DatePicker type="date" :value="datetime" split-panels placeholder="Select date" :clearable="false" style="width: 200px;margin-bottom: 10px;"></DatePicker>
        <Button @click="addHandler($event)" type="primary"><Icon type="md-add" />
          添加</Button>
        <Button @click="removeHandler($event)" type="error"><Icon type="ios-remove-circle-outline" />
          取消</Button>
=======
  <div class='main'>
    <!--modal v-model="modall" @on-ok="ok"
           @on-cancel="cancel" :type="modalltype"><p style="text-align: center;">{{modallerro}}</p>
    </modal-->
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
>>>>>>> .r139
      </div>
    </Modal>
    <div style="padding: 5px">
      <h5 style="margin-top: 30px;margin-bottom: 10px">日期选择</h5>
      <DatePicker type="date" :value="datetime" v-model="datetime" split-panels placeholder="Select date"
                  :clearable="false" @on-change="dateChangeHandler"
                  style="width: 200px;margin-bottom: 10px;"></DatePicker>
      <RadioGroup v-model="buttontype" type="button">
        <Radio label="default">打分管理</Radio>
        <Radio label="open">开放时间</Radio>
      </RadioGroup>

      <!--Button @click="addHandler($event)" type="primary"><Icon type="md-add" />
        开放时间</Button>
      <Button @click="removeHandler($event)" type="error"><Icon type="ios-remove-circle-outline" />
        取消</Button-->
    </div>
    <div>
      <span>课程类型：</span>
      <RadioGroup v-model="mstype">
        <Radio label="s">一对一</Radio>
        <Radio label="m">一对多</Radio>
      </RadioGroup>
    </div>
    <div style="display: inline-block;width: 900px">
      <div style="display: inline-block;width: 140px;margin-right: 0px"  v-for="(item,index) in timelist" :key="index">

        <div style="display: inline-block;width: 120px;position: relative">
          <Button style="" class="button_time" :type="item.status===0?'default':'primary'" @click="selectHandler($event)">{{item.time}}</Button>
        </div>
        <div style="text-align: center;display: inline-block;width: 20px;margin-left: -15px;background-color: red;color: white">
          <span>{{item.mstype}}</span>
        </div>

      </div>
      <!--Button style="margin-right: 20px" class="button_time" v-for="(item,index) in timelist" :key="index"
              :type="item.status===0?'default':'primary'" @click="selectHandler($event)">{{item.time}}
        <Badge class="badico" :count="item.mstype" type="success"></Badge>
      </Button-->
    </div>
    <h5 style="margin-top: 30px;margin-bottom: 10px">选课学生</h5>
    <div style="margin:5px;background-color: #019642;color: white;">
      <Row type="flex" justify="center" align="middle">
        <Col span="6">
          <div class="col">姓名</div>
        </Col>
        <Col span="6">
          <div class="col">项目名称</div>
        </Col>
        <Col span="4">
          <div class="col">日期</div>
        </Col>
        <Col span="4">
          <div class="col">时间</div>
        </Col>
        <Col span="4">
          <div class="col">打分</div>
        </Col>
      </Row>
    </div>
    <div  v-for="(item,index) in tdata" :key="index" style="border-bottom:1px dashed #dcdee2;">
      <Row type="flex" justify="center" align="middle">
        <Col span="6">
          <div class="col">{{item.stuname}}</div>
        </Col>
        <Col span="6">
          <div class="col">{{item.pname}}</div>
        </Col>
        <Col span="4">
          <div class="col">{{item.date}}</div>
        </Col>
        <Col span="4">
          <div class="col">{{item.time}}</div>
        </Col>
        <Col span="4">
          <div class="col">
            <div class="col" v-if="item.th_grade_status==='1'">
              {{item.th_grade}}
            </div>
            <Button v-if="item.th_grade_status==='0'" @click="dfHandler(item)" :disabled="item.pjenable" type="primary" size="small">打分</Button>
          </div>
        </Col>
      </Row>
    </div>
    <!--Table class="table" highlight-row border :columns="thead" :data="tdata"></Table-->
    <!--Button style="    right: 100px; margin-left: 85%;margin-top: 8%;width: 120px;" type="primary" @click="submit">提交</Button-->
  </div>
</template>
<script>

import date from '../utils/date'
import loader from '../utils/loader'
import utils from '../utils/utils'
export default {
  name: 'timeselect',
  props: ['initdate'],
  data () {
    return {
      popwindowvisible: false,
      modalltype: 'default',
      buttontype: 'default',
      mstype: 's',
      modallerro: '',
      selecttime: [],
      datetime: date.getNowFormatDate(),
      selectcourse: [],
      courselist: [],
      timelist: [],
      pjitem: {},
      timeitem: {},
      valueHalf: 5,
      thead: [
        {
          title: '学生姓名',

          key: 'stuname'
        },
        {
          title: '课时类型',
          key: 'cname'
        },
        {
          title: '日期',
          key: 'date'
        },
        {
          title: '时间',
          key: 'time'
        }

      ],
      tdata: []
      // timelist: [{text: '00:00-00:30', type: 'default'}, {text: '00:30-01:00', type: 'default'}, {text: '01:00-01:30', type: 'default'}, {text: '01:30-02:00', type: 'default'}, {text: '02:00-02:30', type: 'default'}, {text: '02:30-03:00', type: 'default'}, {text: '03:00-03:30', type: 'default'}, {text: '03:30-04:00', type: 'default'}, {text: '04:00-04:30', type: 'default'}, {text: '04:30-05:00', type: 'default'}, {text: '05:00-05:30', type: 'default'}, {text: '05:30-06:00', type: 'default'}, {text: '06:00-06:30', type: 'default'}, {text: '06:30-07:00', type: 'default'}, {text: '07:00-07:30', type: 'default'}, {text: '07:30-08:00', type: 'default'}, {text: '08:00-08:30', type: 'default'}, {text: '08:30-09:00', type: 'default'}, {text: '09:00-09:30', type: 'default'}, {text: '09:30-10:00', type: 'default'}, {text: '10:00-10:30', type: 'default'}, {text: '10:30-11:00', type: 'default'}, {text: '11:00-11:30', type: 'default'}, {text: '11:30-12:00', type: 'default'}, {text: '12:00-12:30', type: 'default'}, {text: '12:30-13:00', type: 'default'}, {text: '13:00-13:30', type: 'default'}, {text: '13:30-14:00', type: 'default'}, {text: '14:00-14:30', type: 'default'}, {text: '14:30-15:00', type: 'default'}, {text: '15:00-15:30', type: 'default'}, {text: '15:30-16:00', type: 'default'}, {text: '16:00-16:30', type: 'default'}, {text: '16:30-17:00', type: 'default'}, {text: '17:00-17:30', type: 'default'}, {text: '17:30-18:00', type: 'default'}, {text: '18:00-18:30', type: 'default'}, {text: '18:30-19:00', type: 'default'}, {text: '19:00-19:30', type: 'default'}, {text: '19:30-20:00', type: 'default'}, {text: '20:00-20:30', type: 'default'}, {text: '20:30-21:00', type: 'default'}, {text: '21:00-21:30', type: 'default'}, {text: '21:30-22:00', type: 'default'}, {text: '22:00-22:30', type: 'default'}, {text: '22:30-23:00', type: 'default'}, {text: '23:00-23:30', type: 'default'}, {text: '23:30-24:00', type: 'default'}]
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    selectHandler (e) {
      /*
          let timetxt = e.currentTarget.innerText.substring(0, 11)
          let index = this.getTimeindex(timetxt)
          let obj = this.timelist[index]

          let dataindex = this.getdateIndex(timetxt)
          if (dataindex !== -1) {
            if (obj.students > 0) {
              this.modall = true
              this.modallerro = '这个时间已经有' + obj.students + '个学生预约，请您不要辜负学生们的期待哦！！'
            } else {
              this.selecttime.splice(dataindex, 1)
              this.timelist[index].type = 'default'
            }
          } else {
            this.timelist[index].type = 'primary'
            this.selecttime.push(obj)
          }
          this.$emit('change', this.datetime, this.selecttime) */

      let text = e.target.innerText

      switch (this.buttontype) {
        case 'default':
          let index = this._getTimeIndex(text)
          let timeobj = this.timelist[index]
          this.timeitem = timeobj
          if (!timeobj) return
          let status = timeobj.status
          if (status === 1) {
            // console.log('ffff', timeobj.opendateid)
            this.getstudent_selected(timeobj.opendateid)
          }
          break
        case 'open':
          this.openorclose(text)
          break
      }
    },
    getstudent_selected (dateid) {
      loader.post('/dataserver/modo/timemanager/stu_select_course.php', {
        opendateid: dateid,
        type: this.mstype
      }, (res) => {
        console.log(res)
        if (res.data.result === '1') {
          this.tdata = res.data.data
          for (let i = 0; i < this.tdata.length; i++) {
            let obj = this.tdata[i]
            let time = obj.time.split('-')[1]
            let dd = date.getDate(obj.date, time)
            let cd = new Date()
            if (dd > cd) {
              obj.pjenable = true
            } else {
              obj.pjenable = false
            }
          }
        }
      })
    },
    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    _getTimeIndex (text) {
      console.log(this.timelist)
      for (let i = 0; i < this.timelist.length; i++) {
        text = utils.trim(text)
        if (text === this.timelist[i].time) {
          console.log(i)
          return i
        }
      }
    },
    _getTimeIndexByid (id) {
      for (let i = 0; i < this.timelist.length; i++) {
        if (id === this.timelist[i].id) {
          return i
        }
      }
    },
    openorclose (text) {
      let index = this._getTimeIndex(text)
      let timeobj = this.timelist[index]
      let status = timeobj.status
      if (status === 0) {
        loader.post('/dataserver/modo/timemanager/i_opendate.php', {
          date: date.formatDate(this.datetime),
          timeid: timeobj.id,
          type: this.mstype

        }, (res) => {
          this.getOpenDate()
        })
        // this.modall = true
      } else {
        loader.post('/dataserver/modo/timemanager/d_opendate.php', {
          id: timeobj.opendateid
        }, (res) => {
          timeobj.status = 0
          this.getOpenDate()
        })
      }
    },
    getOpenDate () {
      console.log(this.datetime)
      loader.post('/dataserver/modo/timemanager/opendate.php', {
        date: date.formatDate(this.datetime)
      }, (res) => {
        console.log(res.data)
        for (let i = 0; i < res.data.data.length; i++) {
          let obj = res.data.data[i]
          let index = this._getTimeIndexByid(obj.tid)
          let timeobj = this.timelist[index]
          timeobj.status = 1
          timeobj.opendateid = obj.id
          timeobj.mstype = obj.type
          console.log(this.timelist[index])
        }
      })
    },
    dateChangeHandler () {
      this.resetTimeList()
      this.getOpenDate()
    },
    resetTimeList () {
      for (let i = 0; i < this.timelist.length; i++) {
        let obj = this.timelist[i]
        obj.status = 0
        obj.opendateid = -1
        obj.type = 'default'
        obj.students = 0
        obj.mstype = null
      }
    },
    dfHandler (item) {
      let time = item.time.split('-')[1]
      date.getDate(item.date, time)
      this.popwindowvisible = true
      this.pjitem = item
      // this.$emit('click', item)
    },
    pjcancel () {
      this.valueHalf = 5
      this.popwindowvisible = false
    },
    datechange (date, e) {
      let arr = []
      for (let i = 0; i < e.length; i++) {
        let obj = e[i]
        arr.push(obj)
      }
      this.date = date
      this.timelist = arr
    },
    pjok () {
      console.log(this.pjitem)
      loader.post('/dataserver/modo/student/u_stu_dafen.php', {
        id: this.pjitem.id,
        number: this.valueHalf,
        cname: this.pjitem.cname,
        uid: this.pjitem.userid
      }, (res) => {
        if (res.data.result === '1') {
          this.getstudent_selected(this.timeitem.opendateid)
        }
      })
      this.valueHalf = 5
    },
    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    getdateIndex (text) {
      let result = -1
      for (let i = 0; i < this.selecttime.length; i++) {
        if (this.selecttime[i].time === text) {
          result = i
          return result
        }
      }
      return result
    },
    getTimeindex (txt) {
      let result = -1
      for (let i = 0; i < this.timelist.length; i++) {
        if (this.timelist[i].time === txt) {
          result = i
          return result
        }
      }
    },
    courseselectHandler (e) {
      let coursetxt = e.currentTarget.innerText
      let isorno = this.hasincourse(coursetxt)
      let index = this.getcoursindex(coursetxt)
      let obj = ''
      console.log(index)
      obj = this.courselist[index].coursename
      if (isorno === -1) {
        this.courselist[index].type = 'primary'
        this.selectcourse.push(this.courselist[index].coursename)
      } else {
        for (var i = 0; i < this.selectcourse.length; i++) {
          if (this.selectcourse[i].coursename === obj) {
            this.selectcourse.splice(i, 1)
            this.courselist[index].type = 'default'
          }
        }
      }
      this.$emit('change', this.selectcourse, this.datetime)
    },
    hasincourse (text) {
      let result = -1
      if (this.selectcourse) {
        for (let i = 0; i < this.selectcourse.length; i++) {
          if (this.selectcourse[i] === text) {
            result = i
            return result
          }
        }
      }
      return result
    },
    getcoursindex (text) {
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
      this.loadtimeancorse()
    },
    ok () {
    },
    cancel () {
    },
    submit () {
<<<<<<< .mine
      console.log(this.selecttime)
      console.log(this.selectcourse)
      // loader.post('/dataserver/modo/timemanager/i_opendate.php', {
      //   date: this.date,
      //   timelist: this.timelist
      // }, (res) => {
      //   console.log(res.data)
      // })
    },
    loadtimeancorse () {
      loader.post('/dataserver/modo/timemanager/timecourse.php', {
        name: '李二狗', time: '2019-05-01'
      }, (res) => {
        console.log(res)
        // 课程列表
        if (res.data.result === '1') {
          let obj = res.data.data
          this.datetime = obj[0].time
          // 已选课程列表
          if (obj[0].selectcourse) {
            this.selectcourse = []
            let arr = obj[0].selectcourse.split(',')
            if (arr) {
              for (var j = 0; j < this.courselist.length; j++) {
                for (var f = 0; f < arr.length; f++) {
                  if (this.courselist[j].coursename === arr[f]) {
                    // let obj = {coursename: ''}
                    // obj.coursename = arr[f]
                    this.courselist[j].type = 'primary'
                    this.selectcourse.push(arr[f])
                  }
                }
              }
            }
          }

          // 已选时间列表
          if (obj[0].selecttimeAndStudens) {
            this.selecttime = []
            let arr = obj[0].selecttimeAndStudens.split(';')
            if (arr) {
              for (var s = 0; s < arr.length; s++) {
                var indexc = arr[s].split(':')[0]
                var students = arr[s].split(':')[1]
                this.timelist[indexc].type = 'primary'
                this.timelist[indexc].students = parseInt(students)
                this.selecttime.push(this.timelist[indexc])
              }
            }
          }
        } else {
        }
      })
||||||| .r100
      loader.post('/dataserver/modo/timemanager/i_opendate.php', {
        date: this.date,
        timelist: this.timelist
      }, (res) => {
        console.log(res.data)
      })
=======

>>>>>>> .r139
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    loader.post('/dataserver/modo/timemanager/timelist.php', {}, (res) => {
      if (res.data.result === '1') {
        console.log(res.data)
        this.timelist = []
        for (let i = 0; i < res.data.data.length; i++) {
          let obj = {
            id: res.data.data[i].id,
            time: res.data.data[i].time,
            type: 'default',
            status: 0,
            students: 0,
            opendateid: -1
          }
          this.timelist.push(obj)
        }
        console.log(this.timelist)

        this.getOpenDate()
      } else {
      }
    })
    loader.post('/dataserver/modo/timemanager/courselist.php', {
    }, (res) => {
      if (res.data.result === '1') {
        for (let i = 0; i < res.data.data.length; i++) {
          let obj = {coursename: res.data.data[i].course, type: 'default'}
          this.courselist.push(obj)
        }
        this.loadtimeancorse()
      } else {

      }
    })
    /* for (let i = 0; i < this.initdate.length; i++) {
<<<<<<< .mine
      let index = this.getTimeindex(this.initdate[i])
      let obj = this.timelist[index]
      console.log(obj)
      obj.type = 'primary'
      this.date.push(obj)
    } */
    this.$emit('initover', this)
||||||| .r100
      let index = this.getTimeindex(this.initdate[i])
      let obj = this.timelist[index]
      console.log(obj)
      obj.type = 'primary'
      this.date.push(obj)
    } */
    loader.post('/dataserver/modo/timemanager/timecourse.php', {
      name: '李二狗', time: '2019-05-01'
    }, (res) => {
      // 课程列表
      if (res.data.result === '1') {
        let obj = res.data.data
        this.datetime = obj[0].time
        // 所有课程列表
        if (obj[0].allcourse) {
          let arr = obj[0].allcourse.split(',')
          if (arr) {
            for (var i = 0; i < arr.length; i++) {
              let obj = {coursename: '', type: 'default'}
              obj.coursename = arr[i]
              this.courselist.push(obj)
            }
          }
          // 已选课程列表
          if (obj[0].selectcourse) {
            let arr = obj[0].selectcourse.split(',')
            if (arr) {
              for (var j = 0; j < arr.length; j++) {
                let obj = {coursename: '', index: -1}
                obj.coursename = this.courselist[arr[j]].coursename
                obj.index = arr[j]
                this.courselist[arr[j]].type = 'primary'
                this.selectcourse.push(obj)
              }
            }
          }
        }
        // 已选时间列表
        if (obj[0].selecttimeAndStudens) {
          let arr = obj[0].selecttimeAndStudens.split(';')
          if (arr) {
            for (var s = 0; s < arr.length; s++) {
              var indexc = arr[s].split(':')[0]
              var students = arr[s].split(':')[1]
              this.timelist[indexc].type = 'primary'
              this.timelist[indexc].students = parseInt(students)
              this.selecttime.push(this.timelist[indexc])
            }
          }
        }
        console.log(this.timelist)
      } else {
      }
    })
    this.$emit('initover', this)
=======
          let index = this.getTimeindex(this.initdate[i])
          let obj = this.timelist[index]
          console.log(obj)
          obj.type = 'primary'
          this.date.push(obj)
        } */
    /* loader.post('/dataserver/modo/timemanager/timecourse.php', {
      name: '李二狗', time: '2019-05-01'
    }, (res) => {
      // 课程列表
      if (res.data.result === '1') {
        let obj = res.data.data
        this.datetime = obj[0].time
        // 所有课程列表
        if (obj[0].allcourse) {
          let arr = obj[0].allcourse.split(',')
          if (arr) {
            for (var i = 0; i < arr.length; i++) {
              let obj = {coursename: '', type: 'default'}
              obj.coursename = arr[i]
              this.courselist.push(obj)
            }
          }
          // 已选课程列表
          if (obj[0].selectcourse) {
            let arr = obj[0].selectcourse.split(',')
            if (arr) {
              for (var j = 0; j < arr.length; j++) {
                let obj = {coursename: '', index: -1}
                obj.coursename = this.courselist[arr[j]].coursename
                obj.index = arr[j]
                this.courselist[arr[j]].type = 'primary'
                this.selectcourse.push(obj)
              }
            }
          }
        }
        // 已选时间列表
        if (obj[0].selecttimeAndStudens) {
          let arr = obj[0].selecttimeAndStudens.split(';')
          if (arr) {
            for (var s = 0; s < arr.length; s++) {
              var indexc = arr[s].split(':')[0]
              var students = arr[s].split(':')[1]
              this.timelist[indexc].type = 'primary'
              this.timelist[indexc].students = parseInt(students)
              this.selecttime.push(this.timelist[indexc])
            }
          }
        }
        console.log(this.timelist)
      } else {
      }
    }) */
    // this.$emit('initover', this)
>>>>>>> .r139
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
  .main {
    padding: 10px;
  }

  .button_time {
    width: 100px;
    margin: 5px 10px;
    padding: 5px 0 5px 5px;
  }

  .button_cl {
    width: 100px;
    margin: 5px 10px;
    padding: 5px 0 5px 5px;
  }

  .badico {
    margin-left: 10px;
    width: 5px;
    height: 10px;
    top: -5px;
  }
  .col{
    text-align: center;
    margin: 5px;
  }
</style>
