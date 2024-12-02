package com.ssafy.mvc.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class Diary {

    private int diaryNo;
    private int userNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String imgURL;
    private String content;
    //private List<LatLng> polyList;
    //private List<Marker> markerList;

    public int getDiaryNo() {
        return diaryNo;
    }
    // 기본 생성자
    public Diary() {}

    public void setDiaryNo(int diaryNo) {
        this.diaryNo = diaryNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public List<LatLng> getPolyList() {
//        return polyList;
//    }
//
//    public void setPolyList(List<LatLng> polyList) {
//        this.polyList = polyList;
//    }
//
//    public List<Marker> getMarkerList() {
//        return markerList;
//    }
//
//    public void setMarkerList(List<Marker> markerList) {
//        this.markerList = markerList;
//    }

    @Override
    public String toString() {
        return "Diary{" +
                "diaryNo=" + diaryNo +
                ", userNo=" + userNo +
                ", date=" + date +
                ", imgURL=" + imgURL +
                ", content=" + content +
                '}';
    }
}
