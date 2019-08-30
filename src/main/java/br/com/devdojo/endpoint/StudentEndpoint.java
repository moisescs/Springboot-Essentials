package br.com.devdojo.endpoint;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.error.CustomErrorType;
import br.com.devdojo.model.Student;
import br.com.devdojo.repository.StudentRepository;



@RestController
@RequestMapping("students")
public class StudentEndpoint {
	
	private final StudentRepository studentDAO;
	
	@Autowired
	public StudentEndpoint(StudentRepository studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);		
	}
	
	//@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") long id){
		Optional<Student> student = studentDAO.findById(id);
		
		if(student == null)
			return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(studentDAO.findById(id), HttpStatus.OK);
	}
	
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student){		
		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.OK);
	}
	
	
	//@RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		
		studentDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//@RequestMapping(method = RequestMethod.PUT)
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student){
		studentDAO.save(student);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
