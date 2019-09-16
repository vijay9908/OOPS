package HealthUIPKG;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormatUI {

  public FormatUI() {

  }

  
  public JLabel formatLabel(JLabel aLabel, String txt, int x, int y, int width,
                            int height, int Bred, int Bgreen, int Bblue,
                            int Fred, int Fgreen, int Fblue, String fontFace,
                            int fontStyle, int fontSize, int vert, int horz) {
    aLabel.setOpaque(true);
    aLabel.setText(txt);
    aLabel.setBounds(new Rectangle(x, y, width, height));
    aLabel.setBackground(new Color(Bred, Bgreen, Bblue));
    aLabel.setForeground(new Color(Fred, Fgreen, Fblue));
    aLabel.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aLabel.setVerticalAlignment(vert);
    aLabel.setHorizontalAlignment(horz);

    return aLabel;
  }

   public JLabel formatLabel(JLabel aLabel, int x, int y, int width,
                            int height, int Bred, int Bgreen, int Bblue,
                            int Fred, int Fgreen, int Fblue, String fontFace,
                            int fontStyle, int fontSize, int vert, int horz) {
    aLabel.setOpaque(true);
    aLabel.setBounds(new Rectangle(x, y, width, height));
    aLabel.setBackground(new Color(Bred, Bgreen, Bblue));
    aLabel.setForeground(new Color(Fred, Fgreen, Fblue));
    aLabel.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aLabel.setVerticalAlignment(vert);
    aLabel.setHorizontalAlignment(horz);

    return aLabel;
  }


  public JRadioButton formatRadioButton(JRadioButton aRadioButton, String txt, int x, int y, int width,
                           int height, int Bred, int Bgreen, int Bblue,
                           int Fred, int Fgreen, int Fblue, String fontFace,
                           int fontStyle, int fontSize) {
   aRadioButton.setOpaque(true);
   aRadioButton.setText(txt);
   aRadioButton.setBounds(new Rectangle(x, y, width, height));
   aRadioButton.setBackground(new Color(Bred, Bgreen, Bblue));
   aRadioButton.setForeground(new Color(Fred, Fgreen, Fblue));
   aRadioButton.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
   return aRadioButton;
 }


  public JTextField formatTextField(JTextField aTextField, String txt, int x,
                                    int y, int width, int height, int Bred,
                                    int Bgreen,
                                    int Bblue, int Fred, int Fgreen, int Fblue,
                                    String fontFace, int fontStyle,
                                    int fontSize
                                    ) {
    aTextField.setBorder(BorderFactory.createLoweredBevelBorder());
    aTextField.setOpaque(true);
    aTextField.setText(txt);
    aTextField.setBounds(new Rectangle(x, y, width, height));
    aTextField.setBackground(new Color(Bred, Bgreen, Bblue));
    aTextField.setForeground(new Color(Fred, Fgreen, Fblue));
    aTextField.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    return aTextField;
  }

  public JFormattedTextField formatFormattedTextField(JFormattedTextField
      aFormattedTextField, int x, int y, int width, int height, String option,
      int Bred, int Bgreen,
      int Bblue, int Fred, int Fgreen, int Fblue, String fontFace,
      int fontStyle, int fontSize
      ) throws
      Exception {
    aFormattedTextField.setBorder(BorderFactory.createLoweredBevelBorder());
    aFormattedTextField.setOpaque(true);
    aFormattedTextField.setBounds(new Rectangle(x, y, width, height));
    aFormattedTextField.setBackground(new Color(Bred, Bgreen, Bblue));
    aFormattedTextField.setForeground(new Color(Fred, Fgreen, Fblue));
    aFormattedTextField.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    return aFormattedTextField;
  }

  public JComboBox formatComboBox(JComboBox aComboBox, int x, int y, int width,
                                  int height, boolean editable,
                                  boolean selected,
                                  int index, int Bred, int Bgreen,
                                  int Bblue, int Fred, int Fgreen, int Fblue,
                                  String fontFace,
                                  int fontStyle, int fontSize
                                  ) {
    aComboBox.setBorder(BorderFactory.createLoweredBevelBorder());
    aComboBox.setBounds(new Rectangle(x, y, width, height));
    aComboBox.setOpaque(true);
    aComboBox.setBackground(new Color(Bred, Bgreen, Bblue));
    aComboBox.setForeground(new Color(Fred, Fgreen, Fblue));
    aComboBox.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aComboBox.setEditable(editable);
    if (selected == true) {
      aComboBox.setSelectedIndex(index);
    }
    return aComboBox;
  }

  public JScrollPane formatScrollPane(JScrollPane aScrollpane, int x, int y,
                                      int width,
                                      int height, int Bred, int Bgreen,
                                      int Bblue, int Fred, int Fgreen,
                                      int Fblue, String fontFace,
                                      int fontStyle, int fontSize
                                      ) {
    aScrollpane.setBorder(BorderFactory.createLoweredBevelBorder());
    aScrollpane.setBounds(new Rectangle(x, y, width, height));
    aScrollpane.setBackground(new Color(Bred, Bgreen, Bblue));
    aScrollpane.setForeground(new Color(Fred, Fgreen, Fblue));
    aScrollpane.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aScrollpane.setOpaque(true);

    return aScrollpane;
  }

  public JTextArea formatTextArea(JTextArea aTextArea, String txt, int x, int y,
                                  int width, int height, int Bred, int Bgreen,
                                  int Bblue, int Fred, int Fgreen,
                                  int Fblue, String fontFace, int fontStyle,
                                  int fontSize
                                  ) {
    aTextArea.setLineWrap(true);
    aTextArea.setWrapStyleWord(true);
    aTextArea.setEditable(true);
    aTextArea.setBounds(new Rectangle(x, y, width, height));
    aTextArea.setBackground(new Color(Bred, Bgreen, Bblue));
    aTextArea.setForeground(new Color(Fred, Fgreen, Fblue));
    aTextArea.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
    return aTextArea;
  }

  public TextArea formatTextArea(TextArea aTextArea, String txt, int x, int y,
                                 int width, int height, int Bred, int Bgreen,
                                 int Bblue, int Fred, int Fgreen,
                                 int Fblue, String fontFace, int fontStyle,
                                 int fontSize
                                 ) {
   aTextArea.setEditable(true);
   aTextArea.setBounds(new Rectangle(x, y, width, height));
   aTextArea.setBackground(new Color(Bred, Bgreen, Bblue));
   aTextArea.setForeground(new Color(Fred, Fgreen, Fblue));
   aTextArea.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
   return aTextArea;
 }


  public JButton formatButton(JButton aButton, String txt, int x, int y,
                              int width,
                              int height, int Bred, int Bgreen,
                              int Bblue, int Fred, int Fgreen, int Fblue,
                              String fontFace,
                              int fontStyle, int fontSize
                              ) {
    aButton.setOpaque(true);
    aButton.setText(txt);
    aButton.setBounds(new Rectangle(x, y, width, height));
    aButton.setBackground(new Color(Bred, Bgreen, Bblue));
    aButton.setForeground(new Color(Fred, Fgreen, Fblue));
    aButton.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));

    return aButton;
  }

  public JCheckBox formatCheckBox(JCheckBox aButton, String txt, int x, int y,
                              int width,
                              int height, int Bred, int Bgreen,
                              int Bblue, int Fred, int Fgreen, int Fblue,
                              String fontFace,
                              int fontStyle, int fontSize
                              ) {
    aButton.setOpaque(true);
    aButton.setText(txt);
    aButton.setBounds(new Rectangle(x, y, width, height));
    aButton.setBackground(new Color(Bred, Bgreen, Bblue));
    aButton.setForeground(new Color(Fred, Fgreen, Fblue));
    aButton.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));

    return aButton;
  }


  public JPanel formatPanel(JPanel aPanel, int border, Color lineColor,
                            int lineThick,
                            String borderTitle, int x, int y, int width,
                            int height, int Bred, int Bgreen, int Bblue,
                            int Fred, int Fgreen, int Fblue, String fontFace,
                            int fontStyle, int fontSize) {
    aPanel.setOpaque(true);
    aPanel.setBounds(new Rectangle(x, y, width, height));
    aPanel.setBackground(new Color(Bred, Bgreen, Bblue));
    aPanel.setForeground(new Color(Fred, Fgreen, Fblue));
    aPanel.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    switch (border) {
      case 0:
        aPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        break;
      case 1:
        aPanel.setBorder(BorderFactory.createEmptyBorder());
        break;
      case 2:
        aPanel.setBorder(BorderFactory.createEtchedBorder());
        break;
      case 3:
        aPanel.setBorder(BorderFactory.createLineBorder(lineColor, lineThick));
        break;
      case 4:
        aPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        break;
      case 5:
        aPanel.setBorder(BorderFactory.createTitledBorder(borderTitle));
        break;
    }
    return aPanel;
  }

}

					