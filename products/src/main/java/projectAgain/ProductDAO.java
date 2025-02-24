package projectAgain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	public void create(Product student) throws Exception {
		String sql = "INSERT INTO productJsf (productName, price, phoneNumber, details) VALUES (?,?,?,?)";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setString(1, student.getProductName());
			preparedstatement.setDouble(2, student.getPrice());
			preparedstatement.setString(3, student.getPhoneNumber());
			preparedstatement.setString(3, student.getDetails());
			preparedstatement.executeUpdate();
		}
	}

	public List<Product> readAll() throws Exception {
		List<Product> students = new ArrayList<>();
		String sql = "SELECT * FROM productJsf ORDER BY id";
		try (Connection connection = DatabaseConfig.getConnection();
				Statement ps = connection.createStatement();
				ResultSet resultSet = ps.executeQuery(sql)) {

			while (resultSet.next()) {
				Product student = new Product(resultSet.getLong("id"), resultSet.getString("productName"),
						resultSet.getDouble("price"), resultSet.getString("phoneNumber"),
						resultSet.getString("details"));
				students.add(student);
			}
//				int id = resultSet.getInt("id");
//				String name = resultSet.getString("name");
//				String email = resultSet.getString("email");
//				String course = resultSet.getString("course");

		}
		return students;
	}

	public void update(Product student) throws Exception {
		String sql = "UPDATE productJsf SET productName=?, price=?, phoneNumber=?, details=? WHERE id = ?";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setString(1, student.getProductName());
			preparedstatement.setDouble(2, student.getPrice());
			preparedstatement.setString(3, student.getPhoneNumber());
			preparedstatement.setString(3, student.getDetails());
			preparedstatement.setLong(4, student.getId());
			preparedstatement.executeUpdate();
		}
	}

	public void delete(Long id) throws Exception {
		String sql = "DELETE FROM productJsf WHERE id=?";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setLong(1, id);
			preparedstatement.executeUpdate();
		}
	}
}
