package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CollectPanel extends JPanel {
    private MainFrame frame;
    public CollectPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(new JLabel("Step 4: Collect Raw Data", SwingConstants.CENTER), BorderLayout.NORTH);

        String[] cols = {"Metric", "Value", "Calculated Score (1-5)"};
        Object[][] data = {
                {"SUS score", "89", "5.0"},
                {"Onboarding time", "5", "5.0"},
                {"Video start time", "2", "4.5"}
        };

        JTable table = new JTable(new DefaultTableModel(data, cols));
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton nextBtn = new JButton("Next Step: Analyse");
        nextBtn.addActionListener(e -> frame.nextStep("Profile ✓ Define ✓ Plan ✓ Collect ✓ Analyse ●"));
        add(nextBtn, BorderLayout.SOUTH);
    }
}