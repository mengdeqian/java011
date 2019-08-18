package InputAndOutputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * �޸ĸ���е����ݣ�ʵ�����ļ���д����
 * @author mdq
 *
 */
public class ReplaceLyricDemo {
	static final String FilePath1 = "E:/�����ļ�/lyric.sav";

	static final String FilePath2 = "E:/�����ļ�/lyric(replace).sav";
	
	/**
	 * �ַ���
	 * ����ȡ�ļ��Ĳ�����װ�ɷ���
	 * @param filePath
	 * @return
	 */
	public static String ReadFileByReader(String filePath){
		StringBuffer content = new StringBuffer();
		Reader reader = null;
		BufferedReader bReader = null;
		try {
			 reader = new FileReader(filePath);
			 bReader = new BufferedReader(reader);
			 String line = null;
			 while((line = bReader.readLine()) != null){
				 content.append(line);
				 content.append(System.getProperty("line.separator"));
			 }
			 //ɾ������ϵͳ�ָ��
			 content.delete(content.toString().lastIndexOf(System.getProperty("line.separator")), content.toString().length());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bReader.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content.toString();
	}
	/**
	 * ʹ��PrintWriter����ʵ��д���ļ�
	 * @param filePath
	 * @param isAppend
	 */
	public static void WriteFileByPrintWriter(String content, String filePath, boolean isAppend){
		try(FileOutputStream outStream = new FileOutputStream(filePath, isAppend);
			PrintWriter writer = new PrintWriter(outStream)	){
			writer.write(content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		String content = ReadFileByReader(FilePath1);
		WriteFileByPrintWriter(content, FilePath2, true);
	}
	
//	public static void main(String[] args){
//		Reader reader = null;
//		BufferedReader bReader = null;
//		Writer writer = null;
//		BufferedWriter bWriter = null;
//		
//		StringBuffer lyric = new StringBuffer();
//		try {
//			 reader = new FileReader(FilePath1);
//			 bReader = new BufferedReader(reader);
//			 String line = null;
//			 while((line = bReader.readLine()) != null){
//				 lyric.append(line);
//				 lyric.append(System.getProperty("line.separator"));
//			 }
//			 String newLyric = lyric.toString().replaceAll("���У�", "�У�").replaceAll("���ϣ�", "�ϣ�").replaceAll("��Ů��", "Ů��");
//			 //�����д���ļ�
//			 writer = new FileWriter(FilePath2);
//			 bWriter = new BufferedWriter(writer);
//			 bWriter.write(newLyric);
//			 System.out.println("�ļ��滻�ɹ�");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				bWriter.close();
//				writer.close();
//				bReader.close();
//				reader.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
// 	}
}
