<template>
  <div id="TeacherDetails">
    <div class="content">
      <Card>
        <p slot="title">
          头像
        </p>
        <div class="avatar">
          <div class="upload">
            <div style="padding: 0">
              <img class="lecturer-avatar" :src="avatar">
            </div>
          </div>
        </div>

      </Card>
      <br/>
      <Card>
        <p slot="title">
          基本信息
        </p>
        <Form :label-width="100">
          <FormItem label="姓名:">
            <Input placeholder="输入姓名"></Input>
          </FormItem>
          <FormItem label="学科:" disabled>
            <CheckboxGroup>
              <Checkbox disabled label="建筑" ></Checkbox>
              <Checkbox label="城市"></Checkbox>
              <Checkbox label="景观"></Checkbox>
              <Checkbox label="室内"></Checkbox>
            </CheckboxGroup>
          </FormItem>
          <FormItem label="教学服务范围:">
            <CheckboxGroup>
              <Checkbox label="1V1"></Checkbox>
              <Checkbox label="STUDIO"></Checkbox>
              <Checkbox label="REVIEW"></Checkbox>
              <Checkbox label="COACH"></Checkbox>
              <Checkbox label="文书"></Checkbox>
            </CheckboxGroup>
          </FormItem>
          <FormItem label="教学服务媒介:">
            <CheckboxGroup>
              <Checkbox label="线上"></Checkbox>
              <Checkbox label="线下（北京798魔豆）"></Checkbox>
            </CheckboxGroup>
          </FormItem>
          <FormItem label="地区:">
            <CheckboxGroup>
              <Checkbox label="北美"></Checkbox>
              <Checkbox label="英国"></Checkbox>
              <Checkbox label="欧洲"></Checkbox>
              <Checkbox label="香港\新加坡"></Checkbox>
              <Checkbox label="澳洲"></Checkbox>
              <Checkbox label="日本"></Checkbox>
              <Checkbox label="其他"></Checkbox>
            </CheckboxGroup>
          </FormItem>
          <Divider dashed />
          <FormItem label="教育背景:">
            <Input type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="Enter something..."></Input>
          </FormItem>
          <FormItem label="工作与实习经历:">
            <Input type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="Enter something..."></Input>
          </FormItem>
          <FormItem label="荣誉:">
            <Input type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="Enter something..."></Input>
          </FormItem>
          <FormItem label="学术方向:">
            <Input type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="Enter something..."></Input>
          </FormItem>
          <FormItem label="教学期望:">
            <Input type="textarea" :autosize="{minRows: 3,maxRows: 5}" placeholder="一句话自我介绍或谈谈您对这份教育事业的理解和态度与学生共享"></Input>
          </FormItem>
        </Form>
      </Card>
      <br/>
      <Card>
        <p slot="title">
          作品集
        </p>
        <Upload
          multiple
          type="drag"
          action="//jsonplaceholder.typicode.com/posts/">
          <div style="padding: 20px 0">
            <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
            <p>Click or drag files here to upload</p>
          </div>
        </Upload>
      </Card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TeacherDetails',
  data () {
    return {
      value2: 0,
      avatar: '/modo/upload/default_avatar.jpg'
    }
  }
}
</script>

<style scoped>
  #TeacherDetails{
    text-align: left;
  }
  .avatar{
    text-align: center;
  }
  .upload{
    width: 200px;
    height: 200px;
    display: inline-block;
    text-align: center;
    -webkit-box-shadow: 0 10px 30px 0 rgba(0,0,0,.05);
    box-shadow: 0 10px 30px 0 rgba(0,0,0,.05)
  }
  .lecturer-avatar{
    width: 100%;
    height: 100%;
  }
  .content{
    width: 800px;
    margin: auto;
  }
</style>
