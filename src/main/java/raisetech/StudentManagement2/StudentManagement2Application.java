package raisetech.StudentManagement2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagement2Application {

  private String studentName = "山田";
  private String age = "18";

  public static void main(String[] args) {
    SpringApplication.run(StudentManagement2Application.class, args);
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/studentInfo")
  public String studentInfo() {
    return studentName + " " + age + "歳";
  }

  @PostMapping("/updateStudentInfo")
  public void updateStudentInfo(String studentName, String age) {
    this.studentName = studentName;
    this.age = age;

  }

  @PostMapping("/updateStudentName")
  public void updateStudentName(String studentName) {
    this.studentName = studentName;

  }

  @PostMapping("/updateStudentAge")
  public void updateStudentAge(String age) {
    this.age = age;
  }
}
