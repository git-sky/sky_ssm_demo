package cn.com.sky.chart.pie;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * ������ʾ��״ͼ
 * @author leejon
 * 
 */
public class PieChart {
	/**
	 * �������ݼ���
	 * 
	 * @return
	 */
	public static PieDataset getPieDataset() {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("�޻�", 1.9);
		pieDataset.setValue("С��", 1.2);
		pieDataset.setValue("ˮ��", 3.9);
		pieDataset.setValue("��", 2.4);
		pieDataset.setValue("����", 3.4);
		pieDataset.setValue("����", 5.4);
		return pieDataset;
	}

	/**
	 * �������ݼ��ϴ���JFreeChart����
	 * 
	 * @param pieDataset
	 * @return
	 */
	public static JFreeChart createJFreeChart(PieDataset pieDataset) {
		JFreeChart chart = ChartFactory.createPieChart("ĳ������Ҫũ������ֲ������״ͼ",
				pieDataset, true, true, false);
		return chart;
	}

	/**
	 * ���ɱ�ͼͼ���ļ�
	 * 
	 * @param session
	 * @param out
	 * @return
	 */
	public static String getPieImgURL(HttpSession session, PrintWriter out) {
		String filename = "";
		PieDataset pieDataset = getPieDataset();
		JFreeChart chart = createJFreeChart(pieDataset);
		//��״ͼֻ��Ҫ����ͼƬ�ı�����ɫ,�����������ʾ��ɫ���Զ�����
		chart.setBackgroundPaint(Color.WHITE);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		try {
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 400, info,
					session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(out, filename, info, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
}
