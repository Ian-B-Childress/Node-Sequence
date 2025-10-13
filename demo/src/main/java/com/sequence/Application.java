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

	}



	@Bean
	CommandLineRunner runner(NodeService nodeService){
		return args -> {
			Scanner scanner = new Scanner(System.in);

			while(true){
				System.out.println("Choose action: [1] Create Node, [2] List Nodes, [3] Exit, [4] Search For Node By Code");
				String choice = scanner.nextLine();

				switch (choice){
					case "1":
						Node newNode = new Node();

						System.out.println("Enter code: ");
						newNode.setCode(scanner.nextLine());

						System.out.println("Enter content: ");
						newNode.setContent(scanner.nextLine());

						System.out.println("Enter content type (text, url, etc..): ");
						newNode.setType(scanner.nextLine());


						nodeService.saveNode(newNode);
						System.out.println("Node saved with id: " + nodeService.getNodeById(newNode.getId()));
						break;

					case "2":
						System.out.println("All current nodes: ");
						nodeService.getAllNodes().forEach(System.out::println);
						break;

					case "3":
						System.out.println("Enter Code: ");
						nodeService.findByCode(scanner.nextLine());

						return;


					default:
						System.out.println("invalid option");
				}

			}

		};
	}


}
