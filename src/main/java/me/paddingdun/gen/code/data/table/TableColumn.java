/**
 * 
 */
package me.paddingdun.gen.code.data.table;



import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import me.paddingdun.gen.code.data.jsp.RenderWayType;
import me.paddingdun.gen.code.data.option.ModelValue;
import me.paddingdun.gen.code.data.option.ModelValueCategory;
import me.paddingdun.gen.code.util.EditValueGenWayHelper;

/**
 * @author paddingdun
 *
 * 2015年12月3日
 */
public class TableColumn extends DBColumn implements Comparable<TableColumn>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ModelValue(category=ModelValueCategory.Column, valueGetFuncName="getColumnAlias")
	private String columnAlias;
	
	/**
	 * 用来实现查询参数的json字符串, 关联对象QueryColumn
	 * 由于没有进一步ui操作设计, 因此直接用json字符串表示多个字段;
	 */
	private String queryColumnJson;
	
	/**
	 * 新增和编辑时,该字段值的生成方式;
	 */
	private String editValueGenWayJson;
	
	/**
	 * add by 2016年3月17日
	 * 新增和编辑时, 验证规则json;
	 * jquery.bootstrap.validate
	 */
	private String editValidateJson;
	
	/**
	 * add by 2016年3月31日
	 * 新增列表字段显示排序功能, 按照从小到大的顺序排列;
	 */
	@ModelValue(category=ModelValueCategory.Column, valueGetFuncName="getSeq")
	private Integer seq;
	
	/**
	 * add by 2016年3月31日
	 * 新增记录排序字段;
	 * 大于等于0表示正序;
	 * 小于0表示倒序;
	 * 按照绝对值的大小排序;
	 */
	@ModelValue(category=ModelValueCategory.Column, valueGetFuncName="getOrder")
	private Integer order;
	
	
	/**
	 * @param columnName
	 * @param type
	 * @param columnCommon
	 */
	public TableColumn(String columnName, int type, String columnCommon) {
		super(columnName, type, columnCommon);
	}
	
	public TableColumn(DBColumn dbColumn){
		this(dbColumn.getColumnName(), dbColumn.getType(), dbColumn.getColumnCommon());
		try {
			BeanUtils.copyProperties(this, dbColumn);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	private String javaType;
	private String propertyName;
	private String getMethod;
	private String setMethod;


	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getGetMethod() {
		return getMethod;
	}
	public void setGetMethod(String getMethod) {
		this.getMethod = getMethod;
	}
	public String getSetMethod() {
		return setMethod;
	}
	public void setSetMethod(String setMethod) {
		this.setMethod = setMethod;
	}
	
	public String getColumnAlias() {
		if(columnAlias == null)
			columnAlias = this.getColumnName();
		return columnAlias;
	}
	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
	}



	/**
	 * EntityBean中是否生成gson注释;
	 */
	private boolean gson = true;


	public boolean isGson() {
		return gson;
	}
	public void setGson(boolean gson) {
		this.gson = gson;
	}
	
	
	/***jsp使用********************************************************************************/
	/**
	 * 是否显示;
	 */
	private boolean queryRenderShow = false;
	/**
	 * 是否显示;
	 */
	private boolean listRenderShow = true;
	/**
	 * 是否显示;
	 */
	private boolean editRenderShow = true;
	
	/**
	 * 用来定义查询显示方式;
	 */
	private int queryRenderWay = RenderWayType.query_default.getType();
	/**
	 * 用来定义列表显示方式;
	 */
	private int listRenderWay  = RenderWayType.list_default.getType();
	/**
	 * 用来定义编辑列显示方式;
	 */
	private int editRenderWay  = RenderWayType.edit_default.getType();
	
	/**
	 * 列标题;
	 */
	private String columnTitle;
	
	public boolean isQueryRenderShow() {
		return queryRenderShow;
	}
	public void setQueryRenderShow(boolean queryRenderShow) {
		this.queryRenderShow = queryRenderShow;
	}
	public boolean isListRenderShow() {
		return listRenderShow;
	}
	public void setListRenderShow(boolean listRenderShow) {
		this.listRenderShow = listRenderShow;
	}
	public boolean isEditRenderShow() {
		return editRenderShow;
	}
	public void setEditRenderShow(boolean editRenderShow) {
		this.editRenderShow = editRenderShow;
	}
	public int getQueryRenderWay() {
		return queryRenderWay;
	}
	public void setQueryRenderWay(int queryRenderWay) {
		this.queryRenderWay = queryRenderWay;
	}
	public int getListRenderWay() {
		return listRenderWay;
	}
	public void setListRenderWay(int listRenderWay) {
		this.listRenderWay = listRenderWay;
	}
	public int getEditRenderWay() {
		return editRenderWay;
	}
	public void setEditRenderWay(int editRenderWay) {
		this.editRenderWay = editRenderWay;
	}
	public String getColumnTitle() {
		if(columnTitle == null){
			columnTitle = this.getColumnCommon();
		}
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	
	public String getQueryColumnJson() {
		return queryColumnJson;
	}
	public void setQueryColumnJson(String queryColumnJson) {
		this.queryColumnJson = queryColumnJson;
	}
	
	public String getEditValueGenWayJson() {
		return editValueGenWayJson;
	}
	public void setEditValueGenWayJson(String editValueGenWayJson) {
		this.editValueGenWayJson = editValueGenWayJson;
	}
	
	/**
	 * 判断该字段是否可以存在updatesql中的set语句中;
	 * @return
	 */
	public boolean isNotInSetUpdateSql(){
		return EditValueGenWayHelper.isNotInSetUpdateSql(this);
	}
	
	
	public String getEditValidateJson() {
		return editValidateJson;
	}

	public void setEditValidateJson(String editValidateJson) {
		this.editValidateJson = editValidateJson;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableColumn other = (TableColumn) obj;
		if (this.getColumnName() == null) {
			if (other.getColumnName() != null)
				return false;
		} else if (!this.getColumnName().equals(other.getColumnName()))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TableColumn o2) {
		if(o2 == null){
			return -1;
		}
		
		Integer s1 = getSeq();
		Integer s2 = o2.getSeq();
		if(s1 == null){
			return 1;
		}else if(s2 == null)
			return -1;
		
		return s1-s2;
	}

	
}

