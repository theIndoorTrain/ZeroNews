<template>
    <div class="bg">
        <h2>修改资料</h2>
        <el-card shadow="always">
            <el-form  label-width="80px">
            <el-form-item label="上传头像">
                <el-upload
                    class="avatar-uploader"
                    action="/api/upload/head"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload">
                    <img v-if="user.image" :src="user.image" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
            </el-form-item>
            <el-form-item label="昵称">
                <el-input v-model="user.username"></el-input>
            </el-form-item>
            <el-form-item label="生日">
                <el-date-picker v-model="user.birth" type="date" placeholder="选择日期"></el-date-picker>
            </el-form-item>
            <el-form-item label="性别">
                <template>
                    <el-radio v-model="user.gender" :label="true">男</el-radio>
                    <el-radio v-model="user.gender" :label="false">女</el-radio>
                </template>
            </el-form-item>
            <el-form-item label="个性签名">
                <el-input type="textarea" :autosize="{ minRows: 3, maxRows: 5}" placeholder="说点什么吧" v-model="user.signature"/>
            </el-form-item>
            <el-form-item>
                <el-button type="info" @click="save">保存</el-button>
            </el-form-item>
            
        </el-form>
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                user: null
            }
        },
        methods: {
            save() {
                var that = this
                http.put("/user/update",this.user,function(data,status) {
                    if(status==true) {
                        that.$message.success('个人资料修改成功！');
                    } else {
                        that.$message.error('网络拥挤，请重试！');
                    }
                })
            },
            handleAvatarSuccess(res, file) {
                this.user.image = file.response;
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
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
    width: 800px;
    margin: 30px auto;
    text-align: left;
}

.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }

</style>