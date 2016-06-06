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
import me.paddingdun.gen.code.data.table.IDBColumn;
import me.paddingdun.gen.code.data.table.Sort;
import me.paddingdun.gen.code.data.table2.Entity;
import me.paddingdun.gen.code.data.table2.IEntityProperty;
import me.paddingdun.gen.code.data.table2.ListColumn;
import me.paddingdun.gen.code.data.table2.QueryColumn;
import me.paddingdun.gen.code.data.table2.TableColumn;
import me.paddingdun.gen.code.gui.model.TableViewModel;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
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
	public static String defaultQueryColumnJson(IDBColumn column){
		QueryColumn qp = new QueryColumn();
		qp.setRelColumnName(column.getColumnName());
		qp.setPropertyName(EntityHelper.col(column.getColumnAlias()));
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
	public static String defaultEditValueGenWayJson(IDBColumn column){
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
	public static String defaultEditValidateJson(IDBColumn column){
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
			p.put(EntityHelper.col(columnName), v);
			result = GsonHelper.create(false, true).toJson(p);
		}
		return result;
	}
	
	/**
	 * add by 2016年3月21日
	 * 新增jsp页面中js验证;
	 * @param tcs
	 * @return
	 */
	public static String editJSValidtors(List<TableColumn> tcs){
		String result = null;
		Map<String, Map<String, Map<String, Map<String, Object>>>> tmp  = new LinkedHashMap<String, Map<String, Map<String, Map<String, Object>>>>();
		Gson gson = GsonHelper.create(false, true);
		for (TableColumn tc : tcs) {
			//1.必须是编辑;
			//2.非自增长字段;
			if(tc.isEditRenderShow()
					&& !tc.isAutoIncrement()){
				String str = tc.getEditValidateJson();
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
											String new_value = MessageFormat.format(value, tc.getColumnTitle());
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
	 * 表字段新增/编辑排序;
	 * @param list
	 */
	public static void processTableColumnSeq(List<TableColumn> list){
		Collections.sort(list);
	}
	
	/**
	 * 列表显示排序;
	 * @param list
	 */
	public static void processListColumnSeq(List<ListColumn> list){
		Collections.sort(list);
	}
	
	/**
	 * 列表处理排序集合;
	 * @param list
	 * @return
	 */
	private static List<Sort> processListColumnSort(List<ListColumn> list){
		List<Sort> result = new ArrayList<Sort>();
		for (ListColumn lc : list) {
			Integer order = lc.getOrder();
			if(order != null){
				Sort sort = new Sort();
				sort.setColumnName(lc.getColumnName());
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
		Entity entity = tableViewModel.getEntity();
		//1:设置实体javabean名称;
		entity.setEntityBeanName(EntityHelper.table(entity.getTableName()));
		
		//javabean 属性集合;
		Set<String> set_propertyNames = new HashSet<String>();
		//属性集合;
		List<IEntityProperty> list_eps = new ArrayList<IEntityProperty>();
		
		//2:处理表字段集合;
		List<TableColumn> list_tc = entity.getTableColumns();
		//2.1:字段排序;
		processTableColumnSeq(list_tc);
		//2.2:补全column 属性
		/**
		 * pojo用;
		 * 1.设置javaType
		 * 2.设置属性名称
		 * 3.设置set方法名称
		 * 4.设置get方法名称
		 * 5.设置是否显示gson的annotation
		 * 
		**/
		TableColumn primary = null;
		for (TableColumn tc : list_tc) {
			//set fulled java qualified name;
			tc.setJavaType(TypesHelper.map_types.get(tc.getType()));
			String pn = EntityHelper.col(tc.getColumnName());
			//set field name;
			tc.setPropertyName(pn);
			//set set method name;
			tc.setSetMethod(EntityHelper.set(pn));
			//set get method name;
			tc.setGetMethod(EntityHelper.get(pn, tc.getType()));
			//show annotation on field
			tc.setGson(true);
			//set edit render in jsp
			tc.setEditRender(RenderHelper.createEditRender(tc, tc.isEditRenderShow()));
			
			set_propertyNames.add(tc.getPropertyName());
			
			IEntityProperty ep = EntityHelper.from(tc);
			list_eps.add(ep);
			
			if(primary == null
					&& tc.isPrimary()){
				primary = tc;
			}
		}
		
		//3:处理列表字段;
		List<ListColumn> list_raw_lc = entity.getRawListColumns();
		//3.1:显示排序;
		processListColumnSeq(list_raw_lc);
		
		//3.2:记录排序;
		entity.setSorts(processListColumnSort(list_raw_lc));
		
		
		List<ListColumn> listColumns = new ArrayList<ListColumn>();
		
		//
		TableColumn key = null;
		//3.3:补充属性;
		for (ListColumn lc : list_raw_lc) {
			//set list table render in jsp
			lc.setListRender(RenderHelper.createListRender(tableViewModel, lc, lc.isListRenderShow()));
			
			listColumns.add(lc);
			
			//3.31:设置主键;
			//表名,字段名一样且是主键;
			if(key == null
					&& lc.isPrimary()
					&& primary != null
					&& primary.getTableName()
					.equals(lc.getTableName())){
				try {
					IDBColumn tmp_db = new DBColumn();
					BeanUtils.copyProperties(tmp_db, primary.getDbColumn());
					TableColumn tmp_tc = new TableColumn(tmp_db);
					BeanUtils.copyProperties(tmp_tc, primary);
					tmp_tc.setColumnAlias(lc.getColumnAlias());
					key = tmp_tc;
					entity.setKey(key);
				} catch (Exception e) {
					key = null;
					e.printStackTrace();
				}
			}
		}
		
		//3.4:是否生成操作列;
		ListColumn lc_op = new  ListColumn(new DBColumn());
		lc_op.setColumnAlias("__op");
		lc_op.setListTitle("操作");
		lc_op.setQueryRenderShow(false);
		lc_op.setListRender(RenderHelper.createListOperateRender(lc_op, true));
		lc_op.setListRenderShow(true);
		listColumns.add(lc_op);
		
		//3.5:设置列表字段;
		entity.setListColumns(listColumns);
		
		
		//4:生成QueryColumn;
		List<QueryColumn> queryColumns = new ArrayList<QueryColumn>();
		for(ListColumn lc : list_raw_lc){
			//该列需要查询时新增查询列参数;
			if(lc.isQueryRenderShow()){
				String queryColumnJson = lc.getQueryColumnJson();
				if(StringUtils.isNotBlank(queryColumnJson)){
					queryColumnJson = queryColumnJson.trim();
					List<QueryColumn> list_queryColumns = GsonHelper.create().fromJson(queryColumnJson, new TypeToken<List<QueryColumn>>(){}.getType());
					for (QueryColumn qc : list_queryColumns) {
						String pn = qc.getPropertyName();
						if(set_propertyNames.contains(pn.trim())){
							qc.setNewProperty(false);
						}else{
							qc.setNewProperty(true);
							
							list_eps.add(EntityHelper.from(qc));
						}
						
						qc.setRelColumnName(lc.getColumnName());
						
						qc.setRenderWayType(lc.getQueryRenderWay());
						qc.setSetMethod(EntityHelper.set(pn));
						qc.setGetMethod(EntityHelper.get(pn, qc.getJavaType()));
						qc.setStringJavaType(TypesHelper.isStringType(qc.getJavaType()));
						
						if(qc.getTitle() == null){
							qc.setTitle(lc.getListTitle());
						}
						
						queryColumns.add(qc);
					}
					
				}
			}
		}
		//4.2:设置查询列;
		entity.setQueryColumns(queryColumns);
		
		//5:设置属性列;
		entity.setEntityProperties(list_eps);
		
		//6:设置编辑js验证;
		entity.setEditJSValidtors(editJSValidtors(list_tc));
		
		//7:设置formRender
		entity.setQueryFormRender(RenderHelper.createQueryFormRender(queryColumns, tableViewModel.getJspQueryColumnCount(), true));
		
		//8:生成配置文件;
		ConfigHelper.genConfigXmlFile(tableViewModel.getEntity());
	}

}
