package com.example.scoop.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.scoop.domain.Workspace;

@Mapper
public interface WorkspaceDAO {

	public int insertWorkspace(Workspace workspace);

	public Workspace selectLately(String email);
	
	public int updateLately(Workspace workspace);

	public Workspace selectOne(int wsid);

	public ArrayList<Workspace> selectOwner(String email);

	public int selectKey(Workspace workspace);

	public int countOwner(String email);

}
