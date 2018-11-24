import axios from 'axios'

export var baseurl = '/api'

/**
 * Get请求
 */
export function get(url, callback){
    console.log('测试get请求')
    axios.get(baseurl+url)
    .then(function (response) {
        console.log(response)
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        console.log(error)
        callback(null,false)
    })
}

export function remove(url, callback){
    console.log('测试delete请求')
    axios.delete(baseurl+url)
    .then(function (response) {
        console.log(response)
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        console.log(error)
        callback(null,false)
    })
}

export function post(url, data, callback){
    console.log('测试get请求')
    axios.post(baseurl+url,data)
    .then(function (response) {
        console.log(response)
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        console.log(error)
        callback(null,false)
    })
}

export function put(url, data, callback){
    console.log('测试get请求')
    axios.put(baseurl+url,data)
    .then(function (response) {
        console.log(response)
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        console.log(error)
        callback(null,false)
    })
}


export default {
    get,
    post,
    put,
    remove,
}