<template>
  <div class="right-header">
      <p>ㅡ ㅁ X</p>
  </div>
  <div class="btn-location">
      <button @click="goWalk()">산책하기</button>
      <button @click="goDiaryBook()">일기장</button>
      <button @click="goFriendsAdd()">친구추가</button>
      <button @click="goFriendsList()">친구목록</button>
      <button>+@</button>
      <button>+@</button>
  </div>
</template>

<script setup>
import {useRouter} from "vue-router";

const router = useRouter();

const goWalk = () => {
  router.push({ path: "/main/right/statusWalk" });
};
const goDiaryBook = () => {
  router.push({ path: "/main/right/diaryMain" });
};
const goFriendsAdd = () => {
  router.push({ path: "/main/right/friendsAdd" });
};
const goFriendsList = () => {
  router.push({ path: "/main/right/friendsList" });
};
</script>

<style scoped>
.btn-location button{
font-family: 'meetMe';
font-size: 80px;
background-color: #FFD9A6;
border-radius: 20px;
border: 5px solid #4F3612;
position: relative;
width: 17rem;
height: 17rem;
margin: 1rem;
margin-top: 2rem;
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
transition: all 0.3s ease;
}
.btn-location button:hover {
background-color: #FFB74D;
box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}
.btn-location button:active {
background-color: #FF9A3D;
box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15);
transform: translateY(2px);
}

.right-header{
font-family: "meetMe";
font-size: 50px;
height: 3rem;
background-color: #FFB74D;
border-bottom: 5px solid #4F3612;
}

.right-header p {
position: relative;
top: -0.9rem;
left: 31.1rem;
}
</style>