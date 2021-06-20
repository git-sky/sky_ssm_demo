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

public class TimeLineChart {
	/**
	 * �������ݼ�
	 * 
	 * @return
	 */
	public static XYDataset getDataset() {
		String tag = "����";
		TimeSeries timeSer = new TimeSeries(tag, Year.class);
		timeSer.add(new Year(2000), 1000);
		timeSer.add(new Year(2001), 1300);
		timeSer.add(new Year(2002), 1700);
		timeSer.add(new Year(2003), 1900);
		timeSer.add(new Year(2004), 1400);
		timeSer.add(new Year(2005), 2000);
		timeSer.add(new Year(2006), 2700);
		timeSer.add(new Year(2007), 1800);
		timeSer.add(new Year(2008), 2300);
		timeSer.add(new Year(2009), 1900);

		TimeSeriesCollection timeSerCollection = new TimeSeriesCollection();
		timeSerCollection.addSeries(timeSer);
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
				"��������2000��-2009���꽵ˮ������ͼ", "���", "��ˮ��(mm)", xyDataset, true,
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
