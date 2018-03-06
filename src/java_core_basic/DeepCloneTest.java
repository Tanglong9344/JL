package java_core_basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java_common.User;

/**
 * Deep clone using 'Serializable'
 *
 * @author tanglong
 *
 */
public class DeepCloneTest {
	public static void main(String[] args) {
		List<User> people = new ArrayList<User>();
		people.add(new User("XiaoLv"));
		people.add(new User("YangDun", 666, true));
		User user = new User("Tanglong", 18, true, people);
		System.out.println("User:\n" + user.toString());

		User userCopy = DeepClone.cloneTo(user);
		System.out.println("UserCopy:\n" + userCopy.toString());
	}
}

class DeepClone implements Serializable{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public static <T> T cloneTo(T obj) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		T copy = null;
		try {
			out = new ObjectOutputStream(baos);
			out.writeObject(obj);
			out.flush();
			in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
			copy = (T) in.readObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return copy;
	}
}