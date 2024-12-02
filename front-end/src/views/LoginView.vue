<template>
  <div class="content">
    <div class="left-area">
      <div class="login-container">
        <div class="left-header">
          <p>ㅡ ㅁ X</p>
        </div>
        <div class="logo">
          <img src="@/assets//img/DogLogo.png"/>
        </div>
        <form @submit.prevent="login">
          <div class="input-group">
            <label for="id">아이디</label>
            <input type="text" id="id" v-model="id" placeholder="아이디를 입력하세요" />
          </div>
          <div class="input-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" v-model="password" placeholder="비밀번호를 입력하세요" />
          </div>
          <div class="button-group">
            <button type="submit" class="login-button">LOGIN</button>
            <button type="button" class="register-button" @click="goRegist">REGISTER</button>
          </div>
        </form>
      </div>
    </div>
    <div class="right-area">
      <img class="main-img" src="@/assets/img/mainImg.png" />
    </div>
  </div>
</template>

<script setup>

import { useUserStore } from '@/stores/user';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const store = useUserStore();

// #1. 로그인 
const id = ref('');
const password = ref('');
const login = function () {
if (!id.value.trim() || !password.value.trim()) {
    alert("아이디와 비밀번호를 입력해주세요.")
    return;
  }
store.login(id.value, password.value);
}

// #2. 회원가입 페이지로 이동
const goRegist = () => {
router.push({ name: 'regist' });
};

</script>

<style scoped>
.content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100vh;
  background-color: #fef3e3;
  font-family: Arial, sans-serif;
}

.login-container {
  width: 40rem;
  height: 65rem;
  background-color: #fff;
  border-radius: 30px;
  border: 5px solid #4F3612;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  position: absolute;
  top: 10rem;
  left: 30rem;
  text-align: center;
  overflow: hidden;
}

.logo {
  margin-top: 5rem;
}

.input-group {
  font-family: 'meetMe';
  font-size: 40px;
  position: relative;
  top: 9.8rem;
  margin-top: 1rem;
}

.input-group label {
  display: block;
  font-weight: bold;
}

.input-group input {
  width: 100%;
  padding: 0.5rem;
  border: 3px solid #4F3612;
}

.login-button,
.register-button {
font-family: 'Holtwood';
font-size: 40px;
margin-bottom: 1rem;
background-color: #FFB74D;
position: relative;
width: 530px;
height: 100px;
top: 13.3rem;
border-radius: 20px;
border: 5px solid #4F3612;
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
transition: all 0.3s ease;
}

.login-button:hover,
.register-button:hover{
  background-color: #e1a040;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}

.login-button:active,
.register-button:active {
background-color: #c28b37;
box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15);
transform: translateY(2px);
}

.left-header{
  font-family: "meetMe";
  font-size: 50px;
  height: 3rem;
  background-color: #FFB74D;
  border-bottom: 5px solid #4F3612;
}

.left-header p {
  position: relative;
  top: -0.9rem;
  left: 15rem;
}

form{
  position: relative;
  top: -4rem;
  padding-left: 3rem;
  padding-right: 3rem;
}
</style>
