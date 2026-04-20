
package com.mycompany.mavenproject3;

/*
Group Members:
1) Samuel Dessalegn UGR/2304/14  
2) Leul Gebremariam UGR/3478/15 
3) Yohannes Wale UGR/1232/14 
4) Yohannes Alemu UGR/8644/15 
 --------------------------------
Advisor: Mr. Samuel G.
Submission Date: April 20, 2026  
Section: 2

 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;

public class Mavenproject3 {

    // Function to generate SHA-256 hash
    public static String generateHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            return "Error generating hash";
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hash Generator");
        frame.setSize(500, 320); // slightly larger
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(144, 238, 144));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20)); 

        JLabel inputLabel = new JLabel("Enter Message:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JTextField inputField = new JTextField(25);

        // Button
        JButton hashButton = new JButton("Generate Hash");
        hashButton.setBackground(new Color(34, 139, 34)); // darker green
        hashButton.setForeground(Color.WHITE);

        // Output
        JTextArea outputArea = new JTextArea(5, 30);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Button
        hashButton.addActionListener((ActionEvent e) -> {
            String input = inputField.getText();
            String hash = generateHash(input);
            outputArea.setText(hash);
        });

        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(hashButton);
        panel.add(new JScrollPane(outputArea));
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
