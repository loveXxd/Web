<template>
    <div id="startpage">
      <div class="title">
        <h1>欢迎申请加入魔豆讲师团队</h1>
      </div>
      <div class="des">
        <div class="des-content">
        <card style="width:640px">

            <!--h2>我们的要求</h2-->
            <ul>
              <li>在这里我们潜心学术、传播知识、授业解惑；</li>
              <li>在这里我们将自身习得的先进设计理念、设计方法与设计资源带给渴望真正碰触设计的学生们，让更多的人有机会接受优质的设计教育！</li>
              <li>目前我们仍以内部邀请制为主，请您阅读须知并同意后，填写所需资料。</li>
            </ul>

        </card>
        </div>
      </div>
      <div class="goto">
        <Button type="primary" to="/register">快去注册 ></Button>
      </div>
    </div>
</template>

<script>
export default {
  name: 'StartPage'
}
</script>

<style scoped>
  .title{
    height: 100px;
    padding: 30px;
  }
  .des{
    height: 280px;
    margin-top: 50px;
  }
  .des-content{
    text-align: left;
    display: inline-block;
    width: 640px;
  }
  .goto{
    height: 250px;
    padding: 30px;
  }
  div{
    //border:1px solid #F00
  }
  p{

  }
  ul{
    display: block;
    font-size: 24px;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
    color: #019642;
  }
  li{

    position: relative;
    padding-left: 8px;
    margin-bottom: 8px;
    line-height: 24px;
    font-size: 14px;
    color: #414141;
  }
</style>
