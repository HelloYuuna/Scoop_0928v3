package com.example.scoop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scoop.domain.Project;
import com.example.scoop.domain.User;
import com.example.scoop.dao.ProjectDAO;

import lombok.extern.slf4j.Slf4j;
import com.example.scoop.domain.Project;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectdao;

	// public String updateContent(Project project) {
	//
	// String result = projectdao.updateContent(project);
	//
	// return result;
	// }

	// public ArrayList<Project> selectContent(){
	//
	// ArrayList<Project> list = projectdao.selectContent();
	//
	// // if(project.getCount() == ' ') {
	// // list.setCount('');
	// // }
	// return list;
	// }

	@Override
	public int updateContent(Project pproject) {
		int result = projectdao.updateContent(pproject);

		return result;
	}

	@Override
	public String selectContent(int pnum) {
		String result = projectdao.selectContent(pnum);

		return result;
	}

	@Override
	public ArrayList<User> selectMember() {

		ArrayList<User> result = projectdao.selectMember();
		return result;

	}

	public String memberselect(String membername) {

		String result = projectdao.memberselect(membername);
		return result;
	}

	public int projectInsert(Project pproject) {

		int result = projectdao.projectInsert(pproject);

		return result;
	}

	public ArrayList<Project> selectProject() {

		ArrayList<Project> result = projectdao.selectProject();
		return result;

	}

	public Project projectread(int pnum) {

		Project pproject = projectdao.projectread(pnum);

		return pproject;
	}

	public int updatemember(int pnum, User user) {
		// select String으로 pmember 다 받아오고
		String pmember = choiceMember(pnum);
		pmember += user.getUsername();
		// map을 선언한다. pnum과 user를 넘기는
		HashMap<String, Object> map = new HashMap<>();

		map.put("pmember", pmember);

		int result = projectdao.updatemember(map);

		return result;
	}

	public String choiceMember(int pnum) {

		String result = projectdao.choiceMember(pnum);
		return result;
	}

	public int memberupdate(String str, int pnum) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("pmember", str);
		map.put("pnum", pnum);

		int result = projectdao.memberupdate(map);

		return result;
	}

	public int updateproject(Project project) {
		int result = projectdao.updateproject(project);

		return result;

	}

	public int deleteproject(Project project) {

		int result = projectdao.deleteproject(project);
		return result;

	}

	@Override
	public int insertMember(String member) {
		log.debug("member :{}", member);

		// User user = projectdao.findByName(member);
		// log.debug("찾아온 유저 정보: {}", user);

		// return projectdao.insertMember(user);
		return 0;
	}

	/**
	 * 내작업공간에 사용
	 * 등록된 프로젝트 가져오기
	 * @param wsid 워크스페이스 아이디
	 * @return 프로젝트 리스트 리턴
	 */
	@Override
	public List<Project> findByWsid(int wsid) {
		return projectdao.findByWsid(wsid);
	}

}
