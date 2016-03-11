/**
 * 
 */
package me.paddingdun.gen.code.data.edit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author paddingdun
 *
 * 2016年3月10日
 */
public class EditValueGenWay {

	@Expose
	@SerializedName("new")
	private EditValueGenWayType new1;
	
	@Expose
	private EditValueGenWayType edit;
	
	private String newCustom;
	private String editCustom;
	public EditValueGenWayType getNew1() {
		return new1;
	}
	public void setNew1(EditValueGenWayType new1) {
		this.new1 = new1;
	}
	public EditValueGenWayType getEdit() {
		return edit;
	}
	public void setEdit(EditValueGenWayType edit) {
		this.edit = edit;
	}
	public String getNewCustom() {
		
		
		return newCustom;
	}
	public void setNewCustom(String newCustom) {
		this.newCustom = newCustom;
	}
	public String getEditCustom() {
		return editCustom;
	}
	public void setEditCustom(String editCustom) {
		this.editCustom = editCustom;
	}
}
