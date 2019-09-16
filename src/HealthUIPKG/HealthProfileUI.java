package HealthUIPKG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HealthProfileUI extends JFrame {
  
  private static final long serialVersionUID = 1L;
  private JPanel infoPanel = new JPanel();
  private JLabel firstNameLabel = new JLabel();
  private JLabel lastNameLabel = new JLabel();
  private JLabel genderLabel = new JLabel();
  private JLabel unitLabel = new JLabel();
  private JLabel dateOfBirthLabel = new JLabel();
  private JLabel heightInchesLabel = new JLabel();
  private JLabel heightMetricLabel = new JLabel();
  private JLabel weightPoundsLabel = new JLabel();
  private JLabel weightKgLabel = new JLabel();
  private JTextField firstNameTextField = new JTextField();
  private JTextField lastNameTextField = new JTextField();
  private JTextField heightInchesTextField = new JTextField();
  private JTextField heightMetricTextField = new JTextField();
  private JTextField weightPoundsTextField = new JTextField();
  private JTextField weightKgTextField = new JTextField();
  private JRadioButton maleRadioButton = new JRadioButton();
  private JRadioButton femaleRadioButton = new JRadioButton();
  private ButtonGroup genderGroup = new ButtonGroup();
  private JRadioButton imperialRadioButton = new JRadioButton();
  private JRadioButton metricRadioButton = new JRadioButton();
  private ButtonGroup unitGroup = new ButtonGroup();
  private JButton okButton = new JButton();
  private JButton resetButton = new JButton();
  private TextArea reportTextArea = new TextArea();
  private JLabel statusBarLabel = new JLabel();
  private HealthProfile hp = new HealthProfile();
  private Date calendar;
  private SimpleDateFormat sdf;
  private String dateString = new String();
  private JTextField dateOfBirthTextField = new JTextField();
  protected FormatUI format = new FormatUI();

  public HealthProfileUI() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    formatUserInterfaces();
    setupListeners();

    metricRadioButton.setSelected(true);
    heightMetricLabel.setVisible(true);
    heightMetricTextField.setVisible(true);

    weightKgLabel.setVisible(true);
    weightKgTextField.setVisible(true);

    heightInchesLabel.setVisible(false);
    heightInchesTextField.setVisible(false);

    weightPoundsLabel.setVisible(false);
    weightPoundsTextField.setVisible(false);

    infoPanel.setBackground(new Color(240, 244, 247));
    infoPanel.setLayout(null);
    addToPanel();

    this.getContentPane().setBackground(new Color(240, 244, 247));
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setResizable(true);
    this.setSize(700, 395);
    this.setResizable(false);
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(infoPanel, null);
    this.setTitle("Health Profile and Body Mass Index Calculator");   
  }

  public void addToPanel() {
    genderGroup.add(maleRadioButton);
    genderGroup.add(femaleRadioButton);
    unitGroup.add(metricRadioButton);
    unitGroup.add(imperialRadioButton);
    infoPanel.add(firstNameLabel);
    infoPanel.add(firstNameTextField);
    infoPanel.add(lastNameLabel);
    infoPanel.add(lastNameTextField);
    infoPanel.add(genderLabel);
    infoPanel.add(maleRadioButton);
    infoPanel.add(femaleRadioButton);
    infoPanel.add(unitLabel);
    infoPanel.add(metricRadioButton);
    infoPanel.add(imperialRadioButton);
    infoPanel.add(dateOfBirthLabel);
    infoPanel.add(dateOfBirthTextField);
    infoPanel.add(heightMetricLabel);
    infoPanel.add(heightMetricTextField);
    infoPanel.add(weightKgLabel);
    infoPanel.add(weightKgTextField);
    infoPanel.add(heightInchesLabel);
    infoPanel.add(heightInchesTextField);
    infoPanel.add(weightPoundsLabel);
    infoPanel.add(weightPoundsTextField);
    infoPanel.add(okButton);
    infoPanel.add(resetButton);
    infoPanel.add(reportTextArea);
    infoPanel.add(statusBarLabel);
  }

  public void formatUserInterfaces() {
    firstNameLabel = format.formatLabel(firstNameLabel, "First Name", 15, 20,
                                        75, 25, 240, 244, 247, 130, 128, 127,
                                        "Arial", 0, 14, SwingConstants.CENTER,
                                        SwingConstants.LEFT);
    firstNameTextField = format.formatTextField(firstNameTextField, "", 105, 20,
                                                150, 25, 255, 255, 255, 130,
                                                128, 127, "Arial", 0, 14);
    lastNameLabel = format.formatLabel(lastNameLabel, "Last Name", 15, 55,
                                       75, 25, 240, 244, 247, 130, 128, 127,
                                       "Arial", 0, 14, SwingConstants.CENTER,
                                       SwingConstants.LEFT);
    lastNameTextField = format.formatTextField(lastNameTextField, "", 105, 55,
                                               150, 25, 255, 255, 255, 130,
                                               128, 127, "Arial", 0, 14);
    dateOfBirthLabel = format.formatLabel(dateOfBirthLabel, "Birth Date", 15,
                                          90,
                                          75, 25, 240, 244, 247, 130, 128, 127,
                                          "Arial", 0, 14, SwingConstants.CENTER,
                                          SwingConstants.LEFT);
    calendar = new GregorianCalendar(TimeZone.getDefault()).getTime();
    sdf = new SimpleDateFormat("d/MM/yyyy");
    dateString = sdf.format(calendar);
    dateOfBirthTextField = format.formatTextField(
        dateOfBirthTextField, dateString, 105, 90, 150, 25, 255, 255,
        255, 130, 128, 127, "Arial", 0, 14);
    genderLabel = format.formatLabel(genderLabel, "Gender", 15, 125,
                                     75, 25, 240, 244, 247, 130, 128, 127,
                                     "Arial", 0, 14, SwingConstants.CENTER,
                                     SwingConstants.LEFT);
    maleRadioButton = format.formatRadioButton(maleRadioButton, "Male", 105,
                                               125,
                                               75, 25, 240, 244, 247, 130, 128,
                                               127, "Arial", 0, 14);
    femaleRadioButton = format.formatRadioButton(femaleRadioButton, "Female",
                                                 180, 125, 75, 25, 240, 244,
                                                 247, 130,
                                                 128, 127, "Arial", 0, 14);
    unitLabel = format.formatLabel(unitLabel, "Unit System", 15, 170,
                                   75, 25, 240, 244, 247, 130, 128, 127,
                                   "Arial", 0, 14, SwingConstants.CENTER,
                                   SwingConstants.LEFT);
    metricRadioButton = format.formatRadioButton(metricRadioButton, "Metric",
                                                 105, 170,
                                                 75, 25, 240, 244, 247, 130,
                                                 128,
                                                 127, "Arial", 0, 14);
    imperialRadioButton = format.formatRadioButton(imperialRadioButton,
        "Imperial",
        180, 170, 75, 25, 240, 244, 247, 130,
        128, 127, "Arial", 0, 14);
    heightMetricLabel = format.formatLabel(heightMetricLabel,
                                           "Height (Centimeter)",
                                           15, 205,
                                           125, 25, 240, 244, 247, 130, 128,
                                           127,
                                           "Arial", 0, 14,
                                           SwingConstants.CENTER,
                                           SwingConstants.LEFT);
    heightMetricTextField = format.formatTextField(heightMetricTextField, "",
        145, 205,
        110, 25, 255, 255, 255, 130,
        128, 127, "Arial", 0, 14);
    weightKgLabel = format.formatLabel(weightKgLabel, "Weight (Kilograms)",
                                       15, 240,
                                       125, 25, 240, 244, 247, 130, 128, 127,
                                       "Arial", 0, 14,
                                       SwingConstants.CENTER,
                                       SwingConstants.LEFT);
    weightKgTextField = format.formatTextField(weightKgTextField, "",
                                               145, 240,
                                               110, 25, 255, 255, 255, 130,
                                               128, 127, "Arial", 0, 14);

    heightInchesLabel = format.formatLabel(heightInchesLabel, "Height (Inches)",
                                           15, 205,
                                           125, 25, 240, 244, 247, 130, 128,
                                           127,
                                           "Arial", 0, 14,
                                           SwingConstants.CENTER,
                                           SwingConstants.LEFT);
    heightInchesTextField = format.formatTextField(heightInchesTextField, "",
        145, 205,
        110, 25, 255, 255, 255, 130,
        128, 127, "Arial", 0, 14);
    weightPoundsLabel = format.formatLabel(weightPoundsLabel, "Weight (Pounds)",
                                           15, 240,
                                           125, 25, 240, 244, 247, 130, 128,
                                           127,
                                           "Arial", 0, 14,
                                           SwingConstants.CENTER,
                                           SwingConstants.LEFT);
    weightPoundsTextField = format.formatTextField(weightPoundsTextField, "",
        145, 240,
        110, 25, 255, 255, 255, 130,
        128, 127, "Arial", 0, 14);
    okButton = format.formatButton(okButton, "OK", 145, 280, 110, 25, 160, 166,
                                   171, 240, 244, 247, "Arial", Font.BOLD, 14);

    resetButton = format.formatButton(resetButton, "Reset", 25, 280, 110, 25,
                                      160, 166,
                                      171, 240, 244, 247, "Arial", Font.BOLD,
                                      14);

    reportTextArea = format.formatTextArea(reportTextArea, "", 275, 20, 385,
                                           285, 255, 255, 255, 130, 128, 127,
                                           "Arial", 0, 14);
    reportTextArea.setEditable(false);
    reportTextArea.setFocusable(false);
    reportTextArea.addMouseMotionListener(new
                                          HealthProfileUI_reportTextArea_mouseMotionAdapter(this));
    statusBarLabel = format.formatLabel(statusBarLabel, "",
                                        -3, 325,
                                        700, 25, 240, 244, 247, 130, 128,
                                        127,
                                        "Arial", 0, 14,
                                        SwingConstants.CENTER,
                                        SwingConstants.LEFT);
    statusBarLabel.setBorder(BorderFactory.createLoweredBevelBorder());

  }

  public void setupListeners() {
    heightMetricTextField.addMouseListener(new
                                           HealthProfileUI_heightMetricTextField_mouseAdapter(this));
    heightMetricTextField.addMouseMotionListener(new
                                                 HealthProfileUI_heightMetricTextField_mouseMotionAdapter(this));
    weightKgTextField.addMouseListener(new
                                       HealthProfileUI_weightKgTextField_mouseAdapter(this));
    weightKgTextField.addMouseMotionListener(new
                                             HealthProfileUI_weightKgTextField_mouseMotionAdapter(this));
    heightInchesTextField.addMouseListener(new
                                           HealthProfileUI_heightInchesTextField_mouseAdapter(this));
    heightInchesTextField.addMouseMotionListener(new
                                                 HealthProfileUI_heightInchesTextField_mouseMotionAdapter(this));
    weightPoundsTextField.addMouseListener(new
                                           HealthProfileUI_weightPoundsTextField_mouseAdapter(this));
    weightPoundsTextField.addMouseMotionListener(new
                                                 HealthProfileUI_weightPoundsTextField_mouseMotionAdapter(this));

    dateOfBirthTextField.addMouseMotionListener(new
                                                HealthProfileUI_dateOfBirthTextField_mouseMotionAdapter(this));
    infoPanel.addMouseMotionListener(new
                                     HealthProfileUI_infoPanel_mouseMotionAdapter(this));
    metricRadioButton.addItemListener(new
                                      HealthProfileUI_metricRadioButton_itemAdapter(this));
    imperialRadioButton.addItemListener(new
                                        HealthProfileUI_imperialRadioButton_itemAdapter(this));
    okButton.addActionListener(new HealthProfileUI_okButton_actionAdapter(this));
    firstNameTextField.addMouseMotionListener(new
                                              HealthProfileUI_firstNameTextField_mouseMotionAdapter(this));
    lastNameTextField.addMouseMotionListener(new
                                             HealthProfileUI_lastNameTextField_mouseMotionAdapter(this));
    unitLabel.addMouseMotionListener(new
                                     HealthProfileUI_unitLabel_mouseMotionAdapter(this));
    okButton.addMouseMotionListener(new
                                    HealthProfileUI_okButton_mouseMotionAdapter(this));
    firstNameTextField.addMouseListener(new
                                        HealthProfileUI_firstNameTextField_mouseAdapter(this));
    lastNameTextField.addMouseListener(new
                                       HealthProfileUI_lastNameTextField_mouseAdapter(this));
    dateOfBirthTextField.addMouseListener(new
                                          HealthProfileUI_dateOfBirthTextField_mouseAdapter(this));
    resetButton.addActionListener(new HealthProfileUI_resetButton_actionAdapter(this));
    resetButton.addMouseMotionListener(new
                                       HealthProfileUI_resetButton_mouseMotionAdapter(this));
    resetButton.addMouseListener(new HealthProfileUI_resetButton_mouseAdapter(this));

  }

  void metricRadioButton_itemStateChanged(ItemEvent e) {
    if (metricRadioButton.isSelected() == true) {
      heightMetricLabel.setVisible(true);
      heightMetricTextField.setVisible(true);
      weightKgLabel.setVisible(true);
      weightKgTextField.setVisible(true);

      heightInchesLabel.setVisible(false);
      heightInchesTextField.setVisible(false);
      weightPoundsLabel.setVisible(false);
      weightPoundsTextField.setVisible(false);
    }
  }

  void imperialRadioButton_itemStateChanged(ItemEvent e) {
    if (imperialRadioButton.isSelected() == true) {
      heightMetricLabel.setVisible(false);
      heightMetricTextField.setVisible(false);
      weightKgLabel.setVisible(false);
      weightKgTextField.setVisible(false);

      heightInchesLabel.setVisible(true);
      heightInchesTextField.setVisible(true);
      weightPoundsLabel.setVisible(true);
      weightPoundsTextField.setVisible(true);
    }
  }

  void okButton_actionPerformed(ActionEvent e) {
    if (validateEntries() == true) {
      assignRecord();
      createReport();
    }
  }

  public boolean validateEntries() {
    boolean valid = true;

    if ( (firstNameTextField.getText().trim().length() > 25) ||
        (firstNameTextField.getText().trim().equals("") == true)) {
      valid = false;
      statusBarLabel.setText(
          " Error: First Name needs value up to 25 Characters");
      firstNameTextField.setBackground(new Color(250, 224, 235));
    }

    if ( (lastNameTextField.getText().trim().length() > 25) ||
        (lastNameTextField.getText().trim().equals("") == true)) {
      valid = false;
      statusBarLabel.setText(
          " Error: Last Name needs value up to 25 Characters");
      lastNameTextField.setBackground(new Color(250, 224, 235));
    }

    if (hp.validateDate(dateOfBirthTextField.getText().trim(), dateString) == false) {
      valid = false;
      statusBarLabel.setText(
          " Error: Date of Birth must be in dd/mm/yyyy format and not Today's Date");
      dateOfBirthTextField.setBackground(new Color(250, 224, 235));
    }

    if ( (maleRadioButton.isSelected() == false) &&
        (femaleRadioButton.isSelected() == false)) {
      valid = false;
      statusBarLabel.setText(
          " Error: Please select a Gender");

    }
    if (metricRadioButton.isSelected() == true) {
      if (hp.validateDouble(heightMetricTextField.getText().trim()) == false) {
        valid = false;
        statusBarLabel.setText(
            " Error: Height must have a value in Centimeter");
        heightMetricTextField.setBackground(new Color(250, 224, 235));

      }

      if (hp.validateDouble(weightKgTextField.getText().trim()) == false) {
        valid = false;
        statusBarLabel.setText(
            " Error: Weight must have a value in Kilograms");
        weightKgTextField.setBackground(new Color(250, 224, 235));

      }
    }
    else {

      if (hp.validateDouble(heightInchesTextField.getText().trim()) == false) {
        valid = false;
        statusBarLabel.setText(
            " Error: Height must have a value in Inches");
        heightInchesTextField.setBackground(new Color(250, 224, 235));

      }
      if (hp.validateDouble(weightPoundsTextField.getText().trim()) == false) {
        valid = false;
        statusBarLabel.setText(
            " Error: Weight must have a value in Pounds");
        weightPoundsTextField.setBackground(new Color(250, 224, 235));
      }
    }
    return valid;
  }

  public void assignRecord() {
    hp.setFirstName(firstNameTextField.getText());
    hp.setLastName(lastNameTextField.getText());
    hp.setBirthDate(dateOfBirthTextField.getText().trim());
    if (maleRadioButton.isSelected() == true) {
      hp.setGender("Male");
    }
    else {
      hp.setGender("Female");
    }
    if (metricRadioButton.isSelected() == true) {
      hp.setUnit("Metric");
    }
    else {
      hp.setUnit("Imperial");
    }
    if (metricRadioButton.isSelected() == true) {
      hp.setHeightMeter(Double.parseDouble(heightMetricTextField.getText().trim()));
      hp.setWeightKg(Double.parseDouble(weightKgTextField.getText().trim()));
    }
    else {
      hp.setHeightInch(Double.parseDouble(heightInchesTextField.getText().trim()));
      hp.setWeightPounds(Double.parseDouble(weightPoundsTextField.getText().
                                            trim()));
    }
  }

  public void createReport() {
    reportTextArea.setText("");
    reportTextArea.insert("H E A L T H  P R O F I L E\n", 5);
    reportTextArea.append("\nFirst Name: " + hp.getFirstName() +
                          "\nLast Name: " +
                          hp.getLastName());
    reportTextArea.append("\nDate of Birth: " +
                          dateOfBirthTextField.getText().trim() + "\nAge: " +
                          hp.calculateAge() + " \nGender: " + hp.getGender());

    reportTextArea.append("\nMaximum Heart Rate: " +
                          hp.calculateMaximumHeartRate());
    int[] targetRate = hp.calculateTargetHeartRate();
    reportTextArea.append("\nTargeted Heart Rate Min: " + targetRate[0] +
                          "\nTargeted Heart Rate Max: " + targetRate[1]);
    if (hp.getUnit().equals("Metric") == true) {
      reportTextArea.append("\nHeight (Centimeter): " + hp.getHeightMeter() +
                            "\nWeight (KG): " + hp.getWeightKg());
      reportTextArea.append("\nBody Mass Index (BMI): " + hp.calculateMetricBMI());
    }
    else {
      reportTextArea.append("\nHeight (Inches): " + hp.getHeightInch() +
                            "\nWeight (Pounds): " + hp.getWeightPounds());
      reportTextArea.append("\nBody Mass Index (BMI): " +
                            hp.calculateImperialBMI());
    }
    reportTextArea.append("\n\nRecommended Body Mass Index (BMI) Values:" +
                          "\nUnderweight: less than 18.5" +
                          "\nNormal: between 18.5 and 24.9" +
                          "\nOverweight: between 25 and 29.9" +
                          "\nObese: 30 or greater\n\nE N D  O F   R E P O R T");
  }

  public void resetScreen() {
    firstNameTextField.setText("");
    lastNameTextField.setText("");
    reportTextArea.setText("");
    dateOfBirthTextField.setText(dateString);
    heightMetricTextField.setText("");
    heightInchesTextField.setText("");
    weightKgTextField.setText("");
    weightPoundsTextField.setText("");
  }

  void firstNameTextField_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" First Name (25 characters)");
  }

  void infoPanel_mouseMoved(MouseEvent e) {
    //  statusBarLabel.setText(" ");
  }

  void lastNameTextField_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" Last Name (25 characters)");
  }

  void unitLabel_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" BMI Unit System");
  }

  void dateOfBirthTextField_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" Date of Birth in dd/mm/yyyy Format");
  }

  void heightMetricTextField_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" Height in Centimeter");
  }

  void weightKgTextField_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" Weight in Kilograms");
  }

  void heightInchesTextField_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" Height in Inches");
  }

  void weightPoundsTextField_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(" Weight in Kilograms");
  }

  void okButton_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(
        " Press OK to see your Health Profile and BMI Values Report");
  }

  void firstNameTextField_mouseEntered(MouseEvent e) {
    firstNameTextField.setBackground(new Color(255, 255, 255));
  }

  void lastNameTextField_mouseEntered(MouseEvent e) {
    lastNameTextField.setBackground(new Color(255, 255, 255));
  }

  void dateOfBirthTextField_mouseEntered(MouseEvent e) {
    dateOfBirthTextField.setBackground(new Color(255, 255, 255));
  }

  void heightMetricTextField_mouseEntered(MouseEvent e) {
    heightMetricTextField.setBackground(new Color(255, 255, 255));
  }

  void weightKgTextField_mouseEntered(MouseEvent e) {
    weightKgTextField.setBackground(new Color(255, 255, 255));
  }

  void heightInchesTextField_mouseEntered(MouseEvent e) {
    heightInchesTextField.setBackground(new Color(255, 255, 255));
  }

  void weightPoundsTextField_mouseEntered(MouseEvent e) {
    weightPoundsTextField.setBackground(new Color(255, 255, 255));
  }

  void resetButton_actionPerformed(ActionEvent e) {
    resetScreen();
  }

  void resetButton_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(
        " Press Reset to clear and start again");
  }

  void resetButton_mouseEntered(MouseEvent e) {

  }

  void reportTextArea_mouseMoved(MouseEvent e) {
    statusBarLabel.setText(
        " Health Profile Report area");
  }

}

