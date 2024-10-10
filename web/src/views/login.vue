<template>
  <a-row class="login">
    <a-col :span="8" offset="8" class="login-main">
      <h1 class="centered-title">小卒科技-仿12306购票平台</h1>
      <a-form
          :model="loginForm"
          name="basic"
          autocomplete="off"
          @finish="onFinish"
          @finishFailed="onFinishFailed"
      >
        <a-form-item
            label="手机号"
            name="mobile"
            :rules="[{ required: true, message: '请输入手机号' }]"
        >
          <a-input v-model:value="loginForm.mobile" />
        </a-form-item>

        <a-form-item
            label="验证码"
            name="code"
            :rules="[{ required: true, message: '请输入验证码' }]"
        >
          <a-input v-model:value="loginForm.code">
            <template #addonAfter>
              <a @click="sendCode">获取验证码</a>
            </template>
          </a-input>
        </a-form-item>

        <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
          <a-button type="primary" html-type="submit">登陆</a-button>
        </a-form-item>
      </a-form>
    </a-col>
  </a-row>
</template>

<script>
import { defineComponent, reactive } from 'vue';
import axios from 'axios';

export default defineComponent({
  setup() {
    const loginForm = reactive({
      mobile: '',
      code: '',
    });
    const onFinish = values => {
      console.log('Success:', values);
    };
    const onFinishFailed = errorInfo => {
      console.log('Failed:', errorInfo);
    };
    const sendCode = () => {
      axios.post("http://localhost:8000/member/member/send-code", {
        mobile: loginForm.mobile
      }).then(response => {
        console.log(response)
      });
    };
    return {
      loginForm,
      onFinish,
      onFinishFailed,
      sendCode
    };
  },
});
</script>

<style>
.centered-title {
  font-weight: bold;
  font-family: "黑体", sans-serif;
  color: black;
  text-align: center;
  font-size:30px;
}
</style>