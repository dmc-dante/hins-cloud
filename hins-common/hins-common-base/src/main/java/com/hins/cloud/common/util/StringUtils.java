package com.hins.cloud.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
	/**
	 * 防止sql注入的敏感词
	 */
	public static final String[] SqlStr1 = {"and", "exec", "execute", "insert", "select", "delete", "update", "count", "drop", "chr", "mid", "master", "truncate", "char",
		"declare", "sitename", "net user", "xp_cmdshell", "like", "and", "exec", "execute", "insert", "create", "drop", "table", "from", "grant", "use", "group_concat",
		"column_name", "information_schema.columns", "table_schema", "union", "where", "select", "delete", "update", "order", "by", "count", "chr", "mid", "master",
		"truncate", "char", "declare", "or"};
	/**
	 * 防止sql注入的敏感词特殊字符
	 */
	public static final String[] SqlStr2 = {"*", "'", ";", "--", "+", "//", "/", "%", "#"};//特殊字符
	public static final String[] SqlStrRegx = {"[*]", "'", ";", "--", "[+]", "//", "/", "%", "#"};//特殊字符

	/**
	 * 传入字符串是否只包含中文字
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isChinese(String s) {
		return StringUtils.matches(s, "^[\u4e00-\u9fa5]+$");
	}

	/**
	 * 检查是否标准的中国人身份证号码<br />
	 * 15位或者18位
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isChineseIdCard(String s) {
		return StringUtils
			.matches(s,
				"^(([1-9]\\d{7}((0[1-9])|(1[0-2]))((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))\\d{3})|([1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(1[0-2]))((0[1-9])|(1[0-9])|(2[0-9])|(3[0-1]))\\d{3}[0-9Xx]))$");
	}

	/**
	 * 传入的字符串是否符合标准的域名格式
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isDomain(String s) {
		return StringUtils.matches(s, "^[A-Za-z0-9]([A-Za-z0-9\\-]{0,61}[A-Za-z0-9])?\\.([A-Za-z0-9]([A-Za-z0-9\\-]{0,61}[A-Za-z0-9])?\\.){0,10}[A-Za-z]{1,4}$");
	}

	/**
	 * 传入字符串是否只包含双字节字符，中文也在内
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isDoubleByte(String s) {
		return StringUtils.matches(s, "^[^x00-xff]+$");
	}

	/**
	 * 传入字符串是否符合email地址格式
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isEmail(String s) {
		return StringUtils.matches(s,
			"^[A-Za-z0-9][A-Za-z0-9_\\.]*[A-Za-z0-9]@[A-Za-z0-9]([A-Za-z0-9\\-]{0,61}[A-Za-z0-9])?\\.([A-Za-z0-9]([A-Za-z0-9\\-]{0,61}[A-Za-z0-9])?\\.){0,10}[A-Za-z]{1,4}$");
	}

	/**
	 * 传入字符串是否以空格结束
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isEndBlank(String s) {
		return StringUtils.matches(s, ".*\\s$");
	}

	/**
	 * 检查是否只包含英文字符
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isEnglish(String s) {
		return StringUtils.matches(s, "^[A-Za-z]+$");
	}

	/**
	 * 检查是否只包含英文与数字
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isEnglishAndNumber(String s) {
		return StringUtils.matches(s, "^[A-Za-z0-9]+$");
	}

	/**
	 * 检查是否只包含英文，数字，下划线
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isEnglishAndNumberAnd_(String s) {
		return StringUtils.matches(s, "^[A-Za-z0-9_]+$");
	}

	/**
	 * 传入字符串是否包含空格
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isHasBlank(String s) {
		return StringUtils.matches(s, "^.*\\s.*$");
	}

	/**
	 * 检查是否标准的ipv4地址,本方法使用正则表达式来验证IP地址是否合法
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isIPv4(String s) {
		return StringUtils
			.matches(
				s,
				"^((25[0-5])|(2[0-4][0-9])|(1[0-9][0-9])|([1-9][0-9])|([0-9]))\\.((25[0-5])|(2[0-4][0-9])|(1[0-9][0-9])|([1-9][0-9])|([0-9]))\\.((25[0-5])|(2[0-4][0-9])|(1[0-9][0-9])|([1-9][0-9])|([0-9]))\\.((25[0-5])|(2[0-4][0-9])|(1[0-9][0-9])|([1-9][0-9])|([0-9]))$");
	}

	/**
	 * 检查是否标准的ipv6地址,本方法使用正则表达式来验证IP地址是否合法
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isIPv6(String s) {
		String p = "^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$";
		return StringUtils.matches(s, p);
	}

	/**
	 * 检查是否只包含小写的英文字符
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isLowercaseEnglish(String s) {
		return StringUtils.matches(s, "^[a-z]+$");
	}

	/**
	 * 检查传入字符串是否标准的手机号码<br />
	 * 13,14,15,18开头的11位数字
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isMobile(String s) {
		return StringUtils.matches(s, "^1\\d{10}$");
	}

	/**
	 * 传入的字符串是否一个标准的电话号码<br />
	 * 国际电话格式：+86-757-12345678,(带国际区号的电话一定要写国内区号，但不用写区号的0)<br />
	 * 国内长途:0757-12345678(带国内区号的格式)<br />
	 * 市话：12345678<br />
	 * 内线：1000(1-5位)
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isPhone(String s) {
		return StringUtils.matches(s, "^((\\+[1-9]\\d{0,3}\\-[1-9]\\d{1,2}\\-[1-9]\\d{2,9}(\\-\\d{1,5})?)|((0[1-9]\\d{1,2}\\-)?[1-9]\\d{2,9}(\\-\\d{1,5})?))$");
	}

	/**
	 * 检查传入字符串是否标准的QQ号码
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isQQ(String s) {
		return StringUtils.matches(s, "^[1-9]\\d{4,10}$");
	}

	/**
	 * 传入字符串是否已空格开头
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isStartBlank(String s) {
		return StringUtils.matches(s, "^\\s.*$");
	}

	/**
	 * 检查是否只包含大写的英文字符
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isUppercaseEnglish(String s) {
		return StringUtils.matches(s, "^[A-Z]+$");
	}

	/**
	 * 传入字符串是否一个标准的用户名<br />
	 * 以字符数字开头，中间可以是字母数字下划线，结尾是字母或者数字，长度在5-16个字符之间
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isUserName(String s) {
		return StringUtils.matches(s, "^[A-Za-z0-9][A-Za-z0-9_]{3,14}[A-Za-z0-9]$");
	}

	/**
	 * 检查传入字符串是否标准的邮政编码<br />
	 * 6位数字，开头不是0
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isZip(String s) {
		return StringUtils.matches(s, "^[1-9]\\d{5}$");
	}

	/**
	 * 正则验证
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean matches(String s, String p) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0) {
			return false;
		}
		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}

	/**
	 * 去除字符串中所有 &<>'"\/字符（防止xxs攻击）
	 *
	 * @param str
	 * @return
	 */
	public static String stripXXSChars(String str) {
		return replaceChars(str, "&\\<>\"'\\/", "");
	}

	/**
	 * 用全角字符替换掉所有 &<>'"\/#%:字符（防止xxs攻击）
	 *
	 * @param s
	 * @return
	 */
	public static String replaceXXSChars(String s) {
		if (s == null || s.equals("")) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append('＞');// 全角大于号
				break;
			case '<':
				sb.append('＜');// 全角小于号
				break;
			case '\'':
				sb.append('＇');
				break;
			case '\"':
				sb.append('＂');// 全角双引号
				break;
			case '&':
				sb.append('＆');// 全角
				break;
			case '\\':
				sb.append('＼');// 全角斜线
				break;
			case '#':
				sb.append('＃');// 全角井号
				break;
			case ':':
				sb.append('：');// 全角冒号
				break;
			case '%':
				sb.append("％");
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 过滤sql敏感词
	 *
	 * @param str
	 * @return
	 */
	public static String sqlStrTrim(String str) {
		if (StringUtils.isEmpty(str)) {
			return str;
		}
		for (int i = 0; i < SqlStr1.length; i++) {
			if (str.indexOf(SqlStr1[i]) >= 0) {
				str = str.replaceAll("(?i)\\s" + SqlStr1[i] + "[\\s\\(]", " ");//正则替换词语，无视大小写
			}
		}
		for (int i = 0; i < SqlStr2.length; i++) {
			if (str.indexOf(SqlStr2[i]) >= 0) {
				str = str.replaceAll(SqlStrRegx[i], "");
			}
		}
		return str;
	}

	public static void main(String[] args) {
		String s = "杜哥 or (1 = 1) like % orselect count(";
		//		System.out.println(s);
		//		System.out.println(stripXXSChars(s));
		//		System.out.println(replaceXXSChars(s));
		System.out.println(sqlStrTrim(s));
	}

	/**
	 * 检查是否一个时间格式的字符串，有前缀0的
	 *
	 * @param s 检查字符串
	 * @return true/false
	 */
	public static boolean isTime(String s) {
		return StringUtils.matches(s, "^(([0-1][0-9])|(2[0-3])):([0-5][0-9]):([0-5][0-9])$");
	}

	/**
	 * 将集合字符串转换成sql in()里面用的字符串
	 * 例如：[a,b,c] 转换成-》 'a','b','c'<br/>
	 * <br/>
	 * <p>
	 * 可以在miniDao sql freemark模板中直接使用该方法<br/>
	 * 例如：${list2SqlInString(ids)} ,其中ids为数组参数名
	 *
	 * @param list
	 * @return
	 */
	public static String list2SqlInString(Collection<String> list) {
		return "'" + StringUtils.join(list, "','") + "'";
	}

	/**
	 * split操作并返回list
	 *
	 * @param str
	 * @param separatorChars
	 * @return
	 */
	public static List<String> splitToList(String str, String separatorChars) {
		String[] split = split(str, separatorChars);
		return new ArrayList<String>(Arrays.asList(split));
	}
}
