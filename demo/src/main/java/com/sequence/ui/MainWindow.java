package com.sequence.ui;

import com.sequence.service.NodeService;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private final NodeService nodeService;


    public MainWindow(NodeService nodeService) {
        this.nodeService = nodeService;

    }

    private void setupFrame(){
        setTitle("Node Sequence Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setLocationRelativeTo(null);
    }

    private void setupLayout(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        JLabel titleLabel = new JLabel("Welcome!");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        //here we add each other panel

        mainPanel.add(new CreatePanel(nodeService));
        mainPanel.add(new SearchPanel(nodeService));
        mainPanel.add(new OutputPanel());

        mainPanel.setVisible(true);
    }
}
