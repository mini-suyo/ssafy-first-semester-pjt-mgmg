<template>
  <div class = "left-container">
    <div class="left-header">
      <p>ㅡ ㅁ X</p>
    </div>
    <img class="my-dog-img" src="@/assets/img/civa.jpg" />
      <div class="window-header">
          <TheLeftHeader />
      </div>
  </div>
  
</template>

<script setup>
import TheLeftHeader from '@/components/common/TheLeftHeader.vue';
</script>

<style scoped>
.left-container {
  width: 40rem;
  height: 65rem;
  background-color: #fff;
  border-radius: 30px;
  border: 5px solid #4F3612;
  padding-bottom: 50px;
  position: relative;
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
}

.left-header p {
  position: relative;
  top: -0.9rem;
  left: 15rem;
}

.my-dog-img{
  border: 6px solid #4F3612;
  zoom:85%;
  position: relative;
  top: 4rem;
}

.window-header{
  height: 130px;
}

</style>