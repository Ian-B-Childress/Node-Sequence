package com.sequence.ui;

import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import com.sequence.service.NodeService;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Optional;

public class MainWindow extends JFrame {
    private final NodeService nodeService;
    private final SearchPanel searchPanel;
    private OutputPanel outputPanel;


    JPanel navPanel = new JPanel();
    JButton next = new JButton("Next Node");
    JButton previous = new JButton("Previous Node");

    public MainWindow(NodeService nodeService) {
        this.nodeService = nodeService;
        OutputPanel outputPanel1 = new OutputPanel();
        this.searchPanel = new SearchPanel(nodeService, outputPanel1);
        setupFrame();
        setupLayout();
    }

    private void setupFrame() {
        setTitle("Node Sequence Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1000);
        setLocationRelativeTo(null);
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        JLabel titleLabel = new JLabel("Welcome!");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        //single output
        OutputPanel outputPanel = new OutputPanel();


        //add panels
        mainPanel.add(new CreatePanel(nodeService));
        mainPanel.add(new SearchPanel(nodeService, outputPanel));
        mainPanel.add(outputPanel);


        JPanel leftWrap = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftWrap.add(previous);

        JPanel rightWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightWrap.add(next);

        navPanel.add(leftWrap, BorderLayout.WEST);
        navPanel.add(rightWrap, BorderLayout.EAST);

        navPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        mainPanel.add(navPanel);
    }

    private Optional<Node> nodeNav(Node node){
        previous.addActionListener(e -> {
            //TODO figure out what to do here..
            Optional<Node> returnedNode = nodeService.findPrevious(node.getId());
            outputPanel.appendText(returnedNode.toString());
        });
        return Optional.empty();
    }
}