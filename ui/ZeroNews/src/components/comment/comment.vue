<template>
    <div>
        <div class="comment" v-for="comment in page.records" :key="comment.id">
            <img :src="comment.user.image" class="logo">
            <div class="userInfo">
                <span v-text="comment.user.username"> </span><span v-text="comment.createTime.replace('T',' ')"> 2018-10-15 </span><el-tooltip content="回复" placement="right-start"><i class="el-icon-edit-outline" @click="subReply(comment)"></i></el-tooltip><br>
                <p><span>评论：{{comment.context}}</span></p>
            </div>
            <Reply class="reply" v-for="reply in comment.replyList" :key="reply.id" :reply="reply" @subReply="subChildReply"/>
            <br>
            <hr>
        </div>
        <el-pagination background style="text-align:center" layout="prev, pager, next" @current-change="currentChange" :total="page.total" :page-size="page.size" :current-page="page.current" class="page"></el-pagination>
    </div>
</template>

<script>
    import Reply from "@/components/comment/reply"
    import http from '@/util/httpUtil'
    import check from '@/util/checkUtil'
    export default {
        data() {
            return {
                page:null,
            }
        },
        components:{
            Reply,
        },
        methods: {
            getPage(pageInfo) {
                var that = this
                http.post("/comment/page",pageInfo,function(data,status) {
                    if(status == true) {
                        if(data != null) {
                            that.page = data
                        }
                    }
                })
            },
            subChildReply() {
                var id=this.$route.query.id
                var pageInfo={
                    current:1,
                    size:15,
                    newsId:id,
                }
                this.getPage(pageInfo)
            },
            subReply(comment) {
                var that = this
                this.$prompt('请输入回复', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                }).then(({ value }) => {
                if(check.isNull(value) == true) {
                    this.$message.warning("回复内容不可为空！")
                    return
                }
                var reply ={
                    commentId:comment.id,
                    replyUserId:comment.user.id,
                    context:value
                }
                http.post("/reply/create",reply,function(data,status){
                    if(status==true) {
                        that.$message({
                            type: 'success',
                            message: "回复提交成功！"
                        });
                        var id=that.$route.query.id
                        var pageInfo={
                            current:1,
                            size:15,
                            newsId:id,
                        }
                        that.getPage(pageInfo)
                    } else {
                        that.$router.push("/login")
                    }
                })
                }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '取消输入'
                });       
                });
            }
        },
        created() {
            var id=this.$route.query.id
            var pageInfo={
                current:1,
                size:15,
                newsId:id,
            }
            this.getPage(pageInfo)
        }
    }
</script>

<style scoped>

.comment{
    position: relative;
    width:90%;
}

.userInfo {
    position: absolute;
    top:10px;
    left:70px;
}

.userInfo p {
    margin: 0;
    padding: 0;
}

.logo{
    height: 55px;
    width:55px;
    border-radius: 50%;
    border: 1px;
    border-style:solid;
    border-color: bisque;
}

.reply {
    margin-left: 50px;
}

</style>