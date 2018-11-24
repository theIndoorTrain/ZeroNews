<template>
    <div class="bg">
        <el-form  label-width="100px">
            <img src="@/assets/logo.png" class="logo"><h1>登陆</h1>
            <el-form-item label="邮箱">
                <el-input v-model="user.email"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="user.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="选择">
                <template>
                    <el-radio v-model="user.type" :label="1">用户</el-radio>
                    <el-radio v-model="user.type" :label="2">记者</el-radio>
                    <el-radio v-model="user.type" :label="3">主编</el-radio>
                </template>
            </el-form-item>
            <el-form-item>
                <el-button type="info" @click="doLogin">登陆</el-button>
                <el-button type="info" @click="to">忘记密码</el-button>
            </el-form-item>
            
        </el-form>
    </div>
</template>

<script>
    import check from '@/util/checkUtil'
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                user: {
                    type: 1,
                    email:'',
                    password:'',
                },
                //image: "static/logo.png"
            }
        },
        methods: {
            doLogin() {
                var str = '不能为空！'
                if(check.isNull(this.user.password)==true) {
                    this.msg('密码'+str,'warning')
                    return
                }
                if(check.isNull(this.user.email)==true) {
                    this.msg('邮箱'+str,'warning')
                    return
                }
                var that = this
                http.post('/doLogin',this.user,function(data,status){

                    if(status==true) {
                        if(data != null) {
                            that.msg('登陆成功','success')
                            that.$router.push("/")
                            return
                        }
                        that.msg('邮箱或密码、用户类型错误！','error')
                    }

                })
            },
            msg(str,type) {
                this.$message({
                        message: str,
                        type: type
                });
            },
            to() {
                this.$router.push("/forget")
            }
        },
        
    }
</script>

<style scoped>

.bg {
    width: 400px;
    background: #FFF;
    padding: 20px 50px 10px 0px;
}

.logo {
    width: 70px;
    position: absolute;
    top: 20px;
    left: 20px;
}

</style>