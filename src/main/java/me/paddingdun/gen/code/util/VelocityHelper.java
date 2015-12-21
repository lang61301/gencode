/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import me.paddingdun.gen.code.data.table.TableColumn;
import me.paddingdun.gen.code.data.tabletree.Table;
import me.paddingdun.gen.code.gui.view.dbtable.TableViewModel;

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
	
	public static String entityBean(TableViewModel tableViewModel){
		Table table = tableViewModel.getTable();
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
		CollectionHelper.object2Map(tableViewModel, model);
		String s = VelocityEngineUtils.mergeTemplateIntoString(helper.engine, "template/velocity/EntityBean.vm", "utf-8", model);
		return s;
	}
	
	public static String sqlMap(TableViewModel tableViewModel){
		Table table = tableViewModel.getTable();
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
		CollectionHelper.object2Map(tableViewModel, model);
		String s = VelocityEngineUtils.mergeTemplateIntoString(helper.engine, "template/velocity/SqlMap.vm", "utf-8", model);
		return s;
	}
	
	public static String dataTable(TableViewModel tableViewModel){
		Table table = tableViewModel.getTable();
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
		CollectionHelper.object2Map(tableViewModel, model);
		String s = VelocityEngineUtils.mergeTemplateIntoString(helper.engine, "template/velocity/DataTable.vm", "utf-8", model);
		return s;
	}

}
