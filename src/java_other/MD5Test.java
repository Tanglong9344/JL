/**
 * digest()方法返回字符串s的md5哈希值，是16位 的十六进制（相当于8个字符）
 * BigInteger将8个字符构成的字符串转换成16位的十六进制， 并用字符串来表示，
 * 从而得到字符串形式的哈希值
 */

package java_other;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Test {
	/**
	 * MD5 加密
	 * @param s 待加密字符串
	 * @return 加密后的字符串
	 */
	public static String makeMD5(String s) {
		// 空值判断
		if(s.equals("") || null == s){
			return "";
		}
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			return (new BigInteger(1,md.digest()).toString(16));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	//test
	public static void main(String[] args) {
		String password = "pwd123";
		System.out.println("密码‘" + password + "’经过MD5加密后为：\n" + makeMD5(password));
	}
}