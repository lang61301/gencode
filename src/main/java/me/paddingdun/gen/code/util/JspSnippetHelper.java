/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import me.paddingdun.gen.code.exception.BusinessException;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
@Component
@Lazy(false)
public class JspSnippetHelper {
	
	private static Map<String, String> map = new HashMap<String, String>();
	
	@PostConstruct
	public void init(){
		SAXReader reader = new SAXReader();
		reader.setDefaultHandler(new ElementHandler() {
			
			public void onStart(ElementPath ep) {
			}
			
			public void onEnd(ElementPath ep) {
				Element e = ep.getCurrent();
				String ename = e.getName();
				if("snippet".equals(ename)){
					String name = e.attributeValue("name");
					map.put(name, e.getText());
				}
				
			}
		});
		try{
			reader.read(ResourceUtils.getFile("classpath:template/xml/JspComponent.xml"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getSnippet(String key){
		return getSnippet(key, new Object[0]);
	}
	
	public static String getSnippet(String key, Object...objects ){
		String s = map.get(key);
		if(StringUtils.isEmpty(s))
			throw new BusinessException("can't not config snippet[" + key +"] in JspComponent.xml!");
		String tmp = MessageFormat.format(s, objects);
		return tmp;
	}
}
