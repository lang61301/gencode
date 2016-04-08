/**
 * 
 */
package me.paddingdun.gen.code.gui.component;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;
import javax.swing.text.JTextComponent;

import me.paddingdun.gen.code.data.tabletree.DBTable;

/**
 * 可以接收拖拽的textarea;
 * @author paddingdun
 *
 * 2016年4月7日
 */
@SuppressWarnings("serial")
public class TargetTextArea extends JTextArea{
	
	public TargetTextArea() {
		super(1, 10);
		
		this.setTransferHandler(new TransferHandler(){

			@Override
			public boolean importData(TransferSupport support) {
				Transferable ts = support.getTransferable();
				if(ts.isDataFlavorSupported(TranDBTable.dbtable)){
					JTextComponent.DropLocation loc = (JTextComponent.DropLocation)support.getDropLocation();
					try {
						DBTable tmp =  (DBTable)ts.getTransferData(TranDBTable.dbtable);
						TargetTextArea.this.insert(tmp.getTableName(), loc.getIndex());
					} catch (UnsupportedFlavorException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return true;
				}else if(ts.isDataFlavorSupported(DataFlavor.stringFlavor)){
					try {
						String str = (String)ts.getTransferData(DataFlavor.stringFlavor);
						TargetTextArea.this.insert(str, TargetTextArea.this.getSelectionStart());
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
			    return new StringSelection(TargetTextArea.this.getSelectedText());
			}
			
			@Override
			protected void exportDone(JComponent c, Transferable t, int action) {
				if(action == MOVE){
					TargetTextArea.this.replaceSelection("");
				}
			}
		});
		
	}
}
