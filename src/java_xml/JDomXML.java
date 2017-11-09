/**
 * JDOM方式解析XML简化与XML的交互并且比使用DOM实现
 * 更快,仅使用具体类而不使用接口因此简化了API,并且易于使用
 * jdom-2.0.6.jar
 */

package java_xml;

import java.io.FileInputStream;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDomXML {
	private String fileName = "src/java_xml/poem.xml";
	Document document = null;

	public JDomXML(){
		try{
			SAXBuilder saxBuilder = new SAXBuilder();
			document = saxBuilder.build(new FileInputStream(fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * print XML info
	 */
	public void printMsg(){
		Element rootElement = document.getRootElement();
		System.out.println(rootElement.getName());
		// get children nodes as list
		List<Element> poemList = rootElement.getChildren();
		// print children elements info
		poemList.forEach(s->printElement(s));
	}

	/**
	 * print element info
	 * @param element
	 */
	public void printElement(Element e){
		// element name
		System.out.print(e.getName() + "\t");
		// print attributes
		List<Attribute> attributes = e.getAttributes();
		attributes.forEach(s->System.out.print(s.getName() + ":" + s.getValue() + "\t"));
		System.out.println();
		// print text that is empty
		if(!(e.getTextTrim().equals(""))){
			System.out.println(e.getTextTrim());
		}
		// loop for children nodes
		List<Element> poemList = e.getChildren();
		poemList.forEach(s->printElement(s));
	}

	// This is a test
	public static void main(String[] args) {
		new JDomXML().printMsg();
	}
}