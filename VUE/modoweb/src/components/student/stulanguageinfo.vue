/**
* created by lifeng on 2019-05-27
* create time :2019-05-27 09:05
*/

<template>
    <div class='main'>
      <Card>
        <p slot="title">
          语言
        </p>
      </Card>
      <Table class="table" highlight-row border :columns="thead" :data="tdata"></Table>
      <Divider />
      <Form :label-width="180">
        <FormItem label="语言科目">
          <Input type="text" v-model="formInline.name" placeholder="语言科目"/>
        </FormItem>
        <FormItem label="分数">
          <Input type="text" v-model="formInline.number" placeholder="分数"/>
        </FormItem>
        <FormItem label="日期">
          <DatePicker type="date" v-model="formInline.date" format="yyyy-MM-dd" placeholder="Select date" style="width: 200px"></DatePicker>
        </FormItem>
        <FormItem >
          <Button type="primary" long @click="submitHandler">提交</Button>
        </FormItem>
      </Form>
    </div>
</template>

<script>
import loader from '../../utils/loader'
import date from '../../utils/date'
export default {
  name: 'stulanguageinfo',
  props: [],
  data () {
    return {
      thead: [
        {
          title: '语言',
          key: 'lname'
        },
        {
          title: '分数',
          align: 'center',
          key: 'number'
        },
        {
          title: '日期',
          align: 'center',
          key: 'date'
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    loader.post('/dataserver/modo/student/d_stu_language.php', {
                      id: params.row.id
                    }, (res) => {
                      this.reloadlanguagelist()
                    })
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      tdata: [],
      formInline: {},
      currentid: ''
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    submitHandler () {
      this.currentid = this.$route.params.id
      loader.post('/dataserver/modo/student/i_stu_language.php', {
        id: this.currentid,
        lname: this.formInline.name,
        number: this.formInline.number,
        date: date.formatDate(this.formInline.date)
      }, (res) => {
        this.reloadlanguagelist()
      })
    },
    reloadlanguagelist () {
      this.currentid = this.$route.params.id
      loader.post('/dataserver/modo/student/stu_language.php', {
        id: this.currentid
      }, (res) => {
        if (res.data.result === '1') {
          this.tdata = res.data.data
        }
      })
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    this.reloadlanguagelist()
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

  },
  watch: {
    '$route' (to, from) {
      this.reloadlanguagelist()
    }
  }
}
</script>

<style scoped>

</style>
