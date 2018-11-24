import Vue from 'vue'
import Router from 'vue-router'
import index from '@/page/main/index'
import login from '@/page/main/login'
import forget from '@/page/main/forget'
import sighIn from '@/page/main/sighIn'
import home from '@/page/home/home'
import myhome from '@/page/home/myhome'
import details from '@/page/home/details'
import employee from '@/page/home/employee'
import job from '@/page/home/job'
import join from '@/page/home/join'
import love from '@/page/home/love'
import love_list from "@/page/love/list"
import love_editor from "@/page/love/editor"
import love_news from "@/page/love/news"
import message from '@/page/home/message'
import msg_list from '@/page/msg/list'
import msg_details from '@/page/msg/details'
import news from '@/page/home/news'
import mydetails from '@/page/details/mydetails'
import details_update from '@/page/details/update'
import upPass from '@/page/details/upPass'
import details_list from '@/page/details/list'
import news_list from '@/page/news/list'
import news_create from '@/page/news/create'
import news_details from '@/page/news/details'
import publics from '@/page/news/public'
import save from '@/page/news/save'
import update from '@/page/news/update'
import failure from '@/page/news/failure'
import auditing from '@/page/news/auditing'
import job_list from '@/page/job/list'
import job_join from '@/page/job/join'
import job_news from '@/page/job/news'

import all from '@/page/newsType/all'
import culture from '@/page/newsType/culture'
import education from '@/page/newsType/education'
import entertainment from '@/page/newsType/entertainment'
import foreign from '@/page/newsType/foreign'
import military from '@/page/newsType/military'
import other from '@/page/newsType/other'
import science from '@/page/newsType/science'
import tourism from '@/page/newsType/tourism'
import history from '@/page/newsType/history'

import News from '@/page/main/news'

import Details from '@/page/main/details'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index,
      children:[
        {
          path:'/',
          name:'all',
          component:all
        },
        {
          path:'culture',
          name:'culture',
          component:culture
        },
        {
          path:'education',
          name:'education',
          component:education
        },
        {
          path:'entertainment',
          name:'entertainment',
          component:entertainment
        },
        {
          path:'foreign',
          name:'foreign',
          component:foreign
        },
        {
          path:'military',
          name:'military',
          component:military
        },
        {
          path:'other',
          name:'other',
          component:other
        },
        {
          path:'science',
          name:'science',
          component:science
        },
        {
          path:'tourism',
          name:'tourism',
          component:tourism
        },
        {
          path:'news',
          name:'news',
          component:News
        },
        {
          path:'history',
          name:'history',
          component:history
        },
      ]
    },
    {
      path: '/sighIn',
      name: 'sighIn',
      component: sighIn
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/forget',
      name: 'forget',
      component: forget
    },
    {
      path: '/details',
      name: 'details',
      component: Details
    },
    {
      path: '/home',
      name: 'home',
      component: home,
      children:[
        {
          path: '/',
          name: 'myhome',
          component: myhome
        },
        {
          path: 'details',
          name: 'details',
          component: details,
          children:[
            {
              path: '/',
              name: 'details_list',
              component: details_list
            },
            {
              path: 'mydetails',
              name: 'mydetails',
              component: mydetails
            },
            {
              path: 'update',
              name: 'update_deatails',
              component: details_update
            },
            {
              path: 'upPass',
              name: 'upPass',
              component: upPass
            },
          ]
        },
        {
          path: 'employee',
          name: 'employee',
          component: employee
        },
        {
          path: 'job',
          name: 'job',
          component: job,
          children:[
            {
              path: '/',
              name: 'job_list',
              component: job_list
            },
            {
              path: 'news',
              name: 'job_news',
              component: job_news
            },
            {
              path: 'join',
              name: 'job_join',
              component: job_join
            },
          ]
        },
        {
          path: 'join',
          name: 'join',
          component: join
        },
        {
          path: 'love',
          name: 'love',
          component: love,
          children:[
            {
              path:"/",
              name:"love_list",
              component:love_list
            },
            {
              path:"news",
              name:"love_news",
              component:love_news
            },
            {
              path:"editor",
              name:"love_editor",
              component:love_editor
            },
          ]
        },
        {
          path: 'message',
          name: 'message',
          component: message,
          children:[
            {
              path:"/",
              name:"msg_list",
              component:msg_list
            },
            {
              path:"details",
              name:"msg_details",
              component:msg_details
            },
          ]
        },
        {
          path: 'news',
          name: 'news',
          component: news,
          children:[
            {
              path: '/',
              name: 'news_list',
              component: news_list
            },
            {
              path: 'create',
              name: 'news_create',
              component: news_create
            },
            {
              path: 'update',
              name: 'news_create',
              component: update
            },
            {
              path: 'public',
              name: 'public',
              component: publics
            },
            {
              path: 'save',
              name: 'save',
              component: save
            },
            {
              path: 'failure',
              name: 'failure',
              component: failure
            },
            {
              path: 'auditing',
              name: 'auditing',
              component: auditing
            },
            {
              path: 'details',
              name: 'news_details',
              component: news_details
            }
          ]
        },
      ]
    },
  ]
})
