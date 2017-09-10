package com.tm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;

/**
 * 角色实体<BR>
 * Role<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-下午9:15:32
 * 
 * @version 1.0.0
 * 
 */
@Entity
@Table(name = "tm_admin_role")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private String name;// 角色名称
	private String description;// 描述
	private Date createTime;// 创建时间
	private List<Permission> permissions = new ArrayList<Permission>(0);// 角色对应的权限，一个角色可以有多个权限

	// 空的构造方法
	public Role() {

	}

	// 传入id的构造方法
	public Role(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 100, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 1000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 0, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP", updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	// 产生一个中间表，角色对应权限的表，角色是主控方
	@JSON(serialize = false)
	@ManyToMany
	@JoinTable(name = "tm_admin_role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
