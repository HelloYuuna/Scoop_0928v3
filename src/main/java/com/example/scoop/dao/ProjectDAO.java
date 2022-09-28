package com.example.scoop.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;


@Mapper
public interface ProjectDAO {
	//public String updateContent(Project project);
	
	//공지사항 제목 가져오기
	public String selectContent(int pnum);
	
	//공지사항 갱신시 업데이트
	public int updateContent(Project pproject);
	
	//멤버 리스트 
	public ArrayList<User> selectMember();
	
	//멤버 셀렉트
	public String memberselect(String membername);
	
	//기존 목록에 업데이트를 해야한다. 
	
	//그 목록을 다시 select 해와야하 한다. 
	
	
	//메인에서 프로젝트 생성
	public int projectInsert(Project pproject);
	
	//메인 화면에서 프로젝트 목록 생성 
	public ArrayList<Project> selectProject();
	
	//프로젝트로 들어가기 
	public Project projectread(int pnum);
	
	//선택된 멤버를 프로젝트에 업데이트
	public int updatemember(HashMap<String, Object>map);

	public String choiceMember(int pnum);

	public int memberupdate(HashMap<String, Object>map);

	public int updateproject(Project project);

	public int deleteproject(Project project);
//
//	public int insertMember(User user);
//
//	public User findByName(String member);
	
	// 내작업공간에서 프로젝트 리스트 받아오기
	List<Project> findByWsid(int wsid);

}
