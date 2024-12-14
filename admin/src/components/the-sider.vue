<template>
  <a-layout-sider width="200" style="background: #fff">
    <a-menu
        v-model:selectedKeys="selectedKeys"
        :openKeys="['batch', 'base', 'business', 'member']"
        mode="inline"
        :style="{ height: '100%', borderRight: 0 }"
    >
      <a-menu-item key="/welcome">
        <router-link to="/welcome">
          <coffee-outlined /> 欢迎
        </router-link>
      </a-menu-item>
      <a-menu-item key="/about">
        <router-link to="/about">
          <coffee-outlined /> About
        </router-link>
      </a-menu-item>
      <a-sub-menu key="base">
        <template #title>
          <span>
            <UnorderedListOutlined />
            基础数据
          </span>
        </template>
        <a-menu-item key="/station">
          <router-link to="/station">
            <highlight-outlined /> station
          </router-link>
        </a-menu-item>
        <a-menu-item key="/train">
          <router-link to="/train">
            <highlight-outlined /> train
          </router-link>
        </a-menu-item>
        <a-menu-item key="/train-station">
          <router-link to="/train-station">
            <highlight-outlined /> train-station
          </router-link>
        </a-menu-item>
        <a-menu-item key="/train-carriage">
          <router-link to="/train-carriage">
            <highlight-outlined /> train-carriage
          </router-link>
        </a-menu-item>
        <a-menu-item key="/train-seat">
          <router-link to="/train-seat">
            <highlight-outlined /> train-seat
          </router-link>
        </a-menu-item>
      </a-sub-menu>
      <a-sub-menu key="batch">
        <template #title>
          <span>
            <UnorderedListOutlined />
            跑批管理
          </span>
        </template>
        <a-menu-item key="/batch/job">
          <router-link to="/batch/job">
            <form-outlined /> 任务管理
          </router-link>
        </a-menu-item>
      </a-sub-menu>
      <a-sub-menu key="business">
        <template #title>
          <span>
            <UnorderedListOutlined />
            业务管理
          </span>
        </template>
        <a-menu-item key="/business/daily-train">
          <router-link to="/business/daily-train">
            <right-square-outlined /> 每日车次
          </router-link>
        </a-menu-item>
        <a-menu-item key="/business/daily-train-station">
          <router-link to="/business/daily-train-station">
            <right-square-outlined /> 每日途径车站
          </router-link>
        </a-menu-item>
        <a-menu-item key="/business/daily-train-carriage">
          <router-link to="/business/daily-train-carriage">
            <right-square-outlined /> 每日车厢
          </router-link>
        </a-menu-item>
        <a-menu-item key="/business/daily-train-seat">
          <router-link to="/business/daily-train-seat">
            <right-square-outlined /> 每日座位
          </router-link>
        </a-menu-item>
        <a-menu-item key="/business/daily-train-ticket">
          <router-link to="/business/daily-train-ticket">
            <right-square-outlined /> 余票信息
          </router-link>
        </a-menu-item>
        <a-menu-item key="/business/confirm-order">
          <router-link to="/business/confirm-order">
            <right-square-outlined /> 订单信息
          </router-link>
        </a-menu-item>
      </a-sub-menu>

      <a-sub-menu key="member">
        <template #title>
          <span>
            <UnorderedListOutlined />
            会员管理
          </span>
        </template>
        <a-menu-item key="/member/ticket">
          <router-link to="/member/ticket">
            <right-square-outlined /> 会员车票
          </router-link>
        </a-menu-item>
      </a-sub-menu>

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