/**
 * com.tm.model
 * TmParams.java
 * 创建人:lifan
 * 时间：2017年09月09日 21:11:57
 */
package com.tm.model;

/**
 * 通用参数实体
 * TmParams 
 * 创建人:lifan
 * 时间：2017年09月09日 21:11:57
 * @version 1.0.0
 * 
 */
public class TmParams implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;// 主键id
	private String account;//账号
	private String password;//密码
	private String keyword;// 关键字
	private Integer isDelete;// 是否删除
	private Integer pageNo = 0;// 分页起始
	private Integer pageSize = 10;// 分页显示数
	private Integer totalCount = 0;// 总页数
	private String order;// 排序参数
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
