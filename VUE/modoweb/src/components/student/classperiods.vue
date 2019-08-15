/**
* created by lifeng on 2019-05-23
* create time :2019-05-23 13:57
*/

<template>
    <div class='main'>
      <studentlist @selectuser="clickhandler"></studentlist>
      <div class="right">
        <router-view></router-view>
      </div>
    </div>
</template>

<script>
// import loader from '../../utils/loader'
import Studentlist from './studentlist'
export default {
  name: 'classperiods ',
  props: [],
  data () {
    return {
      autoheight: 300,

      userdata: []
    }
  },
  components: {Studentlist},
  methods: {
    // 该属性中申明方法
    clickhandler (user) {
      this.$router.push({path: '/studentmanager/classperiods/' + user.id, query: {name: user.name}})
      /* for (let i = 0; i < this.userdata.length; i++) {
        if (this.userdata[i].id === name) {
          this.currentuser = this.userdata[i]
          // console.log(this.currentuser)

          // this.$router.push({path:'/teachermanager/' + id + '/',params:{name:}})
          this.$router.push({path: '/studentmanager/classperiods/' + this.currentuser.id, query: {name: this.currentuser.name}})
        }
      } */
    }
  },
  beforeCreate: function () {

  },
  created: function () {

  },
  beforeMount: function () {

  },
  mounted: function () {
    if (this.$refs.scroll) {
      this.autoheight = this.$refs.scroll.clientHeight
    }
  },
  beforeUpdate: function () {

  },
  updated: function () {
    if (this.$refs.scroll) {
      this.autoheight = this.$refs.scroll.clientHeight
    }
  },
  beforeDestroy: function () {

  },
  destroyed: function () {

  }
}
</script>

<style scoped>
.main{
  height: 100%;

}

.right{
  width: 800px;
  display: inline-block;
  text-align: center;
}
#scroll-1 {
  width:200px;
  height:200px;
  overflow:auto;
}
#scroll-1 div {
  width:400px;
  height:400px;
} #scroll-1::-webkit-scrollbar {
    width:10px;
    height:10px;
  }
#scroll-1::-webkit-scrollbar-button {
  background-color:#FF7677;
}
#scroll-1::-webkit-scrollbar-track {
  background:#FF66D5;
}
#scroll-1::-webkit-scrollbar-track-piece {
  background:url(http://www.lyblog.net/wp/wp-content/themes/mine/img/stripes_tiny_08.png);
}
#scroll-1::-webkit-scrollbar-thumb{
  background:#FFA711;
  border-radius:4px;
}
#scroll-1::-webkit-scrollbar-corner {
  background:#82AFFF;
}
#scroll-1::-webkit-scrollbar-resizer {
  background:#FF0BEE;
}
@-moz-document url-prefix(http://),url-prefix(https://) {
  /* 滚动条颜色 */
  scrollbar {
    -moz-appearance: none !important;
    background: rgb(0,255,0) !important;
  }
  /* 滚动条按钮颜色 */
  thumb,scrollbarbutton {
    -moz-appearance: none !important;
    background-color: rgb(0,0,255) !important;
  }
  /* 鼠标悬停时按钮颜色 */
  thumb:hover,scrollbarbutton:hover {
    -moz-appearance: none !important;
    background-color: rgb(255,0,0) !important;
  }
  /* 隐藏上下箭头 */
  scrollbarbutton {
    display: none !important;
  }
  /* 纵向滚动条宽度 */
  scrollbar[orient="vertical"] {
    min-width: 15px !important;
  }
}
.ivu-layout>.ivu-scroll-container{
    height: 100%;
  }
</style>
