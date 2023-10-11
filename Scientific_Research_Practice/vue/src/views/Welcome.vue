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
            <div style="color: #337ecc;;font-size: 20pt;margin-top: -10px">Introduction</div>
            <div style="width: 900px">
              <div><span style="font-weight: bold">MetImp</span>
              is a web tool for -omics missing data imputation, especially for mass spectrometry-based metabolomics data from
                metabolic profiling and targeted analysis.</div><br>
              <div>There are three types of missing values in Metabolomics: missing completely at random (MCAR), missing at random (MAR),
                and missing not at random (MNAR). We recommend
              <sapn style="font-weight: bold">a comprehensive approach for handling missing values:</sapn>
              </div>
            </div><br>
            <div>
              <div>(1) Analyze the possible reasons of missing values: whether they are MNAR/MAR, or MNAR;</div>

              <div class="m5">(2) If necessary, check raw data and/or adjust parameter settings of data preprocessing in order to fill back certain missing values in an accurate way;</div>

              <div class="m5">(3) Apply missing filtering to remove those unreliable variables with unacceptable number of missing values;</div>

              <div class="m5">(4) If missing value imputation is needed for your data, choose an appropriate method;</div>

              <div class="m5">(5) MetImp provides:</div>

              <div class="m5">A. Group-wise missing filtering: 0%~100% adjustable, 80% is the default proportion ;</div>

              <div class="m5">B. For MCAR/MAR: we provide RF, SVD, kNN, Mean, Median imputation, and RF is default;</div>

              <div class="m5">C. For MNAR: we provide GSimp, QRILC, HM, Zero, Binary imputation, and GSimp is default.</div>
            </div>
            <div style="background-image: url(src/files/MetImp1.2.png);width: 1000px;height: 380px;background-size: 100%"></div>
            <div>
              For the imputation evaluation pipeline, please visit:
              <a href="https://github.com/WandeRum/MVI-evaluation" target="_blank" style="color: #337ecc;font-size: 12pt;">
                https://github.com/WandeRum/MVI-evaluation
              </a>
            </div>
          </el-main>
        </el-container>
      </el-container>
    </div>
</template>


<script>
export default {
  name: "Welcome"
}
</script>

<style scoped>
.m5{
  margin-top: 5px;
}
.shadow {
  box-shadow: 0px 0px 3px rgba(50, 10, 100,0.5);
}
</style>