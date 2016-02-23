/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author paddingdun
 *
 * 2016年1月14日
 */
public class XmlHelper {
	
	public static void main(String[] args) throws Exception{
		final Map<String, String> map = new HashMap<String, String>(); 
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
		reader.read(new File("D:\\home\\workspace\\Test\\src\\main\\resources\\JspComponent.xml"));
	}
}
