<template>
    <div>
        <el-carousel indicator-position="outside" height="400px">
            <el-carousel-item v-for="(item,index) in car" :key="index">
            <img :src="item" height="100%">
            </el-carousel-item>
        </el-carousel>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                car: [
                    require("@/assets/car/c1.jpg"),
                    require("@/assets/car/c2.jpg"),
                    require("@/assets/car/c3.jpg"),
                    require("@/assets/car/c4.jpg"),
                ]
            }
        },
    }
</script>

<style scoped>


  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

</style>