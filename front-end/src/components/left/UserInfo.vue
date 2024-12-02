<template>
  <div class="info-menu">
    <div class="input-group">
      <label for="password">비밀번호</label>
      <input type="password" id="password" v-model="password" placeholder="비밀번호" />
    </div>
    <div class="input-group">
      <label for="newPassword"> 새 비밀번호</label>
      <input type="password" id="newPassword" v-model="newPassword" placeholder="비밀번호" />
    </div>
    <div class="input-group">
      <label for="newPasswordRe">새 비밀번호 확인</label>
      <input type="password" id="newPasswordRe" v-model="newPasswordRe" placeholder="비밀번호" />
    </div>
    
    <div class="button-group">
      <button @click="updateUser" class="update-button">DONE</button>
    </div>
  </div>

</template>

<script setup>
import { useUserStore } from '@/stores/user';
import { ref } from 'vue';

const password = ref('');
const newPassword = ref('');
const newPasswordRe = ref('');

const store = useUserStore();

const updateUser = function() {

  if (newPassword.value === newPasswordRe.value) {
    store.userUpdate(password.value, newPassword.value);

  } else {
    alert("새 비밀번호가 일치하지 않습니다.")
  }
}


</script>

<style scoped>
.input-group {
  font-family: 'meetMe';
  font-size: 30px;
  position: relative;
  top: 1rem;
}

.input-group label {
  display: block;
  margin-bottom: 0.5rem;
}

.input-group input {
  position: relative;
  width: 35rem;
  padding: 0.5rem;
  border: 3px solid #4F3612;
}

.info-menu{
  padding-left: 3rem;
  padding-right: 3rem;
  position: relative;
  top: 1rem;
  max-height: 30rem;
  overflow-x: hidden;
}

.info-menu::-webkit-scrollbar{
  /* 필요하지 않으면 none 처리 */
  display: none;
  overflow: auto;
  width: 20px;
}

.info-menu::-webkit-scrollbar-thumb{
  background-color: #FFD9A6;
  border-radius: 20px;
}

.update-button{
  font-family: 'Holtwood';
  font-size: 60px;
  background-color: #FFB74D;
  width: 540px;
  height: 100px; 
  border-radius: 20px;
  border: 5px solid #4F3612;
  margin-top: 3rem;
}
</style>