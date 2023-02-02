package qodous.erp.inventory.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "summary")
	private String summary;
	@Column(name = "created_at")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdAt;
	@Column(name = "updated_at")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@Column(name = "content")
	private String content;
	
	public Brand() {}
	
	public Brand(int id, String title, String summary, Date createdAt, Date updatedAt, String content) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "$$.. Brand [id:" + id + ", title:" + title + ", summary:" + summary + ", createdAt:" + createdAt
				+ ", updatedAt:" + updatedAt + ", content:" + content + "]";
	}
}
