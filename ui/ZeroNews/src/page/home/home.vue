<template>
    <div width="100%">
        <el-aside width="15%" class="aside">
            <Aside/>
        </el-aside>
        <el-container class="con">
            <el-main class="main"><router-view/>
            </el-main>
            <el-footer class="footer"><Footer/></el-footer>
        </el-container>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    import Aside from '@/components/home/aside.vue';
    import Footer from '@/components/home/footer.vue';
    export default {
        name:'home',
        components:{
            Aside,
            Footer,
        },
        created() {
            var that = this
            http.get("/user/isLogin",function(data,status){
                if(status!=true || data==null) {
                    that.$router.push("/login")
                }
            })
        }
    }
</script>

<style scoped>

.aside{
    border-right: 1px solid;
    height: 100%;
    position: fixed;
    background: #2a5caa;
}

.con{
    margin-left: 15%;
}

.footer{
    width: 85%;
    position: absolute;
    bottom: 0px;
    padding: 0;
}

.main{
    position: absolute;
    top:0px;
    bottom: 71px;
    width: 85%;
    margin: 0;
    padding: 0;
}

</style>