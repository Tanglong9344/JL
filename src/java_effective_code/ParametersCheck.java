package java_effective_code;

/**
 * ²ÎÊý¼ì²é
 *
 * @author ÌÆÁú
 *
 */
public class ParametersCheck {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};

		System.out.println(sumException(arr,2,20));
		System.out.println(sumAssert(arr,2,2));
	}

	/**parametes check using Exception*/
	private static int sumException(int[] arr, int offset, int length) {
		if(arr == null) {
			throw new NullPointerException("arr is null!");
		}
		if(offset <0 || offset > arr.length) {
			throw new IndexOutOfBoundsException("offset : " + offset);
		}
		if(length <0 || length > arr.length - offset) {
			throw new IllegalArgumentException("length : " + length + " exceed " + (arr.length - offset));
		}

		int sum = 0;
		for(int i=offset,len=offset+length;i<len;i++) {
			sum += arr[i];
		}
		return sum;
	}

	/**parametes check using assertion(must be started before using)*/
	private static int sumAssert(int[] arr, int offset, int length) {
		assert arr != null;
		assert offset >=0 && offset <= arr.length;
		assert length >=0 && length <= arr.length - offset;

		int sum = 0;
		for(int i=offset,len=offset+length;i<len;i++) {
			sum += arr[i];
		}
		return sum;
	}
}