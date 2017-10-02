package java_GUI.bookStores.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java_GUI.bookStores.entity.Book;

public class BookDao {
	//����ͼ���ţ���õ���ͼ��ʵ��
	public static Book selectBook(String id) {
		String sql = "select * from book where id='" + id +"' ";
		ResultSet rs = BaseDao.executeQuery(sql);
		Book book = null;
		try {
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getString("id"));//ͼ����
				book.setType(rs.getString("type"));//ͼ������
				book.setName(rs.getString("name"));//ͼ�����
				book.setAuthor(rs.getString("author"));//����
				book.setTranslator(rs.getString("translator"));//����
				book.setPublisher(rs.getString("publisher"));//������
				book.setPublish_time(rs.getDate("publish_time"));//����ʱ��
				book.setPrice(rs.getDouble("price"));//�������
				book.setStock(rs.getInt("stock"));//�۸�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return book;
	}

	//�������sql����ͼ��ʵ���б�
	public static List<Book> selectBookList(String sql) {
		List<Book> list = new ArrayList<Book>();
		ResultSet rs = BaseDao.executeQuery(sql);
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("id"));//ͼ����
				book.setType(rs.getString("type"));//ͼ������
				book.setName(rs.getString("name"));//ͼ�����
				book.setAuthor(rs.getString("author"));//����
				book.setTranslator(rs.getString("translator"));//����
				book.setPublisher(rs.getString("publisher"));//������
				book.setPublish_time(rs.getDate("publish_time"));//����ʱ��
				book.setPrice(rs.getDouble("price"));//�������
				book.setStock(rs.getInt("stock"));//�۸�
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}