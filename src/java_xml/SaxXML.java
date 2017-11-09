/*
 * SAX方式解析XML基于事件驱动,逐条解析,适用于只处理xml
 * 数据,不易编码,而且很难同时访问同一个文档中的多处不同数据
 */

package java_xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXML{
	private static String fileName = "src/java_xml/poem.xml";
	private static SAXParser parser = null;
	private static SaxParseHandle handle= null;

	public SaxXML(){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			parser = factory.newSAXParser();
			handle = new SaxParseHandle();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	// This is a test
	public static void main(String[] args) {
		// Initialization
		new SaxXML();
		try {
			parser.parse(fileName,handle);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Sax Parse XML Handle
 */
class SaxParseHandle extends DefaultHandler{
	/**
	 * 开始解析xml文档时调用此方法
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Start to Parse xml:");
	}

	/**
	 * 文档解析完成后调用此方法
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("Parse xml end.");
	}

	/**
	 * 开始解析节点时调用此方法
	 */
	@Override
	public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException {
		super.startElement(uri,localName,qName,attributes);

		if(qName.equals("poems")) {
			System.out.println("Poems start:");
		}else if(qName.equals("poem")) {
			System.out.println("A Poem start:");
		}else {
			System.out.println("Node Name：" + qName);
		}
		// get attribute name
		int len = attributes.getLength();
		if(len>0){
			for(int i=0;i<len;i++){
				System.out.print(attributes.getQName(i) + ":");
				System.out.print(attributes.getValue(i) + "\t");
			}
			System.out.println();
		}
	}

	/**
	 *节点解析完毕时调用此方法
	 *@param qName 节点名
	 */
	@Override
	public void endElement(String uri,String localName,String qName) throws SAXException {
		super.endElement(uri,localName,qName);
		if(qName.equals("poems")) {
			System.out.println("Poems end.");
		}else if(qName.equals("poem")) {
			System.out.println("A Poem end.");
		}
	}

	/**
	 * 此方法用来获取节点的值
	 */
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException {
		super.characters(ch,start,length);
		String nodeValue = new String(ch,start,length);
		if(!nodeValue.trim().equals("")){
			System.out.println("Node Value:"+nodeValue);
		}
	}
}