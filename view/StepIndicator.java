package view;

import javax.swing.*;
import java.awt.*;

public class StepIndicator extends JPanel {

    private static final String[] STEP_NAMES = {"Profile", "Define", "Plan", "Collect", "Analyse"};
    private int currentStep;

    private static final Color BG_COLOR       = new Color(245, 247, 252);
    private static final Color ACTIVE_COLOR   = new Color(37, 99, 235);
    private static final Color DONE_COLOR     = new Color(22, 163, 74);
    private static final Color INACTIVE_COLOR = new Color(180, 188, 204);
    private static final Color TEXT_ACTIVE    = new Color(37, 99, 235);
    private static final Color TEXT_DONE      = new Color(22, 163, 74);
    private static final Color TEXT_INACTIVE  = new Color(140, 150, 170);
    private static final Color LINE_COLOR     = new Color(210, 218, 230);

    public StepIndicator(int currentStep) {
        this.currentStep = currentStep;
        setBackground(BG_COLOR);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(220, 226, 238)),
                BorderFactory.createEmptyBorder(16, 24, 16, 24)
        ));
        setPreferredSize(new Dimension(0, 80));
    }

    public void setCurrentStep(int step) {
        this.currentStep = step;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int panelW = getWidth();
        int panelH = getHeight();
        int n = STEP_NAMES.length;
        int circleRadius = 18;
        int spacing = panelW / (n + 1);
        int[] cx = new int[n];
        int cy = panelH / 2 - 8;

        for (int i = 0; i < n; i++) cx[i] = spacing * (i + 1);


        g2.setStroke(new BasicStroke(2f));
        for (int i = 0; i < n - 1; i++) {
            g2.setColor(i + 1 < currentStep - 1 ? DONE_COLOR : LINE_COLOR);
            g2.drawLine(cx[i] + circleRadius, cy, cx[i + 1] - circleRadius, cy);
        }


        for (int i = 0; i < n; i++) {
            int stepNum = i + 1;
            boolean isActive   = stepNum == currentStep;
            boolean isComplete = stepNum < currentStep;

            if (isActive) {
                g2.setColor(ACTIVE_COLOR);
                g2.fillOval(cx[i] - circleRadius, cy - circleRadius, circleRadius * 2, circleRadius * 2);
            } else if (isComplete) {
                g2.setColor(DONE_COLOR);
                g2.fillOval(cx[i] - circleRadius, cy - circleRadius, circleRadius * 2, circleRadius * 2);
            } else {
                g2.setColor(Color.WHITE);
                g2.fillOval(cx[i] - circleRadius, cy - circleRadius, circleRadius * 2, circleRadius * 2);
                g2.setColor(INACTIVE_COLOR);
                g2.setStroke(new BasicStroke(2f));
                g2.drawOval(cx[i] - circleRadius, cy - circleRadius, circleRadius * 2, circleRadius * 2);
            }

            g2.setColor((!isActive && !isComplete) ? INACTIVE_COLOR : Color.WHITE);
            Font circleFont = new Font("SansSerif", Font.BOLD, isComplete ? 14 : 13);
            g2.setFont(circleFont);
            String label = isComplete ? "✓" : String.valueOf(stepNum);
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(label, cx[i] - fm.stringWidth(label) / 2, cy + fm.getAscent() / 2 - 1);

            Font nameFont = new Font("SansSerif", isActive ? Font.BOLD : Font.PLAIN, 11);
            Color nameColor = isActive ? TEXT_ACTIVE : isComplete ? TEXT_DONE : TEXT_INACTIVE;
            g2.setFont(nameFont);
            g2.setColor(nameColor);
            FontMetrics nameFm = g2.getFontMetrics();
            g2.drawString(STEP_NAMES[i], cx[i] - nameFm.stringWidth(STEP_NAMES[i]) / 2, cy + circleRadius + 16);
        }

        g2.dispose();
    }
}