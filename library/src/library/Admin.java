package library;

import javax.swing.*;

//import MainClass.ex;

import java.awt.*;
import java.text.*;
import java.sql.*;
import java.sql.Date;

import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Admin {
	public static void Admin() {
	     
	     
	    JFrame f=new JFrame("Admin Functions"); 
	    
	     
	     
	    JButton create_but=new JButton("Create/Reset");
	    create_but.setBounds(450,60,120,25);
	    
	     
	     
	    JButton view_but=new JButton("View Books");
	    view_but.setBounds(20,20,120,25);
	    view_but.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	             
	            JFrame f = new JFrame("Books Available"); 
	            
	             
	            Database connection = new Database();
	            connection.connect(); 
	            String sql="select * from BOOKS"; 
	            try {
	                Statement stmt = connection.stmt;
	                ResultSet rs=stmt.executeQuery(sql);
	                JTable book_list= new JTable(); 
	                book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                
	                JScrollPane scrollPane = new JScrollPane(book_list); 
	 
	                f.add(scrollPane); 
	                f.setSize(800, 400); 
	                f.setVisible(true);
	                f.setLocationRelativeTo(null);
	            } catch (SQLException e1) {
	                
	                 JOptionPane.showMessageDialog(null, e1);
	            }               
	             
	    }
	    }
	    );
	     
	    JButton users_but=new JButton("View Users");
	    users_but.setBounds(150,20,120,25);
	    users_but.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	                 
	                JFrame f = new JFrame("Users List");
	                
	                 
	                Database connection = new Database();
	                connection.connect();
	                String sql="select * from users"; 
	                try {
	                    Statement stmt = connection.stmt;
	                    ResultSet rs=stmt.executeQuery(sql);
	                    JTable book_list= new JTable();
	                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                    
	                    JScrollPane scrollPane = new JScrollPane(book_list);
	 
	                    f.add(scrollPane); 
	                    f.setSize(800, 400); 
	                    f.setVisible(true);
	                    f.setLocationRelativeTo(null);
	                } catch (SQLException e1) {
	                    
	                     JOptionPane.showMessageDialog(null, e1);
	                }       
	                 
	                 
	    }
	        }
	    );  
	     
	    JButton issued_but=new JButton("View Issued Books");
	    issued_but.setBounds(280,20,160,25);
	    issued_but.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	                 
	                JFrame f = new JFrame("Users List");
	                
	                 
	                Database connection = new Database();
	                connection.connect();
	                String sql="select * from issued";
	                try {
	                    Statement stmt = connection.stmt;
	                    ResultSet rs=stmt.executeQuery(sql);
	                    JTable book_list= new JTable();
	                    book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                     
	                    JScrollPane scrollPane = new JScrollPane(book_list);
	 
	                    f.add(scrollPane);
	                    f.setSize(800, 400);
	                    f.setVisible(true);
	                    f.setLocationRelativeTo(null);
	                } catch (SQLException e1) {
	                    
	                     JOptionPane.showMessageDialog(null, e1);
	                }       
	                             
	    }
	        }
	    );
	     
	     
	    JButton add_user=new JButton("Add User"); 
	    add_user.setBounds(20,60,120,25); 
	     
	    add_user.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	                 
	                JFrame g = new JFrame("Enter User Details"); 
	                
	                
	                JLabel l1,l2;  
	                l1=new JLabel("Username");  
	                l1.setBounds(30,15, 100,30); 
	                 
	                 
	                l2=new JLabel("Password");  
	                l2.setBounds(30,50, 100,30); 
	                 
	                
	                JTextField F_user = new JTextField();
	                F_user.setBounds(110, 15, 200, 30);
	                 
	                
	                JPasswordField F_pass=new JPasswordField();
	                F_pass.setBounds(110, 50, 200, 30);
	                
	                JRadioButton a1 = new JRadioButton("Admin");
	                a1.setBounds(55, 80, 200,30);
	                
	                JRadioButton a2 = new JRadioButton("User");
	                a2.setBounds(130, 80, 200,30);
	                
	                ButtonGroup bg=new ButtonGroup();    
	                bg.add(a1);bg.add(a2);  
	                 
	                                 
	                JButton create_but=new JButton("Create");
	                create_but.setBounds(130,130,80,25);
	                create_but.addActionListener(new ActionListener() {
	                     
	                    public void actionPerformed(ActionEvent e){
	                     
	                    String username = F_user.getText();
	                    String password = F_pass.getText();
	                    Boolean admin = false;
	                     
	                    if(a1.isSelected()) {
	                        admin=true;
	                    }
	                    Database connection = new Database();
	                   connection.connect();
	                     
	                    try {
	                    Statement stmt = connection.stmt;
	                     stmt.executeUpdate("INSERT INTO USERS(USERNAME,PASSWORD,ADMIN) VALUES ('"+username+"','"+password+"',"+admin+")");
	                     JOptionPane.showMessageDialog(null,"User added!");
	                     g.dispose();
	                      
	                    }
	                     
	                    catch (SQLException e1) {
	                        
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                });
	                     
	                 
	                    g.add(create_but);
	                    g.add(a2);
	                    g.add(a1);
	                    g.add(l1);
	                    g.add(l2);
	                    g.add(F_user);
	                    g.add(F_pass);
	                    g.setSize(350,200);
	                    g.setLayout(null);
	                    g.setVisible(true);
	                    g.setLocationRelativeTo(null);
	                 
	                 
	    }
	    });
	         
	     
	    JButton add_book=new JButton("Add Book"); 
	    add_book.setBounds(150,60,120,25); 
	     
	    add_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	                
	                JFrame g = new JFrame("Enter Book Details");
	                
	                
	                JLabel l1,l2,l3;  
	                l1=new JLabel("Book Name");  
	                l1.setBounds(30,15, 100,30); 
	                 
	                 
	                l2=new JLabel("Department");  
	                l2.setBounds(30,53, 100,30); 
	                 
	                l3=new JLabel("Version");  
	                l3.setBounds(30,90, 100,30); 
	                 
	                
	                JTextField F_bname = new JTextField();
	                F_bname.setBounds(110, 15, 200, 30);
	                 
	                
	                JTextField F_genre=new JTextField();
	                F_genre.setBounds(110, 53, 200, 30);
	                
	                JTextField F_price=new JTextField();
	                F_price.setBounds(110, 90, 200, 30);
	                         
	                 
	                JButton create_but=new JButton("Submit");
	                create_but.setBounds(130,130,80,25);
	                create_but.addActionListener(new ActionListener() {
	                     
	                    public void actionPerformed(ActionEvent e){
	                    
	                    String bname = F_bname.getText();
	                    String genre = F_genre.getText();
	                    String price = F_price.getText();
	                    
	                    int price_int = Integer.parseInt(price);
	                    Database connection = new Database();
	                    connection.connect();
	                     
	                    try {
	                    Statement stmt = connection.stmt;
	                     stmt.executeUpdate("INSERT INTO BOOKS(BNAME,DEPARTMENT,VERSION) VALUES ('"+bname+"','"+genre+"',"+price_int+")");
	                     JOptionPane.showMessageDialog(null,"Book added!");
	                     g.dispose();
	                      
	                    }
	                     
	                    catch (SQLException e1) {
	                        
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                });
	                                 
	                    g.add(l3);
	                    g.add(create_but);
	                    g.add(l1);
	                    g.add(l2);
	                    g.add(F_bname);
	                    g.add(F_genre);
	                    g.add(F_price);
	                    g.setSize(350,200);
	                    g.setLayout(null);
	                    g.setVisible(true);
	                    g.setLocationRelativeTo(null);
	                             
	    }
	    });
	     
	     
	    JButton issue_book=new JButton("Issue Book"); 
	    issue_book.setBounds(450,20,120,25); 
	     
	    issue_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	                
	                JFrame g = new JFrame("Enter Details");
	                
	                
	                JLabel l1,l2,l3,l4;  
	                l1=new JLabel("Book ID(BID)");  
	                l1.setBounds(30,15, 100,30); 
	                 
	                 
	                l2=new JLabel("User ID(UID)");  
	                l2.setBounds(30,53, 100,30); 
	                 
	                l3=new JLabel("Period(days)");  
	                l3.setBounds(30,90, 100,30); 
	                 
	                l4=new JLabel("Issued Date(DD-MM-YYYY)");  
	                l4.setBounds(30,127, 150,30); 
	                 
	                JTextField F_bid = new JTextField();
	                F_bid.setBounds(110, 15, 200, 30);
	                 
	                 
	                JTextField F_uid=new JTextField();
	                F_uid.setBounds(110, 53, 200, 30);
	                 
	                JTextField F_period=new JTextField();
	                F_period.setBounds(110, 90, 200, 30);
	                 
	                JTextField F_issue=new JTextField();
	                F_issue.setBounds(180, 130, 130, 30);   
	 
	                 
	                JButton create_but=new JButton("Submit");
	                create_but.setBounds(130,170,80,25);
	                create_but.addActionListener(new ActionListener() {
	                     
	                    public void actionPerformed(ActionEvent e){
	                     
	                    String uid = F_uid.getText();
	                    String bid = F_bid.getText();
	                    String period = F_period.getText();
	                    String issued_date = F_issue.getText();
	 
	                    int period_int = Integer.parseInt(period);
	                    Database connection = new Database();
	                    connection.connect();
	                     
	                    try {
	                    Statement stmt = connection.stmt;
	                     stmt.executeUpdate("INSERT INTO ISSUED(UID,BID,ISSUED_DATE,PERIOD) VALUES ('"+uid+"','"+bid+"','"+issued_date+"',"+period_int+")");
	                     JOptionPane.showMessageDialog(null,"Book Issued!");
	                     g.dispose();
	                      
	                    }
	                     
	                    catch (SQLException e1) {
	                        
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                });
	                     
	                 
	                    g.add(l3);
	                    g.add(l4);
	                    g.add(create_but);
	                    g.add(l1);
	                    g.add(l2);
	                    g.add(F_uid);
	                    g.add(F_bid);
	                    g.add(F_period);
	                    g.add(F_issue);
	                    g.setSize(350,250);
	                    g.setLayout(null);
	                    g.setVisible(true);
	                    g.setLocationRelativeTo(null);
	                 
	                 
	    }
	    });
	     
	     
	    JButton return_book=new JButton("Return Book"); 
	    return_book.setBounds(280,60,160,25); 
	     
	    return_book.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	                 
	                JFrame g = new JFrame("Enter Details");
	                
	                
	                JLabel l1,l2,l3,l4;  
	                l1=new JLabel("Issue ID(IID)");  
	                l1.setBounds(30,15, 100,30); 
	                
	                 
	                l4=new JLabel("Return Date(DD-MM-YYYY)");  
	                l4.setBounds(30,50, 150,30); 
	                 
	                JTextField F_iid = new JTextField();
	                F_iid.setBounds(110, 15, 200, 30);
	                 
	                 
	                JTextField F_return=new JTextField();
	                F_return.setBounds(180, 50, 130, 30);
	             
	 
	                JButton create_but=new JButton("Return");
	                create_but.setBounds(130,170,80,25);
	                create_but.addActionListener(new ActionListener() {
	                     
	                    public void actionPerformed(ActionEvent e){                 
	                     
	                    String iid = F_iid.getText();
	                    String return_date = F_return.getText();
	                    Database connection = new Database();
	                   connection.connect();
	                     
	                    try {
	                    Statement stmt = connection.stmt;
	                     
	                     String date1=null;
	                     String date2=return_date; 
	                     
	                     
	                     ResultSet rs = stmt.executeQuery("SELECT ISSUED_DATE FROM ISSUED WHERE IID="+iid);
	                     while (rs.next()) {
	                         date1 = rs.getString(1);
	                          
	                       }
	                      
	                     try {
	                            Date date_1=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(date1);
	                            Date date_2=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(date2);
	                            
	                            long diff = date_2.getTime() - date_1.getTime();
	                            
	                         //   ex.days=(int)(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	                             
	                             
	                        } catch (ParseException e1) {
	                            
	                            e1.printStackTrace();
	                        }
	                      
	                     
	                     
	                     stmt.executeUpdate("UPDATE ISSUED SET RETURN_DATE='"+return_date+"' WHERE IID="+iid);
	                     g.dispose();
	                      
	                     Database connection1 = new Database();
	                     connection1.connect();
	                     Statement stmt1 = connection1.stmt;          
	                    ResultSet rs1 = stmt1.executeQuery("SELECT PERIOD FROM ISSUED WHERE IID="+iid); 
	                    String diff=null; 
	                    while (rs1.next()) {
	                         diff = rs1.getString(1);
	                          
	                       }
	                    int diff_int = Integer.parseInt(diff);
//	                    if(ex.days&amp;amp;amp;amp;amp;amp;amp;amp;amp;amp;gt;diff_int) { 
//	                         
//	                        
//	                        int fine = (ex.days-diff_int)*10; 
//	                        
//	                        stmt1.executeUpdate("UPDATE ISSUED SET FINE="+fine+" WHERE IID="+iid);  
//	                        String fine_str = ("Fine: Rs. "+fine);
//	                        JOptionPane.showMessageDialog(null,fine_str);
//	                         
//	                    }
//	 
	                     JOptionPane.showMessageDialog(null,"Book Returned!");
	                      
	                    }
	                             
	                     
	                    catch (SQLException e1) {
	                        
	                         JOptionPane.showMessageDialog(null, e1);
	                    }   
	                     
	                    }
	                     
	                }); 
	                    g.add(l4);
	                    g.add(create_but);
	                    g.add(l1);
	                    g.add(F_iid);
	                    g.add(F_return);
	                    g.setSize(350,250);
	                    g.setLayout(null);
	                    g.setVisible(true);
	                    g.setLocationRelativeTo(null);              
	    }
	    });
	     
	    f.add(create_but);
	    f.add(return_book);
	    f.add(issue_book);
	    f.add(add_book);
	    f.add(issued_but);
	    f.add(users_but);
	    f.add(view_but);
	    f.add(add_user);
	    f.setSize(600,200);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	     
	    }
	
}
