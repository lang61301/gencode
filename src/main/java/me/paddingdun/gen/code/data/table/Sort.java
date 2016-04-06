/**
 * 
 */
package me.paddingdun.gen.code.data.table;

import java.io.Serializable;

/**
 * 字段排序;
 * @author paddingdun
 *
 * 2016年4月6日
 */
public class Sort implements Serializable, Comparable<Sort> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 字段名称;
	 */
	private String columnName;
	
	/**
	 * 排序方向;默认正序;
	 */
	private String direct = "asc";
	
	/**
	 * 排序序号;
	 */
	private Integer seq;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Sort o) {
		if(o == null)return -1;
		Integer s1 = getSeq();
		Integer s2 = o.getSeq();
		if(s1 == null)return 1;
		else if(s2 == null)return -1;
		else
			return s1 - s2; 
	}
	
	@Override
	public String toString() {
		return columnName + " " + direct;
	}

}
