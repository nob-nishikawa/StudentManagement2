package raisetech.StudentManagement2;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagement2Application {

  private String studentName = "山田";
  private String age = "20";
  //  private Map<String, String> studentInformation = Map.of("田中", "20");
  private final Map<String, String> studentInfomation = new HashMap<>();

  //  初期値をセット
  @PostConstruct
  public void setMappingData() {
    studentInfomation.put("田中", "30");
    studentInfomation.put("石破", "60");

  }

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

  @GetMapping("/studentInfo2")
  public Map<String, String> studentInfo2() {
    return studentInfomation;
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

  @PostMapping("/studentInfo2")
  public void studentInfo2(@RequestParam Map<String, String> updateParam) {
    String getName = updateParam.get("studentName");
    String getAge = updateParam.get("age");

    if (getName != null && getAge != null) {

      studentInfomation.put(getName, getAge);
    } else {
      System.err.println("パラメータがありませんでした");
    }

  }
}
