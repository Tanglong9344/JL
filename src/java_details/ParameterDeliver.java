package java_details;

import java_common.User;

/**
 * Java paramters deliver: a copy of the reference
 *
 * @author tanglong
 *
 */
public class ParameterDeliver {
	public static void main(String[] args) {
		User user = new User("Tanglong");
		System.out.println("Before testFun  : " + user.getName());
		User newUser = (User) testFunc(user);
		System.out.println("testFun         : " + newUser.getName());
		System.out.println("After testFun   : " + user.getName());

		user.setName("longTang");
		System.err.println("Changed, user   : " + user.getName());
		System.err.println("Changed, newUser: " + newUser.getName());
	}

	/** test function */
	private static Object testFunc(Object obj) {
		User user = null;
		if(obj instanceof User) {
			user = (User)obj;
			user.setName("New Name");
		}
		return user;
	}
}