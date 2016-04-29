/**
 * 
 */
package me.paddingdun.gen.code.util.gui;

import javax.swing.ToolTipManager;

/**
 * 提示帮助类;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 1.0
 */
public class TipHelper {
	
	/**
	 * 设置tooltip消失时间;
	 * 1分钟;
	 */
	public static void configDismissTime(){
		ToolTipManager.sharedInstance().setDismissDelay(60 * 1000);
	}

}
