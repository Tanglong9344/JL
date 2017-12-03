package java_input_output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 1.ʹ��<code>transient</code>������Ҫimplement java.io.Serializable
 * 2.��<code>transient</code>���ε����Բ��ᱻ���л�
 * 3.��<code>static</code>���ε����Բ��ᱻ���л�
 * @author ����
 */
public class TransientTest {
	public static void main(String[] args) {
		TransientClass trc = new TransientClass();
		//���л�ǰ������
		TransientClass.setId("001");
		trc.setName("Tanglong");
		trc.setPassword("password");
		System.out.println("Before Serializable: ");
		System.out.println(trc.toString());
		System.out.println("----------------------------");

		String fileName = "src/java_input_output/transientClass.txt";

		// write
		try {
			FileOutputStream fos = new FileOutputStream(fileName);//�ļ������
			ObjectOutputStream os = new ObjectOutputStream(fos);//���������
			os.writeObject(trc); // ��trc����д���ļ�
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**update the static variable id
		 * to indicate id is not from serialized file but the data segment*/
		TransientClass.setId("002");

		// read
		try {
			FileInputStream fis = new FileInputStream(fileName);//�ļ�������
			ObjectInputStream is = new ObjectInputStream(fis);//����������
			trc = (TransientClass) is.readObject();//�����ж�ȡTransientClass������
			is.close();
			System.out.println("After Serializable: ");
			System.out.println(trc.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/**
 * The class that implements java.io.Serializable
 * and has static and transient.
 */
class TransientClass implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private static String id;
	private String name;
	private transient String password;

	@Override
	public String toString(){
		return "id:"+id+",name:"+name+",password:"+password;
	}

	// getter and setter
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		TransientClass.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}