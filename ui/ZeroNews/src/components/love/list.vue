<template>
    <div>
        <table>
            <tr>
                <td @click="to('news')"><Card title="关注新闻" class="cardA" url="8.png" /></td>
                <td @click="to('editor')"><Card title="关注编辑" class="cardB" url="9.png" /></td>
            </tr>
        </table>
    </div>
</template>

<script>
    import Card from '@/components/details/card.vue';
    export default {
        methods: {
            to(address) {
                this.$router.push('/home/love/'+address)
            }
        },
        components:{
            Card,
        }
    }
</script>

<style scoped>

.cardA {
    background: #67C23A;
}

.cardB {
    background: #E6A23C;
}

td {
    padding: 20px 50px;
}

table {
    margin: 300px auto;
}

</style>