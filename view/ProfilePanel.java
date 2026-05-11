package view;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private JTextField userField, schoolField, sessionField;
    private MainFrame frame;


    public ProfilePanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);


        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Username:"), gbc);
        userField = new JTextField(20); gbc.gridx = 1; add(userField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("School:"), gbc);
        schoolField = new JTextField(20); gbc.gridx = 1; add(schoolField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Session Name:"), gbc);
        sessionField = new JTextField(20); gbc.gridx = 1; add(sessionField, gbc);

        JButton nextBtn = new JButton("Next Step");
        gbc.gridx = 1; gbc.gridy = 3; add(nextBtn, gbc);

        nextBtn.addActionListener(e -> {

            if (userField.getText().trim().isEmpty() || schoolField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                frame.nextStep("Profile ✓ Define ● Plan ○ Collect ○ Analyse");
            }
        });
    }
}