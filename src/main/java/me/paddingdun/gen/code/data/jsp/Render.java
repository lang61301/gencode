/**
 * 
 */
package me.paddingdun.gen.code.data.jsp;

import java.io.Serializable;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class Render implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String render;
	
	private int height;
	
	public Render(){
		
	}
	
	public Render(String render){
		this.render = render;
	}
	
	private Boolean show = true;
	
	private String title;

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
