/**
* created by lifeng on 2019-04-26
* create time :2019-04-26 13:41
*/

<template>
    <div class='teachinfopreview'>
      <div class="modo">
          <div class="content">
            <card>

              <a href="#" slot="extra" @click.prevent="returnHandler">
                <Icon type="ios-loop-strong"></Icon>
                返回
              </a>
              <div class="avatar">
                <div style="padding: 0">
                  <img class="lecturer-avatar" :src="avatar">
                </div>
                <p>{{username}}</p>
              </div>
            </card>
            <card>
              <Form :label-width="100">
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
                <!--FormItem label="地区" :label-width="100">
                  <div class="item">
                    <p>{{area}}</p>
                  </div>
                </FormItem-->
                <FormItem label="教育背景" :label-width="100">
                  <!--Input type="textarea" :readonly="true" :autosize="{minRows: 3,maxRows: 30}" v-model="edubg"></Input-->
                  <Tabs size="small" :animated="false">
                    <TabPane label="北美"><Input v-model="edubg_na" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="英国"><Input v-model="edubg_uk" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="欧洲"><Input v-model="edubg_eur" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="香港\新加坡"><Input v-model="edubg_hk" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="澳洲"><Input v-model="edubg_au" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="日本"><Input v-model="edubg_jp" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="其他"><Input v-model="edubg_other" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder=""></Input></TabPane>
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
                <FormItem class="left" label="教学经验:">
                  <Input v-model="jxjy" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input>
                  <tabs size="small" :animated="false">
                    <TabPane label="北美"><Input v-model="text_area_na" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="英国"><Input v-model="text_area_uk" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="欧洲"><Input v-model="text_area_eur" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="香港\新加坡"><Input v-model="text_area_hk" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="澳洲"><Input v-model="text_area_au" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="日本"><Input v-model="text_area_jp" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                    <TabPane label="其他"><Input v-model="text_area_other" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder=""></Input></TabPane>
                  </tabs>
                </FormItem>
              </Form>
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

    </div>
</template>

<script>
import loader from '../utils/loader'
export default {
  name: 'TeacherInfoPreview',
  data () {
    return {
      userid: '0',
      list: [],
      listindex: 0,
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
      names: []
    }
  },
  methods: {
    returnHandler () {
      this.$router.push('/teachinfo')
    },
    userinfoHandler (res) {
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

      this.works = res.works.split(',')
      this.jxcg = res.jxcg.split(',')
      this.xwzs = res.xwzs.split(',')
    },
    string2arr (str) {
      let arr = []
      if (str.indexOf(',')) {
        arr = str.split(',')
        if (arr.length === 1) {
          if (arr[0] === '') {
            arr = []
          }
        }
      }
      return arr
    }
  },
  created () {
    console.log('created')
    loader.post('/dataserver/modo/getUserInfo.php', {}, this.userinfoHandler)
  }
}
</script>

<style scoped>
.left{
  text-align: left;
}
  .modo{
    width: 720px;
    margin: auto;

  }
  .teachinfopreview{
    -webkit-touch-callout: none; /* iOS Safari */
    -webkit-user-select: none; /* Chrome/Safari/Opera */
    -khtml-user-select: none; /* Konqueror */
    -moz-user-select: none; /* Firefox */
    -ms-user-select: none; /* Internet Explorer/Edge */
    user-select: none; /* Non-prefixed version, currently not supported by any browser */
  }
  .passed p{
    display: inline-block;
    margin-top: 5px;
  }
  .content{
    width: 100%;
    margin-top:20px;
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

</style>
