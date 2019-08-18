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
 * 使用带缓存的流增加读写效率
 * 实现复制粘贴功能
 * @author mdq	
 *
 */
public class BufferdeStreamDemo {
	private static final String FilePath1 = "E:/桌面文件/我的視頻.mp4";
	private static final String FilePath2 = "E:/桌面文件/我的視頻_复制文件1.mp4";
	
	
	
	public static void main(String[] args) throws IOException{
		//使用缓存流装饰系统的输入流对象
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[] bytes = new byte[200];
//		System.out.println("请输入字符串:");
//		inStream.read(bytes);
//		System.out.println("用户输入的字符串时:" + new String(bytes));
		
		long time = CopyFileByBufferedStream();
		System.out.println("文件复制耗时:" + time + "ms");
	
	
	}
	/**
	 * 使用缓存流拷贝文件
	 * 
	 * @return 拷贝过程的用时，单位ms
	 */
	private static long CopyFileByBufferedStream(){
		//要复制的文件对象
		File file = new File(FilePath1);
		if(!file.exists()){
			System.out.println("文件不存在，复制失败!");
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
				bOutStream.write(i);	//注意：读取一个字节，就写入到了缓存中,需要在最后将缓存中的文件写入到文件中，
				//即，需要清空缓冲区
			}
			System.out.println("文件复制成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//bOutStream.flush();
				bOutStream.close();//可以直接调用close方法，内部自动调用flush方法
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
//			bOutStream.write("今天天气很好!".getBytes());
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
