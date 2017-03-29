package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;
		PrintWriter pw = null;
		InputStream is = null;
		BufferedReader br = null;
		try {
			socket = new Socket("localhost",6666);
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("用户名：admin2 密码：admin2");
			pw.flush();
			socket.shutdownOutput();
			
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = br.readLine()) != null) {
				System.out.println("服务端："+info);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(is != null) is.close();
				if(pw != null) pw.close();
				if(os != null) os.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
