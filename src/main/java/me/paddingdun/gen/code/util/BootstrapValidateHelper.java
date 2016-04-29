/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import me.paddingdun.gen.code.data.edit.ValidatorType;
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
public class BootstrapValidateHelper {
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
				if("validate".equals(ename)){
					String name = e.attributeValue("name");
					map.put(name, e.getText());
				}
				
			}
		});
		try{
			reader.read(ResourceUtils.getFile("classpath:template/xml/bootstrap.validate.xml"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static String getValidate(String key, Object...objects ){
		String s = map.get(key);
		if(StringUtils.isEmpty(s))
			throw new BusinessException("can't not get Validate[" + key +"] in bootstrap.validate.xml!");
		List<Object> o = new ArrayList<Object>();
		o.add("{0}");
		if(objects != null && objects.length > 0){
			o.addAll(Arrays.asList(objects));
		}
		String tmp = "{" + MessageFormat.format(s, o.toArray()) + "}";
		return tmp;
	}
	
	private static Map<String, Object> json2Map(String key, String json){
		Gson gson = GsonHelper.create();
		Map<String, Map<String,Object>> map = gson.fromJson(json, new TypeToken<Map<String, Map<String,Object>>>(){}.getType());
		return map.get(key);
	}
	
	public static Map<String, Object> validator(ValidatorType type, Object... objects){
		return json2Map(type.name(), getValidate(type.name(), objects));
	}
}
