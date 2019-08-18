package InputAndOutputStream;
/**
 * 装饰器的实现类A
 * @author mdq
 *
 */
public class CompoentImplA extends Decorator {
	public CompoentImplA(Compoent compoent){
		super(compoent);
	}
	
	@Override
	public void read() {
		//在原始的read方法前后调用了自定义拓展方法
		this.extendsReadA();
		super.read();	//原始的read方法
		this.extendsReadB();
	}
	
	
	private void extendsReadA(){
		System.out.println("comAa拓展方法");
	}
	private void extendsReadB(){
		System.out.println("comAb拓展方法");
	}
}
