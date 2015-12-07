/**
 * 
 */
package me.paddingdun.gen.code.data.message;

import me.paddingdun.gen.code.gui.view.IView;

/**
 * @author paddingdun
 *
 * 2015年12月7日
 */
public class Message {
	
	private String name;
	
	private Object object;
	
	private IView source;
	
	private IView target;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public IView getSource() {
		return source;
	}

	public void setSource(IView source) {
		this.source = source;
	}

	public IView getTarget() {
		return target;
	}

	public void setTarget(IView target) {
		this.target = target;
	}
}
