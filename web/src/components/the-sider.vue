<template>
  <a-layout-sider width="200" style="background: #fff">
    <a-menu
        v-model:selectedKeys="selectedKeys"
        v-model:openKeys="openKeys"
        mode="inline"
        :style="{ height: '100%', borderRight: 0 }"
    >
      <a-menu-item key="/welcome">
        <router-link to="/welcome">
          <coffee-outlined /> 欢迎
        </router-link>
      </a-menu-item>
      <a-menu-item key="/passenger">
        <router-link to="/passenger">
          <coffee-outlined /> 乘车人管理
        </router-link>
      </a-menu-item>
      <a-menu-item key="/ticket">
        <router-link to="/ticket">
          <right-square-outlined /> 余票信息
        </router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-sider>
</template>

<script>
import {defineComponent, ref, watch} from 'vue';
import router from "@/router";
// import {LaptopOutlined, NotificationOutlined, UserOutlined} from "@ant-design/icons-vue";

export default defineComponent({
  name: "the-sider-view",
  components: {},
  setup() {
    const selectedKeys = ref([]);

    watch(()=>router.currentRoute.value.path, (newValue)=>{
      console.log('watch',newValue);
      selectedKeys.value = [];
      selectedKeys.value.push(newValue);
    }, {immediate: true});

    return{
      selectedKeys,
      openKeys: ref(['sub1']),
    };
  },
});
</script>

<style scoped>

</style>