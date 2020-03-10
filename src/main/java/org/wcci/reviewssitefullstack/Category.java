package org.wcci.reviewssitefullstack;

 import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy = "catagories")
	
	private Collection<Review> reviews;
	public Collection<Review> getReviews() {
		return reviews;
	}
	
	//default no args constructor required by JPA
  
	public Category() {
		
	}

	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		
		return id;
	}
	
    public String getName() {
		
		return name;
 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
 
  
	

}
