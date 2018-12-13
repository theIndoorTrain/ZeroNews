<template>
    <div class="bg">
        <el-form  label-width="100px">
            <el-form-item label="新闻标题">
                <el-input  v-model="titleValue"></el-input>
            </el-form-item>
            <el-form-item label="类型">
                <el-select v-model="typeValue" @change="change" clearable placeholder="请选择新闻类型">
                    <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        props: {
            titleValue: {
                type: String
            },
            typeValue:{
                type:Number
            }
        },
        data() {
            return {
                options:[
                    {
                        value:1,
                        label:'国际'
                    },
                    {
                        value:2,
                        label:'科技'
                    },
                    {
                        value:3,
                        label:'军事'
                    },
                    {
                        value:4,
                        label:'历史'
                    },
                    {
                        value:5,
                        label:'文化'
                    },
                    {
                        value:6,
                        label:'娱乐'
                    },
                    {
                        value:7,
                        label:'旅游'
                    },
                    {
                        value:8,
                        label:'教育'
                    },
                    {
                        value:9,
                        label:'其他'
                    },
                ]
            }
        },
        method:{
            change() {
                
            }
        },
        watch: {
            titleValue(newValue, oldValue) {
                this.$emit("change",this.titleValue,this.typeValue)
            },
            typeValue(newValue, oldValue) {
                this.$emit("change",this.titleValue,this.typeValue)
            }
        }
    }
</script>

<style scoped>

.bg {
    width:500px;
    margin: 200px auto 50px;
    text-align: left;
}

</style>