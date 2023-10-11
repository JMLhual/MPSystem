<template>
  <div>
      <el-container>
        <el-aside style="width:320px;height: 270px;background-color:#d9ecff;border-radius: 8px;overflow: hidden;">
          <div style="width: 300px;height: 190px;margin-left: 15px;margin-top: 20px">
            <span style="font-weight: bold;font-size: 15pt">Upload your data</span><br>
            <span style="font-weight: bold">Choose raw file (.csv)</span><br>

       <el-upload
          class="upload-demo"
          action="http://localhost:8080/file/upload"
          :on-success="handlePreview"
          :on-change="handleChange"
          :show-file-list="false"
          :on-progress="handleProgress"
         >
          <el-button size="small" type="primary">点击上传</el-button>
          <el-input
            v-model="input"
            readonly
            :model-value="fileName">
          </el-input>
        </el-upload>

          <el-progress
            v-if="uploading" 
            :percentage="uploadPercentage"
          ></el-progress>

          <a class="explore" href="http://localhost:8080/file/download">Or download our example data</a>
            
          </div>

        </el-aside>

        <el-container>
          <el-main>
            <div style="font-size: 13pt;margin-top: -10px">Raw data overview:</div>

            <!-- <table id="csvTable" class="csvTable" >
              <thead>
                <tr>

                </tr>
              </thead>
              <tbody>
                
              </tbody>
            </table> -->
            <div v-show="total>0" class="top">
              Show
              <el-select 
              @change="handlePageSizeChange"
              v-model="value"  
              style="width:70px;">
                <el-option
                  v-for="item in selectNum"
                  :key="item"
                  :label="item"
                  :value="item"
                  >
                </el-option>
              </el-select>
              entries:
            </div>
              <div v-show="total>0" class="inputBox">
                Search:
                <el-input 
                v-model="search"
                size="mini"
                placeholder="输入关键字搜索"/>
              </div>
            <el-table v-show="total>0"
              id="csvTable"
              :data="filteredData"
              style="width: 100%"
              :row-class-name="tableRowClassName"
              >
             <el-table-column
               v-show="total>0"
               v-for="column in tableColumns"
                :key="column"
                :prop="column"
                :label="column"
                :sortable="true"
                :width="180"
               >
             </el-table-column>
            
            </el-table>
            <div v-show="total>0" style="float:left">showing {{(pageNum-1)*pageSize + 1}} to {{lastNum}}  of {{total}} entries</div>
            <el-pagination
            v-show="total>0"
              @current-change="handleCurrentChange"
              background
              layout="prev, pager, next"
              :total="total"
              :page-size="pageSize">
            </el-pagination>

          </el-main>
        </el-container>
      </el-container>
    </div>
</template>

<script>
  import fileAPI from "../utils/API/file";

export default {
  name: "Upload",
   data() {
      return {
        fileName:'',
        fileList: [],
        uploading: false, // 上传状态
        uploadPercentage: 0, // 上传进度
        tableData:[],
        tableColumns:[],
        search:"",
        selectNum:[5,10,20,50],
        value:10,
        pageSize:10,
        pageNum:1,
        total:0,
        lastNum:0
      };
    },
    beforeMount(){
      this.fileName = JSON.parse(localStorage.getItem("fileName"));
      this.presentationData();
    },
    computed:{
      filteredData(){
        return this.tableData.filter(data =>
         !this.search || this.tableColumns.some(column =>{
          const fieldValue = data[column];
          // console.log("@@@@@@",fieldValue);
          // console.log(data);
          return fieldValue && fieldValue.toString().toLowerCase().includes(this.search.toLowerCase());
         })
        )
      } 
    },
    methods: {
      presentationData(){

          fileAPI.getCsvData(this.fileName,this.pageSize,this.pageNum).then(response => {

          console.log("------------@@@" , response);
        
          this.tableData = response.data;
          localStorage.setItem("fileName",JSON.stringify(this.fileName));
          this.total = response.total;
          const keys = Object.keys(response.data[0]);
          
          this.tableColumns = keys;

          this.lastNum = Math.min(this.total,(this.pageNum-1)*(this.pageSize) + this.pageSize);
          // keys.sort((a,b) => a[0].localeCompare(b[0]));
        })
        .catch(error =>{
          console.log("Error fetching CSV data:" ,error);
        })
      },
      handlePageSizeChange(newPageSize){
       this.pageSize = newPageSize;
       this.presentationData();
      },
      handleCurrentChange(newPage){
       this.pageNum = newPage;
       this.presentationData();
      },
      tableRowClassName({row, rowIndex}) {
        if (rowIndex % 2 === 0) {
          return 'warning-row';
        } else if (rowIndex % 2 === 1) {
          return 'success-row';
        }
        return '';
      },
      handlePreview(file) {
        console.log("------------------------------",file);
        this.fileName = file.data;
        this.presentationData();
      },

      handleChange(file, fileList) {
      // 处理文件上传逻辑
      // 这里可以监听上传进度
      file.status === 'success' && this.$message.success(`${file.name} 上传成功`);
      file.status === 'error' && this.$message.error(`${file.name} 上传失败`);
    },
      handleProgress(event, file, fileList) {
        if (event.percent) {
          // 更新上传进度
          this.uploadPercentage = event.percent;
          this.uploading = true; // 设置上传中状态
        } else {
          this.uploading = false; // 设置上传完成状态
        }
      },

    }
}
</script>

<style>
    .top{
      float: left;
        font-weight: 700;
    }
    .inputBox{
      float: right;
      position: absolute;
      left: 1000px;
      font-weight: 700;
    }
    .inputBox .el-input{
      width: 230px;
    }
    .el-pagination{
      margin-left: 500px;
    }
   .el-table {
      border-collapse: collapse; /* 合并单元格边框 */
      border-top: 2px solid #000; /* 上边框宽度和颜色 */
      border-bottom: 2px solid #000; /* 下边框宽度和颜色 */
    }
   .explore{
     position: absolute;
     top: 200px;
   }
   .el-table .warning-row {
    background:white;
   }

  .el-table .success-row {
    background: rgb(244, 239, 235);
   }

  #csvTable{
    margin-top: 60px;
    margin-bottom: 15px;
  }
</style>