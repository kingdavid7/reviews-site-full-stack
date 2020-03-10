package org.wcci.reviewssitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;

public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Category internetOfThings = new Category("Internet of Things");
		internetOfThings = categoryRepo.save(internetOfThings);
		Category socialMedia  = new Category("Social Media");
		socialMedia = categoryRepo.save(socialMedia);
		
		Review microsoftAzure = new Review("Microsoft Azure", "Project Red Dog!", "/images/microsoftAZURE.jpg", " is a cloud computing service created by Microsoft. "
				+ "for building, testing, deploying, and managing applications and services through Microsoft-managed data centers"
				+ " it provides SaaS,PaaS and IaaS", "3/5", internetOfThings);
		microsoftAzure = reviewRepo.save(microsoftAzure);
		
		Review amazonAws = new Review("Amazon AWS", "is a subsidiary of Amazon", "/images/AWS.png", " these cloud computing web services provide a set of primitive abstract technical infrastructure and distributed computing building blocks and tools."
				+ " One of these services is Amazon Elastic Compute Cloud, which allows users to have at their disposal a virtual cluster of computers, available all the time, through the Internet."
				+ " Amazon markets AWS to subscribers as a way of obtaining large scale computing capacity more quickly and cheaply than building an actual physical server farm."
				+ " All services are billed based on usage, but each service measures usage in varying ways"
				+ " As of 2017, AWS owns a dominant 34% of all cloud (IaaS, PaaS) ", "4/5", internetOfThings);
		amazonAws = reviewRepo.save(amazonAws);
		
		Review memoFeed = new Review("Memory and Feedback", "Grateful Memory & Positive Feedback", "/images/memofeed.jpg", "MemoFeed is an American microblogging and social networking service on which users post and interact by sharing Grateful Memories."
				+ " It was founded by King David NEWMAN,originally as eMomoful.com—today's Memofeed, a popular global social networking website. Memofeed is one of the world's most valuable companies. "
				+ "It is considered one of the Big Five technology companies.!", "5/5", socialMedia);
		memoFeed = reviewRepo.save(memoFeed);
		
		Review slack = new Review("Slack", "Online Tech Workshop ", "/images/slack.jfif", "Slack began as an internal tool for Stewart Butterfield's company Tiny Speck during the development of Glitch, an online game"
				+ " lack offers many IRC-style features, including persistent chat rooms (channels) organized by topic, private groups, and direct messaging "
				+ "Content, including files, conversations, and people, is all searchable within Slack. Users can add emoji buttons to their messages, on which other users can then click to express their reactions to messages"
				+ " There are a number of free and open-source software...!", "2/5", socialMedia);
		slack = reviewRepo.save(slack);							
		
	}
}
