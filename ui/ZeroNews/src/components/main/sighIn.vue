<template>
    <div class="bg">
        <el-form  label-width="100px">
            <img src="@/assets/logo.png" class="logo"><h1>注册账号</h1>
            <el-form-item label="邮箱">
                <el-input type="email" v-model="user.email"></el-input>
            </el-form-item>
            <el-form-item label="验证码">
                <el-input v-model="user.code"><el-button slot="append" @click="getCode" :disabled="!isActive">验证邮箱</el-button></el-input>
            </el-form-item>
            <el-form-item label="新密码">
                <el-input type="password" v-model="user.password"></el-input>
            </el-form-item>
            <el-form-item label="重复密码">
                <el-input type="password" v-model="pass"></el-input>
            </el-form-item>
            <el-button type="info"  @click="submit">注册</el-button>
            
        </el-form>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    import check from '@/util/checkUtil'
    export default {
        data() {
            return {
                user: {
                    email:'',
                    code:'',
                    password:null,
                },
                pass:null,
                isActive:true,
            }
        },
        methods: {
            getCode() {
                var str = '不能为空！'
                if(check.isNull(this.user.email)==true) {
                    this.msg('邮箱'+str,'warning')
                    return
                }
                var that = this
                http.get("/sighIn/"+this.user.email,function(data,status){
                    if(status==true) {
                        if(data==true) {
                            that.isActive = false
                            that.msg("验证码已发送成功！","success")
                        } else {
                            that.msg("账户已存在，请登陆！","warning")
                            that.$router.push('/login')
                        }
                    }
                })

            },
            msg(str,type) {
                this.$message({
                        message: str,
                        type: type
                });
            },
            submit() {
                var str = '不能为空！'
                if(check.isNull(this.user.email)==true) {
                    this.msg('邮箱'+str,'warning')
                    return
                }
                if(check.isNull(this.user.password)==true) {
                    this.msg('新密码'+str,'warning')
                    return
                }
                if(check.isNull(this.user.code)==true) {
                    this.msg('验证码'+str,'warning')
                    return
                }
                if(check.empty(this.user.password,this.pass) != true) {
                    this.msg('重复密码与新密码不一致！','warning')
                    return
                }
                var that = this
                http.post("/submit",this.user,function(data,status){
                    if(status==true) {
                        if(data==true) {
                            that.msg('账号注册成功，请登录！','success')
                            that.$router.push('/login')
                        } else {
                            that.user.code=''
                            that.isActive = true
                            that.msg('验证码不正确，请重新获取！','error')
                        }
                    }
                })
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