package com.ssafy.mvc.model.dao;

import com.ssafy.mvc.model.dto.Friend;

import java.util.List;

public interface FriendDao {

    int insertFriend(Friend friend);

    int deleteFriend(Friend friend);

    List<Friend> selectAlL(int userNo);

    int isFriend(Friend friend);
}
