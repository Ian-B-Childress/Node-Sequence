package com.sequence.ui;

import javax.swing.*;

public class OutputPanel extends JPanel {
    private final JTextArea outputArea = new JTextArea(15, 60);

    public OutputPanel(){
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane);
    }

    public void appendText(String text){
        outputArea.append(text + "\n");
    }

    public void setText(String text){
        outputArea.setText(text);
    }


}
