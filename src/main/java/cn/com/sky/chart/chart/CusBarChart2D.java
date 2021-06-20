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
public class CusBarChart2D {
	/**
	 * ��ȡҪ���Ƶ�ͼ��������Ϣ
	 * @return
	 */
	public static CategoryDataset getDataSet() {
		String str = "��������";
		String str2 = "Ů������";
		// ����������Ҫ��ʾ������
		String s1 = "����";
		String s2 = "����";
		String s3 = "�㶫";
		String s4 = "�Ϻ�";
		String s5 = "����";

		// ��������ͼƬ����Ҫ�ļ���
		DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
		//������������
		defaultCategoryDataset.addValue(300, str, s1);
		defaultCategoryDataset.addValue(300, str, s2);
		defaultCategoryDataset.addValue(450, str, s3);
		defaultCategoryDataset.addValue(190, str, s4);
		defaultCategoryDataset.addValue(230, str, s5);
		//����Ů������
		defaultCategoryDataset.addValue(200, str2, s1);
		defaultCategoryDataset.addValue(340, str2, s2);
		defaultCategoryDataset.addValue(300, str2, s3);
		defaultCategoryDataset.addValue(290, str2, s4);
		defaultCategoryDataset.addValue(200, str2, s5);
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
		 * ��������boolean�͵Ĳ�����
		 * ��һ����ʾ�Ƿ���ʾ��״ͼ��,trueΪ��ʾ,falseΪ����ʾ
		 */
		JFreeChart chart = ChartFactory.createBarChart("����Ů����������", "ʡ��", "����",
				categoryDataset, PlotOrientation.VERTICAL, true, true, false);
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
		//���þ�̬�ķ�����ȡ���ݼ�
		CategoryDataset categoryDataset = getDataSet();
		//�������о�̬��������ͼ�����
		JFreeChart chart = createJFreeChart(categoryDataset);
		ChartRenderingInfo chartInfo = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {
			//�����ɵ�ͼƬ��PNG�ļ���ʽ��ʾ
			fileName = ServletUtilities.saveChartAsPNG(chart, 500, 300,
					chartInfo, session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			//��ͻ�����ʾͼƬ
			ChartUtilities.writeImageMap(out, fileName, chartInfo, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		return fileName;
	}
}
