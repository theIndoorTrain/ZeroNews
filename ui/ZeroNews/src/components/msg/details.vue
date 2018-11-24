<template>
    <div>

        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/message' }">消息列表</el-breadcrumb-item>
                <el-breadcrumb-item>我的消息</el-breadcrumb-item>
            </el-breadcrumb>
        </div>

        <el-card shadows="always" class="bg">

            <span>时间：{{msg.createTime.replace("T"," ")}}</span>

            <div class="msg">
                <div v-html="msg.context">
                    
                </div>
            </div>   
            
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                msg: null
            }
        },
        created() {
            var id = this.$route.query.id
            var that = this
            http.get("/msg/"+id,function(data,status){
                if(status == true) {
                    if(data != null) {
                        that.msg = data
                    }
                }
            })

        }
        
    }
</script>

<style scoped>

.bg {
    width:800px;
    margin: 20px auto;
    text-align: left;
}

.breadcrumb {
    margin: 20px 50px;
}

</style>