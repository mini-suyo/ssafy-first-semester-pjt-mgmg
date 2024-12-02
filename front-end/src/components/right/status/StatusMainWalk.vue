<script setup>
import { KakaoMap, KakaoMapPolyline } from 'vue3-kakao-maps';
import { computed, ref, watch } from 'vue';
import router from '@/router';
import { useDiaryStore } from '@/stores/diary';
import { useMateStore } from '@/stores/mate';

const map = ref();

const latcurrent = ref(36.355073); // 위도
const lngcurrent = ref(127.298351); // 경도

//클릭시 바뀌는 위도 경도
const lat = ref();
const lng = ref();

//클릭 상태
const mode = ref('flower'); //1. 경로 표시 2.나무마커 3.꽃마커 4.강아지 마커
//클릭 상태 변경
const modeChange = function (what) {
  mode.value = what;
}


//////////// 폴리라인을 위한 것 ////////////
//폴리라인을 위한 배열
const polyList = ref([]);
const key1 = ref(0);


//////////// 마커를 위한 것 ///////////////
//마커를 위한 배열 + 카운터
const markerList = ref([]);

const key = ref(0);
//나무 객체
const tree = {
  imageSrc: 'http://localhost:5173/src/assets/marker/tree.png',
  imageWidth: 40,
  imageHeight: 40,
  imageOption: {},
}
//꽃 객체
const flower = {
  imageSrc: 'http://localhost:5173/src/assets/marker/flower.png',
  imageWidth: 40,
  imageHeight: 40,
  imageOption: {},
}
const cuteDog = {
  imageSrc: 'http://localhost:5173/src/assets/marker/dog.png',
  imageWidth: 40,
  imageHeight: 40,
  imageOption: {},
}
const hugeDog = {
  imageSrc: 'http://localhost:5173/src/assets/marker/huge-dog.png',
  imageWidth: 40,
  imageHeight: 40,
  imageOption: {},
}
const vet = {
  imageSrc: 'http://localhost:5173/src/assets/marker/vet.png',
  imageWidth: 40,
  imageHeight: 40,
  imageOption: {},
}
const soap = {
  imageSrc: 'http://localhost:5173/src/assets/marker/soap.png',
  imageWidth: 40,
  imageHeight: 40,
  imageOption: {},
}


// 최근 마커 삭제
const onDeleteMarker = () => {
  if (0 < markerList.value.length) {
    markerList.value.splice(markerList.value.length - 1, 1);
  };
}
// 최근 경로 되돌리기 
const onDeletePoly = () => {
  if (0 < polyList.value.length) {
    polyList.value.splice(polyList.value.length - 1, 1);
  }
}

//클릭했을 때, 위도 경도를 업데이트 함
//마커가 10개 이상이라면 경고창
const onLoadKakaoMap = (mapRef) => {

  map.value = mapRef;
  kakao.maps.event.addListener(map.value, 'click', function (mouseEvent) {

    const latlng = mouseEvent.latLng;

    lat.value = latlng.getLat();
    lng.value = latlng.getLng();


    if (mode.value === 'poly') {
      polyList.value.push({key: key.value++, lat: lat.value, lng: lng.value });
    } else {
      if (markerList.value.length < 11) {
        if (mode.value === 'tree') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: tree });
        } else if (mode.value === 'flower') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: flower });
        } else if (mode.value === 'cuteDog') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: cuteDog });
        } else if (mode.value === 'hugeDog') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: hugeDog });
        } else if (mode.value === 'vet') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: vet });
        } else if (mode.value === 'soap') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: soap });
        } 

      } else {
        alert("마커는 10개 까지 사용할 수 있다멍")
      }
    }
  });
};
////////////////////////////////


// #1.
// 일기 작성을 위한 로직
// 일기 작성 버튼 (인자 : 경로, 마커 배열)
const store = useDiaryStore();

const createDiary = function () {
  var polyDescriptions = polyList.value.map((poly, index) => `경로 ${index + 1}: 위도 ${poly.lat}, 경도 ${poly.lng}`).join('; ');
  var markerDescriptions = markerList.value.map(marker => `${marker.title} (위도: ${marker.lat}, 경도: ${marker.lng})`).join('; ');
  var prompt = `${polyDescriptions}를 순서대로 이으면 내가 오늘 강아지와 산책한 경로이고, 
                ${markerDescriptions}는 강아지가 산책하며 강아지가 좋아했던 것들의 이름과 위치야.
                경도위도를 직접적으로 쓰지말고, 그 길 위에 뭐가 있는지 구글맵 정보와 통합해서, 깜찍발랄한 강아지가 일기를 쓴 것 처럼 400자 이내로 일기를 써줘`;
  console.log(prompt)
  store.createDiary(prompt, polyList, markerList)
}

</script>







<template>
  <div class="right-header">
    <button class="back-space" @click="this.$router.go(-1)">
      < </button>
        <p>ㅡ ㅁ X</p>
  </div>
  <div class="kakao-map">
    <KakaoMap :lat="latcurrent" :lng="lngcurrent" @onLoadKakaoMap="onLoadKakaoMap" :markerList="markerList"
      width="39.4rem" height="35rem">
      <KakaoMapPolyline :latLngList="polyList" :endArrow="true" />
    </KakaoMap>
  </div>

  <div class="btn-location">
    <button @click="modeChange('poly')">
      <img class="map-icon" src="http://localhost:5173/src/assets/marker/milestones.png" />
    </button>
    <button @click="modeChange('tree')">
      <img class="map-icon" src="http://localhost:5173/src/assets/marker/tree.png" />
    </button>
    <button @click="modeChange('flower')">
      <img class="map-icon" src="http://localhost:5173/src/assets/marker/flower.png" />
    </button>
    <br>
    <!-- 여기부터 추가해서 modeChange추가 필요 -->
    <button @click="modeChange('cuteDog')">
      <img class="map-icon" src="http://localhost:5173/src/assets/marker/dog.png" />
    </button>
    <button @click="modeChange('hugeDog')">
      <img class="map-icon" src="http://localhost:5173/src/assets/marker/huge-dog.png" />
    </button>
    <button @click="modeChange('vet')">
      <img class="map-icon" src="http://localhost:5173/src/assets/marker/vet.png" />
    </button>
    <button @click="modeChange('soap')">
      <img class="map-icon" src="http://localhost:5173/src/assets/marker/soap.png" />
    </button>
    <!-- 여기까지 -->
    <br>
    <button @click="onDeletePoly">
      <img class="map-icon" src="http://localhost:5173/src/assets/icons/back-arrow.png" />
    </button>
    <button @click="onDeleteMarker">
      <img class="map-icon" src="http://localhost:5173/src/assets/icons/refresh-button.png" />
    </button>
    <button @click="createDiary">
      <img class="map-icon" src="http://localhost:5173/src/assets/icons/write-message.png" />
    </button>
  </div>
</template>

<style scoped>
.kakao-map{
  border-bottom: 5px solid #4F3612;
}

.btn-location{
  margin-top: 1.3rem;
}
.btn-location button{
  font-family: 'meetMe';
  font-size: 30px;
  background-color: #FFD9A6;
  border-radius: 20px;
  border: 5px solid #4F3612;
  position: relative;
  width: 100px;
  height: 100px;
  margin: 0.8rem;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease;
}
.btn-location button:hover {
  background-color: #FFB74D;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}
.btn-location button:active {
  background-color: #FF9A3D; /* 클릭 시 색 변경 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15); /* 클릭 시 그림자 약간 감소 */
  transform: translateY(2px); /* 클릭 시 눌리는 효과 */
}

.map-icon{
  zoom:14%;
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