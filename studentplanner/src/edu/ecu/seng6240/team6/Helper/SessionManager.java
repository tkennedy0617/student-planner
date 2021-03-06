package edu.ecu.seng6240.team6.Helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.ecu.seng6240.team6.models.User;

public class SessionManager {
	
	private HttpSession session = null; 
	
	public SessionManager(HttpServletRequest request){
		this.session = request.getSession();
	}
	
	public boolean hasUser(){
		return this.session.getAttribute("User") != null;
	}
	
	public void setUser(User user){
		this.session.setAttribute("User", user);
	}
	
	public boolean isStudent(){
		if (this.session.getAttribute("User") != null && ((User) this.session.getAttribute("User")).getRole().equals(User.STUDENT_ROLE))
			return true;
		return false;
	}
	
	public boolean isAdmin(){
		if (this.session.getAttribute("User") != null && ((User) this.session.getAttribute("User")).getRole().equals(User.ADIN_ROLE))
			return true;
		return false;
	}
	
	public User getUser(){
		if(this.session.getAttribute("User") != null) return (User)this.session.getAttribute("User");
		return null;
	}
	
}
