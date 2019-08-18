package InputAndOutputStream;

import java.io.Closeable;
import java.io.IOException;

public class CloseableDemo {
	public static void main(String[] args){
		try(SomeResrc some = new SomeResrc()){
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
class SomeResrc implements Closeable{
	@Override
	public void close() throws IOException {
		System.out.println("¹Ø±Õ");
	}
}