<template>
    <div class="bg">
        <el-card shadow="always">
            <img :src="user.image"  class="logo">
            <div>
                <h1>{{user.username}}</h1>
                <h4>{{user.signature}}</h4>
                <table>
                    <tr>
                        <td><label>邮箱：</label></td>
                        <td><span>{{user.email}}</span></td>
                    </tr>
                    <tr>
                        <td><label>性别：</label></td>
                        <td><span v-if="user.gender">男</span><span v-if="!user.gender">女</span></td>
                    </tr>
                    <tr>
                        <td><label>年龄：</label></td>
                        <td><span>{{age}}</span></td>
                    </tr>
                </table>
            </div>
        </el-card>
    </div>
</template>

<script>
    import check from '@/util/checkUtil'
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                user: null,
            }
        },
        computed: {
            age() {
                if(check.isNull(this.user.birth)==true){
                    return "未知"
                }
                var strBirthday =  this.user.birth
                var returnAge;  
                var strBirthdayArr=strBirthday.split("-");  
                var birthYear = strBirthdayArr[0];  
                var birthMonth = strBirthdayArr[1];  
                var birthDay = strBirthdayArr[2];  

                var d = new Date();  
                var nowYear = d.getFullYear();  
                var nowMonth = d.getMonth() + 1;  
                var nowDay = d.getDate();  

                if(nowYear == birthYear)  
                {  
                    returnAge = 0;//同年 则为0岁  
                }  
                else  
                {  
                    var ageDiff = nowYear - birthYear ; //年之差  
                    if(ageDiff > 0)  
                    {  
                        if(nowMonth == birthMonth)  
                        {  
                            var dayDiff = nowDay - birthDay;//日之差  
                            if(dayDiff < 0)  
                            {  
                                returnAge = ageDiff - 1;  
                            }  
                            else  
                            {  
                                returnAge = ageDiff ;  
                            }  
                        }  
                        else  
                        {  
                            var monthDiff = nowMonth - birthMonth;//月之差  
                            if(monthDiff < 0)  
                            {  
                                returnAge = ageDiff - 1;  
                            }  
                            else  
                            {  
                                returnAge = ageDiff ;  
                            }  
                        }  
                    }  
                    else  
                    {  
                        returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天  
                    }  
                }  

                return returnAge;
            }
        },
        created() {
            var that = this
            http.get("/user/isLogin",function(data,status){
                if(status==true && data!=null) {
                    that.user = data
                }
            })
        }
        
    }
</script>

<style scoped>

.bg {
    width: 600px;
    margin: 30px auto;
}

.logo {
    width:100%;
    height:500px;
    border: 3px #303133 solid;
}

table {
    margin: 0 auto;
}

label{
    color: #606266;
}



</style>