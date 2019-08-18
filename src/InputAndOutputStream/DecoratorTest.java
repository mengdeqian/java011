package InputAndOutputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/**
 * 使用装饰器模式的场合
 * 1、当我们需要在不影响其他对象的情况下，以动态、透明（私有）的方式为对象添加功能（拓展方法实现）
 * 2、当不适合使用继承，当时又想进行方法的拓展时
 * @author mdq
 *
 */
public class DecoratorTest {
	public static void main(String[] args) throws FileNotFoundException{
		//创建要被装饰的原始对象
		Compoent compoent = new TrueCompoent();
		//为原始对象透明的增加功能
		CompoentImplA componentA = new CompoentImplA(compoent);
		componentA.read();
		CompoentImplB compoentB = new CompoentImplB(componentA);
		compoentB.read();
		
		InputStream inputStream = new FileInputStream("");
		BufferedInputStream bInputStream = new BufferedInputStream(inputStream);
		
	}
}
