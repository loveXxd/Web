<template>
  <div id="cheader">
    <div class="header">
      <img class="head-logo"  src="../../assets/image/logo.png">
        <!--a href="/modo/" class="head-logo-icon"> </a-->
    </div>
  </div>
</template>

<script>
export default {
  name: 'cheader'
}
</script>

<style scoped>
  #header{
    //box-shadow: 0px 1px 6px rgba(158, 169, 170, 0.5);
    height: 120px;
  }
  .head-logo-icon {
    display: block;
    width: 100%;
    height: 100px;
    margin-top: 0px;
    background: url("../../assets/image/logo.png") no-repeat;
    -webkit-background-size: cover;
    background-size: cover;
  }
  .head-logo {
    margin: 20px;
    width: 240px;
    height: 83px;
    float: left;
    font-size: 0;
  }
  .header {
    width: 100%;
    height: 100px;
  }
.right{
  float: right;
  margin:30px;
}
</style>
