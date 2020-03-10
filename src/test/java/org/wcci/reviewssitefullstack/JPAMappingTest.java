 package org.wcci.reviewssitefullstack;

 import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


 @RunWith(SpringJUnit4ClassRunner.class)
 @DataJpaTest
 public class JPAMappingTest {
	 	
	@Resource
	private TestEntityManager entityManager;
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Test
	
	public void shouldSaveAndLoadCategory() {
		Category category = categoryRepo.save(new Category("Internet of Things"));
		Long categoryId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Category> result = categoryRepo.findById(categoryId);
		category = result.get();
		assertThat(category.getName(), is("Internet of Things"));	
	}
	
	@Test
	  
	 public void shouldGenerateCatagoryID() {
		Category category = categoryRepo.save(new Category("Internet of Things"));
		Long categoryId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(categoryId, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldSaveAndLoadReview() {
		Review review = new Review("review name", "description", "image", "content", "5");
		review = reviewRepo.save(review);
		Long reviewId = review.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getName(), is("review name"));
	}
	
	@Test
	public void shouldEstablishReviewtoCategoryRelationship() {
		
		Category internetOfThings = categoryRepo.save(new Category("Internet of Things"));
		Category socialMedia = categoryRepo.save(new Category("Social Media"));
		Review review = new Review("Internet of Things", "description", "image", "content", "5",internetOfThings, socialMedia);
		review = reviewRepo.save(review);
		Long reviewId = review.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		
		assertThat(review.getCategories(), containsInAnyOrder(internetOfThings,internetOfThings));
		
	}

	@Test
	public void shouldFindReviewForCategory() {
	Category internetOfThings = categoryRepo.save(new Category ("Internet of Things"));
	
	Review  microsoftAzure = reviewRepo.save(new Review("Microsoft Azure", "Description", "image", "content", "5", internetOfThings));
	Review amazonAws = reviewRepo.save(new Review("Amazon AWS", "Description", "image", "content", "5", internetOfThings));
	
	entityManager.flush();
	entityManager.clear();
	
	Collection<Review> reviewsForCatagory = reviewRepo.findByCategoryContains(internetOfThings);
	
	assertThat(reviewsForCatagory, containsInAnyOrder(microsoftAzure, amazonAws));
	
	}
	
	@Test
	public void shouldFindReviewForCategoryId() {
		Category internetOfThings = categoryRepo.save(new Category("Internet of Things"));
		Long categoryId = internetOfThings.getId();
		
		Review microsoftAzure = reviewRepo.save(new Review("Microsoft Azure", "Description", "image", "content", "5", internetOfThings));
		Review amazonAws = reviewRepo.save(new Review("Amazon AWS", "Description", "image", "content", "5", internetOfThings));
		
		entityManager.flush();
		entityManager.clear();
		
		Collection<Review> reviewsForCategory = reviewRepo.findByCategoryId(categoryId);
		assertThat(reviewsForCategory, containsInAnyOrder(microsoftAzure, amazonAws));
	}
 }
 
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		