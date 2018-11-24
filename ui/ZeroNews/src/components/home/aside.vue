<template>
    <div class="bg">
        <img src="@/assets/logo2.png" width="90%" class="logo">
        <el-menu :default-active="1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" background-color="#2a5caa" text-color="#fff" active-text-color="#ffd04b">
            <el-menu-item :index="item.index" v-for="item of type" :key="item.index" @click="to(item.path)">
                <span slot="title">{{item.title}}</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        data() {
            return {
                role: {
                    user:[
                        {
                        index:1,
                        title:'我的主页',
                        path:'/home'
                        },
                        {
                        index:2,
                        title:'个人资料',
                        path:'/home/details'
                        },
                        {
                        index:3,
                        title:'我的关注',
                        path:'/home/love'
                        },
                        {
                        index:4,
                        title:'我的消息',
                        path:'/home/message'
                        },
                        {
                        index:5,
                        title:'申请加入',
                        path:'/home/join'
                        },
                        {
                        index:6,
                        title:'返回首页',
                        path:'/'
                        }
                    ],
                    editor: [
                        {
                        index:1,
                        title:'我的主页',
                        path:'/home'
                        },
                        {
                        index:2,
                        title:'个人资料',
                        path:'/home/details'
                        },
                        {
                        index:3,
                        title:'员工信息',
                        path:'/home/employee'
                        },
                        {
                        index:4,
                        title:'我的新闻',
                        path:'/home/news'
                        },
                        {
                        index:5,
                        title:'我的关注',
                        path:'/home/love'
                        },
                        {
                        index:6,
                        title:'我的消息',
                        path:'/home/message'
                        },
                        {
                        index:7,
                        title:'返回首页',
                        path:'/'
                        }
                    ],
                    chiefEditor: [
                        {
                        index:1,
                        title:'我的主页',
                        path:'/home'
                        },
                        {
                        index:2,
                        title:'个人资料',
                        path:'/home/details'
                        },
                        {
                        index:3,
                        title:'员工信息',
                        path:'/home/employee'
                        },
                        {
                        index:4,
                        title:'等待审核',
                        path:'/home/job'
                        },
                        {
                        index:5,
                        title:'我的关注',
                        path:'/home/love'
                        },
                        {
                        index:6,
                        title:'我的消息',
                        path:'/home/message'
                        },
                        {
                        index:7,
                        title:'返回首页',
                        path:'/'
                        }
                    ]
                },
                type:null,
            }
        },
        methods: {
            to(address) {
                this.$router.push(address)
            }
        },
        created() {
            var that = this
            http.get("/user/isLogin",function(data,status){
                if(status==true && data!=null) {
                    switch(data.type) {
                case 1:
                    that.type = that.role.user
                    break
                case 2:
                    that.type = that.role.editor
                    break
                case 3:
                    that.type = that.role.chiefEditor
                    break
            }
                }
            })
        }
    }
</script>

<style scoped>

.logo {
    margin-top: 50px;
    margin-bottom: 100px;
}

.el-menu-vertical-demo{
    border-right: none;
}

span {
    font-size: 20px;
}

</style>