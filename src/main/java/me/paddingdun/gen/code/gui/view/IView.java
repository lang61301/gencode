/**
 * 
 */
package me.paddingdun.gen.code.gui.view;

import me.paddingdun.gen.code.data.message.Message;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public interface IView extends Runnable {

	void init();
	void receiveMessage(Message message);
	void doMessage(Message message);
	void destroy();
}
