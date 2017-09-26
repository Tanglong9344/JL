package java_GUI.bookStores.entity;

import java.util.Date;

public class Borrow {
	private int id;//借书表主键
	private String book_id;//借书的id
	private String reader_id;//读者id
	private Date borrowDate;//借书日期
	private Date backDate;//还书日期
	private int is_back;//是否归还

	//---------------- getter and setter ------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getReader_id() {
		return reader_id;
	}

	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}

	public int getIs_back() {
		return is_back;
	}

	public void setIs_back(int is_back) {
		this.is_back = is_back;
	}
}