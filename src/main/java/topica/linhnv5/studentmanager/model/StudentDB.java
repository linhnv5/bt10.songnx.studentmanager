package topica.linhnv5.studentmanager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Hold map of student to add, store, find student by name, ...
 * @author ljnk975
 *
 */
public final class StudentDB implements IDatabase {

	/**
	 * Map of student by name
	 */
	private Map<Integer, Student> mapOfStudent;

	/**
	 * Id of student when add
	 */
	private static int idAutoIncrement = 0;

	/**
	 * Constructor
	 */
	@SuppressWarnings("deprecation")
	private StudentDB() {
		this.mapOfStudent = new HashMap<Integer, Student>();
		this.addStudent("Hoang", (byte)0, new Date(2015-1900, 5, 2));
		this.addStudent("Linh", (byte)0, new Date(2015-1900, 8, 23));
		this.addStudent("Khanh", (byte)0, new Date(2015-1900, 7, 12));
		this.addStudent("Kha", (byte)0, new Date(2015-1900, 4, 3));
		this.addStudent("CuChuoi", (byte)0, new Date(2015-1900, 6, 4));
	}

	// Singleton
	private static class MapStudentHelper {
		static StudentDB instance = new StudentDB();
	}
	
	/**
	 * get instance
	 * @return the instance
	 */
	public static StudentDB gI() {
		return MapStudentHelper.instance;
	}

	@Override
	public synchronized final Student getStudentByID(int iddb) {
		return this.mapOfStudent.get(iddb);
	}

	@Override
	public List<Student> getStudentByName(String name) {
		// create list to contain student
		List<Student> list = new ArrayList<Student>();

		// if name is null then return all student
		if(name == null)
			list.addAll(this.mapOfStudent.values());
		else {
			Iterator<Student> iterOfStu = this.mapOfStudent.values().iterator();
			while(iterOfStu.hasNext()) {
				Student student = iterOfStu.next();

				// Check name, if equals then add to result
				if(student.getName().equals(name))
					list.add(student);
			}
		}

		return list;
	}

	@Override
	public synchronized final int addStudent(String name, byte gender, Date admissionDay) {
		// Create a student and put it to map
		Student student = new Student(idAutoIncrement++, name, gender, admissionDay);
		this.mapOfStudent.put(student.getIddb(), student);
		return student.getIddb();
	}

	@Override
	public synchronized final boolean deleteStudent(int iddb) {
		// remove from map and retun
		this.mapOfStudent.remove(iddb);
		return true;
	}

	@Override
	public synchronized final boolean editStudent(int iddb, String name, byte gender, Date admissionDay) {
		// Get student by iddb
		Student student = this.getStudentByID(iddb);

		// if null then return edit fail
		if(student == null)
			return false;

		// if not null then set it info
		student.setName(name);
		student.setGender(gender);
		student.setAdmissionDay(admissionDay);

		return true;
	}

}
