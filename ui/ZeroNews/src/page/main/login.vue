<template>
    <div class="bg">
        <Login class="login"/>
        <img src="@/assets/logo1.png" class="logo">
        <el-button type="text" class="button"  icon="el-icon-arrow-left" @click="goback">返回</el-button>
    </div>
</template>

<script>
    import Login from '@/components/main/login'
    export default {
        name:'login',
        components:{
            Login,
        },
        methods: {
            goback() {
                this.$router.go(-1)
            }
        },
    }
</script>

<style scoped>

.bg {
    background-image: url("../../assets/bg1.jpg");
    background-size: cover;
    width: 100%;
    height:100%;
    overflow: hidden;
    box-shadow:0 0 120px 80px rgba(255,255,255,.3) inset;
    position: absolute;
}

.login {
    position: absolute;
    height: 350px;
    right: 3%;
    top:50%;
    transform: translateY(-50%)
}

.button{
    position: absolute;
    font-size: 20px;
    color:whitesmoke;
    right: 50px;
}

.logo {
    width:12%;
    position: absolute;
    left:12%;
}
</style>