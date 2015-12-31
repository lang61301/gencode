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
	
	@Value1
	private String pojoFullPackageName;
	@Value1
	private String daoFullPackageName;
	@Value1
	private String daoImplFullPackageName;
	@Value1
	private String serviceFullPackageName;
	@Value1
	private String serviceImplFullPackageName;
	@Value1
	private String webActionFullPackageName;
	@Value1
	private boolean genStringDate;
	
	@Value1(def="com.incito.zhcs.data.paging")
	private String idataCollectionPackageName;
	
	@Value1(def="com.incito.zhcs.data.paging.impl")
	private String defaultListDataCollectionPackageName;
	
	@Value1(def="com.incito.zhcs.data.paging")
	private String pagingPackageName;
	
	@Value1(def="com.incito.zhcs.util")
	private String gsonHelperPackageName;
	
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
	
	public String getPojoFullPackageName() {
		if(pojoFullPackageName == null){
			pojoFullPackageName = basePackageName + IConsant.PACKAGE_SEPARATE + pojoPackageName;
		}
		return pojoFullPackageName;
	}
	
	public String getDaoFullPackageName() {
		if(daoFullPackageName == null){
			daoFullPackageName = basePackageName + IConsant.PACKAGE_SEPARATE + daoPackageName;
		}
		return daoFullPackageName;
	}
	
	public String getServiceFullPackageName() {
		if(serviceFullPackageName == null){
			serviceFullPackageName = basePackageName + IConsant.PACKAGE_SEPARATE + servicePackageName;
		}
		return serviceFullPackageName;
	}
	
	public String getWebActionFullPackageName() {
		if(webActionFullPackageName == null){
			webActionFullPackageName = basePackageName + IConsant.PACKAGE_SEPARATE + webActionPackageName;
		}
		return webActionFullPackageName;
	}
	
	public String getDaoImplFullPackageName() {
		if(daoImplFullPackageName == null){
			daoImplFullPackageName = getDaoFullPackageName() + IConsant.PACKAGE_SEPARATE + IConsant.INTERFACE_IMPL_PACKAGE_NAME;
		}
		return daoImplFullPackageName;
	}
	
	public String getServiceImplFullPackageName() {
		if(serviceImplFullPackageName == null){
			serviceImplFullPackageName = getServiceFullPackageName() + IConsant.PACKAGE_SEPARATE + IConsant.INTERFACE_IMPL_PACKAGE_NAME;
		}
		return serviceImplFullPackageName;
	}
}
