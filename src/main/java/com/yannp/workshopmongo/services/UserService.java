package com.yannp.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yannp.workshopmongo.domain.User;
import com.yannp.workshopmongo.dto.UserDTO;
import com.yannp.workshopmongo.repository.UserRepository;
import com.yannp.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) throws ObjectNotFoundException {

	return repo.findById(id).orElseThrow(()->new ObjectNotFoundException("Usuário não encontrado"));

	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto){
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
