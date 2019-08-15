/**
* created by lifeng on 2019-05-06
* create time :2019-05-06 17:22
*/

<template>
  <div class='main'>
    <div class="register-main" :style="style">
      <Form :model="formInline" :rules="ruleInline">
        <FormItem prop="user">
          <Input type="text" v-model="formInline.user" placeholder="用户名" size="large"/>
        </FormItem>
        <FormItem prop="password">
          <Input type="password" v-model="formInline.password" placeholder="密码" size="large"/>
        </FormItem>
        <Button type="primary" long size="large" @click="loginHandler">登录</Button>
      </Form>
    </div>

  </div>
</template>

<script>
import loader from '../utils/loader'

export default {
  name: 'vlogin',
  props: ['url', 'resultHandler', 'width'],
  data () {
    return {
      style: 'width:' + this.width + 'px',
      formInline: {
        user: '',
        password: ''
      },
      ruleInline: {
        user: [
          {
            required: true,
            message: '请输入正确的邮箱地址!',
            trigger: 'blur',
            transform (value) {
              // var myreg = /^[1][3,4,5,7,8][0-9]{9}$/
              var reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
              if (!reg.test(value)) {
                return false
              } else {
                return value
              }
            }
          }
        ],
        password: [
          {required: true, message: '请输入密码.', trigger: 'blur'},
          {type: 'string', min: 6, message: 'The password length cannot be less than 6 bits', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    loginHandler (name) {
      loader.post(this.url, {
        username: this.formInline.user,
        password: this.formInline.password
      }, this.resultHandler)
    }
    /* successHandler (res) {
        console.log(res.data)
        if (res.data.result === '1') {
          this.$Message.success('登录已成功！')
          this.$router.push('/teachermanage')
        } else {
          this.$Message.error('登录失败！请检查用户名或密码！')
        }
      } */
  }
}
</script>

<style scoped>
  .register-main {

  }
</style>
