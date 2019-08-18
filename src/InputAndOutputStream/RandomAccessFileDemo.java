package InputAndOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	private static final String FilePath = "src/InputAndOutputStream/RandFile.txt";
	private static final String FilePath1 = "src/InputAndOutputStream/163.html";
	/**
	 * 使用RandomAccessFile实现文件的复制
	 */
	private static void CopyFile(){
		try(
				RandomAccessFile srcFile = new RandomAccessFile(new File(FilePath1), "r");
				RandomAccessFile newFile = new RandomAccessFile(new File(FilePath), "rw");
		){
			//复制之前清空newfile
			newFile.setLength(0);
			long fileLength = srcFile.length();	//获得要复制文件的大小
			byte[] bytes = new byte[(int)fileLength];
			srcFile.readFully(bytes);
			//将字节数组写入到新文件中即可
			newFile.write(bytes);
			System.out.println("文件复制成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		CopyFile();
//		File file = new File(FilePath);
//		if(!file.exists()){
//			file.createNewFile();
//		}
//		try(RandomAccessFile randFile = new RandomAccessFile(file, "rw")){
//			//删除文件方法-强制清零
//			//randFile.setLength(0);
//			//写入2000个整形数据
//			for(int i = 0; i < 2000; i++){
//				randFile.writeInt(i + 2000);
//			}
//			//读取
//			System.out.println("当前文件大小：" + randFile.length() + "字节");
//			//移动文件指针
//			randFile.seek(4*8);
//			System.out.println("移动8个整形空间(32字节)后,值为" + randFile.readInt());
//			randFile.seek(4*800);
//			randFile.writeInt(8000);
//			randFile.seek(4*800);
//			System.out.println("移动800个整形空间(3200字节)后,值为" + randFile.readInt());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
