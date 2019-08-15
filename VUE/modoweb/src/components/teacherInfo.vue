/**
* created by lifeng on 2019-05-16
* create time :2019-05-16 15:57
*/

<template>
    <div class='main'>
      <div class="content">
                <card>
                  <div class="avatar">
                    <div style="padding: 0">
                      <img class="lecturer-avatar" :src="avatar" onerror='this.src="data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAAAeAAD/4QNlaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjYtYzE0NSA3OS4xNjM0OTksIDIwMTgvMDgvMTMtMTY6NDA6MjIgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdFJlZj0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlUmVmIyIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9IkU4NzU3MEYwNjE0Mzk5QTFFQ0NBRkVCOEFCOThDNkZFIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjA4QUZGNzEyNzcwMzExRTlCOERFRTY5QzE5QTdDODc5IiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjA4QUZGNzExNzcwMzExRTlCOERFRTY5QzE5QTdDODc5IiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE5IFdpbmRvd3MiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo0NzY5OTAyOC1mZTNlLWMzNGYtYjBjNS1jYzBmZGU4Yjk5NzgiIHN0UmVmOmRvY3VtZW50SUQ9IkU4NzU3MEYwNjE0Mzk5QTFFQ0NBRkVCOEFCOThDNkZFIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+/+4ADkFkb2JlAGTAAAAAAf/bAIQAEAsLCwwLEAwMEBcPDQ8XGxQQEBQbHxcXFxcXHx4XGhoaGhceHiMlJyUjHi8vMzMvL0BAQEBAQEBAQEBAQEBAQAERDw8RExEVEhIVFBEUERQaFBYWFBomGhocGhomMCMeHh4eIzArLicnJy4rNTUwMDU1QEA/QEBAQEBAQEBAQEBA/8AAEQgAgACAAwEiAAIRAQMRAf/EAGMAAQADAQEAAAAAAAAAAAAAAAABAgQDBgEBAAAAAAAAAAAAAAAAAAAAABABAQACAgECBQQDAAAAAAAAAAExAhEDIYESQVFhcaGRsTIzIkJSEQEAAAAAAAAAAAAAAAAAAAAA/9oADAMBAAIRAxEAPwD2oAAAAAAAAAAAAABMwJmAAAAAAt19d3vy1gKyW3iTledO9+Ud5rNZxJxEgz3p3+lUutmZY1oBkGne66682c/JnAAAJmBMwAAAACS2yTNatZNZJMRw6Zzv9o0AAAAAiyWcXFZbPbbL8Gtn7p/n94CgABMwJmAAAAgHTo/n6NCumuuus4nqsAAAAA4d/wDOfZ3V2112nmAzCEgEzAmYAAAhIDt0786+25n7OjLLZeZmNOm3u1l/UEgAAAKdu/t14mattt7dbfkzW3a83IISABMwJmAAAAALdW/tvFxVUA1inV/XFwAV7P69vsDl27+68TE/dRCQAACZgTMAAAELa6bbYnqCE66Xe8THxrpr0/8AV5+kdZJJxPEBEk1kkxEgAWSyy4oAzb6XS+cfCoarJfFw5bdM/wBbx9KDkJ2021zPVUEkzAmYASW3ieaSW3iZrRppNJxM/Ggrp0yedvN/DoAAAAAAAAADnv1a3zr4v4dAGWy63i+KTMaN9ZvOL6Vw4uu3FyD/2Q=="'>
                    </div>
                    <p>{{username}}</p>
                    <Button v-if="status==0" type="warning" long @click="passHandler">通过</Button>
                    <div class="passed" v-if="status==1">
                      <p>已通过</p>
                    </div>
                    <Button type="error" long @click="removeuserHandler">删除</Button>
                  </div>
                </card>
                <card>
                  <div>
                    <Form :label-width="100">
                      <FormItem label="标签" >
                        <Input v-model="tag" placeholder="请输入老师标签"></Input>
                      </FormItem>
                      <FormItem label="评语" >
                        <Input v-model="remark" placeholder="请输入评语"></Input>
                      </FormItem>
                      <Button long type="primary"  @click="remarkHandler">提交</Button>
                    </Form>

                  </div>
                </card>
                <card>
                  <Form>
                    <FormItem label="学科" :label-width="100">
                      <div class="item">
                        <p>{{xk}}</p>
                      </div>
                    </FormItem>
                    <FormItem label="教学服务范围" :label-width="100">
                      <div class="item">
                        <p>{{coursescope}}</p>
                      </div>
                    </FormItem>
                    <FormItem label="教学服务媒介" :label-width="100">
                      <div class="item">
                        <p>{{mj}}</p>
                      </div>
                    </FormItem>
                    <FormItem label="教育背景" :label-width="100">
                      <Tabs size="small" :animated="false" >
                        <TabPane label="北美"><Input :readonly="true" v-model="edubg_na" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="英国"><Input :readonly="true" v-model="edubg_uk" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="欧洲"><Input :readonly="true" v-model="edubg_eur" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="香港\新加坡"><Input :readonly="true" v-model="edubg_hk" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="澳洲"><Input :readonly="true" v-model="edubg_au" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="日本"><Input :readonly="true" v-model="edubg_jp" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="其他"><Input :readonly="true" v-model="edubg_other" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                      </Tabs>
                    </FormItem>
                    <FormItem label="工作与实习经历" :label-width="100">
                      <Input type="textarea" :readonly="true" :autosize="{minRows: 3,maxRows: 30}" v-model="resume"></Input>
                    </FormItem>
                    <FormItem label="荣誉" :label-width="100">
                      <Input type="textarea" :readonly="true" :autosize="{minRows: 3,maxRows: 30}" v-model="honor"></Input>
                    </FormItem>
                    <FormItem label="学术方向" :label-width="100">
                      <Input type="textarea" :readonly="true" :autosize="{minRows: 3,maxRows: 30}" v-model="learning"></Input>
                    </FormItem>
                    <FormItem label="教学期望" :label-width="100">
                      <Input type="textarea" :readonly="true" :autosize="{minRows: 3,maxRows: 30}" v-model="expect"></Input>
                    </FormItem>
                    <FormItem label="教学经验:" :label-width="100">
                      <Input v-model="jxjy" type="textarea" :autosize="{minRows: 3,maxRows: 5}"></Input>
                      <tabs size="small" :animated="false">
                        <TabPane label="北美"><Input :readonly="true" v-model="text_area_na" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="英国"><Input :readonly="true" v-model="text_area_uk" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="欧洲"><Input :readonly="true" v-model="text_area_eur" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="香港\新加坡"><Input :readonly="true" v-model="text_area_hk" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="澳洲"><Input :readonly="true" v-model="text_area_au" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="日本"><Input :readonly="true" v-model="text_area_jp" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                        <TabPane label="其他"><Input :readonly="true" v-model="text_area_other" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                      </tabs>
                    </FormItem>
                  </Form>
                </card>
                <br/>
                <card>
                  <p slot="title">
                    学位证书
                  </p>
                  <div>
                    <img class="works-image" v-for="(item,i ) in xwzs" :key="i" :src="item">
                  </div>
                </card>
                <br/>
                <card>
                  <p slot="title">
                    作品展示
                  </p>
                  <div>
                    <img class="works-image" v-for="(item,i ) in works" :key="i" :src="item">
                  </div>
                </card>
                <br/>
                <card>
                  <p slot="title">
                    教学成果
                  </p>
                  <div>
                    <img class="works-image" v-for="(item,i ) in jxcg" :key="i" :src="item">
                  </div>
                </card>
              </div>
    </div>
