<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/love' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>关注新闻</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <News/>
    </div>
</template>

<script>
    import News from '@/components/love/news.vue';
    export default {
        name:"love_news",
        components:{
            News,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}


</style>