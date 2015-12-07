/**
 * 
 */
package me.paddingdun.gen.code.gui.perspective.designer;

import javax.swing.JDesktopPane;

import me.paddingdun.gen.code.gui.perspective.AbstractPerspective;
import me.paddingdun.gen.code.gui.view.dbtable.TableTreeView;
import me.paddingdun.gen.code.gui.view.dbtable.TableView;

/**
 * @author paddingdun
 *
 * 2015年12月7日
 */
public class DesignerPerspective extends AbstractPerspective {
	
	/**
	 * 点击表格树消息;
	 */
	public final static  String MESSAGE_CLICK_TABLE_TREE_NODE = "click_table_tree_node";

	private JDesktopPane container;
	
	private TableTreeView tableTreeView;
	
	private TableView tableView;

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

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.perspective.IPerspective#init()
	 */
	public void init() {
		int w = container.getWidth();
		int h = container.getHeight();
		
		//表列表view;
		tableTreeView = new TableTreeView(this);
		int w1 = (int)(w * 0.25);
		int h1 = (int)(h * 0.5);
		int l1 = 0;
		int t1 = h1;
		
		tableTreeView.setBounds(l1, t1, w1, h1);
		tableTreeView.setVisible(true);
		
		container.add(tableTreeView);
		this.add(tableTreeView);
		
		//表view;
		tableView = new TableView(this);
		int w2 = (int)(w * 0.25);
		int h2 = h;
		int l2 = w - w2;
		int t2 = 0;
		
		tableView.setBounds(l2, t2, w2, h2);
		tableView.setVisible(true);
		
		container.add(tableView);
		this.add(tableView);
	}

}
