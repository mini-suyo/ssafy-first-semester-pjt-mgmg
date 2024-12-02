<template>
    <div class="left-header">
        <button class="user-data-tab" @click="showPage = 'status'" :class="{ active: showPage === 'status' }">status</button>
        <button class="user-data-tab" @click="showPage = 'recent'" :class="{ active: showPage === 'recent' }">recent</button>
        <button class="user-data-tab" @click="showPage = 'friends'" :class="{ active: showPage === 'friends' }">friends</button>
        <button class="user-data-tab" @click="showPage = 'info'" :class="{ active: showPage === 'info' }">info</button>
    </div>
    <div class="user-data">
        <div v-show="showPage === 'status'">
        <UserStatus/>
        </div>
        <div v-show="showPage === 'recent'">
        <UserRecent/>
        </div>
        <div v-show="showPage === 'friends'">
        <UserFriends/>
        </div>
        <div v-show="showPage === 'info'">
        <UserInfo/>
    </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import UserStatus from '../left/UserStatus.vue';
import UserRecent from '../left/UserRecent.vue';
import UserFriends from '../left/UserFriends.vue';
import UserInfo from '../left/UserInfo.vue';

const showPage = ref('status')

</script>

<style scoped>

.left-header {
  position: relative;
  top: 6.5rem;
  font-family: 'meetMe';
  font-size: 50px;
}
.user-data{
    position: relative;
    top: 5.8rem;
}
.user-data-tab{
    position: relative;
    width: 25%;
    background-color: #FFD9A6;
    border-top: 5px solid #4f3612;
    border-bottom: 5px solid #4f3612;
    transition: all 0.3s ease;
}
.user-data-tab:hover {
  background-color: #FFB74D;
}
.user-data-tab:active {
  background-color: #FF9A3D;
}

.user-data-tab.active {
  background-color: #BF9D6F;
}
</style>