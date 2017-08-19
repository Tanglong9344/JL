package hibernate_annotation_test;

@MyEntity//实体
@MyTable(name="hero_")//对应表
public class MyAnnotationHeroTest {
	private int id;
	private String name;
	private int damage;
	private int armor;

	@MyId//主键
	@MyGeneratedValue(strategy = "identity")//增长策略
	@MyColumn("id_")//列名
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@MyColumn("name_")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@MyColumn("damage_")
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@MyColumn("armor_")
	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
}