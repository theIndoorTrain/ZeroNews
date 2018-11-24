<template>
    <div class="bg">
        <el-card shadow="always">
            <img src="@/assets/boy.jpg" width="70%" v-if="emp.user.gender">
            <img src="@/assets/girl.jpg" width="70%" v-if="!emp.user.gender">
            <h2>职员信息</h2>
            <table>
                            <tr>
                                <td>
                                    <label>工号：</label>
                                </td>
                                <td>
                                    <span>{{emp.num}}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>姓名：</label>
                                </td>
                                <td>
                                    <span>{{emp.name}}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>部门：</label>
                                </td>
                                <td>
                                    <span>编辑部</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>电话：</label>
                                </td>
                                <td>
                                    <span>{{emp.phone}}</span>
                                </td>
                            </tr>
            </table>
            <img src="@/assets/logo2.png" width="40%" class="logo">
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                emp:null
            }
        },
        created() {
            var that = this
            http.get("/emp/get",function(data,status){
                if(status==true) {
                    if(data!=null) {
                        that.emp=data
                    }
                }
            })
        }
        
    }
</script>

<style scoped>

.bg {
    width:500px;
    margin: 40px auto;
}

table {
    margin: 0 auto;
}

.logo {
    margin-top: 20px;
}

</style>