package com.sequence.ui;

import com.sequence.models.Node;
import com.sequence.service.NodeService;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SearchPanel extends JPanel {
    private final JPasswordField searchField = new JPasswordField(15);
    private final JButton searchButton = new JButton("Search by code");
    private final OutputPanel outputPanel;
    private final MainWindow parent;


    public SearchPanel(NodeService nodeService, OutputPanel outputPanel, MainWindow parent){
        this.outputPanel = outputPanel;
        this.parent = parent;
        setLayout(new FlowLayout());
        add(searchField);
        add(searchButton);

        searchButton.addActionListener(e ->{
            String code = new String(searchField.getPassword());
            nodeService.findByCode(code).ifPresentOrElse(
                    n -> {
                        parent.setCurrentNode(n);
                        n.setStatus(true);
                        nodeService.saveNode(n);
                        outputPanel.appendText("Found Node:\n" + n);
                    },
                    () -> JOptionPane.showMessageDialog(this, "No node can be found with code:\n" + code)
        );
            searchField.setText("");

        });
        KeypadPanel keypad = new KeypadPanel(
                val -> searchField.setText(new String(searchField.getPassword()) + val),
                searchButton::doClick, //triggers upon enter button
                () -> searchField.setText("")
        );

        add(keypad);

    }

}
