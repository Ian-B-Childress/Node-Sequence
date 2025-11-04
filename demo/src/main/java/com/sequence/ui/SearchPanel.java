package com.sequence.ui;

import com.sequence.service.NodeService;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    private final JTextField searchField = new JTextField(15);
    private final JButton searchButton = new JButton("Search by code");

    public SearchPanel(NodeService nodeService){
        setLayout(new FlowLayout());
        add(searchField);
        add(searchButton);

        searchButton.addActionListener(e ->{
            String code = searchField.getText();
            nodeService.findByCode(code).ifPresentOrElse(
                    n -> JOptionPane.showMessageDialog(this, "Found Node:\n" + n),
                    () -> JOptionPane.showMessageDialog(this, "No node can be found with code:\n" + code)
            );
        });
    }
}
