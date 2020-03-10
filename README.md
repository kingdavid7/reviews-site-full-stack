Reviews Site, Full Stack

Overview
Return to your reviews site from the previous exercise (or create another).

Creating a new repository from an existing one
If you are continuing with your reviews site from the previous exercise, create a new GitHub repo based on a clone of your old project repo. Here’s a simple way to go about that:

Create another clone with a different name. The git clone command will accept an additional argument specifying a folder name, so you can do something like: git clone http://github.com/myid/reviews-site reviews-site-full-stack.
The .git folder is what establishes the folder in which it resides as a git repository. Remove the .git folder from this newly cloned repo. You can do this from Windows Explorer or by running rm -rf .git from Git Bash. Now it’s no longer a git repository.
Treat it now just like any other new project: git init, etc.
We’re going to add categories to reviews. Each category will have one or more reviews (a one to many relationship). Each review will be assigned to one category (a many to one relationship).

Also, we’re going to JPA-enable your site so that it writes/reads from an H2 database.

Tasks
Feel free to use appropriate class names other than Review and Category, but these instructions will refer to Review and Category.

Add the following dependencies to build.gradle (or use Spring Initializr to create a new build.gradle)
JPA (spring-boot-starter-data-jpa)
H2
Create a Category class that:
is a JPA entity.
contains an instance variable referencing the Reviews it contains.
configures an appropriate JPA relationship to its reviews.
Update the Review class such that:
it is a JPA entity.
configures a JPA relationship to its associated category.
allows for a description/content/body longer than 255 characters.
Update your view (templates/html/css) such that:
there is a page that lists review categories, each of which links to the (details) page for a specific category.
there is a page that lists the reviews for a chosen category, each of which links to the (details) page for a specific review.
each review detail page has a link to the page for its category.
Stretch Tasks
Tags
Create a Tag entity.
Update Review so that it can have tags associated with it. A review can have many tags, a tag can be assigned to many reviews.
Display tags on the review details page.
Create a page that displays links to all of the reviews associated with a given tag.
Stretchier
Style your tags list template as a tag cloud, making tags which appear more often larger and/or bolder and those that appear less often smaller and/or lower weight.
Allow creation and deletion of tags from a review using <form> and <button> elements along with the appropriate controller method(s).
Grading
Find the rubric here.

Tips
Start with the known specifics
Start with mapping and displaying your Reviews. Add Categorys to them after you’ve gotten that working.

Mapping out URLs, Model attributes, view template names, etc
It is good practice to map things out and think them through, using plural and singular names appropriately, or you’ll likely be well confused.

Your names, etc will be different, but hopefully this helps with some of the confusion I’ve seen around naming and what is in the model for a specific view. I’ll append model and view to names to help clarify, though we usually wouldn’t do this in the wild. Create your own table that maps these things out:

Page Intent	URL (mapped via @RequestMapping)	Description of model attribute	Model Attribute	Retrieved via	View will display	View Template name
Categories List	/categories	an Iterable of all Category objects	“categoriesModel”	repo findAll	list of categories	“categoriesView”
Category details, including a list of reviews for the chosen category	/categories/42	the Category object associated with id	“singleCategoryModel”	repo findOne	category detail and list of reviews for that category, each of which links to a review	“singleCategoryView”
Review details	/reviews/86	the Review object associated with id	“reviewModel”	repo findOne	review details	“reviewView”
String fields longer than 255 characters
For instance variables that hold things like descriptions, which may be longer than 255 characters, you will need to indicate that this should be stored in a CLOB (Character Large OBject). To do, this use the @Lob annotation on your instance variable, like so:

@Lob
private String description;
See LOBs, BLOBs, CLOBs and Serialization in the Java Persistence wikibook.
