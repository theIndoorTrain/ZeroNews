<template>
    <div class="bg">
        <el-table  stripe style="width: 100%" :data="page.records">
            <el-table-column prop="name" label="申请人"  width="180"/>
            <el-table-column prop="type" label="申请职位" width="180" :formatter="typeformat"/>
            <el-table-column prop="createTime" label="申请时间" width="300" />
            <el-table-column prop="phone" label="联系方式" width="300" />
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button @click="accept(scope.row,3)" type="text" size="small">同意</el-button>
                    <el-button @click="accept(scope.row,2)" type="text" size="small">拒绝</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination background layout="prev, pager, next" @current-change="currentChange" :total="page.total" class="page" :page-size="page.size" :current-page="page.current" ></el-pagination>
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
            typeformat(row,column) {
                return row.type==true?"编辑":"主编"
            },
            getList(page) {
                var that = this 
                http.post("/emp/page",page,function(data,status){
                    if(status==true) {
                        that.page = data
                    }
                })
            },
            accept(row,status) {
                row.status = status
                var that = this
                http.put("/audit/emp",row,function(data,status) {
                    if(status==true) {
                        that.getList
                    }
                })
            },
            currentChange(val) {
                var pageInfo={
                    current:val,
                    size:15,
                }
                this.getList(pageInfo)
            }
        },
        created(){
            var pageInfo={
                current:1,
                size:15,
            }
            this.getList(pageInfo)
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