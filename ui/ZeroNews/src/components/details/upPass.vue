<template>
    <div class="bg">
        <h2>修改密码</h2>
        <el-card shadow="always">
            <el-form  label-width="100px">
            <el-form-item label="当前密码">
                <el-input  v-model="user.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="新密码">
                <el-input v-model="user.newPass" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认新密码" >
                <el-input v-model="pass" type="password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="info" @click="submit">修改密码</el-button>
            </el-form-item>
            
            
        </el-form>
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    import check from '@/util/checkUtil'
    export default {
        data() {
            return {
                user: {
                    password:null,
                    newPass:null,
                },
                pass:null,
            }
        },
        methods: {
            submit() {
                if(check.isNull(this.user.password)==true || check.isNull(this.user.newPass)==true || check.isNull(this.pass)==true) {
                    this.warn('密码不能为空或者包含空格！')
                    return
                }
                if(check.empty(this.user.newPass,this.pass)   != true ) {
                    this.warn('重复密码不正确！')
                    return
                }
                var that = this
                http.put("/user/upPass",this.user,function(data,status) {
                    if(status == true ) {
                        if(data==true) {
                            that.$message.success("密码修改成功！")
                        } else{
                            that.$message.error("密码错误！")
                        }
                    }
                })
            },
            warn(str) {
                this.$message({
                        message: str,
                        type: 'warning'
                });
            }
        },
    }
</script>

<style scoped>

.bg {

    width: 500px;
    margin: 200px auto;

    text-align: left;
    
}

</style>