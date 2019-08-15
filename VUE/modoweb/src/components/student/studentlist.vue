/**
* created by lifeng on 2019-05-24
* create time :2019-05-24 11:19
*/

<template>
    <div class='main' ref="scroll">
        <Scroll :height="autoheight">
          <!--CellGroup @on-click="clickhandler">
            <Cell v-for="(item,index) in userdata" :name="item.id" :key="index" :title="item.name" />
          </CellGroup-->

          <Menu class="menu" width="100%" @on-select="clickhandler">
            <MenuItem  v-for="(item,index) in userdata" :key="index"  :name="item.id">
              <!--Icon :class="list[item.index].status==0?'color-y':'color-g'" type="md-person" /-->
              {{item.name}}
            </MenuItem>
          </Menu>
        </Scroll>
    </div>
</template>

<script>
import loader from '../../utils/loader'
export default {
  name: 'studentlist',
  props: [],
  data () {
    return {
      autoheight: 300,
      userdata: '',
      currentuser: '',
      currentname: ''
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    clickhandler (name) {
      for (let i = 0; i < this.userdata.length; i++) {
        if (this.userdata[i].id === name) {
          this.currentuser = this.userdata[i]
          this.$emit('selectuser', this.currentuser)
        }
      }
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    loader.post('/dataserver/modo/student/studentlist.php', {

    }, (res) => {
      this.userdata = res.data.data
      // this.userdata = res.data.data
      if (this.userdata.length > 0) {
        // this.currentuser = this.userdata[0]
        // this.currentname = this.currentuser.id
        // this.$emit('selectuser', this.currentuser)
      }

      if (this.$refs.scroll) {
        this.autoheight = this.$refs.scroll.clientHeight
      }
    })
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
    height: 100%;
    width: 200px;
    display: inline-block;
    float: left;
  }
</style>
