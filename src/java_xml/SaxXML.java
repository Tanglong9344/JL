/*
 * SAX��ʽ����XML�����¼�����,��������,������ֻ����xml
 * ����,���ױ���,���Һ���ͬʱ����ͬһ���ĵ��еĶദ��ͬ����
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
	 * ��ʼ����xml�ĵ�ʱ���ô˷���
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("Start to Parse xml:");
	}

	/**
	 * �ĵ�������ɺ���ô˷���
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("Parse xml end.");
	}

	/**
	 * ��ʼ�����ڵ�ʱ���ô˷���
	 */
	@Override
	public void startElement(String uri,String localName,String qName,Attributes attributes) throws SAXException {
		super.startElement(uri,localName,qName,attributes);

		if(qName.equals("poems")) {
			System.out.println("Poems start:");
		}else if(qName.equals("poem")) {
			System.out.println("A Poem start:");
		}else {
			System.out.println("Node Name��" + qName);
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
	 *�ڵ�������ʱ���ô˷���
	 *@param qName �ڵ���
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
	 * �˷���������ȡ�ڵ��ֵ
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