package com.example.scoop.service;

import java.util.ArrayList;

import com.example.scoop.domain.Workspace;

public interface WorkspaceService {

	public int insertWorkspace(Workspace workspace);

	public Workspace selectLately(String email);

	public int updateLately(Workspace workspace);

	public Workspace selectOne(int wsid);

	public ArrayList<Workspace> selectOwner(String email);

	public int selectKey(Workspace workspace);

	public int countOwner(String email);

}
