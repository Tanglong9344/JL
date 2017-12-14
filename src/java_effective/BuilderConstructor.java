package java_effective;

/**
 * 建造者方式实例化对象
 * @author 唐龙
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

	/**内部建造器*/
	public static class Builder{
		// required parameters
		private String name;
		// optional parameters, initialized to default values
		private String sex     = "未知";
		private String age     = "未知";
		private String address = "未知";

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