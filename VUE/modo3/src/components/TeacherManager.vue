<template>
  <div id="teachermanager">
    <Layout>
      <Sider class="left" hide-trigger>
        <!--ButtonGroup>
          <Button v-for="item in names" :key="item.index" @click="clickHandler" long ghost type="primary">
            <span>{{item.name}}
            </span>
          </Button>
        </ButtonGroup-->
        <Menu class="menu" width="100%" @on-select="clickHandler">
            <MenuItem  v-for="item in names" :key="item.index"  :name="item.index">
              <Icon :class="list[item.index].status==0?'color-y':'color-g'" type="md-person" />
              {{item.name}}
            </MenuItem>
        </Menu>
      </Sider>
      <Content class="layout">
        <div class="content">
          <card>
            <div class="avatar">
              <div style="padding: 0">
                <img class="lecturer-avatar" :src="avatar">
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
              <!--FormItem label="地区" :label-width="100">
                <div class="item">
                  <p>{{area}}</p>
                </div>
              </FormItem-->
              <FormItem label="教育背景" :label-width="100">
                <!--Input type="textarea" :readonly="true" :autosize="{minRows: 3,maxRows: 30}" v-model="edubg"></Input-->
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

      </Content>
    </Layout>
  </div>
</template>

<script>
import loader from '../utils/loader'
export default {
  name: 'TeacherManager',
  data () {
    return {
      userid: '0',
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
  methods: {
    userinfoHandler (res) {
      this.list = res.data
      for (let i = 0; i < this.list.length; i++) {
        let obj = {}
        obj.name = this.list[i].name
        obj.index = i
        this.names.push(obj)
      }
      this.viewinfo(res.data[this.listindex])
    },
    passreturnHandler (res) {
      if (res.data.result === '1') {
        this.$Message.success('已通过！')
        this.list[this.listindex].status = 1
        console.log(this.list)
        this.status = 1
      } else {

      }
    },
    removeuserHandler () {
      console.log('this is listindex:' + this.listindex)
      let index = this.getindexByname(this.username)
      if (index !== -1) {
        this.names.splice(index, 1)
        this.listindex = 0
        this.viewinfo(this.list[this.listindex])
      }

      // this.names
      loader.post('/dataserver/modo/deleteUser.php', {
        userid: this.userid
      })
    },
    getindexByname (name) {
      for (let i = 0; i < this.names.length; i++) {
        if (this.names[i].name === name) {
          return i
        }
      }
    },
    clickHandler (name) {
      console.log(name)
      this.listindex = name
      this.viewinfo(this.list[this.listindex])
    },
    viewinfo (res) {
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
      // console.log(this.works)
    },
    passHandler (e) {
      loader.post('/dataserver/modo/UserPass.php', {
        userid: this.userid
      }, this.passreturnHandler)
    }

  },
  created () {
    console.log('created')
    loader.post('/dataserver/modo/getAllUserInfo.php', {
    }, this.userinfoHandler)
  }
}
</script>

<style scoped>
  #teachermanager{
    -webkit-touch-callout: none; /* iOS Safari */
    -webkit-user-select: none; /* Chrome/Safari/Opera */
    -khtml-user-select: none; /* Konqueror */
    -moz-user-select: none; /* Firefox */
    -ms-user-select: none; /* Internet Explorer/Edge */
    user-select: none; /* Non-prefixed version, currently not supported by any browser */
  }
  .menu{
    text-align: left;
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
  .color-y{
    color: #ff9900;
  }
  .color-g{
    color: #019642;
  }
</style>
