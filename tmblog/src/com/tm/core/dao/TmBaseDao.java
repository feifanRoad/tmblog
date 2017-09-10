package com.tm.core.dao;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.core.updateUtil.TmBeanUtil;
import com.tm.core.updateUtil.TmUpdater;



/**
 * <BR>
 * BaseDao<BR>
 * 创建人:lifan<BR>
 * 时间：2017年9月10日-上午9:54:19
 * @version 1.0.0
 *
 */
public class TmBaseDao<T,PK extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;
	//连接池
	public Session getSession() {
		if (sessionFactory!=null) {
//			return sessionFactory.openSession();//一定要手动关闭session
			return sessionFactory.getCurrentSession();//必须结合事务才有意义
		}
		return null;
	}
	
	/**
	 * 更新对象<BR>
	 * 方法名：updateDefault<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午10:06:34
	 * @param entity
	 * @return T
	 * @exception 
	 * @since  1.0.0
	 */
	public T updateDefault(T entity) {
		return updateByUpdater(TmUpdater.create(entity));
	}
	
	
	@SuppressWarnings("rawtypes")
	private ClassMetadata getClassMetadata(Class clazz) {
		return (ClassMetadata) sessionFactory.getClassMetadata(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public T updateByUpdater(TmUpdater updater) {
		ClassMetadata cm = getClassMetadata(updater.getBean().getClass());
		if (cm == null) {
			throw new RuntimeException("所更新的对象没有映射或不是实体对象");
		}
		Object bean = updater.getBean();
		T po = (T) getSession().load(bean.getClass(),cm.getIdentifier(bean));
		updaterCopyToPersistentObject(updater, po);
		return po;
	}
	
	/**
	 * 将更新对象拷贝至实体对象，并处理many-to-one的更新<BR>
	 * 方法名：updaterCopyToPersistentObject<BR>
	 * 创建人：lifan <BR>
	 * 时间：2017年9月10日-上午10:11:58
	 * @param updater
	 * @param po void
	 * @exception 
	 * @since  1.0.0
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void updaterCopyToPersistentObject(TmUpdater updater, Object po) {
		Map map = TmBeanUtil.describe(updater.getBean());
		Set<Map.Entry<String, Object>> set = map.entrySet();
		for (Map.Entry<String, Object> entry : set) {
			String name = entry.getKey();
			Object value = entry.getValue();
			if (!updater.isUpdate(name, value)) {
				continue;
			}
			if (value != null) {
				Class valueClass = value.getClass();
				ClassMetadata cm = getClassMetadata(valueClass);
				if (cm != null) {
					Serializable vid = cm.getIdentifier(value);
					// 如果更新的many to one的对象的id为空，则将many to one设置为null。
					if (vid != null) {
						value = getSession().load(valueClass, vid);
					} else {
						value = null;
					}
				}
			}
			try {
				PropertyUtils.setProperty(po, name, value);
			} catch (Exception e) {
			}
		}
	}
}
