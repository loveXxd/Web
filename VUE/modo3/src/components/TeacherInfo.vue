<template>
    <div id="TeacherInfo">
      <Affix>
        <div class="bz">
          <Steps :current="0" direction="vertical">
            <Step :status="step1.status" :title="step1.title" content="头像上传"></Step>
            <Step :status="step2.status" :title="step2.title" content="填写姓名等基本信息"></Step>
            <Step :status="step3.status" :title="step3.title" content="代表作品上传"></Step>
          </Steps>
        </div>
      </Affix>
      <div class="content">
        <Card>
          <p slot="title">
            头像
          </p>
          <a href="#" slot="extra" @click.prevent="previewHandler">
            <Icon type="ios-loop-strong"></Icon>
            预览
          </a>
          <div class="sm">
            <p>
                 为了能更加全面的向潜在学生展示您的教学教研水平与学术能力，请您耐心并准确的填下下列信息，您所填写的资料详细程度和图片质量，将会对您在魔豆的教学机会产生影响。我们将根据合作协议中法律允许的范围内，在魔豆的官网，公众号，小程序等平台进行必要的展示。
            </p>
          </div>
          <div class="avatar">
            <!--div class="introduce">
              <img class="lecturer-avatar" src="../assets/image/avatar.jpg">
            </div-->
            <div class="upload">
              <Upload
                class="upload_avatar"
                ref="upload_avatar"
                multiple
                :on-success="successHandler"
                type="drag"
                :format="['jpg','jpeg','png']"
                :max-size="2048"
                action="/dataserver/modo/upFile.php">
                <div style="padding: 0">
                  <img class="lecturer-avatar" :src="avatar">
                  <p class="avatar_p">Click here to upload</p>
                </div>
              </Upload>

            </div>
            <div class="avatar-sm">
              <p>( 头像是导师留给学生的第一印象，请选择清晰的、正面的肖像照片作为您的头像 ）</p>
            </div>
          </div>

        </Card>
        <br/>
        <Card>
          <p slot="title">
            基本信息
          </p>
          <Form :label-width="140" :rules="ruleInline" :model="formValidate" ref="formValidate" >
            <FormItem label="真实姓名:" prop="username">
              <Input placeholder="中英文名字皆可" v-model="formValidate.username"></Input>
            </FormItem>
            <FormItem label="学科:" prop="xk">
              <p>(多选)</p>
              <CheckboxGroup v-model="formValidate.xk">
                <Checkbox label="建筑"></Checkbox>
                <Checkbox label="城市"></Checkbox>
                <Checkbox label="景观"></Checkbox>
                <Checkbox label="室内"></Checkbox>
                <Checkbox label="其他"></Checkbox>
              </CheckboxGroup>
            </FormItem>
            <FormItem label="教学服务范围:" prop="coursescope">
              <p>(多选)</p>
              <CheckboxGroup v-model="formValidate.coursescope">
                <Tooltip max-width="150" placement="top" content="与一位学生进行一对一辅导">
                  <Checkbox label="1V1"></Checkbox>
                </Tooltip>
                <Tooltip max-width="150"  placement="top" content="对多位学生在一定周期内同时教学，需要准备STUDIO课程">
                  <Checkbox label="STUDIO"></Checkbox>
                </Tooltip>
                <Tooltip max-width="150"  placement="top" content="对学生已完成的作品集部分进行综合性指导与点评">
                  <Checkbox label="REVIEW"></Checkbox>
                </Tooltip>
                <Tooltip max-width="150"  placement="top" content="目前仅限全职导师">
                  <Checkbox label="COACH"></Checkbox>
                </Tooltip>
                <Tooltip max-width="150"  placement="top" content="辅导学生申请学校的相关文书">
                  <Checkbox label="文书"></Checkbox>
                </Tooltip>
                <Tooltip max-width="150"  placement="top" content="对学生进行软件与技法方面的指导">
                  <Checkbox label="软件"></Checkbox>
                </Tooltip>
              </CheckboxGroup>
            </FormItem>
            <FormItem label="教学服务媒介:" prop="mj">
              <p>(多选)</p>
              <CheckboxGroup v-model="formValidate.mj">
                <Checkbox label="线上"></Checkbox>
                <Checkbox label="线下（北京798魔豆）"></Checkbox>
              </CheckboxGroup>
            </FormItem>
            <!--FormItem label="地区:" prop="area">
              <p>(多选)</p>
              <CheckboxGroup v-model="formValidate.area">
                <Checkbox label="北美" ></Checkbox>
                <Checkbox label="英国"></Checkbox>
                <Checkbox label="欧洲"></Checkbox>
                <Checkbox label="香港\新加坡"></Checkbox>
                <Checkbox label="澳洲"></Checkbox>
                <Checkbox label="日本"></Checkbox>
                <Checkbox label="其他" v-model="other_select"></Checkbox>
                <Input v-model="other_area" v-if="other_select" size="small" placeholder="国家名称" style="width: 80px" />
              </CheckboxGroup>
            </FormItem-->
            <Divider dashed />
            <!--FormItem label="教育背景:">
              <Input v-model="formValidate.edubg" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input>
            </FormItem-->
            <FormItem label="教育背景:">
              <Tabs size="small" :animated="false">
                <TabPane label="北美"><Input v-model="edubg_na" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：北美：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input></TabPane>
                <TabPane label="英国"><Input v-model="edubg_uk" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：英国：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input></TabPane>
                <TabPane label="欧洲"><Input v-model="edubg_eur" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：欧洲：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input></TabPane>
                <TabPane label="香港\新加坡"><Input v-model="edubg_hk" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：香港：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input></TabPane>
                <TabPane label="澳洲"><Input v-model="edubg_au" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：澳洲：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input></TabPane>
                <TabPane label="日本"><Input v-model="edubg_jp" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：日本：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input></TabPane>
                <TabPane label="其他"><Input v-model="edubg_other" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：其他：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input></TabPane>
              </Tabs>
            </FormItem>
            <FormItem label="工作与实习经历:">
              <Input v-model="formValidate.resume" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：2016.04, 婆罗洲艺术实验室 Borneo Laboratory 创始人"></Input>
            </FormItem>
            <FormItem label="荣誉:">
              <Input v-model="formValidate.honor" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：2018, Project ‘Lily Table’ being selected as one of the finalist of ‘2018 Asian Design Award’"></Input>
            </FormItem>
            <FormItem label="学术方向与擅长领域:" prop="learning">
              <Input v-model="formValidate.learning" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="学术方向与擅长领域"></Input>
            </FormItem>
            <FormItem label="教学期望:" prop="expect">
              <Input v-model="formValidate.expect" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="一句话自我介绍或谈谈您对这份教育事业的理解和态度与学生共享"></Input>
            </FormItem>
            <FormItem label="教学经历:">
              <Input v-model="formValidate.jxjy" type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="例如：2014.01-2015.01, Cambridge University, Professional Studies of Architectural Practice"></Input>
            </FormItem>
            <FormItem label="学生成绩:">
              <tabs size="small" :animated="false">
                <TabPane label="北美"><Input v-model="text_area_na" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="教学经历"></Input></TabPane>
                <TabPane label="英国"><Input v-model="text_area_uk" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="教学经历"></Input></TabPane>
                <TabPane label="欧洲"><Input v-model="text_area_eur" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="教学经历"></Input></TabPane>
                <TabPane label="香港\新加坡"><Input v-model="text_area_hk" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="教学经历"></Input></TabPane>
                <TabPane label="澳洲"><Input v-model="text_area_au" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="教学经历"></Input></TabPane>
                <TabPane label="日本"><Input v-model="text_area_jp" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="教学经历"></Input></TabPane>
                <TabPane label="其他"><Input v-model="text_area_other" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="教学经历"></Input></TabPane>
              </tabs>
            </FormItem>
            <FormItem>
              <Button type="primary" long @click="submitHandler('formValidate')">提交</Button>
            </FormItem>
          </Form>
        </Card>
        <br/>
        <Card>
          <p slot="title">
            学位证书
          </p>
          <div>
            <div class="demo-upload-list" v-for="(item,i) in uploadListxwzs" :key="i">
              <template>
                <img :src="item.url">
                <div class="demo-upload-list-cover">
                  <Icon type="ios-eye-outline" @click.native="handleView(item.url)"></Icon>
                  <Icon type="ios-trash-outline" @click.native="handleRemovexwzs(item)"></Icon>
                </div>
              </template>
            </div>
            <Upload
              ref="xwzs"
              :show-upload-list="false"
              :default-file-list="defaultList"
              :on-success="handleSuccess"
              :format="['jpg','jpeg','png']"
              :max-size="2048"
              :on-format-error="handleFormatError"
              :on-exceeded-size="handleMaxSize"
              :before-upload="handleBeforeUploadxwzs"
              :data="parmxwzs"
              multiple

              type="drag"
              action="/dataserver/modo/upFile.php"
              style="display: inline-block;width:58px;">
              <div style="width: 58px;height:58px;line-height: 58px;">
                <Icon type="ios-camera" size="20"></Icon>
              </div>
            </Upload>
            <p class="ts"></p>
            <Modal title="学位展示" v-model="visible">
              <img :src="imgurl" v-if="visible" style="width: 100%">
            </Modal>
          </div>
        </Card>
        <br/>
        <Card>
          <p slot="title">
            代表作品
          </p>
          <div>
            <div class="demo-upload-list" v-for="(item,i) in uploadList" :key="i">
              <template>
                <img :src="item.url">
                <div class="demo-upload-list-cover">
                  <Icon type="ios-eye-outline" @click.native="handleView(item.url)"></Icon>
                  <Icon type="ios-trash-outline" @click.native="handleRemove(item)"></Icon>
                </div>
              </template>
            </div>
            <Upload
              ref="upload"
              :show-upload-list="false"
              :default-file-list="defaultList"
              :on-success="handleSuccessworks"
              :format="['jpg','jpeg','png']"
              :max-size="2048"
              :on-format-error="handleFormatError"
              :on-exceeded-size="handleMaxSize"
              :before-upload="handleBeforeUpload"
              :data="parm"
              multiple
              type="drag"
              action="/dataserver/modo/upFile.php"
              style="display: inline-block;width:58px;">
              <div style="width: 58px;height:58px;line-height: 58px;">
                <Icon type="ios-camera" size="20"></Icon>
              </div>
            </Upload>
            <p class="ts">（建议10页左右，至少8页，作品集是学生选择导师的重要参考点，请上传您上传最具个人特色的作品）</p>
            <Modal title="作品展示" v-model="visible">
              <img :src="imgurl" v-if="visible" style="width: 100%">
            </Modal>
          </div>
        </Card>
        <br/>
        <Card>
          <p slot="title">
            教学成果
          </p>
          <div>
            <div class="demo-upload-list" v-for="(item,i) in uploadListjxcg" :key="i">
              <template>
                <img :src="item.url">
                <div class="demo-upload-list-cover">
                  <Icon type="ios-eye-outline" @click.native="handleView(item.url)"></Icon>
                  <Icon type="ios-trash-outline" @click.native="handleRemovejxcg(item)"></Icon>
                </div>
              </template>
            </div>
            <Upload
              ref="jxcg"
              :show-upload-list="false"
              :default-file-list="defaultList"
              :on-success="handleSuccess"
              :format="['jpg','jpeg','png']"
              :max-size="2048"
              :on-format-error="handleFormatError"
              :on-exceeded-size="handleMaxSize"
              :before-upload="handleBeforeUploadjxcg"
              :data="{'type': 'jxcg'}"
              multiple

              type="drag"
              action="/dataserver/modo/upFile.php"
              style="display: inline-block;width:58px;">
              <div style="width: 58px;height:58px;line-height: 58px;">
                <Icon type="ios-camera" size="20"></Icon>
              </div>
            </Upload>
            <p class="ts"></p>
            <Modal title="作品展示" v-model="visible">
              <img :src="imgurl" v-if="visible" style="width: 100%">
            </Modal>
          </div>
        </Card>
      </div>

    </div>
</template>

<script>
import loader from '../utils/loader'
import crypto from '../utils/copyto'
export default {
  name: 'TeacherInfo',
  data () {
    return {
      step1: {
        status: 'error',
        title: '未完成'

      },
      step2: {
        status: 'error',
        title: '未完成'
      },
      step3: {
        status: 'error',
        title: '未完成'
      },
      formValidate: {
        username: '',
        edubg: '',
        resume: '',
        honor: '',
        learning: '',
        expect: '',
        jxjy: '',
        xk: [],
        coursescope: [],
        mj: [],
        area: []
      },
      ruleInline: {
        username: [
          {type: 'string', required: true, message: '姓名不能为空', trigger: 'blur'}
        ],
        edubg: [
          {type: 'string', required: true, message: '教育背景不能为空', trigger: 'blur'}
        ],
        resume: [
          {type: 'string', required: true, message: '工作与实习经历不能为空', trigger: 'blur'}
        ],
        honor: [
          {type: 'string', required: true, message: '荣誉不能为空', trigger: 'blur'}
        ],
        learning: [
          {type: 'string', required: true, message: '学术方向与擅长领域不能为空', trigger: 'blur'}
        ],
        expect: [
          {type: 'string', required: true, message: '教学期望不能为空', trigger: 'blur'}
        ],
        jxjy: [
          {type: 'string', required: true, message: '教学经验不能为空', trigger: 'blur'}
        ],
        xk: [
          { required: true, type: 'array', min: 1, message: '请至少选择一门学科', trigger: 'change' }
        ],
        coursescope: [
          { required: true, type: 'array', min: 1, message: '请至少选择一项教学服务范围', trigger: 'change' }
        ],
        mj: [
          { required: true, type: 'array', min: 1, message: '请至少选择一项教学服务媒介', trigger: 'change' }
        ],
        area: [
          { required: true, type: 'array', min: 1, message: '请至少选择一个地区', trigger: 'change' }
        ]
      },
      // username: '',

      other_select: false,
      other_area: '',
      // edubg: '',
      // resume: '',
      // honor: '',
      // learning: '',
      // expect: '',
      text_area_na: '',
      text_area_uk: '',
      text_area_hk: '',
      text_area_eur: '',
      text_area_au: '',
      text_area_jp: '',
      text_area_other: '',
      edubg_na: '',
      edubg_uk: '',
      edubg_hk: '',
      edubg_eur: '',
      edubg_au: '',
      edubg_jp: '',
      edubg_other: '',
      parm: {'type': 'work'},
      parmxwzs: {'type': 'xwzs'},
      avatar: '/modo/upload/default_avatar.jpg',
      defaultList: [
      ],
      imgurl: '',
      visible: false,
      uploadList: [],
      uploadListxwzs: [],
      uploadListjxcg: []
    }
  },
  methods: {
    previewHandler () {
      this.$router.push('/infopreview')
    },
    successHandler (res, file) {
      console.log(res)
      if (res.result === '1') {
        this.avatar = res.url
        this.$refs.upload_avatar.clearFiles()
        this.step1.title = '已完成'
        this.step1.status = 'finish'
      }
      if (res.result === '0') {
        this.$Message.error('用户尚未登录！')
        this.$router.push('/register')
      }
    },
    addChange (name) {
      this.$refs[name].validate(valid => {
        if (valid) {
        }
      })
    },
    submitHandler (name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          let temparea = this.formValidate.area
          if (this.other_select && this.other_area !== '') {
            temparea = temparea + ':' + this.other_area
          }
          this.step2.title = '已完成'
          this.step2.status = 'finish'
          loader.post('/dataserver/modo/userInfo.php', {
            name: crypto.base64Encoed(this.formValidate.username),
            course: this.formValidate.xk.join(','),
            coursescope: this.formValidate.coursescope.join(','),
            coursevehicle: this.formValidate.mj.join(','),
            area: temparea,
            edubackground: crypto.base64Encoed(this.formValidate.edubg),
            resume: crypto.base64Encoed(this.formValidate.resume),
            honor: crypto.base64Encoed(this.formValidate.honor),
            learning: crypto.base64Encoed(this.formValidate.learning),
            expect: crypto.base64Encoed(this.formValidate.expect),
            jxjy: crypto.base64Encoed(this.formValidate.jxjy),
            au: this.text_area_au,
            uk: this.text_area_uk,
            na: this.text_area_na,
            hk: this.text_area_hk,
            eur: this.text_area_eur,
            jp: this.text_area_jp,
            other: this.text_area_other,
            l_na: this.edubg_na,
            l_uk: this.edubg_uk,
            l_hk: this.edubg_hk,
            l_eur: this.edubg_eur,
            l_au: this.edubg_au,
            l_jp: this.edubg_jp,
            l_other: this.edubg_other
          }, (t) => {
            console.log(t.data.result)
            if (t.data.result === '1') {
              this.$Message.success('信息提交成功！')
            } else {

            }
          })
        } else {
          this.$Message.error('请将数据填写完整!')
        }
      })
      /* loader.post('/dataserver/modo/userInfo.php', {
        name: crypto.base64Encoed(this.username),
        course: this.xk,
        coursescope: this.coursescope,
        coursevehicle: this.mj,
        area: this.area,
        edubackground: crypto.base64Encoed(this.edubg),
        resume: crypto.base64Encoed(this.resume),
        honor: crypto.base64Encoed(this.honor),
        learning: crypto.base64Encoed(this.learning),
        expect: crypto.base64Encoed(this.expect),
        au: this.text_area_au,
        uk: this.text_area_uk,
        na: this.text_area_na,
        hk: this.text_area_hk,
        eur: this.text_area_eur,
        jp: this.text_area_jp,
        other: this.text_area_other,
        l_na: this.edubg_na,
        l_uk: this.edubg_uk,
        l_hk: this.edubg_hk,
        l_eur: this.edubg_eur,
        l_au: this.edubg_au,
        l_jp: this.edubg_jp,
        l_other: this.edubg_other
      }, (t) => {
        console.log(t.data.result)
        if (t.data.result === '1') {
          this.$Message.success('信息提交成功！')
        } else {

        }
      }) */
    },
    userinfoHandler (res) {
      res = res.data
      if (res) {
        if (res.avatar && res.avatar !== '') {
          this.avatar = res.avatar
          this.step1.title = '已完成'
          this.step1.status = 'finish'
        } else {
          this.avatar = '/assets/image/avatar.jpg'
        }
        if (res.name && res.name !== '') {
          this.step2.title = '已完成'
          this.step2.status = 'finish'
        } else {
        }
        this.formValidate.username = res.name
        this.formValidate.xk = this.string2arr(res.course)
        this.formValidate.coursescope = this.string2arr(res.coursescope)
        this.formValidate.mj = this.string2arr(res.coursevehicle)
        let a = res.area.split(':')
        this.other_area = a[1]
        if (this.other_area && this.other_area !== '') {
          this.formValidate.area = this.string2arr(a[0])
          this.other_select = true
        } else {
          let temparr = this.string2arr(a[0])
          let index = temparr.indexOf('其他')
          if (index !== -1) {
            temparr.splice(index, 1)
          }
          this.formValidate.area = temparr
        }

        this.formValidate.edubg = res.edubackground
        this.formValidate.resume = res.resume
        this.formValidate.honor = res.honor
        this.formValidate.learning = res.learning
        this.formValidate.expect = res.expect
        this.formValidate.jxjy = res.jxjy

        this.text_area_other = res.other
        this.text_area_jp = res.jp
        this.text_area_eur = res.eur
        this.text_area_hk = res.hk
        this.text_area_na = res.na
        this.text_area_uk = res.uk
        this.text_area_au = res.au
        this.edubg_na = res.l_na
        this.edubg_uk = res.l_uk
        this.edubg_hk = res.l_hk
        this.edubg_eur = res.l_eur
        this.edubg_au = res.l_au
        this.edubg_jp = res.l_jp
        this.edubg_other = res.l_other
        var worksarr
        var xwzsarr
        var jxcg
        if (res.works && res.works !== '') {
          worksarr = this.string2arr(res.works)
        } else {
          worksarr = []
        }
        if (res.xwzs && res.xwzs !== '') {
          xwzsarr = this.string2arr(res.xwzs)
        } else {
          xwzsarr = []
        }
        if (res.jxcg && res.jxcg !== '') {
          jxcg = this.string2arr(res.jxcg)
        } else {
          jxcg = []
        }
        if (worksarr.length > 0) {
          this.step3.title = '已完成'
          this.step3.status = 'finish'
        } else {
        }
        for (var i = 0; i < worksarr.length; i++) {
          var obj1 = {'url': worksarr[i], 'name': i}
          this.$refs.upload.fileList.push(obj1)
        }
        for (var ii = 0; ii < xwzsarr.length; ii++) {
          var obj2 = {'url': xwzsarr[ii], 'name': ii}
          console.log('AA' + obj2)
          this.$refs.xwzs.fileList.push(obj2)
        }
        for (var iii = 0; iii < jxcg.length; iii++) {
          var obj3 = {'url': jxcg[iii], 'name': iii}
          this.$refs.jxcg.fileList.push(obj3)
        }
      }
      // this.uploadList = this.$refs.upload.fileList
    },
    string2arr (str) {
      let arr = []
      if (str.indexOf(',') !== -1) {
        arr = str.split(',')
      } else if (str !== '') {
        arr = [str]
      }
      return arr
    },
    /// ////////////////////////////////////
    uploadHandloer (e) {
      this.parm.bbb = '123'
    },
    handleView (name) {
      this.imgurl = name
      this.visible = true
    },
    handleRemove (file) {
      console.log(file.url)
      const fileList = this.$refs.upload.fileList
      this.$refs.upload.fileList.splice(fileList.indexOf(file), 1)
      if (fileList.length > 0) {
        this.step3.title = '已完成'
        this.step3.status = 'finish'
      } else {
        this.step3.title = '未完成'
        this.step3.status = 'error'
      }
      loader.post('/dataserver/modo/upDateWorks.php', {
        'url': file.url,
        type: 'works'
      }, this.userinfoHandler)
    },
    handleRemovexwzs (file) {
      console.log(file.url)
      const fileList = this.$refs.xwzs.fileList
      this.$refs.xwzs.fileList.splice(fileList.indexOf(file), 1)
      loader.post('/dataserver/modo/upDateWorks.php', {
        'url': file.url,
        type: 'xwzs'
      }, this.userinfoHandler)
    },
    handleRemovejxcg (file) {
      console.log(file.url)
      const fileList = this.$refs.jxcg.fileList
      this.$refs.jxcg.fileList.splice(fileList.indexOf(file), 1)
      loader.post('/dataserver/modo/upDateWorks.php', {
        'url': file.url,
        type: 'jxcg'
      }, this.userinfoHandler)
    },
    handleSuccess (res, file) {
      console.log('aa' + res)
      file.url = res.url
    },
    handleSuccessworks (res, file) {
      this.step3.title = '已完成'
      this.step3.status = 'finish'
      file.url = res.url
    },
    handleFormatError (file) {
      this.$Notice.warning({
        title: 'The file format is incorrect',
        desc: 'File format of ' + file.name + ' is incorrect, please select jpg or png.'
      })
    },
    handleMaxSize (file) {
      this.$Notice.warning({
        title: 'Exceeding file size limit',
        desc: 'File  ' + file.name + ' is too large, no more than 2M.'
      })
    },
    handleBeforeUpload () {
      const check = this.uploadList.length < 9
      let len = this.defaultList.length
      let arr = []
      for (let i = 0; i < len; i++) {
        arr.push(this.defaultList[i].url)
      }
      // JSON.stringify(
      // this.parm.works = arr
      if (!check) {
        this.$Notice.warning({
          title: '最大只能上传9张图片.'
        })
      }
      return check
    },
    handleBeforeUploadjxcg () {
      const check = this.uploadListjxcg.length < 9
      /* let len = this.defaultList.length
      let arr = []
      for (let i = 0; i < len; i++) {
        arr.push(this.defaultList[i].url)
      }
      // JSON.stringify(
      this.parm.works = arr */
      if (!check) {
        this.$Notice.warning({
          title: '最大只能上传9张图片.'
        })
      }
      return check
    },
    handleBeforeUploadxwzs () {
      const check = this.uploadListxwzs.length < 9
      let len = this.defaultList.length
      let arr = []
      for (let i = 0; i < len; i++) {
        arr.push(this.defaultList[i].url)
      }
      // JSON.stringify(
      this.parmxwzs.works = arr
      if (!check) {
        this.$Notice.warning({
          title: '最大只能上传9张图片.'
        })
      }
      return check
    }
  },
  created () {
    console.log('created')
    loader.post('/dataserver/modo/getUserInfo.php', {}, this.userinfoHandler)
  },
  mounted () {
    console.log('mounted')
    this.uploadList = this.$refs.upload.fileList
    this.uploadListxwzs = this.$refs.xwzs.fileList
    console.log(this.uploadListxwzs)
    this.uploadListjxcg = this.$refs.jxcg.fileList
  },
  beforeUpdate () {
    // console.log('beforeUpdate')
    /// loader.post('/api/dataserver/modo/getUserInfo.php', {}, this.userinfoHandler)
  }

}
</script>

