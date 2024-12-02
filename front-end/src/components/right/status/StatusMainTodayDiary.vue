<template>
    <div class="right-header">
      <button class="back-space" @click="this.$router.go(-1)"><</button>
      <p>ㅡ ㅁ X</p>
    </div>
    <div class="diary-content">
        <div class="diary-header">
            <p>OOO의 일기</p>
            <p>{{ currentDate }}</p>
        </div>
        <div>
            {{ text }}
        </div>
        <button @click="save">
            <img class="save-btn" src="http://localhost:5173/src/assets/icons/dog-stamp.png"/>
            <p>저장</p>
        </button>
    </div>
</template>

<script setup>
import { useDiaryStore } from '@/stores/diary';
import { ref } from 'vue';

const store = useDiaryStore();

// 현재 날짜를 계산하여 저장
const date = new Date();
const currentDate = ref(`${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`);


const text = store.generatedDiary;

const save = function() {
    store.saveDiary('exampleurl',text)
}

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

.diary-header {
  display: flex;
  position: relative;
  justify-content: space-between;
  border-bottom: 5px solid #4F3612;
  background-color: #FFD9A6;
}

.diary-header p {
    position: relative;
    top: 0.7rem;
    margin-left: 1rem;
    margin-right: 1rem;
    font-family: 'meetMe';
    font-size: 40px;
}

.diary-content {
  font-family: 'meetMe';
  font-size: 40px;
  margin: 2.5rem;
  height: 56rem;
  border-radius: 20px;
  border: 5px solid #4F3612;
  overflow: hidden;
}

.diary-content button {
    border: white;
    background-color: transparent;
    position: absolute;
    height: 10rem;
    width: 10rem;
    top: 51.5rem;
    left: 27rem;
    transform: rotate(20deg);
}

.diary-content button img {
    zoom: 20%;
}

.diary-content button p {
    position: relative;
    top: -4.3rem;
    left: 0.15rem;
    color: white;
    font-size: 30px;
}

.diary-content button p :hover {
    position: relative;
    top: -4.3rem;
    left: 0.15rem;
    color: white;
    font-size: 40px;
}
</style>