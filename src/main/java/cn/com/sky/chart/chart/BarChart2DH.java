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
 * ������ʾ���ݹ̶������ݼ���JFreeChart������2Dͼ��(������ʾ����)
 * @author leejon
 *
 */
public class BarChart2DH {
	/**
	 * ��ȡҪ���Ƶ�ͼ��������Ϣ
	 * @return
	 */
	public static CategoryDataset getDataSet() {
		String str = "ѧ������";
		// ����������Ҫ��ʾ������
		String s1 = "����";
		String s2 = "����";
		String s3 = "�㶫";
		String s4 = "�Ϻ�";
		String s5 = "����";

		// ��������ͼƬ����Ҫ�ļ���
		DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
		defaultCategoryDataset.addValue(300, str, s1);
		defaultCategoryDataset.addValue(300, str, s2);
		defaultCategoryDataset.addValue(400, str, s3);
		defaultCategoryDataset.addValue(190, str, s4);
		defaultCategoryDataset.addValue(230, str, s5);
		return defaultCategoryDataset;
	}

	/**
	 * ������������ͼ��������Ϣ
	 * @param categoryDataset
	 * @return
	 */
	public static JFreeChart createJFreeChart(CategoryDataset categoryDataset) {
		/**
		 * ����ͼ��������Ϣ,���������Ϊ��
		 * ͼ�����,��������ʾ��ʾ,��������ʾ��ʾ,Ҫ��ʾ������
		 * ����Ҫ��ʾͼ����״�ĺ��������.HORIZONTAL��ʾ����,VERTICAL��ʾ����
		 */
		JFreeChart chart = ChartFactory.createBarChart("ѧ������ͳ��", "ʡ��", "����",
				categoryDataset, PlotOrientation.HORIZONTAL, true, true, false);
		// ���ñ�����ɫ
		chart.setBackgroundPaint(Color.WHITE);
		CategoryPlot cateforyPlot = chart.getCategoryPlot();
		cateforyPlot.setBackgroundPaint(Color.WHITE);
		cateforyPlot.setDomainGridlinePaint(Color.WHITE);
		// �����Ƿ�ɼ�
		cateforyPlot.setDomainGridlinesVisible(true);
		// ������״����ɫ
		cateforyPlot.setRangeGridlinePaint(Color.BLUE);
		return chart;
	}

	/**
	 * ���ɶ�ά����״ͼ
	 * @param session �ͻ��˵�ǰsession
	 * @param out �����
	 * @return ����������ͼƬ��URL
	 */
	public static String getBarChartURL(HttpSession session, PrintWriter out) {
		String fileName = "";
		CategoryDataset categoryDataset = getDataSet();
		JFreeChart chart = createJFreeChart(categoryDataset);
		ChartRenderingInfo chartInfo = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {
			fileName = ServletUtilities.saveChartAsPNG(chart, 500, 300,
					chartInfo, session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(out, fileName, chartInfo, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		return fileName;
	}
}
