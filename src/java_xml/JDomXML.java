/**
 * JDOM��ʽ����XML����XML�Ľ������ұ�ʹ��DOMʵ��
 * ����,��ʹ�þ��������ʹ�ýӿ���˼���API,��������ʹ��
 * jdom-2.0.6.jar
 */

package java_xml;

import java.io.FileInputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDomXML {
	private String fileName = "XML/poem.xml";

	public JDomXML(){
		try{
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(new FileInputStream(fileName));
			//��ȡ���ڵ�bookstore
			Element rootElement = document.getRootElement();
			System.out.println("rootElement:"+rootElement);
			//��ȡ���ڵ���ӽڵ㣬�����ӽڵ������
			List<Element> poemList = rootElement.getChildren();
			poemList.forEach(s->System.out.println("s="+s));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JDomXML();
	}
}