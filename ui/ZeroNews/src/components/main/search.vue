<template>
    <div class="bg">
        <el-card>
            <div class="search">
                <el-input placeholder="请输入内容" v-model="input5" class="input-with-select">
                    <el-select v-model="select" slot="prepend" placeholder="请选择">
                    <el-option label="餐厅名" value="1"></el-option>
                    <el-option label="订单号" value="2"></el-option>
                    <el-option label="用户电话" value="3"></el-option>
                    </el-select>
                    <el-button slot="append" icon="el-icon-search"></el-button>
                </el-input>
                <h1>搜索结果</h1>
                <hr>
            </div>           
        </el-card>
    </div>
</template>

<script>
    export default {
        
    }
</script>

<style scoped>

.bg {
    width:90%;
    margin: 20px auto;
}

.search {
    padding: 20px 100px;
    height:500px;
    text-align: left;
}

</style>