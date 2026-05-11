package view;

import javax.swing.*;
import java.awt.*;

public class DefinePanel extends JPanel {
    private MainFrame frame;

    public DefinePanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));


        add(new JLabel("Select Quality Type:"));
        JRadioButton prod = new JRadioButton("Product Quality");
        JRadioButton proc = new JRadioButton("Process Quality");
        ButtonGroup bg1 = new ButtonGroup(); bg1.add(prod); bg1.add(proc);
        add(prod); add(proc);

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(new JLabel("Select Mode:"));
        JRadioButton health = new JRadioButton("Health");
        JRadioButton edu = new JRadioButton("Education");
        ButtonGroup bg2 = new ButtonGroup(); bg2.add(health); bg2.add(edu);
        add(health); add(edu);

        add(Box.createRigidArea(new Dimension(0, 30)));
        JButton nextBtn = new JButton("Next Step");
        nextBtn.addActionListener(e -> frame.nextStep("Profile ✓ Define ✓ Plan ● Collect ○ Analyse"));
        add(nextBtn);
    }
}