<template>
    <div class="bg">
        <Car/>
        <el-row :gutter="20">
        <el-col :span="18"><div class="grid-content bg-purple"><NewsTable :type="type"/></div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple"><Ranking :type="type"/></div></el-col>
        </el-row>
    </div>
</template>

<script>
    import Car from '@/components/main/carousel.vue';
    import NewsTable from '@/components/main/newsTable.vue';
    import Ranking from "@/components/main/ranking"
    export default {
        props: {
            type: {
                type: Number,
                default: 0
            },
        },
        components:{
            Car,
            NewsTable,
            Ranking,
        }
    }
</script>

<style scoped>

.bg {
    margin: 20px 180px;
}

</style>