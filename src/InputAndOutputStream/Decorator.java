package InputAndOutputStream;
/**
 * װ��������
 * ����Ϊ���������ʵ�ֹ��ܵ���չ
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
