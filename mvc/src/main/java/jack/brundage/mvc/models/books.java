package jack.brundage.mvc.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3, max = 200)
	private String title;
	
	@NotNull
	@Size(min = 5, max = 200)
	private String description;
	
	@NotNull
	@Size(min = 3, max = 40)
	private String language;
	
	@NotNull
	@Min(100)
	private Integer numOfPages;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public books() {
	}
	
	public books(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numOfPages = pages;
    }	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(Integer numOfPages) {
		this.numOfPages = numOfPages;
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
	@PrePersist
	protected void onCreate () {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate () {
		this.updatedAt = new Date();
	}
}