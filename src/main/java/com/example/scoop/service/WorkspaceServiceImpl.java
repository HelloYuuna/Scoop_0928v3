package com.example.scoop.service;

import java.util.ArrayList;

import com.example.scoop.dao.UserDAO;
import com.example.scoop.repository.UserRepository;
import com.example.scoop.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scoop.dao.WorkspaceDAO;
import com.example.scoop.domain.Workspace;

@Service
@Slf4j
public class WorkspaceServiceImpl implements WorkspaceService {

	@Autowired
	private WorkspaceDAO workspaceDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Override
	public Workspace selectLately(String email) {
		Workspace ws = workspaceDAO.selectLately(email);
		return ws;
	};
	
	@Override
	public int updateLately(Workspace workspace) {
		int result = workspaceDAO.updateLately(workspace);
		return result;
		
	}

	@Override
	public Workspace selectOne(int wsid) {
		Workspace workspace = workspaceDAO.selectOne(wsid);
		return workspace;
	}

	@Override
	public ArrayList<Workspace> selectOwner(String email) {
		ArrayList<Workspace> list = workspaceDAO.selectOwner(email);
		return list;
	}

	/**
	 * 새로운 워크스페이스 생성후 시퀀스 가져오기
	 * @param workspace 생성한 객체값
	 * @return wsid: 워크스페이스 pk
	 */
	@Override
	public int selectKey(Workspace workspace) {
//		int wsid = workspaceDAO.selectKey(workspace);

		int wsid = workspaceRepository.save(workspace).getWsid();
		log.debug("등록후 가져온 wsid: {}", wsid);

		workspace.setWsid(wsid);
		log.debug("넘길workspace: {}", workspace);
		int res = userDAO.updateWsid(workspace);

		return res;
	}

	@Override
	public int countOwner(String email) {
		int result = workspaceDAO.countOwner(email);
		return result;
	};

}
