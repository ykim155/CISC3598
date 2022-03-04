package Lab4;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class fields extends JFrame{
    String fname;
    String lname;
    String email;
    int salary;
    String bdate;
    String state;
    String job;

    public static void main(String[] args){
        fields frame = new fields();
        frame.setVisible(true);
    }

    public fields(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 300);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 2));
        contentPane.setBorder(new TitledBorder("Add Employee"));;
        setContentPane(contentPane);

        JLabel fNameLabel = new JLabel("First Name:");
        JLabel lNameLabel = new JLabel("Last Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel salaryLabel = new JLabel("Salary:");
        JLabel bdateLabel = new JLabel("Date of Birth:");
        JLabel empty1 = new JLabel("");
        JLabel empty2 = new JLabel("");
        JLabel format = new JLabel("mm/dd/yyyy");
        JLabel stateLabel = new JLabel("State:");
        JLabel jobLabel = new JLabel("Role:");

        JTextField fnameField = new JTextField();
        JTextField lnameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField bdateField = new JTextField();

        String[] states = {"AK - Alaska", 
        "AL - Alabama", 
        "AR - Arkansas", 
        "AS - American Samoa", 
        "AZ - Arizona", 
        "CA - California", 
        "CO - Colorado", 
        "CT - Connecticut", 
        "DC - District of Columbia", 
        "DE - Delaware", 
        "FL - Florida", 
        "GA - Georgia", 
        "GU - Guam", 
        "HI - Hawaii", 
        "IA - Iowa", 
        "ID - Idaho", 
        "IL - Illinois", 
        "IN - Indiana", 
        "KS - Kansas", 
        "KY - Kentucky", 
        "LA - Louisiana", 
        "MA - Massachusetts", 
        "MD - Maryland", 
        "ME - Maine", 
        "MI - Michigan", 
        "MN - Minnesota", 
        "MO - Missouri", 
        "MS - Mississippi", 
        "MT - Montana", 
        "NC - North Carolina", 
        "ND - North Dakota", 
        "NE - Nebraska", 
        "NH - New Hampshire", 
        "NJ - New Jersey", 
        "NM - New Mexico", 
        "NV - Nevada", 
        "NY - New York", 
        "OH - Ohio", 
        "OK - Oklahoma", 
        "OR - Oregon", 
        "PA - Pennsylvania", 
        "PR - Puerto Rico", 
        "RI - Rhode Island", 
        "SC - South Carolina", 
        "SD - South Dakota", 
        "TN - Tennessee", 
        "TX - Texas", 
        "UT - Utah", 
        "VA - Virginia", 
        "VI - Virgin Islands", 
        "VT - Vermont", 
        "WA - Washington", 
        "WI - Wisconsin", 
        "WV - West Virginia", 
        "WY - Wyoming"};

        JComboBox<String> stateDropdown = new JComboBox<String>(states);

        JPanel radioButtons = new JPanel();
        radioButtons.setLayout(new GridLayout(0,1));

        JRadioButton sdeRadio = new JRadioButton("Software Developer");
        JRadioButton pmRadio = new JRadioButton("Project Manager");

        radioButtons.add(sdeRadio);
        radioButtons.add(pmRadio);


        contentPane.add(fNameLabel);
        contentPane.add(fnameField);
        contentPane.add(lNameLabel);
        contentPane.add(lnameField);
        contentPane.add(emailLabel);
        contentPane.add(emailField);
        contentPane.add(salaryLabel);
        contentPane.add(salaryField);
        contentPane.add(bdateLabel);
        contentPane.add(bdateField);
        contentPane.add(empty1);
        contentPane.add(format);
        contentPane.add(stateLabel);
        contentPane.add(stateDropdown);
        contentPane.add(jobLabel);
        contentPane.add(radioButtons);
        contentPane.add(empty2);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(0,2));

        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				    fname = fnameField.getText();
                    lname = lnameField.getText();
				    email = emailField.getText();
				    salary = Integer.parseInt(salaryField.getText());
                    bdate = bdateField.getText();
                    state = stateDropdown.getSelectedItem().toString();
                    if(sdeRadio.isSelected()){
                        job = sdeRadio.getText();
                    }
                    else{
                        job = pmRadio.getText();
                    }

                    String data = fname + " " + lname + " " + email + " " + salary + " " + bdate + " " + state + " " + job;
                    fileIO write = new fileIO();
				    write.wrTransactionData(data);
			}
			
		});
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				    dispose();
			}
		});
        buttons.add(save);
        buttons.add(cancel);
        contentPane.add(buttons);

        

    }
}