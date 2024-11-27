<template>
  <a-select
      v-model:value="stationName" show-search allow-clear
      :filterOption="filterStationNameOption"
      @change="onChange"
      placeholder="请选择车站"
      :style = "'width: '+ localWidth"
  >
    <a-select-option v-for="item in stations" :key="item.name" :value="item.name" :label="item.name + item.namePinyin + item.namePy">
      {{item.name}} {{item.namePinyin}} {{item.namePy}}
    </a-select-option>
  </a-select>
</template>

<script>
import {defineComponent, onMounted, ref, watch} from "vue";
import axios from "axios";
import {notification} from "ant-design-vue";

export default defineComponent({
  name: "station-select-view",
  props: ["modelValue", "width"],
  emits: ['update:modelValue', 'change'],
  setup(props, {emit}) {

    const stationName = ref();

    const stations = ref([]);

    const localWidth = ref(props.width);
    if(Tool.isEmpty(props.width)) {
      localWidth.value = "100%";
    }

    // 利用watch，动态获取父组件的值，如果放在onMounted或其它方法里，则只有一次有效
    watch(() => props.modelValue, ()=>{
      console.log("props.modelValue", props.modelValue);
      stationName.value = props.modelValue;
    });

    /**
     * 查询所有车次，用于车次下拉框
     */
    const queryAllTrain = () => {
      axios.get("/business/admin/station/query-all").then((response) => {
        let data = response.data;
        if (data.success) {
          console.log("data.content: ",data.content);
          stations.value = data.content;
        } else {
          notification.error({description: data.message});
        }
      });
    };

    const filterStationNameOption = (input, option) => {
      console.log(input, option);
      return option.label.toLowerCase().indexOf(input.toLowerCase()) >= 0;
    };

    const onChange = (value) => {
      emit('update:modelValue', value);
      let station = stations.value.filter(item => item.code === value)[0];
      if (Tool.isEmpty(station)) {
        station = {};
      }
      emit('change', station);
    };

    onMounted(() => {
      queryAllTrain();
    });

    return {
      stationName,
      stations,
      filterStationNameOption,
      onChange,
      localWidth,
    }

  }
})
</script>