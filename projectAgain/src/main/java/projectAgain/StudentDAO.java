package projectAgain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public void create(Student student) throws Exception {
		String sql = "INSERT INTO studentJsf (name, email, course) VALUES (?,?,?)";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setString(1, student.getName());
			preparedstatement.setString(2, student.getEmail());
			preparedstatement.setString(3, student.getCourse());
			preparedstatement.executeUpdate();
		}
	}

	public List<Student> readAll() throws Exception {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM studentJsf ORDER BY id";
		try (Connection connection = DatabaseConfig.getConnection();
				Statement ps = connection.createStatement();
				ResultSet resultSet = ps.executeQuery(sql)) {

			while (resultSet.next()) {
				Student student = new Student(resultSet.getLong("id"), resultSet.getString("name"),
						resultSet.getString("email"), resultSet.getString("course"));
				students.add(student);
			}
//				int id = resultSet.getInt("id");
//				String name = resultSet.getString("name");
//				String email = resultSet.getString("email");
//				String course = resultSet.getString("course");

		}
		return students;
	}

	public void update(Student student) throws Exception {
		String sql = "UPDATE studentJsf SET name=?, email=?, course=? WHERE id = ?";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setString(1, student.getName());
			preparedstatement.setString(2, student.getEmail());
			preparedstatement.setString(3, student.getCourse());
			preparedstatement.setLong(4, student.getId());
			preparedstatement.executeUpdate();
		}
	}

	public void delete(Long id) throws Exception {
		String sql = "DELETE FROM studentJsf WHERE id=?";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setLong(1, id);
			preparedstatement.executeUpdate();
		}
	}
}
