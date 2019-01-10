package io.github.hongsii.jpanplus1.service;

import io.github.hongsii.jpanplus1.domain.Post;
import io.github.hongsii.jpanplus1.repository.PostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> findAll() {
		return postRepository.findPosts();
	}
}
