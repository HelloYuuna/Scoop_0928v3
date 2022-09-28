package com.example.scoop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int tnum;                           // 내작업 넘버
    private int wsid;                           // 워크스페이스 넘버
    private int pnum;                           // 프로젝트 넘버
    private String tcreator;                    // 생성자
    private int tpublic;                        // 0 비공 or 1 공
    private String tname;
    private String tcharge;                     // 담당자
    private String tsession;
    private String tstartperiod;
    private String tendperiod;
    private String texplain;
    private String tparticipaint;                // 참여 멤버
    private int tfinish;                        // 완료 여부 0 미완 1 완
    private String tregidate;                   // 생성일
}
