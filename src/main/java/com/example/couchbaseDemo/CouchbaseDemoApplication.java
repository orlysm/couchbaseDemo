package com.example.couchbaseDemo;

import com.example.couchbaseDemo.domain.Example;
import com.example.couchbaseDemo.repository.ExampleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CouchbaseDemoApplication {

	private final ExampleRepository exampleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CouchbaseDemoApplication.class, args);
	}

	public CouchbaseDemoApplication(ExampleRepository exampleRepository) {
		this.exampleRepository = exampleRepository;
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("Saving a new example");
		Example saved = exampleRepository.save(new Example("Hello World"));
		System.out.println("Example saved: " + saved);

		System.out.println("Examples in db: " + exampleRepository.count());

		System.out.println("Example exists in db: " + exampleRepository.existsById(saved.id));

		Example found = exampleRepository.findById(saved.id).orElseThrow(() -> new RuntimeException("Example is gone"));
		System.out.println("Found example by id: " + found);

		Page<Example> examples = exampleRepository.findAll(PageRequest.of(0, 20));
		System.out.println("Found all examples: " + examples.stream().collect(Collectors.toList()));

		System.out.println("Deleting example by id: " + saved.id);
		exampleRepository.delete(saved);
		System.out.println("Examples in db: " + exampleRepository.count());

		System.out.println("Deleting all examples");
		exampleRepository.deleteAll();
		System.out.println("Examples in db: " + exampleRepository.count());
	}
}
