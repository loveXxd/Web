<template>
  <div class="teachermanager" id="teachermanager">
    <Layout>
      <Sider class="left" hide-trigger>
        <!--ButtonGroup>
          <Button v-for="item in names" :key="item.index" @click="clickHandler" long ghost type="primary">
            <span>{{item.name}}
            </span>
          </Button>
        </ButtonGroup-->
        <Menu class="menu" width="100%" :active-name="listindex" @on-select="clickHandler">
            <MenuItem  v-for="item in names" :key="item.index"  :name="item.index">
              <Icon :class="list[item.index].status==0?'color-y':'color-g'" type="md-person" />
              {{item.name}}
            </MenuItem>
        </Menu>
      </Sider>
      <Content class="layout">
        <router-view>
        </router-view>
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
  methods: {
    userinfoHandler (res) {
      this.list = res.data
      for (let i = 0; i < this.list.length; i++) {
        let obj = {}
        obj.name = this.list[i].name
        obj.index = i
        this.names.push(obj)
      }
      if (this.names.length > 0) {
        this.listindex = this.names[0].index
        let id = this.list[this.listindex].id
        this.$router.push('/teachermanager/' + id + '/')
      }
    },
    changestatus () {
      this.list[this.listindex].status = 1
    },
    getindexByname (name) {
      for (let i = 0; i < this.names.length; i++) {
        if (this.names[i].name === name) {
          return i
        }
      }
    },
    clickHandler (name) {
      this.listindex = name
      let id = this.list[this.listindex].id
      this.$router.push('/teachermanager/' + id + '/')

      // this.viewinfo(this.list[this.listindex])
    },
    removeListItem (uname) {
      console.log('this is listindex:' + this.listindex)
      let index = this.getindexByname(uname)
      if (index !== -1) {
        this.names.splice(index, 1)
        console.log(this.names)
        if (this.names.length > 0) {
          this.listindex = this.names[0].index
          let id = this.list[this.listindex].id
          this.$router.push('/teachermanager/' + id + '/')
        }
      }
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
    //-webkit-touch-callout: none; /* iOS Safari */
    //-webkit-user-select: none; /* Chrome/Safari/Opera */
    //-khtml-user-select: none; /* Konqueror */
    //-moz-user-select: none; /* Firefox */
    //-ms-user-select: none; /* Internet Explorer/Edge */
    //user-select: none; /* Non-prefixed version, currently not supported by any browser */
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

  .color-y{
    color: #ff9900;
  }
  .color-g{
    color: #019642;
  }
</style>
