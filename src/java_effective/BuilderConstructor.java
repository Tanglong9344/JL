package java_effective;

/**
 * �����߷�ʽʵ��������
 * @author ����
 */
public class BuilderConstructor {
	private String name;   //required
	private String sex;    //optional
	private String age;    //optional
	private String address;//optional

	public BuilderConstructor(Builder builder){
		this.name    = builder.name;
		this.sex     = builder.sex;
		this.age     = builder.age;
		this.address = builder.address;
	}

	@Override
	public String toString(){
		return "Name:" + name + ",Sex:" + sex + ",Age:" + age + ",Addr:" + address;
	}

	/**�ڲ�������*/
	public static class Builder{
		// required parameters
		private String name;
		// optional parameters, initialized to default values
		private String sex     = "δ֪";
		private String age     = "δ֪";
		private String address = "δ֪";

		/**set name*/
		public Builder(String name){
			this.name = name;
		}

		/**select sex*/
		public Builder sex(String sex){
			this.sex = sex;
			return this;
		}

		/**select age*/
		public Builder age(String age){
			this.age = age;
			return this;
		}

		/**select address*/
		public Builder address(String address){
			this.address = address;
			return this;
		}

		/**Instance for BuilderConstructor*/
		public BuilderConstructor build(){
			return new BuilderConstructor(this);
		}
	}
}