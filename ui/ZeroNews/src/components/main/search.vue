<template>
    <div class="bg">
        <el-card>
            <div class="search">
                <el-input placeholder="请输入内容" v-model="key" @keyup.enter="search()" class="input-with-select">
                    <el-button slot="append" icon="el-icon-search"  @click="search()"></el-button>
                </el-input>
                <p v-if="key">搜索关键词“{{key}}”</p>
                <h1>搜索结果</h1>
                <hr>
                <el-table
                :data="page.records"
                style="width: 100%;margin-bottom:20px">
                <el-table-column prop="type" width="80" :formatter="typeformat" label="类别"/>
                <el-table-column label="新闻标题">
                    <template slot-scope="scope">
                    <a :href="'/#/News?id='+scope.row.id" class="title">{{scope.row.title}}</a>
                    </template>
                </el-table-column>
                <el-table-column prop="user.username"  width="180" label="编辑"/>
                <el-table-column prop="pullTime" :formatter="dateformat" width="180" label="发表时间"/>
                </el-table>

                <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="page.curent"
                :page-sizes="[5]"
                :page-size="page.size"
                layout="total, sizes, prev, pager, next, jumper"
                :total="page.total">
                </el-pagination>
            </div>           
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                key: "",
                types:["[其他]","[国际]","[科技]","[军事]","[历史]","[文化]","[娱乐]","[旅游]","[教育]"],
                page:null,
            }
        },
        methods: {
            search(page) {
                this.page = null
                var that = this
                http.post("/news/search",page,function(data,status){
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
                        size:5,
                        search:this.key
                    }
                    this.search(pageInfo)
            },
        },
        created() {
            this.key=this.$route.query.key
            var page={
                    current:1,
                    size:5,
                    search:this.key
                }
            this.search(page)
        }
    }
</script>

<style scoped>

.bg {
    width:90%;
    margin: 20px auto;
}

.search {
    padding: 20px 100px;
    height:500px;
    text-align: left;
}

.title {
  text-decoration: none;
  color: #303133;
}

</style>