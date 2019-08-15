/**
* created by lifeng on 2019-05-14
* create time :2019-05-14 11:43
*/

<template>
    <div class='main'>
      <Row class="row">
        <Col class="col" span="16">
          <div class="left">

          </div>
        </Col>
        <Col class="col" span="8">
          <div class="right">
            <div class="login">
              <h1 style="margin-bottom: 20px">魔豆后台管理程序</h1>
              <vlogin url="/dataserver/modo/login.php" :resultHandler="loginHandler"></vlogin>
            </div>
          </div>
        </Col>
      </Row>

    </div>
</template>

<script>
import Vlogin from '../../components/vlogin'
export default {
  name: 'login',
  props: [],
  data () {
    return {}
  },
  components: {Vlogin},
  methods: {
    // 该属性中申明方法
    loginHandler (res) {
      console.log(res)
      let d = res.data
      if (d.result === '1') {
        window.open('./index.html', '_self')
      }
    }
  },
  beforeCreate: function () {
    console.group('beforeCreate 创建前状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + this.login) // undefined
    console.log('%c%s', 'color:red', 'data   : ' + this) // undefined
  },
  created: function () {
    console.group('created 创建完毕状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + this.login) // undefined
    console.log('%c%s', 'color:red', 'data   : ' + this) // 已被初始化
    console.log('%c%s', 'color:red', 'message: ' + this.message) // 已被初始化
  },
  beforeMount: function () {
    console.group('beforeMount 挂载前状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + (this.login)) // 已被初始化
    console.log(this.login)
    console.log('%c%s', 'color:red', 'data   : ' + this) // 已被初始化
    console.log('%c%s', 'color:red', 'message: ' + this.message) // 已被初始化
  },
  mounted: function () {
    console.group('mounted 挂载结束状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + this.login) // 已被初始化
    console.log(this.login)
    console.log('%c%s', 'color:red', 'data   : ' + this) // 已被初始化
    console.log('%c%s', 'color:red', 'message: ' + this.message) // 已被初始化
  },
  beforeUpdate: function () {
    console.group('beforeUpdate 更新前状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + this.login)
    console.log(this.login)
    console.log('%c%s', 'color:red', 'data   : ' + this)
    console.log('%c%s', 'color:red', 'message: ' + this.message)
  },
  updated: function () {
    console.group('updated 更新完成状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + this.login)
    console.log(this.login)
    console.log('%c%s', 'color:red', 'data   : ' + this)
    console.log('%c%s', 'color:red', 'message: ' + this.message)
  },
  beforeDestroy: function () {
    console.group('beforeDestroy 销毁前状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + this.login)
    console.log(this.login)
    console.log('%c%s', 'color:red', 'data   : ' + this)
    console.log('%c%s', 'color:red', 'message: ' + this.message)
  },
  destroyed: function () {
    console.group('destroyed 销毁完成状态===============》')
    console.log('%c%s', 'color:red', 'el     : ' + this.login)
    console.log(this.login)
    console.log('%c%s', 'color:red', 'data   : ' + this)
    console.log('%c%s', 'color:red', 'message: ' + this.message)
  }
}
</script>

<style scoped>
.main{
  text-align: center;
  width: 100%;
  height: 100%;
}
.row{
  width: 100%;
  height: 100%;
}
.col{
  height: 100%;
}
.left{
  width: 100%;
  height: 100%;
  background: #18b566;
}
.right{
  width: 100%;
  height: 100%;
  vertical-align: middle;
}
.login{
  position: absolute;
  left: 50%;
  top: 50%;

  width: 300px;
  height: 400px;
  margin: auto;
  margin-left: -150px;
  margin-top: -200px;

}
</style>
