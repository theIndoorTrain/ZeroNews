<template>
    <div>
    <div class="bg">
        <img :src="reply.user.image" class="logo">
            <div class="userInfo">
                <span v-text="reply.user.username"> </span><span v-text="reply.createTime.replace('T',' ')"></span><el-tooltip content="回复" placement="right-start"><i class="el-icon-edit-outline" @click="subReply(reply)"></i></el-tooltip><br>
                <p><span>回复 </span><span v-text="reply.replyUser.username"></span>: {{reply.context}}</p>
        </div>
    </div>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    import check from '@/util/checkUtil'
    export default {
        props: {
            reply: {
                type: Object,
                default: null
            },
        },
        data() {
            return {
                image: "static/upload/5/head.jpg",
                name:"零度微笑"
            }
        },
        methods: {
            subReply(replys) {
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
                    commentId:replys.commentId,
                    replyUserId:replys.userId,
                    context:value
                }
                http.post("/reply/create",reply,function(data,status){
                    if(status==true) {
                        that.$emit('subReply')
                        that.$message({
                            type: 'success',
                            message: "回复提交成功！"
                        });
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
        }
    }
</script>

<style scoped>

.bg {
    position: relative;
    background: #EBEEF5;
    padding: 5px 20px;
}

.userInfo {
    position: absolute;
    top:5px;
    left:70px;
}

.userInfo p {
    margin: 0;
    padding: 0;
}

.logo{
    height: 45px;
    width:45px;
    border-radius: 50%;
    border: 1px;
    border-style:solid;
    border-color: bisque;
}

</style>