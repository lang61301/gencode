/**
 * 
 */
package me.paddingdun.gen.code.gui.perspective;

import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.gui.view.IView;

/**
 * 接口;
 * @author paddingdun
 *
 * 2015年12月7日
 */
public interface IPerspective {
	
	String name();
	
	void init();
	
	void add(IView view);
	
	void destroy();
	
	void sendMessage(Message message);
}
