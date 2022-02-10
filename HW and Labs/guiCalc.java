// Java Swing Calculator
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class guiCalc extends JFrame{

    // Calculator variables
    int num1;
    int num2;
    int ans;

    // Launch the application
    public static void main(String[] args){
        guiCalc frame = new guiCalc();
        frame.setVisible(true);
    }

    // Constructor
    public guiCalc(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame (in px)
        setSize(300,300);

        // The Content Panel that everything goes on
        JPanel contentPane = new JPanel();
        // Manual layout
        contentPane.setLayout(null);
        contentPane.setBorder(new TitledBorder("GUI Calculator using Java Swing"));;
        setContentPane(contentPane);

        // Number 1 label
        JLabel num1Label = new JLabel("Number 1: ");
        num1Label.setFont(new Font("Helvetica", Font.PLAIN, 14));
        num1Label.setBounds(35, 40, 100, 20);
        contentPane.add(num1Label);
        
        // Number 2 label
        JLabel num2Label = new JLabel("Number 2: ");
        num2Label.setFont(new Font("Helvetica", Font.PLAIN, 14));
        num2Label.setBounds(35, 90, 100, 20);
        contentPane.add(num2Label);

        // Answer label
        JLabel answerLabel = new JLabel("Answer: ");
        answerLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));
        answerLabel.setBounds(35, 140, 100, 20);
        contentPane.add(answerLabel);

        // Number 1 Text Field
        JTextField num1Field = new JTextField("Enter an integer");
        num1Field.setEditable(true);
        num1Field.setBounds(105, 40, 150, 20);
        contentPane.add(num1Field);

        // Number 2 Text Field
        JTextField num2Field = new JTextField("Enter an integer");
        num2Field.setEditable(true);
        num2Field.setBounds(105, 90, 150, 20);
        contentPane.add(num2Field);

        // Answer Text Field
        JTextField answerField = new JTextField();
        answerField.setEditable(false);
        answerField.setBounds(105, 140, 150, 20);
        contentPane.add(answerField);

        // Add Button
        JButton add = new JButton("+");
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Get text from field and convert
                num1 = Integer.parseInt(num1Field.getText());

                // Get text from field and convert
                num2 = Integer.parseInt(num2Field.getText());

                // Add the two together
                ans = num1 + num2;

                // Set text into field
                answerField.setText(String.valueOf(ans));
            }
        });
        add.setBounds(40, 190, 50, 25);
        contentPane.add(add);

        // Subtract Button
        JButton sub = new JButton("-");
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Get text from field and convert
                num1 = Integer.parseInt(num1Field.getText());

                // Get text from field and convert
                num2 = Integer.parseInt(num2Field.getText());

                // Subtract the two
                ans = num1 - num2;

                // Set text into field
                answerField.setText(String.valueOf(ans));
            }
        });
        sub.setBounds(90, 190, 50, 25);
        contentPane.add(sub);

        // Multiply Button
        JButton mul = new JButton("x");
        mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Get text from field and convert
                num1 = Integer.parseInt(num1Field.getText());

                // Get text from field and convert
                num2 = Integer.parseInt(num2Field.getText());

                // Multiply the two together
                ans = num1 * num2;

                // Set text into field
                answerField.setText(String.valueOf(ans));
            }
        });
        mul.setBounds(140, 190, 50, 25);
        contentPane.add(mul);

        // Divide Button
        JButton div = new JButton("/");
        div.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(num2 != 0){
                    // Get text from field and convert
                    num1 = Integer.parseInt(num1Field.getText());

                    // Get text from field and convert
                    num2 = Integer.parseInt(num2Field.getText());

                    // Divide the two
                    ans = num1 / num2;

                    // Set text into field
                    answerField.setText(String.valueOf(ans));
                }
                else{
                    answerField.setText("Cannot divide by zero");
                }
            }
        });
        div.setBounds(190, 190, 50, 25);
        contentPane.add(div);
        
    }
}
