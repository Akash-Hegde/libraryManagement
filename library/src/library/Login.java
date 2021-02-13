package library;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;

public class Login {
	Login() {
	     
	    JFrame f=new JFrame("Login");
	    JLabel l1,l2;  
	    l1=new JLabel("Username");
	    l1.setBounds(30,15, 100,30); 
	     
	    l2=new JLabel("Password");  
	    l2.setBounds(30,50, 100,30);    
	     
	    JTextField F_user = new JTextField(15); 
	    F_user.setBounds(110, 15, 200, 30);
	         
	    JPasswordField F_pass=new JPasswordField(15); 
	    F_pass.setBounds(110, 50, 200, 30);
	       
	    JButton login_but=new JButton("Login");
	    login_but.setBounds(130,90,80,25);
	    login_but.addActionListener(new ActionListener() {  
	         
	        public void actionPerformed(ActionEvent e){ 
	 
	        String username = F_user.getText(); 
	        String password = F_pass.getText(); 
	         
	        if(username.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter username"); 
	        } 
	        else if(password.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter password"); 
	        }
	        else { 
	            
	             Database connection = new Database();
	             
	            try
	            {
	            	connection.connect();
	              String st = ("SELECT * FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'"); 
	              ResultSet rs = connection.stmt.executeQuery(st); 
	              if(rs.next()==false) { 
	                  System.out.print("No user");  
	                  JOptionPane.showMessageDialog(null,"Wrong Username/Password!"); 
	 
	              }
	              else {
	                  f.dispose();
	                rs.beforeFirst();  
	                while(rs.next())
	                {
	                  String admin = rs.getString("ADMIN"); 
	                  
	                  String UID = rs.getString("UID"); 
	                  if(admin.equals("1")) { 
	                      Admin a;
	                      Admin.Admin(); 
	                  }
	                  else{
	                	  User user;
	                	  
	                      User.User(UID); 
	                  }
	              }
	              }
	            }
	            catch (Exception ex) {
	                 ex.printStackTrace();
	        }
	        }
	    }               
	    });
	 

	    f.add(l1);
	    f.add(F_user);
	    f.add(l2); 
	    f.add(F_pass); 
	    f.add(login_but);
  

	     
		f.setSize(600, 600);
		f.setVisible(true);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
	     
	}
}