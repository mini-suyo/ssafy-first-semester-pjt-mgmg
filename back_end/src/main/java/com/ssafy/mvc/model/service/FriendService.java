package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dto.Friend;

import java.util.List;

public interface FriendService {

    // #1. 친구 등록
    boolean friendCreate(Friend friend);

    // #2. 친구 삭제
    boolean friendDelete(Friend friend);

    // #3. 친구 목록 불러오기
    List<Friend> friendRead(int userNo);

    // #4. 친구 인지 확인
    boolean isFriend(Friend friend);
}
