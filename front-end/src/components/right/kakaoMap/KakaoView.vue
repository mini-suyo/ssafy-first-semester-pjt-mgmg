<script setup>
import { KakaoMap, KakaoMapPolyline } from 'vue3-kakao-maps';
import { ref } from 'vue';
import router from '@/router';



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


//////////// 마커를 위한 것 ///////////////
//마커를 위한 배열 + 카운터
const markerList = ref([]);

const key = ref(0);
//나무 객체
const tree = {
  key: key.value,
  imageSrc: 'http://localhost:5173/src/assets/marker/tree.png',
  imageWidth: 40,
  imageHeight: 40,
  imageOption: {},
  clickable: "true"
}
//꽃 객체
const flower = {
  imageSrc: 'http://localhost:5173/src/assets/marker/flower.png',
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
      polyList.value.push({ lat: lat.value, lng: lng.value });
    } else {
      if (markerList.value.length < 11) {
        if (mode.value === 'tree') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: tree });
        } else if (mode.value === 'flower') {
          markerList.value.push({ key: key.value++, lat: lat.value, lng: lng.value, title: mode.value, image: flower });
        }
      } else {
        alert("마커는 10개 까지 사용할 수 있다멍")
      }
    }
  });
};

// 일기 작성 버튼 (인자 : 경로, 마커 배열)
const createDiary = function() {
  router.push("")
}

</script>

<template>
  <KakaoMap :lat="latcurrent" :lng="lngcurrent" @onLoadKakaoMap="onLoadKakaoMap" :markerList="markerList">
    <KakaoMapPolyline :latLngList="polyList" :endArrow="true" />

  </KakaoMap>

  <button @click="modeChange('poly')">선긋기</button>
  <button @click="modeChange('tree')">나무</button>
  <button @click="modeChange('flower')">꽃</button>
  <br>
  <button @click="onDeleteMarker">마커 되돌리기</button>
  <button @click="onDeletePoly">경로 되돌리기</button>
  <br>
  <button @click="createDiary">일기 작성</button>

</template>
