import router from "@/router";
import axios from "axios";
import { defineStore } from "pinia";
import { ref } from "vue";

const REST_API_URL = `http://localhost:8080/api-user`

export const useUserStore = defineStore('user', () => {

  
  const loginUserName = ref(null)
  const loginUserNo = ref()
  const flag = ref(false);
  
  //#1.
  //로그인
  const login = function (id, password) {
    axios.post(`${REST_API_URL}/login`, {
      id: id,
      password: password
    })
      .then((response) => {
        console.log(response)
        sessionStorage.setItem('access-token', response.data['access-token'])

        let token = response.data['access-token'].split('.')
        let userName = JSON.parse(atob(token[1]))['userName']
        loginUserName.value = userName;
        
        flag.value = JSON.parse(atob(token[1]))['mateFlag'];
        console.log(flag.value)
        if (flag.value === true) {
          router.push({ name: 'theRightHeader' })
        } else {
          router.push({ name: 'mateRegist'})
        }
      })
      .catch((err) => {
        console.log(err)
        alert(err.response.data.message)
        router.push({ name: 'login' })
      })
  }
  // #2. 
  // 회원가입
  const userRegist = function (id, password, userName) {
    axios.post(`${REST_API_URL}/regist`, {
      id: id,
      password: password,
      userName: userName,
    }).then((response) => {
      console.log(response)

      router.push({ name: 'login' })
      alert(response.data.message)
    })
      .catch((err) => {
        console.log(err)
        alert(err.response.data.message)
      })
  }
  // #3.
  // 회원정보 수정
  const userUpdate = function (password, newPassword) {

    const token = sessionStorage.getItem('access-token').split('.');
    const userNo = JSON.parse(atob(token[1]))['userNo'];
    loginUserNo.value = userNo;

    axios.post(`${REST_API_URL}/update`, {
      userNo: loginUserNo.value,
      password: password,
      newPassword: newPassword,
    })
      .then((response) => {
        console.log(response);
        alert(response.data.message)
      })
      .catch((err) => {
        console.log(err);
        alert(err.response.data.message)
      })
  }

  const friend = ref([]);
  const userRead = function (userNo) {
    console.log(userNo)
    axios.post(`${REST_API_URL}/getUserByUserNo`, {
      userNo: userNo,
    })
      .then((response) => {
        friend.value = response.data;
      })
      .catch((err) => {
        console.log(err);
        alert(err.response.data.message)
      })
  }

  return { loginUserName, loginUserNo, login, userRegist, userUpdate, friend, userRead }

})