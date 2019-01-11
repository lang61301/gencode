/**
 * 
 */
package me.paddingdun.gen.code.gui.model;

import java.io.Serializable;

/**
 * @author paddingdun
 *
 * 2019年1月9日
 * @since 1.0
 * @version 1.0
 */
public class GenDialogModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean xml;
	boolean baseData;
	boolean data;
	boolean dao;
	boolean service;
	boolean action;
	boolean jsp;
	public boolean isXml() {
		return xml;
	}
	public void setXml(boolean xml) {
		this.xml = xml;
	}
	public boolean isData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}
	public boolean isDao() {
		return dao;
	}
	public void setDao(boolean dao) {
		this.dao = dao;
	}
	public boolean isService() {
		return service;
	}
	public void setService(boolean service) {
		this.service = service;
	}
	public boolean isAction() {
		return action;
	}
	public void setAction(boolean action) {
		this.action = action;
	}
	public boolean isJsp() {
		return jsp;
	}
	public void setJsp(boolean jsp) {
		this.jsp = jsp;
	}
	public boolean isBaseData() {
		return baseData;
	}
	public void setBaseData(boolean baseData) {
		this.baseData = baseData;
	}
}
