package com.curso.angular4.apicurso.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="COMMENTS_ID_GENERATOR", sequenceName="SEQ_COMMENTS")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMENTS_ID_GENERATOR")
	private int id;

	@Lob
	private String body;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	private Video video;

	public Comment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}