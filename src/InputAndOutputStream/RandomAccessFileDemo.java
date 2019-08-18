package InputAndOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	private static final String FilePath = "src/InputAndOutputStream/RandFile.txt";
	private static final String FilePath1 = "src/InputAndOutputStream/163.html";
	/**
	 * ʹ��RandomAccessFileʵ���ļ��ĸ���
	 */
	private static void CopyFile(){
		try(
				RandomAccessFile srcFile = new RandomAccessFile(new File(FilePath1), "r");
				RandomAccessFile newFile = new RandomAccessFile(new File(FilePath), "rw");
		){
			//����֮ǰ���newfile
			newFile.setLength(0);
			long fileLength = srcFile.length();	//���Ҫ�����ļ��Ĵ�С
			byte[] bytes = new byte[(int)fileLength];
			srcFile.readFully(bytes);
			//���ֽ�����д�뵽���ļ��м���
			newFile.write(bytes);
			System.out.println("�ļ����Ƴɹ���");
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
//			//ɾ���ļ�����-ǿ������
//			//randFile.setLength(0);
//			//д��2000����������
//			for(int i = 0; i < 2000; i++){
//				randFile.writeInt(i + 2000);
//			}
//			//��ȡ
//			System.out.println("��ǰ�ļ���С��" + randFile.length() + "�ֽ�");
//			//�ƶ��ļ�ָ��
//			randFile.seek(4*8);
//			System.out.println("�ƶ�8�����οռ�(32�ֽ�)��,ֵΪ" + randFile.readInt());
//			randFile.seek(4*800);
//			randFile.writeInt(8000);
//			randFile.seek(4*800);
//			System.out.println("�ƶ�800�����οռ�(3200�ֽ�)��,ֵΪ" + randFile.readInt());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
