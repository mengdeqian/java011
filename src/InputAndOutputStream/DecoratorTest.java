package InputAndOutputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/**
 * ʹ��װ����ģʽ�ĳ���
 * 1����������Ҫ�ڲ�Ӱ���������������£��Զ�̬��͸����˽�У��ķ�ʽΪ������ӹ��ܣ���չ����ʵ�֣�
 * 2�������ʺ�ʹ�ü̳У���ʱ������з�������չʱ
 * @author mdq
 *
 */
public class DecoratorTest {
	public static void main(String[] args) throws FileNotFoundException{
		//����Ҫ��װ�ε�ԭʼ����
		Compoent compoent = new TrueCompoent();
		//Ϊԭʼ����͸�������ӹ���
		CompoentImplA componentA = new CompoentImplA(compoent);
		componentA.read();
		CompoentImplB compoentB = new CompoentImplB(componentA);
		compoentB.read();
		
		InputStream inputStream = new FileInputStream("");
		BufferedInputStream bInputStream = new BufferedInputStream(inputStream);
		
	}
}
