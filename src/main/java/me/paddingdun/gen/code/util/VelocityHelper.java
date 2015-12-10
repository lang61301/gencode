/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import me.paddingdun.gen.code.data.table.TableColumn;
import me.paddingdun.gen.code.data.tabletree.Table;

/**
 * @author paddingdun
 *
 * 2015年12月8日
 */
@Component
@Lazy(false)
public class VelocityHelper {
	
	/**
	 * VelocityHelper 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(VelocityHelper.class);

	private static VelocityHelper helper;
	
	@PostConstruct
	public void init(){
		helper = this;
	}
	
	@Resource(name="velocityEngine")
	private VelocityEngine  engine;
	
	public static String entityBean(Table table){
		table.setEntityBeanName(TableHelper.table(table.getTableName()));
		List<TableColumn> list = table.getColumns();
		for (TableColumn tc : list) {
			tc.setJavaType(TypesHelper.map_types.get(tc.getType()));
			String pn = TableHelper.col(tc.getColumnName());
			tc.setPropertyName(pn);
			tc.setSetMethod(TableHelper.set(pn));
			tc.setGetMethod(TableHelper.get(pn, tc.getType()));
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("date", DateHelper.now());
		PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(table);
		for (PropertyDescriptor pd : pds) {
			try {
				model.put(pd.getName(), PropertyUtils.getProperty(table, pd.getName()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} 
		}
		String s = VelocityEngineUtils.mergeTemplateIntoString(helper.engine, "template/velocity/EntityBean.vm", "utf-8", model);
		return s;
	}

}
