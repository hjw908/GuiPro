import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PreferencesDemo extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				PreferencesDemo demo = new PreferencesDemo();
				demo.setTitle("myDemo");
				demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				demo.setSize(new Dimension(500,300));
				demo.setVisible(true);
			}
		});
	}
	
	public PreferencesDemo(){
		JPanel panel = new JPanel();
		setLayout(new BorderLayout());
		JLabel label = new JLabel();
		label.setText("当前坐标位置是：" );
		panel.add(label);
		add(panel,BorderLayout.CENTER);
	}

}
