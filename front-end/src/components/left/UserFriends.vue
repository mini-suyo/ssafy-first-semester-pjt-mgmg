<template>
    <div class="friends-container">
        <ul v-if="filteredItems.length">
            <li v-for="item in filteredItems" :key="item.to">
                <img class="friend-icon" src="http://localhost:5173/src/assets/img/DogLogo.png"/>
                <p>{{ item.friendName }}</p>
                <button @click="goFriendDetail(item.userNo)">
                    <img class="friend-info" src="http://localhost:5173/src/assets/icons/user-account.png"/>
                </button>
            </li>
        </ul>
        <p v-else-if="!filteredItems.length && searchQuery">검색 결과가 없습니다.</p>
    </div>
</template>

<script setup>
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
  router.push({ path: "/main/right/friendsMain/" + userNo });
};

</script>

<style scoped>
.friends-container {
    position: relative;
    top: 0.8rem;    
    font-family: "meetMe";
    font-size: 30px;
    max-height: 30rem;
    overflow-x: hidden;
}

.friends-container::-webkit-scrollbar {
  display: none;
}

.friends-container ul {
    position: relative;
    margin-left: -2rem;
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
}

.friend-icon {
  position: relative;
  zoom: 40%;
  margin: 2rem;
}

.friends-container::-webkit-scrollbar{
  /* 필요하지 않으면 none 처리 */
  display: none;
  overflow: auto;
  width: 20px;
}
</style>