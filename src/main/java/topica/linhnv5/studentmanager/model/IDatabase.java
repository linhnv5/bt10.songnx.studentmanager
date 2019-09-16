package topica.linhnv5.studentmanager.model;

import java.util.Date;
import java.util.List;

/**
 * Defination of database student that allow to find, edit, add, delete student
 * @author ljnk975
 *
 */
public interface IDatabase {

	/**
	 * get a student by it's id
	 * @param iddb id of student
	 * @return the student
	 */
	public Student getStudentByID(int iddb);

	/**
	 * Add a student to map
	 * @param name          name of student
	 * @param gender        gender of student
	 * @param admissionDay  admissionDay of student
	 * @return  if unsuccessful return -1, otherwise return id of student have been added
	 */
	public int addStudent(String name, byte gender, Date admissionDay);

	/**
	 * Delete a student by using it's iddb
	 * @param  iddb id of student
	 * @return true if success, false if not success
	 */
	public boolean deleteStudent(int iddb);

	/**
	 * Modify student info by it's iddb
	 * @param iddb          id of student
	 * @param name          name of student
	 * @param gender        gender of student
	 * @param admissionDay  admissionDay of student
	 * @return              true if success, false if not success
	 */
	public boolean editStudent(int iddb, String name, byte gender, Date admissionDay);

	/**
	 * Get a list of student by it's name<br/>
	 * If name is null then the result is all student in db
	 * @param name name of student
	 * @return     List of student have given name
	 */
	public List<Student> getStudentByName(String name);

}
