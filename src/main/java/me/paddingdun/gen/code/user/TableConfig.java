/**
 * 
 */
package me.paddingdun.gen.code.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author paddingdun
 *
 * 2016年2月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement  
@XmlType
public class TableConfig {

	@XmlAttribute
	private String id;
	
	@XmlElement
	@XmlJavaTypeAdapter(AdapterCDATA.class)
	private byte[] text;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getText() {
		return text;
	}

	public void setText(byte[] text) {
		this.text = text;
	}
}
