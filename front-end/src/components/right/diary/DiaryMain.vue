<template>
     <div class="right-header">
      <button class="back-space" @click="this.$router.go(-1)"><</button>
      <p>ㅡ ㅁ X</p>
    </div>
    <div>
        <vue-cal
            class="vuecal"
            color=""
            xsmall
            hide-view-selector
            :time="false"
            active-view="month"
            :disable-views="['week']"
            style="width: 560px;height: 910px"
            :events=events>
        </vue-cal>
    </div>
</template>

<script>
import { useDiaryStore } from '@/stores/diary';
import { computed, onMounted, ref, watch } from 'vue';
import VueCal from 'vue-cal'
import 'vue-cal/dist/vuecal.css'

export default {
  components: { VueCal },
}
</script>

<script setup>
const store = useDiaryStore();
const events = ref([]);


console.log(store.events)

onMounted(
    store.getDiary
)

watch (
    () => store.events, (newEvents) => 
    {
        events.value = newEvents;
    },
    { immediate: true } // 컴포넌트가 마운트될 때 즉시 실행
);

</script>

<style>
.vuecal{
    font-family: 'meetMe';
    font-size: 30px;
    border: 5px solid #4F3612;
    border-radius: 20px;
    margin: 2rem;
    overflow: hidden;
}
.vuecal__title-bar{
    background-color: #FFD9A6;
}
.back-space{
    border-style: hidden;
    background-color: white;
    font-family: "meetMe";
    font-size: 30px;
    display: flex;
    position: relative;
    top: -1rem;
    left: -1rem;
  }

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
  background-color: #FFB74D;
  font-size: 40px;
  padding-top: 0.25em;
  padding-left: 2rem;
}

.right-header p {
  position: relative;
  top: -0.8rem;
  right: 1rem;
}
</style>