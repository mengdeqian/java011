package InputAndOutputStream;
/**
 * 装饰器父类
 * 用来为基本的组件实现功能的拓展
 * @author mdq
 *
 */
public class Decorator extends Compoent {
	private Compoent compoent;
	
	public Decorator(Compoent compoent) {
		this.compoent = compoent; 
	}
	
	@Override
	public void read() {
		compoent.read();
	}
}
