package io.github.hongsii.jpanplus1.repository;

import io.github.hongsii.jpanplus1.domain.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

	@Query("SELECT DISTINCT p FROM Post p JOIN FETCH p.comments")
	List<Post> findAllWithComments();
}
