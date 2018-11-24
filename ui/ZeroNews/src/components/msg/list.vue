<template>
    <div class="bg">
        <div class="bg">
        <el-table  stripe style="width: 100%" :data="page.records">
            <el-table-column prop="isRead" label="状态"  width="180">
                <template slot-scope="scope">
                    <svg class="icon font" aria-hidden="true" v-if="!scope.row.isRead" @click="read(scope.row)">
                        <use xlink:href="#icon-zhanneixin"></use>
                    </svg>
                    <svg class="icon font" aria-hidden="true" v-if="scope.row.isRead" @click="read(scope.row)">
                        <use xlink:href="#icon-zhanneixinyidu"></use>
                    </svg>
                </template>
            </el-table-column>
            <el-table-column prop="name" label="发件人" width="300" />
            <el-table-column prop="createTime" label="时间" :formatter="dateformat" width="180"/>
            <el-table-column label="操作">
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
    import "@/fonticon/iconfont1.js"
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                page: null
            }
        },
        methods: {
            getPage(pageInfo) {
                var that = this
                http.post("/msg/page",pageInfo,function(data,status){
                    if(status==true) {
                        if(data != null) {
                            that.page = data
                        }
                    }
                })
            },
            dateformat(row,column) {
                if(row.createTime==null) {
                    return ""
                }
                return row.createTime.replace("T"," ")
            },
            currentChange(val) {
                var pageInfo={
                    current:val,
                    size:15
                }
                this.getPage(pageInfo)
            },
            read(row) {
                if(row.isRead==false) {
                    http.put("/msg/"+row.id,null,function(data,status){})
                }
                this.$router.push({path:'/home/message/details',query:{id:row.id}})
            }
        },
        created() {
            var pageInfo={
                current:1,
                size:15
            }
            this.getPage(pageInfo)
        }
    }
</script>

<style scoped>

.bg {
    width:80%;
    margin: 30px auto;
}

.page {
    margin: 50px;
}

.font {
    font-size: 20px;
}

</style>