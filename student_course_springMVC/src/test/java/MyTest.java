import com.klabsy.pojo.Student;
import com.klabsy.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentServiceImpl =(StudentService) context.getBean("StudentServiceImpl");
        for (Student student : studentServiceImpl.queryAllStudent()) {
            System.out.println(student);
        }
    }
}