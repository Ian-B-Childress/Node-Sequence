package com.sequence.ui;

import com.sequence.models.Node;
import com.sequence.service.NodeService;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class CreatePanel extends JPanel {
    public CreatePanel(NodeService nodeService){

        setLayout(new FlowLayout());

        JLabel codeLabel = new JLabel("Code:");
        JTextField codeField = new JTextField(10);
        JLabel contentLabel = new JLabel("Content:");
        JTextField contentField = new JTextField(10);
        JLabel typeLabel = new JLabel("Type:");
        JTextField typeField = new JTextField(10);
        JButton createButton = new JButton("Create Node");


        add(createButton);


        KeypadPanel keypad = new KeypadPanel(
                val -> codeField.setText(codeField.getText() + val),
                createButton::doClick, //triggers upon enter button
                () -> codeField.setText("")
        );


        createButton.addActionListener(e -> {

            //TODO: get labels to pop up after i either A: click 'create node' or B: after i hit enter on keypad
            add(codeLabel);
            add(codeField);
            add(contentLabel);
            add(contentField);
            add(typeLabel);
            add(typeField);


            String code = codeField.getText().trim();
            String content = contentField.getText().trim();
            String type = typeField.getText().trim();




            if(code.isEmpty() || content.isEmpty() || type.isEmpty()){
                JOptionPane.showMessageDialog(
                        this, "All fields (Code, Content, and Type) are required.",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            Node node = new Node();
            node.setCode(code);
            node.setContent(content);
            node.setType(type);
            nodeService.saveNode(node);

            JOptionPane.showMessageDialog(this, "Saved Node: " + node);
            codeField.setText("");
            contentField.setText("");
            typeField.setText("");
        });
        add(keypad);
    }
}
