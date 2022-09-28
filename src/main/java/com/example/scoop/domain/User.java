package com.example.scoop.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * Oauth 인증용 도메인
 * 구글 API저장용
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name="scoop_member")
public class User implements UserDetails {

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


	//************************** implements UserDetails methods ****************************//

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * enabled
	 * 0 : false 비활성화
	 * 1 : true 활성화
	 * @return true/false
	 */
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}

