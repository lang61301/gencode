/**
 * 
 */
package me.paddingdun.gen.code.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import me.paddingdun.gen.code.annotation.Value1;
import me.paddingdun.gen.code.extend.spring.ExtendPropertyPlaceholderConfigurer;
import me.paddingdun.gen.code.util.TypesHelper;

/**
 * 自动将绑定@Value1注释的属性注入资源文件中的值;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
@Component
@Lazy(false)
public class PropertiesBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	@Autowired
	private ExtendPropertyPlaceholderConfigurer eppc;
	
	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		
		ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
			
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				Value1 v1 = field.getAnnotation(Value1.class);
				String key = v1.value();
				String def = v1.def();
				String keyName = field.getName();
				if(StringUtils.isNotBlank(key)){
					keyName = key.trim();
				}
				String def1 = eppc.getProperty(keyName);
				
				if(StringUtils.isBlank(def)
						&& def1 == null){
					return;
				}
				if(def1 != null){
					def = def1;
				}
				ReflectionUtils.makeAccessible(field);
				field.set(bean, TypesHelper.convertBasic(field.getType(), def));
			}
		}, new ReflectionUtils.FieldFilter() {
			
			public boolean matches(Field field) {
				Value1 v1 = field.getAnnotation(Value1.class);
				if(v1 != null){
					return !Modifier.isStatic(field.getModifiers());
					
				}
				return false;
			}
		});
		
		return bean;
	}
}
