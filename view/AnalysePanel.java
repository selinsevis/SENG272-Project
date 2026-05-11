package view;

import javax.swing.*;
import java.awt.*;


public class AnalysePanel extends JPanel {
    private MainFrame frame;

    public AnalysePanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel title = new JLabel("Step 5: Measurement Analysis", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 0));


        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.Y_AXIS));
        progressPanel.setBorder(BorderFactory.createTitledBorder("Dimension-Based Scores"));

        progressPanel.add(createScoreBar("Usability", 4.5));
        progressPanel.add(createScoreBar("Performance", 3.0));
        progressPanel.add(createScoreBar("Accessibility", 4.0));
        progressPanel.add(createScoreBar("Reliability", 3.5));
        progressPanel.add(createScoreBar("Functionality", 4.2));


        RadarChart radarChart = new RadarChart();

        centerPanel.add(progressPanel);
        centerPanel.add(radarChart);
        add(centerPanel, BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        String gapText = "<html><b>Gap Analysis:</b><br>" +
                "Lowest Dimension: Performance (3.0)<br>" +
                "Gap Value: 2.0 (5.0 - 3.0)<br>" +
                "Level: Needs Improvement<br>" +
                "<i>'This dimension has the lowest score and requires the most improvement.'</i></html>";

        JLabel gapLabel = new JLabel(gapText);
        gapLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(gapLabel, BorderLayout.CENTER);

        JButton finishBtn = new JButton("Complete Project");
        finishBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "ISO 15939 Project Completed Successfully!"));
        bottomPanel.add(finishBtn, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }


    private JPanel createScoreBar(String name, double score) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel(name + ": " + score), BorderLayout.NORTH);
        JProgressBar bar = new JProgressBar(0, 50); // 5.0 üzerinden 10 katı
        bar.setValue((int)(score * 10));
        bar.setForeground(score >= 4 ? Color.GREEN : score >= 3 ? Color.ORANGE : Color.RED);
        p.add(bar, BorderLayout.CENTER);
        p.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        return p;
    }


    class RadarChart extends JPanel {
        public RadarChart() {
            setPreferredSize(new Dimension(300, 300));
            setBorder(BorderFactory.createTitledBorder("Radar Analysis (Bonus)"));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int cx = getWidth() / 2;
            int cy = getHeight() / 2;
            int radius = 80;
            int n = 5;


            g2d.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i < n; i++) {
                double angle = Math.toRadians(i * 360.0 / n - 90);
                int x = cx + (int) (radius * Math.cos(angle));
                int y = cy + (int) (radius * Math.sin(angle));
                g2d.drawLine(cx, cy, x, y);
            }


            double[] values = {0.9, 0.6, 0.8, 0.7, 0.84};
            int[] px = new int[n];
            int[] py = new int[n];
            for (int i = 0; i < n; i++) {
                double angle = Math.toRadians(i * 360.0 / n - 90);
                px[i] = cx + (int) (values[i] * radius * Math.cos(angle));
                py[i] = cy + (int) (values[i] * radius * Math.sin(angle));
            }
            g2d.setColor(new Color(0, 102, 204, 100));
            g2d.fillPolygon(px, py, n);
            g2d.setColor(Color.BLUE);
            g2d.drawPolygon(px, py, n);
        }
    }
}