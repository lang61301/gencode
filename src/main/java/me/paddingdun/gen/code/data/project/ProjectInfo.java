/**
 * 
 */
package me.paddingdun.gen.code.data.project;

import java.io.Serializable;

/**
 * 工程信息;
 * @author paddingdun
 *
 * 2016年4月19日
 */
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
}
