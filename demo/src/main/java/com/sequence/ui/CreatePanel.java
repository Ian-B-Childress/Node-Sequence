package com.sequence.ui;

import com.sequence.models.Node;
import com.sequence.service.NodeService;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CreatePanel extends JPanel {
    private boolean formOpen = false;
    private boolean revealCode = false;
    public CreatePanel(NodeService nodeService){


        setLayout(new FlowLayout());

        JButton showCode = new JButton("Reveal Node Code");
        JButton createButton = new JButton("Create Node");
        JButton newNodeButton = new JButton("Create New Node");



        add(createButton);
        JLabel codeLabel = new JLabel("Code:");
        JPasswordField codeField = new JPasswordField(10);
        JLabel contentLabel = new JLabel("Content:");
        JTextField contentField = new JTextField(10);
        JLabel typeLabel = new JLabel("Type:");
        JTextField typeField = new JTextField(10);

        showCode.addActionListener(e -> {
           revealCode = true;
        });

        createButton.addActionListener(e -> {

            if(formOpen){return;}
            formOpen = true;

            Runnable submitForm = () -> {
                System.out.println("Submitting: " + codeField.getPassword());
            };

            KeypadPanel keypad = new KeypadPanel(
                    val -> codeField.setText(new String(codeField.getPassword()) + val),
                    submitForm,
                    () -> codeField.setText("")
            );

            //TODO: get labels to pop up after i either A: click 'create node' or B: after i hit enter on keypad
                        add(codeLabel);
                        add(codeField);
                        codeField.setEditable(false);
                        if(revealCode){
                            codeField.setEchoChar((char) 0);
                        }
                        add(contentLabel);
                        add(contentField);
                        add(typeLabel);
                        add(typeField);
                        add(keypad);
                        add(newNodeButton);
                        add(showCode);
                        showCode.setVisible(true);
                        revalidate();
                        repaint();


        });
                newNodeButton.addActionListener(e -> {
                    String code = new String(codeField.getPassword());
                    String content = contentField.getText().trim();
                    String type = typeField.getText().trim();

                    if(code.isEmpty() || content.isEmpty() || type.isEmpty()){
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
                    formOpen = false;
                } );
    }
}
