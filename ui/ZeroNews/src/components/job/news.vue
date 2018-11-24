<template>
    <div class="bg" v-loading.fullscreen.lock="fullscreenLoading">
        <el-card shadows="always">
            <div class="news">
                    <h1 v-text="news.title"></h1>
                    <div v-html="news.context">

                    </div>
                </div>
            <div class="form">
                <el-form  label-width="100px">
                        <el-form-item label="审核">
                            <template>
                                <el-radio v-model="audit.isAgree" :label="true">通过</el-radio>
                                <el-radio v-model="audit.isAgree" :label="false">不通过</el-radio>
                                </template>
                        </el-form-item>
                        <el-form-item>
                            <el-input
                                type="textarea"
                                :rows="2"
                                placeholder="请输入指导意见"
                                v-model="audit.reply">
                            </el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="info" @click="submit">下一篇</el-button>
                        </el-form-item>
                        
                        
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                fullscreenLoading:false,
                news: null,
                audit:{
                    reply:null,
                    isAgree:true,
                }
            }
        },
        methods: {
            getNews() {
                var that = this
                http.get("/audit/getNews",function(data,status){
                    if(status == true) {
                        if(data != null) {
                            that.news = data
                        } 
                    }
                    else {
                            that.$router.push("/home/job")
                            that.$message.success("暂时没有工作了。可以去浪了。。。。。。")
                    }
                    that.fullscreenLoading=false
                })
            },
            submit() {
                var that = this
                this.fullscreenLoading=true
                this.audit.newsId = this.news.id
                http.put("/audit/news",this.audit,function(data,status){
                    that.getNews()
                })
            }
        },
        created() {
            this.fullscreenLoading=false
            this.getNews()
        }
    }
</script>

<style scoped>

.bg {
    width: 1000px;
    margin: 30px auto;
    text-align: left;
}

.form {
    width:60%;
    margin: 20px auto;
    text-align: left;
}

.news{
    margin: 20px 50px;
}

</style>