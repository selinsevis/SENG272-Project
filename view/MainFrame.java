package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardContainer;
    private JLabel stepIndicator;

    public MainFrame() {
        setTitle("ISO 15939 Measurement Simulator");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        stepIndicator = new JLabel("Profile ● Define ○ Plan ○ Collect ○ Analyse", SwingConstants.CENTER);
        stepIndicator.setFont(new Font("Arial", Font.BOLD, 18));
        stepIndicator.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(stepIndicator, BorderLayout.NORTH);


        cardLayout = new CardLayout();
        cardContainer = new JPanel(cardLayout);


        cardContainer.add(new ProfilePanel(this), "1");
        cardContainer.add(new DefinePanel(this), "2");
        cardContainer.add(new PlanPanel(this), "3");
        cardContainer.add(new CollectPanel(this), "4");
        cardContainer.add(new AnalysePanel(this), "5");

        add(cardContainer, BorderLayout.CENTER);
    }

    public void nextStep(String statusText) {
        stepIndicator.setText(statusText);
        cardLayout.next(cardContainer);
    }
}