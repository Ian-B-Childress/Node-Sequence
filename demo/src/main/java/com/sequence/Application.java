package com.sequence;

import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import com.sequence.service.NodeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		NodeService nodeService = context.getBean(NodeService.class);
	}



	@Bean
	CommandLineRunner runner(NodeService nodeService){
		return args -> {
			Scanner scanner = new Scanner(System.in);

			while(true){
				System.out.println("Choose action: [1] Create Node, [2] List Nodes, [3] Exit");
				String choice = scanner.nextLine();

				

			}

		};
	}


}
