<template>
    <div>
        <div class="bg">
        <el-table  stripe style="width: 100%" :data="page.records">
            <el-table-column prop="pullTime" label="发布日期" :formatter="dateformat" width="180"/>
            <el-table-column prop="title" label="标题"  />
            <el-table-column prop="type" label="类型" width="180" :formatter="typeformat" />
            <el-table-column label="操作" width="180">
                <template slot-scope="scope">
                    <el-button @click="read(scope.row)" type="text" size="small">查看</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination background layout="prev, pager, next" @current-change="currentChange" :total="page.total" :page-size="page.size" :current-page="page.current" class="page"></el-pagination>
    </div>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                page: null,
                type:["其他","国际","科技","军事","历史","文化","娱乐","旅游","教育"],
            }
        },
        methods: {
            getList(pageInfo) {
                var that = this
                http.post("/news/page",pageInfo,function(data,status){
                    if(status==true) {
                        if(data != null) {
                            that.page = data
                        }
                    }
                })
            },
            typeformat(row,column) {
                return this.type[row.type%9]
            },
            dateformat(row,column) {
                if(row.pullTime==null) {
                    return ""
                }
                return row.pullTime.replace("T"," ")
            },
            currentChange(val) {
                var pageInfo={
                    current:val,
                    size:15,
                    status:2,
                }
                this.getList(pageInfo)
            },
            read(row) {
                var id = row.id
                this.$router.push({path:'/home/news/details',query:{id:id}})
            },
        },
        created() {
            var pageInfo={
                current:1,
                size:15,
                status:2,
            }
            this.getList(pageInfo)
        }
    }
</script>

<style scoped>

.bg {
    width: 60%;
    margin: 20px auto;
}

.page {
    margin: 50px;
}


</style>