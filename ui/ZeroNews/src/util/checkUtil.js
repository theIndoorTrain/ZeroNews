
//判断字符串是否相等
export function empty(str1,str2) {
    if(str1 !== str2) {
        return false
    }
    return true
}

//判断是否为空
export function isNull(str) {
    if(str==null || str==''){
        return true
    }
    if(str.indexOf(" ") != -1) {
        return true
    }
    return false
}

export default {
    empty,
    isNull,
}