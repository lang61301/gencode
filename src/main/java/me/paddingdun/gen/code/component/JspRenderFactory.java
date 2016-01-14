/**
 * 
 */
package me.paddingdun.gen.code.component;

import me.paddingdun.gen.code.annotation.Value1;

/**
 * @author paddingdun
 *
 * 2016年1月12日
 */

public class JspRenderFactory {

	private static JspRenderFactory factory;
	
	public void init(){
		factory = this; 
	}
	
	@Value1(def="")
	private String jspRenderClass;
	
	public static Object getFactory(){
		return null;
	}
}
