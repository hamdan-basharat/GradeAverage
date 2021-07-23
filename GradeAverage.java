package gradeaverage;

import java.awt.*;    // required for GUI
import javax.swing.*;  // swing is for GUI
import java.util.Arrays; // need for Array manipuation.

class GradeAverage{
  // -----CLASS INSTANCE VARIABLE DECLARATIONS NCAPSULATED-------
  private static double [] marks;      // array to hold numbers for calculations
  private static JTextField[] marksField;   // textbox to input numbers.
  private static JLabel resultLabel;    // instructions labels displayed
  // ------CLASS CONSTRUCTOR TO INTIALIZE INSTANCE VARIABLES------
  GradeAverage() { // creates the variables on the HEAP
    marks = new double[3];
    marksField = new JTextField[3];
    marksField[0] = new JTextField(10);
    marksField[1] = new JTextField(10);
    marksField[2] = new JTextField(10);
  }
  // ----USUALLY GET/SETTER METHODS FOR INSTANCE VARIABLES------
  // -----CLAS/INSTANCE METHODS-------------------------
  private static JPanel getPanel() {
    JPanel basePanel = new JPanel();
    basePanel.setOpaque(true);
    basePanel.setBackground(Color.BLUE.darker());
    
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(3,2,5,5));
    centerPanel.setBorder(
                          BorderFactory.createEmptyBorder(5,5,5,5));
    centerPanel.setOpaque(true);
    centerPanel.setBackground(Color.WHITE);
    
    JLabel mLabel1 = new JLabel("Enter Marks 1 :");
    JLabel mLabel2 = new JLabel("Enter Marks 2 :");
    JLabel mLabel3 = new JLabel("Enter Marks 3 :");
    
    centerPanel.add(mLabel1);
    centerPanel.add(marksField[0]);
    centerPanel.add(mLabel2);
    centerPanel.add(marksField[1]);
    centerPanel.add(mLabel3);
    centerPanel.add(marksField[2]);
    
    basePanel.add(centerPanel);
    
    return basePanel;
  } // --------end of getPanel() method---------
  
  private static void displayGUI()
  {
    int selection = JOptionPane.showConfirmDialog(
                                                  null, getPanel(), "Input Form :"
                                                    , JOptionPane.OK_CANCEL_OPTION
                                                    , JOptionPane.PLAIN_MESSAGE);
    
    if (selection == JOptionPane.OK_OPTION)
    {
      for (int i = 0; i< 3; i++)
      {
        marks[i] = Double.valueOf(marksField[i].getText());
      }
      
      double average = (marks[0] + marks[1] + marks[2])/3.0;
      JOptionPane.showMessageDialog(null
                                      , "Average is : " + Double.toString(average)
                                      , "Average :"
                                      , JOptionPane.PLAIN_MESSAGE);
    }
    else if (selection == JOptionPane.CANCEL_OPTION)
    {
      System.out.println("Good Bye");
    }
  } // ----------end of displayGUI() method-----------
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable()
                                 {
      public void run()
      {
        new GradeAverage().displayGUI();
      }
    });
    
  } //---------end of main() method----------
} // ----------end of the entire program class---------------
