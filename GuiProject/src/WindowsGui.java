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
		tabbedPane.addTab("omcs平台", null, panel, null);
		panel.setLayout(new GridLayout(1, 3));
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.LEFT);
		JPanel j1 = createChartPanel(createPieChart());
		JPanel j2 = createChartPanel(createBarChart());
		JPanel j3 = createChartPanel(createLineChart());
		JPanel j4 = new JPanel();

		tabbedPane2.addTab("任务监控", j1);
		tabbedPane2.addTab("指派承运商", j2);
		tabbedPane2.addTab("转外包", j3);
		tabbedPane2.addTab("中止任务", j4);
		panel.add(tabbedPane2);

		// GroupLayout gl_j1 = new GroupLayout(j1);
		// gl_j1.setHorizontalGroup(gl_j1.createParallelGroup(Alignment.LEADING).addGap(0,
		// 298, Short.MAX_VALUE));
		// gl_j1.setVerticalGroup(gl_j1.createParallelGroup(Alignment.LEADING).addGap(0,
		// 146, Short.MAX_VALUE));
		// j1.setLayout(gl_j1);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("ground平台", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("生成任务", null, panel_2, null);
	}

	public void setTheme(){
		StandardChartTheme theme = new StandardChartTheme("CN");
		theme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		theme.setRegularFont(new Font("隶书", Font.BOLD, 10));
		theme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		theme.setSmallFont(new Font("宋体", Font.BOLD, 15));
		ChartFactory.setChartTheme(theme);
	}
	
	
	public JFreeChart createLineChart(){
		setTheme();
		JFreeChart chart = ChartFactory.createLineChart("年收入折线图", "年份", "万元", createLineData(),PlotOrientation.VERTICAL,true,true,false);
		return chart;
	}
	
	public DefaultCategoryDataset createLineData(){
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		//row 是万元，colum是年份
		data.addValue(15.45f,"万元","1990");
		data.addValue(25.45f,"万元","1991");
		data.addValue(35.45f,"万元","1992");
		data.addValue(45.45f,"万元","1993");
		data.addValue(55.45f,"万元","1994");
		data.addValue(65.45f,"万元","1995");
		
		return data;
	}
	
	
	
	public PieDataset creatPieDataset() {
		// 创建一个饼图的数据集，初始为空。
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("自营车辆", new Double(20));
		pieDataset.setValue("外包固定车辆", new Double(20));
		pieDataset.setValue("外包临时车辆", new Double(40));
		pieDataset.setValue("准入临时车辆", new Double(10));
		return pieDataset;
	}

	// 条形图
	public JFreeChart createBarChart() {
		// 制表前先设置样式 那就后面不用标题和图例单独设置
		setTheme();
		// title、x值的类别，y值的类别,图标主题方向,是否用图例，第二个是否提示，第三个是否用url
		JFreeChart chart = ChartFactory.createBarChart("司机资源表", "司机类型", "得分", createBarDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		return chart;

	}

	public DefaultCategoryDataset createBarDataset() {
		// 创建一个条形图的数据集，初始为空。
		final String sfDriver = "顺丰自营司机";
		final String fixedDriver = "固定司机";
		final String temporaryDriver = "临时司机";

		final String performance = "绩效";
		final String assess = "用户评价";
		final String age = "年龄";

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

	// 饼图
	public JFreeChart createPieChart() {
		// 制表前先设置样式 那就后面不用标题和图例单独设置
		setTheme();

		// JFreeChart主要由三个部分构成：title(标题),legend(图释),plot(图表主体)。
		// 此方法使用默认设置创建一个饼图。它返回JFreeChart类型的对象。第一个布尔是指是否用图例，第二个是否提示，第三个是否用url
		JFreeChart chart = ChartFactory.createPieChart("车辆资源表", creatPieDataset(), true, true, false);
		// 对乱码进行处理
		// TextTitle title = chart.getTitle();
		// title.setFont(new Font("宋体",Font.BOLD,20));
		//
		// LegendTitle legend = chart.getLegend();
		// if(legend != null){
		// legend.setItemFont(new Font("宋体",Font.ITALIC,10));
		// }
		//
		// PiePlot plot = (PiePlot) chart.getPlot();
		// plot.setLabelFont(new Font("宋体",Font.BOLD,10));
		// plot.setNoDataMessage("no data available");
		// plot.setCircular(true);
		return chart;
	}

	public JPanel createChartPanel(JFreeChart chart) {
		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}

}
