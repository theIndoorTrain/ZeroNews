<template>
    <div class="bg">
        <el-steps :active="step" align-center>
            <el-step title="Step.1 创建" icon="el-icon-circle-plus-outline"></el-step>
            <el-step title="Step.2 编辑" icon="el-icon-edit"></el-step>
            <el-step title="Step.3 发布" icon="el-icon-upload"></el-step>
        </el-steps>
        <Add v-if="step==1" @change="chOne" :typeValue="news.type" :titleValue="news.title"/>
        <div v-if="step==1">
            <el-button-group>
                <el-button type="primary" icon="el-icon-arrow-left" disabled>上一页</el-button>
                <el-button type="primary" @click="stepTwo">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
            </el-button-group>
        </div>
        <Editor v-if="step==2" @input="chTwo"  :value="news.context" :imagesValue="news.images"/>
        <div v-if="step==2" class="button">
            <el-button-group>
                <el-button type="primary" icon="el-icon-arrow-left" @click="stepOne">上一页</el-button>
                <el-button type="primary" @click="stepThree">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
            </el-button-group>
        </div>
        <div class="upload" v-if="step==3">
            <h2>新闻已保存成功！请选择发布新闻！</h2>
        </div>
        <div v-show="true" class="button" v-if="step==3" >
            <el-button-group>
                <el-button type="primary" icon="el-icon-arrow-left" @click="stepTwo">上一页</el-button>
                <el-button type="primary" @click="update">发布</el-button>
                <el-button type="primary" disabled>下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
            </el-button-group>
        </div>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    import Add from '@/components/news/create/add'
    import Editor from '@/components/news/create/eeditor'
    export default {
        data() {
            return {
                step:1,
                news:{
                    title:null,
                    type:null,
                    context:null,
                    images:null,
                }
            }
        },
        methods: {
            chOne(title,type) {
                this.news.title=title
                this.news.type=type
            },
            chTwo(context,images) {
                this.news.context=context
                this.news.images=images
            },
            stepTwo(){
                this.step=2
            },
            stepOne() {
                this.step=1
            },
            stepThree(){
                var that = this
                if(this.news.id==null || this.news.id.length==0) {
                    http.post("/news/create",this.news,function(data,status){
                        if(status==true) {
                            if(data != null) {
                                that.news=data
                                that.$message.success="新闻保存成功"
                                that.id = data.id
                                that.step=3
                            } 
                        }else {
                            that.$message.error="网络拥挤，请稍后重试"
                        }
                    })
                } else {
                    http.put("/news/update",this.news,function(data,status){
                        if(status==true) {
                            that.$message.success="新闻保存成功"
                            that.step=3
                        } else {
                            that.$message.error="网络拥挤，请稍后重试"
                        }
                    })
                }
            },
            update() {
                var that = this
                http.put("/news/pull",this.news,function(data,status){
                        if(status==true) {
                            that.$message.success="新闻发布成功"
                        } else {
                            that.$message.error="网络拥挤，请稍后重试"
                        }
                })
            }
        },
        created() {
            var id = this.$route.query.id
            var that = this
            if(id != null ) {
                http.get("/news/"+id,function(data,status){
                    if(status ==true) {
                        if(data != null) {
                            that.news = data
                        }
                    }
                })
            }
        },
        components:{
            Add,
            Editor,
        }
    }
</script>

<style scoped>

.bg {
    width:90%;
    margin: 20px auto;
}

.upload {
    margin: 200px auto 100px;
}


</style>
