import axios from 'axios'
import doCookie from '@/util/cookieUtil'

axios.defaults.headers.common['Authorization'] = doCookie.getCookie("SESSIONID")
axios.defaults.baseURL = 'http://localhost:8080'


/**
 * Get请求
 */
export function get(url, callback){
    axios.get(url)
    .then(function (response) {
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        callback(null,false)
    })
}

export function remove(url, callback){
    axios.delete(url)
    .then(function (response) {
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        callback(null,false)
    })
}

export function post(url, data, callback){
    axios.post(url,data)
    .then(function (response) {
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        callback(null,false)
    })
}

export function put(url, data, callback){
    axios.put(url,data)
    .then(function (response) {
        if(response.data.length==0 || response.data==null) {
            callback(null,true)
        } else {
            callback(response.data,true)
        }
    })
    .catch(function (error) {
        callback(null,false)
    })
}


export default {
    get,
    post,
    put,
    remove,
}