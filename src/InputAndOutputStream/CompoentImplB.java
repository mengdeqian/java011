package InputAndOutputStream;
/**
 * װ������ʵ����B
 * @author mdq
 *
 */
public class CompoentImplB extends Decorator {
	public CompoentImplB(Compoent compoent){
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
		System.out.println("comBa��չ����");
	}
	private void extendsReadB(){
		System.out.println("comBb��չ����");
	}
}
