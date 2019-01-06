import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiDemo extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GuiDemo demo = new GuiDemo();
				demo.setTitle("mydemo");
				demo.setSize(new Dimension(370,150));
				demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				demo.setVisible(true);
//				demo.setLocationRelativeTo(null);
			}
		});
	}
	
	public GuiDemo(){
		setLayout(new GridLayout(3, 1));
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		
		Label label = new Label();
		Label label2 = new Label();
		label.setText("左边距:");
		label2.setText("右边距:");
		
		//单行文本框用JTextFiled 多行是JTextArea
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		field1.setPreferredSize(new Dimension(200,20)); 
		field2.setPreferredSize(new Dimension(200,20));
		
		//使用对键盘的点击事件进行响应，进而对所敲击的键值进行判断，如果是所需要的值则输入，不是就屏蔽掉
		field1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar>= KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9){
					
				}else{
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		field2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
				}else{
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton but1 = new JButton("确定");
		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String x_obj = field1.getText();
				String y_obj = field2.getText();
				if(x_obj == null || y_obj == null){
					return;
				} else{
					//把String 转换成 int
					int x = Integer.parseInt(x_obj);
					int y = Integer.parseInt(y_obj);
					GuiDemo.this.setLocation(x,y);
				}
			}
		});
		
		JButton but2 = new JButton("中心位置");
		but2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
				//屏幕中心的坐标，窗体的左上角会坐落在屏幕中心。
				Point point = env.getCenterPoint();
				int x = (int) point.getX();
				int y = (int) point.getY();
				field1.setText(String.valueOf(x));
				field2.setText(String.valueOf(y));
			}
		});
		
		panel1.add(label);
		panel1.add(field1);
		panel2.add(label2);
		panel2.add(field2);
		panel3.add(but2);
		panel3.add(but1);
		
		add(panel1);
		add(panel2);
		add(panel3);
	}
	
	

}
