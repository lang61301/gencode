/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.paddingdun.gen.code.gui.view.dbtable;

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

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import org.apache.log4j.Logger;

import layout.TableLayout;
import me.paddingdun.gen.code.IConsant;
import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.data.option.ModelValue;
import me.paddingdun.gen.code.data.option.ModelValueCategory;
import me.paddingdun.gen.code.data.option.Option;
import me.paddingdun.gen.code.data.table.CellEditorType;
import me.paddingdun.gen.code.data.table.TableColumn;
import me.paddingdun.gen.code.data.tabletree.DBTable;
import me.paddingdun.gen.code.data.tabletree.Table;
import me.paddingdun.gen.code.db.TableHelper;
import me.paddingdun.gen.code.gui.perspective.designer.DesignerPerspective;
import me.paddingdun.gen.code.gui.view.AbstractView;
import me.paddingdun.gen.code.util.CollectionHelper;
import me.paddingdun.gen.code.util.FileHelper;
import me.paddingdun.gen.code.util.ModelHelper;
import me.paddingdun.gen.code.util.SpringHelper;
import me.paddingdun.gen.code.util.TaskHelper;
import me.paddingdun.gen.code.util.VelocityHelper;

/**
 *
 * @author admin
 */
@SuppressWarnings("serial")
public class TableView extends AbstractView {
	
	/**
	 * TableView 日志变量;
	 */
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(TableView.class);


	@SuppressWarnings("unused")
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
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("数据库表详细内容");
        fileChooser = new javax.swing.JFileChooser();
        p = new javax.swing.JSplitPane();
        pt = new javax.swing.JSplitPane();
        ptt = new javax.swing.JScrollPane();
        ptb = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){
        	public void editingStopped(ChangeEvent e) {
        		TableCellEditor editor = this.getCellEditor();
                if (editor != null) {
                    Object value = editor.getCellEditorValue();
                    setTableColumnValue(value);
                }
//        		System.out.println(MessageFormat.format("c:{0}-r:{1}", this.getSelectedColumn(), this.getSelectedRow()));
                super.editingStopped(e);
            }
        };
        //当使用ColumnModel时将其设置成false;
//        table.setAutoCreateColumnsFromModel(false);
        pb = new javax.swing.JScrollPane();
        pba = new javax.swing.JPanel();
        ptba = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        basePackageName = new javax.swing.JTextField();
        btnGen = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
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
//        customQueryProperty.setAutoscrolls(true);
        
        editValueGenWayJson = new javax.swing.JTextArea(1, 10);
        javax.swing.JScrollPane cevfw = new javax.swing.JScrollPane(editValueGenWayJson); 
        
        editValidateJson = new javax.swing.JTextArea(1, 10);
        javax.swing.JScrollPane evj = new javax.swing.JScrollPane(editValidateJson); 
        
        p.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        pt.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        ptt.setViewportView(table);

        p.setLeftComponent(pt);
        
        pt.setTopComponent(ptt);
        pt.setBottomComponent(ptb);
        
        pb.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        ptb.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ptb.setViewportView(ptba);
        
        jLabel1.setText("基础包名称");

        btnGen.setText("生成");
        btnOk.setText("Ok");

        jLabel2.setText("SQL传入值占位符");

