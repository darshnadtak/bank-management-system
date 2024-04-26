package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pantf, aadhartf;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religioncb, categorycb, incomecb, eduqualcb, occupationcb;
    JButton next;
    String formno;
    
    SignupTwo(String formno){ // created obj in signupone.java, here given constructor
        
        this.formno = formno;
        
        setLayout (null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religioncb = new JComboBox(valReligion);
        religioncb.setBounds(300,140,400,30);
        religioncb.setBackground(Color.WHITE);
        add(religioncb);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190,100,30);
        add(category);
        
        String valCategory[] = {"General","OBC","SC","St","Other"};
        categorycb = new JComboBox(valCategory);
        categorycb.setBounds(300,190,400,30);
        categorycb.setBackground(Color.WHITE);
        add(categorycb);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,100,30);
        add(income);

        String valIncome[] = {"NULL","<1,50,000", "< 2,50,000","< 5,00,000","Upto 1 Lakh"};
        incomecb = new JComboBox(valIncome);
        incomecb.setBounds(300,240,400,30);
        incomecb.setBackground(Color.WHITE);
        add(incomecb);
        
        JLabel edu = new JLabel("Educational:");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100,290,200,30);
        add(edu);

        JLabel qual = new JLabel("Qualification");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100,315,200,30);
        add(qual);
        
        String valEduqual[] = {"Non-Graduation","Graduation", "Post-Graduation","Doctorate"};
        eduqualcb = new JComboBox(valEduqual);
        eduqualcb.setBounds(300,315,400,30);
        eduqualcb.setBackground(Color.WHITE);
        add(eduqualcb);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,390,150,30);
        add(occupation);

        String valOccupation[] = {"Student","Salaried","Self-Employed", "Business","Retired","Other"};
        occupationcb = new JComboBox(valOccupation);
        occupationcb.setBounds(300,390,400,30);
        occupationcb.setBackground(Color.WHITE);
        add(occupationcb);
        
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,440,150,30);
        add(pan);
        
        pantf = new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD, 20));
        pantf.setBounds(300,440,400,30);
        add(pantf);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,490,180,30);
        add(aadhar);
        
        aadhartf = new JTextField();
        aadhartf.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhartf.setBounds(300,490,400,30);
        add(aadhartf);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(100,540,150,30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBackground(Color.WHITE);
        syes.setBounds(300,540,60,30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBackground(Color.WHITE);
        sno.setBounds(380,540,60,30);
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel existingaccount = new JLabel("Exisiting Account:");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingaccount.setBounds(100,590,180,30);
        add(existingaccount);
                
        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300,590,60,30);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBackground(Color.WHITE);
        eno.setBounds(380,590,60,30);
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
        
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
    
    //Override function
    public void actionPerformed(ActionEvent ae) {
        //entering values we want in db
        //below -- this function returns an object so typecast it in string.
        String religion = (String) religioncb.getSelectedItem(); //fun used getselecteditem for combobox
        String category = (String) categorycb.getSelectedItem();
        String income = (String) incomecb.getSelectedItem(); //fun used getselecteditem for combobox
        String edu = (String) eduqualcb.getSelectedItem();
        String occupation = (String) occupationcb.getSelectedItem();
        String pan = pantf.getText();
        String aadhar = aadhartf.getText();
        String seniorcitizen = null;
        if(syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }
        
        //JOptionPane
        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+religion+"', '"+category+"', '"+income+"', '"+edu+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            
            //Signup3 object
            setVisible(false);
            new SignupThree(formno);
            
            
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
 
    public static void main (String [] args) {
        new SignupTwo(""); //pass empty string as it will give error as we dont have any default constructor //5/12
    }    
}
