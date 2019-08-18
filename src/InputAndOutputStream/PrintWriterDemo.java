package InputAndOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintWriter 和PrintStream
 * 1、printWriter用来处理字符流，一次写入两个字节；
 * PrintStream用来处理字节流，一次写入一个字节
 * 建议在处理文本文件时，使用PrintWriter
 * @author mdq
 *
 */
public class PrintWriterDemo {
	static final String FilePath1 = "E:/桌面文件/信息.txt";
	public static void main(String[] args){
		//关于java中的分隔符windows-\r\n
		String separator = System.getProperty("line.separator");
		String content = "public static void main(String[] args){" + separator;
		content += "\tpublic static void }}";
		try(PrintWriter writer = new PrintWriter(new File(FilePath1))){
			writer.write(content);
			System.out.println("写入成功");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try(Scanner input = new Scanner(new File(FilePath1))){
			StringBuffer value = new StringBuffer();
			while(input.hasNextLine()){
				value.append(input.nextLine());
				value.append(separator);
			}
			System.out.println("文件中读取的内容:");
			System.out.println(value.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
