/**
 * JDOM方式解析XML简化与XML的交互并且比使用DOM实现
 * 更快,仅使用具体类而不使用接口因此简化了API,并且易于使用
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
			//获取根节点bookstore
			Element rootElement = document.getRootElement();
			System.out.println("rootElement:"+rootElement);
			//获取根节点的子节点，返回子节点的数组
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