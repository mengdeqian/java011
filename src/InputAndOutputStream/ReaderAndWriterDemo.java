package InputAndOutputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ַ����ļ���д
 * @author mdq
 *
 */
public class ReaderAndWriterDemo {
	private static final String FilePath1 = "E:/�����ļ�/��Ϣ.txt";
	private static final String FilePath2 = "E:/�����ļ�/��Ϣ���ư�1.txt";
	
	public static void main(String [] args){
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(FilePath1));
			//�̶��Ķ�ȡ��ʽ
			String line = null;
			while((line = bReader.readLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String content = "�ŵص㣺ɽ��ʡ�޳������ĵ���ѧ";
		BufferedWriter bWriter = null;
		try {
			bWriter = new BufferedWriter(new FileWriter(FilePath2));
			bWriter.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				bWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
