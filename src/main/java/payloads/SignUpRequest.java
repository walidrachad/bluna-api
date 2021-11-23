package payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignUpRequest {

	private String username;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String password;
    private Long roleId;

	public SignUpRequest() {
	}

	public SignUpRequest(String username, String email, String password, Long roleId) {

		this.username = username;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
