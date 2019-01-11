/**
 * 
 */
package me.paddingdun.gen.code.gui.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import me.paddingdun.gen.code.IConsant;
import me.paddingdun.gen.code.annotation.Value1;
import me.paddingdun.gen.code.data.table2.Entity;
import me.paddingdun.gen.code.util.ConfigHelper;
import me.paddingdun.gen.code.util.GenFilenameHelper;
import me.paddingdun.gen.code.util.PathHelper;

/**
 * 数据库表和查询列表视图数据结构;
 * @author paddingdun
 *
 * 2016年4月29日
 * 
 * 备注:
 * 2016-09-08
 * 由于这里是配置参数入口, 因此将很多Entity参数配置也放在此类中,
 * 但是并不表示该参数就是公共配置, 而是Entity配置.
 * @since 1.0
 * @version 2.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TableViewModel {
	
	/**
	 * 实体属性;
	 */
	private Entity entity;
	
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
	@Value1(def="1")
	private Integer sqlMapMarkUse = 1;
	

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
	 * 
	 * modify by 2016-08-31
	 * 删除该属性,由于该属性是和实体类对应的, 因此即使要配置也应该放在Entity中去进行配置;
	 */
//	@Value1
//	private String categoryPackageName;
	
	/**
	 * 需要针对每个实体页面进行个性化设置; 用于页面存放和页面映射路径位置;
	 * 如果为null,将categoryPackageName获取最后一个包名称作为路径path;
	 * 如果categoryPackageName为null或者空串表明放在根目录下;
	 * 
	 * modify by 2016-08-31
	 * 删除该属性,由于该属性是和实体类对应的, 因此即使要配置也应该放在Entity中去进行配置;
	 */
//	@Value1
//	private String categoryMappingPath;

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
	 * jsp存放的路径.
	 * spring-mvc中
	 * "org.springframework.web.servlet.view.InternalResourceViewResolver"
	 * 的prefix属性之后,jsp文件之前中间的目录;
	 */
	@Value1
	private String jspWebinfAfterDir;
	
	/**
	 * 如果该值为null,则使用 categoryMappingPath  + entityBeanName
	 * @return
	 * 
	 * modify by 2016-08-31
	 * 删除该属性,由于该属性是和实体类对应的, 因此即使要配置也应该放在Entity中去进行配置;
	 * 由于在vm文件中被使用因此,提供getWebActionRequestMapping方法;
	 */
//	@Value1
//	private String webActionRequestMapping;
	
	/**
	 * 如果该值为null,则使用
	 * 
	 * modify by 2016-08-31
	 * 删除该属性,由于该属性是和实体类对应的, 因此即使要配置也应该放在Entity中去进行配置;
	 * 由于在vm文件中被使用因此,提供getSpringJspViewResolverMiddleFullPath方法;
	 */
//	@Value1
//	private String springJspViewResolverMiddleFullPath;
	
	@Value1(def="edit")
	private String webActionEditMethodName;
	
	/**
	 * add modify by 2017-07-20
	 * 增加进入新增或编辑页面的方action方法名称;
	 */
	@Value1(def="toEdit")
	private String webActionToEditMethodName;
	
	
	@Value1
	private boolean genStringDate;
	
	
	/**start special assistant class name or package name **/
	@Value1
	private String idataCollectionPackageName;
	
	@Value1
	private String defaultListDataCollectionPackageName;
	
	@Value1
	private String defaultCollectionHelperPackageName;
	
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
	
	@Value1
	private String baseCtrlPackageName;
	
	/**
	 * add by 2018-01-07
	 */
	@Value1
	private String baseMapperPackageName;
	
	/**
	 * add by 2018-01-07
	 */
	@Value1
	private String baseServicePackageName;
	
	/**
	 * add by 2018-01-07
	 */
	@Value1
	private String ibaseServicePackageName;
	
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
	
	
	/**
	 * contextPath;
	 */
	@Value1(def="_ctx")
	private String jspContextPathVar;
	
	/**
	 * add by 2016-09-01
	 * 全局配置是否生成完整的jsp页面;
	 * true:完整的jsp页面;
	 * false:没有<html>和<body>和css和javascript引用;
	 */
	@Value1(def="true")
	private Boolean jspFulled;
	
	/**
	 * add by 2017-08-02
	 * 日志输出类包名称,适配日志类;
	 */
	@Value1(def="")
	private String logHelperPackageName;
	
	/**
	 * add by 2019-01-09
	 */
	@Value1
	private String xmlParentDir;
	/**
	 * add by 2019-01-09
	 */
	@Value1
	private String dataParentDir;
	/**
	 * add by 2019-01-09
	 */
	@Value1
	private String daoParentDir;
	/**
	 * add by 2019-01-09
	 */
	@Value1
	private String serviceParentDir;
	/**
	 * add by 2019-01-09
	 */
	@Value1
	private String actionParentDir;
	/**
	 * add by 2019-01-09
	 */
	@Value1
	private String jspParentDir;
	
	
	public String getDefaultCollectionHelperPackageName() {
		return defaultCollectionHelperPackageName;
	}

	public void setDefaultCollectionHelperPackageName(String defaultCollectionHelperPackageName) {
		this.defaultCollectionHelperPackageName = defaultCollectionHelperPackageName;
	}

	public String getJspContextPathVar() {
		return jspContextPathVar;
	}

	public void setJspContextPathVar(String jspContextPathVar) {
		this.jspContextPathVar = jspContextPathVar;
	}

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

