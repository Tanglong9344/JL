/**
 * ��ȡ��ǰ�����ID
 */

package design_mode;

public class ObjectSimplify {
	static String getObjectId(Object o){
		String dest=o.toString();
		String[] strs=dest.split("\\.");//���ա�.���ָ�
		return strs[strs.length-1];//���ض���ID
	}
}
