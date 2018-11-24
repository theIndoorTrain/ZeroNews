<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/news' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>未发布</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Save/>
    </div>
</template>

<script>
    import Save from '@/components/news/save.vue';
    export default {
        name:'save',
        components:{
            Save,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}

</style>