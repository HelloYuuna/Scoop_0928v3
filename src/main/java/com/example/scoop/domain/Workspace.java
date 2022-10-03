package com.example.scoop.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "SCOOP_WORKSPACE_GENERATOR",
		sequenceName = "scoop_workspace_seq",
		allocationSize = 1)
@Table(name="scoop_workspace")
public class Workspace {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE
			, generator = "scoop_workspace_seq")
	int wsid;					// 워크스페이스 시퀀스

	@Column
	String wsname;				// 워크스페이스 이름

	@Column
	String wsowner;				// email

	@Column
	String lately;				// 추가된 날짜

	@Builder
	public Workspace(int wsid, String wsname, String wsowner, String lately) {
		this.wsid = wsid;
		this.wsname = wsname;
		this.wsowner = wsowner;
		this.lately = lately;
	}

}
