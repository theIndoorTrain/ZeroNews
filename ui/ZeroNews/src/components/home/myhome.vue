<template>
    <div class="bg" :style="{background: 'url('+user.bg+')',backgroundSize: 'cover'}">

        <div class="logo">
            <img :src="user.image" width="300px" height="300px">
            <div>
                <span >{{user.username}}<i class="el-icon-star-off" v-if="isLove" @click="love(true)"></i><i class="el-icon-star-on" v-if="disLove" @click="love(false)"></i></span>
            </div>
        </div>

        <div class="up" v-if="isMe">
            <el-upload
            class="avatar-uploader"
            action="http://localhost:8080/upload/bg"
            :headers="headers"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <el-button type="warning" icon="el-icon-upload" circle></el-button>
            </el-upload>
        </div>

    </div>
</template>

<script>
    import http from "@/util/httpUtil"
    import doCookie from '@/util/cookieUtil'
    export default {
        props: {
            user: {
                type:Object,
            },
            isLove:{
                type:Boolean,
                default:false,
            },
            disLove:{
                type:Boolean,
                default:false,
            },
            isMe:{
                type:Boolean,
                default:false,
            }
        },
        data() {
            return {
                key: null,
                headers:{
                    Authorization:doCookie.getCookie("SESSIONID")
                }
            }
        },
        methods: {
            love(isLove) {
                var love ={
                    editorId : this.user.id,
                    isLove : isLove
                }
                var that = this
                http.post("/love/update",love,function(data,status){
                    if(status==true){
                        if(isLove == true) {
                            that.isLove = false
                            that.disLove = true
                        } else {
                            that.isLove = true
                            that.disLove = false
                        }
                    }
                })
            },
            handleAvatarSuccess(res, file) {
                this.user.bg = file.response;
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 4;

                if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 4MB!');
                }
                return isJPG && isLt2M;
            }
        },
        created() {
        }
    }
</script>

<style scoped>

.bg {
    /* background-image: url(""); 
    background-size: cover;*/
    width: 100%;
    height:100%;
    overflow: hidden;
    box-shadow:0 0 120px 80px rgba(255,255,255,.3) inset;
    position: absolute;
}

.logo {
    position: absolute;
    bottom: 5%;
    right: 8%;
}
.logo img {
    border: 5px solid whitesmoke;
}
.logo div {
    text-align: center;
}
span {
    font-size: 30px;
    color: beige;
}

i {
    margin-left: 30px;
}

.up {
    position: absolute;
    right: 50px;
    top:30px;
}

</style>