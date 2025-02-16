package isdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DatabaseConnection;

public class StudentDAO {
	private static final String INSERT_STUDENT_SQL = "INSERT INTO student_jsp(name, email, phone, address) VALUES(?,?,?,?)";
	private static final String SELECT_ALL_STUDENTS_SQL = "SELECT * FROM student_jsp";
	private static final String SELECT_STUDENT_BY_ID_SQL = "SELECT * FROM student_jsp WHERE id = ?";
	private static final String UPDATE_STUDENT_SQL = "UPDATE student_jsp SET name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
	private static final String DELETE_STUDENT_SQL = "DELETE FROM student_jsp WHERE id = ?";

	public void addStudent(Student student) throws SQLException {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedstatement.setString(1, student.getName());
			preparedstatement.setString(2, student.getEmail());
			preparedstatement.setString(3, student.getPhone());
			preparedstatement.setString(4, student.getAddress());
			preparedstatement.executeUpdate();
		}
	}

	public List<Student> getAllStudents() throws SQLException {
		List<Student> students = new ArrayList<>();

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_ALL_STUDENTS_SQL);
				ResultSet resultSet = ps.executeQuery()) {

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				students.add(new Student(id, name, email, phone, address));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("error while fetching students records", e);
		}
		return students;
	}

	public Student getStudentsById(int id) throws SQLException {
		Student student = null;

		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_STUDENT_BY_ID_SQL)) {
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {

				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				student = new Student(id, name, email, phone, address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("error while fetching students records", e);
		}
		return student;
	}

	public void updateStudent(Student student) throws SQLException {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
			preparedstatement.setString(1, student.getName());
			preparedstatement.setString(2, student.getEmail());
			preparedstatement.setString(3, student.getPhone());
			preparedstatement.setString(4, student.getAddress());
			preparedstatement.setInt(5, student.getId());
			preparedstatement.executeUpdate();
		}
	}

	public void deleteStudent(int id) throws SQLException {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
			preparedstatement.setInt(1, id);
			preparedstatement.execute();
		}
	}
}
