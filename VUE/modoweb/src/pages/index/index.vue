/**
* created by lifeng on 2019-05-06
* create time :2019-05-06 16:15
*/

<template>
  <div class='main' v-if="isview">
    <!--router-link to="/foo">Go to Foo</router-link>
    <router-link to="/bar">Go to Bar</router-link-->
    <Layout style="height: 100%">
      <Sider class="left-menu" style="width:240px;max-width: 240px;flex:0 0 240px;">
        <div style="margin: 20px">
          <img style="width: 200px" src="../../assets/image/logo.png"/>
        </div>
        <Menu theme="light" active-name="article" @on-select="selectHandler" style="height: 100%">
          <MenuGroup title="内容管理">
            <MenuItem name="article">
              <Icon type="md-document"/>
              选校助手
            </MenuItem>
            <MenuItem name="teacher" v-if="poswer">
              <Icon type="md-document"/>
              师资管理
            </MenuItem>
            <MenuItem name="student">
              <Icon type="md-document"/>
              学生管理
            </MenuItem>
            <!--MenuItem name="project">
              <Icon type="md-chatbubbles"/>
              项目管理
            </MenuItem-->
            <MenuItem name="mytime">
              <Icon type="md-document"/>
              时间管理
            </MenuItem>
          </MenuGroup>
        </Menu>
      </Sider>
      <Layout>
        <Header :style="{margin:'0px',padding:'0px',background:'#fff', minHeight: '60px'}">
          <div class="userinfo">
           <Dropdown trigger="click" style="margin-left: 20px">
             <Avatar icon="ios-person" size="large" :src="avatarurl" :on-error="errorHandler"/>
              <a href="javascript:void(0)">
                  {{username}}
                  <Icon type="arrow-down-b"></Icon>
              </a>
              <Dropdown-menu slot="list">
                  <Dropdown-item @click.native="loginout">退出登陆</Dropdown-item>
              </Dropdown-menu>
          </Dropdown>
          </div>
        </Header>
        <Content :style="{margin:'0px',background:'#fff', minHeight: '220px'}">
          <router-view></router-view>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
import HelloWorld from '../../components/HelloWorld'
import loader from '../../utils/loader'
import Vlogin from '../../components/vlogin'

export default {
  name: 'index',
  components: {Vlogin, HelloWorld},
  data () {
    return {
      isview: false,
      avatarurl: '',
      username: '',
      poswer: 0
    }
  },
  methods: {
    loginout () {
      console.log('111111111111')
    },
    resultHandler (e) {

    },
    errorHandler (e) {

    },
    selectHandler (e) {
      switch (e) {
        case 'article':
          this.$router.push('/article')

          break
        case 'teacher':
          this.$router.push('/teachermanager')
          break
        case 'student':
          this.$router.push('/studentmanager')

          break
        case 'mytime':
          this.$router.push('/mytime')
          break
        case 'project':
          this.$router.push('/project')
          break
      }
    },
    userinfo (res) {
      console.log(res)
      let d = res.data
      this.avatarurl = d.avatar
      this.username = d.name
    },
    validityHandler (data) {
      console.log(data.data)
      if (data.data.result === '1') {
        // this.$router.push('/teachinfo')
        this.isview = true
        this.$router.push('/article')
        this.poswer = data.data.power
        loader.post('/dataserver/modo/getUserInfo.php', {}, this.userinfo)
      } else {
        this.islogined = false
        window.open('./login.html', '_self')
      }
    }
  },
  created () {
    loader.post('/dataserver/modo/validityJWT.php', {}, this.validityHandler)
  }
}
</script>

<style scoped>
  .main {
    border: 1px solid #d7dde4;
    background: #fff;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
    height: 100%;
  }

  .ivu-layout-sider {
    margin: 0px;
    background: #fff;
    max-width: 240px;
    width: 240px
  }

  .layout-header-bar {
    background: #fff;
    box-shadow: 0 1px 1px rgba(0, 0, 0, .1);
  }

  .menu-item span {
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }

  .menu-item i {
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }

  .collapsed-menu span {
    width: 0px;
    transition: width .2s ease;
  }

  .collapsed-menu i {
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }

  .userinfo {
    float: right;
    margin-right: 20px;
  }
</style>
