/**
 * com.tm.model
 * Knowlege.java
 * 创建人:lifan
 * 时间：2017年09月09日 21:31:59
 */
package com.tm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 知识点管理模块 Knowlege 
 * 创建人:lifan 
 * 时间：2017年09月09日 21:31:59
 * 
 * @version 1.0.0
 * 
 */
@Entity
@Table(name = "tm_knowlege")
public class Knowlege implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;/* 主键 */
	private String name;// 名称
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private Integer userId;// 用户ID
	private Integer isDelete;// 0未删除1删除
	private Integer status;// 0未发布1发布

	public Knowlege() {
		super();
	}
	
	public Knowlege(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 0, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP", updatable = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 0, nullable = true, columnDefinition = "datetime")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "is_delete", length = 1)
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "status", length = 1)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
