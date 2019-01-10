package io.github.hongsii.jpanplus1.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.github.hongsii.jpanplus1.domain.Post;
import io.github.hongsii.jpanplus1.domain.QComment;
import io.github.hongsii.jpanplus1.domain.QPost;
import java.util.List;

public class PostRepositoryImpl implements PostRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;
	private final QPost post = QPost.post;
	private final QComment comment = QComment.comment;

	public PostRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
		this.jpaQueryFactory = jpaQueryFactory;
	}

	@Override
	public List<Post> findPosts() {
		return jpaQueryFactory
				.selectFrom(post)
				.leftJoin(post.comments, comment)
				.fetchJoin()
				.distinct()
				.orderBy(post.id.asc())
				.fetch();
	}
}
