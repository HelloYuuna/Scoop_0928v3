package com.example.scoop.service;

import java.util.ArrayList;
import java.util.List;

import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;

public interface ProjectService {
	
	public int updateContent(Project pproject);

	public String selectContent(int pnum);

	public ArrayList<User> selectMember();

	public String memberselect(String membername);

	public int projectInsert(Project pproject);

	public ArrayList<Project> selectProject();
	
	public Project projectread(int pnum);

	public int updatemember(int pnum, User user);

	public String choiceMember(int pnum);

	public int memberupdate(String str, int pnum);

	public int updateproject(Project project);

	public int deleteproject(Project project);

	public int insertMember(String member);

	// 내작업공간에서 사용
	List<Project> findByWsid(int wsid);
	
}
