package com.tm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;

/**
 * 权限实体<BR>
 * Permission<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-下午9:21:25
 * @version 1.0.0
 *
 */
@Entity
@Table(name = "tm_admin_permission")
public class Permission implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private String name;// 权限名称
	private String url;// 权限链接,所有的功能操作
	private String model;// 访问模块
	private String method;// 模块中的方法
	private Integer sort;//排序
	private Integer isDelete;//删除状态0未删除1删除
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private Permission parent;// 定义个根权限
	private List<Permission> permissions = new ArrayList<Permission>(0);//自己映射自己，子权限


	public Permission() {
		
	}
	public Permission(Integer id){
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

	@Column(name = "name",nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url",length = 200)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "model", length = 100)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "method", length = 50)
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@JSON(serialize = false)
	@ManyToOne
	@JoinColumn(name = "parent_id")
	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
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

	@JSON(serialize = false)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Column(name="sort")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name = "is_delete", columnDefinition = "int(1) DEFAULT 0 comment '删除状态：(0：未删除，1：已删除)'", nullable = false)
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
