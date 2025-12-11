package com.sequence;


import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import com.sequence.service.NodeService;
import com.sequence.ui.MainWindow;
import com.sequence.ui.OutputPanel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.sound.midi.Sequence;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//YES MR. GPT HELPED WITH SWING, (steeper learning curve than I imagined...)
		System.setProperty("java.awt.headless", "false");
		ApplicationContext context = SpringApplication.run(Application.class, args);
		NodeService nodeService = context.getBean(NodeService.class);


		SwingUtilities.invokeLater(() -> {
			MainWindow window = new MainWindow(nodeService);
			window.setVisible(true);
		});

	}

	//TODO: testing window, cli not needed at the moment.

//	@Bean
//	CommandLineRunner runner(NodeService nodeService){
//		return args -> {
//			Scanner scanner = new Scanner(System.in);
//
//			while(true){
//				System.out.println("Choose action: [1] Create Node, [2] List Nodes, [3] Exit, [4] Search For Node By Code");
//				String choice = scanner.nextLine();
//
//				switch (choice){
//					case "1":
//						Node newNode = new Node();
//
//						System.out.println("Enter code: ");
//						newNode.setCode(scanner.nextLine());
//
//						System.out.println("Enter content: ");
//						newNode.setContent(scanner.nextLine());
//
//						System.out.println("Enter content type (text, url, etc..): ");
//						newNode.setType(scanner.nextLine());
//
//
//						nodeService.saveNode(newNode);
//						System.out.println("Node saved with id: " + nodeService.getNodeById(newNode.getId()));
//						break;
//
//					case "2":
//						System.out.println("All current nodes: ");
//						nodeService.getAllNodes().forEach(System.out::println);
//						break;
//
//					case "3":
//						System.out.println("Enter Code: ");
//						nodeService.findByCode(scanner.nextLine());
//
//						return;
//
//					case "4":
//						System.out.println("Exiting... ");
//						return;
//
//					default:
//						System.out.println("invalid option");
//				}
//
//			}
//
//		};
//	}


}
