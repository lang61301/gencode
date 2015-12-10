/**
 * 
 */
package me.paddingdun.gen.code;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.paddingdun.gen.code.gui.MainFrame;
import me.paddingdun.gen.code.util.VelocityHelper;

/**
 * @author paddingdun
 *
 * 2015年12月8日
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//启动spring;
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring/spring.xml"});
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

	}

}
