/**
 * DOM4j方式解析XML 是JDOM的一种智能分支
 *
 * 需要jar：dom4j-1.6.1.jar
 */

package java_xml;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jXML {
	private String fileName = "XML/poem.xml";
	private Document document = null;

	/**
	 * Dom4j Parse XML
	 */
	public Dom4jXML(){
		try {
			SAXReader reader = new SAXReader();
			document = reader.read(fileName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * print XML info
	 */
	public void printMsg(){
		Element poems = document.getRootElement();
		printElement(poems);
	}

	/**
	 * look through element
	 * @param element
	 */
	@SuppressWarnings("rawtypes")
	public void printElement(Element element){
		//get elements
		Iterator iterator = element.elementIterator();
		while(iterator .hasNext()){
			Element poElement = (Element) iterator.next();
			System.out.print(poElement.getName() + "\t");
			// get attributes
			Iterator iteratorAttr = poElement.attributeIterator();
			while(iteratorAttr.hasNext()){
				Attribute attr = (Attribute) iteratorAttr.next();
				System.out.print(attr.getName() + ":");
				System.out.print(attr.getData()+"\t");
			}
			// get text
			if(!(poElement.getTextTrim().equals(""))){
				System.out.print(poElement.getText());
			}
			System.out.println();
			// loop
			printElement(poElement);
		}
	}

	//test
	public static void main(String[] args) {
		new Dom4jXML().printMsg();
	}
}