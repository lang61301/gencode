/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.option.ModelValue;
import me.paddingdun.gen.code.data.option.ModelValueCategory;
import me.paddingdun.gen.code.data.table.JspColumn;
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
				Class<?> clazz = field.getDeclaringClass();
				ModelValue mv = field.getAnnotation(ModelValue.class);
				if(mv != null
						&& mv.category() == category){
					String valueSetFuncName = mv.valueSetFuncName();
					try {
						field.setAccessible(true);
						Object value = PropertyUtils.getProperty(src, pName);
						if(BASIC_CLASS.contains(clazz)){
							field.set(dest, value);
						}else{
							//复杂类型尝试调用 getValue 方法;
							Object field_object = field.get(dest);
							if(field_object == null){
								System.out.println(pName);
							}else
								try{
									MethodUtils.invokeMethod(field_object, valueSetFuncName, new Object[]{value});
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
	 * 加工model,准备数据;
	 * @param tableViewModel
	 */
	public static void processTableViewModel(TableViewModel tableViewModel){
		Table table = tableViewModel.getTable();
		table.setEntityBeanName(TableHelper.table(table.getTableId()));
		List<TableColumn> list = table.getColumns();
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
		
		//生成jspcolumn;
		tableViewModel.getTable().setJspColumns(jspColumns);
		
		//设置formRender
		tableViewModel.getTable().setQueryFormRender(RenderHelper.createQueryFormRender(tableViewModel, tableViewModel.getSqlMapMarkUse(), true));
		
		//生成配置文件;
		ConfigHelper.genConfigXmlFile(tableViewModel.getTable());
	}

}
