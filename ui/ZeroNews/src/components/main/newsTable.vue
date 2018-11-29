<template>
<el-card>
<div class="bg">
    <h1>最新新闻</h1>
    <el-table
      :data="page.records"
      style="width: 100%;margin-bottom:20px">
      <el-table-column prop="type" width="80" :formatter="typeformat" />
      <el-table-column>
        <template slot-scope="scope">
          <a :href="'/#/News?id='+scope.row.id" class="title">{{scope.row.title}}</a>
        </template>
      </el-table-column>
      <el-table-column prop="pullTime" :formatter="dateformat" width="180"/>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="page.curent"
      :page-sizes="[15]"
      :page-size="page.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="page.total">
    </el-pagination>
  
</div>
</el-card>    
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
      props: {
        type: {
          type: Number,
          default: 0
        },
      },
      data() {
        return {
          page:null,
          types:["[其他]","[国际]","[科技]","[军事]","[历史]","[文化]","[娱乐]","[旅游]","[教育]"],
          //type:["其他","国际","科技","军事","历史","文化","娱乐","旅游","教育"],
        }
      },
      methods: {
        getPage(pageInfo) {
          var that = this
          http.post("/news/page/publicType",pageInfo,function(data,status){
            if(status==true) {
              if(data != null) {
                that.page = data
              }
            }
          })
        },
        dateformat(row,column) {
                if(row.pullTime==null) {
                    return ""
                }
                return row.pullTime.replace("T"," ")
            },
        typeformat(row,column) {
          return this.types[row.type%9]
        },
        currentChange(val) {
                var pageInfo={
                    current:val,
                    size:15,
                }
                this.getPage(pageInfo)
            },
      },
      created() {
        var pageInfo={
          current:1,
          size:15,
          type:this.type,
        }
        this.getPage(pageInfo)
      }
    }
  </script>

<style scoped>

.bg {
  width:90%;
  margin: 0px auto 20px;
}

.title {
  text-decoration: none;
  color: #303133;
}

h1 {
  margin: 5px auto;
}

</style>