<template>
  <div id="admin">
    <div class="register">
      <div class="dialog">
        <!--img class="banner" src="../assets/image/login-bg.jpg"/-->
      </div>
      <div class="register-main">
        <Form :model="formInline" :rules="ruleInline">
          <FormItem prop="user">
            <Input type="text" v-model="formInline.user" placeholder="用户名" size="large">
            </Input>
          </FormItem>
          <FormItem prop="password">
            <Input type="password" v-model="formInline.password" placeholder="密码" size="large">
            </Input>
          </FormItem>
          <Button type="primary" long size="large" @click="loginHandler">登录</Button>
        </Form>
      </div>
    </div>
  </div>
</template>

<script>
import loader from '../utils/loader'
export default {
  name: 'Admin',
  data () {
    return {
      formInline: {
        user: '',
        password: ''
      },
      ruleInline: {
        user: [
          { required: true,
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
            } }
        ],
        password: [
          { required: true, message: '请输入密码.', trigger: 'blur' },
          { type: 'string', min: 6, message: 'The password length cannot be less than 6 bits', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    loginHandler (name) {
      console.log(this.formInline.user)
      console.log(this.formInline.password)
      loader.post('/dataserver/modo/login.php', {
        username: this.formInline.user,
        password: this.formInline.password
      }, this.successHandler)
    },
    successHandler (res) {
      console.log(res.data)
      if (res.data.result === '1') {
        this.$Message.success('登录已成功！')
        this.$router.push('/teachermanage')
      } else {
        this.$Message.error('登录失败！请检查用户名或密码！')
      }
    }
  }
}
</script>

<style scoped>
  .register {

    width:100%;
    height: 750px;

    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    object-fit: cover;
  }
  .register-main {
    width: 400px;
    height: 300px;
    padding: 72px 50px 40px;
    position: absolute;
    background: #fff;
    -webkit-box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);
    box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);

  }
  .dialog {
    width: 100%;
    height: 750px;
    background: #515a6e;
  }
  .banner {
    display: block;
    width:100%;
    height: 750px;
    object-fit: cover;
  }
</style>
