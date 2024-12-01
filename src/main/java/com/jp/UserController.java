package com.jp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody InputRequest<UserDto> request){
		UserDto userDetails = request.getUserDetails();
		UserEntity userEntity = mapper.map(userDetails, UserEntity.class);
		userEntity.setCreatedBy(request.getUserId());
		UserEntity _savedUser = userRepository.save(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(_savedUser);
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<?> createUser(@PathVariable Integer Id, @RequestBody InputRequest<UserDto> request){
		UserEntity userEntity =  userRepository.findById(Id).orElse(null);
		UserDto userDetails = request.getUserDetails();
		userEntity.setFirstName(userDetails.getFirstName());
		userEntity.setLastName(userDetails.getLastName());
		userEntity.setLastModifiedBy(request.getUserId());
		UserEntity _savedUser = userRepository.save(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(_savedUser);
	}
	

}
