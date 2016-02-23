/**
 * 
 */
package me.paddingdun.gen.code.data.jsp;

/**
 * @author paddingdun
 *
 * 2016年1月12日
 */
public class Render{

	private String render;
	
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
}
