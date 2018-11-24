<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/details' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>修改密码</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <UpPass/>
    </div>
</template>

<script>
    import UpPass from '@/components/details/upPass.vue';
    export default {
        name:'upPass',
        components:{
            UpPass
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}
</style>