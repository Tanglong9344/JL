package java_json;

public class Person {
	private String name    = "Tanglong";
	private String address = "HangZhou";
	private boolean isboy  = true;

	public Person(){};

	public Person(String name, boolean isboy){
		this.name = name;
		this.isboy = isboy;
	}

	public Person(String name,boolean isboy,String address){
		this(name, isboy);
		this.address = address;
	}

	@Override
	public String toString(){
		return String.format("[Name:%s,isboy:%s,Address:%s]",name,isboy,address);
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isIsboy() {
		return isboy;
	}

	public void setIsboy(boolean isboy) {
		this.isboy = isboy;
	}
}