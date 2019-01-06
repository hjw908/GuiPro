import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTree;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.JSplitPane;

public class WindowsGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					WindowsGui window = new WindowsGui();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowsGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 600));

		frame.getContentPane().setLayout(new GridLayout(2, 1));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("omcsƽ̨", null, panel, null);
		panel.setLayout(new GridLayout(1, 3));
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.LEFT);
		JPanel j1 = createChartPanel(createPieChart());
		JPanel j2 = createChartPanel(createBarChart());
		JPanel j3 = createChartPanel(createLineChart());
		JPanel j4 = new JPanel();

		tabbedPane2.addTab("������", j1);
		tabbedPane2.addTab("ָ�ɳ�����", j2);
		tabbedPane2.addTab("ת���", j3);
		tabbedPane2.addTab("��ֹ����", j4);
		panel.add(tabbedPane2);

		// GroupLayout gl_j1 = new GroupLayout(j1);
		// gl_j1.setHorizontalGroup(gl_j1.createParallelGroup(Alignment.LEADING).addGap(0,
		// 298, Short.MAX_VALUE));
		// gl_j1.setVerticalGroup(gl_j1.createParallelGroup(Alignment.LEADING).addGap(0,
		// 146, Short.MAX_VALUE));
		// j1.setLayout(gl_j1);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("groundƽ̨", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("��������", null, panel_2, null);
	}

	public void setTheme(){
		StandardChartTheme theme = new StandardChartTheme("CN");
		theme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
		theme.setRegularFont(new Font("����", Font.BOLD, 10));
		theme.setLargeFont(new Font("����", Font.PLAIN, 15));
		theme.setSmallFont(new Font("����", Font.BOLD, 15));
		ChartFactory.setChartTheme(theme);
	}
	
	
	public JFreeChart createLineChart(){
		setTheme();
		JFreeChart chart = ChartFactory.createLineChart("����������ͼ", "���", "��Ԫ", createLineData(),PlotOrientation.VERTICAL,true,true,false);
		return chart;
	}
	
	public DefaultCategoryDataset createLineData(){
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		//row ����Ԫ��colum�����
		data.addValue(15.45f,"��Ԫ","1990");
		data.addValue(25.45f,"��Ԫ","1991");
		data.addValue(35.45f,"��Ԫ","1992");
		data.addValue(45.45f,"��Ԫ","1993");
		data.addValue(55.45f,"��Ԫ","1994");
		data.addValue(65.45f,"��Ԫ","1995");
		
		return data;
	}
	
	
	
	public PieDataset creatPieDataset() {
		// ����һ����ͼ�����ݼ�����ʼΪ�ա�
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("��Ӫ����", new Double(20));
		pieDataset.setValue("����̶�����", new Double(20));
		pieDataset.setValue("�����ʱ����", new Double(40));
		pieDataset.setValue("׼����ʱ����", new Double(10));
		return pieDataset;
	}

	// ����ͼ
	public JFreeChart createBarChart() {
		// �Ʊ�ǰ��������ʽ �Ǿͺ��治�ñ����ͼ����������
		setTheme();
		// title��xֵ�����yֵ�����,ͼ�����ⷽ��,�Ƿ���ͼ�����ڶ����Ƿ���ʾ���������Ƿ���url
		JFreeChart chart = ChartFactory.createBarChart("˾����Դ��", "˾������", "�÷�", createBarDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public DefaultCategoryDataset createBarDataset() {
		// ����һ������ͼ�����ݼ�����ʼΪ�ա�
		final String sfDriver = "˳����Ӫ˾��";
		final String fixedDriver = "�̶�˾��";
		final String temporaryDriver = "��ʱ˾��";

		final String performance = "��Ч";
		final String assess = "�û�����";
		final String age = "����";

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(20.0d, sfDriver, performance);
		dataset.setValue(10.0d, fixedDriver, performance);
		dataset.setValue(25.0d, temporaryDriver, performance);

		dataset.setValue(30.0d, sfDriver, assess);
		dataset.setValue(20.0d, fixedDriver, assess);
		dataset.setValue(35.0d, temporaryDriver, assess);

		dataset.setValue(40.0d, sfDriver, age);
		dataset.setValue(30.0d, fixedDriver, age);
		dataset.setValue(25.0d, temporaryDriver, age);

		return dataset;
	}

	// ��ͼ
	public JFreeChart createPieChart() {
		// �Ʊ�ǰ��������ʽ �Ǿͺ��治�ñ����ͼ����������
		setTheme();

		// JFreeChart��Ҫ���������ֹ��ɣ�title(����),legend(ͼ��),plot(ͼ������)��
		// �˷���ʹ��Ĭ�����ô���һ����ͼ��������JFreeChart���͵Ķ��󡣵�һ��������ָ�Ƿ���ͼ�����ڶ����Ƿ���ʾ���������Ƿ���url
		JFreeChart chart = ChartFactory.createPieChart("������Դ��", creatPieDataset(), true, true, false);
		// ��������д���
		// TextTitle title = chart.getTitle();
		// title.setFont(new Font("����",Font.BOLD,20));
		//
		// LegendTitle legend = chart.getLegend();
		// if(legend != null){
		// legend.setItemFont(new Font("����",Font.ITALIC,10));
		// }
		//
		// PiePlot plot = (PiePlot) chart.getPlot();
		// plot.setLabelFont(new Font("����",Font.BOLD,10));
		// plot.setNoDataMessage("no data available");
		// plot.setCircular(true);
		return chart;
	}

	public JPanel createChartPanel(JFreeChart chart) {
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}

}
