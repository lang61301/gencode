/**
 * 
 */
package me.paddingdun.gen.code.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author paddingdun
 *
 * 2015年12月23日
 */
@Component
@Lazy(false)
public class SpringHelper implements BeanFactoryAware {
	
	private static BeanFactory ac;

	public static <T> T getBean(Class<T> clazz){
		return ac.getBean(clazz);
	}
	
	public static <T> T getBean(String name, Class<T> clazz){
		return ac.getBean(name, clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(org.springframework.beans.factory.BeanFactory)
	 */
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		ac = beanFactory;
	}
}
