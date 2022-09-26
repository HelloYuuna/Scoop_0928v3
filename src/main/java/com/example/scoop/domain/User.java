package com.example.scoop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="SCOOP_MEMBER")
public class User {
	@Id
	@Column(nullable = false, unique = true)
	private String email;				// 회원 아이디 이메일
	
	@Column
	private String password;			// 회원 비밀번호
	
	@Column(nullable = false)
	private String name;				// 회원 이름 (폼가입 시 꼭 받을것)

	@Column
	private String picture;				// 구글에서 받은 프로필사진

	@Enumerated(EnumType.STRING)
	@Column
	private Role role;

	@Column
	private int wsid;					// 워크스페이스 번호 (seq FK) 워크스페이스 생성시 부여
	
	@Column
	private String udept;				// 부서명

	@Column (columnDefinition = "number default '1'")
	private boolean enabled;            // 1 or 0 계정활성화
	
	@Builder
	public User(String email, String password, String name, String picture, Role role, int wsid, String udept, boolean enabled) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.picture = picture;
		this.role = role;
		this.wsid = wsid;
		this.udept = udept;
		this.enabled = enabled;
	}
	
	public User update(String name, String picture) {
		this.name = name;
		this.picture = picture;
		return this;
	}

	public User update(String name) {
		this.name = name;
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
}

