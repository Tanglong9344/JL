package java_yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.ho.yaml.Yaml;

/**
 * Yaml in java(JYaml)
 * url: http://jyaml.sourceforge.net/tutorial.html
 *
 * @author ÌÆÁú
 */
public class JYamlTest {
	public static void main(String[] args) throws FileNotFoundException {
		// read from yaml file
		Map<?, ?> mr = (Map<?, ?>) Yaml.load(new File("src/java_yaml/yaml_read.yml"));
		System.out.println(mr);

		// write into yaml file
		Map<String, Object> mw = new HashMap<String, Object>();
		mw.put("new_k1", "new_v1");
		mw.put("new_k2", new String[] {"new_v21", "new_v22", "new_v23"});
		Yaml.dump(mw, new File("src/java_yaml/yaml_write.yml"));
	}
}