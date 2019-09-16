package topica.linhnv5.studentmanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class to convert date to string format yyyy/MM/dd
 * @author ljnk975
 *
 */
public final class DateUtil {

	// Singleton pattern
	private DateUtil() {}

	private static class DateUtilHelper {
		static DateUtil instance = new DateUtil();
	}

	/**
	 * Get instance of util to format date
	 * @return the instance
	 */
	public static final DateUtil gI() {
		return DateUtilHelper.instance;
	}

	/**
	 * Formater to convert string to date
	 */
	private final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Formater to convert date to string
	 */
	private final SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Convert date to string date format yyyy/MM/dd
	 * @param d date to conver
	 * @return  String of date
	 */
	public final String format1(Date d) {
		return formatter1.format(d);
	}

	/**
	 * Convert date to string date format dd/MM/yyyy
	 * @param d date to conver
	 * @return  String of date
	 */
	public final String format2(Date d) {
		return formatter2.format(d);
	}

	/**
	 * Convert a string format yyyy/MM/dd to java date object
	 * @param s String date format yyyy/MM/dd
	 * @return  Java Date object
	 * @throws ParseException if string not follow the format yyyy/MM/dd
	 */
	public final Date parse(String s) throws ParseException {
		return formatter1.parse(s);
	}

}
