/**
 * 
 */
package me.paddingdun.gen.code.extend.spring;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author paddingdun
 *
 * 2015年12月28日
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
