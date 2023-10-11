<template>
  <div style="height: 100%; width: 100%;">
    <div style="height: 60px;font-size:25pt;position:absolute;top:0px;left:20px">
      I do not want to study !
    </div>
    <div style="width: 100%;height: 100%">
      <el-container style="position:absolute;top:60px;left:-10px;height:100%;width: 100%;">
        <el-header >
          <Header />
        </el-header>
      </el-container>
    </div>
    <div style="position:absolute;top:130px;left:10px;">
      <router-view />
    </div>


  </div>
</template>

<script>
import Header from "../components/Header.vue";
export default {
  name: "Manage",

  data(){
    return{

    }
  },

  components:{
    Header
  },
}
</script>

<style scoped>

</style>