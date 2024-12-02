<template>
  <div class="content">
   <div class="left-area">
      <div class="catch-phrase">
        작은 발자국
        <br />
        멍글멍글한 이야기
      </div>
      <div class="btn-location">
        <button class="enter-btn" @click="goLogin">LOGIN</button>
        <button class="enter-btn" @click="goRegist">REGIST</button>
      </div>
    </div>
    <div class="right-area">
      <img class="main-img" src="@/assets/img/mainImg.png" />
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const goLogin = () => {
  console.log(123)
  router.push({name: 'login'})
}

const goRegist = () => {
  router.push({name: 'regist'})
}
</script>

<style scoped>

.catch-phrase {
  color: #000000;
  text-align: left;
  font-family: 'meetMe';
  font-size: 150px;
  position: relative;
  left: 200px;
  top: 150px;
  width: 900px;
  height: 391px;
}
.btn-location{
  position: relative;
  left: 350px;
  top: 300px;
}
.enter-btn{
  font-family: 'Holtwood';
  font-size: 70px;
  display: block;
  top: 100px;
  margin: 10px;
  background-color: #FFB74D;
  text-align: center;
  padding: 8px;
  width: 400px;
  height: 150px;
  border-radius: 20px;
  border: 5px solid #4F3612;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease;
}
.enter-btn:hover {
  background-color: #e1a040;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}
.enter-btn:active {
  background-color: #c28b37;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15);
  transform: translateY(2px);
}

</style>
