package com.ssafy.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.mvc.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Mate;
import com.ssafy.mvc.model.service.MateService;


@RestController
@RequestMapping("/api-mate")
@CrossOrigin("*")
public class MateController {

	private final UserController userController;
	private MateService mateService;
	
	@Autowired
	public MateController(MateService mateService, UserController userController) {
		this.mateService = mateService;
		this.userController = userController;
	}
	
	// UserNo로 메이트 찾기
	@PostMapping("/getMateByUserNo")
	public ResponseEntity<Map<String, Object>> getMateByUserNo(@RequestBody Mate mate) {
		
		HttpStatus status = null; 
		Map<String, Object> result = new HashMap<>();
		
		Mate mateCreated = mateService.getByUserNo(mate.getUserNo());
		
		if (mateCreated != null) {
			result.put("message", "mate찾기 성공");
			result.put("mate", mate);
			status = HttpStatus.OK;
		} else {
			result.put("message", "mate찾기 실패");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(result, status);
	}
	
	// 메이트 등록
	@PostMapping("/regist")
	public ResponseEntity<Map<String, Object>> regist(@RequestBody Mate mate) {

		System.out.println(mate);
		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();
		
		if (mateService.insertMate(mate)) {
			result.put("message","메이트 등록 완료");
			status = HttpStatus.CREATED;
			userController.toggleFlag(mate.getUserNo());
		} else {
			result.put("message","메이트 등록 실패");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(result, status);
	}
	
	// mateNo로 메이트 수정
	@PutMapping("/{mateNo}")
	public ResponseEntity <Map<String, Object>> update (@PathVariable int mateNo, @RequestBody Mate updatedMate) {
		
		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();
		
		if(mateService.updateMate(updatedMate)) {
			result.put("message","메이트 수정 완료");
			status = HttpStatus.OK;

		} else {
			result.put("message","메이트 수정 실패");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(result, status);
	}

	// mateNo로 메이트 삭제
	@DeleteMapping("/{mateNo}")
	public ResponseEntity<Map<String, Object>> delete (@PathVariable int mateNo) {

		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();

		if(mateService.deleteMate(mateNo)) {
			result.put("message", "메이트 삭제 성공");
			status = HttpStatus.OK;
		} else {
			result.put("message", "메이트 삭제 실패");
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(result, status);
	}
	// mate가 있는지 확인
	@PostMapping("/isConnected")
	public ResponseEntity<Map<String, Object>> isConnected(@RequestBody Mate mate) {

		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();

		Mate createdMate = mateService.getByUserNo(mate.getUserNo());
		System.out.println(createdMate);
		if (createdMate != null) {
			result.put("flag", true);
			status = HttpStatus.OK;
		} else {
			result.put("flag", false);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(result, status);
	}
}
