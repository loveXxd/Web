<template>
  <div class="hello">
    <div class="register">
      <div class="register-main">

      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .register-main {
    width: 400px;
    height: 496px;
    padding: 72px 50px 40px;
    background: #fff;
    -webkit-box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);
    box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);

  }
  .register {
    width: 100%;
    height: 755px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    background: url("../assets/image/login-bg.jpg") no-repeat 50%;
    background-size: cover;
    margin-bottom: -160px;
  }
</style>
