//3/12
package bank.management.system;
//**how to do jdbc connectivity
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nametf, fnametf, emailtf, addresstf, citytf, statetf, pincodetf;
    JDateChooser datechooser;
    JRadioButton male, female, unmarried, married, other;
    JButton next;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO." +random); //randon no.
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel PersonalDetails = new JLabel("Page 1: Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        PersonalDetails.setBounds(290,80,400,30);
        add(PersonalDetails);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 14));
        nametf.setBounds(300,140,400,30);
        add(nametf);
        
        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnametf = new JTextField();
        fnametf.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametf.setBounds(300,190,400,30);
        add(fnametf);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        //Choose class jdatechooser
        datechooser = new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setFont(new Font("Raleway", Font.BOLD, 20));
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,100,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(380,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtf = new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtf.setBounds(300,340,400,30);
        add(emailtf);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(380,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(480,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,100,30);
        add(address);
        
        addresstf = new JTextField();
        addresstf.setFont(new Font("Raleway", Font.BOLD, 14));
        addresstf.setBounds(300,440,400,30);
        add(addresstf);
                
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        citytf = new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD, 14));
        citytf.setBounds(300,490,400,30);
        add(citytf);
                
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,100,30);
        add(state);
        
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 14));
        statetf.setBounds(300,540,400,30);
        add(statetf);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,100,30);
        add(pincode);
        
        pincodetf = new JTextField();
        pincodetf.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodetf.setBounds(300,590,400,30);
        add(pincodetf);
        
        next = new JButton("Next");
        next.setBounds(620,660,80,30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) { //override function
        //Entering the values we want in db
        String formno = "" + random; //long, to convert in string use "" before long or number
        String name = nametf.getText(); //get the value from gettext()
        String fname = fnametf.getText();
        //getUiComponent returns a textfield so use textfield to concat
        String dob = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        }else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailtf.getText();
        String marital = null;
        if(unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (married.isSelected()) {
            marital = "Married";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String address = addresstf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pincode = pincodetf.getText();
        
        //JOptionPane() function used to create a popup
        try {
            //below is called validation // like some value is required
           if (name.equals("")) { 
               JOptionPane.showMessageDialog(null, "Name is Required");
           } else {
               // call db
               //make obj of SignupTwo
               Conn c = new Conn();
               String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
               c.s.executeUpdate(query); //execute query
               
               setVisible(false); //curret frame will close
               new SignupTwo(formno); //SignupTwo window will open
               //upper line will give error after passing value of formno if we dont have any constructor in SignupTwo.java
           }
           
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[] ){
        new SignupOne();
    }
}


