<template>
  <div class= "content">
    <div class="left-area">
      <div class="register-container">
        <div class="left-header">
          <button class="back-space" @click="this.$router.go(-1)"><</button>
          <p>ㅡ ㅁ X</p>
        </div>
        <form @submit.prevent="regist">
          <div class="input-group">
            <label for="id">아이디</label>
            <input type="text" id="id" v-model="id" placeholder="아이디" />
          </div>
          <div class="input-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" v-model="password" placeholder="비밀번호" />
          </div>
          <div class="input-group">
            <label for="userName">이름</label>
            <input type="text" id="userName" v-model="userName" placeholder="이름" />
          </div>
          <div class="button-group">
            <button type="submit" class="register-button">REGISTER</button>
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
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/user';

const router = useRouter();
const store = useUserStore();

const id = ref('');
const password = ref('');
const userName = ref('');

// #1. 회원가입
const regist = function() {
  if (!id.value.trim() || !password.value.trim() || !userName.value.trim()) {
    alert("모든 정보를 입력 해주세요.")
    return;
  }
  store.userRegist(id.value, password.value, userName.value)
}
</script>

<style scoped>

.register-container {
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

.left-header{
  font-family: "meetMe";
  font-size: 50px;
  height: 3rem;
  background-color: #FFB74D;
  border-bottom: 5px solid #4F3612;
  display: flex;
  position: relative;
  justify-content: space-between;
}

.back-space{
  position: relative;
  background-color: #FFB74D;
  font-size: 40px;
  padding-top: 0.25em;
  padding-left: 2rem;
}

.left-header p {
  position: relative;
  top: -0.8rem;
  right: 1rem;
}

form{
  padding-top: 2rem;
  padding-left: 3rem;
  padding-right: 3rem;
}

.input-group {
  font-family: 'meetMe';
  font-size: 30px;
  position: relative;
}

.input-group label {
  display: block;
  margin-bottom: 0.5rem;
}

.input-group input {
  width: 100%;
  padding: 0.5rem;
  border: 3px solid #4F3612;
}

.button-group {
  margin-top: 1rem;
}

.register-button {
  font-family: 'Holtwood';
  font-size: 40px;
  background-color: #FFB74D;
  position: relative;
  width: 33rem;
  height: 5rem;
  border-radius: 20px;
  border: 5px solid #4F3612;
}
.register-button:hover {
  background-color: #e1a040;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}
.register-button:active {
  background-color: #c28b37;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15);
  transform: translateY(2px);
}


</style>