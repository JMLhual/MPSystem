const routes = [
    {
        name: 'Manage',
        path: '/',
        component: () => import('@/views/Manage.vue'),
        redirect: '/welcome',
        children:[
            {name:'Welcome',path:'/welcome',component:() => import("@/views/Welcome.vue")},
            {name:'Upload',path:'/upload',component:() => import("@/views/Upload.vue")},
            {name:'McarMar',path:'/mcarmar',component:() => import("@/views/McarMar.vue")},
            {name:'Mnar',path:'/mnar',component:() => import("@/views/Mnar.vue")},
            {name:'About',path:'/about',component:() => import("@/views/About.vue")}
        ]
    },

];

export default routes
