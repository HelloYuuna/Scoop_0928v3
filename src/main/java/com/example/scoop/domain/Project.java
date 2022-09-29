package com.example.scoop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	private int pnum;               // 프로젝트 시퀀스
	private String uemail;          // 유저아이디
	private int wsid;               // 워크스페이스 시퀀스
	private int key;                // 목표 시퀀스
	private String pnotice;         // 프로젝트 공지제목
	private String ptext;           // 프로잭트 공지내용
	private String pname;           // 프로젝트 이름
	private String powner;          // 프로젝트 소유자 (변경될 수 있음)
	private String pmember;
}
