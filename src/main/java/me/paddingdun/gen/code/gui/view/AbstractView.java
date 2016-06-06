/**
 * 
 */
package me.paddingdun.gen.code.gui.view;

import java.awt.EventQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.gui.IGuiConstant;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public  abstract class AbstractView extends javax.swing.JInternalFrame implements IView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
				consumeMessage(message);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param message
	 */
	public void consumeMessage(final Message message){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				doMessage(message);
			}
		});
	}

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.view.IView#doMessage(me.paddingdun.gen.code.data.message.Message)
	 */
	abstract public void doMessage(Message message);
	
	/**
	 * 关闭消息队列;
	 */
	public void destroy(){
		Message shutdown = new Message(IGuiConstant.SHUT_DOWN_MESSAGE);
		this.receiveMessage(shutdown);
	}
	
}
