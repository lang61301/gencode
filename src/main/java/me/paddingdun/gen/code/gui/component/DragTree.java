/**
 * 
 */
package me.paddingdun.gen.code.gui.component;

import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;

import me.paddingdun.gen.code.data.tabletree.DBTable;

/**
 * 可拖拽树;
 * @author paddingdun
 *
 * 2016年4月7日
 */
@SuppressWarnings("serial")
public class DragTree extends JTree{
	
	public DragTree(){
		super();
		this.setDragEnabled(false);
		
		/**
		 *	自定义导出数据; 
		 */
		this.setTransferHandler(new TransferHandler(){
			@Override
			public int getSourceActions(JComponent c) {
			    return COPY_OR_MOVE;
			}
			
			@Override
			protected Transferable createTransferable(JComponent c) {
				Object[] objs = DragTree.this.getSelectionModel().getSelectionPath().getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)objs[objs.length - 1];
				if(node.isLeaf()){
					Object uo = node.getUserObject();
					if( uo instanceof DBTable){
						DBTable tmp = (DBTable)uo;
						return new TranDBTable(tmp);
					}
				}
			    return super.createTransferable(c);
			}
			
			@Override
			protected void exportDone(JComponent c, Transferable t, int action) {
			}


		});
		
	}
}
