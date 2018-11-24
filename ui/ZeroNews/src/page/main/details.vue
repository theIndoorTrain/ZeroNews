<template>
    <div>
        <Myhome :user="user" :isLove="isLove" :disLove="disLove"/>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    import Myhome from "@/components/home/myhome"
    export default {
        name:"details",
        data() {
            return {
                    user: null,
                    isLove: false,
                    disLove: false,
                }
        },
        methods: {
            getUser(id) {
                var that = this
                http.get("/love/"+id,function(data,status) {
                    if(status == true) {
                        if(data != null) {
                            that.user = data
                            if(that.user.love == null) {
                                that.isLove = true
                            } else {
                                if(that.user.love.isLove == true) {
                                that.disLove = true
                                } else {
                                    that.isLove = true
                                }
                            }
                        }
                    }
                })
            }
        },
        created() {
            var id = this.$route.query.id
            this.getUser(id)
        },
        components:{
            Myhome,
        }
    }
</script>

<style scoped>

</style>