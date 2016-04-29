/**
 * 
 */
package me.paddingdun.gen.code.gui.model;

import javax.swing.tree.TreeNode;

/**
 * 工程树视图数据结构;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
public class ProjectTreeViewModel {

	private TreeNode rootNode;

	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
}
