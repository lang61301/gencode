/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.paddingdun.gen.code.gui.view.dbtable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.MessageFormat;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sun.tools.javac.util.Name.Table;

import layout.TableLayout;
import me.paddingdun.gen.code.IConsant;
import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.data.option.ModelValue;
import me.paddingdun.gen.code.data.option.ModelValueCategory;
import me.paddingdun.gen.code.data.option.Option;
import me.paddingdun.gen.code.data.table.CellEditorType;
import me.paddingdun.gen.code.data.table.DBColumn;
import me.paddingdun.gen.code.data.table.IDBColumn;
import me.paddingdun.gen.code.data.table2.Entity;
import me.paddingdun.gen.code.data.table2.ListColumn;
import me.paddingdun.gen.code.data.table2.TableColumn;
import me.paddingdun.gen.code.data.tabletree.DBTable;
import me.paddingdun.gen.code.data.tabletree.IDBTable;
import me.paddingdun.gen.code.db.TableHelper2;
import me.paddingdun.gen.code.gui.model.EditViewModel;
import me.paddingdun.gen.code.gui.model.OptionComboBoxModel;
import me.paddingdun.gen.code.gui.model.TableViewModel;
import me.paddingdun.gen.code.gui.perspective.designer.DesignerPerspective;
import me.paddingdun.gen.code.gui.view.AbstractView;
import me.paddingdun.gen.code.util.CollectionHelper;
import me.paddingdun.gen.code.util.FileHelper;
import me.paddingdun.gen.code.util.ModelHelper;
import me.paddingdun.gen.code.util.SpringHelper;
import me.paddingdun.gen.code.util.VelocityHelper;
import me.paddingdun.gen.code.util.gui.TaskHelper;

/**
 * 数据库表/查询列表详细视图;
 * 
 * @author paddingdun
 *
 *         2016年4月29日
 * @since 1.0
 * @version 2.0
 */
@SuppressWarnings({ "serial", "unused"})
public class TableView extends AbstractView {

	/**
	 * TableView 日志变量;
	 */
	private final static Logger logger = Logger.getLogger(TableView.class);

	private DesignerPerspective perspective;

	/**
	 * 数据;
	 */
	private TableViewModel model = null;

	/**
	 * Creates new form TableFrame
	 */
	public TableView(DesignerPerspective perspective) {
		super();
		this.perspective = perspective;
		initModel();
		initComponents();
	}

