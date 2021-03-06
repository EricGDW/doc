package com.itucity.yjreport.dao.entity;
// default package
// Generated Jan 6, 2014 2:04:07 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserDetail generated by hbm2java
 */
@Entity
@Table(name = "user_detail", catalog = "yjreport")
public class UserDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2572011851882743302L;
	private String id;
	private Users users;
	private String userType;
	private String firstName;
	private String lastName;
	private String email;
	private String idCard;
	private String phone;
	private String mobilePhone;
	private String province;
	private String city;
	private String zone;
	private String address;
	private Date createTime;
	private Date lastUpdate;
	private Byte deleted;

	public UserDetail() {
	}

	public UserDetail(String id, Users users, String firstName,
			String lastName, String email, String idCard, Date createTime) {
		this.id = id;
		this.users = users;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.idCard = idCard;
		this.createTime = createTime;
	}

	public UserDetail(String id, Users users, String userType,
			String firstName, String lastName, String email, String idCard,
			String phone, String mobilePhone, String province, String city,
			String zone, String address, Date createTime, Date lastUpdate,
			Byte deleted) {
		this.id = id;
		this.users = users;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.idCard = idCard;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.province = province;
		this.city = city;
		this.zone = zone;
		this.address = address;
		this.createTime = createTime;
		this.lastUpdate = lastUpdate;
		this.deleted = deleted;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "user_type")
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "first_name", nullable = false, length = 10)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "id_card", nullable = false, length = 18)
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "phone", length = 13)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "mobile_phone", length = 11)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "province", length = 32)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 32)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zone", length = 32)
	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Column(name = "address", length = 120)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "deleted")
	public Byte getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

}
