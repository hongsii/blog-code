package io.github.hongsii.jpanplus1.service;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.hongsii.jpanplus1.domain.Comment;
import io.github.hongsii.jpanplus1.domain.Post;
import io.github.hongsii.jpanplus1.repository.PostRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostService postService;
	@Autowired
	private PostRepository postRepository;

	@Test
	public void findAll() {
		Post post1 = new Post("포스트1");
		addComments(post1);
		Post post2 = new Post("포스트2");
		addComments(post2);
		Post post3 = new Post("포스트3");
		postRepository.saveAll(asList(post1, post2, post3));

		List<Post> posts = postService.findAll();

		assertThat(posts).extracting(Post::getTitle)
				.containsExactly(post1.getTitle(), post2.getTitle(), post3.getTitle());
	}

	private void addComments(Post post) {
		for (int i = 1; i <= 2; i++) {
			Comment comment = new Comment(post.getTitle() + "-댓글" + i);
			comment.writtenBy(post);
			post.addComment(comment);
		}
	}
}