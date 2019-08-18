package InputAndOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintWriter ��PrintStream
 * 1��printWriter���������ַ�����һ��д�������ֽڣ�
 * PrintStream���������ֽ�����һ��д��һ���ֽ�
 * �����ڴ����ı��ļ�ʱ��ʹ��PrintWriter
 * @author mdq
 *
 */
public class PrintWriterDemo {
	static final String FilePath1 = "E:/�����ļ�/��Ϣ.txt";
	public static void main(String[] args){
		//����java�еķָ���windows-\r\n
		String separator = System.getProperty("line.separator");
		String content = "public static void main(String[] args){" + separator;
		content += "\tpublic static void }}";
		try(PrintWriter writer = new PrintWriter(new File(FilePath1))){
			writer.write(content);
			System.out.println("д��ɹ�");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try(Scanner input = new Scanner(new File(FilePath1))){
			StringBuffer value = new StringBuffer();
			while(input.hasNextLine()){
				value.append(input.nextLine());
				value.append(separator);
			}
			System.out.println("�ļ��ж�ȡ������:");
			System.out.println(value.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
