<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/job' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>入职审核</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Join/>
    </div>
</template>

<script>
    import Join from '@/components/job/join.vue';
    export default {
        name:'job_join',
        components:{
            Join,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}

</style>