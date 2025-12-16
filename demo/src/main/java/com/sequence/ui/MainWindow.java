package com.sequence.ui;

import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import com.sequence.service.NodeService;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.html.Option;
import java.awt.*;
import java.util.Optional;

public class MainWindow extends JFrame {
    private final NodeService nodeService;
    private final SearchPanel searchPanel;
    private OutputPanel outputPanel;
    private Node currentNode;
    private Node nN;
    private Node pN;


    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    JPanel navPanel = new JPanel();
    JButton next = new JButton("Next Node");
    JButton previous = new JButton("Previous Node");

    public MainWindow(NodeService nodeService) {
        this.nodeService = nodeService;
        OutputPanel outputPanel1 = new OutputPanel();
        this.searchPanel = new SearchPanel(nodeService, outputPanel1, this);
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
        mainPanel.add(new SearchPanel(nodeService, outputPanel, this));
        mainPanel.add(outputPanel);


        JPanel leftWrap = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftWrap.add(previous);

        JPanel rightWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightWrap.add(next);

        navPanel.add(leftWrap, BorderLayout.WEST);
        navPanel.add(rightWrap, BorderLayout.EAST);

        navPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        mainPanel.add(navPanel);

        previous.addActionListener( e -> {
            if(currentNode == null) return;
            Optional<Node> previousNode = nodeService.findPrevious(currentNode.getId());
            try{
                previousNode.ifPresentOrElse(
                        node -> {
                            pN = node;
                            if(pN.getStatus() && pN != null){
                                outputPanel.appendText("Previous Node is: " + previousNode);
                            } else if(!pN.getStatus()){
                                JOptionPane.showMessageDialog(this, "You have not unlocked that node yet!");
                            }
                        }, () -> JOptionPane.showMessageDialog(this, "Sorry it seems there is no previous node!")
                );
            } catch (RuntimeException ex) {
                throw new RuntimeException(ex);
            }
        });

        next.addActionListener( e -> {
            if(currentNode == null) return;

            Optional<Node> nextNode = nodeService.findNext(currentNode.getId());
            try{
                nextNode.ifPresentOrElse(
                        node -> {
                            nN = node;
                            if(nN.getStatus() && nN != null){
                                outputPanel.appendText("Next Node is: " + nextNode);
                            } else if(!nN.getStatus()){
                                JOptionPane.showMessageDialog(this, "You have not unlocked that node yet!");
                            }
                        }, () -> JOptionPane.showMessageDialog(this, "Sorry! It seems there is no next node!")
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

}