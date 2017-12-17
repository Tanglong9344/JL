package java_annotation;

@MyEntity
@MyTable(name="hero_")
/**
 * Annotation Class to test Annotation
 *
 * @author ÌÆÁú
 *
 */
public class MyAnnotation {
	/**the first char can not be in upper case*/
	private int id;
	private String name;
	private String age;
	private String addreSS;

	@MyId
	@MyGenerate(strategy = "identity")
	@MyColumn("id_")
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

	@MyColumn("age_")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@MyColumn("address_")
	public String getAddreSS() {
		return addreSS;
	}

	public void setAddreSS(String addreSS) {
		this.addreSS = addreSS;
	}
}