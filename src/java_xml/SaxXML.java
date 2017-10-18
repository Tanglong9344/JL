/*
 * SAX方式解析XML基于事件驱动,逐条解析,适用于只处理xml
 * 数据,不易编码,而且很难同时访问同一个文档中的多处不同数据
 */

package java_xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXML {
	public static void main(String[] args) {

	}
}

/**
 * Sax Parse XML
 */
class SAXParseHandler extends DefaultHandler {

	/**
	 * 开始解析xml文档时调用此方法
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("开始解析xml文件");
	}

	/**
	 * 文档解析完成后调用此方法
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("xml文件解析完毕");
	}

	/**
	 * 开始解析节点时调用此方法
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri,localName,qName,attributes);
	}

	/**
	 *节点解析完毕时调用此方法
	 *@param qName 节点名
	 */
	@Override
	public void endElement(String uri,String localName,String qName) throws SAXException {
		super.endElement(uri, localName, qName);
	}

	/**
	 * 此方法用来获取节点的值
	 */
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException {
		super.characters(ch, start, length);
	}
}