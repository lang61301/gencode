/**
 * 
 */
package me.paddingdun.gen.code;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.paddingdun.gen.code.gui.MainFrame;
import me.paddingdun.gen.code.util.BufferHelper;
import me.paddingdun.gen.code.util.ConfigHelper;
import me.paddingdun.gen.code.util.DirectoryHelper;
import me.paddingdun.gen.code.util.gui.TipHelper;

/**
 * 
 * @author paddingdun
 *
 * 2016年4月29日
 * @since 1.0
 * @version 2.0
 */
public class Main {
	
	private static void init(){
		BufferHelper.readConfigXmlBuffer(DirectoryHelper.getUserDir(), ConfigHelper.cfgDir());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//启动spring;
		final ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring/spring.xml"});
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
			@Override
			public void run(){
				try{
					ac.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		init();
		
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
                
                TipHelper.configDismissTime();
            }
        });

	}

}
