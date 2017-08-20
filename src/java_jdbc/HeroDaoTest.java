package java_jdbc;

import java.util.List;

public class HeroDaoTest {
	public static void main(String[] args) {
		HeroDAO hd = new HeroDAO();
		Hero h = new Hero();
		h.setName("曹操");
		h.setHp(1000);
		h.setDamage(10);
		//添加数据
		hd.add(h);
		//更新数据
		h.setId(3);
		hd.update(h);
		//删除数据
		hd.delete(2);
		//查询数据
		System.out.println("查询id=5的数据：");
		System.out.println(hd.get(5).getName());
		//获取数据列表
		System.out.println("获取数据列表：");
		List<Hero> list = hd.list();
		list.forEach(l->System.out.println(l.getName()));
	}
}
