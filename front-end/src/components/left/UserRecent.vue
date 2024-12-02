<template>
    <div class="recent-list">
        <ul v-if="filteredDiarys.length">
            <li v-for="diary in filteredDiarys" :key="diary.dairyNo">
                <button @click="detailDiary">
                    <p class="diary-content">{{ diary.content }}</p>
                    <p class="diary-date">{{ diary.date }}</p>

                </button>
            </li>
        </ul>
        <p v-else-if="!filteredDiarys.length">아직 일기가 없다멍!</p>
    </div>
</template>

<script setup>
import { useDiaryStore } from '@/stores/diary';
import { onMounted, ref, watch } from 'vue';


const store = useDiaryStore();

const filteredDiarys = ref([]);

onMounted(
    store.getSummary
)

watch(
  () => store.summaryList,
  (newVal) => {
    filteredDiarys.value = newVal;
    console.log("watch triggered");
  }
);



</script>

<style scoped>
.recent-list{
    position: relative;
    top: 0.6rem;
    font-family: "meetMe";
    font-size: 30px;
}

.recent-list ul {
    padding: 0rem;
}

.recent-list ul li {
    position: relative;
    height: 4rem;
    list-style-type: none;
}

.recent-list ul li button {
    position: relative;
    background: white;
    /* border: white; */
    display: flex;
    width: 40rem;
    justify-content: space-between;
    background-color: #fde9cf;
    border-bottom: 3px solid #4F3612;
}

.diary-content {
    position: relative;
    width: 29rem;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    top: 0.5rem;
    margin-left: 1rem;
}

.diary-date {
    position: relative;
    top: 0.5rem;
    margin-right: 1rem;
}

.recent-list::-webkit-scrollbar{
  /* 필요하지 않으면 none 처리 */
  display: none;
  overflow: auto;
  width: 20px;
}
</style>