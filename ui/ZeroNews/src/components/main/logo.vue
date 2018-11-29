<template>
    <div class="bg">

        <table>
            <tr>
                <td>
                    <img src="@/assets/logo2.png" class="logo">
                </td>
                <td>
                    <span v-text="Dtime"></span>
                </td>
                <td>
                    <el-input placeholder="请输入内容" v-model="input5" width="400px"><el-button slot="append">搜索</el-button></el-input>
                </td>
            </tr>
        </table>
            
            
            
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



.bg {
    background-color: #DCDFE6;
}

table{
    width: 100%;
    padding: 0 200px;
}

.logo {
    width:300px;
}

td {
    padding: 0 40px;
}






</style>