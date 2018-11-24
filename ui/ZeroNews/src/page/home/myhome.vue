<template>
    <div>
        <Myhome :user="user"/>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    import Myhome from '@/components/home/myhome.vue';
    export default {
        name:'myhome',
        data() {
            return {
                user: null,
            }
        },
        components:{
            Myhome,
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

</style>