//        sqlMapMarkUse.setModel(null);

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
        double border = 2;			      		//0      1    2     3    4     5     6
        tableLayout_ptba.setColumn(new double[]{border, 50,  50,   80,  -1,  50,   70, border});
        tableLayout_ptba.setRow(new double[]{border,30, 30, 30, 130, 30, 30, 30, 30, 130, 130, border});
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
        
        
        
        CollectionHelper.renderWayOption(queryRenderWay,"query");
        jcombo_queryRenderWay.setModel(queryRenderWay);

        CollectionHelper.renderWayOption(listRenderWay,"list");
        jcombo_listRenderWay.setModel(listRenderWay);

        CollectionHelper.renderWayOption(editRenderWay,"edit");
        jcombo_editRenderWay.setModel(editRenderWay);
        
        int row = 1;
        ptba.add(jLabel16, MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(columnTitle, MessageFormat.format("3,{0},4,{0}", row));
        
        row++;
        ptba.add(jLabel10, MessageFormat.format("1,{0},2,{0}", row, row));
        ptba.add(jcombo_queryRenderShow, MessageFormat.format("3,{0},4,{0}", row));
        ptba.add(btnOk, MessageFormat.format("6,{0}", row));
        row++;
        ptba.add(jLabel11, MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(jcombo_queryRenderWay, MessageFormat.format("3,{0},4,{0}", row));
        row++;
        ptba.add(new JLabel("查询字段"), MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(cqpc, MessageFormat.format("3,{0},6,{0}", row));
        
        row++;
        ptba.add(jLabel12, MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(jcombo_listRenderShow, MessageFormat.format("3,{0},4,{0}", row));
        row++;
        ptba.add(jLabel13, MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(jcombo_listRenderWay, MessageFormat.format("3,{0},4,{0}", row));
        
        row++;
        ptba.add(jLabel14, MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(jcombo_editRenderShow, MessageFormat.format("3,{0},4,{0}", row));
        row++;
        ptba.add(jLabel15, MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(jcombo_editRenderWay, MessageFormat.format("3,{0},4,{0}", row));
        row++;
        JLabel j1 = new JLabel("填值方式");
        j1.setToolTipText("<html>\n" + 
        		"<table border=\"1\">\n" + 
        		"<tr>\n" + 
        		"	<th>参数</th>\n" + 
        		"	<th>描述</th>\n" + 
        		"</tr>\n" + 
        		"<tr>\n" + 
        		"	<td>new</td>\n" + 
        		"	<td>新增时该字段填值方式,如\"input\":输入, \"time\":获取当前时间, \"nothing\":不处理</td>\n" + 
        		"</tr>\n" + 
        		"</table>\n" + 
        		"</html>");
        
        ptba.add(j1, MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(cevfw, MessageFormat.format("3,{0},6,{0}", row));
        row++;
        ptba.add(new JLabel("JS验证"), MessageFormat.format("1,{0},2,{0}", row));
        ptba.add(evj, MessageFormat.format("3,{0},6,{0}", row));

//        showGsonAnnotation.setModel(null);

        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });
        
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        
        TableLayout tableLayout_pba = new TableLayout();
//        double border = 2;			      //0      1    2     3    4     5     6
        tableLayout_pba.setColumn(new double[]{border, 50,  50,   80,  -1,  50,   70, border});
        tableLayout_pba.setRow(new double[]{border,30, 30, 30, 30, 30, 30, 30, 30, 30, 30, border});
        pba.setLayout(tableLayout_pba);
        
        pba.add(jLabel1, "1,1,2,1");
        pba.add(basePackageName, "3,1,5,1");
        pba.add(btnGen, "6,1");
        
        pba.add(jLabel2, "1,2,2,2");
        pba.add(jcombo_sqlMapMarkUse, "3,2,4,2");
        
        pba.add(jLabel9, "1,3,2,3");
        pba.add(jcombo_showGsonAnnotation, "3,3,4,3");
        
        pba.add(jLabel3, "1,4,2,4");
        pba.add(saveMethodPrefix, "3,4,4,4");
        
        pba.add(jLabel4, "1,5,2,5");
        pba.add(updateMethodPrefix, "3,5,4,5");
        
        pba.add(jLabel5, "1,6,2,6");
        pba.add(getMethodPrefix, "3,6,4,6");
        
        pba.add(jLabel6, "1,7,2,7");
        pba.add(deleteMethodPrefix, "3,7,4,7");
        
        pba.add(jLabel7, "1,8,2,8");
        pba.add(queryMethodPrefix, "3,8,4,8");
        
        pba.add(jLabel8, "1,9,2,9");
        pba.add(queryPagingMethodPrefix, "3,9,4,9");
        
        
        sqlMapMarkUse.addElement(CollectionHelper.option("属性名称", 1));
        sqlMapMarkUse.addElement(CollectionHelper.option("表字段名称", 2));
       jcombo_sqlMapMarkUse.setModel(sqlMapMarkUse);
       
       showGsonAnnotation.addElement(CollectionHelper.option("是", Boolean.TRUE));
       showGsonAnnotation.addElement(CollectionHelper.option("否", Boolean.FALSE));
       jcombo_showGsonAnnotation.setModel(showGsonAnnotation);
       
       
        
        pb.setViewportView(pba);

        p.setBottomComponent(pb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        

        
        
        
        
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                afterShow(evt);
            }
        });
        
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * add by 2016年4月5日
     * 改变行选择时执行;
     */
    private void changeRow(){
    	if(model != null
    			&& model.getTable() != null
    			&& model.getTable().getColumns() != null){
    		final int index = table.getSelectedRow();
    		if(index < 0) return;
    		TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {
    	    		List<TableColumn> list = model.getTable().getColumns();
    	    		if(index < list.size()){
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
    
    private void afterShow(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_afterShow
//    	table.addPropertyChangeListener("tableCellEditor", new PropertyChangeListener() {
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				System.out.println("1[" +evt.getPropertyName());
//				System.out.println("2[" +evt.getSource());
//				System.out.println("3[" +(evt.getOldValue()));
//				System.out.println("4[" +evt.getNewValue());
//				System.out.println("5[" +table.getCellEditor());
//			}
//		});
    	
//    	table.getCellEditor().addCellEditorListener(new CellEditorListener() {
//			
//			@Override
//			public void editingStopped(ChangeEvent e) {
//				System.out.println("stop");
//			}
//			
//			@Override
//			public void editingCanceled(ChangeEvent e) {
//				System.out.println("cancel");
//			}
//		});
    	
    	table.addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mouseClicked(MouseEvent e){
    	    	changeRow();
    	    }
    	});
    	
    	//38 up;
		//40 down;
		//37 left;
		//39 right;
		//10 enter;
    	table.addKeyListener(new KeyAdapter() {
    		public void keyReleased(KeyEvent e) {
    			int keyCode = e.getKeyCode();
    			if(keyCode == 10
    					|| keyCode == 38
    					|| keyCode == 40)
    				changeRow();
    		}
		});
    	p.setDividerLocation(0.85);
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				pt.setDividerLocation(0.4);
			}
		});
    }
    
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {
    	if(model != null
    			&& model.getTable() != null
    			&& model.getTable().getColumns() != null){
    		final int index = table.getSelectedRow();
    		TaskHelper.runInNonEDT(new Callable<Void>() {
				public Void call() throws Exception {
    	    		List<TableColumn> list = model.getTable().getColumns();
    	    		if(index >-1
    	    				&& index < list.size()){
    	    			TableColumn tc = list.get(index);
    	    			ModelHelper.complexGetAndSimpleSet(TableView.this, tc, ModelValueCategory.Column);
    	    			
    	    			/**
    	    			 * modify by 2016年4月6日
    	    			 * 新增了setTableColumnValue方法后,就不需要点击ok保存表格中的属性了;
    	    			 */
//    	    			//变更第4列(列别名)的值进入TableColumn
//    	    			String ca = (String)table.getModel().getValueAt(index, 3);
//    	    			tc.setColumnAlias(ca);
//    	    			
//    	    			//变更第5列(显示顺序)的值进入TableColumn
//    	    			Integer seq = (Integer)table.getModel().getValueAt(index, 4);
//    	    			tc.setSeq(seq);
//    	    			
//    	    			//变更第6列(排序字段顺序)的值进入TableColumn
//    	    			Integer order = (Integer)table.getModel().getValueAt(index, 5);
//    	    			tc.setOrder(order);
    	    		}
					return null;
				}
    		});
    	}
    }
    
    /**
     * add by 2016年4月5日
     * 自动提交表格数据到内存;
     */
    private void setTableColumnValue(Object cellValue){
    	final int r = table.getSelectedRow();
    	final int c = table.getSelectedColumn();
    	if(model != null
    			&& model.getTable() != null
    			&& model.getTable().getColumns() != null){
    		List<TableColumn> list = model.getTable().getColumns();
    		int size = list.size();
    		if(r > -1 
    				&& r < size){
    			TableColumn tc = list.get(r);
    			
    			//变更第4列(列别名)的值进入TableColumn
            	if(c == 3){
            		String ca = (String)cellValue;
            		tc.setColumnAlias(ca);
            	//变更第5列(显示顺序)的值进入TableColumn
            	}else if(c == 4){
            		Integer seq = (Integer)cellValue;
            		tc.setSeq(seq);
            		
            		//循环list,将>=seq列的值+1;
            		for (int i = 0; i < size; i++) {
						TableColumn tmp = list.get(i);
						if(tmp != tc){
							Integer s = tmp.getSeq();
							if(s != null
									&& s >= seq
									&& s < IConsant.DEF_MAX_SEQ){
								Integer newVal = s + 1;
								//变更显示的值;
								table.getModel().setValueAt(newVal, i, c);
								
								//变更内存值;
								tmp.setSeq(newVal);
							}
						}
					}
            	//变更第6列(排序字段顺序)的值进入TableColumn
            	}else if(c == 5){
            		Integer order = (Integer)cellValue;
            		tc.setOrder(order);
            	}
            	table.updateUI();
    		}
    	}
    }
    
    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {
    	if(model!= null){
	    	fileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG|JFileChooser.DIRECTORIES_ONLY);
	    	fileChooser.setCurrentDirectory(new File("C:\\Users\\admin\\Desktop"));
	        int opt = fileChooser.showSaveDialog(null);
	        //保存;
	        if(JFileChooser.APPROVE_OPTION == opt){
	        	TaskHelper.runInNonEDT(new Callable<Integer[]>() {
					public Integer[] call() throws Exception {
						File saveFile = fileChooser.getSelectedFile();
			        	if(!saveFile.exists())
			        		saveFile.mkdirs();
			        	//设置全局值;
			        	ModelHelper.complexGetAndSimpleSet(TableView.this, model);
			        	//加工model;
			        	ModelHelper.processTableViewModel(model);
			        	
			        	/**
			        	 * add by 2016年4月6日
			        	 * 由于有显示列按照顺序重新排序,因此要更新数据表格;
			        	 */
			        	updateTableData(model.getTable().getColumns());
			        	
			        	String javaContent = VelocityHelper.entityBean(model);
//			        	System.out.println(javaContent);
			        	FileHelper.genPojoJavaFile(saveFile.getAbsolutePath(), model.getPojoFullPackageName(), model.getTable().getEntityBeanName(), javaContent);
			        	
			        	String sqlMapContent = VelocityHelper.sqlMap(model);
			        	FileHelper.genSqlMapXmlFile(saveFile.getAbsolutePath(), model.getTable().getEntityBeanName(), sqlMapContent);
//			        	System.out.println(sqlMapContent);
			        	
			        	String bootstrapDataTableJspContent = VelocityHelper.bootstrapDataTableJsp(model);
			        	FileHelper.genBootstrapDataTableJspFile(saveFile.getAbsolutePath(), model.getJspWebinfAfterDir(), model.getTable().getEntityBeanName(), bootstrapDataTableJspContent);
			        	
			        	String sqlMapIDaoContent = VelocityHelper.sqlMapIDao(model);
			        	FileHelper.genSqlMapIDaoJavaFile(saveFile.getAbsolutePath(), model.getDaoFullPackageName(), model.getTable().getEntityBeanName(), sqlMapIDaoContent);
			        	
			        	String sqlMapDaoImplContent = VelocityHelper.sqlMapDaoImpl(model);
			        	FileHelper.genSqlMapDaoImplJavaFile(saveFile.getAbsolutePath(), model.getDaoImplFullPackageName(), model.getTable().getEntityBeanName(), sqlMapDaoImplContent);
			        	
			        	String sqlMapIServiceContent = VelocityHelper.sqlMapIService(model);
			        	FileHelper.genSqlMapIServiceJavaFile(saveFile.getAbsolutePath(), model.getServiceFullPackageName(), model.getTable().getEntityBeanName(), sqlMapIServiceContent);
			        	
			        	String sqlMapServiceImplContent = VelocityHelper.sqlMapServiceImpl(model);
			        	FileHelper.genSqlMapServiceImplJavaFile(saveFile.getAbsolutePath(), model.getServiceImplFullPackageName(), model.getTable().getEntityBeanName(), sqlMapServiceImplContent);
			        	
			        	String springWebActionContent = VelocityHelper.springWebAction(model);
			        	FileHelper.genSpringWebActionJavaFile(saveFile.getAbsolutePath(), model.getWebActionFullPackageName(), model.getTable().getEntityBeanName(), springWebActionContent);
			        	
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JButton btnGen;
    private javax.swing.JButton btnOk;
    
    @ModelValue(valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextField deleteMethodPrefix;
    private javax.swing.JFileChooser fileChooser;
    
    @ModelValue(valueGetFuncName = "getText", valueSetFuncName ="setText")
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
    
    @ModelValue(valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextField basePackageName;
    @ModelValue(valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextField queryMethodPrefix;
    @ModelValue(valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextField queryPagingMethodPrefix;
    @ModelValue(valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextField saveMethodPrefix;
    private javax.swing.JComboBox<Option<Boolean>> jcombo_showGsonAnnotation;
    private javax.swing.JPanel pba;
    private javax.swing.JScrollPane pb;
    private javax.swing.JSplitPane p;
    private javax.swing.JSplitPane pt;
    private javax.swing.JScrollPane ptt;
    private javax.swing.JScrollPane ptb;
    private javax.swing.JPanel ptba;
    private javax.swing.JComboBox<Option<Integer>> jcombo_sqlMapMarkUse;
    private javax.swing.JTable table;
    @ModelValue(valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextField updateMethodPrefix;
    
    @ModelValue()
    private OptionComboBoxModel<Integer> sqlMapMarkUse = new OptionComboBoxModel<Integer>();
    @ModelValue()
    private OptionComboBoxModel<Boolean> showGsonAnnotation = new OptionComboBoxModel<Boolean>();
    
    private javax.swing.JComboBox<Option<Integer>> jcombo_queryRenderWay;
    private javax.swing.JComboBox<Option<Integer>> jcombo_listRenderWay;
    private javax.swing.JComboBox<Option<Integer>> jcombo_editRenderWay;
    
    @ModelValue(category=ModelValueCategory.Column)
    private OptionComboBoxModel<Integer> queryRenderWay = new OptionComboBoxModel<Integer>();
    @ModelValue(category=ModelValueCategory.Column)
    private OptionComboBoxModel<Integer> listRenderWay = new OptionComboBoxModel<Integer>();
    @ModelValue(category=ModelValueCategory.Column)
    private OptionComboBoxModel<Integer> editRenderWay = new OptionComboBoxModel<Integer>();
    
    private javax.swing.JComboBox<Option<Boolean>> jcombo_queryRenderShow;
    private javax.swing.JComboBox<Option<Boolean>> jcombo_listRenderShow;
    private javax.swing.JComboBox<Option<Boolean>> jcombo_editRenderShow;
    
    @ModelValue(category=ModelValueCategory.Column)
    private OptionComboBoxModel<Boolean> queryRenderShow = new OptionComboBoxModel<Boolean>();
    @ModelValue(category=ModelValueCategory.Column)
    private OptionComboBoxModel<Boolean> listRenderShow = new OptionComboBoxModel<Boolean>();
    @ModelValue(category=ModelValueCategory.Column)
    private OptionComboBoxModel<Boolean> editRenderShow = new OptionComboBoxModel<Boolean>();
    
    private javax.swing.JLabel jLabel16;
    @ModelValue(category=ModelValueCategory.Column, valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextField columnTitle; 
    
    @ModelValue(category=ModelValueCategory.Column,valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextArea queryColumnJson;
    
    @ModelValue(category=ModelValueCategory.Column,valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextArea editValueGenWayJson;
    
    @ModelValue(category=ModelValueCategory.Column,valueGetFuncName = "getText", valueSetFuncName ="setText")
    private javax.swing.JTextArea editValidateJson;
    
    
    private void initModel(Table t){
    	model = SpringHelper.getBean(TableViewModel.class);
    	ModelHelper.simpleGetAndComplexSet(model, TableView.this);
    	model.setTable(t);
    }
    
    // End of variables declaration//GEN-END:variables
    
    private void updateTableData(final List<TableColumn> list){
    	TaskHelper.runInNonEDT(new Callable<Void>() {
			@Override
			public Void call() throws Exception {
				
				Vector<Vector<Object>> v = TableHelper.transform1(list);
				Vector<Object> v2 = new Vector<Object>();
				
//				final DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
				
//					["列名称", "编辑类型"]
		    	String[][] heads = new String[][]{
		    		{"主键", 		null}, 								//0
					{"自增长", 	null}, 								//1
					{"列名称", 	null}, 								//2
					{"列别名", 	CellEditorType.String.name()}, 		//3
					{"显示顺序", 	CellEditorType.Number.name()}, 		//4
					{"排序字段", 	CellEditorType.Number.name()}, 		//5
					{"列描述", 	null}								//6	
		    	};
			    								  
		    	for (int i = 0; i < heads.length; i++) {
		    		String[] tmp = heads[i];
//		    		javax.swing.table.TableColumn h = new javax.swing.table.TableColumn(i);
//		    		h.setHeaderValue(tmp[0]);
//					dtcm.addColumn(h);
					v2.add(tmp[0]);
				}
		    	
		    	
				final DefaultTableModel dtm = new DefaultTableModel(v, v2){
					private static final long serialVersionUID = 1L;

					/**
					 * 获取列的类型;用来输入时判断是否合法输入;
					 */
					public Class<?> getColumnClass(int col){
						//显示排序或者是记录排序
						if(col == 4
								|| col == 5)return Integer.class;
						Object value = getValueAt(0, col);
				        if(value!=null)
				            return value.getClass();
				        else 
				        	return super.getClass();
					}
					
					public boolean isCellEditable(int row, int column) {
						if(column == 3
								|| column == 4
								|| column == 5)
							return true;
				        return false;
				    }
				};
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
//						table.setColumnModel(dtcm);
						table.setModel(dtm);
				    	table.updateUI();
					}
				});
				
				return null;
			}
		});
    }

	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.view.AbstractView#doMessage(me.paddingdun.gen.code.data.message.Message)
	 */
	@Override
	public void doMessage(Message message) {
		//表格树点击消息;
		if(DesignerPerspective.MESSAGE_CLICK_TABLE_TREE_NODE.equals(message.getName())){
			DBTable dbt = (DBTable)message.getObject();
			final Table t = new Table(dbt);
			
			TaskHelper.runInNonEDT(new Callable<Integer[]>() {
				public Integer[] call() throws Exception {
					
					initModel(t);
					
					List<TableColumn> list_tr = TableHelper.tableColumn(t.getCat(), t.getTableName());
					t.setColumns(list_tr);
					
					/**
					 * add by 2016年4月6日
					 * 新增显示排序;
					 */
					ModelHelper.processSeq(list_tr);
					
					/**
					 * 更新表格数据;
					 */
					updateTableData(list_tr);
					
					return new Integer[]{0};
				}
			});
		}
	}
}
