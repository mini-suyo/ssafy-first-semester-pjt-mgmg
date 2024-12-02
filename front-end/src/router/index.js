import { createRouter, createWebHistory } from 'vue-router'
import RegisterView from '@/views/RegisterView.vue'
import HomeView from '../views/HomeView.vue'
import MainView from '@/views/mainPage/MainView.vue'
import MainLeftView from '@/views/mainPage/MainLeftView.vue'
import MainRightView from '@/views/mainPage/MainRightView.vue'
import StatusMainTodayDiary from '@/components/right/status/StatusMainTodayDiary.vue'
import StatusMainWalk from '@/components/right/status/StatusMainWalk.vue'
import LoginView from '@/views/LoginView.vue'
import TheRightHeader from '@/components/common/TheRightHeader.vue'
import DiaryMain from '@/components/right/diary/DiaryMain.vue'
import FriendsAdd from '@/components/right/friends/FriendsAdd.vue'
import FriendDetail from '@/components/right/friends/FriendDetail.vue'
import MateView from '@/views/MateView.vue'
import FriendsList from '@/components/right/friends/FriendsList.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
    },
    {
      path: '/regist',
      name: 'regist',
      component: RegisterView,
    },
    {
      path: '/mateRegist',
      name: 'mateRegist',
      component: MateView,
    },
    {
      path: '/main',
      name: 'main',
      component: MainView,
      children: [
        {
          path: 'left',
          name: 'mainLeftView',
          component: MainLeftView,
        },
        {
          path: 'right',
          name: 'mainRightView',
          component: MainRightView,
          children: [
            {
              path: 'rightHeader',
              name: 'theRightHeader',
              component: TheRightHeader,
            },
            {
              path: 'statusWalk',
              name: 'statusWalk',
              component: StatusMainWalk,
            },
            {
              path: 'statusTodayDiary',
              name: 'statusTodayDiary',
              component: StatusMainTodayDiary,
            },
            {
              path: 'diaryMain',
              name: 'diaryMain',
              component: DiaryMain,
            },
            {
              path: 'friendsAdd',
              name: 'friendsAdd',
              component: FriendsAdd,
            },
            {
              path: 'friendsList',
              name: 'friendsList',
              component: FriendsList,
            },
            {
              path: 'friends/:userNo',
              name: 'friendDetail',
              component: FriendDetail,
              props: true, // Enables passing route params as props
            },

          ]
        },
      ]
    },
  ]
})

const publicPaths = ['/', '/login', '/regist'];
router.beforeEach((to, from) => {
  if (!publicPaths.includes(to.path)) {
    const token = sessionStorage.getItem('access-token');
    if (!token) {
      console.log("로그인이 필요합니다.");
      alert("로그인이 필요합니다.");
      return { name: 'login' };
    }
  }
});

export default router