//	public String getCategoryPackageName() {
//		return categoryPackageName;
//	}

//	public void setCategoryPackageName(String categoryPackageName) {
//		this.categoryPackageName = categoryPackageName;
//	}

//	public void setCategoryMappingPath(String categoryMappingPath) {
//		this.categoryMappingPath = categoryMappingPath;
//	}

	public String getWebActionEditMethodName() {
		return webActionEditMethodName;
	}

	public void setWebActionEditMethodName(String webActionEditMethodName) {
		this.webActionEditMethodName = webActionEditMethodName;
	}

//	public void setSpringJspViewResolverMiddleFullPath(String springJspViewResolverMiddleFullPath) {
//		this.springJspViewResolverMiddleFullPath = springJspViewResolverMiddleFullPath;
//	}

//	public void setWebActionRequestMapping(String webActionRequestMapping) {
//		this.webActionRequestMapping = webActionRequestMapping;
//	}

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
		return GenFilenameHelper.sqlMapIDaoJavaClassName(entity.getEntityBeanName());
	}
	
	public String getSqlMapBaseDaoJavaClassName(){
		return GenFilenameHelper.sqlMapBaseDaoJavaClassName(entity.getEntityBeanName());
	}
	
	public String getSqlMapDaoImplJavaClassName(){
		return GenFilenameHelper.sqlMapDaoImplJavaClassName(entity.getEntityBeanName());
	}
	
	public String getSqlMapIServiceJavaClassName(){
		return GenFilenameHelper.sqlMapIServiceJavaClassName(entity.getEntityBeanName());
	}
	
	public String getSqlMapBaseServiceJavaClassName(){
		return GenFilenameHelper.sqlMapBaseServiceJavaClassName(entity.getEntityBeanName());
	}
	
	public String getSqlMapServiceImplJavaClassName(){
		return GenFilenameHelper.sqlMapServiceImplJavaClassName(entity.getEntityBeanName());
	}
	
	public String getSqlMapBaseServiceImplJavaClassName(){
		return GenFilenameHelper.sqlMapBaseServiceImplJavaClassName(entity.getEntityBeanName());
	}
	
	public String getSpringWebActionJavaClassName(){
		return GenFilenameHelper.springWebActionJavaClassName(entity.getEntityBeanName());
	}
	
	public String getPojoFullPackageName() {
		if(pojoFullPackageName == null){
			pojoFullPackageName = PathHelper.concatPackageName(basePackageName, pojoPackageName, entity.getSubPackageName());
		}
		return pojoFullPackageName;
	}
	
	public String getDaoFullPackageName() {
		if(daoFullPackageName == null){
			daoFullPackageName = PathHelper.concatPackageName(basePackageName, daoPackageName, entity.getSubPackageName());
		}
		return daoFullPackageName;
	}
	
	public String getServiceFullPackageName() {
		if(serviceFullPackageName == null){
			serviceFullPackageName = PathHelper.concatPackageName(basePackageName, servicePackageName, entity.getSubPackageName());
		}
		return serviceFullPackageName;
	}
	
	public String getWebActionFullPackageName() {
		if(webActionFullPackageName == null){
			webActionFullPackageName = PathHelper.concatPackageName(basePackageName, webActionPackageName, entity.getSubPackageName());
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
	
//	public String getCategoryMappingPath() {
//		if(categoryMappingPath == null){
//			categoryMappingPath = PathHelper.lastPackageName(this.getCategoryPackageName());
//		}
//		return categoryMappingPath;
//	}
	
	public String getWebActionRequestMapping() {
		return PathHelper.concatMappingPath(null, entity.getEntityBeanName());
	}
	
	/**
	 * 获取jsp文件存放路径;
	 *  jsp路径默认获取action映射路径;
	 * @return
	 */
	public String getJspWebinfAfterDir() {
		return jspWebinfAfterDir;
	}
	
	public void setJspWebinfAfterDir(String jspWebinfAfterDir) {
		this.jspWebinfAfterDir = jspWebinfAfterDir;
	}

	/**
	 * 编辑页面
	 * @return
	 */
	public String getSpringJspViewResolverMiddleFullPath() {
		return PathHelper.concatJspMiddlePath(getJspWebinfAfterDir(), entity.getSubPackageName(), entity.getEntityBeanName());
	}
	
	/**
	 * list页面;
	 * @return
	 */
	public String getSpringListJspViewResolverMiddleFullPath() {
		return PathHelper.concatJspMiddlePath(getJspWebinfAfterDir(), entity.getSubPackageName(), GenFilenameHelper.easyuiListFN(entity.getEntityBeanName()) );
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Integer getSqlMapMarkUse() {
		return sqlMapMarkUse;
	}

	public void setSqlMapMarkUse(Integer sqlMapMarkUse) {
		this.sqlMapMarkUse = sqlMapMarkUse;
	}

	public String getBaseCtrlPackageName() {
		return baseCtrlPackageName;
	}

	public void setBaseCtrlPackageName(String baseCtrlPackageName) {
		this.baseCtrlPackageName = baseCtrlPackageName;
	}

	public Boolean getJspFulled() {
		return jspFulled;
	}

	public void setJspFulled(Boolean jspFulled) {
		this.jspFulled = jspFulled;
	}

	public String getWebActionToEditMethodName() {
		return webActionToEditMethodName;
	}

	public void setWebActionToEditMethodName(String webActionToEditMethodName) {
		this.webActionToEditMethodName = webActionToEditMethodName;
	}

	public String getLogHelperPackageName() {
		return logHelperPackageName;
	}

	public void setLogHelperPackageName(String logHelperPackageName) {
		this.logHelperPackageName = logHelperPackageName;
	}
	
	public String getDatabase() {
		return ConfigHelper.database().name();
	}

	public String getBaseMapperPackageName() {
		return baseMapperPackageName;
	}

	public void setBaseMapperPackageName(String baseMapperPackageName) {
		this.baseMapperPackageName = baseMapperPackageName;
	}

	public String getBaseServicePackageName() {
		return baseServicePackageName;
	}

	public void setBaseServicePackageName(String baseServicePackageName) {
		this.baseServicePackageName = baseServicePackageName;
	}

	public String getIbaseServicePackageName() {
		return ibaseServicePackageName;
	}

	public void setIbaseServicePackageName(String ibaseServicePackageName) {
		this.ibaseServicePackageName = ibaseServicePackageName;
	}

	public String getXmlParentDir() {
		return xmlParentDir;
	}

	public void setXmlParentDir(String xmlParentDir) {
		this.xmlParentDir = xmlParentDir;
	}

	public String getDataParentDir() {
		return dataParentDir;
	}

	public void setDataParentDir(String dataParentDir) {
		this.dataParentDir = dataParentDir;
	}

	public String getDaoParentDir() {
		return daoParentDir;
	}

	public void setDaoParentDir(String daoParentDir) {
		this.daoParentDir = daoParentDir;
	}

	public String getServiceParentDir() {
		return serviceParentDir;
	}

	public void setServiceParentDir(String serviceParentDir) {
		this.serviceParentDir = serviceParentDir;
	}

	public String getActionParentDir() {
		return actionParentDir;
	}

	public void setActionParentDir(String actionParentDir) {
		this.actionParentDir = actionParentDir;
	}

	public String getJspParentDir() {
		return jspParentDir;
	}

	public void setJspParentDir(String jspParentDir) {
		this.jspParentDir = jspParentDir;
	}
	
}
