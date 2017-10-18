/**
 * DOM��ʽ����XML Dom�����ǽ�xml�ļ�ȫ�����뵽�ڴ�,
 * ��װ��һ��dom����mȻ��ͨ���ڵ��Լ��ڵ�֮��Ĺ�ϵ������
 * xml�ļ�,��ƽ̨�޹�,java�ṩ��һ�ֻ����Ľ���XML�ļ�
 * ��API,���ϼ򵥣��������������ĵ�����Ҫ�����ڴ�,����
 * �����ĵ��ϴ�ʱ��
 */

package java_xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DomXML {
	private String fileName = "XML/poem.xml";
	private Document doc = null;

	/**
	 * xml�ĵ�����
	 */
	public DomXML() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//DOM ������
			DocumentBuilder builder = factory.newDocumentBuilder();
			//�ĵ�����
			doc = builder.parse(fileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ӡxml�ĵ���Ϣ
	 */
	public void printMsg() {
		try {
			//���ݱ�ǩ����ȡ�ڵ��б�
			NodeList poems = doc.getElementsByTagName("poem");
			if(null != poems) {
				//�����ڵ�
				for(int i=0;i<poems.getLength();i++) {
					Node poem = poems.item(i);
					String author = poem.getAttributes().getNamedItem("author").getNodeValue();
					String address = poem.getAttributes().getNamedItem("address").getNodeValue();
					NodeList poemInfo = poem.getChildNodes();
					String title = null;
					String description = null;
					//�����ӽڵ�
					for(int j=0;j<poemInfo.getLength();j++) {
						//��ȡ�����ı�ֵ
						if(poemInfo.item(j).getNodeName().equalsIgnoreCase("title")) {
							title = poemInfo.item(j).getTextContent();
						}
						//��ȡ�����ı�ֵ
						else if(poemInfo.item(j).getNodeName().equalsIgnoreCase("description")) {
							description = poemInfo.item(j).getTextContent();
						}
					}
					System.out.println("\n\t" + title);
					System.out.print("\t" + author + " " + address);
					System.out.println(description);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���xmlʫ����Ϣ
	 */
	public int addPoem(String author,String address,String titleText,String descriptionText) {
		//�Ƿ���ڼ��
		//���ݱ�ǩ����ȡ�ڵ��б�
		NodeList poems = doc.getElementsByTagName("poem");
		if(null != poems) {
			//�����ڵ�
			for(int i=0;i<poems.getLength();i++) {
				Node poemExisted = poems.item(i);
				NodeList poemInfo = poemExisted.getChildNodes();
				//�����ӽڵ�
				for(int j=0;j<poemInfo.getLength();j++) {
					//��ȡ�����ı�ֵ
					if(poemInfo.item(j).getNodeName().equalsIgnoreCase("title")) {
						String title = poemInfo.item(j).getTextContent();
						if(titleText.equalsIgnoreCase(title)) {
							System.out.println("'" + title + "'" + "�Ѵ��ڣ�");
							return -1;
						}
					}
				}
			}
		}
		//д��XML��Ϣ
		try {
			//��ȡ��Ԫ��
			Element root = doc.getDocumentElement();
			//����ʫ��Ԫ��
			Element poem = doc.createElement("poem");
			//��Ԫ�����
			root.appendChild(poem);
			//����Ԫ������
			poem.setAttribute("author", author);
			poem.setAttribute("address", address);

			//����
			Element title = doc.createElement("title");
			//��������
			Text title_text = doc.createTextNode(titleText);
			title.appendChild(title_text);
			poem.appendChild(title);

			//����
			Element description = doc.createElement("description");
			//��������
			Text description_text = doc.createTextNode(descriptionText);
			description.appendChild(description_text);
			poem.appendChild(description);

			//DOM�ĵ�
			Source source = new DOMSource(doc);
			//�ĵ����Ŀ���ַ
			File file = new File(fileName);
			Result result = new StreamResult(file);
			//DOM�ĵ�д��
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			return 1;
		}catch(TransformerConfigurationException e){
			System.err.println("xml��Ϣת�����ô���"+e.getMessage());
			return -2;
		}catch(TransformerException e) {
			System.err.println("xml��Ϣת������"+e.getMessage());
			return -3;
		}
	}

	//���������
	public static void main(String[] args) {
		DomXML app = new DomXML();
		//���һ�״���
		//��ӳɹ������ʫ����Ϣ
		if(1 == app.addPoem("�Ÿ�", "��", "����",
				"\n\t����ɽ���ڣ��Ǵ���ľ�\n"
						+ "\t��ʱ�����ᣬ�ޱ����ġ�\n"
						+ "\t��������£���������\n"
						+ "\t��ͷɦ���̣�������ʤ����")){
			app.printMsg();
		}
		//���һ�׳���
		//��ӳɹ������ʫ����Ϣ
		if(1 == app.addPoem("ë��", "�й�", "����",
				"\n\t�������Զ���ѣ� ��ˮǧɽֻ���� ��\n"
						+ "\t����������ϸ�ˣ� ���ɰ��������衣\n"
						+ "\t��ɳˮ������ů�� ����ź���������\n"
						+ "\t��ϲ�ɽǧ��ѩ�� �������󾡿��� ��")){
			app.printMsg();
		}
		app.printMsg();
	}
}