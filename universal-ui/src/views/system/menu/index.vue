<template>
  <div>
    <h1>菜单管理</h1>
    <button @click="test()">点击测试</button>
  </div>
</template>

<script>
import { login, logout, getInfo } from "@/api/login";
export default {
  name: "Menu",
  data() {
    return {};
  },

  methods:{
    test(){
      getInfo().then(res => {
        console.log(res)
      })
    }
  }
};
</script>

<style>
</style>