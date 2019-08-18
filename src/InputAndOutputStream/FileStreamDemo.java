package InputAndOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 演示文件输入、输出流的基本用法
 * 较原始方法，熟悉常用InputStream&OutputStream常用方法即可
 * @author mdq
 *
 */
public class FileStreamDemo {
	private static final String FilePath = "src/InputAndOutputStream/FileStreamDemo.java";
	public static void main(String[] args) throws IOException{
		ReadFile();
		writeFile();
	}
	
	public static void writeFile() throws IOException{
		final String FilePath1 = "src/InputAndOutputStream/FileOutDemo1.java";
		OutputStream outStream = new FileOutputStream(FilePath1,true);
		String content = "public class FileOutDemo1{\n";
		content += "public static void main(String[] args)";
		outStream.write(content.getBytes());
		outStream.close();
	}
	
	public static void ReadFile() throws IOException{
		File file =  new File(FilePath);
		InputStream inputStream = new FileInputStream(file);
		//读取文件的基本操作
		//inputStream.available():文件预估大小
		byte[] bytes = new byte[inputStream.available()+100];
		inputStream.read(bytes);
		
		
//		int count = 0;
//		while((bytes[count] = (byte)inputStream.read()) != -1){
//			count++; 
//		}
		String content = new String(bytes);
		
		System.out.println(content);
		inputStream.close();
	}
}
