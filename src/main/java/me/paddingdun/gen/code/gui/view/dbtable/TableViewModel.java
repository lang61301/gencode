/**
 * 
 */
package me.paddingdun.gen.code.gui.view.dbtable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import me.paddingdun.gen.code.IConsant;
import me.paddingdun.gen.code.annotation.Value1;
import me.paddingdun.gen.code.data.tabletree.Table;
import me.paddingdun.gen.code.util.GenFilenameHelper;
import me.paddingdun.gen.code.util.PathHelper;

/**
 * @author paddingdun
 *
 * 2015年12月21日
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TableViewModel {
	
	/**
	 * 
	 */
	private Table table;
	
	/**
	 * ibatis中SqlMap的属性占位符;
	 * 1:属性名称;
	 * 2:字段名称;
	 */
	@Value1(def="1")
	private Integer sqlMapMarkUse;
	
	/**
	 * 是否显示gosn注释;
	 * 1:显示;
	 * 0:不显示;
	 */
	@Value1(def="true")
	private Boolean showGsonAnnotation;
	
	
	@Value1(def="save")
	private String saveMethodPrefix;
	@Value1(def="update")
	private String updateMethodPrefix;
	@Value1(def="get")
	private String getMethodPrefix;
	@Value1(def="delete")
	private String deleteMethodPrefix;
	@Value1(def="query")
	private String queryMethodPrefix;
	@Value1(def="queryPaging")
	private String queryPagingMethodPrefix;
	@Value1(def="getPagingCount")
	private String getPagingCountPrefix;
	

	/**
	 * 基础包名称;
	 */
	@Value1(def="me.paddingdun")
	private String basePackageName;
	/**
	 * 服务包名称;
	 */
	@Value1(def="service")
	private String servicePackageName;
	/**
	 * pojo包名称;
	 */
	@Value1(def="data")
	private String pojoPackageName;
	/**
	 * dao包名称;
	 */
	@Value1(def="dao")
	private String daoPackageName;
	/**
	 * web.action包名称;
	 */
	@Value1(def="web.action")
	private String webActionPackageName;
	
	/**start data**/
	@Value1
	private String pojoFullPackageName;
	
	/**
	 * 需要针对每个实体进行个性化设置;
	 */
	@Value1
	private String cateGoryPackageName;
	
	/**
	 * 需要针对每个实体页面进行个性化设置; 用于页面存放和页面映射路径位置;
	 * 如果为null,将cateGoryPackageName获取最后一个包名称作为路径path;
	 * 如果cateGoryPackageName为null或者空串表明放在根目录下;
	 */
	@Value1
	private String cateGoryMappingPath;

	/**start dao**/
	@Value1
	private String daoFullPackageName;
	@Value1
	private String daoImplFullPackageName;
	
	/**start service**/
	@Value1
	private String serviceFullPackageName;
	@Value1
	private String serviceImplFullPackageName;
	
	/**start web.Action**/
	@Value1
	private String webActionFullPackageName;
	
	/**
	 * 如果该值为null,则使用 cateGoryMappingPath  + entityBeanName
	 * @return
	 */
	@Value1
	private String webActionRequestMapping;
	
	/**
	 * 如果该值为null,则使用
	 */
	@Value1
	private String springJspViewResolverMiddleFullPath;
	
	@Value1(def="edit")
	private String webActionEditMethodName;
	
	
	@Value1
	private boolean genStringDate;
	
	
	/**start special assistant class name or package name **/
	@Value1
	private String idataCollectionPackageName;
	
	@Value1
	private String defaultListDataCollectionPackageName;
	
	@Value1
	private String pagingPackageName;
	
	@Value1
	private String gsonHelperPackageName;
	
	@Value1
	private String jsonResultPackageName;
	
	@Value1
	private String businessExceptionPackageName;
	
	@Value1
	private String ierrorCodePackageName;
	
	/**
	 * jsp中datatables表格id;
	 */
	@Value1(def="table_id")
	private String jspDatatableId;
	
	/**
	 * jsp中datatables表格th中的第一列的checkbox的特定className
	 */
	@Value1(def="list_head_group_checkbox")
	private String headGroupCheckboxClassName;
	
	/**
	 * jsp中datatables表格td中的第一列的checkbox的特定className
	 */
	@Value1(def="list_group_checkbox")
	private String groupCheckboxClassName;
	
	/**
	 * jsp页面查询参数列数;
	 */
	@Value1(def="3")
	private Integer jspQueryColumnCount;
	
	public Integer getJspQueryColumnCount() {
		return jspQueryColumnCount;
	}

	public void setJspQueryColumnCount(Integer jspQueryColumnCount) {
		this.jspQueryColumnCount = jspQueryColumnCount;
	}

	public String getJspDatatableId() {
		return jspDatatableId;
	}

	public void setJspDatatableId(String jspDatatableId) {
		this.jspDatatableId = jspDatatableId;
	}

	public String getHeadGroupCheckboxClassName() {
		return headGroupCheckboxClassName;
	}

	public void setHeadGroupCheckboxClassName(String headGroupCheckboxClassName) {
		this.headGroupCheckboxClassName = headGroupCheckboxClassName;
	}

	public String getGroupCheckboxClassName() {
		return groupCheckboxClassName;
	}

	public void setGroupCheckboxClassName(String groupCheckboxClassName) {
		this.groupCheckboxClassName = groupCheckboxClassName;
	}

	public String getCateGoryPackageName() {
		return cateGoryPackageName;
	}

	public void setCateGoryPackageName(String cateGoryPackageName) {
		this.cateGoryPackageName = cateGoryPackageName;
	}

	public void setCateGoryMappingPath(String cateGoryMappingPath) {
		this.cateGoryMappingPath = cateGoryMappingPath;
	}

	public String getWebActionEditMethodName() {
		return webActionEditMethodName;
	}

	public void setWebActionEditMethodName(String webActionEditMethodName) {
		this.webActionEditMethodName = webActionEditMethodName;
	}

	public void setSpringJspViewResolverMiddleFullPath(String springJspViewResolverMiddleFullPath) {
		this.springJspViewResolverMiddleFullPath = springJspViewResolverMiddleFullPath;
	}

	public void setWebActionRequestMapping(String webActionRequestMapping) {
		this.webActionRequestMapping = webActionRequestMapping;
	}

	public String getBusinessExceptionPackageName() {
		return businessExceptionPackageName;
	}

	public void setBusinessExceptionPackageName(String businessExceptionPackageName) {
		this.businessExceptionPackageName = businessExceptionPackageName;
	}

	public String getIerrorCodePackageName() {
		return ierrorCodePackageName;
	}

	public void setIerrorCodePackageName(String ierrorCodePackageName) {
		this.ierrorCodePackageName = ierrorCodePackageName;
	}

	public String getJsonResultPackageName() {
		return jsonResultPackageName;
	}

	public void setJsonResultPackageName(String jsonResultPackageName) {
		this.jsonResultPackageName = jsonResultPackageName;
	}

	public String getDefaultListDataCollectionPackageName() {
		return defaultListDataCollectionPackageName;
	}

	public void setDefaultListDataCollectionPackageName(String defaultListDataCollectionPackageName) {
		this.defaultListDataCollectionPackageName = defaultListDataCollectionPackageName;
	}

	public String getGsonHelperPackageName() {
		return gsonHelperPackageName;
	}

	public void setGsonHelperPackageName(String gsonHelperPackageName) {
		this.gsonHelperPackageName = gsonHelperPackageName;
	}

	public String getIdataCollectionPackageName() {
		return idataCollectionPackageName;
	}

	public void setIdataCollectionPackageName(String idataCollectionPackageName) {
		this.idataCollectionPackageName = idataCollectionPackageName;
	}

	public String getPagingPackageName() {
		return pagingPackageName;
	}

	public void setPagingPackageName(String pagingPackageName) {
		this.pagingPackageName = pagingPackageName;
	}

	public String getGetPagingCountPrefix() {
		return getPagingCountPrefix;
	}

	public void setGetPagingCountPrefix(String getPagingCountPrefix) {
		this.getPagingCountPrefix = getPagingCountPrefix;
	}

	public String getPojoPackageName() {
		return pojoPackageName;
	}

	public void setPojoPackageName(String pojoPackageName) {
		this.pojoPackageName = pojoPackageName;
	}

	public String getDaoPackageName() {
		return daoPackageName;
	}

	public void setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
	}

	public String getWebActionPackageName() {
		return webActionPackageName;
	}

	public void setWebActionPackageName(String webActionPackageName) {
		this.webActionPackageName = webActionPackageName;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Integer getSqlMapMarkUse() {
		return sqlMapMarkUse;
	}

	public void setSqlMapMarkUse(Integer sqlMapMarkUse) {
		this.sqlMapMarkUse = sqlMapMarkUse;
	}

	public Boolean getShowGsonAnnotation() {
		return showGsonAnnotation;
	}

	public void setShowGsonAnnotation(Boolean showGsonAnnotation) {
		this.showGsonAnnotation = showGsonAnnotation;
	}

	public String getSaveMethodPrefix() {
		return saveMethodPrefix;
	}

	public void setSaveMethodPrefix(String saveMethodPrefix) {
		this.saveMethodPrefix = saveMethodPrefix;
	}

	public String getUpdateMethodPrefix() {
		return updateMethodPrefix;
	}

	public void setUpdateMethodPrefix(String updateMethodPrefix) {
		this.updateMethodPrefix = updateMethodPrefix;
	}

	public String getGetMethodPrefix() {
		return getMethodPrefix;
	}

	public void setGetMethodPrefix(String getMethodPrefix) {
		this.getMethodPrefix = getMethodPrefix;
	}

	public String getDeleteMethodPrefix() {
		return deleteMethodPrefix;
	}

	public void setDeleteMethodPrefix(String deleteMethodPrefix) {
		this.deleteMethodPrefix = deleteMethodPrefix;
	}

	public String getQueryMethodPrefix() {
		return queryMethodPrefix;
	}

	public void setQueryMethodPrefix(String queryMethodPrefix) {
		this.queryMethodPrefix = queryMethodPrefix;
	}

	public String getQueryPagingMethodPrefix() {
		return queryPagingMethodPrefix;
	}

	public void setQueryPagingMethodPrefix(String queryPagingMethodPrefix) {
		this.queryPagingMethodPrefix = queryPagingMethodPrefix;
	}

	public String getBasePackageName() {
		return basePackageName;
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}

	public String getServicePackageName() {
		return servicePackageName;
	}

	public void setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
	}

	public void setPojoFullPackageName(String pojoFullPackageName) {
		this.pojoFullPackageName = pojoFullPackageName;
	}

	public void setDaoFullPackageName(String daoFullPackageName) {
		this.daoFullPackageName = daoFullPackageName;
	}

	public void setServiceFullPackageName(String serviceFullPackageName) {
		this.serviceFullPackageName = serviceFullPackageName;
	}

	public void setWebActionFullPackageName(String webActionFullPackageName) {
		this.webActionFullPackageName = webActionFullPackageName;
	}

	public boolean isGenStringDate() {
		return genStringDate;
	}

	public void setGenStringDate(boolean genStringDate) {
		this.genStringDate = genStringDate;
	}

	public void setDaoImplFullPackageName(String daoImplFullPackageName) {
		this.daoImplFullPackageName = daoImplFullPackageName;
	}

	public void setServiceImplFullPackageName(String serviceImplFullPackageName) {
		this.serviceImplFullPackageName = serviceImplFullPackageName;
	}
	
	
	public String getSqlMapIDaoJavaClassName(){
		return GenFilenameHelper.sqlMapIDaoJavaClassName(table.getEntityBeanName());
	}
	
	public String getSqlMapDaoImplJavaClassName(){
		return GenFilenameHelper.sqlMapDaoImplJavaClassName(table.getEntityBeanName());
	}
	
	public String getSqlMapIServiceJavaClassName(){
		return GenFilenameHelper.sqlMapIServiceJavaClassName(table.getEntityBeanName());
	}
	
	public String getSqlMapServiceImplJavaClassName(){
		return GenFilenameHelper.sqlMapServiceImplJavaClassName(table.getEntityBeanName());
	}
	
	public String getSpringWebActionJavaClassName(){
		return GenFilenameHelper.springWebActionJavaClassName(table.getEntityBeanName());
	}
	
	public String getPojoFullPackageName() {
		if(pojoFullPackageName == null){
			pojoFullPackageName = PathHelper.concatPackageName(basePackageName, pojoPackageName, getCateGoryPackageName());
		}
		return pojoFullPackageName;
	}
	
	public String getDaoFullPackageName() {
		if(daoFullPackageName == null){
			daoFullPackageName = PathHelper.concatPackageName(basePackageName, daoPackageName, getCateGoryPackageName());
		}
		return daoFullPackageName;
	}
	
	public String getServiceFullPackageName() {
		if(serviceFullPackageName == null){
			serviceFullPackageName = PathHelper.concatPackageName(basePackageName, servicePackageName, getCateGoryPackageName());
		}
		return serviceFullPackageName;
	}
	
	public String getWebActionFullPackageName() {
		if(webActionFullPackageName == null){
			webActionFullPackageName = PathHelper.concatPackageName(basePackageName, webActionPackageName, getCateGoryPackageName());
		}
		return webActionFullPackageName;
	}
	
	public String getDaoImplFullPackageName() {
		if(daoImplFullPackageName == null){
			daoImplFullPackageName = PathHelper.concatPackageName(getDaoFullPackageName(), IConsant.INTERFACE_IMPL_PACKAGE_NAME);
		}
		return daoImplFullPackageName;
	}
	
	public String getServiceImplFullPackageName() {
		if(serviceImplFullPackageName == null){
			serviceImplFullPackageName = PathHelper.concatPackageName(getServiceFullPackageName(), IConsant.INTERFACE_IMPL_PACKAGE_NAME);
		}
		return serviceImplFullPackageName;
	}
	
	public String getCateGoryMappingPath() {
		if(cateGoryMappingPath == null){
			cateGoryMappingPath = PathHelper.lastPackageName(this.getCateGoryPackageName());
		}
		return cateGoryMappingPath;
	}
	
	public String getWebActionRequestMapping() {
		if(webActionRequestMapping == null){
			webActionRequestMapping = PathHelper.concatMappingPath(this.getCateGoryMappingPath(), this.table.getEntityBeanName());
		}
		return webActionRequestMapping;
	}
	
	/**
	 * 获取jsp文件存放路径;
	 *  jsp路径默认获取action映射路径;
	 * @return
	 */
	public String getJspWebinfAfterDir() {
		return this.getCateGoryMappingPath();
	}
	
	public String getSpringJspViewResolverMiddleFullPath() {
		if(springJspViewResolverMiddleFullPath == null){
			springJspViewResolverMiddleFullPath = PathHelper.concatJspMiddlePath(getJspWebinfAfterDir(), this.table.getEntityBeanName());
		}
		return springJspViewResolverMiddleFullPath;
	}
}
