<template>
    <div class="bg">
        <table>
            <tr height="150px">
                <td @click="to('mydetails')">
                    <Card title="查看资料" url="1.png" class="cardA" />
                </td>
                <td @click="to('update')">
                    <Card title="修改资料" url="2.png" class="cardB" />
                </td>
                <td @click="to('upPass')">
                    <Card title="修改密码" url="3.png" class="cardC" />
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
    import Card from '@/components/details/card.vue';
    export default {
        methods: {
            to(address) {
                this.$router.push('/home/details/'+address)
            }
        },
        components:{
            Card,
        }
        
    }
</script>

<style scoped>

.cardA {
    background: #ef4136;
}

.cardB {
    background: #f58220;
}

.cardC {
    background: #6f60aa;
}

.bg {
    margin: 0 auto;
}

td {
    padding: 0 20px;
}

table {
    margin: 300px auto;
    width:974px;
}


</style>