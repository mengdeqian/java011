package InputAndOutputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字符流文件读写
 * @author mdq
 *
 */
public class ReaderAndWriterDemo {
	private static final String FilePath1 = "E:/桌面文件/信息.txt";
	private static final String FilePath2 = "E:/桌面文件/信息复制版1.txt";
	
	public static void main(String [] args){
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(FilePath1));
			//固定的读取格式
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
		String content = "团地点：山东省邹城市中心店中学";
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
