package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import dao.Movie;
import dao.User;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BackEnd {

	
	
//Database connection properties -----------------------------------------------------------------------------------------------------------------------			
	
	public static Connection connectionWithDatabase() { 
	
			Connection conn = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	String db_url = "jdbc:mysql://localhost/bd_vk";
        	String user = "root";
        	String password = "";
        	
            conn = DriverManager.getConnection(db_url, user, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return conn;
    }


//Navigation Users * -----------------------------------------------------------------------------------------------------------------------	
	
//Navigation Users.New_user	--------------------------------------------------------------------------------------------------------------------
	
	protected static String makingUserID() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
	
	
	public void addUser(){
		
		String id_klienta = makingUserID();

		String sql = "INSERT INTO klient (imie,id_klienta,nazwisko,pesel,adres,telefon,email) VALUES('"+FrontEnd.firstnameTF.getText()+"','"+id_klienta+"','"+FrontEnd.lastnameTF.getText()+"','"+FrontEnd.peselTF.getText()+"','"+FrontEnd.adressTF.getText()+"','"+FrontEnd.phone_numberTF.getText()+"','"+FrontEnd.emailTF.getText()+"')";
     
        
		if( FrontEnd.firstnameTF.getText().equals("") || FrontEnd.lastnameTF.getText().equals("") || FrontEnd.peselTF.getText().equals("") || FrontEnd.adressTF.getText().equals("") || FrontEnd.phone_numberTF.getText().equals("") ){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uwaga");
			alert.setHeaderText(null);
			alert.setContentText("Musisz wypełnić wszystkie pola z * ");

			alert.showAndWait();
		}
		else{	
			
			try{
				Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	stmt.executeUpdate(sql);
			} catch (SQLException e) {
                System.out.println(e.getMessage());
            }
			
	        try {
	        		String sqlUzimiID = "SELECT * FROM klient WHERE pesel='" + FrontEnd.peselTF.getText() + "';";
	        	
	                Connection conn = this.connectionWithDatabase();
	                Statement stmt  = conn.createStatement();
	            	ResultSet rs = stmt.executeQuery(sqlUzimiID);
	            	
	            	String idklienta = "";
	            	String imienazwisko = "";
	            	if(rs.next()){
	            	idklienta = rs.getString("id_klienta");
	            	imienazwisko = rs.getString("imie") + " " + rs.getString("nazwisko");
	            	}
	            	
	        		Alert alert = new Alert(AlertType.INFORMATION);
	        		alert.setTitle("Notification");
	        		alert.setHeaderText(null);
	        		alert.setContentText("Pomyślnie dodałeś nowego klienta: " + imienazwisko +".\nJego ID to: "  +idklienta);
	        		alert.showAndWait();
	        		
	        		FrontEnd.firstnameTF.clear();
	        		FrontEnd.lastnameTF.clear();
	        		FrontEnd.peselTF.clear();
	        		FrontEnd.adressTF.clear();
	        		FrontEnd.phone_numberTF.clear();
	        		FrontEnd.emailTF.clear();
	                
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }

		}		
	}
	

//Navigation User.Edit_user --------------------------------------------------------------------------------------------------------------------	
	public void allowUserEdit(){
		
		String sql ="SELECT * FROM klient WHERE id_klienta='"+FrontEnd.idTF2.getText()+"';";
		
        try {
            Connection conn = this.connectionWithDatabase();
            Statement stmt  = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
        	
        	if(rs.next()==true){
        	FrontEnd.idL2.setDisable(true);
        	FrontEnd.idTF2.setDisable(true);
        	FrontEnd.searchButton2.setDisable(true);
 	
    		FrontEnd.firstnameTF2.setDisable(false);
    		FrontEnd.lastnameTF2.setDisable(false);   		
    		FrontEnd.peselTF2.setDisable(false);   		
    		FrontEnd.adressTF2.setDisable(false);  		
    		FrontEnd.phone_numberTF2.setDisable(false);
    		FrontEnd.emailTF2.setDisable(false);
    		FrontEnd.firstnameL2.setDisable(false);
    		FrontEnd.lastnameL2.setDisable(false);
    		FrontEnd.peselL2.setDisable(false);
    		FrontEnd.adressL2.setDisable(false);
    		FrontEnd.phone_numberL2.setDisable(false);
    		FrontEnd.emailL2.setDisable(false);
    		FrontEnd.editButton2.setDisable(false);
    		FrontEnd.changeUserButton2.setDisable(false);
    				
        	FrontEnd.firstnameTF2.setText(rs.getString("imee"));
        	FrontEnd.lastnameTF2.setText(rs.getString("nazwisko"));
        	FrontEnd.peselTF2.setText(rs.getString("pesel"));
        	FrontEnd.adressTF2.setText(rs.getString("adres"));
        	FrontEnd.phone_numberTF2.setText(rs.getString("telefon"));
        	FrontEnd.emailTF2.setText(rs.getString("email"));
    		
        	
    		FrontEnd.firstnameTF2.setStyle(null);
    		FrontEnd.lastnameTF2.setStyle(null);
    		FrontEnd.peselTF2.setStyle(null);
    		FrontEnd.adressTF2.setStyle(null);
    		FrontEnd.phone_numberTF2.setStyle(null);
    		FrontEnd.emailTF2.setStyle(null);
    		FrontEnd.editButton2.setStyle(null);
        	}
        	else{
        		FrontEnd.firstnameTF2.clear();
        		FrontEnd.lastnameTF2.clear();  		
        		FrontEnd.peselTF2.clear();   		
        		FrontEnd.adressTF2.clear(); 		
        		FrontEnd.phone_numberTF2.clear();
        		FrontEnd.emailTF2.clear();
                
        		FrontEnd.firstnameTF2.setDisable(true);
        		FrontEnd.lastnameTF2.setDisable(true);   		
        		FrontEnd.peselTF2.setDisable(true);   		
        		FrontEnd.adressTF2.setDisable(true);  		
        		FrontEnd.phone_numberTF2.setDisable(true);
        		FrontEnd.emailTF2.setDisable(true);
        		FrontEnd.firstnameL2.setDisable(true);
        		FrontEnd.lastnameL2.setDisable(true);
        		FrontEnd.peselL2.setDisable(true);
        		FrontEnd.adressL2.setDisable(true);
        		FrontEnd.phone_numberL2.setDisable(true);
        		FrontEnd.emailL2.setDisable(true);
        		FrontEnd.editButton2.setDisable(true);
        		

    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Uwaga");
    			alert.setHeaderText(null);
    			alert.setContentText("Musisz wpisać poprawny ID klienta! ");

    			alert.showAndWait();
        	}
                
         } catch (SQLException e) {
                System.out.println(e.getMessage());
                
                //This is if user put characters in ID
        		FrontEnd.firstnameTF2.clear();
        		FrontEnd.lastnameTF2.clear();  		
        		FrontEnd.peselTF2.clear();   		
        		FrontEnd.adressTF2.clear(); 		
        		FrontEnd.phone_numberTF2.clear();
        		FrontEnd.emailTF2.clear();
                
        		FrontEnd.firstnameTF2.setDisable(true);
        		FrontEnd.lastnameTF2.setDisable(true);   		
        		FrontEnd.peselTF2.setDisable(true);   		
        		FrontEnd.adressTF2.setDisable(true);  		
        		FrontEnd.phone_numberTF2.setDisable(true);
        		FrontEnd.emailTF2.setDisable(true);
        		FrontEnd.firstnameL2.setDisable(true);
        		FrontEnd.lastnameL2.setDisable(true);
        		FrontEnd.peselL2.setDisable(true);
        		FrontEnd.adressL2.setDisable(true);
        		FrontEnd.phone_numberL2.setDisable(true);
        		FrontEnd.emailL2.setDisable(true);
        		FrontEnd.editButton2.setDisable(true);
        		

    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Uwaga");
    			alert.setHeaderText(null);
    			alert.setContentText("Musisz wpisać poprawny ID klienta! ");

    			alert.showAndWait();
            }
		
	}
	
	public void change_userEdit(){
	 	
    	FrontEnd.idL2.setDisable(false);
    	FrontEnd.idTF2.setDisable(false);
    	FrontEnd.searchButton2.setDisable(false);
    	
    	FrontEnd.idTF2.clear();
		FrontEnd.firstnameTF2.clear();
		FrontEnd.lastnameTF2.clear();  		
		FrontEnd.peselTF2.clear();   		
		FrontEnd.adressTF2.clear(); 		
		FrontEnd.phone_numberTF2.clear();
		FrontEnd.emailTF2.clear();
	
		FrontEnd.firstnameTF2.setDisable(true);
		FrontEnd.lastnameTF2.setDisable(true);   		
		FrontEnd.peselTF2.setDisable(true);   		
		FrontEnd.adressTF2.setDisable(true);  		
		FrontEnd.phone_numberTF2.setDisable(true);
		FrontEnd.emailTF2.setDisable(true);
		FrontEnd.firstnameL2.setDisable(true);
		FrontEnd.lastnameL2.setDisable(true);
		FrontEnd.peselL2.setDisable(true);
		FrontEnd.adressL2.setDisable(true);
		FrontEnd.phone_numberL2.setDisable(true);
		FrontEnd.emailL2.setDisable(true);
		FrontEnd.editButton2.setDisable(true);
		FrontEnd.changeUserButton2.setDisable(true);      
      
}
	
	public void editUser(){
		
		String sql = "UPDATE klient SET imie='"+FrontEnd.firstnameTF2.getText()+"',nazwisko='"+FrontEnd.lastnameTF2.getText()+"',pesel="+FrontEnd.peselTF2.getText()+",adres='"+FrontEnd.adressTF2.getText()+"',telefon="+FrontEnd.phone_numberTF2.getText()+",email='"+FrontEnd.emailTF2.getText()+"' WHERE id_klienta='"+FrontEnd.idTF2.getText()+"';";

		if( FrontEnd.firstnameTF2.getText().equals("") || FrontEnd.lastnameTF2.getText().equals("") || FrontEnd.peselTF2.getText().equals("") || FrontEnd.adressTF2.getText().equals("") || FrontEnd.phone_numberTF2.equals("") ){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uwaga");
			alert.setHeaderText(null);
			alert.setContentText("Musisz wypełnić wszystkie pola z * ");

			alert.showAndWait();
		}
		else{
		
		
        try {
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	stmt.executeUpdate(sql);
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Uwaga");
		alert.setHeaderText(null);
		alert.setContentText("Pomyślnie edytowałes klienta.");
		alert.showAndWait();
		
    	FrontEnd.idL2.setDisable(false);
    	FrontEnd.idTF2.setDisable(false);
    	FrontEnd.searchButton2.setDisable(false);
        
    	FrontEnd.idTF2.clear();
		FrontEnd.firstnameTF2.clear();
		FrontEnd.lastnameTF2.clear();  		
		FrontEnd.peselTF2.clear();   		
		FrontEnd.adressTF2.clear(); 		
		FrontEnd.phone_numberTF2.clear();
		FrontEnd.emailTF2.clear();
        
		FrontEnd.firstnameTF2.setDisable(true);
		FrontEnd.lastnameTF2.setDisable(true);   		
		FrontEnd.peselTF2.setDisable(true);   		
		FrontEnd.adressTF2.setDisable(true);  		
		FrontEnd.phone_numberTF2.setDisable(true);
		FrontEnd.emailTF2.setDisable(true);
		FrontEnd.firstnameL2.setDisable(true);
		FrontEnd.lastnameL2.setDisable(true);
		FrontEnd.peselL2.setDisable(true);
		FrontEnd.adressL2.setDisable(true);
		FrontEnd.phone_numberL2.setDisable(true);
		FrontEnd.emailL2.setDisable(true);
		FrontEnd.editButton2.setDisable(true);
    	FrontEnd.changeUserButton2.setDisable(true);
		
		}
		
	}
	
	
//Navigation Users.Show_user --------------------------------------------------------------------------------------------------------------------	
	public void showUser(){
		
		String sql ="SELECT * FROM klient WHERE id_klienta='"+FrontEnd.idTF3.getText()+"';";
		
        try {
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
 	
            	if(rs.next()){
            		FrontEnd.firstnameTF3.setDisable(false);
            		FrontEnd.lastnameTF3.setDisable(false);   		
            		FrontEnd.peselTF3.setDisable(false);   		
            		FrontEnd.adressTF3.setDisable(false);  		
            		FrontEnd.phone_numberTF3.setDisable(false);
            		FrontEnd.emailTF3.setDisable(false);
            		FrontEnd.firstnameL3.setDisable(false);
            		FrontEnd.lastnameL3.setDisable(false);
            		FrontEnd.peselL3.setDisable(false);
            		FrontEnd.adressL3.setDisable(false);
            		FrontEnd.phone_numberL3.setDisable(false);
            		FrontEnd.emailL3.setDisable(false);
            		
            		
                	FrontEnd.firstnameTF3.setText(rs.getString("imie"));
                	FrontEnd.lastnameTF3.setText(rs.getString("nazwisko"));
                	FrontEnd.peselTF3.setText(rs.getString("pesel"));
                	FrontEnd.adressTF3.setText(rs.getString("adres"));
                	FrontEnd.phone_numberTF3.setText(rs.getString("telefon"));
                	FrontEnd.emailTF3.setText(rs.getString("email"));
            		}else{
            			
            			FrontEnd.firstnameTF3.clear();
                		FrontEnd.lastnameTF3.clear();  		
                		FrontEnd.peselTF3.clear();   		
                		FrontEnd.adressTF3.clear(); 		
                		FrontEnd.phone_numberTF3.clear();
                		FrontEnd.emailTF3.clear();
                        
                		FrontEnd.firstnameTF3.setDisable(true);
                		FrontEnd.lastnameTF3.setDisable(true);   		
                		FrontEnd.peselTF3.setDisable(true);   		
                		FrontEnd.adressTF3.setDisable(true);  		
                		FrontEnd.phone_numberTF3.setDisable(true);
                		FrontEnd.emailTF3.setDisable(true);
                		FrontEnd.firstnameL3.setDisable(true);
                		FrontEnd.lastnameL3.setDisable(true);
                		FrontEnd.peselL3.setDisable(true);
                		FrontEnd.adressL3.setDisable(true);
                		FrontEnd.phone_numberL3.setDisable(true);
                		FrontEnd.emailL3.setDisable(true);
                		

                        
            			Alert alert = new Alert(AlertType.WARNING);
            			alert.setTitle("Uwaga");
            			alert.setHeaderText(null);
            			alert.setContentText("Musisz wpisać poprawny ID klienta! ");

            			alert.showAndWait();
            	}
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
		
	}
	

//Navigation Users.Delete_user --------------------------------------------------------------------------------------------------------------------	
	public void allow_deleting_user(){
		
		String sql ="SELECT * FROM klient WHERE id_klienta='"+FrontEnd.idTF4.getText()+"';";
		
        try (
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
                ){
        	if(rs.next()==true){
        	FrontEnd.idL4.setDisable(true);
        	FrontEnd.idTF4.setDisable(true);
        	FrontEnd.searchButton4.setDisable(true);
 	
    		FrontEnd.firstnameTF4.setDisable(false);
    		FrontEnd.lastnameTF4.setDisable(false);   		
    		FrontEnd.peselTF4.setDisable(false);   		
    		FrontEnd.adressTF4.setDisable(false);  		
    		FrontEnd.phone_numberTF4.setDisable(false);
    		FrontEnd.emailTF4.setDisable(false);
    		FrontEnd.firstnameL4.setDisable(false);
    		FrontEnd.lastnameL4.setDisable(false);
    		FrontEnd.peselL4.setDisable(false);
    		FrontEnd.adressL4.setDisable(false);
    		FrontEnd.phone_numberL4.setDisable(false);
    		FrontEnd.emailL4.setDisable(false);
    		FrontEnd.deleteButton4.setDisable(false);
    		FrontEnd.changeUserButton4.setDisable(false);
    		

        	FrontEnd.firstnameTF4.setText(rs.getString("imie"));
        	FrontEnd.lastnameTF4.setText(rs.getString("nazwisko"));
        	FrontEnd.peselTF4.setText(rs.getString("pesel"));
        	FrontEnd.adressTF4.setText(rs.getString("adres"));
        	FrontEnd.phone_numberTF4.setText(rs.getString("telefon"));
        	FrontEnd.emailTF4.setText(rs.getString("email"));
    		}
        	else{
            	FrontEnd.idL4.setDisable(false);
            	FrontEnd.idTF4.setDisable(false);
            	FrontEnd.searchButton4.setDisable(false);
        		FrontEnd.firstnameTF4.clear();
        		FrontEnd.lastnameTF4.clear();  		
        		FrontEnd.peselTF4.clear();   		
        		FrontEnd.adressTF4.clear(); 		
        		FrontEnd.phone_numberTF4.clear();
        		FrontEnd.emailTF4.clear();
                
        		FrontEnd.firstnameTF4.setDisable(true);
        		FrontEnd.lastnameTF4.setDisable(true);   		
        		FrontEnd.peselTF4.setDisable(true);   		
        		FrontEnd.adressTF4.setDisable(true);  		
        		FrontEnd.phone_numberTF4.setDisable(true);
        		FrontEnd.emailTF4.setDisable(true);
        		FrontEnd.firstnameL4.setDisable(true);
        		FrontEnd.lastnameL4.setDisable(true);
        		FrontEnd.peselL4.setDisable(true);
        		FrontEnd.adressL4.setDisable(true);
        		FrontEnd.phone_numberL4.setDisable(true);
        		FrontEnd.emailL4.setDisable(true);
        		FrontEnd.deleteButton4.setDisable(true);
        		FrontEnd.changeUserButton4.setDisable(true);
        		

                
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Uwaga");
    			alert.setHeaderText(null);
    			alert.setContentText("Musisz wpisać poprawny ID klienta! ");

    			alert.showAndWait();
        		}
   
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                
            	FrontEnd.idL4.setDisable(false);
            	FrontEnd.idTF4.setDisable(false);
            	FrontEnd.searchButton4.setDisable(false);
        		FrontEnd.firstnameTF4.clear();
        		FrontEnd.lastnameTF4.clear();  		
        		FrontEnd.peselTF4.clear();   		
        		FrontEnd.adressTF4.clear(); 		
        		FrontEnd.phone_numberTF4.clear();
        		FrontEnd.emailTF4.clear();
                
        		FrontEnd.firstnameTF4.setDisable(true);
        		FrontEnd.lastnameTF4.setDisable(true);   		
        		FrontEnd.peselTF4.setDisable(true);   		
        		FrontEnd.adressTF4.setDisable(true);  		
        		FrontEnd.phone_numberTF4.setDisable(true);
        		FrontEnd.emailTF4.setDisable(true);
        		FrontEnd.firstnameL4.setDisable(true);
        		FrontEnd.lastnameL4.setDisable(true);
        		FrontEnd.peselL4.setDisable(true);
        		FrontEnd.adressL4.setDisable(true);
        		FrontEnd.phone_numberL4.setDisable(true);
        		FrontEnd.emailL4.setDisable(true);
        		FrontEnd.deleteButton4.setDisable(true);
        		FrontEnd.changeUserButton4.setDisable(true);
        		

                
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Uwaga");
    			alert.setHeaderText(null);
    			alert.setContentText("Musisz wpisać poprawny ID klienta! ");

    			alert.showAndWait();
            }     	
	}
	
	public void changeUserDeleting(){
 	
        	FrontEnd.idL4.setDisable(false);
        	FrontEnd.idTF4.setDisable(false);
        	FrontEnd.searchButton4.setDisable(false);
        	
        	FrontEnd.idTF4.clear();
    		FrontEnd.firstnameTF4.clear();
    		FrontEnd.lastnameTF4.clear();  		
    		FrontEnd.peselTF4.clear();   		
    		FrontEnd.adressTF4.clear(); 		
    		FrontEnd.phone_numberTF4.clear();
    		FrontEnd.emailTF4.clear();
 	
    		FrontEnd.firstnameTF4.setDisable(true);
    		FrontEnd.lastnameTF4.setDisable(true);   		
    		FrontEnd.peselTF4.setDisable(true);   		
    		FrontEnd.adressTF4.setDisable(true);  		
    		FrontEnd.phone_numberTF4.setDisable(true);
    		FrontEnd.emailTF4.setDisable(true);
    		FrontEnd.firstnameL4.setDisable(true);
    		FrontEnd.lastnameL4.setDisable(true);
    		FrontEnd.peselL4.setDisable(true);
    		FrontEnd.adressL4.setDisable(true);
    		FrontEnd.phone_numberL4.setDisable(true);
    		FrontEnd.emailL4.setDisable(true);
    		FrontEnd.deleteButton4.setDisable(true);
    		FrontEnd.changeUserButton4.setDisable(true);      
          
	}
	
	public void finalDeleting(){
		
		String sql ="DELETE FROM klient WHERE id_klienta='"+FrontEnd.idTF4.getText()+"';";
		
        try {
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	stmt.executeUpdate(sql);
           
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
        
    	if(FrontEnd.idTF4.getText().equals("")){
    		
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Uwaga");
    		alert.setHeaderText(null);
    		alert.setContentText("Musisz wpisać poprawny ID klienta!");

    		alert.showAndWait();
    		
    	}else{
        
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText(null);
		alert.setContentText("Pomyślnie usunąłeś klienta.");

		alert.showAndWait();
    	}
		
        FrontEnd.idTF4.clear();
		FrontEnd.firstnameTF4.clear();
		FrontEnd.lastnameTF4.clear();  		
		FrontEnd.peselTF4.clear();   		
		FrontEnd.adressTF4.clear(); 		
		FrontEnd.phone_numberTF4.clear();
		FrontEnd.emailTF4.clear();
        
		FrontEnd.idL4.setDisable(false);
		FrontEnd.idTF4.setDisable(false);
		FrontEnd.searchButton4.setDisable(false);
		
		FrontEnd.firstnameTF4.setDisable(true);
		FrontEnd.lastnameTF4.setDisable(true);   		
		FrontEnd.peselTF4.setDisable(true);   		
		FrontEnd.adressTF4.setDisable(true);  		
		FrontEnd.phone_numberTF4.setDisable(true);
		FrontEnd.emailTF4.setDisable(true);
		FrontEnd.firstnameL4.setDisable(true);
		FrontEnd.lastnameL4.setDisable(true);
		FrontEnd.peselL4.setDisable(true);
		FrontEnd.adressL4.setDisable(true);
		FrontEnd.phone_numberL4.setDisable(true);
		FrontEnd.emailL4.setDisable(true);
		FrontEnd.deleteButton4.setDisable(true);
		FrontEnd.changeUserButton4.setDisable(true);
	}
	
	
//Navigation User.Show_all_users --------------------------------------------------------------------------------------------------------------------	
    public void showAllUsers(){
        String sql = "SELECT * FROM klient;";
        
        try (Connection conn = this.connectionWithDatabase();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        	FrontEnd.usersData.clear();
        	
            while (rs.next()) {
            	FrontEnd.usersData.add(new User( String.valueOf(rs.getString("id_klienta")), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("pesel"), rs.getString("adres"), rs.getString("telefon"), rs.getString("email") ));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    
    
//Movies *
    
//Navigation Movies.Add_movie --------------------------------------------------------------------------------------------------------------------
	public void dodajFilm(){

	String sql = "INSERT INTO Film (title,zanr,opis,rok,jezyk,ocena_imdb,czas_trwania,obsada) VALUES('"+FrontEnd.movieTitleTF.getText()+"','"+FrontEnd.genreTF.getText()+"','"+FrontEnd.descriptionTF.getText()+"','"+FrontEnd.release_yearTF.getText()+"','"+FrontEnd.languageTF.getText()+"',"+FrontEnd.rating_imdbTF.getText()+",'"+FrontEnd.duration_minutesTF.getText()+"','"+FrontEnd.main_actorsTF.getText()+"')";
     
        
		if( FrontEnd.movieTitleTF.getText().equals("") || FrontEnd.genreTF.getText().equals("") || FrontEnd.release_yearTF.getText().equals("") || FrontEnd.rating_imdbTF.getText().equals("") || FrontEnd.duration_minutesTF.getText().equals("") ){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uwaga");
			alert.setHeaderText(null);
			alert.setContentText("Musisz wypełnić wszystkie pola z * ");

			alert.showAndWait();
		}
		else{	
			
	        try {
	                Connection conn = this.connectionWithDatabase();
	                Statement stmt  = conn.createStatement();
	            	stmt.executeUpdate(sql);   
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Uwaga");
		alert.setHeaderText(null);
		alert.setContentText("Pomyślnie dodałeś nowy film.");
		alert.showAndWait();
		
		FrontEnd.movieTitleTF.clear();
		FrontEnd.genreTF.clear();
		FrontEnd.descriptionTF.clear();
		FrontEnd.release_yearTF.clear();
		FrontEnd.languageTF.clear();
		FrontEnd.rating_imdbTF.clear();
		FrontEnd.duration_minutesTF.clear();
		FrontEnd.main_actorsTF.clear();
		}		
	}
	

//Navigation Movies.Find_movie --------------------------------------------------------------------------------------------------------------------	
	public void checkAllSearchFields(){
		
		if(FrontEnd.find_idCB.isSelected()==true){
			FrontEnd.find_idTF.setDisable(false);
		}else{
			FrontEnd.find_idTF.clear();
			FrontEnd.find_idTF.setDisable(true);
		}
		
		if(FrontEnd.find_titleCB.isSelected()==true){
			FrontEnd.find_titleTF.setDisable(false);
		}else{
			FrontEnd.find_titleTF.setDisable(true);
			FrontEnd.find_titleTF.clear();
		}
		
		if(FrontEnd.find_genreCB.isSelected()==true){
			FrontEnd.find_genreTF.setDisable(false);
		}else{
			FrontEnd.find_genreTF.setDisable(true);
			FrontEnd.find_genreTF.clear();
		}
		
		if(FrontEnd.find_release_yearCB.isSelected()==true){
			FrontEnd.find_release_yearTF.setDisable(false);
		}else{
			FrontEnd.find_release_yearTF.setDisable(true);
			FrontEnd.find_release_yearTF.clear();
		}
		
		if(FrontEnd.find_main_actorCB.isSelected()==true){
			FrontEnd.find_main_actorTF.setDisable(false);
		}else{
			FrontEnd.find_main_actorTF.setDisable(true);
			FrontEnd.find_main_actorTF.clear();
		}
			
	}
	
	
	public void findMovie(){


		if( FrontEnd.find_idTF.getText().equals("") && FrontEnd.find_titleTF.getText().equals("") && FrontEnd.find_genreTF.getText().equals("") && FrontEnd.find_release_yearTF.getText().equals("") && FrontEnd.find_main_actorTF.getText().equals("") ){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uwaga");
			alert.setHeaderText(null);
			alert.setContentText("Musisz wypełnić chociażby jedno pole!");

			alert.showAndWait();
		}
		else{	
			
			String sql = "SELECT * FROM Film WHERE ";
			if(FrontEnd.find_idCB.isSelected()==true){
				sql = sql + "id="+FrontEnd.find_idTF.getText()+" AND ";
			}
			if(FrontEnd.find_titleCB.isSelected()==true){
				sql = sql +"title LIKE '%"+FrontEnd.find_titleTF.getText()+"%'"+" AND ";
			}
			if(FrontEnd.find_genreCB.isSelected()==true){
				sql = sql +"zanr LIKE '%"+FrontEnd.find_genreTF.getText()+"%'"+" AND ";
			}
			if(FrontEnd.find_release_yearCB.isSelected()==true){
				sql = sql +"rok="+FrontEnd.find_release_yearTF.getText()+" AND ";
			}
			if(FrontEnd.find_main_actorCB.isSelected()==true){
				sql = sql +"obsada LIKE '%"+FrontEnd.find_main_actorTF.getText()+"%'"+" AND ";
			}
			
			
			String sql2 = sql.substring(0, sql.length()-4);
			
	        try (
	                Connection conn = this.connectionWithDatabase();
	                Statement stmt  = conn.createStatement();
	            	ResultSet rs = stmt.executeQuery(sql2);
	                ){
	        	
	        	FrontEnd.movieData2.clear();
	        	
	            while (rs.next()) {

	            	FrontEnd.movieData2.add(new Movie( String.valueOf(rs.getInt("id")), rs.getString("title"), rs.getString("zanr"), rs.getString("opis"), String.valueOf(rs.getInt("rok")), rs.getString("jezyk"), String.valueOf(rs.getDouble("ocena_imdb")), rs.getString("czas_trwania"), rs.getString("obsada"), rs.getString("dost"), String.valueOf(rs.getInt("ostatni_wyn")), rs.getString("ostatnia_data_wyn")  ));

	            }
	                
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
		

		}		
	}
	
	
//Navigation Movies.Edit/Delete_movie --------------------------------------------------------------------------------------------------------------------	
	public void allowMovieEdit(){
		
		String sql ="SELECT * FROM Film WHERE id="+FrontEnd.edit_idTF2.getText()+";";
		
        try (
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
                ){
        	
        	if(rs.next()==true){
        	FrontEnd.edit_idL2.setDisable(true);
        	FrontEnd.edit_idTF2.setDisable(true);
        	FrontEnd.edit_searchButton2.setDisable(true);
 	
    		FrontEnd.movieTitleL2.setDisable(false);
    		FrontEnd.movieTitleTF2.setDisable(false);   		
    		FrontEnd.genreL2.setDisable(false);   		
    		FrontEnd.genreTF2.setDisable(false);  		
    		FrontEnd.descriptionL2.setDisable(false);
    		FrontEnd.descriptionTF2.setDisable(false);
    		FrontEnd.release_yearL2.setDisable(false);
    		FrontEnd.release_yearTF2.setDisable(false);
    		FrontEnd.languageL2.setDisable(false);
    		FrontEnd.languageTF2.setDisable(false);
    		FrontEnd.rating_imdbL2.setDisable(false);
    		FrontEnd.rating_imdbTF2.setDisable(false);
    		FrontEnd.duration_minutesL2.setDisable(false);
    		FrontEnd.duration_minutesTF2.setDisable(false);
    		FrontEnd.main_actorsL2.setDisable(false);
    		FrontEnd.main_actorsTF2.setDisable(false);
    		FrontEnd.edit_deleteButton.setDisable(false);
    		

        	FrontEnd.movieTitleTF2.setText(rs.getString("title"));
        	FrontEnd.genreTF2.setText(rs.getString("zanr"));
        	FrontEnd.descriptionTF2.setText(rs.getString("opis"));
        	FrontEnd.release_yearTF2.setText(rs.getString("rok"));
        	FrontEnd.languageTF2.setText(rs.getString("jezyk"));
        	FrontEnd.rating_imdbTF2.setText(String.valueOf(rs.getDouble("ocena_imdb")));
        	FrontEnd.duration_minutesTF2.setText(rs.getString("czas_trwania"));
        	FrontEnd.main_actorsTF2.setText(rs.getString("obsada"));
        	
        	FrontEnd.edit_change_movieButton.setDisable(false);
        	FrontEnd.edit_fDugme2.setDisable(false);
        	}
        	else{
            	FrontEnd.edit_idL2.setDisable(false);
            	FrontEnd.edit_idTF2.setDisable(false);
            	FrontEnd.edit_searchButton2.setDisable(false);
            	
        		FrontEnd.movieTitleTF2.clear();   		  		
        		FrontEnd.genreTF2.clear();  		
        		FrontEnd.descriptionTF2.clear();
        		FrontEnd.release_yearTF2.clear();
        		FrontEnd.languageTF2.clear();
        		FrontEnd.rating_imdbTF2.clear();
        		FrontEnd.duration_minutesTF2.clear();
        		FrontEnd.main_actorsTF2.clear();
                
        		FrontEnd.movieTitleL2.setDisable(true);
        		FrontEnd.movieTitleTF2.setDisable(true);   		
        		FrontEnd.genreL2.setDisable(true);   		
        		FrontEnd.genreTF2.setDisable(true);  		
        		FrontEnd.descriptionL2.setDisable(true);
        		FrontEnd.descriptionTF2.setDisable(true);
        		FrontEnd.release_yearL2.setDisable(true);
        		FrontEnd.release_yearTF2.setDisable(true);
        		FrontEnd.languageL2.setDisable(true);
        		FrontEnd.languageTF2.setDisable(true);
        		FrontEnd.rating_imdbL2.setDisable(true);
        		FrontEnd.rating_imdbTF2.setDisable(true);
        		FrontEnd.duration_minutesL2.setDisable(true);
        		FrontEnd.duration_minutesTF2.setDisable(true);
        		FrontEnd.main_actorsL2.setDisable(true);
        		FrontEnd.main_actorsTF2.setDisable(true);
        		FrontEnd.edit_deleteButton.setDisable(true);
        		

                
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Uwaga");
    			alert.setHeaderText(null);
    			alert.setContentText("Film o takim ID nie istnieje! ");

    			alert.showAndWait();
        	}
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
		
            	FrontEnd.edit_idL2.setDisable(false);
            	FrontEnd.edit_idTF2.setDisable(false);
            	FrontEnd.edit_searchButton2.setDisable(false);
            	
        		FrontEnd.movieTitleTF2.clear();   		  		
        		FrontEnd.genreTF2.clear();  		
        		FrontEnd.descriptionTF2.clear();
        		FrontEnd.release_yearTF2.clear();
        		FrontEnd.languageTF2.clear();
        		FrontEnd.rating_imdbTF2.clear();
        		FrontEnd.duration_minutesTF2.clear();
        		FrontEnd.main_actorsTF2.clear();
                
        		FrontEnd.movieTitleL2.setDisable(true);
        		FrontEnd.movieTitleTF2.setDisable(true);   		
        		FrontEnd.genreL2.setDisable(true);   		
        		FrontEnd.genreTF2.setDisable(true);  		
        		FrontEnd.descriptionL2.setDisable(true);
        		FrontEnd.descriptionTF2.setDisable(true);
        		FrontEnd.release_yearL2.setDisable(true);
        		FrontEnd.release_yearTF2.setDisable(true);
        		FrontEnd.languageL2.setDisable(true);
        		FrontEnd.languageTF2.setDisable(true);
        		FrontEnd.rating_imdbL2.setDisable(true);
        		FrontEnd.rating_imdbTF2.setDisable(true);
        		FrontEnd.duration_minutesL2.setDisable(true);
        		FrontEnd.duration_minutesTF2.setDisable(true);
        		FrontEnd.main_actorsL2.setDisable(true);
        		FrontEnd.main_actorsTF2.setDisable(true);
        		FrontEnd.edit_deleteButton.setDisable(true);
        		

                
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Uwaga");
    			alert.setHeaderText(null);
    			alert.setContentText("Film o takim ID nie istnieje! ");

    			alert.showAndWait();
            }
		
	}
	
	public void change_movie_EditingMovie(){
		
    	FrontEnd.edit_idL2.setDisable(false);
    	FrontEnd.edit_idTF2.setDisable(false);
    	FrontEnd.edit_searchButton2.setDisable(false);
    	
    	FrontEnd.edit_idTF2.clear();
		FrontEnd.movieTitleTF2.clear();   		  		
		FrontEnd.genreTF2.clear();  		
		FrontEnd.descriptionTF2.clear();
		FrontEnd.release_yearTF2.clear();
		FrontEnd.languageTF2.clear();
		FrontEnd.rating_imdbTF2.clear();
		FrontEnd.duration_minutesTF2.clear();
		FrontEnd.main_actorsTF2.clear();
        
		FrontEnd.movieTitleL2.setDisable(true);
		FrontEnd.movieTitleTF2.setDisable(true);   		
		FrontEnd.genreL2.setDisable(true);   		
		FrontEnd.genreTF2.setDisable(true);  		
		FrontEnd.descriptionL2.setDisable(true);
		FrontEnd.descriptionTF2.setDisable(true);
		FrontEnd.release_yearL2.setDisable(true);
		FrontEnd.release_yearTF2.setDisable(true);
		FrontEnd.languageL2.setDisable(true);
		FrontEnd.languageTF2.setDisable(true);
		FrontEnd.rating_imdbL2.setDisable(true);
		FrontEnd.rating_imdbTF2.setDisable(true);
		FrontEnd.duration_minutesL2.setDisable(true);
		FrontEnd.duration_minutesTF2.setDisable(true);
		FrontEnd.main_actorsL2.setDisable(true);
		FrontEnd.main_actorsTF2.setDisable(true);
		FrontEnd.edit_change_movieButton.setDisable(true);
		FrontEnd.edit_fDugme2.setDisable(true);
		FrontEnd.edit_deleteButton.setDisable(true);
		
	}
	
	public void finalEditMovie(){
		
		String sql = "UPDATE Film SET title='"+FrontEnd.movieTitleTF2.getText()+"',zanr='"+FrontEnd.genreTF2.getText()+"',opis='"+FrontEnd.descriptionTF2.getText()+"',rok="+FrontEnd.release_yearTF2.getText()+",jezyk='"+FrontEnd.languageTF2.getText()+"',ocena_imdb="+FrontEnd.rating_imdbTF2.getText()+",czas_trwania="+FrontEnd.duration_minutesTF2.getText()+",obsada='"+FrontEnd.main_actorsTF2.getText()+"' WHERE id="+FrontEnd.edit_idTF2.getText()+";";

		if( FrontEnd.movieTitleTF2.getText().equals("") || FrontEnd.genreTF2.getText().equals("") || FrontEnd.release_yearTF2.getText().equals("") || FrontEnd.rating_imdbTF2.getText().equals("") || FrontEnd.duration_minutesTF2.equals("") ){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uwaga");
			alert.setHeaderText(null);
			alert.setContentText("Musisz wypełnić wszystkie pola z * ");

			alert.showAndWait();
		}
		else{
		
		
        try {
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	stmt.executeUpdate(sql);
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Uwaga");
		alert.setHeaderText(null);
		alert.setContentText("Pomyślnie edytowałeś wybrany film");
		alert.showAndWait();
		
    	FrontEnd.edit_idL2.setDisable(false);
    	FrontEnd.edit_idTF2.setDisable(false);
    	FrontEnd.edit_searchButton2.setDisable(false);
    	
    	FrontEnd.edit_idTF2.clear();
		FrontEnd.movieTitleTF2.clear();   		  		
		FrontEnd.genreTF2.clear();  		
		FrontEnd.descriptionTF2.clear();
		FrontEnd.release_yearTF2.clear();
		FrontEnd.languageTF2.clear();
		FrontEnd.rating_imdbTF2.clear();
		FrontEnd.duration_minutesTF2.clear();
		FrontEnd.main_actorsTF2.clear();
        
		FrontEnd.movieTitleL2.setDisable(true);
		FrontEnd.movieTitleTF2.setDisable(true);   		
		FrontEnd.genreL2.setDisable(true);   		
		FrontEnd.genreTF2.setDisable(true);  		
		FrontEnd.descriptionL2.setDisable(true);
		FrontEnd.descriptionTF2.setDisable(true);
		FrontEnd.release_yearL2.setDisable(true);
		FrontEnd.release_yearTF2.setDisable(true);
		FrontEnd.languageL2.setDisable(true);
		FrontEnd.languageTF2.setDisable(true);
		FrontEnd.rating_imdbL2.setDisable(true);
		FrontEnd.rating_imdbTF2.setDisable(true);
		FrontEnd.duration_minutesL2.setDisable(true);
		FrontEnd.duration_minutesTF2.setDisable(true);
		FrontEnd.main_actorsL2.setDisable(true);
		FrontEnd.main_actorsTF2.setDisable(true);
		FrontEnd.edit_change_movieButton.setDisable(true);
		FrontEnd.edit_fDugme2.setDisable(true);
		FrontEnd.edit_deleteButton.setDisable(true);
		
		}
		
	}
	
	public void deleteMovie(){
		
		String sql = "DELETE FROM Film WHERE id="+FrontEnd.edit_idTF2.getText()+";";


        try {
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	stmt.executeUpdate(sql);
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Uwaga");
		alert.setHeaderText(null);
		alert.setContentText("Pomyślnie usunąłeś wybrany film");
		alert.showAndWait();
		
    	FrontEnd.edit_idL2.setDisable(false);
    	FrontEnd.edit_idTF2.setDisable(false);
    	FrontEnd.edit_searchButton2.setDisable(false);
    	
    	FrontEnd.edit_idTF2.clear();
		FrontEnd.movieTitleTF2.clear();   		  		
		FrontEnd.genreTF2.clear();  		
		FrontEnd.descriptionTF2.clear();
		FrontEnd.release_yearTF2.clear();
		FrontEnd.languageTF2.clear();
		FrontEnd.rating_imdbTF2.clear();
		FrontEnd.duration_minutesTF2.clear();
		FrontEnd.main_actorsTF2.clear();
        
		FrontEnd.movieTitleL2.setDisable(true);
		FrontEnd.movieTitleTF2.setDisable(true);   		
		FrontEnd.genreL2.setDisable(true);   		
		FrontEnd.genreTF2.setDisable(true);  		
		FrontEnd.descriptionL2.setDisable(true);
		FrontEnd.descriptionTF2.setDisable(true);
		FrontEnd.release_yearL2.setDisable(true);
		FrontEnd.release_yearTF2.setDisable(true);
		FrontEnd.languageL2.setDisable(true);
		FrontEnd.languageTF2.setDisable(true);
		FrontEnd.rating_imdbL2.setDisable(true);
		FrontEnd.rating_imdbTF2.setDisable(true);
		FrontEnd.duration_minutesL2.setDisable(true);
		FrontEnd.duration_minutesTF2.setDisable(true);
		FrontEnd.main_actorsL2.setDisable(true);
		FrontEnd.main_actorsTF2.setDisable(true);
		FrontEnd.edit_change_movieButton.setDisable(true);
		FrontEnd.edit_fDugme2.setDisable(true);
		FrontEnd.edit_deleteButton.setDisable(true);
		
		
	}
	
	
//Navigation Movies.Show_all_movies -----------------------------------------------------------------------------------------------------------------------	
	public void show_all_movies(){
		
		String sql = "SELECT * FROM Film;";
		
        try (
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
                ){
        	
        	FrontEnd.movieData3.clear();
        	
            while (rs.next()) {

            	FrontEnd.movieData3.add(new Movie( String.valueOf(rs.getInt("id")), rs.getString("title"), rs.getString("zanr"), rs.getString("opis"), rs.getString("rok"), rs.getString("jezyk"), String.valueOf(rs.getDouble("ocena_imdb")), rs.getString("czas_trwania"), rs.getString("obsada"), rs.getString("dost"), rs.getString("ostatni_wyn"), rs.getString("ostatnia_data_wyn")  ));

            }
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
		
	}
	
		
//Navigation Rental.Rental_movie --------------------------------------------------------------------------------------------------------------------
	public boolean check_is_movie_availbale(){
		
		String sql = "SELECT * FROM Film WHERE id=" +FrontEnd.rentalMovie_id_movieTF.getText() +";";
		boolean rezultat = false;
		
		try {
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
            	
            	while(rs.next()){
            		if(rs.getString("rezerwacja").equals("tak")){
            			rezultat = true;
            		}
            	}
        }  catch (SQLException c) {
            System.out.println(c.getMessage());  
        }
		
		
		return rezultat;
	}
	
	public boolean checkIfPersonWhoReservedTheMovieTakeThatMovie(){
		
		String sql = "SELECT * FROM Film WHERE id=" +FrontEnd.rentalMovie_id_movieTF.getText() +";";
		boolean rezultat = false;
		
		try {
            Connection conn = this.connectionWithDatabase();
            Statement stmt  = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
        	
        	while(rs.next()){
        		if(FrontEnd.rentalMovie_id_userTF.getText().equals(rs.getString("rezerwacja_id"))){
        			rezultat = true;
        		}
        	}
    }  catch (SQLException c) {
        System.out.println(c.getMessage());  
    }
		
		return rezultat;
	}
	
	
	
	public void finalRentalMovie(){

			String formatDatuma = "dd MM yyyy";
			String datumIznajmljivanja =new SimpleDateFormat(formatDatuma).format(new Date());
			
			
			String sql1 = "SELECT id FROM Film;";
			
			String sql2 = "SELECT dost FROM Film WHERE id="+FrontEnd.rentalMovie_id_movieTF.getText()+";";
			
			String sql3 = "UPDATE Film SET dost='nie', rezerwacja='nie', ostatni_wyn='"+FrontEnd.rentalMovie_id_userTF.getText() + "', ostatnia_data_wyn='"+ datumIznajmljivanja + "' WHERE id="+FrontEnd.rentalMovie_id_movieTF.getText()+";";
			
			String sql4 = "SELECT id_klienta FROM klient;";
			
			String idFilm = "";
			String dost = "";
			String idklient = "";

			

			
			if(FrontEnd.rentalMovie_id_movieTF.getText().equals("") || FrontEnd.rentalMovie_id_userTF.getText().equals("") ){
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Uwaga");
				alert.setHeaderText(null);
				alert.setContentText("Musisz wypełnić wszystkie pola z * ");
				
				alert.showAndWait();
				
			}else{

		        		
		                try (
		                        Connection conn1 = this.connectionWithDatabase();
		                        Statement stmt1  = conn1.createStatement();
		                    	ResultSet rs1 = stmt1.executeQuery(sql1);
		                        ){
		                        
		                	while (rs1.next()) {
		                		String a = String.valueOf(rs1.getInt("id"));
		                		
		                		 if( a.equals(FrontEnd.rentalMovie_id_movieTF.getText() ) ){
		                			 
		                			 idFilm = a;
		                		 }
		
		        	}

		                }  catch (SQLException c) {
			                System.out.println(c.getMessage());
			                
			            }
		                
		                
		                
		                try (
		                        Connection conn4 = this.connectionWithDatabase();
		                        Statement stmt4  = conn4.createStatement();
		                    	ResultSet rs4 = stmt4.executeQuery(sql4);
		                        ){
		                        
		                	while (rs4.next()) {
		                		String a = String.valueOf(rs4.getString("id_klienta"));
		                		
		                		 if( a.equals(FrontEnd.rentalMovie_id_userTF.getText() ) ){
		                			 
		                			 idklient = a;
		                		 }
		
		        	}

		                }  catch (SQLException c) {
			                System.out.println(c.getMessage());
			                
			            }
		                
		                
		                
		                if(FrontEnd.rentalMovie_id_movieTF.getText().equals(idFilm) && FrontEnd.rentalMovie_id_userTF.getText().equals(idklient)){
		                	

	    			        try (   Connection conn2 = this.connectionWithDatabase();
	    			                Statement stmt2  = conn2.createStatement();
	    			            	ResultSet rs2 = stmt2.executeQuery(sql2);
	    			                ){
	    			        	
	    			        while(rs2.next()){
		    			        	if(rs2.getString("dost").equals("tak")){
		    			        		dost = "tak"; 			        		
		    			        	}else{
		    			        		
		    			    			Alert alert = new Alert(AlertType.WARNING);
		    			    			alert.setTitle("Uwaga");
		    			    			alert.setHeaderText(null);
		    			    			alert.setContentText("Ten film już jest wypożyczony!");
		    			    			
		    			    			alert.showAndWait();
		    			    			
		    			        		FrontEnd.rentalMovie_id_movieTF.clear();
		    			        		FrontEnd.rentalMovie_id_userTF.clear();
	    			        		
		    			        		}
	    			        	}

	    		            } catch (SQLException e) {
	    		                System.out.println(e.getMessage());
	    		                
	    		            }
	    			 
	    		 }else{
		    			Alert alert = new Alert(AlertType.WARNING);
		    			alert.setTitle("Uwaga");
		    			alert.setHeaderText(null);
		    			alert.setContentText("Klient lub Film o takim ID nie istnieje !");
		    			
		    			alert.showAndWait();
		    			
		        		FrontEnd.rentalMovie_id_movieTF.clear();
		        		FrontEnd.rentalMovie_id_userTF.clear();	 
	    		 }
		                
		                
		                if(dost.equals("tak")){
		                	
		                	
		                	
		            		boolean zarezerwowany = false;
		            		
		            		boolean checkIsMovieAvailbale = this.check_is_movie_availbale();
		            		
		            		if(checkIsMovieAvailbale==true){
		            			boolean czyWypozyczony = this.checkIfPersonWhoReservedTheMovieTakeThatMovie();
		            			
		            			if(czyWypozyczony==false){
		            				Alert alert = new Alert(AlertType.WARNING);
		            				alert.setTitle("Uwaga");
		            				alert.setHeaderText(null);
		            				alert.setContentText("Nie możesz wypożyczyć tego filmu.");
		            				
		            				alert.showAndWait();
		            				
	        		        		FrontEnd.rentalMovie_id_movieTF.clear();
	        		        		FrontEnd.rentalMovie_id_userTF.clear();
		            			}else{
		            				zarezerwowany = true;
		            			}
		            		}else{
		            			zarezerwowany = true;
		            		}
		            		
		            		if(zarezerwowany==true){
		        		        try {
	        		                Connection conn3 = this.connectionWithDatabase();
	        		                Statement stmt3  = conn3.createStatement();
	        		            	stmt3.executeUpdate(sql3);      	
	        		        }
	        		        catch(SQLException e){
	        		        	System.out.println(e.getMessage());
	        		        };
	        		        
	    	        		Alert alert = new Alert(AlertType.INFORMATION);
	        		        		alert.setTitle("Uwaga");
	        		        		alert.setHeaderText(null);
	        		        		alert.setContentText("Pomyślnie wypożyczyłeś film ");
	        		        		
	        		        		alert.showAndWait();
	        		        		
	        		        		FrontEnd.rentalMovie_id_movieTF.clear();
	        		        		FrontEnd.rentalMovie_id_userTF.clear();
		            		}

		                }

			}

	
	}
	
	
	
//Navigation Rental.Return_back_movie --------------------------------------------------------------------------------------------------------------------	
	public void returnBackMovie() throws ParseException{
		
		String sql = "UPDATE Film SET dost= 'tak' WHERE id="+FrontEnd.returnBackMovie_idMovieTF.getText()+";";
		
		String sql2 = "SELECT id FROM Film;";
		
		String sql3 = "SELECT dost FROM Film WHERE id="+FrontEnd.returnBackMovie_idMovieTF.getText()+";";
		
		String sql4 = "SELECT ostatnia_data_wyn FROM Film WHERE id="+FrontEnd.returnBackMovie_idMovieTF.getText()+";";
		
		String movieID = "";
		String availbale = "";
    	String dateOfRentalDatabase = null;
    	int days = 0;
		
		
		if(FrontEnd.returnBackMovie_idMovieTF.getText().equals("") ){
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Uwaga");
			alert.setHeaderText(null);
			alert.setContentText("Musisz wypełnić wszystkie pola z * ");
			
			alert.showAndWait();
			
		}else{
			
			
			
			
			
			
	        try (
                    Connection conn2 = this.connectionWithDatabase();
                    Statement stmt2  = conn2.createStatement();
                	ResultSet rs2 = stmt2.executeQuery(sql2);
                    ){
                    
            	while (rs2.next()) {
            		String a = String.valueOf(rs2.getInt("id"));
            		
            		 if( a.equals(FrontEnd.returnBackMovie_idMovieTF.getText() ) ){
            			 
            			 movieID = a;
            		 }

    	}

            }  catch (SQLException c) {
                System.out.println(c.getMessage());
                
            }
			
			
			
	        
	        if(FrontEnd.returnBackMovie_idMovieTF.getText().equals(movieID)){
	        	
		        try (
	                    Connection conn3 = this.connectionWithDatabase();
	                    Statement stmt3  = conn3.createStatement();
	                	ResultSet rs3 = stmt3.executeQuery(sql3);
	                    ){
		        			String a="";
		        			
		        			while(rs3.next()){
		        			a = rs3.getString("dost");
		        			}
	            		 
	            		 if( a.equals("nie") ){
	            			 
	            			 availbale = "tak";
	            			 
	            			 
	            		 }else{
	            				Alert alert = new Alert(AlertType.WARNING);
	            				alert.setTitle("Uwaga");
	            				alert.setHeaderText(null);
	            				alert.setContentText("Ten film już jest zwrócony! ");
	            				
	            				alert.showAndWait();
	            				
	            				FrontEnd.returnBackMovie_idMovieTF.clear();
	            		 }

	    	

	            }  catch (SQLException c) {
	                System.out.println(c.getMessage());
	                
	            }
	        	
	        }else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Uwaga");
				alert.setHeaderText(null);
				alert.setContentText("Wpisałeś niepoprawny ID filmu! ");
				
				alert.showAndWait();
	        }
			
		}
		
		if(availbale.equals("nie")){
			
			
	        try (
	                Connection conn = this.connectionWithDatabase();
	                Statement stmt  = conn.createStatement();
	            	ResultSet rs = stmt.executeQuery(sql4);
	                ){
	        
	     //Check is movie returned on time,if movie is not returned on time then calculating how much days is overdated them calculate how much money user must pay for overdate   	
	        	while(rs.next()){
	        	dateOfRentalDatabase = rs.getString("ostatnia_data_wyn");
	        	}
	        	
		    	SimpleDateFormat formatDatuma = new SimpleDateFormat("dd MM yyyy");

		        Date datumIznajmljivanja = formatDatuma.parse(dateOfRentalDatabase);
		        Date datumVracanja = new java.util.Date();
		        
		        long razlika = datumVracanja.getTime() - datumIznajmljivanja.getTime();
		        days = (int) TimeUnit.DAYS.convert(razlika, TimeUnit.MILLISECONDS);
	        	
	                
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
	        
	        if(days==0 || days==1 || days==2 || days==3 || days==4 || days==5){
	        	
	        }else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Uwaga");
				alert.setHeaderText(null);
				int exceededDays = days-5;
				double exceededMoney = exceededDays * 5;
				alert.setContentText("Przekroczyłeś 5 dozwolonych dni na wypożyczenie.\nFilm był wypożyczony "+dateOfRentalDatabase+" .\n"+"Musisz zapłacić za "+exceededDays+" przekroczonych dni "+exceededMoney + " złotych." );
				
				alert.showAndWait();	
	        }
	        
			
			

	        try {
	                Connection conn = this.connectionWithDatabase();
	                Statement stmt  = conn.createStatement();
	            	stmt.executeUpdate(sql);
	                
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	                
	            }
	        
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Uwaga");
			alert.setHeaderText(null);
			alert.setContentText("Pomyślnie zwróciłeś film!");
			
			alert.showAndWait();
			
			FrontEnd.returnBackMovie_idMovieTF.clear();
		}
	
	}
	
	
	
//Navigation Rental.List_of_rental_movies --------------------------------------------------------------------------------------------------------------------	
	public void showRentaledMovies(){
		
		String sql = "SELECT * FROM Film WHERE dost='nie';";
		
        try (
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
                ){
        	
        	FrontEnd.movieData4.clear();
        	
            while (rs.next()) {

            	FrontEnd.movieData4.add(new Movie( String.valueOf(rs.getInt("id")), rs.getString("title"), rs.getString("zanr"), rs.getString("opis"), String.valueOf(rs.getInt("rok")), rs.getString("jezyk"), String.valueOf(rs.getDouble("ocena_imdb")), rs.getString("czas_trwania"), rs.getString("obsada"), rs.getString("dost"), String.valueOf(rs.getString("ostatni_wyn")), rs.getString("ostatnia_data_wyn")  ));

            }
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
		
		
	}
		
	
	public String returnBackCurrentSecurityCode(){
		
		String sql = "SELECT kod FROM security WHERE id=1;";
		String securityCode=null;
		
        try (
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
                ){
        	while(rs.next()){
        	securityCode = rs.getString("kod");
        	}

            } catch (SQLException e) {
                System.out.println(e.getMessage());
		
        }
        return securityCode;
	}    
	
	
	
//Navigation Properties.Change_background --------------------------------------------------------------------------------------------------------------------	
	public void returnBackBackground(){
		
		String sql = "SELECT background FROM background WHERE id=1;";
		
        try (
                Connection conn = this.connectionWithDatabase();
                Statement stmt  = conn.createStatement();
            	ResultSet rs = stmt.executeQuery(sql);
                ){
        	
        	while(rs.next()){
        	FrontEnd.background = rs.getString("background");
        	}
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
		
        }
		
	}
	
	


}
