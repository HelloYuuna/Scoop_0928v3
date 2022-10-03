package com.example.scoop.repository;

import com.example.scoop.domain.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
}
