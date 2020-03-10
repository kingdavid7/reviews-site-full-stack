package org.wcci.reviewssitefullstack;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

 public class ReviewControllerTest {
	
	@InjectMocks
	private ReviewController reviewTest;
	
	@InjectMocks
	private CategoryController categoryTest;
	
	@Mock
	private Review review;
	
	@Mock
	private Review review2;
	
	@Mock
	private ReviewRepository reviewRepo;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category;
	
	@Mock
	private Category category2;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void shouldAddSingleReviewToModel() throws ReviewNotFoundException {
		long arbitraryReviewId = 1;
		when(reviewRepo.findById(arbitraryReviewId)).thenReturn(Optional.of(review));
		
		reviewTest.findOneReview(arbitraryReviewId, model);
		verify(model).addAttribute("review", review);
	}
	
	@Test
	public void shouldAddAllReviewsToModel() {
		Collection<Review> allReviews = Arrays.asList(review, review2);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		reviewTest.findAllReviews(model);
		verify(model).addAttribute("review", allReviews);
		
	}
	
	@Test
	public void shouldAddSingleCategoryToModel()throws CategoryNotFoundException {
		long arbitraryCategoryId = 1;
		when(categoryRepo.findById(arbitraryCategoryId)).thenReturn(Optional.of(category));
		
		categoryTest.findOneCategory(arbitraryCategoryId, model);
		verify(model).addAttribute("category", category);
	}
	
	@Test
	public void shouldAddAllCategoriesToModel() {
		Collection<Category> allCategories = Arrays.asList(category,category2);
		when(categoryRepo.findAll()).thenReturn(allCategories);
		
		categoryTest.findAllCategories(model);
		verify(model).addAttribute("category", allCategories);
		
	}
		
	}
