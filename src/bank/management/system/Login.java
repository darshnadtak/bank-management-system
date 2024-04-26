//2/12
package bank.management.system;

import javax.swing.*; //swing package comes from java extended package
import java.awt.*; //import image package from awt
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener { //using inheritance concept 
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() { //constructor
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //class ImageIcon, i1 is object, classloader is class, getsystem.. is static method
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //create image class object, set image position
        // we can place imageicon in jlabel but image cant be placed in jlabel
        ImageIcon i3 = new ImageIcon(i2); // i2 is passed in i3 to make imageicon
        JLabel label = new JLabel(i3); //label is variable, pass i1
        label.setBounds(70, 10, 100, 100); //setbound is used for custom layout but first make setlayout null
        add(label); //pass the variable object to place the component in frame
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Rleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 30);
        add(pin);  
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE); //to use whole frame use getcontentpane function and chng bg color to white
        
        
        setSize(800,480); //function
        setLocation(350, 200); //left,top
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) { //what task should be performed by the button
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
            
        } else if (ae.getSource() == login) {
            
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try {
                //if query gets matched then it will return some data.
                //resultset is an obj, type of data is resultset
               ResultSet rs = c.s.executeQuery(query);
               if(rs.next()) {
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
                   
               } else {
                   JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
               }
               
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            
        } else if (ae.getSource() == signup) {
            setVisible(false);
            //create signup object
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login(); // class ka anonymous object
    }
}
