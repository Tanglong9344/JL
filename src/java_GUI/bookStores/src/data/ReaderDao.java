package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Reader;

public class ReaderDao {
	//根据读者编号，获得单个读者实体
	public static Reader selectReader(String id) {
		String sql = "select * from reader where id='" + id +"' ";
		ResultSet rs = BaseDao.executeQuery(sql);
		Reader reader = null;
		try {
			if (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getString("id"));//读者编号
				reader.setType(rs.getString("type"));//读者姓名
				reader.setName(rs.getString("name"));//性别
				reader.setSex(rs.getString("sex"));//读者类别
				reader.setMax_num(rs.getString("max_num"));//最多可借数量
				reader.setDays_num(rs.getInt("days_num"));//最大可借天数
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return reader;
	}

	//获得满足sql语句的读者实体列表
	public static List<Reader> selectReaderList(String sql) {
		List<Reader> list = new ArrayList<Reader>();
		ResultSet rs = BaseDao.executeQuery(sql);
		Reader reader = null;
		try {
			while (rs.next()) {
				reader = new Reader();
				reader.setId(rs.getString("id"));//读者编号
				reader.setType(rs.getString("type"));//读者姓名
				reader.setName(rs.getString("name"));//性别
				reader.setSex(rs.getString("sex"));//读者类别
				reader.setMax_num(rs.getString("max_num"));//最多可借数量
				reader.setDays_num(rs.getInt("days_num"));//最大可借天数
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseDao.close();
		return list;
	}
}