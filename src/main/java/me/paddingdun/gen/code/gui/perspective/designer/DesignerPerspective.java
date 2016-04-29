/**
 * 
 */
package me.paddingdun.gen.code.gui.perspective.designer;

import javax.swing.JDesktopPane;

import me.paddingdun.gen.code.gui.perspective.AbstractPerspective;
import me.paddingdun.gen.code.gui.view.dbtable.EditView;
import me.paddingdun.gen.code.gui.view.dbtable.ProjectTreeView;
import me.paddingdun.gen.code.gui.view.dbtable.TableTreeView;
import me.paddingdun.gen.code.gui.view.dbtable.TableView;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class DesignerPerspective extends AbstractPerspective {
	
	/**
	 * 点击表格树消息;
	 */
	public final static  String MESSAGE_CLICK_TABLE_TREE_NODE = "click_table_tree_node";
	
	/**
	 * add by 2016年4月18日
	 * 点击查询SQL按钮生成按钮;
	 */
	public final static String MESSAGE_CLICK_QUERY_SQL_BUTTON = "click_query_sql_button";
	
	/**
	 * add by 2016年4月19日
	 * 点击工程树节点事件;
	 */
	public final static String MESSAGE_CLICK_PROJECT_TREE_NODE = "click_project_tree_node";
	
	/**
	 * add by 2016年4月19日
	 * 打开工程事件;
	 */
	public final static String MESSAGE_OPEN_PROJECT = "open_project";
	
	/**
	 * add by 2016年4月19日
	 * 新建工程事件;
	 */
	public final static String MESSAGE_NEW_PROJECT = "new_project";
	
	/**
	 * add by 2016年4月19日
	 * 关闭工程事件;
	 */
	public final static String MESSAGE_CLOSE_PROJECT = "close_project";

	private JDesktopPane container;
	
	private TableTreeView tableTreeView;
	
	private TableView tableView;
	
	private EditView editView;
	
	/**
	 * add by 2016年4月19日
	 * 新增已生成实体列表;
	 */
	private ProjectTreeView generatedTableTreeView;

	/**
	 * @param tableTree
	 */
	public DesignerPerspective(JDesktopPane container) {
		super();
		this.container = container;
		
		init();
	}

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.perspective.IPerspective#name()
	 */
	public String name() {
		// TODO Auto-generated method stub
		return "Designer";
	}

	public JDesktopPane getContainer() {
		return container;
	}

	public void setContainer(JDesktopPane container) {
		this.container = container;
	}

	public TableTreeView getTableTreeView() {
		return tableTreeView;
	}

	public TableView getTableView() {
		return tableView;
	}
	
	public EditView getEditView() {
		return editView;
	}
	
	public ProjectTreeView getGeneratedTableTreeView() {
		return generatedTableTreeView;
	}

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.perspective.IPerspective#init()
	 */
	public void init() {
		int w = container.getWidth();
		int h = container.getHeight();
		
		//已生成列表;
		generatedTableTreeView = new ProjectTreeView(this);
		int w0 = (int)(w * 0.2);
		int h0 = (int)(h * 0.5);
		int l0 = 0;
		int t0 = 0;
		generatedTableTreeView.setBounds(l0, t0, w0, h0);
		generatedTableTreeView.setVisible(true);
		container.add(generatedTableTreeView);
		this.add(generatedTableTreeView);
		
		//表列表view;
		tableTreeView = new TableTreeView(this);
		int w1 = (int)(w * 0.2);
		int h1 = (int)(h * 0.5);
		int l1 = 0;
		int t1 = h1;
		
		tableTreeView.setBounds(l1, t1, w1, h1);
		tableTreeView.setVisible(true);
		container.add(tableTreeView);
		this.add(tableTreeView);
		
		/**
		 * add by 2016年4月7日
		 * 增加editView
		 */
		editView = new EditView(this);
		int w3 = (int)(w * 0.45);
		int h3 = (int)(h * 1);
		int l3 = w1;
		int t3 = 0;
		
		editView.setBounds(l3, t3, w3, h3);
		editView.setVisible(true);
		container.add(editView);
		this.add(editView);
		
		//表view;
		tableView = new TableView(this);
		int w2 = (int)(w * 0.35);
		int h2 = h;
		int l2 = w - w2;
		int t2 = 0;
		
		tableView.setBounds(l2, t2, w2, h2);
		tableView.setVisible(true);
		container.add(tableView);
		this.add(tableView);
	}

}
