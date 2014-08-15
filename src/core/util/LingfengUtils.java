package core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.math.RandomUtils;

import sun.misc.BASE64Encoder;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public class LingfengUtils {

	public static String base64EncodeImage(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	public static String getRandomString(int i) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < i; j++) {
			sb.append(String.valueOf(RandomUtils.nextInt(10)));
		}
		return sb.toString();
	}

	public static String stringFilter(String str) throws PatternSyntaxException {
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

}
