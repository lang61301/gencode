/**
 * 
 */
package me.paddingdun.gen.code.gui.component;

import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;
import javax.swing.text.JTextComponent;

import org.apache.commons.lang.StringUtils;

import me.paddingdun.gen.code.data.edit.TargetSqlType;
import me.paddingdun.gen.code.data.tabletree.DBTable;
import me.paddingdun.gen.code.db.TableHelper2;
import me.paddingdun.gen.code.util.gui.TaskHelper;

/**
 * 可以接收拖拽数据的textarea;
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 2.0
 * @version 2.0
 */
@SuppressWarnings("serial")
public class TargetSqlTextArea extends JTextArea{
	
	private List<AfterD2DAction> actions = new ArrayList<AfterD2DAction>();
	
	private TargetSqlType type;
	
	public TargetSqlTextArea(){
		this(TargetSqlType.query);
	}

	public TargetSqlTextArea(TargetSqlType type) {
		super(1, 10);
		
		this.type = type;
		
		//激活自动换行功能;
		this.setLineWrap(true);         
		// 激活断行不断字功能;
		this.setWrapStyleWord(true);            
		
		this.setTransferHandler(new TransferHandler(){

			@Override
			public boolean importData(TransferSupport support) {
				Transferable ts = support.getTransferable();
				
				if(ts.isDataFlavorSupported(TranDBTable.dbtable)){
					/**
					 * 输入表别名;
					 */
					String tas = JOptionPane.showInputDialog("请输入表别名(如:t1)", "t1");
					if(StringUtils.isBlank(tas)){
						tas = "t1";
					}else{
						tas = tas.trim();
					}
					final String _tas = tas;
					
					final JTextComponent.DropLocation loc = (JTextComponent.DropLocation)support.getDropLocation();
					try {
						final DBTable tmp =  (DBTable)ts.getTransferData(TranDBTable.dbtable);
						
						TaskHelper.runInNonEDT(new Callable<Void>() {
							@Override
							public Void call() throws Exception {
								
								final String result = TableHelper2.tableName2QuerySql(tmp, _tas);
								EventQueue.invokeLater(new Runnable() {
									@Override
									public void run() {
										TargetSqlTextArea.this.insert(result, loc.getIndex());
										
										for (AfterD2DAction a : actions) {
											a.process(tmp);
										}
									}
								});
								return null;
							}
						});
					} catch (UnsupportedFlavorException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				}else if(ts.isDataFlavorSupported(DataFlavor.stringFlavor)){
					try {
						String str = (String)ts.getTransferData(DataFlavor.stringFlavor);
						TargetSqlTextArea.this.insert(str, TargetSqlTextArea.this.getSelectionStart());
					} catch (UnsupportedFlavorException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				}else{
					return false;
				}
			}

			@Override
			public boolean canImport(TransferSupport support) {
				boolean result = support.isDataFlavorSupported(TranDBTable.dbtable)
						|| super.canImport(support);
				return  result;
			}
			
			
			@Override
			public int getSourceActions(JComponent c) {
			    return COPY_OR_MOVE;
			}
			
			@Override
			protected Transferable createTransferable(JComponent c) {
			    return new StringSelection(TargetSqlTextArea.this.getSelectedText());
			}
			
			@Override
			protected void exportDone(JComponent c, Transferable t, int action) {
				if(action == MOVE){
					TargetSqlTextArea.this.replaceSelection("");
				}
			}
		});
		
	}
	
	/**
	 * 拖拽完成后后续处理;
	 */
	public void addAfterDragDropListener(AfterD2DAction action){
		if(action != null)
			actions.add(action);
	}
	
	public void removeAfterDragDropListener(AfterD2DAction action){
		if(action != null)
			actions.remove(action);
	}
	
	public static interface AfterD2DAction{
		public void process(DBTable dbTable);
	}

	public TargetSqlType getType() {
		return type;
	}

	public void setType(TargetSqlType type) {
		this.type = type;
	}
	
}
