<template>
  <div>
    <el-container>
      <el-aside class="shadow" style="width:320px;height: 460px;background-color:#d9ecff;border-radius: 8px;overflow: hidden;">
        <div style="width: 300px;height: 190px;margin-left: 15px;margin-top: 20px;border-bottom: 1px solid #ffffff">
          <span style="font-weight: bold;font-size: 15pt">News & Updates</span><br>

          <span>Added set seed options at June/27/2018;</span><br>

          <span>Elaborated the required data format at June/18/2018;</span><br>

          <span>Added a new module for MNAR imputation (GSimp) at May/21/2018;</span><br>

          <sapn>MetImp was started on March 2017!</sapn>
        </div>

        <div style="width: 300px;height: 120px;margin-top:10px;margin-left: 10px;border-bottom: 1px solid #ffffff">
          <sapn style="font-size: 20pt">JXUTCM</sapn><br>

          <span>jxutcm.edu.cn</span><br>

          <span>jsj.jxutcm.edu.cn/index.htm</span>
        </div>

        <div style="height: 100px;margin-top:10px;margin-left: 10px">
          <span style="font-size: 15pt">I don't want to write front-end </span><br>

          <span>写累了怎么办？</span><br>

          <a href="https://www.4399.com/" target="_blank" style="color: red;font-size: 12pt;">当然是去play games</a>
        </div>
      </el-aside>

      <el-container>
        <el-main>

          <div style="width: 900px">
            <div style="color: #337ecc;;font-size: 23pt;margin-top: -10px">App Info</div>

            <div>Version 1.2</div>

            <div class="m5">Built using Shiny by R and RStudio</div>
          </div>

          <div style="width: 900px" class="m12">
            <div style="color: #337ecc;;font-size: 23pt;margin-top: -10px">License</div>

            <div>This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</div>

          </div>

          <div style="width: 900px" class="m12">
            <div style="color: #337ecc;;font-size: 23pt;margin-top: -10px">Support</div>

            <div>For sending comments, suggestions, bug reports of MetImp, please email to Runmin Wei (runmin@hawaii.edu)</div>

          </div>

          <div style="width: 900px" class="m12">
            <div style="color: #337ecc;;font-size: 23pt;margin-top: -10px">References</div>

            <div>Stekhoven, Daniel J., and Peter Bühlmann. "MissForest—non-parametric missing value imputation for mixed-type data."
              Bioinformatics 28.1 (2011): 112-118.</div>

            <div class="m5">Hastie, Trevor, et al. "Imputing missing data for gene expression arrays." (1999): 1-7.</div>

            <div class="m5">Troyanskaya, Olga, et al. "Missing value estimation methods for DNA microarrays." Bioinformatics 17.6 (2001): 520-525.</div>

            <div class="m5">Lazar, Cosmin. "imputeLCMD: a collection of methods for left-censored missing data imputation." R package, version 2 (2015).</div>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script>
export default {
  name: "About"
}
</script>

<style scoped>
.m5{
  margin-top: 5px;
}
.m12{
  margin-top: 12px;
}
.shadow {
  box-shadow: 0px 0px 3px rgba(50, 10, 100,0.5);
}
</style>