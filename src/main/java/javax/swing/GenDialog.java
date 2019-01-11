/**
 * 
 */
package javax.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.accessibility.Accessible;

import org.apache.commons.beanutils.BeanUtils;

import me.paddingdun.gen.code.gui.model.GenDialogModel;

/***
 * 定义的Dialog对话框
 * 
 * @author WXW
 *
 */
public class GenDialog extends JComponent implements Accessible, ActionListener {
	private static final long serialVersionUID = 1L;

	private GenDialogModel model = null;
	private JDialog dialog = null;

	public static void main(String[] args) {
		GenDialog d = new GenDialog("你好",  360, 320);
		d.showDialog(null);
	}

	JButton okBtn = new JButton("确定");
	JButton cancelBtn = new JButton("关闭");

	int x = 50;
	int y = 30;
	int width = 65;
	int height = 20;
	
	int windowWidth;
	int windowHeight;
	String title;

	/***
	 * 自定义 Dialog
	 * 
	 * @param parent       父Frame
	 * @param modal        是否模式窗体
	 * @param caipinMap    数据Map
	 * @param windowWidth  宽度 需根据数据计算高度
	 * @param windowHeight 高度 默认320即可
	 */
	public GenDialog(String title,int windowWidth, int windowHeight) {
		this.windowWidth =windowWidth;
		this.windowHeight = windowHeight;
		this.title = title;
	}
	
	protected JDialog createDialog(Component parent) throws HeadlessException {
        JDialog dialog;
        Window window = JOptionPane.getFrameForComponent(null);
        if (window instanceof Frame) {
            dialog = new JDialog((Frame)window, title, true);
        } else {
            dialog = new JDialog((Dialog)window, title, true);
        }
        dialog.setComponentOrientation(this.getComponentOrientation());

        Container contentPane = dialog.getContentPane();
        contentPane.setLayout(null);
//        contentPane.add(this, BorderLayout.CENTER);

        if (JDialog.isDefaultLookAndFeelDecorated()) {
            boolean supportsWindowDecorations =
            UIManager.getLookAndFeel().getSupportsWindowDecorations();
            if (supportsWindowDecorations) {
//                dialog.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
            }
        }
        dialog.pack();
//        dialog.setLocationRelativeTo(parent);

        return dialog;
    }
	
	
	
	private void drawOne(String title, String propertyName, int x, int y) {
		JLabel jlabel = new JLabel(title);
		dialog.getContentPane().add(jlabel);
		jlabel.setBounds(x, y, width, height);
		JCheckBox cb = new JCheckBox();
		dialog.getContentPane().add(cb);
		cb.setBounds(x + 120, y, width, height);
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox c = (JCheckBox) e.getSource();
				try {
					BeanUtils.setProperty(model, propertyName, c.isSelected());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		jlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cb.setSelected(!cb.isSelected());
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okBtn) {
		}else if (e.getSource() == cancelBtn) {
			model = null;
		}
		if(dialog != null)
			dialog.hide();
	}
	
	public GenDialogModel showDialog(Component parent) {
		model = new GenDialogModel();
		
		if (dialog != null) {
            // Prevent to show second instance of dialog if the previous one still exists
            return null;
        }

        dialog = createDialog(parent);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	model = null;
            }
        });
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		drawOne("xml", "xml", x, y);
		y+=30;
		drawOne("baseData", "baseData", x, y);
		y+=30;
		drawOne("data", "data", x, y);
		y+=30;
		drawOne("dao", "dao", x, y);
		y+=30;
		drawOne("service", "service", x, y);
		y+=30;
		drawOne("action", "action", x, y);
		y+=30;
		drawOne("jsp", "jsp", x, y);

		dialog.getContentPane().add(okBtn);
		dialog.getContentPane().add(cancelBtn);
		y+=40;
		okBtn.setBounds(x, y, 60, 25);
		okBtn.setName("ok");
		cancelBtn.setBounds(x+80, y, 60, 25);
		cancelBtn.setName("cancel");
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		dialog.setSize(windowWidth, windowHeight);
		dialog.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);
        dialog.show();
		dialog.getContentPane().removeAll();
        dialog.dispose();
        dialog = null;
        x = 50;
    	y = 30;
        GenDialogModel result = model;
        model = null;
        return result;
    }
}
