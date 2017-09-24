package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class BookDao {
	//根据图书编号，获得单个图书实体
	public static Book selectBook(String id) {
		String sql = "select * from book where id='" + id +"' ";
		ResultSet rs = BaseDao.executeQuery(sql);
		Book book = null;
		try {
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getString("id"));//图书编号
				book.setType(rs.getString("type"));//图书名称
				book.setName(rs.getString("name"));//图书类别
				book.setAuthor(rs.getString("author"));//作者
				book.setTranslator(rs.getString("translator"));//译者
				book.setPublisher(rs.getString("publisher"));//出版社
				book.setPublish_time(rs.getDate("publish_time"));//出版时间
				book.setPrice(rs.getDouble("price"));//库存数量
				book.setStock(rs.getInt("stock"));//价格
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return book;
	}

	//获得满足sql语句的图书实体列表
	public static List<Book> selectBookList(String sql) {
		List<Book> list = new ArrayList<Book>();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("id"));//图书编号
				book.setType(rs.getString("type"));//图书名称
				book.setName(rs.getString("name"));//图书类别
				book.setAuthor(rs.getString("author"));//作者
				book.setTranslator(rs.getString("translator"));//译者
				book.setPublisher(rs.getString("publisher"));//出版社
				book.setPublish_time(rs.getDate("publish_time"));//出版时间
				book.setPrice(rs.getDouble("price"));//库存数量
				book.setStock(rs.getInt("stock"));//价格
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}