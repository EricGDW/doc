package com.itucity.yjreport.dao.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "test_user", catalog = "yjreport")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7799081309778507695L;
	private int id;
	private String username;
	private String password;
	private String email;
	private Date lastlogintime;
	private String lastloginip;
	private Set<Role> roles = new HashSet<Role>(0);
	private boolean enable;

	public User() {
	}

	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(int id, Set<Role> roles, String username, String password, 
			String email, Date lastlogintime, String lastloginip, 
			boolean enable) {
		this.id = id;
		this.roles = roles;
		this.username = username;
		this.password = password;
		this.email = email;
		this.lastlogintime = lastlogintime;
		this.lastloginip = lastloginip;
		this.enable = enable;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 10)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToMany(
		targetEntity=com.itucity.yjreport.dao.entity.Role.class,
		cascade ={CascadeType.PERSIST,CascadeType.MERGE},
		fetch=FetchType.LAZY
	)
	@JoinTable(
		name="test_user_role",
		joinColumns={@JoinColumn(name="user_id")},
		inverseJoinColumns={@JoinColumn(name="role_id")}
	)
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", nullable = true, length = 40)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_time", length = 19)
	public Date getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	@Column(name = "last_login_ip", nullable = true, length = 15)
	public String getLastloginip() {
		return this.lastloginip;
	}

	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}
	
	@Column(name = "enable", nullable = true)
	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
