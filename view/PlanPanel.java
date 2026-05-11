package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlanPanel extends JPanel {
    private MainFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public PlanPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel title = new JLabel("Step 3: Plan Measurement", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);


        String[] columns = {"Metric", "Coeff", "Direction", "Range", "Unit"};

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Read-only kuralı [cite: 48]
            }
        };

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);


        loadData();


        JButton nextBtn = new JButton("Next Step: Collect Data");
        nextBtn.setPreferredSize(new Dimension(150, 40));
        nextBtn.addActionListener(e -> {

            frame.nextStep("Profile ✓ Define ✓ Plan ✓ Collect ● Analyse");
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(nextBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadData() {
        Object[][] sampleData = {
                {"SUS score", "50", "Higher↑", "0-100", "points"},
                {"Onboarding time", "50", "Lower↓", "0-60", "min"},
                {"Video start time", "50", "Lower↓", "0-15", "sec"},
                {"Concurrent exams", "50", "Higher↑", "0-600", "users"}
        };

        for (Object[] row : sampleData) {
            tableModel.addRow(row);
        }
    }
}