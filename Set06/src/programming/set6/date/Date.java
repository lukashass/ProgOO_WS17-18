package programming.set6.date;

/**
 * simple date representation.
 * 
 * @author lukas
 *
 */
public class Date {

	private int year;
	private int month;
	private int day;

	private static final String[] MONTHNAMES = { null, "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };

	/**
	 * creates new Date.
	 * 
	 * @param year
	 *            integer for year.
	 * @param month
	 *            integer for month {@code 1} to {@code 12}.
	 * @param day
	 *            integer for day of month, validity depends on month.
	 */
	public Date(int year, int month, int day) {
		if (!validate(year, month, day)) {
			throw new IllegalArgumentException("This is not a valid date.");
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * returns the number of days in the given month of the given year, where
	 * {@code 1} represents January and {@code 12} represents December.
	 * 
	 * @param year
	 *            integer for year.
	 * @param month
	 *            integer for month {@code 1} to {@code 12}.
	 * @return number of days in a month returns {@code 0} if month is out of range.
	 */
	public static int getDaysInMonth(int year, int month) {
		if (month < 1 || month > 12) {
			return 0;
		}
		if (month <= 7) {
			if (month % 2 == 1) {
				return 31;
			}
			if (month == 2) {
				if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
					return 29;
				}
				return 28;
			}
			return 30;
		}
		if (month % 2 == 1) {
			return 30;
		}
		return 31;

	}

	/**
	 * checks if the given three integers represent a valid date.
	 * 
	 * @param year
	 *            integer for year.
	 * @param month
	 *            integer for month.
	 * @param day
	 *            integer for day.
	 * @return {@code true} when date is valid and {@code false} when invalid.
	 */
	public static boolean validate(int year, int month, int day) {
		if (month < 1 || month > 12) {
			return false;
		}
		if (month <= 7) {
			if (month % 2 == 1) {
				return day >= 1 && day <= 31;
			}
			if (month == 2) {
				if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
					return day >= 1 && day <= 29;
				}
				return day >= 1 && day <= 28;

			}
			return day >= 1 && day <= 30;
		}
		if (month % 2 == 1) {
			return day >= 1 && day <= 30;
		}
		return day >= 1 && day <= 31;
	}

	/**
	 * returns the day of a Date.
	 * 
	 * @return day of Date instance.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * returns the month of a Date.
	 * 
	 * @return month of Date instance.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * returns the year of a Date.
	 * 
	 * @return year of Date instance.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * returns the number of the day in the year.
	 * 
	 * @return the number of the day represented by the Date instance.
	 */
	public int dayOfYear() {
		int days = 0;
		for (int i = 1; i < month; i++) {
			days += getDaysInMonth(year, i);
		}
		return days + day;
	}

	/**
	 * calculates how many days the other Date is off and returns that as an
	 * integer.
	 * 
	 * @param other
	 *            second Date instance.
	 * @return difference between given dates; If {@code other} lies in the future,
	 *         that number is positive; otherwise, it is negative; {@code 0} when
	 *         years are different.
	 */
	public int sameYearDiff(Date other) {
		if (this.year != other.year) {
			return 0;
		}
		return -1 * (this.dayOfYear() - other.dayOfYear());
	}

	@Override
	public String toString() {
		return MONTHNAMES[month] + " " + day + ", " + year;
	}

}
