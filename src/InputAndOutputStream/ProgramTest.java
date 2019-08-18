package InputAndOutputStream;
/**
 * 向文件中随机写入100个整数
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProgramTest {
	public static final String FilePath = "D:/mengdeqian1.txt";
	
	public static void main(String[] args){
		File file = new File(FilePath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream outStream = null;
		BufferedOutputStream bOutStream = null;
		try {
			outStream = new FileOutputStream(file, true);
			bOutStream = new BufferedOutputStream(outStream);
			StringBuffer nums = new StringBuffer();
			for(int i = 0; i < 100; i++){
				Integer num =  (int)(Math.random() * 100);
				nums.append(num.toString());
				nums.append(" ");
			}
			nums.delete(nums.lastIndexOf(" "), nums.length());
			System.out.println(nums);
			bOutStream.write(nums.toString().getBytes());
			bOutStream.write("keke".getBytes());
			System.out.println("写入完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bOutStream.close();
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
