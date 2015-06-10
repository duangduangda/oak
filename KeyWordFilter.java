
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description 敏感字（关键字）过滤
 * @author duangduangda
 * @since 2014年12月30日
 */
public class KeyWordFilter {
	private static Pattern pattern = null;

	/**
	 * 
	 * @Description: 格式化输出词库
	 * @author duangduangda
	 * @since 2014年12月30日
	 */
	private static void initPattern() {
		StringBuffer patternBuf = new StringBuffer();
		InputStream in = null;
		BufferedReader bf = null;
		String filepath = "/util/keywords.properties";
		try {
			in = KeyWordFilter.class.getResourceAsStream(filepath);
			bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			Properties properties = new Properties();
			properties.load(in);
			Enumeration<?> enu = properties.propertyNames();
			while (enu.hasMoreElements()) {
				patternBuf.append((String) enu.nextElement()).append("|"); 
			}
			patternBuf.deleteCharAt(patternBuf.length() - 1);
			pattern = Pattern.compile(new String(patternBuf.toString()));
			if (null != in) {
				in.close();
			}
			if (null != bf) {
				bf.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: 对关键字或敏感词进行过滤
	 * @author duangduangda
	 * @since 2014年12月30日
	 * @param str
	 * @return
	 */
	public static String doFilter(String str) {
		try {
			if (StringUtils.isBlank(str)) {
				return str;
			}
			initPattern();
			if (null != pattern) {
				Matcher m = pattern.matcher(str);
				str = m.replaceAll("**");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 
	 * @Description: 敏感词或者关键字是否在词库中
	 * @author duangduangda
	 * @since 2014年12月30日
	 * @param str
	 * @return
	 */
	public static boolean hasKeywords(String str) {
		try {
			initPattern();
			if (null != pattern) {
				Matcher m = pattern.matcher(str);
				return m.find();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
