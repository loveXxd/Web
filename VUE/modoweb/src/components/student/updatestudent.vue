/**
* created by lifeng on 2019-05-27
* create time :2019-05-27 17:26
*/

<template>
    <div class='main'>
      <Form ref="formInline" :model="userinfo" :rules="ruleInline" inline :label-width="120">
        <FormItem label="姓名" prop="user">
          <Input type="text" v-model="userinfo.name" placeholder="Username">
          </Input>
        </FormItem>
        <FormItem label="联系电话">
          <Input type="tel" v-model="userinfo.tel" placeholder="Password">
          </Input>
        </FormItem>
        <FormItem label="本科院校">
          <Input type="text" v-model="userinfo.course" placeholder="">
          </Input>
        </FormItem>
        <FormItem label="本科专业">
          <Input type="text" v-model="userinfo.major" placeholder="">
          </Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="handleSubmit('formInline')">提交</Button>
        </FormItem>
      </Form>
    </div>
</template>

<script>
import loader from '../../utils/loader'
export default {
  name: 'updatestudent',
  props: ['userinfo'],
  data () {
    return {
      ruleInline: {
        name: [
          { required: true, message: 'Please fill in the user name', trigger: 'blur' }
        ]
      }
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法

    handleSubmit (rule) {
      // console.log(this.userinfo)
      loader.post('/dataserver/modo/student/u_student.php', {
        id: this.userinfo.id,
        name: this.userinfo.name,
        tel: this.userinfo.tel,
        course: this.userinfo.course,
        major: this.userinfo.major
      }, (res) => {
        this.$emit('updateover')
      })
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

</style>
