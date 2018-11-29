<template>
    <div>
        <el-card shadows="always">
            <h1>热度排行榜
                <el-table
                :data="ranking"
                style="width: 100%">
                <el-table-column
                    prop=""
                    label="编号"
                    width="50">
                </el-table-column>
                <el-table-column
                    prop="title"
                    label="新闻标题">
                </el-table-column>
                </el-table>
            </h1>
        </el-card>
    </div>
</template>

<script>
    import http from '@/util/httpUtil'
    export default {
        props: {
        type: {
          type: Number,
          default: 0
        },
        data() {
            return {
                ranking: null,
            }
        },
        methods: {
            getList(type) {
                var that = this
                http.get("/news/ranking/"+type,function(data,status){
                    if(status==true) {
                        if(data != null) {
                            that.ranking = data
                        }
                    }
                })
            }
        },
        created() {
            this.getList(this.type)
        }
      },
    }
</script>

<style scoped>

</style>