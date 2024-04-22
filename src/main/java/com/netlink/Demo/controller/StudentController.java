package com.netlink.Demo.controller;

import com.netlink.Demo.model.Student;
import com.netlink.Demo.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                                // Restful API call (GET,PUT,POST,DELETE,PATCH==> HTTP METHOD)compulsory
@RequestMapping("/student")                      //optional
public class StudentController {

    @Autowired
    private IStudent iStudent;
    @GetMapping("/print")
    public ResponseEntity<String> helloSpring()
    {
        String msg= "HELLO SPRING BOOT!";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Description","Hello Spring API call!");
        return new ResponseEntity<String>(msg, httpHeaders, HttpStatus.OK);
    }

    //               CRUD OPERATIONS
    @PostMapping("/add-student")                                                     // CREATE
    public Boolean saveStudent(@RequestBody Student student) throws Exception {
        return iStudent.saveStudentInfo(student);
    }
    @GetMapping("/get-all-students")                                               // READ
    public ResponseEntity<List<Student>> getAllStudents()
    {
         List<Student> studentList= iStudent.getAllStudent();
         return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }
    @PutMapping("/update-student-by-id")                                            // UPDATE
    public Student updateStudentById(@RequestBody Student student)
    {
        return iStudent.updateStudentById(student);
    }
    @DeleteMapping("/delete-student-by-id")                                    //DELETE
    public ResponseEntity<Void> deleteStudentById(@RequestParam Integer id)
    {
         iStudent.deleteStudent(id);
         return ResponseEntity.ok().build();
    }
    // CUTOMIZE API
    @GetMapping("/get-student-by-id/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable Integer id)  {
            Student student = iStudent.getStudentById(id);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Description", "API Call......!");
            httpHeaders.add("Description", "Get Student By Id");
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(student);
    }
    @GetMapping("/get-sorted-students/{property}")
    public List<Student> getSortedStudents(@PathVariable String property)
    {
        return iStudent.getSortedStudents(property);
    }
    @GetMapping("/get-students-with-pagination/{offset}/{pageSize}")
    public List<Student> getStudentsWithPagination(@PathVariable Integer offset,@PathVariable Integer pageSize)
    {
        return iStudent.getStudentsWithPagination(offset,pageSize);
    }
    @GetMapping("/get-student-by-name-using-native-query")
    public List<Student> findStudentNameUsingNativeQuery(@RequestParam(defaultValue = "Adil Qureshi") String name)
    {
        System.out.println("inside controller---------"+name);
        return  iStudent.getStudentByNativeQuery(name);
    }

    @GetMapping("/get-student-by-name")
    public ResponseEntity<Object> getStudentByName(@RequestParam(value = "names") String name)
    {
             Student student = iStudent.getStudentByName(name);
             return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    @GetMapping("/get-student-by-age-or-name")
    public List<Student> getStudentByAgeOrName(@RequestParam Integer age,@RequestParam String name)
    {
        return iStudent.getStudentByAgeOrName(age,name);
    }
    @GetMapping("/get-error")
    public Integer getError()
    {
        int a=10/0;
        return a;
    }

    //Exception Handling at controller level
//    @ExceptionHandler(value = StudentNotFoundException.class)
//    public ResponseEntity<String> getStudentNotFoundException()
//    {
//        StudentNotFoundException studentNotFoundException= new StudentNotFoundException("No Record Found!");
//        return ResponseEntity.ok(studentNotFoundException.getMessage());
//    }
}
