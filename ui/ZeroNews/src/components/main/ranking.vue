<template>
    <div>
        <el-card shadows="always">
            <h1>热度排行榜
                <el-table
                :data="ranking"
                style="width: 100%">
                <el-table-column
                    label="排行"
                    type="index"
                    width="50">
                </el-table-column>
                <el-table-column label="新闻标题">
                    <template slot-scope="scope">
                    <a :href="'/#/News?id='+scope.row.id" class="title">{{scope.row.title}}</a>
                    </template>
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
        },
        data() {
            return {
                ranking: null,
            }
        },
        methods: {
            getList() {
                var that = this
                http.get("/news/ranking/"+this.type,function(data,status){
                    if(status==true) {
                        if(data != null) {
                            that.ranking = data
                        }
                    }
                })
            }
        },
        created() {
            this.getList()
        }
    }
</script>

<style scoped>

.title {
  text-decoration: none;
  color: #303133;
}

</style>