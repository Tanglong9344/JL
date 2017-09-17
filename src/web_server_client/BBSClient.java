package web_server_client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * �����ң�Bulletin Board System���Ŀͻ��˳���GUI���档
 */
public class BBSClient extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// ��½�����ҵ����ֱ�ǩ�������
	JLabel nameLabel = new JLabel();
	JTextField nameTextField = new JTextField(15);
	// ���ӺͶϿ����ӵİ�ť
	JButton connectButton = new JButton();
	JButton disConnectButton = new JButton();
	JTextArea chatContentTextArea = new JTextArea(9, 30); // ���������ݵ��ı���
	JButton sendMsgButton = new JButton(); // ������Ϣ�İ�ť
	JTextField msgTextField = new JTextField(20); // ��Ϣ�����
	JLabel msglabel = new JLabel();
	java.awt.List peopleList = new java.awt.List(10); // �������û��б�
	/** ���¶������������������ */
	Socket soc = null;
	PrintStream ps = null;
	// �ͻ���������������Ϣ���߳�
	ListenClentThread listener = null;

	public BBSClient() {
		init();
	}

	// ��ʼ��ͼ�ν���
	public void init() {
		this.setTitle("��ӭ����������");

		// ��ʼ����ť�ͱ�ǩ
		nameLabel.setText("������");
		connectButton.setText("�� ¼");
		connectButton.addActionListener(this);
		disConnectButton.setText("�� ��");
		disConnectButton.addActionListener(this);
		// �����������ݲ��ɱ༭
		chatContentTextArea.setEditable(false);
		sendMsgButton.setText("������Ϣ");
		sendMsgButton.addActionListener(this);
		msgTextField.setText("");

		// panel1������������������������ť
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(nameLabel);
		panel1.add(nameTextField);
		panel1.add(connectButton);
		panel1.add(disConnectButton);

		// ���ڷ���������Ϣ��ʾ��������Ա�б�
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JScrollPane pane1 = new JScrollPane(chatContentTextArea);
		pane1.setBorder(
				new TitledBorder(BorderFactory.createEtchedBorder
						(Color.white, new Color(134, 134, 134)), "��������"));
		panel2.add(pane1);
		JScrollPane pane2 = new JScrollPane(peopleList);
		pane2.setBorder(
				new TitledBorder(BorderFactory.createEtchedBorder
						(Color.white, new Color(134, 134, 134)), "�����û�"));
		panel2.add(pane2);

		// ���ڷ��÷�����Ϣ����
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(msglabel);
		panel3.add(msgTextField);
		panel3.add(sendMsgButton);

		// �������ӵ�����
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel3, BorderLayout.SOUTH);
		this.pack();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** �ر������ҿͻ����¼� */
	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			// ����ǹر������ҿͻ��ˣ���Ͽ�����
			disconnect();
			dispose();
			System.exit(0);
		}
	}

	/** ����ť�¼� */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == connectButton) {
			// ���������Ӱ�ť
			if (soc == null) {
				try {
					// ʹ�ö˿�2525ʵ����һ�������׽���
					soc = new Socket(InetAddress.getLocalHost(), Message.SERVER_PORT);
					System.out.println(soc); // �ڿ���̨��ӡʵ�����Ľ��
					ps = new PrintStream(soc.getOutputStream());// ��psָ��soc�������
					// ����һ���ַ�����洢������Ϣ
					StringBuffer info = new StringBuffer(Message.CONNECT_IDENTIFER)
							.append(Message.SEPERATOR);
					// ����INFOΪ�ؼ����÷�����ʶ��Ϊ������Ϣ
					// ����name��ip��"��"�ֿ����ڷ������˽���һ��
					// StringTokenizer������ȡ����
					String userinfo = nameTextField.getText() + Message.SEPERATOR
							+ InetAddress.getLocalHost().getHostAddress();
					ps.println(info.append(userinfo));
					ps.flush();
					// ���ͻ����߳�ʵ������������
					listener = new ListenClentThread(this, nameTextField.getText(), soc);
					listener.start();
				} catch (IOException e) {
					System.out.println("Error:" + e);
					disconnect();
				}
			}
		} else if (source == disConnectButton) {
			// �������Ͽ����Ӱ�ť
			disconnect();
		} else if (source == sendMsgButton) {
			// ���������Ͱ�ť
			if (soc != null) {
				// ���岢ʵ����һ���ַ�����洢���͵�������Ϣ
				StringBuffer msg = new StringBuffer(Message.MSG_IDENTIFER).append(Message.SEPERATOR);
				// �ô�ӡ������������Ϣ
				ps.println(msg.append(msgTextField.getText()));
				ps.flush();
			}
		}
	}

	/** �Ͽ�������������� */
	public void disconnect() {
		if (soc != null) {
			try {
				// �ô�ӡ������QUIT��Ϣ֪ͨ�������Ͽ��˴�ͨ��
				ps.println(Message.QUIT_IDENTIFER);
				ps.flush();
				soc.close(); // �ر��׽���
				listener.toStop();
				soc = null;
			} catch (IOException e) {
				System.out.println("Error:" + e);
			}
		}
	}

	public static void main(String[] args) {
		BBSClient client = new BBSClient();
		client.setVisible(true);
	}

	/** �ͻ����߳�������������������������Ϣ */
	class ListenClentThread extends Thread {
		String name = null; // �洢�ͻ������Ӻ��name��Ϣ
		BufferedReader br = null; // �ͻ��˽��ܷ��������ݵ�������
		PrintStream ps = null; // ʵ�ִӿͻ��˷������ݵ��������Ĵ�ӡ��
		Socket socket = null; // �洢�ͻ��˵�socket��Ϣ
		BBSClient parent = null; // �洢��ǰ���е�ChatClientʵ��
		boolean running = true;
		// ���췽��
		public ListenClentThread(BBSClient p, String n, Socket s) {
			// ���ܲ���
			parent = p;
			name = n;
			socket = s;
			try {
				// ʵ��������������
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				ps = new PrintStream(s.getOutputStream());
			} catch (IOException e) {
				System.out.println("Error:" + e);
				parent.disconnect();
			}
		}
		// ֹͣ����
		public void toStop() {
			this.running = false;
		}

		// �߳����з���
		@Override
		public void run() {
			String msg = null;
			while (running) {
				msg = null;
				try {
					// ��ȡ�ӷ�������������Ϣ
					msg = br.readLine();
					System.out.println("receive msg: " + msg);
				} catch (IOException e) {
					System.out.println("Error:" + e);
					parent.disconnect();
				}
				// ����ӷ�������������ϢΪ����Ͽ��˴�����
				if (msg == null) {
					parent.listener = null;
					parent.soc = null;
					parent.peopleList.removeAll();
					running = false;
					return;
				}
				// ��StringTokenizer����ʵ�ֶ�ȡ�ֶ��ַ�
				StringTokenizer st = new StringTokenizer(msg, Message.SEPERATOR);
				// ��ȡ��Ϣͷ���ؼ�������ʶ���Ǻ�����Ϣ
				String keyword = st.nextToken();
				if (keyword.equals(Message.PEOPLE_IDENTIFER)) {
					// �����PEOPLE���Ƿ����������Ŀͻ�������Ϣ
					// ��Ҫ����ˢ�¿ͻ��˵��û��б�
					parent.peopleList.removeAll();
					// ����stȡ��Ŀǰ�����ӵĿͻ�
					while (st.hasMoreTokens()) {
						String str = st.nextToken();
						parent.peopleList.add(str);
					}

				} else if (keyword.equals(Message.MSG_IDENTIFER)) {
					// ����ؼ�����MSG���Ƿ�����������������Ϣ,
					// ��Ҫ����ˢ�¿ͻ���������Ϣ����ÿ���ͻ�������������ʾ����
					String usr = st.nextToken();
					parent.chatContentTextArea.append(usr);
					parent.chatContentTextArea.append(st.nextToken("\0"));
					parent.chatContentTextArea.append("\r\n");
				} else if (keyword.equals(Message.QUIT_IDENTIFER)) {
					// ����ؼ�����QUIT���Ƿ������رյ���Ϣ, �жϴ˴�����
					System.out.println("Quit");
					try {
						running = false;
						parent.listener = null;
						parent.soc.close();
						parent.soc = null;
					} catch (IOException e) {
						System.out.println("Error:" + e);
					} finally {
						parent.soc = null;
						parent.peopleList.removeAll();
					}
					break;
				}
			}
			// ����û��б�
			parent.peopleList.removeAll();
		}
	}

	/**
	 * ��Ϣ��
	 * @author ����
	 *
	 */
	class Message {
		public static final int SERVER_PORT = 2525;// �������Ķ˿ں�
		public static final int MAX_CLIENT = 10;//���ͻ���
		public static final String SEPERATOR = "��"; // ��Ϣ��ʶ������Ϣ��֮��ķָ���
		public static final String MSG_IDENTIFER = "MSG"; // ��Ϣ��Ϣ�ı�ʶ��
		public static final String PEOPLE_IDENTIFER = "PEOPLE"; // �û��б���Ϣ�ı�ʶ��
		public static final String CONNECT_IDENTIFER = "INFO"; // ���ӷ�������Ϣ�ı�ʶ��
		public static final String QUIT_IDENTIFER = "QUIT"; // �˳���Ϣ��ʶ��
	}
}