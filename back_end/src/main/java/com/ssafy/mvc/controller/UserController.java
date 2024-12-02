package com.ssafy.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.mvc.model.dto.Friend;
import com.ssafy.mvc.model.dto.UpdatedUser;
import com.ssafy.mvc.model.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.mvc.jwt.JwtUtil;
import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

@RestController
@RequestMapping("/api-user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final FriendService friendService;
    private final JwtUtil jwtUtil;


    @Autowired
    public UserController(UserService userService, FriendService friendService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.friendService = friendService;
        this.jwtUtil = jwtUtil;
    }

    // #1.
    // 유저 로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> userLogin(@RequestBody User loginUser) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;

        User user = userService.getUserById(loginUser.getId());

        System.out.println(user);
        System.out.println(loginUser);

        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            result.put("message", "로그인 성공");
            result.put("access-token", jwtUtil.createToken(user.getUserNo(), user.getUserName(), user.isMateFlag()));
            status = HttpStatus.ACCEPTED;
        } else {
            result.put("message", "ID와 비밀번호를 확인해주세요.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    // #2.
    // 유저 회원가입
    @PostMapping("/regist")
    public ResponseEntity<Map<String, Object>> userRegist(@RequestBody User user) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;

        if (userService.getUserById(user.getId()) != null) {
            result.put("message", "회원 가입 실패 : 중복된 ID");
            status = HttpStatus.INTERNAL_SERVER_ERROR;

        } else {
            if (userService.userRegist(user)) {
                result.put("message", "회원 가입 성공");
                status = HttpStatus.CREATED;
            } else {
                result.put("message", "회원 가입 실패 : 일시적 서버 장애");
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
        return new ResponseEntity<>(result, status);
    }

    // #3.
    // 유저 업데이트
    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> userUpdate(@RequestBody UpdatedUser updatedUser) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;

        User user = userService.getUserByUserNo(updatedUser.getUserNo());
        if (user.getPassword().equals(updatedUser.getPassword())) {
            user.setPassword(updatedUser.getNewPassword());
            if (userService.userUpdate(user)) {
                result.put("message", "수정 완료");
                status = HttpStatus.OK;
            } else {
                result.put("message", "수정 실패");
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            result.put("message", "패스워드를 확인해주세요.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    // #4.
    // 유저 찾기
    @PostMapping("/getUserByUserNo")
    public ResponseEntity<Map<String, Object>> getUserByUserNo(@RequestBody User searchUser) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;
        System.out.println(searchUser);
        User user = userService.getUserByUserNo(searchUser.getUserNo());
        System.out.println(user);
        if (user != null) {
            result.put("friendNo", user.getUserNo());
            result.put("friendName", user.getUserName());
            result.put("friendId", user.getId());
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            result.put("message", "뭐가 이상해");
        }

        return new ResponseEntity<>(result, status);
    }
    // #5.
    // mateFlag 토글
    public void toggleFlag(int userNo) {
        userService.toggle(userNo);
    }
    //////////////////////////////////////////////////////////////////////////

    // # 1. 친구 등록
    // 여기 userNo은 from, userId는 to 관련임
    @PostMapping("/createFriend")
    public ResponseEntity<Map<String, Object>> friendCreate(@RequestBody Friend friend) {

        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;

        if (friendService.friendCreate(friend)) {
            result.put("message", "친구 추가 성공");
            status = HttpStatus.OK;
        } else {
            result.put("message", "친구 추가 실패");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }


        return new ResponseEntity<>(result, status);
    }

    // #2. 친구 찾기
    @PostMapping("/searchFriend")
    public ResponseEntity<Map<String, Object>> friendFind(@RequestBody User user) {
        System.out.println(user);
        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;

        List<User> list = userService.searchUser(user.getId());
        System.out.println(list);

        if (list != null) {
            result.put("message", "친구 찾기 성공");
            result.put("list", list);
            status = HttpStatus.OK;
        } else {
            result.put("message", "친구 찾기 실패");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(result, status);
    }

    // #3. 친구 삭제
    // // 여기 userNo은 from, userId는 to 관련임
    @DeleteMapping("/deleteFriend")
    public ResponseEntity<Map<String, Object>> friendDelete(@RequestBody Friend friend) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;
        System.out.println("여기 까지 왔다.");

        if (friendService.friendDelete(friend)) {
            result.put("message", "친구 삭제 성공");
            status = HttpStatus.OK;
        } else {
            result.put("message", "친구 삭제 실패");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);

    }

    // #4. 친구 목록 불러오기
    @PostMapping("/readFriend")
    public ResponseEntity<Map<String, Object>> friendRead(@RequestBody Friend friend) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;
        System.out.println(friend);
        List<Friend> list = friendService.friendRead(friend.getUserNo());
        System.out.println(list);

        if (list != null) {
            result.put("list", list);
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(result, status);
    }

    // #5.친구인지 확인
    @PostMapping("/isFriend")
    public ResponseEntity<Map<String, Object>> isFriend(@RequestBody Friend friend) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status = null;

        if(friendService.isFriend(friend)) {
            result.put("flag", true);
            result.put("message", "친구임");
            status = HttpStatus.OK;
        } else {
            result.put("flag",true);
            result.put("message", "친구 아님");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(result, status);
    }
}


