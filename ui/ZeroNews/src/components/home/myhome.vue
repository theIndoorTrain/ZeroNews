<template>
    <div class="bg" :style="{background: 'url('+user.bg+')',backgroundSize: 'cover'}">

        <div class="logo">
            <img :src="user.image" width="300px" height="300px">
            <div>
                <span >{{user.username}}<i class="el-icon-star-off" v-if="isLove" @click="love(true)"></i><i class="el-icon-star-on" v-if="disLove" @click="love(false)"></i></span>
            </div>
        </div>

    </div>
</template>

<script>
    import http from "@/util/httpUtil"
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
            }
        },
        data() {
            return {
                key: null
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

</style>