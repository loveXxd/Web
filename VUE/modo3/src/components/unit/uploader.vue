/**
* created by lifeng on 2019-04-29
* create time :2019-04-29 15:19
*/

<template>
    <div class='main'>
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
          <Modal title="展示" v-model="visible">
            <img :src="imgurl" v-if="visible" style="width: 100%">
          </Modal>
        </div>
      </Card>
    </div>
</template>

<script>
export default {
  name: 'uploader',
  props: ['upurl', 'successHandler']
}
</script>

<style scoped>

</style>
