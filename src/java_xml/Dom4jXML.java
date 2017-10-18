/**
 * DOM4j方式解析XML JDOM的一种智能分支,功能较强大，建议熟练使用
 * dom4j-1.6.1.jar
 */

package java_xml;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jXML {
	private String fileName = "XML/poem.xml";

	/**
	 * Dom4j Parse XML
	 */
	public Dom4jXML(){
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(fileName);
			Element poems = document.getRootElement();
			@SuppressWarnings("rawtypes")
			Iterator iterator = poems.elementIterator();
			while(iterator .hasNext()){
				System.out.println(iterator.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Dom4jXML();
	}
}