package InputAndOutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 从给定的url上读取文件内容-暂时只支持http协议
 * @author mdq
 *
 */
public class ReadUrlContent {
	static final String FilePath = "src/InputAndOutputStream/163.html";
	public static void main(String[] args) throws MalformedURLException{
		URL url = new URL("http://www.163.com/index.html");
		StringBuffer content = new StringBuffer();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
			String line = null;
			while((line = reader.readLine()) != null){
				content.append(line);
				content.append(System.getProperty("line.separator"));
			}
			ReplaceLyricDemo.WriteFileByPrintWriter(content.toString(), FilePath, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
