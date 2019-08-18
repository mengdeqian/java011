package InputAndOutputStream;
/**
 * 装饰器的实现类B
 * @author mdq
 *
 */
public class CompoentImplB extends Decorator {
	public CompoentImplB(Compoent compoent){
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
		System.out.println("comBa拓展方法");
	}
	private void extendsReadB(){
		System.out.println("comBb拓展方法");
	}
}
