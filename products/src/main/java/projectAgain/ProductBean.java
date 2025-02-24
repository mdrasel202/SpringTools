package projectAgain;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Product student = new Product();
	private ProductDAO studentDAO = new ProductDAO();
	private List<Product> studentList;
	private boolean editMode = false;

	public String saveStudent() {
		try {
			if (editMode) {
				studentDAO.update(student);
			} else {
				studentDAO.create(student);
			}
			refreshList();
			clearForm();
			return "student?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void editStudent(Product student) {
		this.student = student;
		editMode = true;
	}

	public void deleteStudent(Long id) {
		try {
			studentDAO.delete(id);
			refreshList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearForm() {
		student = new Product();
		editMode = false;
	}

	private void refreshList() {
		try {
			studentList = studentDAO.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getters and Setters
	public Product getStudent() {
		return student;
	}

	public void setStudent(Product student) {
		this.student = student;
	}

	public List<Product> getStudentList() {
		if (studentList == null) {
			refreshList();
		}
		return studentList;
	}
}