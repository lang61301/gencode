/**
 * 
 */
package me.paddingdun.gen.code.data.table2;

import me.paddingdun.gen.code.data.jsp.RenderWayType;

/**
 * 列表字段;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class ListColumn extends EntityProperty {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 表别名;
	 * 用于在给查询sql语句添加排序字段时组装语句用;
	 */
	private String tableAlias;
	
	/**
	 * add by 2016年3月31日
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
	 * 字段标题;
	 */
	private String columnTitle;
	
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
}
