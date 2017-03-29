package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	
	Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = br.readLine()) != null) {
				System.out.println("¿Í»§¶Ë£º"+info);
			}
			socket.shutdownInput();
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("»¶Ó­Äú£¡");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pw != null) pw.close();
				if(os != null) os.close();
				if(br != null) br.close();
				if(is != null) is.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
