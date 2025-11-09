package com.sequence.ui;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class KeypadPanel extends JPanel {

    public KeypadPanel(Consumer<Integer> onNumberPressed, Runnable onEnterPressed) {
        setLayout(new GridLayout(4, 3, 5, 5));

        // 3,2,1,4,5,6,9,8,7,0
        List<Integer> keypadValues = new ArrayList<>(List.of(3, 2, 1, 4, 5, 6, 9, 8, 7, 0));

        for (int i = 0; i < 9; i++) {
            int val = keypadValues.get(i);
            JButton b = new JButton(String.valueOf(val));
            b.setBackground(Color.DARK_GRAY);
            b.setForeground(Color.WHITE);
            b.addActionListener(e -> onNumberPressed.accept(val));
            add(b);
        }

        //blank placeholder (bottom left)
        add(new JLabel(""));

        //0 button
        JButton zeroButton = new JButton(String.valueOf(keypadValues.get(9)));
        zeroButton.setBackground(Color.DARK_GRAY);
        zeroButton.setForeground(Color.WHITE);
        zeroButton.addActionListener(e -> onNumberPressed.accept(keypadValues.get(9)));
        add(zeroButton);

        //enter button
        JButton enterButton = new JButton("ENTER");
        enterButton.setBackground(Color.BLACK);
        enterButton.setForeground(Color.WHITE);
        enterButton.addActionListener(e -> onEnterPressed.run());
        add(enterButton);
    }
}