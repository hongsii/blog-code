package io.github.hongsii.jpanplus1.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String title;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.EAGER)
	@OrderBy("id desc")
	private List<Comment> comments = new ArrayList<>();

	public Post() {}

	public Post(String title) {
		this.title = title;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public String getTitle() {
		return title;
	}

	public List<Comment> getComments() {
		return comments;
	}
}
