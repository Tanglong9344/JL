/*
 * SAX��ʽ����XML�����¼�����,��������,������ֻ����xml
 * ����,���ױ���,���Һ���ͬʱ����ͬһ���ĵ��еĶദ��ͬ����
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
	 * ��ʼ����xml�ĵ�ʱ���ô˷���
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("��ʼ����xml�ļ�");
	}

	/**
	 * �ĵ�������ɺ���ô˷���
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("xml�ļ��������");
	}

	/**
	 * ��ʼ�����ڵ�ʱ���ô˷���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri,localName,qName,attributes);
	}

	/**
	 *�ڵ�������ʱ���ô˷���
	 *@param qName �ڵ���
	 */
	@Override
	public void endElement(String uri,String localName,String qName) throws SAXException {
		super.endElement(uri, localName, qName);
	}

	/**
	 * �˷���������ȡ�ڵ��ֵ
	 */
	@Override
	public void characters(char[] ch,int start,int length) throws SAXException {
		super.characters(ch, start, length);
	}
}