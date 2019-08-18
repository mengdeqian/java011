package InputAndOutputStream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * �ļ�������
 * ������ԭ��
			ʵ��ͨ��httpЭ�������ļ�
			1����HTTPЭ�������ļ����ļ����������ļ��Ի������ķ�ʽ��ȡ���ڴ���
			 InputStream->BufferedInputStream
			2�������������ݷֿ�д�뵽Ӳ���ϣ�ʹ��RandomAccessFileʵ��
			
 * @author mdq
 *
 */
public class Downloader_RandomAccessFile {
	/**
	 * ����·��
	 */
	public static final String StrUrl = "http://dldir1.qq.com/qqtv/TencentVideo10.21.4318.0.exe";
	/**
	 * ��������ʱ��Ĭ�ϻ����С-1M/10K��С
	 */
	private static final int MAX_BYFFERED_SIZE = 102400;
	public static void main(String[] args){
		//1����http���ӣ�����������ݵĳ���
		//2������randomaccessFile����
		//3�������ص����ݻ��浽�ֽ�������
		//3���������ֽ�����ͨ��RandomAccessFile����д�뵽�ļ��У�ʹ���ļ�ָ�룩
		HttpURLConnection connection = null;
		BufferedInputStream bInputStream = null;
		try {
			URL url = new URL(StrUrl);	//����url�����Ա����ļ���
			connection = (HttpURLConnection)url.openConnection();
			//������������-Rangeָ�ӷ��������������ļ����ֽ�����Χ��0-��ʾ��ָ����ֹ�ֽ���
			connection.setRequestProperty("Range", "bytes=0-");
			connection.connect();//���ӵ�������
			//�ж������Ƿ�ɹ�-һ�����ӳɹ���᷵��200-299���ڵ�����
			if(connection.getResponseCode() / 100 != 2){
				System.out.println("���ӵ���Ӧ״̬����200��Χ�ڣ�������");
				return;
			}
			int fileSize = connection.getContentLength();//���Ҫ�����ļ��Ĵ�С-�ֽ���
			bInputStream = new BufferedInputStream(connection.getInputStream(),MAX_BYFFERED_SIZE);
			int downloaded = 0;	//�����ص��ֽ���-�����������ذٷֱ�
			String fileName = url.getFile();	//����ļ���
			fileName = fileName.substring(fileName.lastIndexOf("/") + 1);	//��ȡ�ַ���-�����һ��/����
			RandomAccessFile file = new RandomAccessFile(fileName, "rw");
			file.setLength(0);
			file.seek(0);
			while(downloaded < fileSize){	//��ǰ�Ѿ������ֽ���С���ļ��ܴ�Сʱ����������
				byte[] buffer = null;
				//�ж�δ���صĴ�С�Ƿ񳬹���󻺴���
				if(fileSize - downloaded > MAX_BYFFERED_SIZE){
					buffer = new byte[MAX_BYFFERED_SIZE];
				}else{
					buffer = new byte[fileSize - downloaded];
				}
				//�������е����ݶ�ȡ����
				int read = bInputStream.read(buffer);
				if(read == -1) break;	//�������
				//����ǰ���صĻ���д�뵽�ļ���
				file.seek(downloaded);	//�����ļ�ָ��
				file.write(buffer, 0, read);
				downloaded += read;
				System.out.println("��ǰ���ؽ��ȣ�" + downloaded * 1.0 / fileSize * 10000 / 100 + "%");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
			try {
				bInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
