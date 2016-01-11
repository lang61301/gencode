/**
 * 
 */
package me.paddingdun.gen.code.gui.view;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.gui.IGuiConstant;

/**
 * @author paddingdun
 *
 * 2015年12月7日
 */
public  abstract class AbstractView extends javax.swing.JInternalFrame implements IView {

	private BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(1000);
	
	protected boolean running = true;
	
	public AbstractView(){
		init();
	}
	
	/**
	 * 启动消息队列;
	 */
	public void init(){
		new Thread(this).start();
	}

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.view.IView#receiveMessage(me.paddingdun.gen.code.data.message.Message)
	 */
	public void receiveMessage(Message message) {
		try {
			messages.put(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			while(running){
				Message message = messages.take();
				if(IGuiConstant.SHUT_DOWN_MESSAGE.equals(message.getName())){
					running = false;
					break;
				}
				doMessage(message);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.view.IView#doMessage(me.paddingdun.gen.code.data.message.Message)
	 */
	abstract public void doMessage(Message message);
	
	/**
	 * 关闭消息队列;
	 */
	public void destroy(){
		Message shutdown = new Message();
		shutdown.setName(IGuiConstant.SHUT_DOWN_MESSAGE);
		this.receiveMessage(shutdown);
	}
	
}
