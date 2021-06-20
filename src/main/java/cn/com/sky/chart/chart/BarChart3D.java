package cn.com.sky.chart.chart;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * ������ʾJFreeChart����3Dͼ��
 * 
 * @author leejon
 * 
 */
public class BarChart3D {
	/**
	 * ��ȡ���ݼ�
	 * 
	 * @return
	 */
	public static CategoryDataset getDataset() {
		String str = "ѧ������ͳ��";
		// �������������ʵ����
		String s1 = "����";
		String s2 = "�Ϻ�";
		String s3 = "����";
		String s4 = "�㽭";
		String s5 = "����";

		DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
		categoryDataset.addValue(200, str, s1);
		categoryDataset.addValue(300, str, s2);
		categoryDataset.addValue(600, str, s3);
		categoryDataset.addValue(560, str, s4);
		categoryDataset.addValue(670, str, s5);

		return categoryDataset;
	}

	/**
	 * ����JFreeChart����
	 * 
	 * @param categoryDataset
	 * @return
	 */
	public static JFreeChart createJFreeChart(CategoryDataset categoryDataset) {
		JFreeChart jFreeChart = ChartFactory.createBarChart3D("ѧ����Դͳ����״����ͼ",
				"ʡ��", "ѧ������", categoryDataset, PlotOrientation.VERTICAL, true,
				true, false);
		jFreeChart.setBackgroundPaint(Color.WHITE);
		CategoryPlot categoryPlot = jFreeChart.getCategoryPlot();
		categoryPlot.setBackgroundPaint(Color.WHITE);
		categoryPlot.setDomainGridlinePaint(Color.WHITE);
		categoryPlot.setDomainGridlinesVisible(true);
		categoryPlot.setRangeGridlinePaint(Color.BLUE);
		return jFreeChart;
	}

	/**
	 * ����3D��״ͼ��ͼƬ
	 */
	public static String getImgURL(HttpSession session, PrintWriter out) {
		String fileName = "";
		CategoryDataset categoryDataset = getDataset();
		JFreeChart chart = createJFreeChart(categoryDataset);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {
			fileName = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
					session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(out, fileName, info, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
