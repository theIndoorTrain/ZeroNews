<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/details' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>个人资料</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Details/>
    </div>
</template>

<script>
    import Details from '@/components/details/details.vue';
    export default {
        name:'mydetails',
        components:{
            Details,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}

</style>