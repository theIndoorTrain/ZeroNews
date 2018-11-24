<template>
    <div class="bg">
        <el-card shadows="always">
            <h1>欢迎加入零点新闻大家庭！</h1>
            <h3>请完善个人信息</h3>
            <div class="form">
                <el-form  label-width="80px">
                    <el-form-item label="真实姓名">
                        <el-input v-model="emp.name"></el-input>
                    </el-form-item>
                    <el-form-item label="联系电话">
                        <el-input  v-model="emp.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="现住地址">
                        <el-input  v-model="emp.address"></el-input>
                    </el-form-item>
                    <el-form-item label="申请职位">
                        <el-select v-model="emp.type" clearable placeholder="请选择职位">
                            <el-option
                            v-for="item in types"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-card class="text">
                        <h1>入职协议：</h1>
                        <p>
                            一、为申请并使用零点新闻信息科技有限公司（以下简称“零点新闻”）提供的中国互联网新闻媒体发布平台（以下简称“新闻发布平台”），申请者同意并接受本协议内容。<br>
二、服务内容<br>
2.1 新闻发布平台提供的具体服务内容由零点新闻根据实际情况提供，如网站用户统计数据、软件用户统计数据、广告投放媒介计划等。<br>
2.2 零点新闻提供新闻发布平台，除此之外与本新闻发布平台有关的设备（如个人电脑、手机、及其他与接入互联网或移动网有关的装置）及所需的费用（如为接入互联网而支付的电话费及上网费、为使用移动网而支付的手机费）均应由申请者自行负担。<br>
三、服务变更、中断或终止<br>
3.1 零点新闻需要定期或不定期地对新闻发布平台及相关的设备、系统进行检修或者维护，如因此类情况而造成新闻发布平台在合理时间内的中断，零点新闻无需为此承担任何责任，但应尽可能事先进行通告。<br>
3.2 如发生下列任何一种情形，零点新闻有权随时中断或终止向申请者提供本协议项下的系统服务而无需对用户或任何第三方承担任何责任：<br>
3.2.1 申请者提供的注册信息、资料不真实、不准确、不完整；<br>
3.2.2 申请者冒用他人名义使用本新闻发布平台；<br>
3.2.3 申请者违反本协议中规定的使用规则。<br>
四、使用规则<br>
4.1 申请者应确保在申请时提供真实有效的信息，如属冒用他人名义申请、使用账号的，应承担因此产生的一切法律责任。<br>
4.2 申请者不应将其账号、密码转让或出借予他人使用。如申请者发现其账号遭他人非法使用，应立即通知零点新闻。因黑客行为或申请者的保管疏忽导致账号、密码遭他人非法使用，零点新闻不承担任何责任。<br>
4.3 申请者在使用新闻发布平台过程中，必须遵循以下原则：<br>
4.3.1 遵守中国有关的法律和法规；<br>
4.3.2 不得为任何非法目的使用本新闻发布平台；<br>
4.3.3 不得利用本新闻发布平台进行任何可能对互联网或移动网正常运行造成不利影响的行为；<br>
4.3.4 不得利用本新闻发布平台上传、展示或传播任何非法的信息资料；<br>
4.3.5 不得侵犯其他任何第三方的专利权、著作权、商标权、名誉权或其他任何合法权益。<br>
4.4 零点新闻有权对新闻发布平台的使用情况进行审查和监督，如申请者在使用时违反任何上述规定，零点新闻有权要求申请者改正或直接采取一切必要的措施（包括但不限于暂停或终止申请者使用新闻发布平台的权利）以减轻不当行为造成的影响。<br>
4.5 零点新闻针对某些特定的系统服务的使用通过各种方式（包括但不限于网页公告、电子邮件、短信提醒等）做出的任何声明、通知、警示等内容视为本协议的一部分，申请者如使用该服务，视为用户同意该声明、通知、警示的内容。<br>
五、知识产权<br>
5.1 新闻发布平台中包含的任何文本、标识、图形均受知识产权法律的保护，未经零点新闻同意，上述资料均不得在没有注明出处的前提下在任何媒体直接或间接发布、播放，也不得出于播放或发布目的而改写或再发行，或者被用于其他任何商业目的。<br>
5.2 新闻发布平台涉及使用的任何软件、系统的一切权利均属于该软件的著作权人，未经该软件的著作权人许可，申请者不得对该软件进行反向工程、反向编译或反汇编。<br>
六、免责声明<br>
6.1 中国互联网新闻发布平台的样本均来自网民自愿参与，数据仅用于研究网民总体行为；<br>
6.2 中国互联网新闻发布平台所公布的数据是通过计算机程序自动计算得出的结果，不带有任何形式的主观推论；<br>
6.3 零点新闻保留对中国互联网新闻发布平台进行调整或改进的权利，包括但不限于平台功能及算法；<br>
6.4 使用者可以合法引用中国互联网新闻发布平台中的数据，并注明出处。但其在数据基础上所做的任何判断、推论或观点，均不代表零点新闻的立场；<br>
6.5 中国互联网新闻发布平台所公布的数据仅供参考，零点新闻不承担因使用本网站数据而产生的法律责任；<br>
6.6 使用者明确同意其使用新闻发布平台所存在的风险及产生的后果将完全由其自己承担；<br>
6.7 对于因不可抗力或零点新闻不能控制的原因造成的服务中断或其它缺陷，零点新闻不承担任何责任，但将尽力减少因此而给用户造成的损失和影响。<br>
七、违约赔偿<br>
7.1 如因零点新闻违反有关法律、法规或本协议项下的任何条款而给申请者造成损失，零点新闻同意承担由此造成的直接经济损害赔偿，赔偿限额为人民币贰万元整。<br>
7.2 申请者同意保障和维护零点新闻及其他用户的利益，如因申请者违反有关法律、法规或本协议项下的任何条款而给零点新闻或任何其他第三人造成损失，申请者同意承担由此造成的损害赔偿责任。<br>
八、协议修改<br>
8.1 零点新闻有权随时修改本协议的任何条款，一旦本协议的内容发生变动，将会直接在网站上公布修改之后的协议内容，该公布行为视为已经通知申请者修改内容。零点新闻也可通过其他适当方式向申请者提示修改内容。<br>
8.2 如果申请者不同意零点新闻对本协议相关条款所做的修改，申请者有权停止使用新闻发布平台。如果继续使用，则视为接受零点新闻对本协议相关条款所做的修改。<br>
九、本协议的各项条款具有独立性，其中任何条款的无效，并不影响其它条款的效力。因本协议产生的争议，任何一方均可提交中国国际经济贸易仲裁委员会仲裁解决，仲裁裁决对双方均具有约束力。<br>
十、申请者同意本协议及免责声明之效力如同申请者亲自签字、盖章的书面条款一样，对申请者具有法律约束力。
                        </p>
                        <template>
                            <el-radio v-model="radio" :label="1">同意</el-radio>
                            <el-radio v-model="radio" :label="2">不同意</el-radio>
                        </template>
                    </el-card>
                    <el-form-item>
                        <el-button type="info" v-if="status==0" :disabled="dis" @click="createEmp">提交申请</el-button>
                        <el-button type="info" v-if="status==2" :disabled="dis" @click="upEmp">重新申请</el-button>
                        <el-button type="info" disabled v-if="status==1">等待申请</el-button>
                        <el-button type="info" v-if="status==3" @click="active">前往激活</el-button>
                    </el-form-item>
                    
                </el-form>
            </div>
            <img src="@/assets/logo2.png" width="20%" class="logo">
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                emp:{
                    type:null,
                    name:null,
                    phone:null,
                    address:null
                },
                status:0,
                radio:2,
                types:[
                    {
                        value:true,
                        label:"编辑",
                    },
                    {
                        value:false,
                        label:"主编",
                    }
                ]
            }
        },
        computed: {
            dis() {
                return this.radio==2?true:false 
            }
        },
        methods: {
            createEmp() {
                var that = this
                http.post("/emp/create",this.emp,function(data,status){
                    if(status==true) {
                        if(data!=null) {
                            that.emp = data
                            that.status=1
                            that.$message.success('申请提交成功！')
                        } else{
                            that.$message.error('网络拥挤，请重试！');
                        }
                    }
                })
            },
            upEmp() {
                this.status=1
                this.emp.status=1
                var that = this
                http.put("/emp/update",this.emp,function(data,status){
                    if(status==true) {
                        that.$message.success('申请提交成功！')
                         
                    }else{
                        that.$message.error('网络拥挤，请重试！');
                    }
                })
            },
            active() {
                var that = this
                http.put("/emp/update",this.emp,function(data,status){
                    if(status==true) {
                        
                        that.$message.success('激活成功，请登陆！')
                        that.$router.push("/login") 
                    }else{
                            that.$message.error('网络拥挤，请重试！');
                    }
                })

            }
        }, 
        created() {
            var that = this
            http.get("/emp/get",function(data,status) {
                if(status==true) {
                    if(data != null) {
                        that.emp = data
                        that.status = data.status%4
                    }
                }
            })
        }  
    }
</script>

<style scoped>

.bg{
    width:800px;
    margin: 30px auto;
}

.form {
    width:600px;
    margin: 30px auto;
    text-align: left;
}

.text {
    height:400px;
    overflow-y:auto;
    margin-left: 80px;
    margin-bottom: 20px;
}

</style>