<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/details' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>修改资料</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Update/>
    </div>
</template>

<script>
    import Update from '@/components/details/update.vue';
    export default {
        name:'update_deatails',
        components:{
            Update,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}
</style>