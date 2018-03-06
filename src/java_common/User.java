package java_common;

import java.io.Serializable;
import java.util.List;

/**
 * User class
 * 1. name
 * 2. age
 * 3. sex
 * 4. friends
 *
 * @author tanglong
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name = null;
	private int age  = 18;
	private boolean sex = false; // true: boy, false: girl
	private List<User> friends = null;

	public User(String name) {
		this.name = name;
	}

	public User(String name, int age) {
		this(name);
		this.age = age;
	}

	public User(String name, int age, boolean sex) {
		this(name, age);
		this.sex = sex;
	}

	public User(String name, int age, boolean sex, List<User> people) {
		this(name, age, sex);
		this.friends = people;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name + "\n");
		sb.append("Age: "  + age  + "\n");

		String str = sex ? "boy" : "girl";
		sb.append("sex: "  + str  + "\n");
		if(friends != null) {
			sb.append("Friends:\n");
			sb.append("------------------\n");
			friends.forEach(f->sb.append(f + ",\n"));
			sb.append("------------------\n");
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		User user = null;
		if(obj instanceof User) {
			user = (User)obj;
		}
		return name.equals(user.name)
				&& age == user.age
				&& sex == user.sex
				&& compare(user);
	}

	private boolean compare(User user) {
		System.out.println("Friends: " + friends);
		if(friends == null) {
			return false;
		}
		for(int i=0;i<friends.size();i++) {
			if(!friends.get(i).equals(user.friends.get(i))) {
				return false;
			}
		}
		return true;
	}
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
}