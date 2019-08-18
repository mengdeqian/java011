package InputAndOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ʹ�ô�����������Ӷ�дЧ��
 * ʵ�ָ���ճ������
 * @author mdq	
 *
 */
public class BufferdeStreamDemo {
	private static final String FilePath1 = "E:/�����ļ�/�ҵ�ҕ�l.mp4";
	private static final String FilePath2 = "E:/�����ļ�/�ҵ�ҕ�l_�����ļ�1.mp4";
	
	
	
	public static void main(String[] args) throws IOException{
		//ʹ�û�����װ��ϵͳ������������
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("�������ַ���:");
//		inStream.read(bytes);
//		System.out.println("�û�������ַ���ʱ:" + new String(bytes));
		
		long time = CopyFileByBufferedStream();
		System.out.println("�ļ����ƺ�ʱ:" + time + "ms");
	
	
	}
	/**
	 * ʹ�û����������ļ�
	 * 
	 * @return �������̵���ʱ����λms
	 */
	private static long CopyFileByBufferedStream(){
		//Ҫ���Ƶ��ļ�����
		File file = new File(FilePath1);
		if(!file.exists()){
			System.out.println("�ļ������ڣ�����ʧ��!");
			return 0;
		}
		long starTime = System.currentTimeMillis();
		InputStream inStream = null;
		BufferedInputStream bInStream = null;
		OutputStream outStream = null;
		BufferedOutputStream bOutStream = null;
		try {
			inStream = new FileInputStream(file);
			bInStream = new BufferedInputStream(inStream);
			outStream = new FileOutputStream(FilePath2);
			bOutStream = new BufferedOutputStream(outStream);
			int i = -1;
			while((i = bInStream.read()) != -1){
				bOutStream.write(i);	//ע�⣺��ȡһ���ֽڣ���д�뵽�˻�����,��Ҫ����󽫻����е��ļ�д�뵽�ļ��У�
				//������Ҫ��ջ�����
			}
			System.out.println("�ļ����Ƴɹ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//bOutStream.flush();
				bOutStream.close();//����ֱ�ӵ���close�������ڲ��Զ�����flush����
				outStream.close();
				bInStream.close();
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		long endTime = System.currentTimeMillis();
		
		return endTime - starTime;
	}
	
	
//	private static final String FilePath = "src/InputAndOutputStream/FileOutDemo1.java";
//
//	private static final String FilePath2 = "src/InputAndOutputStream/FileOutDemo2.txt";
//	public static void main(String[] args){
//		BufferedInputStream bInputStream = null;
//		try {
//			bInputStream = new BufferedInputStream(new FileInputStream(FilePath));
//			
//			byte[] bytes = new byte[bInputStream.available()];
//			bInputStream.read(bytes);
//			System.out.println(new String(bytes));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				bInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		BufferedOutputStream bOutStream = null;
//		try {
//			bOutStream = new BufferedOutputStream(new FileOutputStream(FilePath2),10240);
//			bOutStream.write("���������ܺ�!".getBytes());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				bOutStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		
//	}
}
