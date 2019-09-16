package topica.linhnv5.studentmanager.model;

import java.util.Date;

import topica.linhnv5.studentmanager.utils.DateUtil;

/**
 * Student model holds info of student, id, name, birth, gender, admission day
 * @author ljnk975
 *
 */
public class Student {

	/**
	 * id of student in database
	 */
	private final int iddb;

	/**
	 * name of student
	 */
	private String name;

	/**
	 * Year of birth
	 */
	private int yearOfBirth;

	/**
	 * Gender of student, 0 for female and 1 for male
	 */
	private byte gender;

	/**
	 * Day of admission
	 */
	private Date admissionDay;

	/**
	 * Create student using iddb, name, gender and admissionDay
	 * @param iddb
	 * @param name
	 * @param yearOfBirth   year of birth
	 * @param gender
	 * @param admissionDay
	 */
	public Student(int iddb, String name, int yearOfBirth, byte gender, Date admissionDay) {
		this.iddb = iddb;
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.admissionDay = admissionDay;
	}

	/**
	 * @return the iddb
	 */
	public final int getIddb() {
		return iddb;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @return the yearOfBirth
	 */
	public final int getYearOfBirth() {
		return yearOfBirth;
	}

	/**
	 * @param yearOfBirth the yearOfBirth to set
	 */
	public final void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	/**
	 * @return the gender
	 */
	public final byte getGender() {
		return gender;
	}

	/**
	 * @return the gender in string, 0 = Female, 1 = Male
	 */
	public final String getGenderStr() {
		switch (this.gender) {
			case 0:
				return "FeMale";
			case 1:
				return "Male";
		}

		return "Undefined";
	}

	/**
	 * @return the admissionDay
	 */
	public final Date getAdmissionDay() {
		return admissionDay;
	}

	/**
	 * @return the admissionDay in format yyyy/MM/dd
	 */
	public final String getAdmissionDayStr1() {
		return DateUtil.gI().format1(this.admissionDay);
	}

	/**
	 * @return the admissionDay in format dd/MM/yyyy
	 */
	public final String getAdmissionDayStr2() {
		return DateUtil.gI().format2(this.admissionDay);
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @param gender the gender to set
	 */
	public final void setGender(byte gender) {
		this.gender = gender;
	}

	/**
	 * @param admissionDay the admissionDay to set
	 */
	public final void setAdmissionDay(Date admissionDay) {
		this.admissionDay = admissionDay;
	}

}
