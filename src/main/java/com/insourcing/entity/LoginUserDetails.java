package com.insourcing.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class LoginUserDetails implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private boolean active;
    private String role;
    private boolean isnewuser;
    private String createdtimestamp;
    private String modifiedtimestamp;
    private String lastlogintime;
    private String fullname;
    private String empid;
    private String grade;
    private String phone;
    private String createdBy;

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	/**
	 * @return the isNewUser
	 */
	public boolean isNewUser() {
		return isnewuser;
	}

	/**
	 * @param isNewUser the isNewUser to set
	 */
	public void setNewUser(boolean isNewUser) {
		this.isnewuser = isNewUser;
	}

	/**
	 * @return the createdtimestamp
	 */
	public String getCreatedtimestamp() {
		return createdtimestamp;
	}

	/**
	 * @param createdtimestamp the createdtimestamp to set
	 */
	public void setCreatedtimestamp(String createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	/**
	 * @return the modifiedtimestamp
	 */
	public String getModifiedtimestamp() {
		return modifiedtimestamp;
	}

	/**
	 * @param modifiedtimestamp the modifiedtimestamp to set
	 */
	public void setModifiedtimestamp(String modifiedtimestamp) {
		this.modifiedtimestamp = modifiedtimestamp;
	}

	/**
	 * @return the lastLoginTime
	 */
	public String getLastLoginTime() {
		return lastlogintime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(String lastLoginTime) {
		this.lastlogintime = lastLoginTime;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return the empid
	 */
	public String getEmpid() {
		return empid;
	}

	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
}
