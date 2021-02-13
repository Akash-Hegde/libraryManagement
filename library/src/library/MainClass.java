package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
 
import javax.swing.*;
import net.proteanit.sql.DbUtils;
 
public class MainClass {
     
    public static class ex{
        public static int days=0;
            }
 
    public static void main(String[] args) {
         
    	System.out.println("Working.......");
    	Login login;
		try {
			login = new Login();
			System.out.println("Login opened");
		} catch (Exception e) {
			System.out.println("Login not working....");
		}
}
        
    }