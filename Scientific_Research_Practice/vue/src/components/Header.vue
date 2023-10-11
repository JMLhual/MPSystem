<template>
  <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      router="true"
  >
    <el-menu-item index="/welcome" style="margin-left: 5px">
      <el-icon><house/></el-icon>
      Welcome
    </el-menu-item>
    <el-menu-item index="/upload">
      <el-icon><upload /></el-icon>
      Upload
    </el-menu-item>
    <el-menu-item index="/mcarmar">
      <el-icon><Cpu /></el-icon>
      MCAR/MAR
    </el-menu-item>
    <el-menu-item index="/mnar">
      <el-icon><Cpu /></el-icon>
      MNAR
    </el-menu-item>
    <el-menu-item index="/about">
      <el-icon><More /></el-icon>
      About
    </el-menu-item>
  </el-menu>

</template>

<script lang="ts" setup>
import { ref } from 'vue'


const activeIndex = ref('/welcome')

const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

</script>
<script>


</script>


