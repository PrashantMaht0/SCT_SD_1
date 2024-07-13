//imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Temperture_convert{
    //delcaring super variables;
    private JTextField myTextField;
    private JButton button;
    private JLabel fahrenheitLabel;
    private JLabel kelvinLabel;



    public Temperture_convert() {
        MyFrame frame = new MyFrame();
        frame.setTitle("Temperture Converter");
        frame.setLayout(new GridLayout(3, 1, 5, 5));

        // Panels
        JPanel inputpPanel = new JPanel();
        JPanel fahrenheitPanel = new JPanel();
        JPanel kelvinpPanel = new JPanel();

        // taking User input
        myTextField = new JTextField(10);


        button = new JButton("Submit");
        button.setHorizontalAlignment(JButton.RIGHT);
        button.setPreferredSize(new Dimension(100, 50));
        
        JLabel inputLabel = new JLabel("Enter the temperture in Celsius: ");
        fahrenheitLabel = new JLabel("Fahrenheit: ");
        kelvinLabel = new JLabel("Kelvin: ");

        // Add components to panels
        inputpPanel.add(inputLabel);
        inputpPanel.add(myTextField);
        inputpPanel.add(button);

        fahrenheitPanel.add(fahrenheitLabel);
        kelvinpPanel.add(kelvinLabel);

        // Add panels to frame
        frame.add(inputpPanel);
        frame.add(fahrenheitPanel);
        frame.add(kelvinpPanel);

        //adding event to submit button it will update the temperture in fahernheitlabel and kelvin label
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the input text as an integer (Celsius)
                    int celsius = Integer.parseInt(myTextField.getText());

                    // Convert to Fahrenheit
                    double fahrenheit = celsius * 9.0 / 5.0 + 32.0;

                    // Convert to Kelvin
                    double kelvin = celsius + 273.15;

                    fahrenheitLabel.setText(String.format("Fahrenheit:   %.2f ", fahrenheit));
                    kelvinLabel.setText(String.format("Kelvin:   %.2f ", kelvin));
                } catch (NumberFormatException ex) {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.revalidate();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Temperture_convert();
    }

}