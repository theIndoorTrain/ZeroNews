<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/news' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>审核失败</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Failure/>
    </div>
</template>

<script>
    import Failure from '@/components/news/failure.vue';
    export default {
        name:'failure',
        components:{
            Failure,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}

</style>