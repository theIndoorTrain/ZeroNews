<template>
    <div class="xm">
        <div class="bg">
            <img src="@/assets/logo2.png" class="logo">
            <span v-text="Dtime">2018年11月12日 星期一</span>
            <div class="search">
                <el-input placeholder="请输入内容" v-model="input5" ><el-button slot="append">搜索</el-button></el-input>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        computed: {
            Dtime() {
                var date = new Date();
                var seperator2 = ":";
                var month = date.getMonth() + 1;
                var strDate = date.getDate();
                if (month >= 1 && month <= 9) {
                    month = "0" + month;
                }
                if (strDate >= 0 && strDate <= 9) {
                    strDate = "0" + strDate;
                }
                var a = new Array("日", "一", "二", "三", "四", "五", "六");
                var week = date.getDay()
                var currentdate = date.getFullYear() + "年" + month + "月" + strDate
                        + "日  星期" + a[week];
                return currentdate
            }
        },
    }
</script>

<style scoped>

.xm {
    width: 100%;
}


.bg {
    padding: 0 250px 0 250px;
    background-color: #DCDFE6;
}

.bg span {
    vertical-align: 40px;
    margin-left: 80px;
}

.logo {
    width:300px;
    margin-top: 3px;
    position: relative;
    left: -5%;
}

.search {
    float: right;
    margin: 33px;
    width: 300px;
}



</style>