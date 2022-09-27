package com.example.scoop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scoop.dao.WorkspaceDAO;
import com.example.scoop.domain.Workspace;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

	@Autowired
	private WorkspaceDAO workspaceDAO;
	
	@Override
	public int insertWorkspace(Workspace workspace) {
		int result = workspaceDAO.insertWorkspace(workspace);
		return result;
	}

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

	@Override
	public int selectKey(Workspace workspace) {
		int result = workspaceDAO.selectKey(workspace);
		return result;
	}

	@Override
	public int countOwner(String email) {
		int result = workspaceDAO.countOwner(email);
		return result;
	};

}
