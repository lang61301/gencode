/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.beans.PropertyDescriptor;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.option.Option;
import me.paddingdun.gen.code.exception.BusinessException;
import me.paddingdun.gen.code.gui.model.OptionComboBoxModel;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
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
	
	public static void renderWayOption(OptionComboBoxModel<Integer> model, String category){
		for (RenderWayType rwt : RenderWayType.values()) {
			if(category.equals(rwt.getCategory())){
				model.addElement(CollectionHelper.option(rwt.getTitle(), rwt.getType()));
			}
		}
	}
}
