package entity;

public class Reader {
	private String id;//���߱��
	private String name;//��������
	private String sex;//�Ա�
	private String type;//�������
	private String max_num;//���ɽ�����
	private int days_num;//���ɽ�����

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMax_num() {
		return max_num;
	}

	public void setMax_num(String max_num) {
		this.max_num = max_num;
	}

	public int getDays_num() {
		return days_num;
	}

	public void setDays_num(int days_num) {
		this.days_num = days_num;
	}
}