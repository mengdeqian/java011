package InputAndOutputStream;


import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;

import javax.swing.JFileChooser;

/**
 * ��ʾFile��Ļ���ʹ�ü����÷���
 * File�ಢ���������ļ��Ķ�д����
 * @author �Ͼ�ѧ�á���ͷ
 * @version 1.0
 * @date 2017��8��8�� ����2:56:53
 * @copyright �Ͼ�ѧ��
 * @remarks TODO
 *
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		//���飺��Ҫֱ��ʹ�þ����ļ��������ʹ������c:\\test.java֮����ļ�������Windows���������У�������������ƽ̨������
		//Ӧ��ʹ���뵱ǰĿ¼��ص��ļ���
		JFileChooser fileChooser = new JFileChooser(new File("."));	//�����ļ��Ի����ʱ�ĸ�Ŀ¼
		//��FileChooser����ѡ���ļ���
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setFileFilter(new MyFileFilter());
		fileChooser.showOpenDialog(null);	//��ʾ��ѡ���ļ��ĶԻ���(null��ʾ�޸�����)
		//����û�ѡ����ļ� ����ʹ��ʱ�ж�file�Ƿ�Ϊnull�����Ϊnull����ʾ�û�����ȡ����ť
		File file = fileChooser.getSelectedFile();	//����û�ѡ����ļ�
		if(null == file){
			System.out.println("�û�δѡ���κ��ļ���ϵͳǿ���˳���");
			System.exit(0);
		}
		System.out.println("�ļ�/�ļ����Ƿ���ڣ�" + file.exists());
		System.out.println("�Ƿ���һ���ļ���" + file.isFile());
		System.out.println("�Ƿ���һ���ļ��У�" + file.isDirectory());
		System.out.println("�ļ�/�ļ������ƣ�" + file.getName());
		System.out.println("�ļ�/�ļ��еľ���·����" + file.getAbsolutePath());
		System.out.println("�ļ�/�ļ��е�����޸�ʱ�䣺" + new Date(file.lastModified()).toLocaleString());
		System.out.println("�ļ�/�ļ�����ռ�ռ��С��" + file.length() / 1024 + "KB");
		System.out.println("�Ƿ�ɶ���" + file.canRead());
		System.out.println("�Ƿ��д��" + file.canWrite());
		System.out.println("�Ƿ����أ�" + file.isHidden());
		//System.out.println(file.canExecute());//linux����Ч
		
//		if(!file.exists()){
//			if(file.createNewFile())
//				System.out.println("�ļ������ɹ���");
//		}
//		if(file.exists()){
//			file.delete();	//ֱ��ɾ���ļ���ɾ����ʱ��Ҳ�����ж��ļ��Ƿ���ڣ�Ҳ�����쳣
//			//file.deleteOnExit();//�ڽ��̽�����ʱ����ļ�ɾ����ע�⣺����ڵ�ǰ�������´����ļ�������Ҳ�ᱻɾ������
//			System.out.println("�ļ�ɾ���ɹ���");
//		}
//		file.createNewFile();
//		System.out.println("�ļ����´����ɹ���");
//		mkdir���������˳���·������ָ����Ŀ¼����ֻ�ܴ���һ����Ŀ¼������Ҫ���ڸ�Ŀ¼��
//		mkdirs���������˳���·��ָ����Ŀ¼���������б��뵫�����ڵĸ�Ŀ¼���������Դ����༶Ŀ¼�������Ƿ���ڸ�Ŀ¼��-�༶Ŀ¼ʱʹ��
		
		//�г���ǰĿ¼�µ������ļ�/�ļ���
		if(file.isDirectory()){
			System.out.println(file.getAbsolutePath() + "·���µ������ļ����ļ��У�");
			String[] fileNames = file.list(new DirFilter());
			for (int i = 0; i < fileNames.length; i++) {
				System.out.println(fileNames[i]);
			}
		}
		

	}
	
	static class MyFileFilter extends javax.swing.filechooser.FileFilter{

		@Override
		public boolean accept(File f) {
			if(f.getName().endsWith("wav")){
				return true;
			}
			return false;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "*.*, *.wav";
		}
		

		
	}
	
	//���䣺ѡѧ
	/**
	 * �����Զ�����ļ����������࣬����ʵ��FilenameFileter�ӿ�
	 * @author �Ͼ�ѧ�á���ͷ
	 * @version 1.0
	 * @date 2017��8��11�� ����10:58:17
	 * @copyright �Ͼ�ѧ��
	 * @remarks TODO
	 *
	 */
	static class DirFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String name) {
			//��������Ҫ��ֻ��ʾgitΪ��׺���ļ������˵�������׺
			if(name.endsWith("wav")){
				return true;
			}
			return false;
		}
		
	}
	

}
