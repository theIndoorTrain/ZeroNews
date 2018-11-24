<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/news' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>修改新闻</el-breadcrumb-item>
            </el-breadcrumb>
            <Create/>
        </div>
    </div>
</template>

<script>
    import Create from '@/components/news/create.vue';
    export default {
        name:"news_update",
        components:{
            Create,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}

</style>