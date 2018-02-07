package java_nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java NIO
 *
 * @author ÌÆÁú
 *
 */
public class NIO {
	public static void main(String[] args) {
		Path resource = Paths.get("file");
		System.out.println(resource);
	}
}