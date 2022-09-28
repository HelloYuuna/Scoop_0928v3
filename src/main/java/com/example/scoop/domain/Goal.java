package com.example.scoop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 정보
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {

    int key; // 목표 넘버(시퀀스)
    int wsid; // 워크스페이스아이디
    String gname; // 목표제목
    String gstartdate; // 시작일
    String genddate; // 종료일
    int gstatus; // 진행상태(0:진행상태 , 1: 위험, 2:기간지남,3:완료,4:보류,5:목표완성,6:목표미완성,7:목표중지.
    String gstatus1;
    String uowner; // 소유자 이메일(update가능하도록)
    int gpublic; // 0:비공개, 1:공개
    String gmember; // 참가맴버 아이디등록
    int gfinish; // 0: 미완료, 1: 완료 (마일스톤)
    String gcreator; // 생성자 (못지움)
    String calendar; // 일 총합

}
