package com.sequence;

import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import com.sequence.service.NodeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//YES MR. GPT HELPED WITH SWING, (steeper learning curve than I imagined...)
		System.setProperty("java.awt.headless", "false");
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		NodeService nodeService = context.getBean(NodeService.class);

		//creates and shows ui
		SwingUtilities.invokeLater(() -> createAndShowGUI(nodeService));


	}

	private static void createAndShowGUI(NodeService nodeService){
		JFrame frame = new JFrame("Node Sequence Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);

		JLabel label = new JLabel("Welcome to my DNS project! (not the internet DNS)");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(0, 20)));
		//frame -> panel -> label
		//parent -> child -> child

		JLabel codeLabel = new JLabel("Code: ");
		JTextField codeField = new JTextField(20);
		JLabel contentLabel = new JLabel("Content: ");
		JTextField contentField = new JTextField(20);
		JLabel typeLabel = new JLabel("Content Type: ");
		JTextField typeField = new JTextField(20);
		JButton createButton = new JButton("Create Node");

		JPanel createPanel = new JPanel();
		createPanel.add(codeLabel);
		createPanel.add(codeField);
		createPanel.add(contentLabel);
		createPanel.add(contentField);
		createPanel.add(typeLabel);
		createPanel.add(typeField);
		createPanel.add(createButton);
		panel.add(createPanel);

		//Lists nodes:
		JButton listButton = new JButton("List All Nodes");
		listButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(listButton);

		//Search node by ...
		JPanel searchPanel = new JPanel();
		JTextField searchField = new JTextField(15);
		JButton searchButton = new JButton("Search by Code");
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		panel.add(searchPanel);

		//output area
		JTextArea outputArea = new JTextArea(15, 60);
		outputArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputArea);
		panel.add(scrollPane);

		//actions
		//create node
		createButton.addActionListener(e -> {
			Node node = new Node();
			node.setCode(codeField.getText());
			node.setContent(contentField.getText());
			node.setType(typeLabel.getText());
			nodeService.saveNode(node);
			outputArea.append("Saved Node: " + node + "\n");
			codeField.setText("");
			contentField.setText("");
			typeField.setText("");
		});

		//list all nodes
		listButton.addActionListener(e -> {
			outputArea.setText("");
			nodeService.getAllNodes().forEach(n -> {outputArea.append(n.toString() + "\n");});
		});

		//search node
		searchButton.addActionListener(e -> {
			String code = searchField.getText();
			nodeService.findByCode(code).ifPresentOrElse(
					//if it exists, sets output area to the found nodes content
					n -> outputArea.setText("Found Node:\n" + n + "\n"),
							//if not found, returns not found + code inputted
					//glorified switch case
							() -> outputArea.setText("No node with code: " + code + "\n"));
		});

		frame.setVisible(true);
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
