<template>
  <div class="app">
    <Navigation />
    <RouterView/>
  </div>
</template>

<script setup>
import Navigation from './components/common/Navigation.vue';

</script>

<style scoped>
.app{
  display: flex;
  flex-direction: column;
  height: 147%;
}
    /* 폰트 임포트하는 부분 */
    /* 기본폰트 */
    @font-face {
        font-family: 'meetMe';
        src: url('../src/assets/fonts/meetMe.ttf') format('truetype');
        font-weight: 400;  
    }
      /* 로그인버튼폰트 */
    @font-face {
        font-family: 'Holtwood';
        src: url('../src/assets/fonts/HoltwoodOneSC.ttf') format('truetype');
        font-weight: 400;
    }
</style>