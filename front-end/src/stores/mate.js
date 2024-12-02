import router from "@/router";
import axios from "axios";
import { defineStore } from "pinia"
import { ref } from "vue"

const REST_API_URL = `http://localhost:8080/api-mate`

export const useMateStore = defineStore('mate', () => {

    // #1. 강아지 등록
    const mateRegist = function(mateName, personality) {
        
        let token = sessionStorage.getItem('access-token').split('.');
        let userNo = JSON.parse(atob(token[1]))['userNo'];

        axios.post(`${REST_API_URL}/regist`, {
            userNo: userNo,
            mateName: mateName,
            personality: personality
        })
        .then((response) => {
            alert("등록 성공")
            router.push({name : `theRightHeader` })
        })
        .catch((err) => {
            console.log(err)
            alert("다시 시도해주세요.")
        })
    }

    // #2. 강아지 불러오기
    const createdMate = ref({});
    const getMate = function() {
        let token = sessionStorage.getItem('access-token').split('.');
        let userNo = JSON.parse(atob(token[1]))['userNo'];
        

        axios.post(`${REST_API_URL}/getMateByUserNo`,{
            userNo: userNo
        })
        .then((resonse) => {
            createdMate.value = resonse.data.mate
            
        })
        .catch((err)=> {

        })
    }

    return { mateRegist, getMate, createdMate }
})