	private void initModel() {
		model = SpringHelper.getBean(TableViewModel.class);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle("数据库表/查询列表详细内容");
		fileChooser = new javax.swing.JFileChooser();
		p = new javax.swing.JSplitPane();
		p0t = new javax.swing.JPanel();
		pt = new javax.swing.JSplitPane();
		ptt = new javax.swing.JScrollPane();
		ptb = new javax.swing.JScrollPane();
		ptba = new javax.swing.JPanel();
		pb = new javax.swing.JSplitPane();
		p0b = new javax.swing.JPanel();
		pbt = new javax.swing.JScrollPane();
		pbb = new javax.swing.JScrollPane();
		pbba = new javax.swing.JPanel();

		p.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
		pt.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
		pb.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

		p.setTopComponent(p0t);
		p.setBottomComponent(p0b);

		p0t.setLayout(new BorderLayout());
		p0t.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "数据库表", TitledBorder.LEFT,
				TitledBorder.DEFAULT_POSITION, null, Color.BLACK));
		p0t.add(pt, BorderLayout.CENTER);
		p0t.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				p.setDividerLocation(p.getHeight() - 40);
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						pt.setDividerLocation(0.38);
						EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								pb.setDividerLocation(1.0d);
							}
						});
					}
				});
			}
		});

		p0b.setLayout(new BorderLayout());
		p0b.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), "查询列表", TitledBorder.LEFT,
				TitledBorder.DEFAULT_POSITION, null, Color.BLACK));
		p0b.add(pb, BorderLayout.CENTER);
		p0b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				p.setDividerLocation(30);
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						pt.setDividerLocation(1.0d);

						EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								pb.setDividerLocation(0.38);
							}
						});
					}
				});
			}
		});

		pt.setTopComponent(ptt);
		pt.setBottomComponent(ptb);

		ptb.setViewportView(ptba);
		ptb.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		pb.setTopComponent(pbt);
		pb.setBottomComponent(pbb);

		pbb.setViewportView(pbba);
		pbb.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		tableColumnTable = new javax.swing.JTable() {
			public void editingStopped(ChangeEvent e) {
				TableCellEditor editor = this.getCellEditor();
				if (editor != null) {
					Object value = editor.getCellEditorValue();
					setTableColumnValue(value);
				}
				// System.out.println(MessageFormat.format("c:{0}-r:{1}",
				// this.getSelectedColumn(), this.getSelectedRow()));
				super.editingStopped(e);
			}
		};
		// 当使用ColumnModel时将其设置成false;
		// table.setAutoCreateColumnsFromModel(false);
		ptt.setViewportView(tableColumnTable);

		/**
		 * add by 2016年4月22日 新增查询列表;
		 */
		listColumnTable = new javax.swing.JTable() {
			public void editingStopped(ChangeEvent e) {
				TableCellEditor editor = this.getCellEditor();
				if (editor != null) {
					Object value = editor.getCellEditorValue();
					setListColumnValue(value);
				}
				// System.out.println(MessageFormat.format("c:{0}-r:{1}",
				// this.getSelectedColumn(), this.getSelectedRow()));
				super.editingStopped(e);
			}
		};
		listColumnTable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});
		pbt.setViewportView(listColumnTable);

		jLabel1 = new javax.swing.JLabel();
		basePackageName = new javax.swing.JTextField();
		btnGen = new javax.swing.JButton();
		btnListColumnOk = new javax.swing.JButton();
		btnTableColumnOk = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jcombo_sqlMapMarkUse = new javax.swing.JComboBox<Option<Integer>>();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		columnTitle = new javax.swing.JTextField();
		listTitle = new javax.swing.JTextField();
		jcombo_showGsonAnnotation = new javax.swing.JComboBox<Option<Boolean>>();
		jcombo_queryRenderShow = new javax.swing.JComboBox<Option<Boolean>>();
		jcombo_listRenderShow = new javax.swing.JComboBox<Option<Boolean>>();
		jcombo_editRenderShow = new javax.swing.JComboBox<Option<Boolean>>();
		jcombo_queryRenderWay = new javax.swing.JComboBox<Option<Integer>>();
		jcombo_listRenderWay = new javax.swing.JComboBox<Option<Integer>>();
		jcombo_editRenderWay = new javax.swing.JComboBox<Option<Integer>>();
		saveMethodPrefix = new javax.swing.JTextField();
		updateMethodPrefix = new javax.swing.JTextField();
		getMethodPrefix = new javax.swing.JTextField();
		deleteMethodPrefix = new javax.swing.JTextField();
		queryMethodPrefix = new javax.swing.JTextField();
		queryPagingMethodPrefix = new javax.swing.JTextField();

		queryColumnJson = new javax.swing.JTextArea(1, 10);
		javax.swing.JScrollPane cqpc = new javax.swing.JScrollPane(queryColumnJson);
		// customQueryProperty.setAutoscrolls(true);

		editValueGenWayJson = new javax.swing.JTextArea(1, 10);
		javax.swing.JScrollPane cevfw = new javax.swing.JScrollPane(editValueGenWayJson);

		editValidateJson = new javax.swing.JTextArea(1, 10);
		javax.swing.JScrollPane evj = new javax.swing.JScrollPane(editValidateJson);

		jLabel1.setText("基础包名称");

		btnGen.setText("生成");
		btnTableColumnOk.setText("Ok");
		btnListColumnOk.setText("Ok");

		jLabel2.setText("SQL传入值占位符");

		// sqlMapMarkUse.setModel(null);

		jLabel3.setText("保存方法前缀");

		jLabel4.setText("更新方法前缀");

		jLabel5.setText("获取方法前缀");

		jLabel6.setText("删除方法前缀");

		jLabel7.setText("列表方法前缀");

		jLabel8.setText("分页方法前缀");

		jLabel9.setText("是否显示gosn注释");

		jLabel10.setText("查询中是否显示");
		jLabel11.setText("查询中显示方式");

		jLabel12.setText("列表中是否显示");
		jLabel13.setText("列表中显示方式");

		jLabel14.setText("编辑中是否显示");
		jLabel15.setText("编辑中显示方式");

		jLabel16.setText("字段标题");

		TableLayout tableLayout_ptba = new TableLayout();
		double border = 2; // 0 1 2 3 4 5 6
		tableLayout_ptba.setColumn(new double[] { border, 50, 50, 80, -1, 50, 70, border });
		tableLayout_ptba.setRow(new double[] { border, 30, 30, 30, 130, 130, border });
		ptba.setLayout(tableLayout_ptba);

		queryRenderShow.addElement(CollectionHelper.option("是", Boolean.TRUE));
		queryRenderShow.addElement(CollectionHelper.option("否", Boolean.FALSE));
		jcombo_queryRenderShow.setModel(queryRenderShow);

		listRenderShow.addElement(CollectionHelper.option("是", Boolean.TRUE));
		listRenderShow.addElement(CollectionHelper.option("否", Boolean.FALSE));
		jcombo_listRenderShow.setModel(listRenderShow);

		editRenderShow.addElement(CollectionHelper.option("是", Boolean.TRUE));
		editRenderShow.addElement(CollectionHelper.option("否", Boolean.FALSE));
		jcombo_editRenderShow.setModel(editRenderShow);

		CollectionHelper.renderWayOption(queryRenderWay, "query");
		jcombo_queryRenderWay.setModel(queryRenderWay);

		CollectionHelper.renderWayOption(listRenderWay, "list");
		jcombo_listRenderWay.setModel(listRenderWay);

		CollectionHelper.renderWayOption(editRenderWay, "edit");
		jcombo_editRenderWay.setModel(editRenderWay);

		int row = 1;
		ptba.add(new JLabel("字段标题"), MessageFormat.format("1,{0},2,{0}", row));
		ptba.add(columnTitle, MessageFormat.format("3,{0},4,{0}", row));
		ptba.add(btnTableColumnOk, MessageFormat.format("6,{0}", row));
		row++;
		ptba.add(jLabel14, MessageFormat.format("1,{0},2,{0}", row));
		ptba.add(jcombo_editRenderShow, MessageFormat.format("3,{0},4,{0}", row));
		ptba.add(btnListColumnOk, MessageFormat.format("6,{0}", row));
		row++;
		ptba.add(jLabel15, MessageFormat.format("1,{0},2,{0}", row));
		ptba.add(jcombo_editRenderWay, MessageFormat.format("3,{0},4,{0}", row));
		row++;
		JLabel j1 = new JLabel("填值方式");
		j1.setToolTipText("<html>\n" + "<table border=\"1\">\n" + "<tr>\n" + "	<th>参数</th>\n" + "	<th>描述</th>\n"
				+ "</tr>\n" + "<tr>\n" + "	<td>new</td>\n"
				+ "	<td>新增时该字段填值方式,如\"input\":输入, \"time\":获取当前时间, \"nothing\":不处理</td>\n" + "</tr>\n" + "</table>\n"
				+ "</html>");

		ptba.add(j1, MessageFormat.format("1,{0},2,{0}", row));
		ptba.add(cevfw, MessageFormat.format("3,{0},6,{0}", row));
		row++;
		ptba.add(new JLabel("JS验证"), MessageFormat.format("1,{0},2,{0}", row));
		ptba.add(evj, MessageFormat.format("3,{0},6,{0}", row));

		// showGsonAnnotation.setModel(null);

		btnGen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGenActionPerformed(evt);
			}
		});

		btnListColumnOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnListColumnOkActionPerformed(evt);
			}
		});
		
		btnTableColumnOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTableColumnOkActionPerformed(evt);
			}
		});

		TableLayout tableLayout_pbba = new TableLayout();
		// double border = 2; //0 1 2 3 4 5 6
		tableLayout_pbba.setColumn(new double[] { border, 50, 50, 80, -1, 50, 70, border });
		tableLayout_pbba.setRow(new double[] { border, 30, 30, 30, 30, 30, 130, border });
		pbba.setLayout(tableLayout_pbba);

		row = 1;
		pbba.add(jLabel16, MessageFormat.format("1,{0},2,{0}", row));
		pbba.add(listTitle, MessageFormat.format("3,{0},4,{0}", row));
		pbba.add(btnListColumnOk, MessageFormat.format("6,{0}", row));

		row++;
		pbba.add(jLabel12, MessageFormat.format("1,{0},2,{0}", row));
		pbba.add(jcombo_listRenderShow, MessageFormat.format("3,{0},4,{0}", row));
		row++;
		pbba.add(jLabel13, MessageFormat.format("1,{0},2,{0}", row));
		pbba.add(jcombo_listRenderWay, MessageFormat.format("3,{0},4,{0}", row));

		row++;
		pbba.add(jLabel10, MessageFormat.format("1,{0},2,{0}", row, row));
		pbba.add(jcombo_queryRenderShow, MessageFormat.format("3,{0},4,{0}", row));
		row++;
		pbba.add(jLabel11, MessageFormat.format("1,{0},2,{0}", row));
		pbba.add(jcombo_queryRenderWay, MessageFormat.format("3,{0},4,{0}", row));
		row++;
		pbba.add(new JLabel("查询字段"), MessageFormat.format("1,{0},2,{0}", row));
		pbba.add(cqpc, MessageFormat.format("3,{0},6,{0}", row));

		// TableLayout tableLayout_pba = new TableLayout();
		//// double border = 2; //0 1 2 3 4 5 6
		// tableLayout_pba.setColumn(new double[]{border, 50, 50, 80, -1, 50,
		// 70, border});
		// tableLayout_pba.setRow(new double[]{border,30, 30, 30, 30, 30, 30,
		// 30, 30, 30, 30, border});
		// pba.setLayout(tableLayout_pba);
		//
		// pba.add(jLabel1, "1,1,2,1");
		// pba.add(basePackageName, "3,1,5,1");
		// pba.add(btnGen, "6,1");
		//
		// pba.add(jLabel2, "1,2,2,2");
		// pba.add(jcombo_sqlMapMarkUse, "3,2,4,2");
		//
		// pba.add(jLabel9, "1,3,2,3");
		// pba.add(jcombo_showGsonAnnotation, "3,3,4,3");
		//
		// pba.add(jLabel3, "1,4,2,4");
		// pba.add(saveMethodPrefix, "3,4,4,4");
		//
		// pba.add(jLabel4, "1,5,2,5");
		// pba.add(updateMethodPrefix, "3,5,4,5");
		//
		// pba.add(jLabel5, "1,6,2,6");
		// pba.add(getMethodPrefix, "3,6,4,6");
		//
		// pba.add(jLabel6, "1,7,2,7");
		// pba.add(deleteMethodPrefix, "3,7,4,7");
		//
		// pba.add(jLabel7, "1,8,2,8");
		// pba.add(queryMethodPrefix, "3,8,4,8");
		//
		// pba.add(jLabel8, "1,9,2,9");
		// pba.add(queryPagingMethodPrefix, "3,9,4,9");

		sqlMapMarkUse.addElement(CollectionHelper.option("属性名称", 1));
		sqlMapMarkUse.addElement(CollectionHelper.option("表字段名称", 2));
		jcombo_sqlMapMarkUse.setModel(sqlMapMarkUse);

		showGsonAnnotation.addElement(CollectionHelper.option("是", Boolean.TRUE));
		showGsonAnnotation.addElement(CollectionHelper.option("否", Boolean.FALSE));
		jcombo_showGsonAnnotation.setModel(showGsonAnnotation);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(p,
				javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(p,
				javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 446,
				Short.MAX_VALUE));

		this.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				afterShow(evt);
			}
		});

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * add by 2016年4月5日 改变行选择时执行;
	 */
	private void changeTableRow() {
		if (model != null && model.getEntity() != null && model.getEntity().getTableColumns() != null) {
			final int index = tableColumnTable.getSelectedRow();
			if (index < 0)
				return;
			TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {
					List<TableColumn> list = model.getEntity().getTableColumns();
					if (index < list.size()) {
						final TableColumn tc = list.get(index);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								ModelHelper.simpleGetAndComplexSet(tc, TableView.this, ModelValueCategory.Column);
							}
						});
					}
					return null;
				}
			});
		}
	}

	private void changeListTableRow() {
		if (model != null 
				&& model.getEntity() != null 
				&& model.getEntity().getRawListColumns() != null) {
			final int index = listColumnTable.getSelectedRow();
			if (index < 0)
				return;
			TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {
					List<ListColumn> list = model.getEntity().getRawListColumns();
					if (index < list.size()) {
						final ListColumn lc = list.get(index);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								ModelHelper.simpleGetAndComplexSet(lc, TableView.this, ModelValueCategory.List);
							}
						});
					}
					return null;
				}
			});
		}
	}

	private void afterShow(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_afterShow
		// table.addPropertyChangeListener("tableCellEditor", new
		// PropertyChangeListener() {
		//
		// @Override
		// public void propertyChange(PropertyChangeEvent evt) {
		// System.out.println("1[" +evt.getPropertyName());
		// System.out.println("2[" +evt.getSource());
		// System.out.println("3[" +(evt.getOldValue()));
		// System.out.println("4[" +evt.getNewValue());
		// System.out.println("5[" +table.getCellEditor());
		// }
		// });

		// table.getCellEditor().addCellEditorListener(new CellEditorListener()
		// {
		//
		// @Override
		// public void editingStopped(ChangeEvent e) {
		// System.out.println("stop");
		// }
		//
		// @Override
		// public void editingCanceled(ChangeEvent e) {
		// System.out.println("cancel");
		// }
		// });

		tableColumnTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeTableRow();
			}
		});

		// 38 up;
		// 40 down;
		// 37 left;
		// 39 right;
		// 10 enter;
		tableColumnTable.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == 10 || keyCode == 38 || keyCode == 40)
					changeTableRow();
			}
		});

		listColumnTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeListTableRow();
			}
		});

		// 38 up;
		// 40 down;
		// 37 left;
		// 39 right;
		// 10 enter;
		listColumnTable.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == 10 || keyCode == 38 || keyCode == 40)
					changeListTableRow();
			}
		});

		p.setDividerLocation(0.5);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				pt.setDividerLocation(0.5);

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						pb.setDividerLocation(0.5);
					}
				});
			}
		});
	}

	/**
	 * 列表"OK"按钮;
	 * @param evt
	 */
	private void btnListColumnOkActionPerformed(java.awt.event.ActionEvent evt) {
		if (model != null && model.getEntity() != null && model.getEntity().getRawListColumns() != null) {
			final int index = listColumnTable.getSelectedRow();
			TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {
					List<ListColumn> list = model.getEntity().getRawListColumns();
					if (index > -1 && index < list.size()) {
						ListColumn lc = list.get(index);
						ModelHelper.complexGetAndSimpleSet(TableView.this, lc, ModelValueCategory.List);
					}
					return null;
				}
			});
		}
	}
	
	/**
	 * 字段表"OK"按钮;
	 * @param evt
	 */
	private void btnTableColumnOkActionPerformed(java.awt.event.ActionEvent evt) {
		if (model != null && model.getEntity() != null && model.getEntity().getTableColumns() != null) {
			final int index = tableColumnTable.getSelectedRow();
			TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {
					List<TableColumn> list = model.getEntity().getTableColumns();
					if (index > -1 && index < list.size()) {
						TableColumn tc = list.get(index);
						ModelHelper.complexGetAndSimpleSet(TableView.this, tc, ModelValueCategory.Column);
					}
					return null;
				}
			});
		}
	}

	/**
	 * add by 2016年4月5日 自动提交表格数据到内存;
	 */
	private void setTableColumnValue(Object cellValue) {
		final int r = tableColumnTable.getSelectedRow();
		final int c = tableColumnTable.getSelectedColumn();
		if (model != null 
				&& model.getEntity() != null 
				&& model.getEntity().getTableColumns() != null) {
			List<TableColumn> list = model.getEntity().getTableColumns();
			int size = list.size();
			if (r > -1 && r < size) {
				TableColumn tc = list.get(r);

				// 变更第4列(列别名)的值进入TableColumn
				if (c == 3) {
					String ca = (String) cellValue;
					tc.setColumnAlias(ca);
					// 排序
				} else if (c == 4) {
					Integer seq = (Integer) cellValue;
					tc.setSeq(seq);

					// 循环list,将>=seq列的值+1;
					for (int i = 0; i < size; i++) {
						TableColumn tmp = list.get(i);
						if (tmp != tc) {
							Integer s = tmp.getSeq();
							if (s != null && s >= seq && s < IConsant.DEF_MAX_SEQ) {
								Integer newVal = s + 1;
								// 变更显示的值;
								tableColumnTable.getModel().setValueAt(newVal, i, c);

								// 变更内存值;
								tmp.setSeq(newVal);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * update list table view;
	 * 
	 * @param cellValue
	 */
	private void setListColumnValue(Object cellValue) {
		final int r = listColumnTable.getSelectedRow();
		final int c = listColumnTable.getSelectedColumn();
		if (model != null && model.getEntity() != null && model.getEntity().getRawListColumns() != null) {
			List<ListColumn> list = model.getEntity().getRawListColumns();
			int size = list.size();
			if (r > -1 && r < size) {
				ListColumn tc = list.get(r);

				// 主键;
				if (c == 0) {
					Boolean pk = (Boolean) cellValue;
					tc.setPrimary(pk);
					for (int i = 0; i < size; i++) {
						ListColumn tmp = list.get(i);
						if (tmp != tc) {
							// 变更显示的值;
							listColumnTable.getModel().setValueAt(false, i, c);

							// 变更内存值;
							tmp.setPrimary(false);
						}
					}
					// 表列名;
				} else if (3 == c) {
//					String ta = (String) cellValue;
//					tc.setTableAlias(ta);
				}
				// 显示顺序;
				else if (c == 3) {
					Integer seq = (Integer) cellValue;
					tc.setSeq(seq);
					// 循环list,将>=seq列的值+1;
					for (int i = 0; i < size; i++) {
						ListColumn tmp = list.get(i);
						if (tmp != tc) {
							Integer s = tmp.getSeq();
							if (s != null && s >= seq && s < IConsant.DEF_MAX_SEQ) {
								Integer newVal = s + 1;
								// 变更显示的值;
								listColumnTable.getModel().setValueAt(newVal, i, c);

								// 变更内存值;
								tmp.setSeq(newVal);
							}
						}
					}
					// 排序;
				} else if (c == 4) {
					Integer order = (Integer) cellValue;
					tc.setOrder(order);
				}
			}
		}
	}

	private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {
		if (model != null) {
			fileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setCurrentDirectory(new File("d:\\Home\\Desktop"));
			int opt = fileChooser.showSaveDialog(null);
			// 保存;
			if (JFileChooser.APPROVE_OPTION == opt) {
				TaskHelper.runInNonEDT(new Callable<Integer[]>() {
					public Integer[] call() throws Exception {
						File saveFile = fileChooser.getSelectedFile();
						if (!saveFile.exists())
							saveFile.mkdirs();
						// 设置全局值;
						// ModelHelper.complexGetAndSimpleSet(TableView.this,
						// model);

						// 加工model;ok
						ModelHelper.processTableViewModel(model);

						String javaContent = VelocityHelper.entityBean(model);
						// System.out.println(javaContent);
						FileHelper.genPojoJavaFile(saveFile.getAbsolutePath(), model.getPojoFullPackageName(),
								model.getEntity().getEntityBeanName(), javaContent);

						 String sqlMapContent = VelocityHelper.sqlMap(model);
						 FileHelper.genSqlMapXmlFile(saveFile.getAbsolutePath(),
						 model.getEntity().getEntityBeanName(),
						 sqlMapContent);
						// System.out.println(sqlMapContent);
						
						 String sqlMapIDaoContent =
						 VelocityHelper.sqlMapIDao(model);
						 FileHelper.genSqlMapIDaoJavaFile(saveFile.getAbsolutePath(),
						 model.getDaoFullPackageName(),
						 model.getEntity().getEntityBeanName(),
						 sqlMapIDaoContent);
						
						 if(!VelocityHelper.isMybtis()){
							 String sqlMapDaoImplContent =
							 VelocityHelper.sqlMapDaoImpl(model);
							 FileHelper.genSqlMapDaoImplJavaFile(saveFile.getAbsolutePath(),
							 model.getDaoImplFullPackageName(),
							 model.getEntity().getEntityBeanName(),
							 sqlMapDaoImplContent);
						 }
						
						 String sqlMapIServiceContent =
						 VelocityHelper.sqlMapIService(model);
						 FileHelper.genSqlMapIServiceJavaFile(saveFile.getAbsolutePath(),
						 model.getServiceFullPackageName(),
						 model.getEntity().getEntityBeanName(),
						 sqlMapIServiceContent);
						
						 String sqlMapServiceImplContent =
						 VelocityHelper.sqlMapServiceImpl(model);
						 FileHelper.genSqlMapServiceImplJavaFile(saveFile.getAbsolutePath(),
						 model.getServiceImplFullPackageName(),
						 model.getEntity().getEntityBeanName(),
						 sqlMapServiceImplContent);
						
						 String springWebActionContent =
						 VelocityHelper.springWebAction(model);
						 FileHelper.genSpringWebActionJavaFile(saveFile.getAbsolutePath(),
						 model.getWebActionFullPackageName(),
						 model.getEntity().getEntityBeanName(),
						 springWebActionContent);
						 
						 String bootstrapDataTableJspContent =
						VelocityHelper.bootstrapDataTableJsp(model);
						FileHelper.genBootstrapDataTableJspFile(saveFile.getAbsolutePath(),
						model.getJspWebinfAfterDir(),
						model.getEntity().getEntityBeanName(),
						bootstrapDataTableJspContent);

						EventQueue.invokeLater(new Runnable() {
							public void run() {
								JOptionPane.showMessageDialog(null, "生成文件完成!");
							}
						});
						return null;
					}
				});
			}
		}
	}

	private void initEntity(Entity e) {
		ModelHelper.simpleGetAndComplexSet(model, TableView.this);
		model.setEntity(e);
	}

	/**
	 * 更新表字段table;
	 * 
	 * @param list
	 */
	private void updateTableData(final List<TableColumn> list) {
		TaskHelper.runInNonEDT(new Callable<Void>() {
			@Override
			public Void call() throws Exception {

				Vector<Vector<Object>> v = TableHelper2.transform1(list);
				Vector<Object> v2 = new Vector<Object>();

				// final DefaultTableColumnModel dtcm = new
				// DefaultTableColumnModel();

				// ["列名称", "编辑类型"]
				String[][] heads = new String[][] { { "主键", null }, // 0
						{ "自增长", null }, // 1
						{ "列名称", null }, // 2
						{ "列别名", CellEditorType.String.name() }, // 3
						{ "显示顺序", CellEditorType.Number.name() }, // 4
						{ "列描述", null } // 5
				};

				for (int i = 0; i < heads.length; i++) {
					String[] tmp = heads[i];
					// javax.swing.table.TableColumn h = new
					// javax.swing.table.TableColumn(i);
					// h.setHeaderValue(tmp[0]);
					// dtcm.addColumn(h);
					v2.add(tmp[0]);
				}

				final DefaultTableModel dtm = new DefaultTableModel(v, v2) {
					private static final long serialVersionUID = 1L;

					/**
					 * 获取列的类型;用来输入时判断是否合法输入;
					 */
					public Class<?> getColumnClass(int col) {
						// //显示排序或者是记录排序
						if (col == 4)
							return Integer.class;
						Object value = getValueAt(0, col);
						if (value != null)
							return value.getClass();
						else
							return super.getClass();
					}

					public boolean isCellEditable(int row, int column) {
						if (column == 3 || column == 4
						/* || column == 5 */)
							return true;
						return false;
					}
				};

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						tableColumnTable.setModel(dtm);
					}
				});

				return null;
			}
		});
	}

	/**
	 * 更新列表字段table;
	 * modify by 2016年6月18日
	 * 取消"表别名", 由于无法解析表别名, 因此不让用户修改, 放在查询json字符串中用户自定义;
	 * @param list
	 */
	private void updateListData(final List<ListColumn> list) {
		TaskHelper.runInNonEDT(new Callable<Void>() {
			public Void call() throws Exception {
				String[] heads = { "主键", // 0
						"列名称", // 1
						"列别名", // 2
//						"表别名", // 
						"显示顺序", // 3
						"排序字段", // 4
						"列描述", };
				Vector<String> v = new Vector<String>();
				for (String h : heads) {
					v.add(h);
				}
				Vector<Vector<Object>> vc = new Vector<Vector<Object>>();
				for (ListColumn lc : list) {
					Vector<Object> t = new Vector<Object>();
					t.add(Boolean.valueOf(lc.isPrimary()));
					t.add(lc.getColumnName());
					t.add(lc.getColumnAlias());
//					String ta = lc.getTableAlias();
//					if(StringUtils.isNotBlank(ta)){
//						t.add(ta);
//					}else{
//						t.add("t1");
//					}
					if (lc.getSeq() == null) {
						if (lc.isPrimary())
							t.add(IConsant.DEF_MIN_SEQ);
						else
							t.add(IConsant.DEF_MAX_SEQ);
					} else {
						t.add(lc.getSeq());
					}
					t.add(lc.getOrder());
					t.add(lc.getColumnCommon());
					vc.add(t);
				}
				final DefaultTableModel dtm = new DefaultTableModel(vc, v) {
					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * javax.swing.table.AbstractTableModel#getColumnClass(int)
					 */
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						if (columnIndex == 3
								||columnIndex == 4)
							return Integer.class;
						Object value = getValueAt(0, columnIndex);
						if (value != null)
							return value.getClass();
						else
							return super.getClass();
					}

					public boolean isCellEditable(int row, int column) {
						if (column == 0 || column == 3 || column == 4 )
							return true;
						return false;
					}
				};

				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						listColumnTable.setModel(dtm);
					}
				});
				return null;
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JButton btnGen;
	private javax.swing.JButton btnListColumnOk;
	private javax.swing.JButton btnTableColumnOk;

	@ModelValue(valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField deleteMethodPrefix;
	private javax.swing.JFileChooser fileChooser;

	@ModelValue(valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField getMethodPrefix;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;

	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;

	@ModelValue(valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField basePackageName;
	@ModelValue(valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField queryMethodPrefix;
	@ModelValue(valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField queryPagingMethodPrefix;
	@ModelValue(valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField saveMethodPrefix;
	private javax.swing.JComboBox<Option<Boolean>> jcombo_showGsonAnnotation;

	private javax.swing.JSplitPane p;
	private javax.swing.JPanel p0t;
	private javax.swing.JSplitPane pt;
	private javax.swing.JScrollPane ptt;
	private javax.swing.JScrollPane ptb;
	private javax.swing.JPanel ptba;
	private javax.swing.JSplitPane pb;
	private javax.swing.JPanel p0b;
	private javax.swing.JScrollPane pbt;
	private javax.swing.JScrollPane pbb;
	private javax.swing.JPanel pbba;

	private javax.swing.JComboBox<Option<Integer>> jcombo_sqlMapMarkUse;
	private javax.swing.JTable tableColumnTable;
	private javax.swing.JTable listColumnTable;
	@ModelValue(valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField updateMethodPrefix;

	@ModelValue()
	private OptionComboBoxModel<Integer> sqlMapMarkUse = new OptionComboBoxModel<Integer>();
	@ModelValue()
	private OptionComboBoxModel<Boolean> showGsonAnnotation = new OptionComboBoxModel<Boolean>();

	private javax.swing.JComboBox<Option<Integer>> jcombo_queryRenderWay;
	private javax.swing.JComboBox<Option<Integer>> jcombo_listRenderWay;
	private javax.swing.JComboBox<Option<Integer>> jcombo_editRenderWay;

	@ModelValue(category = ModelValueCategory.List)
	private OptionComboBoxModel<Integer> queryRenderWay = new OptionComboBoxModel<Integer>();
	@ModelValue(category = ModelValueCategory.List)
	private OptionComboBoxModel<Integer> listRenderWay = new OptionComboBoxModel<Integer>();
	@ModelValue(category = ModelValueCategory.Column)
	private OptionComboBoxModel<Integer> editRenderWay = new OptionComboBoxModel<Integer>();

	private javax.swing.JComboBox<Option<Boolean>> jcombo_queryRenderShow;
	private javax.swing.JComboBox<Option<Boolean>> jcombo_listRenderShow;
	private javax.swing.JComboBox<Option<Boolean>> jcombo_editRenderShow;

	@ModelValue(category = ModelValueCategory.List)
	private OptionComboBoxModel<Boolean> queryRenderShow = new OptionComboBoxModel<Boolean>();
	@ModelValue(category = ModelValueCategory.List)
	private OptionComboBoxModel<Boolean> listRenderShow = new OptionComboBoxModel<Boolean>();
	@ModelValue(category = ModelValueCategory.Column)
	private OptionComboBoxModel<Boolean> editRenderShow = new OptionComboBoxModel<Boolean>();

	private javax.swing.JLabel jLabel16;
	@ModelValue(category = ModelValueCategory.Column, valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField columnTitle;

	@ModelValue(category = ModelValueCategory.List, valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextField listTitle;

	@ModelValue(category = ModelValueCategory.List, valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextArea queryColumnJson;

	@ModelValue(category = ModelValueCategory.Column, valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextArea editValueGenWayJson;

	@ModelValue(category = ModelValueCategory.Column, valueGetFuncName = "getText", valueSetFuncName = "setText")
	private javax.swing.JTextArea editValidateJson;
	// End of variables declaration//GEN-END:variables

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * me.paddingdun.gen.code.gui.view.AbstractView#doMessage(me.paddingdun.gen.
	 * code.data.message.Message)
	 */
	@Override
	public void doMessage(Message message) {
		// 表格树点击消息;
		if (DesignerPerspective.MESSAGE_CLICK_TABLE_TREE_NODE.equals(message.getName())) {
			IDBTable dbt = (DBTable) message.getObject();
			final Entity entity = new Entity(dbt);

			TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {

					initEntity(entity);

					List<TableColumn> list_tr = TableHelper2.tableColumn(entity.getCat(), entity.getTableName());
					entity.setTableColumns(list_tr);

					/**
					 * 更新表格数据;
					 */
					updateTableData(list_tr);

					return null;
				}
			});

			/**
			 * add by 2016年4月18日 点击查询按钮sql事件接收;
			 */
		} else if (DesignerPerspective.MESSAGE_CLICK_QUERY_SQL_BUTTON.equals(message.getName())) {
			final EditViewModel evModel = (EditViewModel) message.getObject();

			TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {
					final List<ListColumn> list_lc = TableHelper2.listColumn(evModel);
					model.getEntity().setRawListColumns(list_lc);
					model.getEntity().setQuerySql(evModel.getQuerySql());

					updateListData(list_lc);
					return null;
				}
			});

		} else if (DesignerPerspective.MESSAGE_GEN_ENTITY.equals(message.getName())) {
			btnGenActionPerformed(null);
		}
	}
}
