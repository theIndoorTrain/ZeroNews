<template>
    <div class="bg">
        <el-table  stripe style="width: 100%" :data="page.records">
            <el-table-column prop="pullTime" label="发表日期" :formatter="dateformat" width="180"/>
            <el-table-column prop="user.username" label="作者"  width="180"/>
            <el-table-column prop="title" label="标题" width="300" />
            <el-table-column prop="zanNum" label="点赞数"  width="180"/>
            <el-table-column prop="commentNum" label="评论数"  width="180"/>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button @click="read(scope.row)" type="text" size="small">查看</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination background layout="prev, pager, next" :total="page.total" @current-change="currentChange" :page-size="page.size" :current-page="page.current" class="page"></el-pagination>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                page: null,
            }
        },
        methods: {
            getPage(pageInfo) {
                var that = this
                http.post("/love/pageNews",pageInfo,function(data,status){
                    if(status == true) {
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
            currentChange(val) {
                var pageInfo={
                    current:val,
                    size:15,
                }
                this.getPage(pageInfo)
            },
            read(row) {
                this.$router.push({path:'/news',query:{id:row.id}})
            }
        },
        created() {
            var pageInfo= {
                current:1,
                size:15,
            }
            this.getPage(pageInfo)
        }
    }
</script>

<style scoped>

.bg {
    width: 80%;
    margin: 20px auto;
}

.page {
    margin: 50px;
}

</style>