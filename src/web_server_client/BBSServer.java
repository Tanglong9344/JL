package web_server_client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import web_server_client.BBSClient.Message;

/**
 * �����ң�Bulletin Board System���ķ������˳���GUI����
 */
public class BBSServer extends JFrame {
	private static final long serialVersionUID = 1L;
	static JLabel statusBar = new JLabel(); // ״̬����ǩ
	// ��ʾ�ͻ��˵�������Ϣ���б�
	static java.awt.List connectInfoList = new java.awt.List(10);
	// ���浱ǰ����ͻ�������Ĵ������߳�
	static Vector<MessFromClient> clientProcessors = new Vector<MessFromClient>(10);
	// ��ǰ��������
	static int activeConnects = 0;
	// ���췽��
	public BBSServer() {
		init();
		try {
			// ���ý���ΪϵͳĬ�����
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
		this.setTitle("BBS��̳1��������");
		statusBar.setText("");
		// ��ʼ���˵�
		JMenu fileMenu = new JMenu();
		fileMenu.setText("�ļ�");
		JMenuItem exitMenuItem = new JMenuItem();
		exitMenuItem.setText("�˳�");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitActionPerformed(e);
			}
		});
		fileMenu.add(exitMenuItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
		// ��������в���
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new BorderLayout());
		JScrollPane pane = new JScrollPane(connectInfoList);
		pane.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(
				Color.red, new Color(134, 134, 0)), "�ͻ���IPһ����"));
		jPanel1.add(new JScrollPane(pane), BorderLayout.CENTER);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(statusBar, BorderLayout.SOUTH);
		this.getContentPane().add(jPanel1, BorderLayout.CENTER);
		this.pack();
	}
	/** �˳��˵����¼� */
	public void exitActionPerformed(ActionEvent e) {
		// ��ͻ��˷��ͶϿ�������Ϣ
		sendMsgToClients(new StringBuffer(Message.QUIT_IDENTIFER));
		closeAll(); // �ر����е�����
		System.exit(0);
	}
	/** �����ڹر��¼� */
	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			exitActionPerformed(null);
		}
	}
	/** ˢ�������ң�����ˢ��clientProcessors���������µ��û��б� */
	public static void RefreshRoom() {
		StringBuffer people = new StringBuffer(Message.PEOPLE_IDENTIFER);
		for (int i = 0; i < clientProcessors.size(); i++) {
			MessFromClient c = clientProcessors.elementAt(i);
			people.append(Message.SEPERATOR).append(c.clientName);
		}
		// ��sendClients������ͻ��˷����û��б����Ϣ
		sendMsgToClients(people);
	}

	/** �����пͻ���Ⱥ����Ϣ */
	public static synchronized void sendMsgToClients(StringBuffer msg) {
		for (int i = 0; i < clientProcessors.size(); i++) {
			MessFromClient c = clientProcessors.elementAt(i);
			System.out.println("send msg: " + msg);
			c.send(msg);
		}
	}

	/** �ر��������� */
	public static void closeAll() {
		while (clientProcessors.size() > 0) {
			MessFromClient c = clientProcessors.firstElement();
			try {
				// �ر�socket���Ӻʹ����߳�
				c.socket.close();
				c.toStop();
			} catch (IOException e) {
				System.out.println("Error:" + e);
			} finally {
				clientProcessors.removeElement(c);
			}
		}
	}

	/**
	 * �жϿͻ����Ƿ�Ϸ��� ������ͬһ�ͻ����ظ���½����νͬһ�ͻ�����ָIP�����ֶ���ͬ��
	 */
	public static boolean isCheck(MessFromClient newclient) {
		if (clientProcessors.contains(newclient)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * �Ͽ�ĳ�����ӣ����Ҵ������б���ɾ��
	 */
	public static void disconnect(MessFromClient client) {
		disconnect(client, true);
	}

	/**
	 * �Ͽ�ĳ�����ӣ�����Ҫ������Ƿ�������б���ɾ��
	 */
	public static synchronized void disconnect(MessFromClient client,
			boolean toRemoveFromList) {
		try {
			// �ڷ������˳����list������ʾ�Ͽ���Ϣ
			connectInfoList.add(client.clientIP + "�Ͽ�����");
			BBSServer.activeConnects--; // ����������1
			String constr = "��ǰ����������" + BBSServer.activeConnects + "��";
			statusBar.setText(constr);
			// ��ͻ����ͶϿ�������Ϣ
			client.send(new StringBuffer(Message.QUIT_IDENTIFER));
			client.socket.close();
		} catch (IOException e) {
			System.out.println("Error:" + e);
		} finally {
			// ��clients������ɾ���˿ͻ������socket����Ϣ�� ��ֹͣ�̡߳�
			if (toRemoveFromList) {
				clientProcessors.removeElement(client);
				client.toStop();
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		BBSServer chatServer1 = new BBSServer();
		chatServer1.setVisible(true);
		System.out.println("Server starting ...");
		ServerSocket server = null;
		try {
			// �������˿�ʼ����
			server = new ServerSocket(Message.SERVER_PORT);
		} catch (IOException e) {
			System.out.println("Error:" + e);
			System.exit(1);
		}
		while (true) {
			// �����ǰ�ͻ�����С��MAX_CLIENT��ʱ������������
			if (clientProcessors.size() < Message.MAX_CLIENT) {
				Socket socket = null;
				try {
					// �յ��ͻ��˵�����
					socket = server.accept();
					if (socket != null) {
						System.out.println(socket + "����");
					}
				} catch (IOException e) {
					System.out.println("Error:" + e);
				}
				// ���岢ʵ����һ��ClientProcessor�߳��࣬���ڴ���ͻ��˵���Ϣ
				MessFromClient c = new MessFromClient(socket);
				if (isCheck(c)) {
					clientProcessors.addElement(c); // ��ӵ��б�
					int connum = ++BBSServer.activeConnects; // ����ͻ��˺Ϸ��������
					// ��״̬������ʾ������
					String constr = "��ǰ����������" + connum + "��";
					BBSServer.statusBar.setText(constr);
					// ���ͻ�socket��Ϣд��list��
					BBSServer.connectInfoList.add(c.clientIP + "����");
					c.start();
					RefreshRoom(); // ֪ͨ���пͻ����û��б����仯
				} else {
					// ����ͻ��˲��Ϸ�
					c.ps.println("�������ظ���½");
					disconnect(c, false);
				}
			} else {
				// ����ͻ��˳�����MAX_CLIENT������ȴ�һ��ʱ���ٳ��Խ�������
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

/**
 * ����ͻ��˷��͵�������߳�
 */
class MessFromClient extends Thread {
	Socket socket; // �洢һ�����ӿͻ��˵�socket��Ϣ
	String clientName; // �洢�ͻ��˵���������
	String clientIP; // �洢�ͻ��˵�ip��Ϣ
	BufferedReader br; // ����ʵ�ֽ��ܴӿͻ��˷�����������
	PrintStream ps; // ����ʵ����ͻ��˷�����Ϣ�Ĵ�ӡ��
	boolean running = true;
	/** ���췽�� */
	public MessFromClient(Socket s) {
		socket = s;
		try {
			// ��ʼ�����������
			br = new BufferedReader(new InputStreamReader(socket
					.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());
			// ��ȡ�յ�����Ϣ����һ����Ϣ�ǿͻ��˵����֡�IP��Ϣ
			String clientInfo = br.readLine();

			// ��ȡ��Ϣ��������Ϣ�ָ���������Ϣ
			StringTokenizer stinfo = new StringTokenizer(clientInfo,
					Message.SEPERATOR);
			String head = stinfo.nextToken();
			if (head.equals(Message.CONNECT_IDENTIFER)) {
				if (stinfo.hasMoreTokens()) {
					// �ؼ��ֺ�ĵڶ��������ǿͻ�����Ϣ
					clientName = stinfo.nextToken();
				}
				if (stinfo.hasMoreTokens()) {
					// �ؼ��ֺ�ĵ����������ǿͻ�ip��Ϣ
					clientIP = stinfo.nextToken();
				}
				System.out.println(head); // �ڿ���̨��ӡͷ��Ϣ
			}
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}
	}

	/** ��ͻ��˷�����Ϣ */
	public void send(StringBuffer msg) {
		ps.println(msg);
		ps.flush();
	}
	// �߳����з���
	@Override
	public void run() {
		while (running) {
			String line = null;
			try {
				// ��ȡ�ͻ��˷�����������
				line = br.readLine();
			} catch (IOException e) {
				System.out.println("Error" + e);
				BBSServer.disconnect(this);
				BBSServer.RefreshRoom();
				return;
			}
			// �ͻ����뿪
			if (line == null) {
				BBSServer.disconnect(this);
				BBSServer.RefreshRoom();
				return;
			}
			StringTokenizer st = new StringTokenizer(line, Message.SEPERATOR);
			String keyword = st.nextToken();
			// ����ؼ�����MSG���ǿͻ��˷�����������Ϣ
			if (keyword.equals(Message.MSG_IDENTIFER)) {
				StringBuffer msg = new StringBuffer(Message.MSG_IDENTIFER)
						.append(Message.SEPERATOR);
				msg.append(clientName);
				msg.append(st.nextToken("\0"));
				// �ٽ�ĳ���ͻ�������������Ϣ���͵�ÿ�����ӿͻ�����������
				BBSServer.sendMsgToClients(msg);

			} else if (keyword.equals(Message.QUIT_IDENTIFER)) {
				// ����ؼ�����QUIT���ǿͻ��˷����Ͽ����ӵ���Ϣ
				BBSServer.disconnect(this); // �������Ͽ�������ͻ�������
				// �������������Ҳ�ˢ�������ͻ�����������list
				BBSServer.RefreshRoom();
				running = false;
			}
		}
	}

	public void toStop() {
		running = false;
	}

	// ����Object���equals����
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MessFromClient) {
			MessFromClient obj1 = (MessFromClient) obj;
			if (obj1.clientIP.equals(this.clientIP)
					&& (obj1.clientName.equals(this.clientName))) {
				return true;
			}
		}
		return false;
	}

	// ����Object���hashCode����
	@Override
	public int hashCode() {
		return (this.clientIP + Message.SEPERATOR + this.clientName).hashCode();
	}
}