class HealthProfileUI_metricRadioButton_itemAdapter
    implements java.awt.event.ItemListener {
  HealthProfileUI adaptee;

  HealthProfileUI_metricRadioButton_itemAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void itemStateChanged(ItemEvent e) {
    adaptee.metricRadioButton_itemStateChanged(e);
  }
}

class HealthProfileUI_imperialRadioButton_itemAdapter
    implements java.awt.event.ItemListener {
  HealthProfileUI adaptee;

  HealthProfileUI_imperialRadioButton_itemAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void itemStateChanged(ItemEvent e) {
    adaptee.imperialRadioButton_itemStateChanged(e);
  }
}

class HealthProfileUI_okButton_actionAdapter
    implements java.awt.event.ActionListener {
  HealthProfileUI adaptee;

  HealthProfileUI_okButton_actionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.okButton_actionPerformed(e);
  }
}

class HealthProfileUI_firstNameTextField_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_firstNameTextField_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.firstNameTextField_mouseMoved(e);
  }
}

class HealthProfileUI_infoPanel_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_infoPanel_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.infoPanel_mouseMoved(e);
  }
}

class HealthProfileUI_lastNameTextField_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_lastNameTextField_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.lastNameTextField_mouseMoved(e);
  }
}

class HealthProfileUI_unitLabel_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_unitLabel_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.unitLabel_mouseMoved(e);
  }
}

