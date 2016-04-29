/**
 * 
 */
package me.paddingdun.gen.code.gui.perspective;

import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.gui.view.IView;

/**
 * 接口
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public interface IPerspective {
	
	String name();
	
	void init();
	
	void add(IView view);
	
	void destroy();
	
	void sendMessage(Message message);
}
