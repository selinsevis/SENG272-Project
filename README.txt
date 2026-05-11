ISO15939 Project

A Java Swing desktop app built for our Software Engineering course,
based on the ISO 15939 software measurement standard.

---------------------------------------------------------
PROJECT STRUCTURE
---------------------------------------------------------

data/
  ScenarioRepository     - handles storing and loading scenarios

model/
  Dimension              - represents a measurement dimension
  Metric                 - defines a metric
  Scenario               - a measurement scenario
  Session                - a measurement session

view/
  MainFrame              - main application window
  DefinePanel            - define the measurement
  PlanPanel              - plan the measurement
  CollectPanel           - collect data
  AnalysePanel           - analyse the results
  ProfilePanel           - manage profiles
  StepIndicator          - shows which step you're on

---------------------------------------------------------
REQUIREMENTS
---------------------------------------------------------

- Java JDK 21+
- IntelliJ IDEA

---------------------------------------------------------
HOW TO RUN
---------------------------------------------------------

Open the project in IntelliJ IDEA and run Main.java.

---------------------------------------------------------
NOTES
---------------------------------------------------------

- UI is built with Java Swing.
- Scenario data is managed through ScenarioRepository.