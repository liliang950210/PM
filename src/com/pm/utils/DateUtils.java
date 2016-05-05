package com.pm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期相关辅助类
 * 
 * @author JiangLongwei
 * @date 2015年12月7日
 */
public class DateUtils {

	/**
	 * 获取当前的日期时间 格式为 yyyy-MM-ddTHH:mm HH为24小时制的
	 * 
	 * @param hasT
	 *            中间是否有T字样的
	 * @return
	 */
	public static String getCurCalendar(boolean hasT) {

		SimpleDateFormat format;
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date date = new Date(System.currentTimeMillis());

		if (hasT) {
			return format.format(date).replace(" ", "T");
		}

		return format.format(date);
	}

	/**
	 * 将毫秒转化为yyyy-MM-dd HH：mm的格式
	 * 
	 * @param ms
	 * @return
	 */
	public static String getDateByMS(long ms) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date date = new Date(ms);

		String timeString = format.format(date);

		return timeString;

	}

	/**
	 * 将日期转化为str类型
	 * 
	 * @param date
	 * @param hasT
	 *            是否带有T，方便呈现日期时间选择
	 * @return
	 */
	public static String date2str(Date date, boolean hasT) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		if (hasT) {
			return format.format(date).replace(" ", "T");
		}

		return format.format(date);
	}

	/**
	 * 根据日期获取毫秒数
	 * 
	 * @param date
	 *            yyyy-MM-ddTHH:mm
	 * @return
	 */
	public static long getMsByDate(String dateTxt) {
		Date date;
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			// 奇葩的输入
			dateTxt = dateTxt.replace("T", " ");

			date = format.parse(dateTxt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return 0;
		}

		return date.getTime();
	}

	/**
	 * 获取持续的时间
	 * 返回格式为  XX天XX小时
	 * @param endDate
	 * @param beginDate
	 * @return
	 */
	public static String getLastedTime(Date endDate, Date beginDate) {

		long lastTime = endDate.getTime() - beginDate.getTime();

		long day = lastTime / 1000 / 60 / 60 / 24;
		long hour = lastTime / 1000 / 60 / 60 - day * 24;

		return day + "天" + hour + "小时";
	}
}
