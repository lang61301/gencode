/**
 * 
 */
package me.paddingdun.gen.code.gui.view.dbtable;

import java.text.MessageFormat;

import javax.swing.JLabel;

import layout.TableLayout;
import me.paddingdun.gen.code.data.message.Message;
import me.paddingdun.gen.code.gui.component.TargetTextArea;
import me.paddingdun.gen.code.gui.perspective.designer.DesignerPerspective;
import me.paddingdun.gen.code.gui.view.AbstractView;

/**
 * @author paddingdun
 *
 * 2016年4月7日
 */
@SuppressWarnings("serial")
public class EditView extends AbstractView {
	
	@SuppressWarnings("unused")
	private DesignerPerspective perspective;

    /**
     * Creates new form EditView
     */
    public EditView(DesignerPerspective perspective) {
    	super();
    	this.perspective = perspective;
        initComponents();
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
        queryArea = new TargetTextArea();
        javax.swing.JScrollPane spqa = new javax.swing.JScrollPane(queryArea); 
        
        TableLayout tableLayout_rootSp = new TableLayout();
        double border = 2;			      		//0      1    2     3    4     5     6
        tableLayout_rootSp.setColumn(new double[]{border, 50,  50,   50,  -1,  50,   50, border});
        tableLayout_rootSp.setRow(new double[]{border, 30, 150, 30, 30, 30, 30, 30, 30, 30, 30, border});
        rootP.setLayout(tableLayout_rootSp);
        
        int row = 1;
        rootP.add(new JLabel("我"), MessageFormat.format("1,{0},2,{0}", row));
        
        row++;
        rootP.add(spqa, MessageFormat.format("1,{0},6,{0}", row));

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
    private TargetTextArea queryArea;
    // End of variables declaration                   


	/* (non-Javadoc)
	 * @see me.paddingdun.gen.code.gui.view.AbstractView#doMessage(me.paddingdun.gen.code.data.message.Message)
	 */
	@Override
	public void doMessage(Message message) {
		
	}
}
