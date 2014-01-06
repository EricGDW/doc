package com.itucity.yjreport.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_role", catalog = "yjreport")
public class Role implements java.io.Serializable{

	public enum RoleTypeEnum {
		ADMIN, USER_DERECTIVE, USER_RM, USER_GP, USER_BP, USER_SALES;
	}
	
	private static final long serialVersionUID = 2232022712086761077L;
	private Integer id;
	private String name;
	private RoleTypeEnum type;
	private String description;
	private boolean enable;

	public Role() {
	}

	public Role(Integer id, String name, RoleTypeEnum type, boolean enable) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.enable = enable;
	}

	public Role(Integer id, String name, String description, RoleTypeEnum type,
			boolean enable) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.enable = enable;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	public RoleTypeEnum getType() {
		return this.type;
	}

	public void setListorder(RoleTypeEnum type) {
		this.type = type;
	}

	@Column(name = "enable", nullable = false)
	public boolean isEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
