package library;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.util.*;
import java.sql.*;
public class User {
	public static void User(String UID) {
	     
	     
	    JFrame f=new JFrame("User Functions"); 
	    
	    JButton view_but=new JButton("View Books");
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
	     
	    JButton my_book=new JButton("My Books");
	    my_book.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	             
	               
	            JFrame f = new JFrame("My Books"); 
	            
	            int UID_int = Integer.parseInt(UID); 
	 
	            Database connection = new Database();
	            connection.connect();
	            
	            String sql="select distinct issued.*,books.bname,books.department,books.version from issued,books " + "where ((issued.uid=" + UID_int + ") and (books.bid in (select bid from issued where issued.uid="+UID_int+"))) group by iid";
	            String sql1 = "select bid from issued where uid="+UID_int;
	            try {
	                Statement stmt = connection.stmt;
	                ArrayList books_list = new ArrayList();
	  
	                
	                 
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
	     

	    JButton department = new JButton("Department Search");
	    department.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	            JFrame frame = new JFrame("Department Search"); 
	    		JLabel option_label = new JLabel("Select the Department");
	    		JTable book_list= new JTable(); 
	    		String[] options = { "--select--","ISE", "CSE","ECE"};
	    		Database connection = new Database();
	    		connection.connect();
	    		Statement stmt = connection.stmt;
	    		JComboBox departments =  new JComboBox(options);
	    		departments.addItemListener(new ItemListener() {
	    			
	    			@Override
	    			public void itemStateChanged(ItemEvent arg0) {
	    				String str = departments.getSelectedItem().toString();
	    				if(str.equals("--select--"))
	    				{
	    					System.out.println("select...");
	    				}
	    				else
	    				{
							String smt = "select * from books where department like '"+ str +"';";
							try {
								ResultSet rs = stmt.executeQuery(smt);
	    		                book_list.setModel(DbUtils.resultSetToTableModel(rs));
	    		                book_list.getColumnModel().getColumn(0).setPreferredWidth(10);
	    		                book_list.getColumnModel().getColumn(1).setPreferredWidth(200);
	    		                book_list.getColumnModel().getColumn(2).setPreferredWidth(50);
	    		                book_list.getColumnModel().getColumn(3).setPreferredWidth(50);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	    				}
	    			}
	    		});
	    		
	    		book_list.setSize(400, 400);
	    		book_list.setRowHeight(30);
	    		
	    		frame.add(option_label);
	    		frame.add(departments);
	    		frame.add(book_list);
		        frame.setVisible(true);
        	    frame.setLayout(new FlowLayout(FlowLayout.CENTER));
                frame.setSize(800, 400);

	                 
	    }
	    }
	    );
	    
	    
	    JButton search_title = new JButton("Search Title");
	    search_title.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	JLabel search_label = new JLabel("Search");
	            JTextField search = new JTextField(15); 
	            JButton search_btn = new JButton("Submit");
	            JFrame f = new JFrame("Search title"); 
	            JTable book_list= new JTable(); 
		        f.add(search_label);
		        f.add(search);
		        f.add(search_btn);
		        f.add(book_list);
		        f.setVisible(true);
        	    f.setLayout(new FlowLayout(FlowLayout.CENTER));
                f.setSize(800, 400);
  	            Database connection = new Database();
	            connection.connect();
	            Statement stmt = connection.stmt;
	            
	            search_btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String sql = search.getText();
						if(sql!="")
						{
							String smt = "select * from books where BNAME like '%"+sql+"%';";
							try {
								ResultSet rs = stmt.executeQuery(smt);
	    						
	    						ArrayList books_list = new ArrayList();
	    		                book_list.setModel(DbUtils.resultSetToTableModel(rs));
	    		                book_list.getColumnModel().getColumn(0).setPreferredWidth(10);
	    		                book_list.getColumnModel().getColumn(1).setPreferredWidth(200);
	    		                book_list.getColumnModel().getColumn(2).setPreferredWidth(50);
	    		                book_list.getColumnModel().getColumn(3).setPreferredWidth(50);
	    		               
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
				});

	                 
	        }
	    }
	    );
	     
	     
	     
	    
	    
	    
	    f.add(search_title);
	    f.add(department);
	    f.add(my_book); 
	    f.add(view_but); 
	    f.setLayout(new FlowLayout(FlowLayout.CENTER));
	    f.setVisible(true);
	    f.setSize(500,600);
	    f.setLocationRelativeTo(null);
	    }
}