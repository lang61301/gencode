/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

import me.paddingdun.gen.code.data.option.ModelValue;

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
		if(src != null
				&& dest != null){
			Field[] fields = src.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String pName = field.getName();
				Class<?> clazz = field.getDeclaringClass();
				ModelValue mv = field.getAnnotation(ModelValue.class);
				if(mv != null){
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
		if(src != null 
				&& dest != null){
			Field[] fields = dest.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String pName = field.getName();
				Class<?> clazz = field.getDeclaringClass();
				ModelValue mv = field.getAnnotation(ModelValue.class);
				if(mv != null){
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
									System.out.println(field_object.getClass() + "==========" + pName + "|" + valueSetFuncName);
									throw new RuntimeException(e4);
								}
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

}
