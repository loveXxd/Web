/**
* created by lifeng on 2019-05-22
* create time :2019-05-22 10:41
*/

<template>
    <div class='main'>
      <Form ref="formDynamic" :model="formDynamic" :rules="ruleInline" inline :label-width="120">
        <FormItem label="项目名称" prop="user">
          <Input type="text" v-model="formInline.name" placeholder="项目名称">
          </Input>
        </FormItem>
        <Divider />
        <FormItem label="起始时间">
          <DatePicker type="date" v-model="formInline.start" placeholder="选择日期"></DatePicker>
        </FormItem>
        <FormItem label="结束时间">
          <DatePicker type="date" v-model="formInline.end" placeholder="选择日期"></DatePicker>
        </FormItem>
        <Divider />
        <FormItem
          v-for="(item, index) in formDynamic.items"
          v-if="item.status"
          :key="index"
          :label="'任务 ' + item.index"
          :prop="'items.' + index + '.value'"
          :rules="{required: true, message: 'Item ' + item.index +' can not be empty', trigger: 'blur'}">
          <Row>
            <Col span="18">
              <Input type="text" v-model="item.value" placeholder="添加任务"></Input>
            </Col>
            <Col span="4" offset="1">
              <Button @click="handleRemove(index)">删除</Button>
            </Col>
          </Row>
        </FormItem>

        <FormItem>
          <Button type="dashed" long @click="handleAdd" icon="md-add">添加任务</Button>
        </FormItem>
        <Divider />
        <FormItem>
          <Button type="primary" @click="handleSubmit('formInline')">提交</Button>
        </FormItem>
      </Form>
    </div>
</template>

<script>
import loader from '../../utils/loader'
import date from '../../utils/date'
export default {
  name: 'addproject',
  props: [],
  data () {
    return {
      index: 1,
      formDynamic: {
        items: [
          {
            value: '',
            index: 1,
            status: 1
          }
        ]
      },
      formInline: {
        name: 'hello',
        start: date.getNowFormatDate(),
        end: date.getNowFormatDate()
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
    handleAdd () {
      this.index++
      this.formDynamic.items.push({
        value: '',
        index: this.index,
        status: 1
      })
    },
    handleRemove (index) {
      this.formDynamic.items.splice(index, 1)
    },
    handleSubmit () {
      let arr = ['aaa']
      for (let i = 0; i < this.formDynamic.items.length; i++) {
        arr.push(this.formDynamic.items[i].value)
      }
      console.log(arr)
      loader.post('/dataserver/modo/project/i_project.php', {
        name: this.formInline.name,
        start: this.formInline.start,
        end: this.formInline.end,
        task: arr

      }, (res) => {
        console.log(res)
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
