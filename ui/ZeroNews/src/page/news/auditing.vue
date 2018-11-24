<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/news' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>审核中</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Auditing/>
    </div>
</template>

<script>
    import Auditing from '@/components/news/auditing.vue';
    export default {
        name:'auditing',
        components:{
            Auditing,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}

</style>