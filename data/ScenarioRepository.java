package data;

import model.Dimension;
import model.Metric;
import model.Scenario;

import java.util.ArrayList;
import java.util.HashMap;

public class ScenarioRepository {

    private static ScenarioRepository instance;
    private HashMap<String, ArrayList<Scenario>> scenariosByMode;

    private ScenarioRepository() {
        scenariosByMode = new HashMap<>();
        initializeScenarios();
    }

    public static ScenarioRepository getInstance() {
        if (instance == null) {
            instance = new ScenarioRepository();
        }
        return instance;
    }

    private void initializeScenarios() {
        // EDUCATION - Scenario C
        Scenario eduC = new Scenario("Scenario C — Team Alpha", "Education", "Product Quality");

        Dimension usability = new Dimension("Usability", 25);
        Metric sus = new Metric("SUS Score", 50, "Higher is better", 0, 100, "points");
        sus.setValue(89);
        Metric onboarding = new Metric("Onboarding Time", 50, "Lower is better", 0, 60, "min");
        onboarding.setValue(5);
        usability.addMetric(sus);
        usability.addMetric(onboarding);

        Dimension perf = new Dimension("Performance Efficiency", 20);
        Metric videoStart = new Metric("Video Start Time", 50, "Lower is better", 0, 15, "sec");
        videoStart.setValue(3);
        Metric concurrent = new Metric("Concurrent Exams", 50, "Higher is better", 0, 600, "users");
        concurrent.setValue(480);
        perf.addMetric(videoStart);
        perf.addMetric(concurrent);

        Dimension access = new Dimension("Accessibility", 20);
        Metric wcag = new Metric("WCAG Compliance", 50, "Higher is better", 0, 100, "%");
        wcag.setValue(92);
        Metric screen = new Metric("Screen Reader Score", 50, "Higher is better", 0, 100, "%");
        screen.setValue(78);
        access.addMetric(wcag);
        access.addMetric(screen);

        Dimension reliability = new Dimension("Reliability", 20);
        Metric uptime = new Metric("Uptime", 50, "Higher is better", 95, 100, "%");
        uptime.setValue(99.5);
        Metric mttr = new Metric("MTTR", 50, "Lower is better", 0, 120, "min");
        mttr.setValue(12);
        reliability.addMetric(uptime);
        reliability.addMetric(mttr);

        Dimension func = new Dimension("Functional Suitability", 15);
        Metric feature = new Metric("Feature Completion", 50, "Higher is better", 0, 100, "%");
        feature.setValue(95);
        Metric submit = new Metric("Assignment Submit Rate", 50, "Higher is better", 0, 100, "%");
        submit.setValue(87);
        func.addMetric(feature);
        func.addMetric(submit);

        eduC.addDimension(usability);
        eduC.addDimension(perf);
        eduC.addDimension(access);
        eduC.addDimension(reliability);
        eduC.addDimension(func);

        // EDUCATION - Scenario D
        Scenario eduD = new Scenario("Scenario D — Team Beta", "Education", "Product Quality");

        Dimension usability2 = new Dimension("Usability", 30);
        Metric sus2 = new Metric("SUS Score", 50, "Higher is better", 0, 100, "points");
        sus2.setValue(72);
        Metric taskRate = new Metric("Task Success Rate", 50, "Higher is better", 0, 100, "%");
        taskRate.setValue(68);
        usability2.addMetric(sus2);
        usability2.addMetric(taskRate);

        Dimension security = new Dimension("Security", 25);
        Metric authFail = new Metric("Auth Failure Rate", 50, "Lower is better", 0, 10, "%");
        authFail.setValue(2.5);
        Metric encryption = new Metric("Encryption Coverage", 50, "Higher is better", 0, 100, "%");
        encryption.setValue(85);
        security.addMetric(authFail);
        security.addMetric(encryption);

        Dimension maintain = new Dimension("Maintainability", 20);
        Metric complexity = new Metric("Code Complexity", 50, "Lower is better", 0, 50, "units");
        complexity.setValue(15);
        Metric docCov = new Metric("Documentation Coverage", 50, "Higher is better", 0, 100, "%");
        docCov.setValue(70);
        maintain.addMetric(complexity);
        maintain.addMetric(docCov);

        Dimension portability = new Dimension("Portability", 25);
        Metric browser = new Metric("Browser Compatibility", 50, "Higher is better", 0, 100, "%");
        browser.setValue(90);
        Metric mobile = new Metric("Mobile Responsiveness", 50, "Higher is better", 0, 100, "points");
        mobile.setValue(65);
        portability.addMetric(browser);
        portability.addMetric(mobile);

        eduD.addDimension(usability2);
        eduD.addDimension(security);
        eduD.addDimension(maintain);
        eduD.addDimension(portability);

        // HEALTH - Scenario A
        Scenario healthA = new Scenario("Scenario A — HealthTrack Pro", "Health", "Product Quality");

        Dimension hUsability = new Dimension("Usability", 25);
        Metric hSus = new Metric("SUS Score", 50, "Higher is better", 0, 100, "points");
        hSus.setValue(81);
        Metric hError = new Metric("User Error Rate", 50, "Lower is better", 0, 20, "%");
        hError.setValue(4);
        hUsability.addMetric(hSus);
        hUsability.addMetric(hError);

        Dimension hReliability = new Dimension("Reliability", 30);
        Metric hUptime = new Metric("System Uptime", 50, "Higher is better", 95, 100, "%");
        hUptime.setValue(99.2);
        Metric hCrash = new Metric("Crash Rate", 50, "Lower is better", 0, 5, "crashes/day");
        hCrash.setValue(0.3);
        hReliability.addMetric(hUptime);
        hReliability.addMetric(hCrash);

        Dimension hSecurity = new Dimension("Security", 30);
        Metric hHipaa = new Metric("HIPAA Compliance", 50, "Higher is better", 0, 100, "%");
        hHipaa.setValue(94);
        Metric hBreach = new Metric("Data Breach Incidents", 50, "Lower is better", 0, 10, "incidents");
        hBreach.setValue(0);
        hSecurity.addMetric(hHipaa);
        hSecurity.addMetric(hBreach);

        Dimension hPerf = new Dimension("Performance Efficiency", 15);
        Metric hResponse = new Metric("API Response Time", 50, "Lower is better", 0, 2000, "ms");
        hResponse.setValue(320);
        Metric hThroughput = new Metric("Throughput", 50, "Higher is better", 0, 1000, "req/sec");
        hThroughput.setValue(750);
        hPerf.addMetric(hResponse);
        hPerf.addMetric(hThroughput);

        healthA.addDimension(hUsability);
        healthA.addDimension(hReliability);
        healthA.addDimension(hSecurity);
        healthA.addDimension(hPerf);

        // HEALTH - Scenario B
        Scenario healthB = new Scenario("Scenario B — MedPortal System", "Health", "Process Quality");

        Dimension sprint = new Dimension("Sprint Efficiency", 30);
        Metric velocity = new Metric("Sprint Velocity", 50, "Higher is better", 0, 100, "points");
        velocity.setValue(76);
        Metric bugLeak = new Metric("Bug Leakage Rate", 50, "Lower is better", 0, 15, "%");
        bugLeak.setValue(3);
        sprint.addMetric(velocity);
        sprint.addMetric(bugLeak);

        Dimension codeQuality = new Dimension("Code Quality", 35);
        Metric coverage = new Metric("Test Coverage", 50, "Higher is better", 0, 100, "%");
        coverage.setValue(82);
        Metric techDebt = new Metric("Technical Debt Ratio", 50, "Lower is better", 0, 50, "%");
        techDebt.setValue(12);
        codeQuality.addMetric(coverage);
        codeQuality.addMetric(techDebt);

        Dimension team = new Dimension("Team Collaboration", 20);
        Metric reviewTime = new Metric("Code Review Time", 50, "Lower is better", 0, 48, "hours");
        reviewTime.setValue(6);
        Metric prRate = new Metric("PR Merge Rate", 50, "Higher is better", 0, 100, "%");
        prRate.setValue(91);
        team.addMetric(reviewTime);
        team.addMetric(prRate);

        Dimension doc = new Dimension("Documentation", 15);
        Metric docScore = new Metric("Doc Completeness", 50, "Higher is better", 0, 100, "%");
        docScore.setValue(65);
        Metric apiDoc = new Metric("API Documentation", 50, "Higher is better", 0, 100, "%");
        apiDoc.setValue(78);
        doc.addMetric(docScore);
        doc.addMetric(apiDoc);

        healthB.addDimension(sprint);
        healthB.addDimension(codeQuality);
        healthB.addDimension(team);
        healthB.addDimension(doc);


        ArrayList<Scenario> eduList = new ArrayList<>();
        eduList.add(eduC);
        eduList.add(eduD);
        scenariosByMode.put("Education", eduList);

        ArrayList<Scenario> healthList = new ArrayList<>();
        healthList.add(healthA);
        healthList.add(healthB);
        scenariosByMode.put("Health", healthList);
    }

    public ArrayList<Scenario> getScenariosForMode(String mode) {
        return scenariosByMode.getOrDefault(mode, new ArrayList<>());
    }
}
