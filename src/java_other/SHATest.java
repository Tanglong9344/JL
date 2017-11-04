/**
 * SHA，全称为“Secure Hash Algorithm”，中文名“安全哈希算法”，
 * 主要适用于数字签名标准（Digital Signature Standard DSS）
 * 里面定义的数字签名算法（Digital Signature Algorithm DSA）
 * 对于长度小于 2^64 位的消息，SHA1 会产生一个 160 位的消息摘要。
 * 该算法的思想是接收一段明文，然后以一种不可逆的方式将它转换成一段
 * （通常更小）密文，也可以简单的理解为取一串输入码（称为预映射或信息），
 * 并把它们转化为长度较短、位数固定的输出序列即散列值的过程。
 */

package java_other;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHATest {
	/**
	 * SHA 加密
	 * @param s 需要加密的字符串
	 * @param choose 加密实例化的方式
	 * @return 加密之后的字符串
	 * @throws Exception
	 */
	public static String encryptSHA(String s,boolean choose) throws Exception {
		// 空值判断
		if(s.equals("") || null == s){
			return "";
		}
		//创建具有指定算法名称的信息摘要
		MessageDigest sha = null;
		if(choose){
			sha = MessageDigest.getInstance("SHA");
		}else{
			sha = MessageDigest.getInstance("SHA-1");
		}
		//使用指定的字节数组对摘要进行最后更新
		sha.update(s.getBytes());
		// 完成摘要计算
		return (new BigInteger(1,sha.digest()).toString(16));
	}

	// This is a test
	public static void main(String[] args) throws Exception {
		String key = "pwd123";
		System.out.println("SHA  :" + encryptSHA(key,true));
		System.out.println("SHA-1:" + encryptSHA(key,false));
	}
}