class HealthProfileUI_dateOfBirthTextField_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_dateOfBirthTextField_mouseMotionAdapter(
      HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.dateOfBirthTextField_mouseMoved(e);
  }
}

class HealthProfileUI_heightMetricTextField_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_heightMetricTextField_mouseMotionAdapter(HealthProfileUI
      adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.heightMetricTextField_mouseMoved(e);
  }
}

class HealthProfileUI_weightKgTextField_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_weightKgTextField_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.weightKgTextField_mouseMoved(e);
  }
}

class HealthProfileUI_heightInchesTextField_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_heightInchesTextField_mouseMotionAdapter(HealthProfileUI
      adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.heightInchesTextField_mouseMoved(e);
  }
}

class HealthProfileUI_weightPoundsTextField_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_weightPoundsTextField_mouseMotionAdapter(HealthProfileUI
      adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.weightPoundsTextField_mouseMoved(e);
  }
}

class HealthProfileUI_okButton_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_okButton_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.okButton_mouseMoved(e);
  }
}

class HealthProfileUI_firstNameTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_firstNameTextField_mouseAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.firstNameTextField_mouseEntered(e);
  }
}

class HealthProfileUI_lastNameTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_lastNameTextField_mouseAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.lastNameTextField_mouseEntered(e);
  }
}

