package com.application.rest.controllers;

import com.application.rest.controllers.dto.StudentDto;
import com.application.rest.entities.Student;
import com.application.rest.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService iStudentService;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){
       List<StudentDto> students = iStudentService.findAll()
               .stream()
               .map(student-> StudentDto.builder()
                       .id(student.getId())
                       .name(student.getName())
                       .lastName(student.getLastName())
                       .age(student.getAge())
                       .gender(student.getGender())
                       .email(student.getEmail())
                       .build())
               .toList();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){

        Optional<Student> studentOptional = iStudentService.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            StudentDto studentDto = StudentDto.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .lastName(student.getLastName())
                    .age(student.getAge())
                    .gender(student.getGender())
                    .email(student.getEmail())
                    .build();
            return ResponseEntity.ok(studentDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto) throws URISyntaxException {

        if(studentDto.getName().isBlank() || studentDto == null ){
            return ResponseEntity.badRequest().build();
        }else{
            iStudentService.save(Student.builder()
                    .name(studentDto.getName())
                    .lastName(studentDto.getLastName())
                    .age(studentDto.getAge())
                    .gender(studentDto.getGender())
                    .email(studentDto.getEmail())
                    .build());
            return ResponseEntity.created(new URI("/student/save")).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody StudentDto studentDto) throws URISyntaxException {

        Optional<Student> studentOptional = iStudentService.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(studentDto.getName());
            student.setLastName(studentDto.getName());
            student.setAge(studentDto.getAge());
            student.setGender(studentDto.getGender());
            student.setEmail(studentDto.getEmail());

            iStudentService.save(student);
            return ResponseEntity.ok("Registro Actualizado como sucesso");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) throws URISyntaxException {
        if(id!=0){
            iStudentService.deleteById(id);
            return ResponseEntity.ok("Registro Excluido como sucesso");
        }
        return ResponseEntity.badRequest().build();
    }
}
