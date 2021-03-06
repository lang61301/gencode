/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.data.project.EntityInfo;
import me.paddingdun.gen.code.data.project.ProjectInfo;
import me.paddingdun.gen.code.exception.BusinessException;

/**
 * 工程信息工具类;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class ProjectHelper {
	
	/**
	 * 当前工程;
	 */
	private static ProjectInfo current = null;
	
	/**
	 * 工程列表;
	 */
	private static List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
	
	/**
	 * 工程根目录;
	 */
	private static File PROJECT_ROOT = new File(DirectoryHelper.getUserDir(), "project");
	
	static{
		File[] projects = PROJECT_ROOT.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
		
		List<ProjectInfo> result = new ArrayList<ProjectInfo>();
		if(projects != null)
			for (File p : projects) {
				ProjectInfo pi = SpringHelper.getBean(ProjectInfo.class);
				pi.setCreateTime(p.lastModified());
				pi.setLastModifyTime(p.lastModified());
				String pName = FilenameUtils.getBaseName(p.getAbsolutePath());
				pi.setProjectName(pName);
				pi.setRootDir(p.getAbsolutePath());
				result.add(pi);
			}
		Collections.sort(result);
		
		addAll(result);
		
		if(!result.isEmpty()){
			setCurrent(result.get(0));
		}
	}
	
	public static void add(ProjectInfo info){
		projects.add(info);
	}
	
	public static void addAll(List<ProjectInfo> list){
		projects.addAll(list);
	}
	
	public static void remove(String projectName){
		ProjectInfo pi = new ProjectInfo();
		pi.setProjectName(projectName);
		
		projects.remove(pi);
	}
	
	public static void setCurrent(ProjectInfo pi){
		current = pi;
	}
	
	public static ProjectInfo getCurrent(){
		return current;
	}
	
	public static ProjectInfo get(String projectName, boolean setCurrent){
		ProjectInfo result = null;
		for (ProjectInfo pi : projects) {
			if(pi.getProjectName().equals(projectName)){
				result = pi;
				break;
			}
		}
		if(setCurrent){
			setCurrent(result);
		}
		return result;
	}

	public static List<ProjectInfo> getProjects() {
		return projects;
	}
	
	/**
	 * 工程树;
	 * @param pName
	 * @return
	 */
	public static TreeNode projectTreeNode(String pName){
		DefaultMutableTreeNode root  = new DefaultMutableTreeNode(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isLeaf() {
				return false;
			}
		};
		root.setUserObject(pName);
		ProjectInfo pi = get(pName, true);
		File dir = new File(pi.getRootDir());
		File[] entitys = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File e) {
				return e.isFile() && e.getName().toLowerCase().endsWith(".xml");
			}
		});
		if(entitys != null)
			for (File f : entitys) {
				DefaultMutableTreeNode n  = new DefaultMutableTreeNode();
				EntityInfo e = new EntityInfo();
				e.setName(FilenameUtils.getBaseName(f.getName()));
				e.setPath(f.getAbsolutePath());
				n.setUserObject(e);
				root.add(n);
			}
		return root;
	}
	
	public boolean createProject(String projectName){
		File p = new File(PROJECT_ROOT, projectName);
		if(p.exists()){
			throw new BusinessException("工程名称已存在");
		}
		return false;
	}
}
