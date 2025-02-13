import com.meli.obtenerdiploma.repository.IStudentDAO;

public class StudentDAOTest {
    IStudentDAO studentDAO = new StudentDAO();

    @Test
    public void shouldSaveANewStudent() {
        // Arrange
        StudentDTO studentToSave = TestingUtils.getStudentWithGreatGrades();
        
        // Act
        studentDAO.save(studentToSave);
        StudentDTO savedStudent = studentDAO.findById(studentToSave.getId());
        boolean isSaved = studentDAO.exists(studentToSave);

        // Assert
        Assertions.assertTrue(isSaved);
        Assertions.assertEquals(studentToSave, savedStudent);
    }

    @Test
    public void shouldNotSaveAnExistentStudent() {}

    @Test
    public void shouldDeleteAStudent() {
        // Arrange
        
        // Act

        // Assert
    }

    @Test
    public void shouldTellIfAStudentExists() {
        // Arrange
        
        // Act

        // Assert
    }

    @Test
    public void shouldFindById() {
        // Arrange
        
        // Act

        // Assert
    }
}
