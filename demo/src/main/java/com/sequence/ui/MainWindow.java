package com.sequence.ui;

import com.sequence.service.NodeService;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final NodeService nodeService;
    private final SearchPanel searchPanel;

    public MainWindow(NodeService nodeService) {
        this.nodeService = nodeService;

        OutputPanel outputPanel = new OutputPanel();
        this.searchPanel = new SearchPanel(nodeService, outputPanel);
        
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


    }
}