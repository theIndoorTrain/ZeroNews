import axios from 'axios'
import doCookie from '@/util/cookieUtil'

axios.defaults.headers.common['Authorization'] = doCookie.getCookie("SESSIONID")
axios.defaults.baseURL = 'http://localhost:8080'


/**
 * Get请求
 */
export function get(url, callback){
    console.log('测试get请求')
    axios.get(url)
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
    axios.delete(url)
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
    axios.post(url,data)
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
    axios.put(url,data)
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