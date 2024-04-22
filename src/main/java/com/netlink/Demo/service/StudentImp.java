package com.netlink.Demo.service;

import com.netlink.Demo.exception.NoPersonFoundException;
import com.netlink.Demo.exception.StudentNotFoundException;
import com.netlink.Demo.model.Student;
import com.netlink.Demo.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class StudentImp implements  IStudent{

    @Autowired
    private StudentRepository repository;
    @Override
    public Boolean saveStudentInfo(Student student) throws Exception {
        Student save = repository.save(student);
        System.out.println("=========="+save);
        if(save==null)
        {
            throw new Exception("Student Info doesn't save");
        }
        return true;
    }

    @Override
    public void deleteStudent(Integer id) {

        Optional<Student> student= repository.findById(id);
        if(student.isPresent())
        {
            repository.delete(student.get());
        }

    }

    @Override
    public List<Student> getAllStudent() {

        return repository.findAll(Sort.by("id"));
    }

    @Override
    public Student updateStudentById(Student student) {
            Optional<Student> oldStudent= repository.findById(student.getId());
            if (oldStudent.isPresent()) {
                Student newStudent = oldStudent.get();
                newStudent.setName(student.getName());
                newStudent.setAge(student.getAge());
                newStudent.setEmail(student.getEmail());
                newStudent.setDateOfBirth(student.getDateOfBirth());
                repository.save(newStudent);
                return newStudent;
            }
        return null;
    }

    @Override
    public List<Student> getStudentsWithPagination(Integer offset,Integer pageSize) {

        Page<Student> students= repository.findAll(PageRequest.of(offset,pageSize));
        return students.getContent();
    }

    @Override
    public List<Student> getSortedStudents(@PathVariable String property) {
       return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,property));
    }

    @Override
    public Student getStudentById(Integer id) {
        log.info("inside repo and id   :{}" , id);         // for debugging we use logging
        Optional<Student> student= repository.findById(id);
        System.out.println("student-----------" + student);
        if (student.isPresent()){
            return student.get();
        }else {
            throw new StudentNotFoundException("Record not found!");
        }
    }

    @Override
    public Student getStudentByName(String name) {
        Student student= repository.getStudentByName(name);

       if(student!=null)
       {
           return student;
       }
        else
       {
           throw new NoPersonFoundException("No Person found");
       }
    }

    @Override
    public List<Student> getStudentByNativeQuery(String name) {
        System.out.println("inside student imp ----"+name);
       return repository.findStudentUsingNativeQuery(name);
    }

    @Override
    public List<Student> getStudentByAgeOrName(Integer age, String name) {
        return repository.getStudentByAgeOrName(age,name);
    }
}
