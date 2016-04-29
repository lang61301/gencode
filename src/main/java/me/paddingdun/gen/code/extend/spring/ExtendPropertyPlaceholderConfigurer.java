/**
 * 
 */
package me.paddingdun.gen.code.extend.spring;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 重载属性注入;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class ExtendPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	private Properties props;
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		
		this.props = props;
	}
	
	public String getProperty(String key) { 
        return props.getProperty(key); 
    } 

}
