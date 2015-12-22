/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.beans.PropertyDescriptor;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import me.paddingdun.gen.code.data.option.Option;
import me.paddingdun.gen.code.exception.BusinessException;

/**
 * @author paddingdun
 *
 * 2015年12月16日
 */
public class CollectionHelper {

	/**
	 * 将对象转成map; key:value{propertyName:propertyValue}
	 * @param t
	 * @return
	 */
	public static <T> void object2Map(T t, Map<String, Object> result){
		if(t != null){
			PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(t);
			for (int i = 0; i < pds.length; i++) {
				PropertyDescriptor pd = pds[i];
				String pName = pd.getName();
				try {
					result.put(pName, PropertyUtils.getProperty(t, pName));
				} catch (Exception e) {
					e.printStackTrace();
					throw new BusinessException("Invalid property name!",e);
				}
			}
		}
	}
	
	/**
	 * 创建option对象;
	 * @param title
	 * @param value
	 * @return
	 */
	public static <T> Option<T> option(String title, T value){
		Option<T> o = new Option<T>(title, value);
		return o;
	}
}
