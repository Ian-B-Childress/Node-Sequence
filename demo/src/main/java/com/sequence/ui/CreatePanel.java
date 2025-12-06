package com.sequence.ui;

import com.sequence.models.Node;
import com.sequence.service.NodeService;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreatePanel extends JPanel {
    private boolean formOpen = false;
    private boolean revealCode = false;

    public CreatePanel(NodeService nodeService) {

        //form panel
        JPanel formPanel = new JPanel(new FlowLayout());
        formPanel.setVisible(false);


        //buttons
        JButton showCode = new JButton("Reveal Node Code");
        JButton createButton = new JButton("Create Node");
        JButton newNodeButton = new JButton("Create New Node");

        //fields/labels
        add(createButton);
        JLabel codeLabel = new JLabel("Code:");
        JPasswordField codeField = new JPasswordField(10);
        JLabel contentLabel = new JLabel("Content:");
        JTextField contentField = new JTextField(10);
        JLabel typeLabel = new JLabel("Type:");
        JTextField typeField = new JTextField(10);

        //adding all elements to form panel
        formPanel.add(codeLabel);
        formPanel.add(codeField);
        codeField.setEditable(false);
        formPanel.add(contentLabel);
        formPanel.add(contentField);
        formPanel.add(typeLabel);
        formPanel.add(typeField);

        formPanel.add(newNodeButton);
        formPanel.add(showCode);
        add(formPanel);

        //keypad functions
        Runnable submitForm = () -> {
            System.out.println("Submitting: " + codeField.getPassword());
        };

        KeypadPanel keypad = new KeypadPanel(
                val -> codeField.setText(new String(codeField.getPassword()) + val),
                submitForm,
                () -> codeField.setText("")
        );
        //unhide password
        showCode.addActionListener(e -> {
            revealCode = !revealCode;
            codeField.setEchoChar(revealCode ? (char) 0 : '*');
        });

        //first event listener
        createButton.addActionListener(e -> {

            if (formOpen) {
                return;
            }
            formOpen = true;

            formPanel.add(keypad);

            formPanel.setVisible(true);
            showCode.setVisible(false);


            revalidate();
            repaint();


        });

        //final create listener
        newNodeButton.addActionListener(e -> {
            String code = new String(codeField.getPassword());
            String content = contentField.getText().trim();
            String type = typeField.getText().trim();

            if (code.isEmpty() || content.isEmpty() || type.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be populated.");
                codeField.setText("");
                contentField.setText("");
                typeField.setText("");

                return;
            }

            Node newNode = new Node();
            newNode.setCode(code);
            newNode.setContent(content);
            newNode.setType(type);
            nodeService.saveNode(newNode);

            JOptionPane.showMessageDialog(this, "Node successfully created.");

            codeField.setText("");
            contentField.setText("");
            typeField.setText("");
            formPanel.setVisible(false);
            formOpen = false;

        });
    }
}
