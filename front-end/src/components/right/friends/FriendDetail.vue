<template>
    <div class="friend-container">
        <div class="friend-header">
            <button class="back-space" @click="$router.go(-1)"><</button>
            <p>ㅡ ㅁ X</p>
        </div>
        <img class="friend-dog-img" src="@/assets/img/civa.jpg" />

        <div class="friend-social">
            <div class="friend-name">
                {{ friend.friendName }}
            </div>
            <button v-if="!showBtn" class="friend-social-tab" @click="btn">
                <img class="friend-social-img" src="@/assets/icons/add-user.png" />
            </button>
            <button v-if="showBtn" class="friend-social-tab" @click="btn">
                <img class="friend-social-img" src="@/assets/icons/delete-user.png" />
            </button>
        </div>
        <div>
            <div class="status-param">
                <img class="status-icon" src="http://localhost:5173/src/assets/icons/love.png" />
                <progress class="status-progress" value="70" min="0" max="100"></progress>
            </div>
            <div class="status-param">
                <img class="status-icon" src="http://localhost:5173/src/assets/icons/compass.png" />
                <progress class="status-progress" value="30" min="0" max="100"></progress>
            </div>
            <div class="status-param">
                <img class="status-icon" src="http://localhost:5173/src/assets/icons/user-account.png" />
                <progress class="status-progress" value="50" min="0" max="100"></progress>
            </div>
            <div class="status-param">
                <img class="status-icon" src="http://localhost:5173/src/assets/icons/idea-bulb.png" />
                <progress class="status-progress" value="90" min="0" max="100"></progress>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useFriendStore } from '@/stores/friend';
import { useUserStore } from '@/stores/user';
import { defineProps, onMounted, ref, watch } from 'vue'

// 초기 세팅
const props = defineProps({
    userNo: {
        type: Number,
        required: true,
    },
})
const store = useUserStore();
const store2 = useFriendStore();
const friend = ref({});
const showBtn = ref(false);

onMounted(async () => {
    store.userRead(props.userNo);
    await store2.isFriend(props.userNo);
}
)

watch(
    () => store.friend,
    (newVal) => {
        friend.value = newVal;
        console.log(friend);
    }
);

watch(
    () => store2.isFriendVal,
    (newVal) => {
        showBtn.value = newVal
        console.log(showBtn.value)
    }
);

const btn = function () {
    if (!showBtn.value) {
        showBtn.value = true;
        store2.registFriend(friend.value.friendNo, friend.value.friendName)

    } else {
        showBtn.value = false;
        store2.deleteFriend(friend.value.friendNo, friend.value.friendName)
    }
};





</script>

<style scoped>
.friend-header {
    font-family: "meetMe";
    font-size: 50px;
    height: 3rem;
    background-color: #FFB74D;
    border-bottom: 5px solid #4F3612;
    display: flex;
    position: relative;
    justify-content: space-between;
}

.friend-header p {
    position: relative;
    top: -0.8rem;
    right: 1rem;
}

.back-space {
    position: relative;
    border-style: hidden;
    background-color: #FFB74D;
    font-size: 40px;
    padding-top: 0.25em;
    padding-left: 2rem;
    top: -1rem;
    left: -1rem;
}

.friend-dog-img {
    border: 6px solid #4F3612;
    zoom: 85%;
    position: relative;
    top: 4rem;
    margin-bottom: 8rem;
}

.friend-social {
    position: relative;
    display: flex;
    justify-content: space-around;
    background-color: #FFD9A6;
    border-top: 5px solid #4f3612;
    border-bottom: 5px solid #4f3612;
    transition: all 0.3s ease;
    top: -0.4rem;
}

.friend-social-img {
    zoom: 80%;
    margin-top: 4rem;
    margin-bottom: 4rem;
}

.friend-name {
    position: relative;
    width: 51%;
    border-right: 5px solid #4f3612;
    font-family: "meetMe";
    font-size: 50px;
}

.friend-social-tab {
    zoom: 15%;
    background: #FFD9A6;
    width: 132rem;
}

.friend-social-tab:hover {
    background-color: #FFB74D;
}

.friend-social-tab:active {
    background-color: #BF9D6F;
}

.status-param {
    position: relative;
    top: -1rem;
    height: 8rem;
    border-bottom: 3px solid #3E2A0E;
}

.status-icon {
    zoom: 15%;
    margin-top: 13rem;
}

.status-progress {
    appearance: none;
    position: relative;
    margin-left: 3rem;
    border: 5px solid #3E2A0E;
    border-radius: 20px;
    width: 24rem;
    height: 3rem;
    top: 2.2rem;
    overflow: hidden;
}

.status-progress::-webkit-progress-bar {
    background: white;
}

.status-progress::-webkit-progress-value {
    background: #FFA726;
}
</style>