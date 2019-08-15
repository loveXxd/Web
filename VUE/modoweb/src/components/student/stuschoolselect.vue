/**
* created by lifeng on 2019-05-27
* create time :2019-05-27 09:01
*/

<template>
  <div class='main' style="height: 100%">
    <studentlist @selectuser="selectUser"></studentlist>
    <div class="right">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Studentlist from './studentlist'
export default {
  name: 'stuschoolselect',
  props: [],
  data () {
    return {}
  },
  components: {Studentlist},
  methods: {
    // 该属性中申明方法
    selectUser (user) {
      // console.log(user)
      this.$router.push({path: '/studentmanager/stuschoolselect/' + user.id, query: {name: user.name}})
    }
  },
  beforeCreate: function () {

  },
  created: function () {

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
  .right{
    width: 800px;
    display: inline-block;
    /*text-align: center;*/
  }
</style>
