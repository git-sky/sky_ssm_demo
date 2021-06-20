package cn.com.sky.chart.line;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * ������ʾ��״ͼ
 * 
 * @author leejon
 * 
 */
public class LineChart {
	/**
	 * �������ݼ�
	 * 
	 * @return
	 */
	public static DefaultCategoryDataset getDataset() {
		DefaultCategoryDataset cateDataset = new DefaultCategoryDataset();
		String str = "�����༶ƽ���ɼ�";
		String s1 = "��һ��";
		String s2 = "�ڶ���";
		String s3 = "������";
		String s4 = "���Ĵ�";
		String s5 = "�����";
		String s6 = "������";
		String s7 = "���ߴ�";
		cateDataset.addValue(70, str, s1);
		cateDataset.addValue(78, str, s2);
		cateDataset.addValue(80, str, s3);
		cateDataset.addValue(66, str, s4);
		cateDataset.addValue(75, str, s5);
		cateDataset.addValue(89, str, s6);
		cateDataset.addValue(61, str, s7);
		return cateDataset;
	}

	/**
	 * �������ݼ�����ͼ�����
	 * 
	 * @param categoryDataset
	 * @return
	 */
	public static JFreeChart createChart(DefaultCategoryDataset categoryDataset) {
		JFreeChart chart = ChartFactory.createLineChart("�����༶ƽ���ɼ���״����ͼ", "����",
				"�ɼ�(��)", categoryDataset, PlotOrientation.VERTICAL, true, true,
				false);
		chart.setBackgroundPaint(Color.WHITE);
		return chart;
	}

	/**
	 * ������״ͼ
	 * 
	 * @param session
	 * @param out
	 * @return
	 */
	public static String getLineChartImgURL(HttpSession session, PrintWriter out) {
		String fileName = "";
		DefaultCategoryDataset categoryDataset = getDataset();
		JFreeChart chart = createChart(categoryDataset);
		chart.setBackgroundPaint(Color.WHITE);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {
			fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, info, session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(out, fileName, info, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		return fileName;
	}
}
