package com.curso.angular4.apicurso.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the videos database table.
 * 
 */
@Entity
@Table(name="videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name="VIDEOS_ID_GENERATOR", sequenceName="SEQ_VIDEOS")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIDEOS_ID_GENERATOR")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Lob
	private String description;

	private String image;

	private String status;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="video_path")
	private String videoPath;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="video")
	private List<Comment> comments;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Video() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getVideoPath() {
		return this.videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setVideo(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setVideo(null);

		return comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}