class HealthProfileUI_dateOfBirthTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_dateOfBirthTextField_mouseAdapter(HealthProfileUI
      adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.dateOfBirthTextField_mouseEntered(e);
  }
}

class HealthProfileUI_heightMetricTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_heightMetricTextField_mouseAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.heightMetricTextField_mouseEntered(e);
  }
}

class HealthProfileUI_weightKgTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_weightKgTextField_mouseAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.weightKgTextField_mouseEntered(e);
  }
}

class HealthProfileUI_heightInchesTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_heightInchesTextField_mouseAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.heightInchesTextField_mouseEntered(e);
  }
}

class HealthProfileUI_weightPoundsTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_weightPoundsTextField_mouseAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.weightPoundsTextField_mouseEntered(e);
  }
}

class HealthProfileUI_resetButton_actionAdapter
    implements java.awt.event.ActionListener {
  HealthProfileUI adaptee;

  HealthProfileUI_resetButton_actionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.resetButton_actionPerformed(e);
  }
}

class HealthProfileUI_resetButton_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_resetButton_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.resetButton_mouseMoved(e);
  }
}

class HealthProfileUI_resetButton_mouseAdapter
    extends java.awt.event.MouseAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_resetButton_mouseAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.resetButton_mouseEntered(e);
  }
}

class HealthProfileUI_reportTextArea_mouseMotionAdapter
    extends java.awt.event.MouseMotionAdapter {
  HealthProfileUI adaptee;

  HealthProfileUI_reportTextArea_mouseMotionAdapter(HealthProfileUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseMoved(MouseEvent e) {
    adaptee.reportTextArea_mouseMoved(e);
  }
}