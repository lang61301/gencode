/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import me.paddingdun.gen.code.data.edit.EditValueGenWay;
import me.paddingdun.gen.code.data.edit.EditValueGenWayType;
import me.paddingdun.gen.code.data.edit.ValidatorType;
import me.paddingdun.gen.code.data.option.ModelValue;
import me.paddingdun.gen.code.data.option.ModelValueCategory;
import me.paddingdun.gen.code.data.table.DBColumn;
import me.paddingdun.gen.code.data.table.JspColumn;
import me.paddingdun.gen.code.data.table.QueryColumn;
import me.paddingdun.gen.code.data.table.Sort;
import me.paddingdun.gen.code.data.table.TableColumn;
import me.paddingdun.gen.code.data.tabletree.Table;
import me.paddingdun.gen.code.gui.view.dbtable.TableViewModel;

/**
 * @author paddingdun
 *
 * 2015年12月22日
 */
public class ModelHelper {
	static Set<Class<?>> BASIC_CLASS = new HashSet<Class<?>>();
	static{
		BASIC_CLASS.add(short.class);
		BASIC_CLASS.add(short.class);
		BASIC_CLASS.add(int.class);
		BASIC_CLASS.add(long.class);
		BASIC_CLASS.add(float.class);
		BASIC_CLASS.add(double.class);
		BASIC_CLASS.add(boolean.class);
		BASIC_CLASS.add(char.class);
		BASIC_CLASS.add(byte.class);
		
		BASIC_CLASS.add(java.lang.String.class);
		BASIC_CLASS.add(java.lang.Short.class);
		BASIC_CLASS.add(java.lang.Integer.class);
		BASIC_CLASS.add(java.lang.Long.class);
		BASIC_CLASS.add(java.lang.Float.class);
		BASIC_CLASS.add(java.lang.Double.class);
		BASIC_CLASS.add(java.lang.Character.class);
		BASIC_CLASS.add(java.lang.Boolean.class);
		BASIC_CLASS.add(java.lang.Byte.class);
		
	}
	
	/**
	 * 复杂获取,简单设置;
	 * @param src
	 * @param dest
	 */
	public static void complexGetAndSimpleSet(Object src, Object dest){
		complexGetAndSimpleSet(src, dest, ModelValueCategory.Default);
	}
	
