package InputAndOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象的序列化和反序列化操作
 * 必须实现Serializable接口
 * @author mdq
 *
 */
public class ObjcetStreamDemo {
	private static final String FilePath = "src/InputAndOutputStream/object.dat";
	public static void main(String[] args){
		Player player1 = new Player("今麦郎" , 99);
		//使用对象流将序列化的对象写入到文件中
		try(	FileOutputStream fOutStream = new FileOutputStream(FilePath);
				ObjectOutputStream objOutStream = new ObjectOutputStream(fOutStream)
			){
			objOutStream.writeObject(player1);
			System.out.println("对象写入成功");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//从文件中读取对象，转换成我们可操作的对象
		try(	FileInputStream fInStream = new FileInputStream(FilePath);
				ObjectInputStream objInStream = new ObjectInputStream(fInStream)
		){
			Player player2 = (Player)objInStream.readObject();
			System.out.println("读取的对象内容是：" + player2.toString());
			System.out.println(player1 == player2);//比较地址

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Player implements Serializable{
	private static final long serialVersionUID = 7922852865251721512L;
	private String nickName;
	private int level;
	
	public Player(){}
	public Player(String nickName, int level){
		setLevel(level);
		setNickName(nickName);
	}
	@Override
	public String toString() {
		return nickName + "\t" + level;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}