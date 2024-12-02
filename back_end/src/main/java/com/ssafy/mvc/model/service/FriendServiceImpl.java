package com.ssafy.mvc.model.service;

import com.ssafy.mvc.model.dao.FriendDao;
import com.ssafy.mvc.model.dto.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendDao friendDao;

    @Autowired
    public FriendServiceImpl(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    // #1. 친구 등록
    @Override
    public boolean friendCreate(Friend friend) {
        return friendDao.insertFriend(friend) == 1 ;
    }
    // #2. 친구 삭제
    @Override
    public boolean friendDelete(Friend friend) {
        return friendDao.deleteFriend(friend) == 1;
    }
    // #3. 친구 목록 불러오기
    @Override
    public List<Friend> friendRead(int userNo) {
        return friendDao.selectAlL(userNo);
    }

    @Override
    public boolean isFriend(Friend friend) {
        return friendDao.isFriend(friend) == 1;
    }
}
