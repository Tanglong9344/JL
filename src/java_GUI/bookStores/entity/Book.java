package java_GUI.bookStores.entity;

import java.sql.Date;

public class Book {
	private String id;//ͼ����
	private String name;//ͼ������
	private String type;//ͼ�����
	private String author;//����
	private String translator;//����
	private String publisher;//������
	private Date publish_time;//����ʱ��
	private int stock;//�������
	private double price;//�۸�

	//---------------- getter and setter ------------------------
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}