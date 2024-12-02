<template>
  <div class="friends-search">
    <div class="right-header">
      <button class="back-space" @click="$router.go(-1)">
        < </button>
          <p>ㅡ ㅁ X</p>
    </div>
    <div class="search-container">
      <img src="http://localhost:5173/src/assets/icons/magnifying-glass.png" alt="검색" class="search-icon" />
      <input type="text" id="searchQuery" v-model="searchQuery" @keyup.enter="search" />

      <!-- 검색 버튼 -->
      <button @click="search">검색</button>
    </div>

    <ul v-if="filteredItems.length">
      <li v-for="item in filteredItems" :key="item.userNo">
        <img class="friend-icon" src="http://localhost:5173/src/assets/img/DogLogo.png"/>
        <p>{{ item.id }}</p>
        <button @click="goFriendDetail(item.userNo)">
            <img class="friend-info" src="http://localhost:5173/src/assets/icons/user-account.png"/>
        </button>
      </li>
    </ul>
    <p v-else-if="!filteredItems.length && searchQuery">검색 결과가 없습니다.</p>
  </div>
</template>

<script setup>

import router from '@/router';
import { useFriendStore } from '@/stores/friend';
import { ref, watch } from 'vue';
const store = useFriendStore()

const searchQuery = ref('')
const filteredItems = ref([]);

const search = function () {
  store.searchFriend(searchQuery.value)
}

const goFriendDetail = (userNo) => {
  router.push({ name: 'friendDetail', params: {userNo}});
};

watch(
  () => store.searchedFriend,
  (newVal) => {
    filteredItems.value = newVal;
    console.log("watch triggered");
  },
  { immediate: true }
);

</script>

<style scoped> 
.friends-search {
    font-family: "meetMe";
    font-size: 30px;
}

.search-container {
    display: flex;
    justify-content: center;
    margin-top: 3rem;
}

.search-container img{
    zoom:10%;
    border-top: 30px solid #4F3612;
    border-bottom: 30px solid #4F3612;
    border-left: 30px solid #4F3612;
    border-right: white;
    border-top-left-radius: 200px;
    border-bottom-left-radius: 200px;
    padding: 3rem;
    padding-right: 5rem;
    padding-left: 5rem;
}

.search-container input{
    border-top: 3px solid #4F3612;
    border-bottom: 3px solid #4F3612;
    border-right: white;
    border-left: white;
    outline: none;
    position: relative;
    width: 20rem;
}

.search-container button{
    background-color: white;
    border-top: 3px solid #4F3612;
    border-bottom: 3px solid #4F3612;
    border-right: 3px solid #4F3612;
    border-top-right-radius: 20px;
    border-bottom-right-radius: 20px;
    border-left: white;
    padding-right: 1rem;
}

.friends-search ul {
    position: relative;
    margin-left: -2rem;
}

.friends-search li {
    position: relative;
    list-style: none;
    text-align: left;
    border-top: 5px solid #4F3612;
    border-bottom: 5px solid #4F3612;
    margin-top: -0.3rem;
    top: 3rem;
    background-color: #FFD9A6;
    display: flex;
    justify-content: flex-start;
}

.friends-search li p {
    position: relative;
    font-size: 40px;
    margin-left: 2rem;
    width: 27rem;
    top: 1.3rem;
}

.friends-search li button {
    zoom: 11%;
    background-color: #FFD9A6;
    border-width: 0px;
    margin-right: 15rem;
}

.friend-icon {
  zoom: 40%;
  margin: 2rem;
}

.no-result {
    margin-top: 5rem;
}
</style>