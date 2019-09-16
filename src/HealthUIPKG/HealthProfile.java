package HealthUIPKG;

import java.text.DecimalFormat;
import java.util.Calendar;

public class HealthProfile {

  private String firstName = new String();
  private String lastName = new String();
  private String gender = new String();
  private String unit = new String();
  private int[] birthDate = new int[3]; 
  private String bDate = new String();
  private Calendar todaysDate;
  private double heightInch;
  private double heightMeter;
  private double weightPounds;
  private double weightKg;
  private int age;
  private int maxHeartRate;
  private int[] targetHeartRate = new int[2];
  private DecimalFormat df = new DecimalFormat("#.##");

  public HealthProfile() {

  }

  public HealthProfile(String firstName, String lastName, String gender,
                       String unit,
                       String bDate, double heightInch, double heightMeter,
                       double weightPounds, double weightKg) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.unit = unit;
    setBirthDate(bDate);
    this.heightInch = heightInch;
    this.heightMeter = heightMeter;
    this.weightPounds = weightPounds;
    this.weightKg = weightKg;
  }

  
  public int calculateAge() {
    todaysDate = Calendar.getInstance();
    todaysDate.setTime(new java.util.Date());
    age = todaysDate.get(Calendar.YEAR) - birthDate[0];
    return age;
  }

  
  public int[] calculateTargetHeartRate() {
    targetHeartRate[0] = (maxHeartRate * 50) / 100;
    targetHeartRate[1] = (maxHeartRate * 85) / 100;
    return targetHeartRate;
  }

  
  public int calculateMaximumHeartRate() {
    maxHeartRate = 220 - age;
    return maxHeartRate;
  }

  
  public String calculateImperialBMI() {
    double bmi = 0.0;
    bmi = (weightPounds * 703) / (heightInch * heightInch);
    return df.format(bmi);
  }

  
  public String calculateMetricBMI() {

    double bmi = 0.0;
    bmi = weightKg / (heightMeter * heightMeter);
    return df.format(bmi);
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public void setBirthDate(String bDate) {

    String[] result = bDate.split("\\/");
    birthDate[0] = Integer.parseInt(result[2]);
    birthDate[1] = Integer.parseInt(result[1]);
    birthDate[2] = Integer.parseInt(result[0]);
  }

  public boolean validateDate(String bDate, String today) {
    boolean valid = true;
    try {
      int[] birthDate2 = new int[3];
      String[] result = bDate.split("\\/");
      birthDate2[0] = Integer.parseInt(result[2]);
      birthDate2[1] = Integer.parseInt(result[1]);
      birthDate2[2] = Integer.parseInt(result[0]);
      if (bDate.equals(today) == true) {
        valid = false;
      }
    }
    catch (Exception ex) {
      valid = false;
    }
    return valid;
  }

  public boolean validateDouble(String number) {
    boolean valid = true;
    double d = 0.0;
    try {
      d = Double.parseDouble(number);
    }
    catch (Exception ex) {
      valid = false;
    }
    return valid;
  }

  public void displayRecord() {

    System.out.println("First Name : " + firstName);
    System.out.println("Last Name : " + lastName);
    System.out.println("Gender : " + gender);
    System.out.println("Unit : " + unit);
    System.out.println("Date of Birth : " + getBirthDate());
    System.out.println("heightMeter: " + heightMeter);
    System.out.println("weightKg : " + weightKg);
    System.out.println("Height Inch : " + heightInch);
    System.out.println("weightPounds : " + weightPounds);
  }

  public void setHeightInch(double heightInch) {
    this.heightInch = heightInch;
  }

  public void setHeightMeter(double heightMeter) {
    this.heightMeter = heightMeter / 100;
  }

  public void setWeightPounds(double weightPounds) {
    this.weightPounds = weightPounds;
  }

  public void setWeightKg(double weightKg) {
    this.weightKg = weightKg;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGender() {
    return gender;
  }

  public String getUnit() {
    return unit;
  }

  public String getBirthDate() {
    String result = String.valueOf(birthDate[0]) + "/" +
        String.valueOf(birthDate[1]) + "/" + String.valueOf(birthDate[2]);
    return result;
  }

  public String getHeightInch() {
    return df.format(heightInch);
  }

  public String getHeightMeter() {
    return df.format(heightMeter * 100);
  }

  public String getWeightPounds() {
    return df.format(weightPounds);
  }

  public String getWeightKg() {
    return df.format(weightKg);
  }

}

					
