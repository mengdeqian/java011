package InputAndOutputStream;
/**
 * װ������ʵ����A
 * @author mdq
 *
 */
public class CompoentImplA extends Decorator {
	public CompoentImplA(Compoent compoent){
		super(compoent);
	}
	
	@Override
	public void read() {
		//��ԭʼ��read����ǰ��������Զ�����չ����
		this.extendsReadA();
		super.read();	//ԭʼ��read����
		this.extendsReadB();
	}
	
	
	private void extendsReadA(){
		System.out.println("comAa��չ����");
	}
	private void extendsReadB(){
		System.out.println("comAb��չ����");
	}
}
