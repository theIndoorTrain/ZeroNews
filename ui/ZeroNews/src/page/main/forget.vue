<template>
    <div class="bg">
        <Forget class="forget"/>
        <img src="@/assets/logo1.png" class="logo">
    </div>
</template>

<script>
    import Forget from '@/components/main/forget'
    export default {
        name:'forget',
        components:{
            Forget,
        }
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

.forget {
    position: absolute;
    height: 400px;
    right: 3%;
    top:50%;
    transform: translateY(-50%)
}

.logo {
    width:12%;
    position: absolute;
    left:12%;
}
</style>