<template>
    <div class="bg">
        <el-menu :default-active="activeIndex" class="el-menu-demo header" mode="horizontal" @select="handleSelect">
            <el-menu-item index="1" @click="to('/')">首页</el-menu-item>
            <el-menu-item index="2" @click="to('/foreign')">国际</el-menu-item>
            <el-menu-item index="3" @click="to('/science')">科技</el-menu-item>
            <el-menu-item index="4" @click="to('/military')">军事</el-menu-item>
            <el-menu-item index="5" @click="to('/history')">历史</el-menu-item>
            <el-menu-item index="6" @click="to('/culture')">文化</el-menu-item>
            <el-menu-item index="7" @click="to('/entertainment')">娱乐</el-menu-item>
            <el-menu-item index="8" @click="to('/tourism')">旅游</el-menu-item>
            <el-menu-item index="9" @click="to('/education')">教育</el-menu-item>
            <el-menu-item index="10" @click="to('/other')">其他</el-menu-item>
            <el-button type="text" class="lab" v-if="isLogin" @click="logout">注销</el-button>
            <el-button type="text" class="lab" v-if="!isLogin" @click="to('/sighIn')">注册</el-button>
            <el-tooltip class="item" effect="light" content="个人中心" placement="bottom">
            <img :src="image" class="logo" v-if="isLogin" @click="to('/home')"/>
            </el-tooltip>
            <el-button type="text" class="lab" v-if="!isLogin" @click="to('/login')">登录</el-button>   
        </el-menu>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                activeIndex: '1',
                isLogin:false,
                image:null
            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            to(address) {
                this.$router.push(address)
            },
            logout() {
                var that = this
                http.get("/doLogout",function(data,status){
                    if(status==true) {
                        that.isLogin = false
                        that.image = null
                        that.$message({
                            message: '账号已注销登录！',
                            type: 'success'
                        });
                    }
                })
            }
        },
        created() {
            var that = this
            http.get("/user/isLogin",function(data,status){
                if(status==true && data!=null) {
                    that.isLogin = true
                    that.image = data.image
                }
            })
        }
    }
</script>

<style scoped>

.bg {
    width: 100%;
}

.header {
    padding: 0 150px 0 150px;
}



.lab {
    float: right;
    margin-right: 50px;
    margin-top: 10px;
}

.logo {
    margin-top: 3px;
    margin-right: 50px;
    float: right;
    height: 50px;
    width:50px;
    border-radius: 50%;
    border: 2px;
    border-style:solid;
    border-color: bisque;
}

.item {
    margin-right: 30px;
}


</style>