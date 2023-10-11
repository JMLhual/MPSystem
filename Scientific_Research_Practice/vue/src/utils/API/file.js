import request from "../request"


export default{
  getCsvData(fileName,pageSize,pageNum){
        return request ({
            url:'/file/data',
            method:'get',
            params:{fileName,pageSize,pageNum}
        })
    },
}