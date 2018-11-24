<template>
    <div class="bg">
        <el-table  stripe style="width: 100%" :data="page.records">
            <el-table-column prop="username" label="作者"  width="180"/>
            <el-table-column prop="newsList.length" label="作品数量" width="180" />
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button @click="read(scope.row)" type="text" size="small">查看</el-button>
                    <el-button @click="update(scope.row)" type="text" size="small">取消关注</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination background layout="prev, pager, next" :total="page.total" @current-change="currentChange" :page-size="page.size" :current-page="page.current"  class="page"></el-pagination>
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
                http.post("/love/pageUser",pageInfo,function(data,status){
                    if(status == true) {
                        if(data != null) {
                            that.page = data
                        }
                    }
                })
            },
            currentChange(val) {
                var pageInfo={
                    current:val,
                    size:15,
                }
                this.getPage(pageInfo)
            },
            read(row){
                this.$router.push({path:'/details',query:{id:row.id}})
            },
            update(row) {
                var love ={
                    editorId : row.id,
                    isLove : false
                }
                var that = this
                http.post("/love/update",love,function(data,status){
                    if(status==true){
                        var pageInfo= {
                            current:1,
                            size:15,
                        }
                        that.getPage(pageInfo)
                    }
                })
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
    width: 600px;
    margin: 20px auto;
}

.page {
    margin: 50px;
}

</style>