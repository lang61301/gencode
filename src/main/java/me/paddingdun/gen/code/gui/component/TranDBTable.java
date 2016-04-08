/**
 * 
 */
package me.paddingdun.gen.code.gui.component;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import me.paddingdun.gen.code.data.tabletree.DBTable;

/**
 * @author paddingdun
 *
 * 2016年4月8日
 */
public class TranDBTable implements Transferable {
	
	public static final DataFlavor dbtable = new DataFlavor(DBTable.class, null);
	
	private DBTable dbTable;
	
	public TranDBTable(DBTable dbTable){
		this.dbTable = dbTable;
	}

	/* (non-Javadoc)
	 * @see java.awt.datatransfer.Transferable#getTransferDataFlavors()
	 */
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return new DataFlavor[]{dbtable};
	}

	/* (non-Javadoc)
	 * @see java.awt.datatransfer.Transferable#isDataFlavorSupported(java.awt.datatransfer.DataFlavor)
	 */
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return dbtable.equals(flavor);
	}

	/* (non-Javadoc)
	 * @see java.awt.datatransfer.Transferable#getTransferData(java.awt.datatransfer.DataFlavor)
	 */
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(dbtable.equals(flavor)){
			return dbTable;
		}
		return null;
	}

}
