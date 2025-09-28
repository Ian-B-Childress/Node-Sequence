package com.sequence;

import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	//little demo from da documents
	@Bean
	CommandLineRunner runner(NodeRepository repository){
		return args -> {
			Node node = new Node();
			node.setCode("rbgb");
			node.setContent("Congrats! You've found the first room.");
			node.setType("text");

			repository.save(node);
			Optional<Node> saved = repository.findById(node.getId());
		};
	}
}
