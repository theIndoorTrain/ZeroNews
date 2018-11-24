<template>
    <div class="bg">
        <el-card shadow="always">
            <img :src="user.image"  class="logo">
            <div>
                <h1>{{user.username}}</h1>
                <h4>{{user.signature}}</h4>
                <table>
                    <tr>
                        <td><label>邮箱：</label></td>
                        <td><span>{{user.email}}</span></td>
                    </tr>
                    <tr>
                        <td><label>性别：</label></td>
                        <td><span v-if="user.gender">男</span><span v-if="!user.gender">女</span></td>
                    </tr>
                    <tr>
                        <td><label>年龄：</label></td>
                        <td><span>21</span></td>
                    </tr>
                </table>
            </div>
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                user: null,
            }
        },
        created() {
            var that = this
            http.get("/user/isLogin",function(data,status){
                if(status==true && data!=null) {
                    that.user = data
                }
            })
        }
        
    }
</script>

<style scoped>

.bg {
    width: 600px;
    margin: 30px auto;
}

.logo {
    width:100%;
    height:500px;
    border: 3px #303133 solid;
}

table {
    margin: 0 auto;
}

label{
    color: #606266;
}



</style>