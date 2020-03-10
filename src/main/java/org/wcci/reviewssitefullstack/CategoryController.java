package org.wcci.reviewssitefullstack;



import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CategoryController {

	@Resource
	CategoryRepository categoryRepo;
	
	@RequestMapping("/category")
	public String findOneCategory(@RequestParam(value="id") long id, Model model) throws CategoryNotFoundException {
		Optional<Category> category = categoryRepo.findById(id);
		
		if(category.isPresent()) {
			
			model.addAttribute("category", category.get());
			return "category";
		}
		
		throw new CategoryNotFoundException();
		
	}

	@RequestMapping("/categories")
	public String findAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return ("categories");
	}
	
}