</template>

<script>
import loader from '../utils/loader'
export default {
  name: 'teacherInfo',
  props: [],
  data () {
    return {
      userid: '0',
      isview: false,
      tag: '',
      remark: '',
      list: [],
      listindex: 0,
      listname: '',
      color: 'color: #18b566',
      avatar: '/modo/upload/default_avatar.jpg',
      username: '',
      status: 0,
      edubg_na: '',
      edubg_uk: '',
      edubg_hk: '',
      edubg_eur: '',
      edubg_au: '',
      edubg_jp: '',
      edubg_other: '',
      text_area_na: '',
      text_area_uk: '',
      text_area_hk: '',
      text_area_eur: '',
      text_area_au: '',
      text_area_jp: '',
      text_area_other: '',
      xk: '',
      coursescope: '',
      mj: '',
      area: '',
      edubg: '',
      resume: '',
      honor: '',
      learning: '',
      expect: '',
      works: [],
      jxcg: [],
      xwzs: [],
      jxjy: '',
      names: []
    }
  },
  components: {},
  methods: {
    passHandler (e) {
      loader.post('/dataserver/modo/UserPass.php', {
        userid: this.userid
      }, this.passreturnHandler)
    },
    passreturnHandler (res) {
      if (res.data.result === '1') {
        let that = this.$parent.$parent.$parent
        that.changestatus()
        this.$Message.success('已通过！')
        this.status = 1
      } else {

      }
    },
    removeuserHandler () {
      let that = this.$parent.$parent.$parent
      that.removeListItem(this.username)
      // this.names
      loader.post('/dataserver/modo/deleteUser.php', {
        userid: this.userid
      }, (res) => {
        console.log(res)
      })
    },
    remarkHandler () {
      loader.post('/dataserver/modo/teacher/u_remark.php', {
        userid: this.userid,
        tag: this.tag,
        remark: this.remark
      }, (res) => {
        console.log(res)
        if (res.data.result === '1') {
          this.$Message.success('标签与评论提交成功！')
        } else {

        }
      })
    },
    clearviewinfo () {
      this.isview = false
      this.userid = ''
      this.status = ''
      this.avatar = 'data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAAAeAAD/4QNlaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjYtYzE0NSA3OS4xNjM0OTksIDIwMTgvMDgvMTMtMTY6NDA6MjIgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdFJlZj0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlUmVmIyIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9IkU4NzU3MEYwNjE0Mzk5QTFFQ0NBRkVCOEFCOThDNkZFIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjA4QUZGNzEyNzcwMzExRTlCOERFRTY5QzE5QTdDODc5IiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjA4QUZGNzExNzcwMzExRTlCOERFRTY5QzE5QTdDODc5IiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE5IFdpbmRvd3MiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo0NzY5OTAyOC1mZTNlLWMzNGYtYjBjNS1jYzBmZGU4Yjk5NzgiIHN0UmVmOmRvY3VtZW50SUQ9IkU4NzU3MEYwNjE0Mzk5QTFFQ0NBRkVCOEFCOThDNkZFIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+/+4ADkFkb2JlAGTAAAAAAf/bAIQAEAsLCwwLEAwMEBcPDQ8XGxQQEBQbHxcXFxcXHx4XGhoaGhceHiMlJyUjHi8vMzMvL0BAQEBAQEBAQEBAQEBAQAERDw8RExEVEhIVFBEUERQaFBYWFBomGhocGhomMCMeHh4eIzArLicnJy4rNTUwMDU1QEA/QEBAQEBAQEBAQEBA/8AAEQgAgACAAwEiAAIRAQMRAf/EAGMAAQADAQEAAAAAAAAAAAAAAAABAgQDBgEBAAAAAAAAAAAAAAAAAAAAABABAQACAgECBQQDAAAAAAAAAAExAhEDIYESQVFhcaGRsTIzIkJSEQEAAAAAAAAAAAAAAAAAAAAA/9oADAMBAAIRAxEAPwD2oAAAAAAAAAAAAABMwJmAAAAAAt19d3vy1gKyW3iTledO9+Ud5rNZxJxEgz3p3+lUutmZY1oBkGne66682c/JnAAAJmBMwAAAACS2yTNatZNZJMRw6Zzv9o0AAAAAiyWcXFZbPbbL8Gtn7p/n94CgABMwJmAAAAgHTo/n6NCumuuus4nqsAAAAA4d/wDOfZ3V2112nmAzCEgEzAmYAAAhIDt0786+25n7OjLLZeZmNOm3u1l/UEgAAAKdu/t14mattt7dbfkzW3a83IISABMwJmAAAAALdW/tvFxVUA1inV/XFwAV7P69vsDl27+68TE/dRCQAACZgTMAAAELa6bbYnqCE66Xe8THxrpr0/8AV5+kdZJJxPEBEk1kkxEgAWSyy4oAzb6XS+cfCoarJfFw5bdM/wBbx9KDkJ2021zPVUEkzAmYASW3ieaSW3iZrRppNJxM/Ggrp0yedvN/DoAAAAAAAAADnv1a3zr4v4dAGWy63i+KTMaN9ZvOL6Vw4uu3FyD/2Q=='
      this.username = ''
      this.xk = ''
      this.coursescope = ''
      this.mj = ''
      this.area = ''
      this.edubg = ''
      this.resume = ''
      this.honor = ''
      this.learning = ''
      this.expect = ''
      this.jxjy = ''
      this.text_area_other = ''
      this.text_area_jp = ''
      this.text_area_eur = ''
      this.text_area_hk = ''
      this.text_area_na = ''
      this.text_area_uk = ''
      this.text_area_au = ''

      this.edubg_na = ''
      this.edubg_uk = ''
      this.edubg_hk = ''
      this.edubg_eur = ''
      this.edubg_au = ''
      this.edubg_jp = ''
      this.edubg_other = ''

      this.tag = ''
      this.remark = ''

      this.works = []
      this.jxcg = []
      this.xwzs = []
    },
    // 该属性中申明方法
    resHandler (res) {
      res = res.data
      this.userid = res.userid
      this.status = res.status
      this.avatar = res.avatar
      this.username = res.name
      this.xk = res.course
      this.coursescope = res.coursescope
      this.mj = res.coursevehicle
      this.area = res.area
      this.edubg = res.edubackground
      this.resume = res.resume
      this.honor = res.honor
      this.learning = res.learning
      this.expect = res.expect
      this.jxjy = res.jxjy
      this.text_area_other = res.other
      this.text_area_jp = res.jp
      this.text_area_eur = res.eur
      this.text_area_hk = res.hk
      this.text_area_na = res.na
      this.text_area_uk = res.uk
      this.text_area_au = res.au

      this.edubg_na = res.l_na
      this.edubg_uk = res.l_uk
      this.edubg_hk = res.l_hk
      this.edubg_eur = res.l_eur
      this.edubg_au = res.l_au
      this.edubg_jp = res.l_jp
      this.edubg_other = res.l_other

      this.tag = res.tag
      this.remark = res.remark
      if (res.works) {
        console.log(this.works)
        this.works = res.works.split(',')
      }
      if (res.jxcg) {
        this.jxcg = res.jxcg.split(',')
      }
      if (res.xwzs) {
        this.xwzs = res.xwzs.split(',')
      }
    }
  },
  beforeCreate: function () {
    console.log('beforeCreate')
  },
  created: function (o) {
    console.log('created', o)
  },
  watch: {
    '$route' (to, from) {
      console.log(to)
      console.log(from)
      // 刷新参数放到这里里面去触发就可以刷新相同界面了
      console.log(this.$route.params.id)
      this.clearviewinfo()
      loader.post('/dataserver/modo/teacher/teacherbyid.php', {
        id: this.$route.params.id
      }, this.resHandler)
    }
  }
}
</script>

<style scoped>
  .avatar{
    width: 200px;
    height: 200px;
    display: inline-block;
    text-align: center;
    -webkit-box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);
    box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);
    text-align: center;
  }
  .lecturer-avatar{
    width: 100%;
    height: 100%;
  }
  .works-image{
    width: 100%;
  }
  .passed{
    text-align: center;
    color:#FFFFFF;
    background-color:#019642;
    height: 30px
  }
  .passed p{
    display: inline-block;
    margin-top: 5px;
  }
  .content{
    width: 100%;
  }
  .item{
    height: 32px;
    text-align: left;
    border: 1px solid #dcdee2;
  }
  .item-large{
    text-align: left;
    border: 1px solid #dcdee2;

  }
  .item-large p{
    line-height: 24px;
    margin-left: 10px;
    margin-right: 10px;
    color:#019642 ;

    word-wrap:break-word;
    word-break:normal;
  }
  .item p{
    margin-left: 10px;

  }
  .left {
    background: #dddddd;
  }
  .layout {
    background: #ffffff;
  }

  .color-y{
    color: #ff9900;
  }
  .color-g{
    color: #019642;
  }
</style>
