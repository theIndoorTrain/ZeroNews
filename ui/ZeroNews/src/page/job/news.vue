<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/job' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>新闻审核</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <News/>
    </div>
</template>

<script>
    import News from '@/components/job/news.vue';
    export default {
        name:'job_news',
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