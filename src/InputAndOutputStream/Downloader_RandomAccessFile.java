package InputAndOutputStream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * 文件下载器
 * 下载器原理
			实现通过http协议下载文件
			1、从HTTP协议下载文件（文件流），将文件以缓冲流的方式读取到内存中
			 InputStream->BufferedInputStream
			2、将缓存中数据分块写入到硬盘上（使用RandomAccessFile实现
			
 * @author mdq
 *
 */
public class Downloader_RandomAccessFile {
	/**
	 * 下载路径
	 */
	public static final String StrUrl = "http://dldir1.qq.com/qqtv/TencentVideo10.21.4318.0.exe";
	/**
	 * 设置下载时的默认缓存大小-1M/10K大小
	 */
	private static final int MAX_BYFFERED_SIZE = 102400;
	public static void main(String[] args){
		//1、打开http链接，获得下载内容的长度
		//2、创建randomaccessFile对象
		//3、将下载的内容缓存到字节数组中
		//3、将缓存字节数组通过RandomAccessFile对象写入到文件中（使用文件指针）
		HttpURLConnection connection = null;
		BufferedInputStream bInputStream = null;
		try {
			URL url = new URL(StrUrl);	//创建url对象，以便获得文件流
			connection = (HttpURLConnection)url.openConnection();
			//设置链接属性-Range指从服务器请求下载文件的字节数范围，0-表示不指定终止字节数
			connection.setRequestProperty("Range", "bytes=0-");
			connection.connect();//连接到服务器
			//判断连接是否成功-一般连接成功后会返回200-299以内的数字
			if(connection.getResponseCode() / 100 != 2){
				System.out.println("连接的响应状态不再200范围内，请重试");
				return;
			}
			int fileSize = connection.getContentLength();//获得要下载文件的大小-字节数
			bInputStream = new BufferedInputStream(connection.getInputStream(),MAX_BYFFERED_SIZE);
			int downloaded = 0;	//已下载的字节数-用来计算下载百分比
			String fileName = url.getFile();	//获得文件名
			fileName = fileName.substring(fileName.lastIndexOf("/") + 1);	//截取字符串-从最后一个/往后
			RandomAccessFile file = new RandomAccessFile(fileName, "rw");
			file.setLength(0);
			file.seek(0);
			while(downloaded < fileSize){	//当前已经下载字节数小于文件总大小时，继续下载
				byte[] buffer = null;
				//判断未下载的大小是否超过最大缓存数
				if(fileSize - downloaded > MAX_BYFFERED_SIZE){
					buffer = new byte[MAX_BYFFERED_SIZE];
				}else{
					buffer = new byte[fileSize - downloaded];
				}
				//将缓存中的内容读取出来
				int read = bInputStream.read(buffer);
				if(read == -1) break;	//下载完毕
				//将当前下载的缓存写入到文件中
				file.seek(downloaded);	//设置文件指针
				file.write(buffer, 0, read);
				downloaded += read;
				System.out.println("当前下载进度：" + downloaded * 1.0 / fileSize * 10000 / 100 + "%");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
			try {
				bInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
