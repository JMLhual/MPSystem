<template xmlns:boxShadow="http://www.w3.org/1999/xhtml">
  <el-container>
    <el-aside class="test" style="width:320px;height: 450px;background-color:#d9ecff;border-radius: 8px;overflow: hidden;">
      <div style="width: 300px;font-size: 15pt;margin-left: 20px;margin-top: 10px">
        MCAR imputation
      </div>

      <div>
        <div style="margin-top:10px;margin-left: 20px;font-weight: bold">
          Set Seed:
        </div>
        <el-input-number
            v-model="num"
            class="mx-4"
            :min="1"
            :max="999999999"
            controls-position="right"
            @change="handleChange"
            style="width: 300px;margin-top: 3px;margin-left: 10px  "
        />
      </div>

      <div>
        <div style="margin-top:10px;margin-left: 20px;font-weight: bold">
          Select one imputation method
        </div>
        <el-select-v2
            v-model="value"
            :options="options"
            placeholder="Please select"
            style="width: 300px;margin-top: 3px;margin-left: 10px;"
        />
      </div>

      <div>
        <div style="margin-top:10px;margin-left: 20px;font-weight: bold;font-size: 11pt">
          Filter variables by non-missing proportion:
        </div>
        <div class="slider-demo-block">
          <el-slider v-model="value1"
                     :step="10"
                     :marks="marks"
                     :min="0"
                     :format-tooltip="formatTooltip" />
        </div>
      </div>

      <div>
        <div style="margin-top:20px;margin-left: 10px;float: left;width: 20px">
          <el-switch v-model="value2" />
        </div>
        <div style="margin-top:23px;margin-right: 60px;float: right;height: 20px;font-size: 12pt">
          Group-wise missing filtering
        </div>
      </div>

      <div>
        <div style="margin-top:60px;margin-left: 15px;width: 290px;font-size: 10pt">
          If checked, variables with non-missing proportion less than the threshold will be removed in the output.
        </div>
      </div>

      <div style="margin-top:10px;margin-left: 15px;">
        <el-row class="mb-4">
          <el-button>Run</el-button>
        </el-row>
      </div>
    </el-aside>

    <el-container>
      <el-main>
        <div style="font-weight: bold;font-size: 40pt">我还是不会！！！</div>
      </el-main>
    </el-container>
  </el-container>


</template>

<script lang="ts" setup>
import {reactive, ref} from 'vue'

const num = ref(1234)
const handleChange = (value: number) => {
  console.log(value)
}
//复选框
const initials = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']

const value = ref()
const options = Array.from({ length: 1000 }).map((_, idx) => ({
  value: `Option ${idx + 1}`,
  label: `${initials[idx % 10]}${idx}`,
}))
//滑块
const value1 = ref(80)

import type { CSSProperties } from 'vue'
const formatTooltip = (val: number) => {
  return val / 100
}

interface Mark {
  style: CSSProperties
  label: string
}

type Marks = Record<number, Mark | string>


const marks = reactive<Marks>({
  0: '0',
  10: '0.1',
  20: '0.2',
  30: '0.3',
  40: '0.4',
  50: '0.5',
  60: '0.6',
  70: '0.7',
  80: '0.8',
  90: '0.9',
  100: '1',
})

//开关
const value2 = ref(true)
</script>

<style scoped>
.test {
  box-shadow: 0px 0px 3px rgba(50, 10, 100,0.5);
}
.example-showcase .el-select-v2 {
  margin-right: 20px;
}

/*滑块*/
.slider-demo-block {
  display: flex;
  align-items: center;
  width: 305px;
}
.slider-demo-block .el-slider {
  margin-top: 10px;
  margin-left: 15px;
}

</style>