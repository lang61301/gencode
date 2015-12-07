/**
 * 
 */
package me.paddingdun.gen.code.gui.view;

import me.paddingdun.gen.code.data.message.Message;

/**
 * @author paddingdun
 *
 * 2015年12月7日
 */
public interface IView extends Runnable {

	void init();
	void receiveMessage(Message message);
	void doMessage(Message message);
	void destroy();
}
