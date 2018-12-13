<template>
    <div>
        <el-card shadows="always" class="bg">
            <el-button type="text" class="gobutton"  icon="el-icon-arrow-left" @click="goback">返回</el-button>
            <div class="title">
                <h1>{{news.title}}</h1>
                <hr>
                <div class="head">
                    <a :href="'/#/details?id='+news.userId">
                        <el-tooltip content="作者" placement="left-start">
                            <img :src="news.user.image" class="logo">
                        </el-tooltip>
                    </a>
                    <div class="userInfo">
                        <span>编辑：{{news.user.username}}</span><br>
                        <span v-if="news.status==5">{{news.pullTime.replace("T"," ")}}</span>
                        <span v-if="news.status!=5">{{news.createTime.replace("T"," ")}}</span>
                    </div>
                </div>
            </div>
            <div class="news">
                <p>原标题：{{news.title}}</p>
                <div v-html="news.context">

                </div>
            </div>
            <div class="foot">
                <h3>- THE END -</h3>
                <p>免责声明：本文来自零点新闻客户端自媒体，不代表零点网的观点和立场。</p>
                <div>
                    <el-tooltip content="点赞" placement="right-start">
                    <svg class="icon zan" aria-hidden="true" v-if="!zan" @click="dianZan">
                        <use xlink:href="#icon-zan"></use>
                    </svg>
                    
                    <svg class="icon zan active" aria-hidden="true" v-if="zan">
                        <use xlink:href="#icon-zan"></use>
                    </svg>
                    </el-tooltip>
                    <h3>赞</h3>
                </div>
                <br>
                <hr>
            </div>
            <div class="comment">
                <h1>发表评论</h1>
                <div class="button">
                    <el-button type="primary" @click="subComment">提交</el-button>
                </div>
                <el-input
                    type="textarea"
                    :rows="3"
                    placeholder="请输入内容"
                    v-model="context">
                </el-input>
                <h1>全部评论</h1>
                <hr>
                <Comment ref="comment"/>
            </div>
        </el-card>
    </div>
</template>

<script>
    import "@/fonticon/iconfont.js"
    import Comment from "@/components/comment/comment"
    import http from '@/util/httpUtil'
    import check from '@/util/checkUtil'
    export default {
        data() {
            return {
                news: null,
                zan:false,
                context:null,
            }
        },
        methods: {
            dianZan() {
                var that = this
                http.post("/zan/"+this.news.id,null,function(data,status){
                    if(status == true) {
                        that.zan = true
                        that.$message.success("点赞+1！")
                    } else {
                        that.$router.push("/login")
                    }
                })
            },
            getZan() {
                var that = this
                http.get("/zan/"+this.news.id,function(data,status){
                    if(status==true) {
                        that.zan = data
                    }
                })
            },
            goback() {
                this.$router.go(-1)
            },
            subComment() {
                if(check.isNull(this.context)== true) {
                    this.$message.warning("评论内容不可为空！")
                    return
                }
                var comment ={
                    context:this.context,
                    newsId:this.news.id
                }
                var that = this
                http.post("/comment/create",comment,function(data,status) {
                    if(status == true) {
                        var pageInfo={
                            current:1,
                            size:15,
                            newsId:that.news.id,
                        }
                        that.$refs.comment.getPage(pageInfo)
                        that.context = null
                        that.$message.success("评论提交成功！")
                    } else {
                        that.$router.push("/login")
                    }
                })
            },
            changeValue(data) {
                this.$emit('value',data)
            },
            getNews() {
                var id=this.$route.query.id
                var that = this
                http.get("/news/"+id,function(data,status){
                    if(status==true) {
                        if(data != null) {
                            that.news = data
                            that.getZan()
                            that.changeValue(data)
                        }
                    }
                })
            }
        },
        created() {
            this.getNews()
        },
        components:{
            Comment,
        }
    }
</script>

<style scoped>

.bg {
    width: 1000px;
    margin: 20px auto;
    padding: 0 20px;
    text-align: left;
}

.title h1 {
    font-size: 40px;
    color: #303133;
}

.logo{
    height: 55px;
    width:55px;
    border-radius: 50%;
    border: 1px;
    border-style:solid;
    border-color: bisque;
}

.head{
    position: relative;
}

.news {
    margin-left: 20px;
}

.foot{
    text-align: center;
}

.userInfo {
    position: absolute;
    top:10px;
    left:70px;
}

.comment{
    position: relative;
}

.button {
    position: absolute;
    right: 20px;
    top:0px;
}

.zan {
    margin-top: 20px;
    font-size: 50px;
    border-radius: 50%;
    border: 1px;
    border-style:solid;
    border-color: black; 
    padding: 10px;
}

.active {
    background-color: #409EFF;
    color:aliceblue;
}

</style>