<style scoped>
  .bz{
    position: fixed;
    z-index: 2;
    left: 20px;
    top: 120px;
  }
  #TeacherInfo{
  text-align: left;
  }
  .avatar-sm{
    margin-top: 20px;
    margin-left: 10px;
    width: 300px;
    //text-align: left;
    color: #019642;
  }
  .sm{
    display: inline-block;
    width: 50%;
    float: right;
    margin: 30px;
    font-size: 16px;
    line-height: 24px;
    color: #019642;
  }
.content{
  width: 720px;
  margin: auto;
  margin-top:20px;
}
.avatar{
text-align: center;
}
Upload{
  margin: auto;
}
  .avatar_p{
    margin-bottom: 10px;
  }
  .lecturer-avatar{
    width: 100%;
    height: 100%;
  }
  .upload{
    width: 200px;
    height: 200px;
    display: inline-block;
    text-align: center;
    -webkit-box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);
    box-shadow: 0 10px 30px 0 rgba(0,0,0,.05)
  }
  p{
    display: inline-block;
    margin: 0px;
  }
  span{
    display: inline-block;
    color: #999999;
    margin: 20px;
  }
  .demo-carousel{
    height: 200px;
    background: #999999;
  }

  .demo-upload-list{
    display: inline-block;
    width: 60px;
    height: 60px;
    text-align: center;
    line-height: 60px;
    border: 1px solid transparent;
    border-radius: 4px;
    overflow: hidden;
    background: #fff;
    position: relative;
    box-shadow: 0 1px 1px rgba(0,0,0,.2);
    margin-right: 4px;
  }
  .demo-upload-list img{
    width: 100%;
    height: 100%;
  }
  .demo-upload-list-cover{
    display: none;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background: rgba(0,0,0,.6);
  }
  .demo-upload-list:hover .demo-upload-list-cover{
    display: block;
  }
  .demo-upload-list-cover i{
    color: #fff;
    font-size: 20px;
    cursor: pointer;
    margin: 0 2px;
  }
  .ts{
    color:#019642;
    font-size: 12px;
  }
</style>
