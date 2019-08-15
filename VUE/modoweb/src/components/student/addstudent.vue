/**
* created by lifeng on 2019-05-21
* create time :2019-05-21 14:39
*/

<template>
  <div class='main'>
    <Form ref="formInline" :model="formInline" :rules="ruleInline" inline :label-width="120">
      <FormItem label="姓名" prop="user">
        <Input type="text" v-model="formInline.name" placeholder="Username">
        </Input>
      </FormItem>
      <FormItem label="联系电话">
        <Input type="tel" v-model="formInline.tel" placeholder="Password">
        </Input>
      </FormItem>
      <FormItem label="本科院校">
        <Input type="text" v-model="formInline.course" placeholder="">
        </Input>
      </FormItem>
      <FormItem label="本科专业">
        <Input type="text" v-model="formInline.major" placeholder="">
        </Input>
      </FormItem>
      <!--FormItem label="是否转专业">
        <Select style="width: 172px">
          <Option>YES</Option>
          <Option>NO</Option>
        </Select>
      </FormItem>

      <FormItem label="上课媒介">
        <Select style="width: 172px">
          <Option>线上</Option>
          <Option>线下</Option>
        </Select>
      </FormItem>
      <FormItem label="申请国家">
        <Input type="password" v-model="formInline.password" placeholder="">
        </Input>
      </FormItem>
      <FormItem label="申请学校">
        <Input type="password" v-model="formInline.password" placeholder="">
        </Input>
      </FormItem>
      <FormItem label="申请专业">
        <Input type="password" v-model="formInline.password" placeholder="">
        </Input>
      </FormItem>
      <FormItem label="开课时间">
        <DatePicker type="date" placeholder="Select date" style="width: 172px"></DatePicker>
      </FormItem>
      <FormItem label="结课时间">
        <DatePicker type="date" placeholder="Select date" style="width: 172px"></DatePicker>
      </FormItem-->
      <FormItem>
        <Button type="primary" @click="handleSubmit('formInline')">提交</Button>
      </FormItem>
    </Form>
  </div>
</template>

<script>
import loader from '../../utils/loader'
import message from '../../utils/message'
export default {
  name: 'addstudent',
  props: [],
  data () {
    return {
      formInline: {
        name: '',
        tel: '',
        course: '',
        major: ''
      },
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
    handleSubmit () {
      loader.loadingshow(this)
      loader.post('/dataserver/modo/student/i_student.php', {
        name: this.formInline.name,
        tel: this.formInline.tel,
        course: this.formInline.course,
        major: this.formInline.major
      }, (res) => {
        loader.loadinghide(this)
        console.log(res)
        if (res.data.result === '1') {
          this.$emit('addover')
          message.success(this, '用户建档成功！')
        }
      })
    },
    clearinfo () {
      this.formInline.name = ''
      this.formInline.tel = ''
      this.formInline.course = ''
      this.formInline.major = ''
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
