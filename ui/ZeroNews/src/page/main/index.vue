<template>
    <div>
        <Logo/>
        <Header/>
        <router-view></router-view>
        <Footers/>
    </div>
</template>

<script>
    import Header from '@/components/main/header.vue';
    import Logo from '@/components/main/logo.vue';
    import Footers from '@/components/home/footer'
    export default {
        name:'index',
        components:{
            Header,
            Logo,
            Footers,
        }
    }
</script>

<style scoped>


</style>