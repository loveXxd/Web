/**
* created by lifeng on 2019-05-14
* create time :2019-05-14 19:11
*/

<template>
    <div class='main'>
      <!--Tabs value="name1" class="demo-tabs-style2">
        <TabPane label="学生信息" name="name1"><h1>标签一的内容</h1></TabPane>
        <TabPane label="新建档案" name="name2"><student></student></TabPane>
      </Tabs-->
      <Tabs class="demo-tabs-style2" value="name1" @on-click="selectHandler">
        <TabPane label="学生基本信息" name="name1"></TabPane>
        <TabPane label="课时分配" name="name2"></TabPane>
        <TabPane label="项目分配" name="name3"></TabPane>
        <TabPane label="语言" name="name4"></TabPane>
        <TabPane label="申请院校" name="name5"></TabPane>
      </Tabs>
      <router-view></router-view>
    </div>
</template>

<script>
// import student from '@/components/studeninfo'

export default {
  name: 'studentInfo',
  props: [],
  data () {
    return {

    }
  },
  components: {},
  methods: {

    // 该属性中申明方法

    selectHandler (name) {
      // console.log(name)
      switch (name) {
        case 'name1':
          this.$router.push('/studentmanager/baseinfo')
          break
        case 'name2':
          this.$router.push('/studentmanager/courseperiods')
          break
        case 'name3':
          this.$router.push('/studentmanager/stuprojects')
          break
        case 'name4':
          this.$router.push('/studentmanager/stulanguage')
          break
        case 'name5':
          this.$router.push('/studentmanager/stuschoolselect')
          break
      }
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    this.$router.push('/studentmanager/baseinfo')
  },
  beforeMount: function () {

  },
  mounted: function () {

  },
  beforeUpdate: function () {

  },
  updated: function () {

  },
  beforeDestroy: function () {

  },
  destroyed: function () {

  }
}
</script>

<style scoped>
  .main{
    padding-top: 0px;
  }
  .demo-tabs-style2{
  }
  .demo-tabs-style2>.ivu-tabs-content.ivu-tabs-content-animated{
    height: 100%;
  }
  .demo-tabs-style2.ivu-tabs> .ivu-tabs-bar{
    margin: 0px;
  }
</style>
