<template>
    <div>
        <div class="breadcrumb">
            <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/home/love' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>关注编辑</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <Editor/>
    </div>
</template>

<script>
    import Editor from '@/components/love/editor.vue';
    export default {
        name:"love_details",
        components:{
            Editor,
        }
    }
</script>

<style scoped>

.breadcrumb {
    margin: 20px 50px;
}


</style>