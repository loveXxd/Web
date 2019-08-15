/**
* created by lifeng on 2019-05-27
* create time :2019-05-27 09:10
*/

<template>
    <div class='main'>
      <Card>
        <p slot="title">
          申请院校
        </p>
        <Table class="table" highlight-row border :columns="thead" :data="tdata"></Table>
        <Divider />
        <Form :label-width="180">
          <FormItem label="学校">
            <!--Input type="text" v-model="formInline.name" placeholder="学校名称"/-->
            <Select v-model="formInline.name">
              <Option v-for="item in schooldata" :value="item.title" :key="item.title">{{ item.title }}</Option>
            </Select>
          </FormItem>
          <FormItem label="专业">
            <Input type="text" v-model="formInline.major" placeholder="专业名称"/>
          </FormItem>
          <FormItem label="日期">
            <DatePicker type="date" v-model="formInline.date" format="yyyy-MM-dd" placeholder="Select date" style="width: 200px"></DatePicker>
          </FormItem>
          <FormItem >
            <Button type="primary" long @click="submitHandler">提交</Button>
          </FormItem>
        </Form>
      </Card>
    </div>
</template>

<script>
import loader from '../../utils/loader'
import date from '../../utils/date'
export default {
  name: 'stuschoolselectinfo',
  props: [],
  data () {
    return {
      formInline: {},
      thead: [
        {
          title: '申请学校',
          width: 250,
          key: 'sname'
        },
        {
          title: '申请专业',
          width: 100,
          key: 'major'
        },
        {
          title: '状态',
          width: 100,
          key: 'status',
          render: (h, params) => {
            return h('p', this.statusHandler(params.row.status))
          }
        },
        {
          title: '操作',
          key: 'action',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'info',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    // this.show(params.index)
                    loader.post('/dataserver/modo/student/u_stu_apply_school.php', {
                      id: params.row.id,
                      status: 0
                    }, (res) => {
                      this.loadapplyshoollist()
                    })
                    // console.log('b', params)
                  }
                }
              }, '未审核'),
              h('Button', {
                props: {
                  type: 'warning',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    // this.show(params.index)
                    loader.post('/dataserver/modo/student/u_stu_apply_school.php', {
                      id: params.row.id,
                      status: 1
                    }, (res) => {
                      this.loadapplyshoollist()
                    })
                    /// /console.log('b', params)
                  }
                }
              }, '审核中'),
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
                    loader.post('/dataserver/modo/student/u_stu_apply_school.php', {
                      id: params.row.id,
                      status: 3
                    }, (res) => {
                      this.loadapplyshoollist()
                    })
                    // console.log('b', params)
                  }
                }
              }, '未通过'),
              h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    loader.post('/dataserver/modo/student/u_stu_apply_school.php', {
                      id: params.row.id,
                      status: 2
                    }, (res) => {
                      this.loadapplyshoollist()
                    })
                    // console.log('b', params)
                  }
                }
              }, '通过'),
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
                    loader.post('/dataserver/modo/student/d_stu_apply_school.php', {
                      id: params.row.id
                    }, (res) => {
                      this.loadapplyshoollist()
                    })
                    // console.log('b', params)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      tdata: [],
      schooldata: [],
      currentid: ''
    }
  },
  components: {},
  methods: {
    // 该属性中申明方法
    submitHandler () {
      this.currentid = this.$route.params.id
      loader.post('/dataserver/modo/student/i_stu_apply_school.php', {
        id: this.currentid,
        sname: this.formInline.name,
        major: this.formInline.major,
        date: date.formatDate(this.formInline.date)
      }, (res) => {
        // console.log(res)
        if (res.data.result === '1') {
          this.loadapplyshoollist()
        }
      })
    },
    statusHandler (s) {
      let status = '未审核'
      switch (s) {
        case '0':
          status = '未审核'
          break
        case '1':
          status = '审核中'
          break
        case '2':
          status = '通过'
          break
        case '3':
          status = '未通过'
          break
      }
      return status
    },
    loadapplyshoollist () {
      this.currentid = this.$route.params.id
      loader.post('/dataserver/modo/student/stu_apply_school.php', {
        id: this.currentid
      }, (res) => {
        // console.log(res)
        if (res.data.result === '1') {
          this.tdata = res.data.data
        }
      })
    }
  },
  beforeCreate: function () {

  },
  created: function () {
    this.loadapplyshoollist()
    loader.post('/dataserver/modo/article/article.php', {}, (res) => {
      console.log(res)
      this.schooldata = res.data
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

  },
  watch: {
    '$route' (to, from) {
      // console.log(this.$route.params.id)
      this.currentid = this.$route.params.id
      this.loadapplyshoollist()
    }
  }
}
</script>

<style scoped>

</style>
