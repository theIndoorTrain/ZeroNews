<template>
    <div class="bg">
        <table>
            <tr>
                <td @click="to('public')"><Card title="已发表" class="cardA" url="1.png" /></td>
                <td @click="to('auditing')"><Card title="审核中" class="cardB" url="4.png" /></td>
                <td @click="to('failure')"><Card title="审核失败" class="cardC" url="5.png" /></td>
            </tr>
            <tr>
                <td @click="to('save')"><Card title="未发布" class="cardD" url="6.png" /></td>
                <td @click="to('create')"><Card title="创建新的" class="cardE" url="7.png" /></td>
                <td></td>
            </tr>
        </table>
    </div>
</template>

<script>
    import Card from '@/components/details/card.vue';
    export default {
        methods: {
            to(address) {
                console.log(address)
                this.$router.push('/home/news/'+address)
            }
        },
        components:{
            Card,
        }
    }
</script>

<style scoped>

.bg {
    margin: 0 auto;
}

.cardA {
    background: #7d5886;
}

.cardB {
    background: #7fb80e;
}

.cardC {
    background: #ef4136;
}

.cardD {
    background: #ffc20e;
}

.cardE {
    background: #224b8f;
}

td {
    padding: 20px 30px;
}

table {
    margin: 100px auto;
}

</style>