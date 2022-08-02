package controller;


import org.example.model.Student;
import org.example.service.StudentService;
import org.example.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService = new StudentServiceImpl();


    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Student user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getName());
        studentService.insert(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getRollNo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
