package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*; //resultset

public class MiniStatement extends JFrame{
    
    String pinnumber;
    
    MiniStatement(String pinnumber) {
    
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("Mini Statement");
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        add(image);
//        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try { //db hit
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+5555+"'");
            while(rs.next()) {
               card.setText("Card Number: "+rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(11));
               
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>"); //settext do overwrite but here we have to append
                    if (rs.getString("type").equals("Deposit")) {
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Current Balance is Rs " +bal);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args) {
       new MiniStatement(""); //no default constructor so give empty string
        
    }
}
