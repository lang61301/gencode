/**
 * 
 */
package me.paddingdun.gen.code.data.project;

import java.io.Serializable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import me.paddingdun.gen.code.annotation.Value1;

/**
 * 工程信息;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectInfo implements Serializable, Comparable<ProjectInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 工程根路径;
	 */
	private String rootDir;
	
	/**
	 * 工程名称;
	 */
	private String projectName;
	
	/**
	 * 创建时间;
	 */
	private long createTime;
	
	/**
	 * 最近更新时间;
	 */
	private long lastModifyTime;
	
	@Value1
	private String database;
	
	@Value1
	private String daoMethod;

	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ProjectInfo o) {
		if(o == null)return -1;
		return (int)Math.signum(o.getLastModifyTime() - this.lastModifyTime );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
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
		ProjectInfo other = (ProjectInfo) obj;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getDaoMethod() {
		return daoMethod;
	}

	public void setDaoMethod(String daoMethod) {
		this.daoMethod = daoMethod;
	}
	
	
}
