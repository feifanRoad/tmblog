/**
 * com.tm.dao.knowlege
 * Knowlege.java
 * 创建人:lifan
 * 时间：2017年09月09日 21:31:59
 */
package com.tm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tm.core.dao.TmBaseDao;
import com.tm.model.Knowlege;

/**
 * 知识点管理模块<BR>
 * KnowlegeDao<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-上午9:03:41
 * @version 1.0.0
 *
 */
@Repository
@Transactional
public class KnowlegeDao extends TmBaseDao<Knowlege, Integer>{

	/**
	 * 查询方法<BR>
	 * 方法名：findKnowlege<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午11:56:48
	 * @param name
	 * @return Knowlege
	 * @exception 
	 * @since  1.0.0
	 */
	public Knowlege getKnowlege(Integer id){
		Knowlege knowlege = (Knowlege) getSession()
				.createQuery("from Knowlege where id = ? and isDelete = 0")
				.setInteger(0, id).uniqueResult();
		System.out.println("+++++++++++++++++++查询成功");
		return knowlege;
	}
	/**
	 * 保存数据<BR>
	 * 方法名：saveKnowlege<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午11:04:31
	 * @param knowlege void
	 * @exception 
	 * @since  1.0.0
	 */
	public Knowlege saveKnowlege(Knowlege knowlege){
		try {
			getSession().save(knowlege);
			return knowlege;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("保存数据失败");
		}
	}
	
	/**
	 * 更新方法<BR>
	 * 方法名：updata<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午11:16:26
	 * @param period
	 * @return Knowlege
	 * @exception 
	 * @since  1.0.0
	 */
	public Knowlege updata(Knowlege knowlege){
		try {
			updateDefault(knowlege);
			return knowlege;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新数据失败");
		}
	}
	
	/**
	 * 真实删除数据(慎用)<BR>
	 * 方法名：delete<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午11:49:42
	 * @param id
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean delete(Integer id){
		try {
			Knowlege Knowlege= (Knowlege) getSession().load(Knowlege.class, id);
			getSession().delete(Knowlege);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
