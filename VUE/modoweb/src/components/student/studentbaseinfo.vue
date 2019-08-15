/**
* created by lifeng on 2019-05-23
* create time :2019-05-23 13:43
*/

<template>
    <div class='main'>
      <Modal
        width="800px"
        :mask-closable="false"
        :scrollable="true"
        v-model="isview"
        title="学生基本信息">
        <addstudent v-if="action==='new'" @addover="addoverhandler"></addstudent>
        <updatestudent v-if="action==='modify'"  :userinfo="userinfo" @updateover="addoverhandler"></updatestudent>

        <div style="text-align: center"  v-if="action==='qr'">
          <h1>{{currentuser.name}}</h1>
          <Divider />
          <div id="qrcode"></div>
          <a id="downloadLink"></a>
          <Divider />
          <Button left type="primary" @click="downloadQR">下载</Button>
        </div>

        <div slot="footer">
        </div>
      </Modal>
      <card>
        <p slot="title">学生管理</p>
        <Button left type="primary" @click="addArticle">新建档案</Button>

      </card>
      <card>
        <Table class="table" height="600" highlight-row border :columns="thead" :data="tdata"></Table>
      </card>
    </div>
</template>

<script>
import loader from '../../utils/loader'
import Addstudent from './addstudent'
import QRCode from 'qrcodejs2'
import Updatestudent from './updatestudent'
export default {
  name: 'studentbaseinfo',
  props: [],
  data () {
    return {
      isview: false,
      action: 'new',
      currentuser: {},
      userinfo: {

      },
      thead: [
        {
          title: '姓名',
          width: 100,
          key: 'name'
        },
        {
          title: '电话',
          width: 120,
          key: 'tel'
        },
        {
          title: '本科院校',
          width: 160,
          key: 'course'
        },
        {
          title: '本科专业',
          width: 160,
          align: 'center',
          key: 'major'
        },
        {
          title: '建档日期',
          width: 120,
          key: 'createdate',
          sortable: true

        },
        {
          title: '操作',
          key: 'action',
          width: 280,
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
                    this.action = 'modify'
                    this.userinfo = params.row
                    this.isview = true
                  }
                }
              }, '修改'),
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
                    console.log(params.row.id)
                    loader.post('/dataserver/modo/student/unbind.php', {
                      id: params.row.id
                    }, (res) => {

                    })
                  }
                }
              }, '解绑'),
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
                    this.isview = true
                    this.action = 'qr'
                    this.currentuser = this.tdata[params.index]
                    // this.qt(params.index)
                    let that = this
                    setTimeout(function () {
                      document.getElementById('qrcode').innerHTML = ''
                      that.qt(params.index)
                    }, 10)
                  }
                }
              }, '生成二维码')
            ])
          }
        }
      ],
      tdata: []
    }
  },
  components: {Updatestudent, Addstudent},
  methods: {
    // 该属性中申明方法
    addArticle () {
      this.action = 'new'
      this.isview = !this.isview
    },
    downloadQR () {
      var img = document.getElementById('qrcode').getElementsByTagName('img')[0]
      // 构建画布
      var canvas = document.createElement('canvas')
      canvas.width = img.width
      canvas.height = img.height
      canvas.getContext('2d').drawImage(img, 0, 0)
      // 构造url
      let url = canvas.toDataURL('image/png')
      // 构造a标签并模拟点击
      var downloadLink = document.getElementById('downloadLink')
      downloadLink.setAttribute('href', url)
      downloadLink.setAttribute('download', this.currentuser.name + '.png')
      downloadLink.click()
    },
    qt (index) {
      this.usercode = this.tdata[index].code
      let qr = new QRCode('qrcode', {
        width: 256,
        height: 256,
        text: this.usercode, // 二维码地址
        colorDark: '#019642',
        colorLight: '#fff',
        correctLevel: QRCode.CorrectLevel.H
      })
      qr.toString()
    },
    addoverhandler () {
      this.loadstudentlist()
    },
    loadstudentlist () {
      loader.post('/dataserver/modo/student/studentlist.php', {

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
    /* loader.post('/dataserver/modo/student/studentlist.php', {

    }, (res) => {
      //console.log(res)
      if (res.data.result === '1') {
        this.tdata = res.data.data
      }
    }) */
    this.loadstudentlist()
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
#qrcode{
  display: inline-block;
}
</style>
