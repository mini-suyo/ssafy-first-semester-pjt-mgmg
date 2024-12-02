import axios from "axios";
import { defineStore } from "pinia";
import { ref } from "vue";


const REST_API_URL = `http://localhost:8080/api-user`

export const useFriendStore = defineStore('friend', () => {

    const loginUserNo = ref();
    const searchedFriend = ref([]);
    const myFriendList = ref([]);


    // #1. 친구 검색
    const searchFriend = async function (id) {
        await axios.post(`${REST_API_URL}/searchFriend`, {
            id: id,
        })
            .then((response) => {
                searchedFriend.value = response.data.list;
                console.log(response.data.list)
            })
            .catch((err) => {
                alert("sss")
            })
    }

    // #2. 나의 친구 불러오기
    const friendList = function () {
        const token = sessionStorage.getItem('access-token').split('.');
        const userNo = JSON.parse(atob(token[1]))['userNo'];
        axios.post(`${REST_API_URL}/readFriend`, {
            userNo: userNo
        })
            .then((response) => {
                myFriendList.value = response.data.list;
            })
            .catch((err) => {
                console.log(err)
                alert("다시 시도해줘~")
            })
    }

    // #3. 친구 등록
    const registFriend = function (friendNo, friendName) {
        const token = sessionStorage.getItem('access-token').split('.');
        const userNo = JSON.parse(atob(token[1]))['userNo'];
        loginUserNo.value = userNo;

        axios.post(`${REST_API_URL}/createFriend`, {
            userNo: loginUserNo.value,
            friendNo: friendNo,
            friendName: friendName,
        })
            .then((response) => {
                console.log(response)
                alert(response.data.message);
                friendList();
            })
            .catch((err) => {
                console.log(err)
                alert(err.response.data.message);
            })
    }

    // #4. 친구 삭제
    const deleteFriend = function (friendNo, friendName) {
        const token = sessionStorage.getItem('access-token').split('.');
        const userNo = JSON.parse(atob(token[1]))['userNo'];
        loginUserNo.value = userNo;

        axios.delete(`${REST_API_URL}/deleteFriend`, {
            data: {
                userNo: loginUserNo.value,
                friendNo: friendNo,
                friendName: friendName,
            }
        })
            .then((response) => {
                console.log(response)
                alert(response.data.message);
                friendList();
            })
            .catch((err) => {
                console.log(err)
                alert(err.response.data.message);
            })

    }
    // #5. 친구인지 판별 
    const isFriendVal = ref(false)
    const isFriend = async function (friendNo) {
        const token = sessionStorage.getItem('access-token').split('.');
        const userNo = JSON.parse(atob(token[1]))['userNo'];
        loginUserNo.value = userNo;

        await axios.post(`${REST_API_URL}/isFriend`, {
            userNo: loginUserNo.value,
            friendNo: friendNo,
        })
        .then((response) =>{
            isFriendVal.value = response.data.flag
            console.log(response.data.message)
        })
        .catch((err)=> {
            console.log(err)
        })
    }


    return { searchedFriend, myFriendList, searchFriend, friendList, registFriend, deleteFriend, isFriend, isFriendVal }
})