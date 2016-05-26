/**
 * 
 */
package me.paddingdun.gen.code.gui.view.dbtable;

import java.awt.EventQueue;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.Callable;

import javax.swing.JLabel;

import org.apache.commons.lang.StringUtils;

import layout.TableLayout;
import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.data.table.IDBColumn;
import me.paddingdun.gen.code.data.tabletree.DBTable;
import me.paddingdun.gen.code.db.TableHelper2;
import me.paddingdun.gen.code.gui.component.TargetSqlTextArea;
import me.paddingdun.gen.code.gui.model.EditViewModel;
import me.paddingdun.gen.code.gui.perspective.designer.DesignerPerspective;
import me.paddingdun.gen.code.gui.view.AbstractView;
import me.paddingdun.gen.code.util.gui.TaskHelper;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
@SuppressWarnings("serial")
public class EditView extends AbstractView {
	
	private DesignerPerspective perspective;
	
	private EditViewModel model;

    /**
     * Creates new form EditView
     */
    public EditView(DesignerPerspective perspective) {
    	super();
    	this.perspective = perspective;
    	initModel();
        initComponents();
    }
    
    private void initModel(){
    	model = new EditViewModel();
    }
    
    /**
     * 查询sql中的生成按钮;
     * @param evt
     */
    private void qBtnOkActionPerformed(java.awt.event.ActionEvent evt){
    	String querySql = queryArea.getText();
    	List<IDBColumn> dbcolumns = TableHelper2.parseQuerySql(queryArea.getCatlog(), querySql);
    	
    	model.setQuerySql(querySql);
    	model.setQuerySqlDBColumnList(dbcolumns);
    	
    	Message m = new Message(DesignerPerspective.MESSAGE_CLICK_QUERY_SQL_BUTTON);
		m.setSource(EditView.this);
		m.setObject(model);
		perspective.sendMessage(m);
    }
    
    private void qBtnClearActionPerformed(java.awt.event.ActionEvent evt){
    	queryArea.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("编辑内容");

        rootSp = new javax.swing.JScrollPane();
        rootP = new javax.swing.JPanel();
        rootSp.setViewportView(rootP);
        qBtnOk = new javax.swing.JButton("生成");
        qBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	qBtnOkActionPerformed(evt);
            }
        });
        qBtnClear = new javax.swing.JButton("清空");
        qBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	qBtnClearActionPerformed(evt);
            }
        });
        
        queryArea = new TargetSqlTextArea();
        queryArea.addAfterDragDropListener(new TargetSqlTextArea.AfterD2DAction() {
			
			@Override
			public void process(DBTable dbTable) {
				String t = tableId.getText();
				if(StringUtils.isBlank(t)){
					tableId.setText(dbTable.getTableName());
				}else{
					tableId.setText(t.trim() + "_" + dbTable.getTableName());
				}
			}
		});
        javax.swing.JScrollPane spqa = new javax.swing.JScrollPane(queryArea);
        
        tableId = new javax.swing.JTextField();
        
        insertArea = new TargetSqlTextArea();
        javax.swing.JScrollPane spia = new javax.swing.JScrollPane(insertArea);
        
        updateArea = new TargetSqlTextArea();
        javax.swing.JScrollPane spua = new javax.swing.JScrollPane(updateArea);
        
        getArea	   = new TargetSqlTextArea();
        javax.swing.JScrollPane spga = new javax.swing.JScrollPane(getArea);
        
        deleteArea = new TargetSqlTextArea();
        javax.swing.JScrollPane spda = new javax.swing.JScrollPane(deleteArea);
        
        TableLayout tableLayout_rootSp = new TableLayout();
        double border = 2;			      		
        					//0       1    2     3    4    5   6   7   8   9   
        double[] col_size = {border, 50,  50,   50, 50,  -1,  50, 50, 50, 50, border};
        tableLayout_rootSp.setColumn(col_size);
        double h0 = 26;
        double h1 = 120;
        tableLayout_rootSp.setRow(new double[]{border, h0, h1, h0, h0, h1, border});
        rootP.setLayout(tableLayout_rootSp);
        
        int lastColumn = col_size.length - 2;
        int row = 1;
        rootP.add(new JLabel("查询sql"), MessageFormat.format("1,{0},2,{0}", row));
        row++;
        rootP.add(spqa, MessageFormat.format("1,{0}," +lastColumn+ ",{0}", row));
        row++;
        rootP.add(new JLabel("实体名称"), MessageFormat.format("1,{0},2,{0}", row));
        rootP.add(tableId, MessageFormat.format("3,{0},5,{0}", row));
        rootP.add(qBtnOk, MessageFormat.format("6,{0},7,{0}", row));
        rootP.add(qBtnClear, MessageFormat.format("8,{0}," +lastColumn+ ",{0}", row));
        
//        row++;
//        rootP.add(new JLabel("新增sql"), MessageFormat.format("1,{0},2,{0}", row));
//        row++;
//        rootP.add(spia, MessageFormat.format("1,{0}," +lastColumn+ ",{0}", row));
//        
//        row++;
//        rootP.add(new JLabel("更新sql"), MessageFormat.format("1,{0},2,{0}", row));
//        row++;
//        rootP.add(spua, MessageFormat.format("1,{0}," +lastColumn+ ",{0}", row));
//        
//        row++;
//        rootP.add(new JLabel("获取sql"), MessageFormat.format("1,{0},2,{0}", row));
//        row++;
//        rootP.add(spga, MessageFormat.format("1,{0}," +lastColumn+ ",{0}", row));
        
        row++;
        rootP.add(new JLabel("删除sql"), MessageFormat.format("1,{0},2,{0}", row));
        row++;
        rootP.add(spda, MessageFormat.format("1,{0}," +lastColumn+ ",{0}", row));

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                afterShow(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootSp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void afterShow(java.awt.event.ComponentEvent evt) {                           
        // TODO add your handling code here:
    }                          


    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane rootSp;
    private javax.swing.JPanel rootP;
    private TargetSqlTextArea queryArea;
    private javax.swing.JButton qBtnOk;
    private javax.swing.JButton qBtnClear;
    private javax.swing.JTextField tableId;
    private TargetSqlTextArea insertArea;
    private TargetSqlTextArea updateArea;
    private TargetSqlTextArea deleteArea;
    private TargetSqlTextArea getArea;
    
    // End of variables declaration                   


	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.view.AbstractView#doMessage(me.paddingdun.gen.code.data.message.Message)
	 */
	@Override
	public void doMessage(Message message) {
		//表格树点击消息;
				if(DesignerPerspective.MESSAGE_CLICK_TABLE_TREE_NODE.equals(message.getName())){
					if(message.getObject() != null
							&& message.getObject().getClass() == DBTable.class){
						final DBTable dbt = (DBTable)message.getObject();
						
						TaskHelper.runInNonEDT(new Callable<Void>() {
							public Void call() throws Exception {
								model.setQuerySql(TableHelper2.tableName2QuerySql(dbt, "t1"));
								model.setDeleteSql(TableHelper2.tableName2DeleteSql(dbt));
								
								EventQueue.invokeLater(new Runnable() {
									@Override
									public void run() {
										queryArea.setText(model.getQuerySql());
										queryArea.setCatlog(dbt.getCat());
										
										deleteArea.setText(model.getDeleteSql());
										deleteArea.setCatlog(dbt.getCat());
									}
								});
								
								return null;
							}
						});
					}
				/**
				 * add by 2016年4月18日
				 * 点击查询按钮sql事件接收;
				 */
				}
	}
}
