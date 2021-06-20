package cn.com.sky.chart.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//����һ�������ռ䣬�����Ͽ����ǲ���һ��excel���
		HSSFWorkbook book=new HSSFWorkbook();
		//ͨ�������ռ䴴��ҳ,����Ϊҳ����
		HSSFSheet sheet=book.createSheet("��������");
		//ͨ��ҳ������
		HSSFRow row1=sheet.createRow(0);
		HSSFRow row2=sheet.createRow(1);
		
		//ͨ���д�����
		HSSFCell cell11=row1.createCell((short) 0);
		HSSFCell cell12=row1.createCell((short) 1);
		HSSFCell cell13=row1.createCell((short) 2);
		
		HSSFCell cell21=row2.createCell((short) 0);
		HSSFCell cell22=row2.createCell((short) 1);
		HSSFCell cell23=row2.createCell((short) 2);
		//���õ�Ԫ���ֵ
		//��һ�еĵ�һ������
		cell11.setCellValue("ѧ��");
		cell12.setCellValue("����");
		cell13.setCellValue("����");
		//�ڶ��еĵ�һ������
		cell21.setCellValue("1721");
		cell22.setCellValue("leejon");
		cell23.setCellValue("98");
		
		//�����ļ��������дexcel����ĵ�
		FileOutputStream out=new FileOutputStream((new File("D:\\back.xls")));
		book.write(out);
	}
}
