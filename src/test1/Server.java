package test1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		int count = 0;
		try {
			ss = new ServerSocket(6666);
			System.out.println("====���ն��ц��ӣ��ȴ��͑��˵��B��====");
			while(true) {
				socket = ss.accept();
				ServerThread st = new ServerThread(socket);
				st.start();
				count++;
				System.out.println("��ǰ�ͷ��˔�����"+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�͑���IP��ַ��"+address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
