/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import me.paddingdun.gen.code.data.jsp.Render;
import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.table.IDBColumn;

/**
 * 列表字段;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class ListColumn extends WapperDBColumn implements Comparable<ListColumn> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 新增列表字段显示排序功能, 按照从小到大的顺序排列;
	 */
	private Integer seq;
	
	/**
	 * add by 2016年3月31日
	 * 新增记录排序字段;
	 * 大于等于0表示正序;
	 * 小于0表示倒序;
	 * 按照绝对值的大小排序;
	 */
	private Integer order;
	
	/**
	 * list title;
	 */
	private String listTitle;
	
	/**
	 * 列表中是否显示;
	 */
	private boolean listRenderShow = true;
	
	/**
	 * 列表中显示方式;
	 * 用来定义列表显示方式;
	 */
	private int listRenderWay  = RenderWayType.list_default.getType();
	
	/**
	 * list render;
	 */
	private Render listRender;
	
	/**
	 * 查询中是否显示;
	 */
	private boolean queryRenderShow = false;
	
	/**
	 * 用来定义查询显示方式;
	 */
	private int queryRenderWay = RenderWayType.query_default.getType();
	
	/**
	 * 查询字段;
	 * 用来实现查询参数的json字符串, 关联对象QueryColumn
	 * 由于没有进一步ui操作设计, 因此直接用json字符串表示多个字段;
	 */
	private String queryColumnJson;
	
	/**
	 * @param dbColumn
	 */
	public ListColumn(IDBColumn dbColumn) {
		super(dbColumn);
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}


	public boolean isListRenderShow() {
		return listRenderShow;
	}

	public void setListRenderShow(boolean listRenderShow) {
		this.listRenderShow = listRenderShow;
	}

	public int getListRenderWay() {
		return listRenderWay;
	}

	public void setListRenderWay(int listRenderWay) {
		this.listRenderWay = listRenderWay;
	}

	public boolean isQueryRenderShow() {
		return queryRenderShow;
	}

	public void setQueryRenderShow(boolean queryRenderShow) {
		this.queryRenderShow = queryRenderShow;
	}

	public int getQueryRenderWay() {
		return queryRenderWay;
	}

	public void setQueryRenderWay(int queryRenderWay) {
		this.queryRenderWay = queryRenderWay;
	}

	public String getQueryColumnJson() {
		return queryColumnJson;
	}

	public void setQueryColumnJson(String queryColumnJson) {
		this.queryColumnJson = queryColumnJson;
	}

	public Render getListRender() {
		return listRender;
	}

	public void setListRender(Render listRender) {
		this.listRender = listRender;
	}
	
	public String getListTitle() {
		if(listTitle == null)
			listTitle = this.getColumnCommon();
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ListColumn o) {
		if(o == null)
			return -1;
		Integer s1 = this.getSeq();
		Integer s2 = this.getSeq();
		if(null == s1){
			return 1;
		}
		if(null == s2){
			return -1;
		}
		return s1.compareTo(s2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
		result = prime * result + ((getColumnName() == null) ? 0 : getColumnName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListColumn other = (ListColumn) obj;
		if (getTableName() == null) {
			if (other.getTableName() != null)
				return false;
		} else if (!getTableName().equals(other.getTableName()))
			return false;
		if (getColumnName() == null) {
			if (other.getColumnName() != null)
				return false;
		} else if (!getColumnName().equals(other.getColumnName()))
			return false;
		return true;
	}

}
