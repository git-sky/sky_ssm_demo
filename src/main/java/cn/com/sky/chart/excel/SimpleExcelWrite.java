package cn.com.sky.chart.excel;

import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 * �򵥲���excel���ʵ��
 * @author leejon
 *
 */
public class SimpleExcelWrite {
	public void createExcel(OutputStream os) throws IOException, RowsExceededException, WriteException{
		//����������
		WritableWorkbook book=Workbook.createWorkbook(os);
		//��excel�ĵ��д����µ�һҳ
		WritableSheet sheet=book.createSheet("��һҳ", 0);
		//��������Ҫ��ʾ������
		//��һ�����ֱ�ʾ��,�ڶ������ֱ�ʾ��,�������ַ�����ʾ����
		Label id=new Label(0,0,"ѧ��");
		Label name=new Label(1,0,"����");
		Label score=new Label(2,0,"����");
		
		Label inf11=new Label(0,1,"1721");
		Label inf12=new Label(1,1,"leejon");
		Label inf13=new Label(2,1,"98");
		
		//����ʾ�����ݼ��뵽sheet��
		sheet.addCell(id);
		sheet.addCell(name);
		sheet.addCell(score);
		
		sheet.addCell(inf11);
		sheet.addCell(inf12);
		sheet.addCell(inf13);
		
		//�Ѵ���������д���������,���ر������
		book.write();
		book.close();
		os.close();
		
	}
}	
