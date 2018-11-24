<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/news' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>已发表</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Public/>
    </div>
</template>

<script>
    import Public from '@/components/news/public.vue';
    export default {
        name:'public',
        components:{
            Public,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}

</style>