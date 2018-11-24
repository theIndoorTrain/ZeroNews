<template>
    <el-card shadows="allways" class="bg">
        <img :src="src" width="60%">
        <span>{{title}}</span>
    </el-card>
</template>

<script>
    export default {
        data() {
            return {
                src: require('@/assets/lab/'+this.url)
            }
        },
        props:{
            title: String,
            url: String
        }
    }
</script>

<style scoped>

.bg {
    width:280px;
    padding:20px 0;
    color: aliceblue;
}


</style>