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
 * 修改歌词中的内容，实际是文件读写操作
 * @author mdq
 *
 */
public class ReplaceLyricDemo {
	static final String FilePath1 = "E:/桌面文件/lyric.sav";

	static final String FilePath2 = "E:/桌面文件/lyric(replace).sav";
	
	/**
	 * 字符流
	 * 将读取文件的操作封装成方法
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
			 //删除最后的系统分割符
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
	 * 使用PrintWriter对象实现写入文件
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
//			 String newLyric = lyric.toString().replaceAll("（男）", "男：").replaceAll("（合）", "合：").replaceAll("（女）", "女：");
//			 //将歌词写入文件
//			 writer = new FileWriter(FilePath2);
//			 bWriter = new BufferedWriter(writer);
//			 bWriter.write(newLyric);
//			 System.out.println("文件替换成功");
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
