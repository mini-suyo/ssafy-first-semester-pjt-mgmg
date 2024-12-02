import StatusMainTodayDiary from "@/components/right/status/StatusMainTodayDiary.vue";
import StatusMainWalk from "@/components/right/status/StatusMainWalk.vue";
import router from "@/router"
import axios from "axios"
import { defineStore } from "pinia";
import { ref } from "vue";

const REST_API_URL = `http://localhost:8080/api-diary`
const OPENAI_URL = "https://api.openai.com/v1/chat/completions"
const VITE_OPENAI_API_KEY = import.meta.env.VITE_OPENAI_API_KEY;



export const useDiaryStore = defineStore('diary', () => {

  // #1. AI 일기 작성 함수
  // AI로 글을 쓰고, 표시할 페이지에서 store.generatedDiary로 부르겠음
  // 여기에서 map 요소를 같이 받음
  const generatedDiary = ref(null);
  const receivedPolyList = ref([]);
  const receivedMarkerList = ref([]);
  const token = sessionStorage.getItem('access-token').split('.');
  const userNo = JSON.parse(atob(token[1]))['userNo'];
  // 'yyyy-mm-dd' 형식으로 포맷팅
  let selectedDate = new Date()
  let year = selectedDate.getFullYear();
  let month = String(selectedDate.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작
  let day = String(selectedDate.getDate()).padStart(2, '0');
  let formattedDate = `${year}-${month}-${day}`;


  const createDiary = async function (prompt, polyList, markerList) {
    try {
      const response = await axios.post(OPENAI_URL, {
        model: "gpt-4o-mini", // 필요한 모델로 변경
        messages: [
          {
            role: "assistant",
            content: "you are a dog",
          },
          {
            role: "user",
            content: prompt,
          }],
        n: 2
      },
        {
          headers: {
            Authorization: `Bearer ${VITE_OPENAI_API_KEY}`
          }
        }
      );
      generatedDiary.value = response.data.choices[1].message.content;
      receivedPolyList.value = polyList;
      receivedMarkerList.value = markerList;

      router.push({ name: 'statusTodayDiary' });

    } catch (err) {
      console.log(err);
      router.push({ name: 'statusWalk' });
    }
  }

  //임시용 aI고장
  const aitest = function(prompt) {
    const polyList = ref([
      { lat: 37.7749, lng: -122.4194 },
      { lat: 34.0522, lng: -118.2437 }
    ]);
  
    const markerList = ref([
      { lat: 40.7128, lng: -74.0060 },
      { lat: 51.5074, lng: -0.1278 }
    ]);
    generatedDiary.value = prompt
    receivedPolyList.value = polyList.value;
    receivedMarkerList.value = markerList.value;
    router.push({ name: 'statusTodayDiary' });
  }

  // #2.
  // 일기를 DiaryDB에 저장하기 위한 함수

  const saveDiary = function (imgURL, content) {
    
    axios.post(`${REST_API_URL}/create`, {
      userNo: userNo,
      date: formattedDate,
      imgURL: imgURL,
      content: content,
      //polyList: receivedPolyList.value,
      //markerList: receivedMarkerList.value
    })
      .then((response) => {
        alert("참 잘했다멍")
        getSummary();

      })
      .catch((err) => {
        alert("다시 시도해달라 멍")
      })
  }

  // #3.
  // 일기 불러오는 함수들
  const diaryList = ref([]);
  const events = ref([]);

  const convertDiaryToEvents = function (diaryList) {
    events.value = diaryList.value.map(diary => ({
      start: diary.date,
      end: diary.date, // 단일 날짜 이벤트인 경우 start와 end를 동일하게 설정
      title: `일기 #${diary.date}`,
      content: diary.content,
      class: 'blue-event', // 색 조정
      deletable: false,
      resizable: false,
      draggable: false
    }));
  }

  const getDiary = async function () {

    await axios.post(`${REST_API_URL}/read`, {
      userNo: userNo,
    })
      .then((response) => {
        diaryList.value = response.data.list;
        convertDiaryToEvents(diaryList)
        
      })
      .catch((err) => {
        console.log(err);
        alert("새로고침 후 이용해주세요.")
      })
  }

  // #4.
  // 일기 요약 불러오기 최대 10개
  const summaryList = ref([]);

  const getSummary = async function () {

    await axios.post(`${REST_API_URL}/summary`, {
      userNo: userNo,
    })
    .then((response) => {
      summaryList.value = response.data.list
    })
    .catch((err)=>{
      alert("일기 읎다")
    })
  }

  


  return { createDiary, generatedDiary, saveDiary, getDiary, events,aitest, getSummary,summaryList }
})