package com.codingdojo.Burgar_tracker_1.models;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burger")
public class Burger {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	//for id
	@NotNull
    @Size(min = 5, max = 200)
    private String burger_name;
	//for name burger
	@NotNull
    @Size(min = 5, max = 200)
    private String rest_name;
	//for resturant name
	@NotNull
	@Min(1)
	@Max(5)
    private Integer rate;
	//for rating
	@NotNull
    @Size(min = 5, max = 200)
    private String note;
	//for note
	 @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    public Burger() {
	    }
	    public Burger(String burger_name, String rest_name,  int rate,String note) {
	        this.burger_name = burger_name;
	        this.rest_name = rest_name;
	        this.rate = rate;
	        this.note = note;
	    }
	    //setter and getter 
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBurger_name() {
			return burger_name;
		}
		public void setBurger_name(String burger_name) {
			this.burger_name = burger_name;
		}
		public String getRest_name() {
			return rest_name;
		}
		public void setRest_name(String rest_name) {
			this.rest_name = rest_name;
		}
		public Integer getRate() {
			return rate;
		}
		public void setRate(Integer rate) {
			this.rate = rate;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
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
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
}
