<template>
    <div>
        <table>
            <tr>
                <td @click="to('news')"><Card title="新闻审核" class="cardA" url="8.png" /></td>
                <td @click="to('join')"><Card title="入职审核" class="cardB" url="9.png" /></td>
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
                this.$router.push('/home/job/'+address)
            }
        },
        components:{
            Card,
        }
    }
</script>

<style scoped>

.cardA {
    background: #224b8f;
}

.cardB {
    background: #7fb80e;
}

td {
    padding: 20px 50px;
}

table {
    margin: 300px auto;
}

</style>