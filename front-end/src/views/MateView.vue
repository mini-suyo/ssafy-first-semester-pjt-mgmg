<template>
  <div class= "content">
    <div class="left-area">
      <div class="register-container">
        <div class="left-header">
          <button v-show="step === 1" class="back-space" @click="this.$router.go(-1)"><</button>
          <button v-show="step === 2" class="back-space" @click="backSpace1"><</button>
          <p>ㅡ ㅁ X</p>
        </div>
        <div v-show="step === 1">
            <div class="input-group">
                <label for="dogName">멍멍이 이름</label>
                <input type="text" id="dogName" v-model="mateName" placeholder="멍멍이 이름을 입력하세요" />
            </div>
            <button class="next-button" @click="next">NEXT</button>
        </div>

        <div v-show="step===2">
            <div class="mate-question">
                <p>강아지는 어디로 뛰어가는 걸까요?</p>
                <p>당신을 사랑하는 강아지와 들판에서 놀고 있습니다.</p>
                <p>그러던 중 강아지가 들판 입구 쪽으로 뛰어가는데</p>
                <p>어떤 이유로 뛰어가는 걸까요?</p>
            </div>
            <div class="input-group">
                <div class="radio">
                    <div class="radio-list">
                        <label for="choice1">가족 중 한명이 들어와서</label>
                        <input type="radio" id="choice1" name="test" value="폭풍 깜찍발랄한 강아지" v-model="personality">
                    </div>
                    <div class="radio-list">
                        <label for="choice2">다른 강아지가 지나가서</label>
                        <input type="radio" id="choice2" name="test" value="강아지계의 아이돌 강아지" v-model="personality">
                    </div>
                    <div class="radio-list">
                        <label for="choice3">먹을 것을 발견해서</label>
                        <input type="radio" id="choice3" name="test" value="자기 주관이 뚜렷한 강아지" v-model="personality">
                    </div>
                    <div class="radio-list">
                        <label for="choice4">모르는 사람을 발견해서</label>
                        <input type="radio" id="choice4" name="test" value="호기심이 많은 강아지" v-model="personality">
                    </div>
                </div>
                <button class="register-button" @click= "regist">REGIST</button>
            </div>
        </div>
      </div>
    </div>
    <div class="right-area">
      <img class="main-img" src="@/assets/img/mainImg.png" />
    </div>
  </div>
</template>

<script setup>
import { useMateStore } from '@/stores/mate';
import { ref } from 'vue';

const store = useMateStore();

const step = ref(1);


const mateName = ref('');
const personality = ref('');
const mateNameSave = ref('');

const next = function() {
    mateNameSave.value = mateName.value;
    step.value++;
}

const regist = function() {
    store.mateRegist(mateNameSave.value, personality.value);
}

const backSpace1 = function() {
    step.value = step.value - 1;
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

.left-area {
  font-family: 'meetMe';
  font-size: 30px;
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
  margin-bottom: 10rem;
  display: block;
  padding: 3rem;
  padding-top: 10rem;
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

.my-dog-img{
  border: 6px solid #4F3612;
  zoom:85%;
  position: relative;
  top: 4rem;
}


.next-button {
  font-family: 'Holtwood';
  font-size: 40px;
  background-color: #FFB74D;
  position: relative;
  width: 33rem;
  height: 5rem;
  top: 23rem;
  border-radius: 20px;
  border: 5px solid #4F3612
}

.next-button:hover {
  background-color: #e1a040;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}

.next-button:active {
  background-color: #c28b37;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15);
  transform: translateY(2px);
}

.mate-question {
    padding: 3rem;
    border-bottom: 3px solid #4F3612;
}

.radio {
    padding: 3rem;
}

.radio-list {
    display: flex ;
    justify-content: space-between;
    border-bottom: 3px solid #4F3612;
    margin-top: 1rem;
}

.radio-list input {
    width: 2rem;
}

/* 기본스타일을 없애고, 버튼모양을 구현한다. */
input[type='radio'] {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  width: 25px;
  height: 25px;
  border: 2px solid #4F3612;
  border-radius: 50%;
  outline: none;
  cursor: pointer;
  position: relative;
  top: 0.8rem;
}

input[type='radio']:checked {
  background-color: #4F3612;
  border: 3px solid white;
  box-shadow: 0 0 0 1.6px #4F3612;
}
</style>