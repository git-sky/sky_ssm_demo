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
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
/**
 * ������ʾ˫����ͼ��
 * @author leejon
 *
 */
public class mutiTimeLineChart {
	/**
	 * �������ݼ�
	 * 
	 * @return
	 */
	public static XYDataset getDataset() {
		String tag1 = "����1";
		TimeSeries timeSer1 = new TimeSeries(tag1, Year.class);
		timeSer1.add(new Year(2000), 1000);
		timeSer1.add(new Year(2001), 1300);
		timeSer1.add(new Year(2002), 1700);
		timeSer1.add(new Year(2003), 1900);
		timeSer1.add(new Year(2004), 1400);
		timeSer1.add(new Year(2005), 2000);
		timeSer1.add(new Year(2006), 2200);
		timeSer1.add(new Year(2007), 1800);
		timeSer1.add(new Year(2008), 2300);
		timeSer1.add(new Year(2009), 1900);

		String tag2 = "����2";
		TimeSeries timeSer2 = new TimeSeries(tag2, Year.class);
		timeSer2.add(new Year(2000), 900);
		timeSer2.add(new Year(2001), 1100);
		timeSer2.add(new Year(2002), 1300);
		timeSer2.add(new Year(2003), 1400);
		timeSer2.add(new Year(2004), 1700);
		timeSer2.add(new Year(2005), 1000);
		timeSer2.add(new Year(2006), 1300);
		timeSer2.add(new Year(2007), 2300);
		timeSer2.add(new Year(2008), 2700);
		timeSer2.add(new Year(2009), 1900);
		
		TimeSeriesCollection timeSerCollection = new TimeSeriesCollection();
		timeSerCollection.addSeries(timeSer1);
		timeSerCollection.addSeries(timeSer2);
		return timeSerCollection;
	}

	/**
	 * �������ݼ�����ͼ�����
	 * 
	 * @param categoryDataset
	 * @return
	 */
	public static JFreeChart createChart(XYDataset xyDataset) {
		JFreeChart chart = ChartFactory.createTimeSeriesChart(
				"����1�͵���2  2000��-2009���꽵ˮ������ͼ", "���", "��ˮ��(mm)", xyDataset, true,
				true, false);
		chart.setBackgroundPaint(Color.WHITE);
		return chart;
	}
	
	/**
	 * �������Ӧ������ͼ
	 * @param session
	 * @param out
	 * @return
	 */
	public static String getTimeLineChartImgURL(HttpSession session,PrintWriter out){
		String filename="";
		JFreeChart chart=createChart(getDataset());
		chart.setBackgroundPaint(Color.WHITE);
		ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
		try {
			filename=ServletUtilities.saveChartAsPNG(chart, 900, 400,info, session);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(out, filename, info, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		return filename;
	}
}
