package com.web.HealCraft.userprofile.dto;

public class JwtResponse {
	
	public String token;
    public String email;

    public JwtResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", email=" + email + "]";
	}
    
}
