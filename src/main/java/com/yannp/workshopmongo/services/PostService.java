package com.yannp.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yannp.workshopmongo.domain.Post;
import com.yannp.workshopmongo.repository.PostRepository;
import com.yannp.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) throws ObjectNotFoundException {

	return repo.findById(id).orElseThrow(()->new ObjectNotFoundException("Usuário não encontrado"));

	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
}

	