	public static void complexGetAndSimpleSet(Object src, Object dest, ModelValueCategory category){
		if(src != null
				&& dest != null){
			Field[] fields = src.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String pName = field.getName();
				Class<?> clazz = field.getType();
				ModelValue mv = field.getAnnotation(ModelValue.class);
				if(mv != null
						&& mv.category() == category){
					String valueGetFuncName = mv.valueGetFuncName();
					try {
						field.setAccessible(true);
						Object value = field.get(src);
						if(BASIC_CLASS.contains(clazz)){
							PropertyUtils.setProperty(dest, pName, value);
						}else{
							//复杂类型尝试调用 getValue 方法;
							Object v = MethodUtils.invokeMethod(value, valueGetFuncName, new Object[0]);
							PropertyUtils.setProperty(dest, pName, v);
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * 简单获取,复杂设置;
	 * @param src
	 * @param dest
	 */
	public static void simpleGetAndComplexSet(Object src, Object dest){
		simpleGetAndComplexSet(src, dest, ModelValueCategory.Default);
	}
	
	public static void simpleGetAndComplexSet(Object src, Object dest, ModelValueCategory category){
		if(src != null 
				&& dest != null){
			Field[] fields = dest.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String pName = field.getName();
				Class<?> clazz = field.getType();
				ModelValue mv = field.getAnnotation(ModelValue.class);
				if(mv != null
						&& mv.category() == category){
					String valueSetFuncName = mv.valueSetFuncName();
					try {
						field.setAccessible(true);
						Object value = PropertyUtils.getProperty(src, pName);
						Class<?> paramClass = PropertyUtils.getPropertyType(src, pName);
						if(BASIC_CLASS.contains(clazz)){
							field.set(dest, value);
						}else{
							//复杂类型尝试调用 getValue 方法;
							Object field_object = field.get(dest);
							if(field_object == null){
								System.out.println(pName);
							}else
								try{
									if(value == null){
										MethodUtils.invokeMethod(field_object, valueSetFuncName, new Object[]{value}, new Class[]{paramClass});
									}else{
										MethodUtils.invokeMethod(field_object, valueSetFuncName, new Object[]{value});
									}
								}catch(Exception e4){
									throw new RuntimeException(e4);
								}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * 生成查询参数;
	 * @param columnName
	 * @param type
	 * @return
	 */
	public static String defaultQueryColumnJson(DBColumn column){
		QueryColumn qp = new QueryColumn();
		qp.setRelColumnName(column.getColumnName());
		qp.setPropertyName(TableHelper.col(column.getColumnName()));
		qp.setJavaType(TypesHelper.map_types.get(column.getType()));
		qp.setLogic("t1.{0} = {1}");
		List<QueryColumn> list = new ArrayList<QueryColumn>();
		list.add(qp);
		String result = GsonHelper.create(true, true).toJson(list);
		return result;
	}
	
	/**
	 * 1.如果是time或者date字段,将给time或者date;
	 * @param column
	 * @return
	 */
	public static String defaultEditValueGenWayJson(DBColumn column){
		EditValueGenWay evg = new EditValueGenWay();
		evg.setNew1(EditValueGenWayType.input);
		evg.setEdit(EditValueGenWayType.input);
		if(TypesHelper.isTimestampType(column.getType())){
			evg.setNew1(EditValueGenWayType.time);
			evg.setEdit(EditValueGenWayType.time);
		}else if(TypesHelper.isDateType(column.getType())){
			evg.setNew1(EditValueGenWayType.date);
			evg.setEdit(EditValueGenWayType.date);
		}else if(column.isPrimary()){
			if(column.isAutoIncrement()){
				evg.setNew1(EditValueGenWayType.nothing);
				evg.setEdit(EditValueGenWayType.nothing);
			}
		}
		String result = GsonHelper.create(true, true).toJson(evg);
		return result;
	}
	
	/**
	 * add by 2016年3月18日
	 * 生成默认的验证json;
	 * @param column
	 * @return
	 */
	public static String defaultEditValidateJson(DBColumn column){
		String columnName = column.getColumnName();
		Map<String, Map<String, Object>> validators = new LinkedHashMap<String, Map<String, Object>>();
		//判断是否不能为空;
		if(!column.isNullable()){
			validators.put(ValidatorType.notEmpty.name(), BootstrapValidateHelper.validator(ValidatorType.notEmpty));
		}
		
		//如果为string;
		if(TypesHelper.isStringType(TypesHelper.map_types.get(column.getType()))){
			int cs = column.getColumnSize();
			if(cs > 0){
				validators.put(ValidatorType.stringLength.name(), BootstrapValidateHelper.validator(ValidatorType.stringLength, "0", String.valueOf(cs)));
			}
			
			//添加ip验证;
			if(columnName.toLowerCase().indexOf("ip")>-1){
				validators.put(ValidatorType.ip.name(), BootstrapValidateHelper.validator(ValidatorType.ip));
			}
			
			//添加邮箱验证;
			if(columnName.toLowerCase().indexOf("email")>-1){
				validators.put(ValidatorType.emailAddress.name(), BootstrapValidateHelper.validator(ValidatorType.emailAddress));
			}
		}
		
		//如果为整形数字;
		if(TypesHelper.isIntegerType(TypesHelper.map_types.get(column.getType()))){
			validators.put(ValidatorType.integer.name(), BootstrapValidateHelper.validator(ValidatorType.integer));
		}
		
		String result = null;
		
		if(!validators.isEmpty()){
			Map<String, Map<String, Map<String, Map<String, Object>>>> p = new LinkedHashMap<String, Map<String, Map<String, Map<String, Object>>>>();
			Map<String, Map<String, Map<String, Object>>> v = new LinkedHashMap<String, Map<String, Map<String, Object>>>();
			v.put("validators", validators);
			p.put(TableHelper.col(columnName), v);
			result = GsonHelper.create(false, true).toJson(p);
		}
		return result;
	}
	
	/**
	 * add by 2016年3月21日
	 * 新增jsp页面中js验证;
	 * @param jspColumn
	 * @return
	 */
	public static String editJSValidtors(List<JspColumn> jspColumn){
		String result = null;
		Map<String, Map<String, Map<String, Map<String, Object>>>> tmp  = new LinkedHashMap<String, Map<String, Map<String, Map<String, Object>>>>();
		Gson gson = GsonHelper.create(false, true);
		for (JspColumn jc : jspColumn) {
			//1.必须是编辑;
			//2.非自增长字段;
			if(jc.isEditRenderShow()
					&& !jc.isAutoIncrement()){
				String str = jc.getEditValidateJson();
				if(StringUtils.isNotBlank(str)){
					Map<String, Map<String, Map<String, Map<String, Object>>>> p  = gson.fromJson(str, new TypeToken<Map<String, Map<String, Map<String, Map<String, Object>>>>>(){}.getType());
					//脱掉名称;
					if(!p.values().isEmpty()){
						Map<String, Map<String, Map<String, Object>>> p0 = p.values().iterator().next();
						
						//脱掉validators
						if(!p0.values().isEmpty()){
							Map<String, Map<String, Object>> p1 = p0.values().iterator().next();
							Collection<Map<String, Object>> c2 = p1.values();
							for (Map<String, Object> m3 : c2) {
								Set<Entry<String, Object>> s3 = m3.entrySet();
								for (Entry<String, Object> e4 : s3) {
									String key = e4.getKey();
									if("message".equals(key)){
										String value = (String)e4.getValue();
										if(StringUtils.isNotBlank(value)){
											String new_value = MessageFormat.format(value, jc.getColumnTitle());
											e4.setValue(new_value);
											break;
										}
									}
								}
							}
						}
					}
					
					tmp.putAll(p);
				}
			}
		}
		if(!tmp.isEmpty()){
			result = gson.toJson(tmp);
		}
		return result;
	}
	
	/**
	 * 显示排序;
	 * @param list
	 */
	public static void processSeq(List<TableColumn> list){
		Collections.sort(list);
	}
	
	/**
	 * 处理排序集合;
	 * @param list
	 * @return
	 */
	private static List<Sort> processSort(List<TableColumn> list){
		List<Sort> result = new ArrayList<Sort>();
		for (TableColumn tc : list) {
			Integer order = tc.getOrder();
			if(order != null){
				Sort sort = new Sort();
				sort.setColumnName(tc.getColumnName());
				if(order < 0){
					sort.setDirect("desc");
				}
				sort.setSeq(Math.abs(order));
				result.add(sort);
			}
		}
		Collections.sort(result);
		return result;
	}
	
	/**
	 * 加工model,准备数据;
	 * @param tableViewModel
	 */
	public static void processTableViewModel(TableViewModel tableViewModel){
		Table table = tableViewModel.getTable();
		table.setEntityBeanName(TableHelper.table(table.getTableId()));
		List<TableColumn> list = table.getColumns();
		
		/**
		 * add by 2016年4月1日
		 * 增加显示排序和记录排序功能;
		 */
		processSeq(list);
		
		
		/**
		 * add by 2016年4月6日
		 * 处理排序集合;
		 */
		table.setSorts(processSort(list));
		
		//补全column 属性
		/**
		 * pojo用;
		 * 1.设置javaType
		 * 2.设置属性名称
		 * 3.设置set方法名称
		 * 4.设置get方法名称
		 * 5.设置是否显示gson的annotation
		 * 
		**/
		List<JspColumn> jspColumns = new ArrayList<JspColumn>();
		for (TableColumn tc : list) {
			tc.setJavaType(TypesHelper.map_types.get(tc.getType()));
			String pn = TableHelper.col(tc.getColumnName());
			tc.setPropertyName(pn);
			tc.setSetMethod(TableHelper.set(pn));
			tc.setGetMethod(TableHelper.get(pn, tc.getType()));
			tc.setGson(tableViewModel.getShowGsonAnnotation());
			
			JspColumn jspColumn = new JspColumn(tc.getColumnName(), tc.getType(), tc.getColumnCommon());
			try{
				BeanUtils.copyProperties(jspColumn, tc);
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
//			jspColumn.setQueryRender(RenderHelper.createQueryRender(tableViewModel, jspColumn, tableViewModel.getSqlMapMarkUse(), tc.isQueryRenderShow()));
			jspColumn.setEditRender(RenderHelper.createEditRender(jspColumn, tableViewModel.getSqlMapMarkUse(), tc.isEditRenderShow()));
			jspColumn.setListRender(RenderHelper.createListRender(tableViewModel, jspColumn, tableViewModel.getSqlMapMarkUse(), tc.isListRenderShow()));
			jspColumns.add(jspColumn);
		}
		
		//是否生成操作列;
		JspColumn op = new  JspColumn(null, -1, "操作");
		op.setQueryRenderShow(false);
//		op.setQueryRender(RenderHelper.createDisAllowShowRender());
		op.setEditRender(RenderHelper.createDisAllowShowRender());
		op.setEditRenderShow(false);
		op.setListRender(RenderHelper.createListOperateRender(op, true));
		op.setListRenderShow(true);
		jspColumns.add(op);
		
		//生成JspColumn;
		tableViewModel.getTable().setJspColumns(jspColumns);
		
		//生成QueryColumn;
		List<QueryColumn> queryColumns = new ArrayList<QueryColumn>();
		Set<String> set_propertyNames = new HashSet<String>();
		for(JspColumn jspColumn : jspColumns){
			set_propertyNames.add(jspColumn.getPropertyName());
		}
		for(JspColumn jspColumn : jspColumns){
			//该列需要查询时新增查询列参数;
			if(jspColumn.isQueryRenderShow()){
				
				String queryColumnJson = jspColumn.getQueryColumnJson();
				if(StringUtils.isNotBlank(queryColumnJson)){
					queryColumnJson = queryColumnJson.trim();
					List<QueryColumn> list_queryColumns = GsonHelper.create().fromJson(queryColumnJson, new TypeToken<List<QueryColumn>>(){}.getType());
					for (QueryColumn qc : list_queryColumns) {
						String pn = qc.getPropertyName();
						if(set_propertyNames.contains(pn.trim())){
							qc.setNewProperty(false);
						}else{
							qc.setNewProperty(true);
						}
						
						qc.setRelColumnName(jspColumn.getColumnName());
						
						qc.setRenderWayType(jspColumn.getQueryRenderWay());
						qc.setSetMethod(TableHelper.set(pn));
						qc.setGetMethod(TableHelper.get(pn, qc.getJavaType()));
						qc.setStringJavaType(TypesHelper.isStringType(qc.getJavaType()));
						
						if(qc.getTitle() == null){
							qc.setTitle(jspColumn.getColumnTitle());
						}
						
						queryColumns.add(qc);
					}
					
				}
			}
		}
		//设置查询列;
		tableViewModel.getTable().setQueryColumns(queryColumns);
		
		//设置编辑js验证;
		tableViewModel.getTable().setEditJSValidtors(editJSValidtors(jspColumns));
		
		//设置formRender
		tableViewModel.getTable().setQueryFormRender(RenderHelper.createQueryFormRender(queryColumns, tableViewModel.getJspQueryColumnCount(), tableViewModel.getSqlMapMarkUse(), true));
		
		//生成配置文件;
		ConfigHelper.genConfigXmlFile(tableViewModel.getTable());
	}

}
