/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import me.paddingdun.gen.code.gui.model.TableViewModel;

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
public class VelocityHelper {
	
	/**
	 * VelocityHelper 日志变量;
	 */
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(VelocityHelper.class);

	private static VelocityHelper helper;
	
	@PostConstruct
	public void init(){
		helper = this;
	}
	
	@Resource(name="velocityEngine")
	private VelocityEngine  engine;
	
	private static String rawTable(TableViewModel tableViewModel, String templateName){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("date", DateHelper.now());
		CollectionHelper.object2Map(tableViewModel, model);
		String s = VelocityEngineUtils.mergeTemplateIntoString(helper.engine, templateName, "utf-8", model);
		return s;
	}
	
	public static String entityBean(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/EntityBean.vm");
		String af = ContentFormatHelper.formatJava(s);
		return af;
	}
	
	public static String sqlMap(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/SqlMap.vm");
		return s;
	}
	
	public static String bootstrapDataTableJsp(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/BootstrapDataTableJsp.vm");
    	return s;
	}
	
	public static String sqlMapIDao(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/SqlMapIDao.vm");
		String af = ContentFormatHelper.formatJava(s);
    	return af;
	}
	
	public static String sqlMapDaoImpl(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/SqlMapDaoImpl.vm");
		String af = ContentFormatHelper.formatJava(s);
    	return af;
	}
	
	public static String sqlMapIService(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/SqlMapIService.vm");
		String af = ContentFormatHelper.formatJava(s);
    	return af;
	}
	
	public static String sqlMapServiceImpl(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/SqlMapServiceImpl.vm");
		String af = ContentFormatHelper.formatJava(s);
    	return af;
	}
	
	public static String springWebAction(TableViewModel tableViewModel){
		String s = rawTable(tableViewModel, "template/velocity/SpringMvcAction.vm");
		String af = ContentFormatHelper.formatJava(s);
    	return af;
	}

}
