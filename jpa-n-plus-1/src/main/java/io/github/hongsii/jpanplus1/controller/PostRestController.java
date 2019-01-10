package io.github.hongsii.jpanplus1.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import io.github.hongsii.jpanplus1.domain.Post;
import io.github.hongsii.jpanplus1.service.PostService;
import java.util.List;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {

	private final PostService postService;

	public PostRestController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts")
	public ResponseEntity<?> getPosts() {
		List<Post> posts = postService.findAll();
		Resources<Post> resources = new Resources<>(posts);
		resources.add(linkTo(methodOn(PostRestController.class).getPosts()).withSelfRel());
		return ResponseEntity.ok(resources);
	}
}
