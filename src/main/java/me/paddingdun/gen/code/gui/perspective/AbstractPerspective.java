/**
 * 
 */
package me.paddingdun.gen.code.gui.perspective;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.gui.view.IView;

/**
 * @author paddingdun
 *
 * 2015年12月7日
 */
public abstract class AbstractPerspective implements IPerspective {
	
	private List<IView> views = new ArrayList<IView>();
	
	public void destroy(){
		if(views != null
				&& !views.isEmpty()){
			for(IView v : views){
				v.destroy();
			}
		}
	}

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.perspective.IPerspective#add(me.paddingdun.gen.code.gui.view.IView)
	 */
	final public void add(IView view) {
		views.add(view);
	}
	
	final public void sendMessage(Message message){
		if(message != null){
			if(views != null
					&& !views.isEmpty()){
				for(IView v : views){
					if(v != message.getSource()){
						//复制消息;
						Message newMessage = new Message();
						try {
							BeanUtils.copyProperties(newMessage, message);
							newMessage.setTarget(v);
							v.receiveMessage(newMessage);
						} catch (Exception e) {
							e.printStackTrace();
						} 
					}
				}
			}
		}
	}
}
