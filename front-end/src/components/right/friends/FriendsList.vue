<template>
    <div class="right-header">
      <button class="back-space" @click="this.$router.go(-1)"><</button>
      <p>ㅡ ㅁ X</p>
    </div>
    <div class="friends-container">
        <ul v-if="filteredItems.length">
            <li v-for="item in filteredItems" :key="item.to">
                <img class="friend-icon" src="http://localhost:5173/src/assets/img/DogLogo.png"/>
                <p>{{ item.friendName }}</p>
                <button @click="goFriendDetail(item.friendNo)">
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
import { onMounted, ref, watch } from 'vue';

const store = useFriendStore();

const filteredItems = ref([]);

onMounted(
    store.friendList
)

watch(
  () => store.myFriendList,
  (newVal) => {
    filteredItems.value = newVal;
    console.log("watch triggered");
  }
);

const goFriendDetail = (userNo) => {
  router.push({ name: 'friendDetail', params: {userNo}});
};
</script>

<style scoped>
.right-header{
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
  border-style: hidden;
  background-color: #FFB74D;
  font-size: 40px;
  padding-top: 0.25em;
  padding-left: 2rem;
  top: -1rem;
  left: -1rem;
}

.right-header p {
  position: relative;
  top: -0.8rem;
  right: 1rem;
}

.friends-container {
    position: relative;
    font-family: "meetMe";
    font-size: 30px;
    max-height: 100rem;
    overflow-x: hidden;
}

.friends-container::-webkit-scrollbar {
  display: none;
}

.friends-container ul {
    position: relative;
    padding: 0rem;
}

.friends-container li {
    position: relative;
    list-style: none;
    text-align: left;
    border-top: 5px solid #4F3612;
    border-bottom: 5px solid #4F3612;
    margin-top: -0.3rem;
    background-color: white;
    display: flex;
    justify-content: flex-start;
    background-color: #fde9cf;
}

.friends-container li p {
    position: relative;
    font-size: 40px;
    margin-left: 2rem;
    width: 27rem;
    top: 1.3rem;
}

.friends-container li button {
    zoom: 11%;
    background-color: white;
    border-width: 0px;
    margin-right: 15rem;
    position: relative;
    margin-top: 0.5rem;
    background-color: #fde9cf;
}

.friend-icon {
  position: relative;
  zoom: 40%;
  margin: 2rem;
}
</style>