package org.wcci.reviewssitefullstack;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	Collection<Review> findCategoriesContains(Category name);

	Collection<Review> findByCategoryContains(Category category);

	Collection<Review> findByCategoryId(Long Id);

}
