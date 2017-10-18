/**
 * DOM方式解析XML Dom解析是将xml文件全部载入到内存,
 * 组装成一颗dom树，m然后通过节点以及节点之间的关系来解析
 * xml文件,与平台无关,java提供的一种基础的解析XML文件
 * 的API,理解较简单，但是由于整个文档都需要载入内存,不适
 * 用于文档较大时。
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
	 * xml文档解析
	 */
	public DomXML() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//DOM 解析器
			DocumentBuilder builder = factory.newDocumentBuilder();
			//文档解析
			doc = builder.parse(fileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印xml文档信息
	 */
	public void printMsg() {
		try {
			//根据标签名获取节点列表
			NodeList poems = doc.getElementsByTagName("poem");
			if(null != poems) {
				//遍历节点
				for(int i=0;i<poems.getLength();i++) {
					Node poem = poems.item(i);
					String author = poem.getAttributes().getNamedItem("author").getNodeValue();
					String address = poem.getAttributes().getNamedItem("address").getNodeValue();
					NodeList poemInfo = poem.getChildNodes();
					String title = null;
					String description = null;
					//遍历子节点
					for(int j=0;j<poemInfo.getLength();j++) {
						//获取标题文本值
						if(poemInfo.item(j).getNodeName().equalsIgnoreCase("title")) {
							title = poemInfo.item(j).getTextContent();
						}
						//获取内容文本值
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
	 * 添加xml诗词信息
	 */
	public int addPoem(String author,String address,String titleText,String descriptionText) {
		//是否存在检测
		//根据标签名获取节点列表
		NodeList poems = doc.getElementsByTagName("poem");
		if(null != poems) {
			//遍历节点
			for(int i=0;i<poems.getLength();i++) {
				Node poemExisted = poems.item(i);
				NodeList poemInfo = poemExisted.getChildNodes();
				//遍历子节点
				for(int j=0;j<poemInfo.getLength();j++) {
					//获取标题文本值
					if(poemInfo.item(j).getNodeName().equalsIgnoreCase("title")) {
						String title = poemInfo.item(j).getTextContent();
						if(titleText.equalsIgnoreCase(title)) {
							System.out.println("'" + title + "'" + "已存在！");
							return -1;
						}
					}
				}
			}
		}
		//写入XML信息
		try {
			//获取根元素
			Element root = doc.getDocumentElement();
			//创建诗词元素
			Element poem = doc.createElement("poem");
			//子元素添加
			root.appendChild(poem);
			//设置元素属性
			poem.setAttribute("author", author);
			poem.setAttribute("address", address);

			//标题
			Element title = doc.createElement("title");
			//标题内容
			Text title_text = doc.createTextNode(titleText);
			title.appendChild(title_text);
			poem.appendChild(title);

			//描述
			Element description = doc.createElement("description");
			//标题内容
			Text description_text = doc.createTextNode(descriptionText);
			description.appendChild(description_text);
			poem.appendChild(description);

			//DOM文档
			Source source = new DOMSource(doc);
			//文档输出目标地址
			File file = new File(fileName);
			Result result = new StreamResult(file);
			//DOM文档写入
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			return 1;
		}catch(TransformerConfigurationException e){
			System.err.println("xml信息转换配置错误："+e.getMessage());
			return -2;
		}catch(TransformerException e) {
			System.err.println("xml信息转换错误："+e.getMessage());
			return -3;
		}
	}

	//主程序测试
	public static void main(String[] args) {
		DomXML app = new DomXML();
		//添加一首春望
		//添加成功则输出诗词信息
		if(1 == app.addPoem("杜甫", "唐", "春望",
				"\n\t国破山河在，城春草木深。\n"
						+ "\t感时花溅泪，恨别鸟惊心。\n"
						+ "\t烽火连三月，家书抵万金。\n"
						+ "\t白头搔更短，浑欲不胜簪。")){
			app.printMsg();
		}
		//添加一首长征
		//添加成功则输出诗词信息
		if(1 == app.addPoem("毛泽东", "中国", "长征",
				"\n\t红军不怕远征难， 万水千山只等闲 。\n"
						+ "\t五岭逶迤腾细浪， 乌蒙磅礴走泥丸。\n"
						+ "\t金沙水拍云崖暖， 大渡桥横铁索寒。\n"
						+ "\t更喜岷山千里雪， 三军过后尽开颜 。")){
			app.printMsg();
		}
		app.printMsg();
	}
}