import com.zme.entity.Student;
import com.zme.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;


public class StudentTest {
    public static SqlSession session;
    @Before
    public void sqlSessionBefore() throws Exception{
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }
    @Test
    public void queryStudentTest() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.queryAllStudent();
        studentList.forEach( list -> System.out.println(list));
        session.close();
    }
}
