package system;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.text.ParseException;

import dao.Movie;
import dao.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class FrontEnd extends Application {
	
	//A lot of static objects is needed for the relationship between FrontEnd and BackEnd
	
	static BackEnd object_Back = new BackEnd();
	
	//Navigation Users.New_user
	static TextField firstnameTF;
	static TextField lastnameTF;
	static TextField peselTF;
	static TextField adressTF;
	static TextField phone_numberTF;
	static TextField emailTF;
	
	//Navigation User.Edit_user
	static Label idL2;
	static TextField idTF2;
	static Button searchButton2;
	static Label firstnameL2;
	static TextField firstnameTF2;
	static Label lastnameL2;
	static TextField lastnameTF2;
	static Label peselL2;
	static TextField peselTF2;
	static Label adressL2;
	static TextField adressTF2;
	static Label phone_numberL2;
	static TextField phone_numberTF2;
	static Label emailL2;
	static TextField emailTF2;
	static Button editButton2;
	static Button changeUserButton2;
	
	//Navigation Users.Show_user
	static TextField idTF3;
	static Label firstnameL3;
	static TextField firstnameTF3;
	static Label lastnameL3;
	static TextField lastnameTF3;
	static Label peselL3;
	static TextField peselTF3;
	static Label adressL3;
	static TextField adressTF3;
	static Label phone_numberL3;
	static TextField phone_numberTF3;
	static Label emailL3;
	static TextField emailTF3;
	
	//Navigation Users.Delete_user
	static Button searchButton4;
	static Label idL4;
	static TextField idTF4;
	static Label firstnameL4;
	static TextField firstnameTF4;
	static Label lastnameL4;
	static TextField lastnameTF4;
	static Label peselL4;
	static TextField peselTF4;
	static Label adressL4;
	static TextField adressTF4;
	static Label phone_numberL4;
	static TextField phone_numberTF4;
	static Label emailL4;
	static TextField emailTF4;
	static Button deleteButton4;
	static Button changeUserButton4;
	
	
	//Navigation Movies.Add_movie
	static TextField movieTitleTF;
	static TextField genreTF;
	static TextField descriptionTF;
	static TextField release_yearTF;
	static TextField languageTF;
	static TextField rating_imdbTF;
	static TextField duration_minutesTF;
	static TextField main_actorsTF ;
	
	//Navigation Movies.Find_movie
	static CheckBox find_idCB;
	static TextField find_idTF;
	static CheckBox find_titleCB;
	static TextField find_titleTF;
	static CheckBox find_genreCB;
	static TextField find_genreTF;
	static CheckBox find_release_yearCB;
	static TextField find_release_yearTF;
	static CheckBox find_main_actorCB;
	static TextField find_main_actorTF;
	
	//Navigatin Movies.Edit_movie
	static TextField movieTitleTF2;
	static TextField genreTF2;
	static TextField descriptionTF2;
	static TextField release_yearTF2;
	static TextField languageTF2;
	static TextField rating_imdbTF2;
	static TextField duration_minutesTF2;
	static TextField main_actorsTF2 ;
	static TextField edit_idTF2;
	static Label edit_idL2;
	static Label movieTitleL2;
	static Label genreL2;
	static Label descriptionL2;
	static Label release_yearL2;
	static Label languageL2;
	static Label rating_imdbL2;
	static Label duration_minutesL2;
	static Label main_actorsL2;
	static Button edit_searchButton2;
	static Button edit_fDugme2;
	static Button edit_change_movieButton;
	static Button edit_deleteButton;
	
	
	static TextField rentalMovie_id_movieTF;
	static TextField rentalMovie_id_userTF;
	
	static TextField returnBackMovie_idMovieTF;
	
	static PasswordField properties_currentPF;
	static PasswordField properties_newPW;
	static PasswordField properties_repeat_newPF;
	
	static String securityCode = object_Back.returnBackCurrentSecurityCode();
	static String background = "";

	
	
	private final TableView<User> usersTable = new TableView<>();
	static ObservableList<User> usersData = FXCollections.observableArrayList();

	private final TableView<Movie> movie_table2 = new TableView<>();
	static ObservableList<Movie> movieData2 = FXCollections.observableArrayList();
	
	private final TableView<Movie> movieTable3 = new TableView<>();
	static ObservableList<Movie> movieData3 = FXCollections.observableArrayList();
	
	private final TableView<Movie> movieTable4 = new TableView<>();
	static ObservableList<Movie> movieData4 = FXCollections.observableArrayList();

	static Stage startingStage = new Stage();
	static Scene security_codeScene;
	
	@Override
	public void start(Stage asd) throws Exception {
		
		object_Back.returnBackBackground();
		
		Image img = new Image("file:./Images/Backgrounds/"+background+".jpg");
		ImageView backgroundIW = new ImageView(img);
		
		
		try{
			

//MAIN navigation * --------------------------------------------------------------------------------------------------------------------
			Button usersButton = new Button("Klienci");
			usersButton.setMinSize(120, 35);
			Button moviesButton = new Button("Filmy");
			moviesButton.setMinSize(120, 35);
			Button rentalButton = new Button("Wypożyczone");
			rentalButton.setMinSize(120, 35);
			//Button propertiesButton = new Button("Properties",new ImageView(new Image("file:./Images/Icons/Properties/MAIN.png")));
			//propertiesButton.setMinSize(120, 35);
			Button informationsButton = new Button("Informacje");
			informationsButton.setMinSize(120, 35);
			Button logoutButton = new Button("Wyloguj");
			logoutButton.setMinSize(60, 35);
			
			
			HBox navigation_mainContainer = new HBox();
			navigation_mainContainer.getChildren().addAll(usersButton,moviesButton,rentalButton,informationsButton,logoutButton);
			//propertiesButton
			navigation_mainContainer.setSpacing(5);
			

			
//Navigation Users * --------------------------------------------------------------------------------------------------------------------
			Button new_userButton = new Button("Nowy klient       ");
			new_userButton.setMinSize(151, 30);
			Button edit_userButton = new Button("Edytuj klienta       ");
			edit_userButton.setMinSize(151, 30);
			Button show_userButton = new Button("Pokaż klienta     ");
			show_userButton.setMinSize(151, 30);
			Button delete_userButton = new Button("Usun klienta   ");
			delete_userButton.setMinSize(151, 30);
			Button show_all_usersButton = new Button("Pokaż wszystkich klientow");
			show_all_usersButton.setMinSize(151, 30);
			
			VBox navigation_usersContainer = new VBox();
			navigation_usersContainer.getChildren().addAll(new_userButton,show_userButton,edit_userButton,delete_userButton,show_all_usersButton);
			navigation_usersContainer.setSpacing(10);
			
//Navigation Users.New_user --------------------------------------------------------------------------------------------------------------------
			Label addUserL = new Label("Nowy klient");
			addUserL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			Label firstnameL = new Label("Imię*");
			firstnameTF = new TextField();
			firstnameL.setStyle("-fx-text-fill: white");
			
			Label lastnameL = new Label("Nazwisko*");
			lastnameL.setStyle("-fx-text-fill: white");
			lastnameTF = new TextField();
			
			Label peselL = new Label("Pesel*");
			peselL.setStyle("-fx-text-fill: white");
			peselTF = new TextField();
			
			Label adressL = new Label("Adres*");
			adressL.setStyle("-fx-text-fill: white");
			adressTF = new TextField();
			
			Label phone_numberL = new Label("Telefon*");
			phone_numberL.setStyle("-fx-text-fill: white");
			phone_numberTF = new TextField();
			
			Label emailL = new Label("Email");
			emailL.setStyle("-fx-text-fill: white");
			emailTF = new TextField();
			
			Button addButton = new Button("Dodaj");
			
			GridPane new_userContainer = new GridPane();
			new_userContainer.add(addUserL, 0, 0,2,1);
			new_userContainer.add(firstnameL, 0, 1);
			new_userContainer.add(firstnameTF, 1, 1);
			new_userContainer.add(lastnameL, 0, 2);
			new_userContainer.add(lastnameTF, 1, 2);
			new_userContainer.add(peselL, 0, 3);
			new_userContainer.add(peselTF, 1, 3);
			new_userContainer.add(adressL, 0, 4);
			new_userContainer.add(adressTF, 1, 4);
			new_userContainer.add(phone_numberL, 0, 5);
			new_userContainer.add(phone_numberTF, 1, 5);
			new_userContainer.add(emailL, 0, 6);
			new_userContainer.add(emailTF, 1, 6);
			new_userContainer.add(addButton, 1, 7);
			new_userContainer.setHgap(5);
			new_userContainer.setVgap(8);
			
		//Home page --------------------------------------------------------------------------------------------------------------------
			Label homeText = new Label("Witamy w systemie wypożyczalni filmów. Wybierz odpowiednią opcję");
			homeText.setStyle("-fx-font-size:21;-fx-text-fill: white");
			StackPane homeTextContainer = new StackPane(homeText);
			
			
			
		//Body Container -----------------------------------------------------------------------------------------------------------------
			HBox navigationBody = new HBox();
			navigationBody.getChildren().addAll(navigation_usersContainer,homeTextContainer);
			navigationBody.setSpacing(100);
			navigationBody.setPadding(new Insets(20,20,20,20));
			
//Navigation User.Edit_user --------------------------------------------------------------------------------------------------------------------
			Label editUserL2 = new Label("Edytuj klienta");
			editUserL2.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			idL2 = new Label("ID klienta*");
			idL2.setStyle("-fx-text-fill: white");
			idTF2 = new TextField();

			searchButton2 = new Button("Szukaj");
			
			firstnameL2 = new Label("Imię*");
			firstnameL2.setStyle("-fx-text-fill: white");
			firstnameL2.setDisable(true);
			firstnameTF2 = new TextField();
			firstnameTF2.setDisable(true);
			
			lastnameL2 = new Label("Nazwisko*");
			lastnameL2.setStyle("-fx-text-fill: white");
			lastnameL2.setDisable(true);
			lastnameTF2 = new TextField();
			lastnameTF2.setDisable(true);
			
			peselL2 = new Label("Pesel*");
			peselL2.setStyle("-fx-text-fill: white");
			peselL2.setDisable(true);
			peselTF2 = new TextField();
			peselTF2.setDisable(true);
			
			adressL2 = new Label("Adres*");
			adressL2.setStyle("-fx-text-fill: white");
			adressL2.setDisable(true);
			adressTF2 = new TextField();
			adressTF2.setDisable(true);
			
			phone_numberL2 = new Label("Telefon*");
			phone_numberL2.setStyle("-fx-text-fill: white");
			phone_numberL2.setDisable(true);
			phone_numberTF2 = new TextField();
			phone_numberTF2.setDisable(true);
			
			emailL2 = new Label("Email");
			emailL2.setStyle("-fx-text-fill: white");
			emailL2.setDisable(true);
			emailTF2 = new TextField();
			emailTF2.setDisable(true);
			
			editButton2 = new Button("Edytuj");
			editButton2.setDisable(true);
			
			changeUserButton2 = new Button("Zmień klienta");
			changeUserButton2.setDisable(true);
			
			
			GridPane edit_userContainer = new GridPane();
			edit_userContainer.add(editUserL2, 0, 0 ,2 ,1);
			edit_userContainer.add(idL2, 0, 1);
			edit_userContainer.add(idTF2, 1, 1);
			edit_userContainer.add(searchButton2, 2, 1);
			edit_userContainer.add(firstnameL2, 0, 2);
			edit_userContainer.add(firstnameTF2, 1, 2);
			edit_userContainer.add(lastnameL2, 0, 3);
			edit_userContainer.add(lastnameTF2, 1, 3);
			edit_userContainer.add(peselL2, 0, 4);
			edit_userContainer.add(peselTF2, 1, 4);
			edit_userContainer.add(adressL2, 0, 5);
			edit_userContainer.add(adressTF2, 1, 5);
			edit_userContainer.add(phone_numberL2, 0, 6);
			edit_userContainer.add(phone_numberTF2, 1, 6);
			edit_userContainer.add(emailL2, 0, 7);
			edit_userContainer.add(emailTF2, 1, 7);
			edit_userContainer.add(changeUserButton2, 0, 8);
			edit_userContainer.add(editButton2, 1, 8);
			edit_userContainer.setHgap(5);
			edit_userContainer.setVgap(8);
			
			
			
			
//Navigation Users.Show_user --------------------------------------------------------------------------------------------------------------------
			Label show_userL3 = new Label("Pokaż klienta");
			show_userL3.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			Label idL3 = new Label("ID klienta*");
			idL3.setStyle("-fx-text-fill: white");
			idTF3 = new TextField();

			Button searchButton3 = new Button("Szukaj");
			
			firstnameL3 = new Label("Imię*");
			firstnameL3.setStyle("-fx-text-fill: white");
			firstnameL3.setDisable(true);
			firstnameTF3 = new TextField();
			firstnameTF3.setDisable(true);
			firstnameTF3.setEditable(false);
			
			lastnameL3 = new Label("Nazwisko*");
			lastnameL3.setStyle("-fx-text-fill: white");
			lastnameL3.setDisable(true);
			lastnameTF3 = new TextField();
			lastnameTF3.setDisable(true);
			lastnameTF3.setEditable(false);
			
			peselL3 = new Label("Pesel*");
			peselL3.setStyle("-fx-text-fill: white");
			peselL3.setDisable(true);
			peselTF3 = new TextField();
			peselTF3.setDisable(true);
			peselTF3.setEditable(false);
			
			adressL3 = new Label("Adres*");
			adressL3.setStyle("-fx-text-fill: white");
			adressL3.setDisable(true);
			adressTF3 = new TextField();
			adressTF3.setDisable(true);
			adressTF3.setEditable(false);
			
			phone_numberL3 = new Label("Telefon*");
			phone_numberL3.setStyle("-fx-text-fill: white");
			phone_numberL3.setDisable(true);
			phone_numberTF3 = new TextField();
			phone_numberTF3.setDisable(true);
			phone_numberTF3.setEditable(false);
			
			emailL3 = new Label("Email");
			emailL3.setStyle("-fx-text-fill: white");
			emailL3.setDisable(true);
			emailTF3 = new TextField();
			emailTF3.setDisable(true);
			emailTF3.setEditable(false);
			
			
			GridPane show_userContainer = new GridPane();
			show_userContainer.add(show_userL3, 0, 0 ,2 ,1);
			show_userContainer.add(idL3, 0, 1);
			show_userContainer.add(idTF3, 1, 1);
			show_userContainer.add(searchButton3, 2, 1);
			show_userContainer.add(firstnameL3, 0, 2);
			show_userContainer.add(firstnameTF3, 1, 2);
			show_userContainer.add(lastnameL3, 0, 3);
			show_userContainer.add(lastnameTF3, 1, 3);
			show_userContainer.add(peselL3, 0, 4);
			show_userContainer.add(peselTF3, 1, 4);
			show_userContainer.add(adressL3, 0, 5);
			show_userContainer.add(adressTF3, 1, 5);
			show_userContainer.add(phone_numberL3, 0, 6);
			show_userContainer.add(phone_numberTF3, 1, 6);
			show_userContainer.add(emailL3, 0, 7);
			show_userContainer.add(emailTF3, 1, 7);
			show_userContainer.setHgap(5);
			show_userContainer.setVgap(8);
			
			
			
//Navigation Users.Delete_user --------------------------------------------------------------------------------------------------------------------
			Label delete_userL4 = new Label("Usuń klienta");
			delete_userL4.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			idL4 = new Label("ID klienta*");
			idL4.setStyle("-fx-text-fill: white");
			idTF4 = new TextField();

			searchButton4 = new Button("Szukaj");
			
			firstnameL4 = new Label("Imię*");
			firstnameL4.setStyle("-fx-text-fill: white");
			firstnameL4.setDisable(true);
			firstnameTF4 = new TextField();
			firstnameTF4.setDisable(true);
			firstnameTF4.setEditable(false);
			
			lastnameL4 = new Label("Nazwisko*");
			lastnameL4.setStyle("-fx-text-fill: white");
			lastnameL4.setDisable(true);
			lastnameTF4 = new TextField();
			lastnameTF4.setDisable(true);
			lastnameTF4.setEditable(false);
			
			peselL4 = new Label("Pesel*");
			peselL4.setStyle("-fx-text-fill: white");
			peselL4.setDisable(true);
			peselTF4 = new TextField();
			peselTF4.setDisable(true);
			peselTF4.setEditable(false);
			
			adressL4 = new Label("Adres*");
			adressL4.setStyle("-fx-text-fill: white");
			adressL4.setDisable(true);
			adressTF4 = new TextField();
			adressTF4.setDisable(true);
			adressTF4.setEditable(false);
			
			phone_numberL4 = new Label("Telefon*");
			phone_numberL4.setStyle("-fx-text-fill: white");
			phone_numberL4.setDisable(true);
			phone_numberTF4 = new TextField();
			phone_numberTF4.setDisable(true);
			phone_numberTF4.setEditable(false);
			
			emailL4 = new Label("Email");
			emailL4.setStyle("-fx-text-fill: white");
			emailL4.setDisable(true);
			emailTF4 = new TextField();
			emailTF4.setDisable(true);
			emailTF4.setEditable(false);
			
			deleteButton4 = new Button("Usuń");
			deleteButton4.setDisable(true);
			
			changeUserButton4 = new Button("Zmień klienta");
			changeUserButton4.setDisable(true);
			
			
			GridPane delete_userContainer = new GridPane();
			delete_userContainer.add(delete_userL4, 0, 0 ,2 ,1);
			delete_userContainer.add(idL4, 0, 1);
			delete_userContainer.add(idTF4, 1, 1);
			delete_userContainer.add(searchButton4, 2, 1);
			delete_userContainer.add(firstnameL4, 0, 2);
			delete_userContainer.add(firstnameTF4, 1, 2);
			delete_userContainer.add(lastnameL4, 0, 3);
			delete_userContainer.add(lastnameTF4, 1, 3);
			delete_userContainer.add(peselL4, 0, 4);
			delete_userContainer.add(peselTF4, 1, 4);
			delete_userContainer.add(adressL4, 0, 5);
			delete_userContainer.add(adressTF4, 1, 5);
			delete_userContainer.add(phone_numberL4, 0, 6);
			delete_userContainer.add(phone_numberTF4, 1, 6);
			delete_userContainer.add(emailL4, 0, 7);
			delete_userContainer.add(emailTF4, 1, 7);
			delete_userContainer.add(changeUserButton4, 0, 8);
			delete_userContainer.add(deleteButton4, 1, 8);
			delete_userContainer.setHgap(5);
			delete_userContainer.setVgap(8);
			
			
			
			
//Navigation User.Show_all_users --------------------------------------------------------------------------------------------------------------------
			Label show_all_usersL = new Label("Pokaż wszystkich klientów");
			show_all_usersL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
	        TableColumn idColumn = new TableColumn("ID klienta");
	        idColumn.setMinWidth(38);
	        idColumn.setCellValueFactory(
	                new PropertyValueFactory<>("id"));
			
	        TableColumn first_nameColumn = new TableColumn("Imię");
	        first_nameColumn.setMinWidth(80);
	        first_nameColumn.setCellValueFactory(
	                new PropertyValueFactory<>("first_name"));
	 
	        TableColumn last_nameColumn = new TableColumn("Nazwisko");
	        last_nameColumn.setMinWidth(90);
	        last_nameColumn.setCellValueFactory(
	                new PropertyValueFactory<>("last_name"));
	 
	        TableColumn peselColumn = new TableColumn("Pesel");
	        peselColumn.setMinWidth(115);
	        peselColumn.setCellValueFactory(
	                new PropertyValueFactory<>("pesel"));
	        
	        TableColumn adressColumn = new TableColumn("Adres");
	        adressColumn.setMinWidth(80);
	        adressColumn.setCellValueFactory(
	                new PropertyValueFactory<>("adress"));
	        
	        TableColumn phone_numberColumn = new TableColumn("Telefon");
	        phone_numberColumn.setMinWidth(90);
	        phone_numberColumn.setCellValueFactory(
	                new PropertyValueFactory<>("phone_number"));
	        
	        TableColumn emailColumn = new TableColumn("Email");
	        emailColumn.setMinWidth(80);
	        emailColumn.setCellValueFactory(
	                new PropertyValueFactory<>("email"));
	        
	 
	        usersTable.setItems(usersData);
	        usersTable.getColumns().addAll(idColumn, first_nameColumn, last_nameColumn, peselColumn, adressColumn, phone_numberColumn, emailColumn);
			usersTable.setMinWidth(700);
			
			VBox show_all_usersContainer = new VBox();
			show_all_usersContainer.getChildren().addAll(show_all_usersL,usersTable);
			show_all_usersContainer.setSpacing(10);
			
			
			
//Navigation Movies ----------------------------------------------------------------------------------------------------------------------
	        Button add_movieButton = new Button("Dodaj film              ");
	        add_movieButton.setMinSize(151, 30);
	        Button find_movieButton = new Button("Znajdz film          ");
	        find_movieButton.setMinSize(151, 30);
	        Button edit_movieButton = new Button("Edytuj/Usuń film ");
	        edit_movieButton.setMinSize(151, 30);
	        Button show_all_moviesButton = new Button("Pokaż wszystkie nfilmy   ");
	        show_all_moviesButton.setMinSize(151, 30);
	        
			VBox navigation_moviesContainer = new VBox();
			navigation_moviesContainer.getChildren().addAll(add_movieButton,find_movieButton, edit_movieButton,show_all_moviesButton);
			navigation_moviesContainer.setSpacing(10);
			
//Navigation Movies.Add_movie --------------------------------------------------------------------------------------------------------------------
			Label add_movieL = new Label("Dodaj film");
			add_movieL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			Label movieTitleL = new Label("Tytuł*");
			movieTitleL.setStyle("-fx-text-fill: white");
			movieTitleTF = new TextField();
			
			Label genreL = new Label("Żanr*");
			genreL.setStyle("-fx-text-fill: white");
			genreTF =new TextField();
			
			Label descriptionL = new Label("Opis");
			descriptionL.setStyle("-fx-text-fill: white");
	        descriptionTF = new TextField();
	        
	        Label release_yearL = new Label("Rok*");
	        release_yearL.setStyle("-fx-text-fill: white");
	        release_yearTF = new TextField();
	        
	        Label languageL = new Label("Język");
	        languageL.setStyle("-fx-text-fill: white");
	        languageTF = new TextField();
	        
	        Label rating_imdbL = new Label("IMDB ocena*");
	        rating_imdbL.setStyle("-fx-text-fill: white");
	        rating_imdbTF = new TextField();
	        
	        Label duration_minutesL = new Label("Czas trwania /n(minuty)*");
	        duration_minutesL.setStyle("-fx-text-fill: white");
	        duration_minutesTF = new TextField();
	        
	        Label main_actorsL = new Label("Obsada");
	        main_actorsL.setStyle("-fx-text-fill: white");
	        main_actorsTF = new TextField();
	        
	        Button add_mButton = new Button("Dodaj");
	        
	        
			GridPane new_movieContainer = new GridPane();
			new_movieContainer.add(add_movieL, 0, 0 ,2 ,1);
			new_movieContainer.add(movieTitleL, 0, 1);
			new_movieContainer.add(movieTitleTF, 1, 1);
			new_movieContainer.add(genreL, 0, 2);
			new_movieContainer.add(genreTF, 1, 2);
			new_movieContainer.add(descriptionL, 0, 3);
			new_movieContainer.add(descriptionTF, 1, 3);
			new_movieContainer.add(release_yearL, 0, 4);
			new_movieContainer.add(release_yearTF, 1, 4);
			new_movieContainer.add(languageL, 0, 5);
			new_movieContainer.add(languageTF, 1, 5);
			new_movieContainer.add(rating_imdbL, 0, 6);
			new_movieContainer.add(rating_imdbTF, 1, 6);
			new_movieContainer.add(duration_minutesL,0, 7);
			new_movieContainer.add(duration_minutesTF, 1, 7);
			new_movieContainer.add(main_actorsL, 0, 8);
			new_movieContainer.add(main_actorsTF, 1, 8);
			new_movieContainer.add(add_mButton, 1, 9);
			new_movieContainer.setHgap(5);
			new_movieContainer.setVgap(8);
			
			
			
//Navigation Movies.Find_movie --------------------------------------------------------------------------------------------------------------------
			Label find_titleL = new Label("Znajdz film");
			find_titleL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			find_idCB = new CheckBox("ID");
			find_idCB.setStyle("-fx-text-fill: white");
			find_idTF = new TextField();
			find_idTF.setDisable(true);
			
			find_titleCB = new CheckBox("Tytuł");
			find_titleCB.setStyle("-fx-text-fill: white");
			find_titleCB.setSelected(true);
			find_titleTF = new TextField();
			
			find_genreCB = new CheckBox("Żanr");
			find_genreCB.setStyle("-fx-text-fill: white");
			find_genreTF = new TextField();
			find_genreTF.setDisable(true);
			
			find_release_yearCB = new CheckBox("Rok");
			find_release_yearCB.setStyle("-fx-text-fill: white");
			find_release_yearTF = new TextField();
			find_release_yearTF.setDisable(true);
			
			find_main_actorCB = new CheckBox("Obsada");
			find_main_actorCB.setStyle("-fx-text-fill: white");
			find_main_actorTF = new TextField();
			find_main_actorTF.setDisable(true);
			
			Button find_searchButton = new Button("Szukaj");
			find_searchButton.setPrefSize(100, 20);
			
			
			
	        TableColumn idColumn2 = new TableColumn("ID");
	        idColumn2.setMinWidth(20);
	        idColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("id"));
			
	        TableColumn titleColumn2 = new TableColumn("Tytuł");
	        titleColumn2.setMinWidth(180);
	        titleColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("title"));
	 
	        TableColumn genreColumn2 = new TableColumn("Żanr");
	        genreColumn2.setMinWidth(80);
	        genreColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("genre"));
	 
	        TableColumn descriptionColumn2 = new TableColumn("Opis");
	        descriptionColumn2.setMinWidth(200);
	        descriptionColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("description"));
	        
	        TableColumn release_yearColumn2 = new TableColumn("Rok");
	        release_yearColumn2.setMinWidth(100);
	        release_yearColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("release_year"));
	        
	        TableColumn languageColumn2 = new TableColumn("Język");
	        languageColumn2.setMinWidth(50);
	        languageColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("language"));
	        
	        TableColumn imdb_ratingColumn2 = new TableColumn("IMDB ocena");
	        imdb_ratingColumn2.setMinWidth(80);
	        imdb_ratingColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("imdb_rating"));
	        
	        TableColumn duration_minutesColumn2 = new TableColumn("Czas trwania/n(minuty)");
	        duration_minutesColumn2.setMinWidth(120);
	        duration_minutesColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("duration_minutes"));
	        
	        TableColumn main_actorsColumn2 = new TableColumn("Obsada");
	        main_actorsColumn2.setMinWidth(200);
	        main_actorsColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("main_actors"));
	        
	        TableColumn availbaleColumn2 = new TableColumn("Dostępność");
	        availbaleColumn2.setMinWidth(60);
	        availbaleColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("availbale"));
	        
	        TableColumn last_rented_idColumn2 = new TableColumn("Ostatni wypożyczany (ID)");
	        last_rented_idColumn2.setMinWidth(150);
	        last_rented_idColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("last_rental_id"));
	        
	        TableColumn date_of_rentingColumn2 = new TableColumn("Data wypożyczenia");
	        date_of_rentingColumn2.setMinWidth(252);
	        date_of_rentingColumn2.setCellValueFactory(
	                new PropertyValueFactory<>("last_rental_date"));
	 
	        movie_table2.setItems(movieData2);
	        movie_table2.getColumns().addAll(idColumn2, titleColumn2, genreColumn2, descriptionColumn2, release_yearColumn2, languageColumn2, imdb_ratingColumn2, duration_minutesColumn2, main_actorsColumn2, availbaleColumn2, last_rented_idColumn2, date_of_rentingColumn2);

		
			GridPane find_movieContainer = new GridPane();
			find_movieContainer.add(find_titleL, 0, 0);
			find_movieContainer.add(find_idCB, 0, 1);
			find_movieContainer.add(find_idTF, 0, 2);
			find_movieContainer.add(find_titleCB, 1, 1);
			find_movieContainer.add(find_titleTF, 1, 2);
			find_movieContainer.add(find_genreCB, 2, 1);
			find_movieContainer.add(find_genreTF, 2, 2);
			find_movieContainer.add(find_release_yearCB, 3, 1);
			find_movieContainer.add(find_release_yearTF, 3, 2);
			find_movieContainer.add(find_main_actorCB, 4, 1);
			find_movieContainer.add(find_main_actorTF, 4, 2);
			find_movieContainer.add(find_searchButton, 2, 3);
			find_movieContainer.add(movie_table2, 0, 4, 5,4);
			find_movieContainer.setHgap(5);
			find_movieContainer.setVgap(8);
			
			
			
//Navigation Movies.Edit/Delete_movie --------------------------------------------------------------------------------------------------------------------
			Label izmeni_filmL2 = new Label("Edytuj film");
			izmeni_filmL2.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			edit_idL2 = new Label("ID Filmu");
			edit_idL2.setStyle("-fx-text-fill: white");
			edit_idTF2 = new TextField();
			edit_searchButton2 = new Button("Search");
			
			movieTitleL2 = new Label("Tytuł*");
			movieTitleL2.setStyle("-fx-text-fill: white");
			movieTitleL2.setDisable(true);
			movieTitleTF2 = new TextField();
			movieTitleTF2.setDisable(true);
			
			genreL2 = new Label("Żanr*");
			genreL2.setStyle("-fx-text-fill: white");
			genreL2.setDisable(true);
			genreTF2 =new TextField();
			genreTF2.setDisable(true);
			
			descriptionL2 = new Label("Opis");
			descriptionL2.setStyle("-fx-text-fill: white");
			descriptionL2.setDisable(true);
	        descriptionTF2 = new TextField();
	        descriptionTF2.setDisable(true);
	        
	        release_yearL2 = new Label("Rok*");
	        release_yearL2.setStyle("-fx-text-fill: white");
	        release_yearL2.setDisable(true);
	        release_yearTF2 = new TextField();
	        release_yearTF2.setDisable(true);
	        
	        languageL2 = new Label("Język");
	        languageL2.setStyle("-fx-text-fill: white");
	        languageL2.setDisable(true);
	        languageTF2 = new TextField();
	        languageTF2.setDisable(true);
	        
	        rating_imdbL2 = new Label("IMDB ocena*");
	        rating_imdbL2.setStyle("-fx-text-fill: white");
	        rating_imdbL2.setDisable(true);
	        rating_imdbTF2 = new TextField();
	        rating_imdbTF2.setDisable(true);
	        
	        duration_minutesL2 = new Label("Czas trwania*");
	        duration_minutesL2.setStyle("-fx-text-fill: white");
	        duration_minutesL2.setDisable(true);
	        duration_minutesTF2 = new TextField();
	        duration_minutesTF2.setDisable(true);
	        
	        main_actorsL2 = new Label("Obsada");
	        main_actorsL2.setStyle("-fx-text-fill: white");
	        main_actorsL2.setDisable(true);
	        main_actorsTF2 = new TextField();
	        main_actorsTF2.setDisable(true);
	        
	        edit_fDugme2 = new Button("Edit");
	        edit_fDugme2.setDisable(true);
	        
	        edit_change_movieButton = new Button("Zmień film");
	        edit_change_movieButton.setDisable(true);
	        
	        edit_deleteButton = new Button("Delete");
	        edit_deleteButton.setDisable(true);
	        
	        
			GridPane edit_movieContainer = new GridPane();
			edit_movieContainer.add(izmeni_filmL2, 0, 0 ,2 ,1);
			edit_movieContainer.add(edit_idL2, 0, 1);
			edit_movieContainer.add(edit_idTF2, 1, 1);
			edit_movieContainer.add(edit_searchButton2, 2, 1);
			edit_movieContainer.add(movieTitleL2, 0, 2);
			edit_movieContainer.add(movieTitleTF2, 1, 2);
			edit_movieContainer.add(genreL2, 0, 3);
			edit_movieContainer.add(genreTF2, 1, 3);
			edit_movieContainer.add(descriptionL2, 0, 4);
			edit_movieContainer.add(descriptionTF2, 1, 4);
			edit_movieContainer.add(release_yearL2, 0, 5);
			edit_movieContainer.add(release_yearTF2, 1, 5);
			edit_movieContainer.add(languageL2, 0, 6);
			edit_movieContainer.add(languageTF2, 1, 6);
			edit_movieContainer.add(rating_imdbL2, 0, 7);
			edit_movieContainer.add(rating_imdbTF2, 1, 7);
			edit_movieContainer.add(duration_minutesL2,0, 8);
			edit_movieContainer.add(duration_minutesTF2, 1, 8);
			edit_movieContainer.add(main_actorsL2, 0, 9);
			edit_movieContainer.add(main_actorsTF2, 1, 9);
			edit_movieContainer.add(edit_change_movieButton, 0, 10);
			edit_movieContainer.add(edit_fDugme2, 1, 10);
			edit_movieContainer.add(edit_deleteButton, 2, 10);
			edit_movieContainer.setHgap(5);
			edit_movieContainer.setVgap(8);
			
			
			
//Navigation Movies.Show_all_movies --------------------------------------------------------------------------------------------------------------------
			Label show_all_moviesL = new Label("Pokaż wszystkie filmy");
			show_all_moviesL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
	        TableColumn idColumn3 = new TableColumn("ID");
	        idColumn3.setMinWidth(38);
	        idColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("id"));
			
	        TableColumn titleColumn3 = new TableColumn("Tytuł");
	        titleColumn3.setMinWidth(180);
	        titleColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("title"));
	 
	        TableColumn genreColumn3 = new TableColumn("Żanr");
	        genreColumn3.setMinWidth(80);
	        genreColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("genre"));
	 
	        TableColumn descriptionColumn3 = new TableColumn("Opis");
	        descriptionColumn3.setMinWidth(300);
	        descriptionColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("description"));
	        
	        TableColumn release_yearColumn3 = new TableColumn("Rok");
	        release_yearColumn3.setMinWidth(40);
	        release_yearColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("release_year"));
	        
	        TableColumn languageColumn3 = new TableColumn("Język");
	        languageColumn3.setMinWidth(60);
	        languageColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("language"));
	        
	        TableColumn imdb_ratingColumn3 = new TableColumn("IMDB ocena");
	        imdb_ratingColumn3.setMinWidth(80);
	        imdb_ratingColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("imdb_rating"));
	        
	        TableColumn duration_minutesColumn3 = new TableColumn("Czas trwania (minuty)");
	        duration_minutesColumn3.setMinWidth(80);
	        duration_minutesColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("duration_minutes"));
	        
	        TableColumn main_actorsColumn3 = new TableColumn("Obsada");
	        main_actorsColumn3.setMinWidth(300);
	        main_actorsColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("main_actors"));
	        
	        TableColumn availbaleColumn3 = new TableColumn("Dostępność");
	        availbaleColumn3.setMinWidth(60);
	        availbaleColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("availbale"));
	        
	        TableColumn last_rental_idColumn3 = new TableColumn("Ostatni wypożyczany (ID)");
	        last_rental_idColumn3.setMinWidth(80);
	        last_rental_idColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("last_rental_id"));
	        
	        TableColumn last_date_of_rentingColumn3 = new TableColumn("Data wypożyczenia");
	        last_date_of_rentingColumn3.setMinWidth(80);
	        last_date_of_rentingColumn3.setCellValueFactory(
	                new PropertyValueFactory<>("last_rental_date"));
	 
	        movieTable3.setItems(movieData3);
	        movieTable3.getColumns().addAll(idColumn3, titleColumn3, genreColumn3, descriptionColumn3, release_yearColumn3, languageColumn3, imdb_ratingColumn3, duration_minutesColumn3, main_actorsColumn3, availbaleColumn3, last_rental_idColumn3, last_date_of_rentingColumn3);

			VBox show_all_moviesContainer = new VBox();
			show_all_moviesContainer.getChildren().addAll(show_all_moviesL,movieTable3);
			show_all_moviesContainer.setSpacing(5);
			
			
			
//Navigation Rental * --------------------------------------------------------------------------------------------------------------------
			Button rental_movieButton = new Button("Wypożyczenie filmu   ");
			rental_movieButton.setMinSize(151, 30);
			
			Button return_back_movieButton = new Button("Zwróć film");
			return_back_movieButton.setMinSize(151, 30);
			
			Button list_of_rental_moviesButton = new Button("List wypożyczonych \nfilmów");
			list_of_rental_moviesButton.setMinSize(151, 30);
			
			VBox rentalContainer = new VBox();
			rentalContainer.getChildren().addAll(rental_movieButton,return_back_movieButton,list_of_rental_moviesButton);
			rentalContainer.setSpacing(10);
			
			
//Navigation Rental.Rental_movie --------------------------------------------------------------------------------------------------------------------
			Label rental_movieL = new Label("Wypożyczenie filmu");
			rental_movieL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			Label rental_movie_idL = new Label("ID Filmu*");
			rental_movie_idL.setStyle("-fx-text-fill: white");
			rentalMovie_id_movieTF = new TextField();
			
			Label rental_user_id = new Label("ID Klienta*");
			rental_user_id.setStyle("-fx-text-fill: white");
			rentalMovie_id_userTF = new TextField();
			
			Button rental_rentalButton = new Button("Wypożeczenie");
			
			
			GridPane rental_movieContainer = new GridPane();
			rental_movieContainer.add(rental_movieL, 0, 0);
			rental_movieContainer.add(rental_movie_idL, 0, 1);
			rental_movieContainer.add(rentalMovie_id_movieTF, 1, 1);
			rental_movieContainer.add(rental_user_id, 0, 2);
			rental_movieContainer.add(rentalMovie_id_userTF, 1, 2);
			rental_movieContainer.add(rental_rentalButton, 1, 3);
			rental_movieContainer.setHgap(5);
			rental_movieContainer.setVgap(8);
			
			
//Navigation Rental.Return_back_movie --------------------------------------------------------------------------------------------------------------------
			Label return_back_movieL = new Label("Zwróc film");
			return_back_movieL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
			Label return_movie_idL = new Label("ID filmu*");
			return_movie_idL.setStyle("-fx-text-fill: white");
			
			Button vrati_film_vratiDugme = new Button("Zwróć");
			
			returnBackMovie_idMovieTF = new TextField();
			
			GridPane return_movieContainer = new GridPane();
			return_movieContainer.add(return_back_movieL, 0, 0);
			return_movieContainer.add(return_movie_idL, 0, 1);
			return_movieContainer.add(returnBackMovie_idMovieTF, 1, 1);
			return_movieContainer.add(vrati_film_vratiDugme, 1, 2);
			return_movieContainer.setHgap(5);
			return_movieContainer.setVgap(8);
			
			
//Navigation Rental.List_of_rental_movies --------------------------------------------------------------------------------------------------------------------
			Label rental_list_titleL = new Label("Lista wypożyczonych filmów");
			rental_list_titleL.setStyle("-fx-font-size:21;-fx-text-fill: white");
			
	        TableColumn idColumn4 = new TableColumn("ID");
	        idColumn4.setMinWidth(48);
	        idColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("id"));
			
	        TableColumn titleColumn4 = new TableColumn("Tytuł");
	        titleColumn4.setMinWidth(180);
	        titleColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("title"));
	 
	        TableColumn genreColumn4 = new TableColumn("Żanr");
	        genreColumn4.setMinWidth(80);
	        genreColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("genre"));
	 
	        TableColumn descriptionColumn4 = new TableColumn("Opis");
	        descriptionColumn4.setMinWidth(400);
	        descriptionColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("description"));
	        
	        TableColumn release_year4 = new TableColumn("Rok");
	        release_year4.setMinWidth(40);
	        release_year4.setCellValueFactory(
	                new PropertyValueFactory<>("release_year"));
	        
	        TableColumn languageColumn4 = new TableColumn("Język");
	        languageColumn4.setMinWidth(60);
	        languageColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("language"));
	        
	        TableColumn imdb_ratingColumn4 = new TableColumn("Ocena IMDB");
	        imdb_ratingColumn4.setMinWidth(80);
	        imdb_ratingColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("imdb_rating"));
	        
	        TableColumn duration_minutesColumn4 = new TableColumn("Czas trwania");
	        duration_minutesColumn4.setMinWidth(80);
	        duration_minutesColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("duration_minutes"));
	        
	        TableColumn main_actorsColumn4 = new TableColumn("Obsada");
	        main_actorsColumn4.setMinWidth(400);
	        main_actorsColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("main_actors"));
	        
	        TableColumn availbaleColumn4 = new TableColumn("Dostępność");
	        availbaleColumn4.setMinWidth(60);
	        availbaleColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("availbale"));
	        
	        TableColumn last_rental_idColumn4 = new TableColumn("Ostatni wypożyczany");
	        last_rental_idColumn4.setMinWidth(80);
	        last_rental_idColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("last_rental_id"));
	        
	        TableColumn last_date_rentalColumn4 = new TableColumn("Data wypożeczenia");
	        last_date_rentalColumn4.setMinWidth(80);
	        last_date_rentalColumn4.setCellValueFactory(
	                new PropertyValueFactory<>("last_rental_date"));
	 
	        movieTable4.setItems(movieData4);
	        movieTable4.getColumns().addAll(idColumn4, titleColumn4, genreColumn4, descriptionColumn4, release_year4, languageColumn4, imdb_ratingColumn4, duration_minutesColumn4, main_actorsColumn4, availbaleColumn4, last_rental_idColumn4, last_date_rentalColumn4);
	        movieTable4.setMinWidth(700);
	        
	        VBox list_of_rental_moviesContainer = new VBox();
	        list_of_rental_moviesContainer.getChildren().addAll(rental_list_titleL,movieTable4);
	        list_of_rental_moviesContainer.setSpacing(8);
	        
	        
	        

//Navigation Informations * --------------------------------------------------------------------------------------------------------------------
	        Button about_programButton = new Button("O aplikacji ");
	        about_programButton.setMinSize(151, 30);
	        
	        Button about_authorButton = new Button("O nas   ");
	        about_authorButton.setMinSize(151, 30);
	        
	        VBox informationsContainer = new VBox();
	        informationsContainer.getChildren().addAll(about_programButton,about_authorButton);
	        informationsContainer.setSpacing(8);
	        
	        
//Navigation Informations.About_program --------------------------------------------------------------------------------------------------------------------
	        Label about_programL = new Label("O aplikacji");
	        about_programL.setStyle("-fx-font-size:21;-fx-text-fill: white");
	        
	        TextArea about_programTA = new TextArea();
	        about_programTA.setText("Aplikacja - Wypożyczalnia filmów");
	        about_programTA.setMinSize(710, 400);
	        about_programTA.setEditable(false);
	        
	        VBox about_programContainer = new VBox();
	        about_programContainer.getChildren().addAll(about_programL,about_programTA);
	        about_programContainer.setSpacing(8);
	        
	        
	        //Navigation Informations.About_author
	        Label about_authorL = new Label("O nas");
	        about_authorL.setStyle("-fx-font-size:21;-fx-text-fill: white");
	        
	        TextArea about_authorTA = new TextArea();
	        about_authorTA.setText("Oleh Bukliv, Serhii Fedirko"
	        		+ " Katolicki Uniwersytet Lubelski"
	        		+ " 2019");
	        about_authorTA.setMinSize(370, 150);
	        about_authorTA.setEditable(false);
	        
	        VBox about_authorContainer = new VBox();
	        about_authorContainer.getChildren().addAll(about_authorL,about_authorTA);
	        about_authorContainer.setSpacing(8);
	        
	        
			
	        
			
	 //Main container * -----------------------------------------------------------------------------------------------------------------------
			VBox mainContainer = new VBox();
			mainContainer.getChildren().addAll(navigation_mainContainer,navigationBody);
			
			
			
// --**ACTION EVENTS**-- --------------------------------------------------------------------------------------------------------------------
			
			
			//Navigation Users **
			usersButton.setOnAction( e -> {
			navigationBody.getChildren().remove(0);
			navigationBody.getChildren().add(0, navigation_usersContainer);
			try{
			navigationBody.getChildren().remove(1);
			}
			catch(Exception r){
			
			}
			});
			new_userButton.setOnAction( e -> {
				try{
				navigationBody.getChildren().remove(1);
				}
				catch(Exception t){
					
				}
				navigationBody.getChildren().add(1,new_userContainer);
			});
			addButton.setOnAction(e -> {
				object_Back.addUser();
			});
			
			
			edit_userButton.setOnAction( e-> {
				try{
				navigationBody.getChildren().remove(1);
				}
				catch(Exception y){
					
				}
				navigationBody.getChildren().add(1,edit_userContainer);
			});
			searchButton2.setOnAction( e-> {
				object_Back.allowUserEdit();
			});
			editButton2.setOnAction( e-> {
				object_Back.editUser();
			});
			changeUserButton2.setOnAction( e-> {
				object_Back.change_userEdit();
			});

			
			show_userButton.setOnAction( e-> {
				try{
				navigationBody.getChildren().remove(1);
				}
				catch(Exception u){
					
				}
				navigationBody.getChildren().add(1,show_userContainer);
			});
			searchButton3.setOnAction( e-> {
				object_Back.showUser();
			});
			
			
			delete_userButton.setOnAction( e-> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception i){}
				navigationBody.getChildren().add(1,delete_userContainer);
			});
			searchButton4.setOnAction( e-> {
				object_Back.allow_deleting_user();
			});
			deleteButton4.setOnAction( e-> {
				object_Back.finalDeleting();
			});
			changeUserButton4.setOnAction( e-> {
				object_Back.changeUserDeleting();
			});
			
			
			show_all_usersButton.setOnAction( e-> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception o){}
				navigationBody.getChildren().add(1,show_all_usersContainer);
				object_Back.showAllUsers();
			});
			
			
//Navigation Movies * --------------------------------------------------------------------------------------------------------------------
			moviesButton.setOnAction( e -> {
				navigationBody.getChildren().remove(0);
				navigationBody.getChildren().add(0, navigation_moviesContainer);
				try{
					navigationBody.getChildren().remove(1);
					}
					catch(Exception r){
					}
			});
//Navigation Movies.Add_movies --------------------------------------------------------------------------------------------------------------------
			add_movieButton.setOnAction( e-> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception o){}
				navigationBody.getChildren().add(1,new_movieContainer);	
			});
			add_mButton.setOnAction( e -> {
				object_Back.dodajFilm();
			});
			
			
			
			
			find_movieButton.setOnAction( e -> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception o){}
				navigationBody.getChildren().add(1,find_movieContainer);	
			});
			find_idCB.setOnAction(e -> object_Back.checkAllSearchFields());
			find_titleCB.setOnAction(e -> object_Back.checkAllSearchFields());
			find_genreCB.setOnAction(e -> object_Back.checkAllSearchFields());
			find_release_yearCB.setOnAction(e -> object_Back.checkAllSearchFields());
			find_main_actorCB.setOnAction(e -> object_Back.checkAllSearchFields());
			find_searchButton.setOnAction( e -> object_Back.findMovie());
			
			
			
//Navigation Movies.Add_movie ------------------------------------------------------------------------------------------------------------------------------
			edit_movieButton.setOnAction( e-> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception o){}
				navigationBody.getChildren().add(1,edit_movieContainer);	
			});
			edit_searchButton2.setOnAction( e -> object_Back.allowMovieEdit());
			edit_change_movieButton.setOnAction( e -> object_Back.change_movie_EditingMovie());
			edit_fDugme2.setOnAction( e -> object_Back.finalEditMovie());
			edit_deleteButton.setOnAction( e -> object_Back.deleteMovie());
			
			//Navigation Movies.Show_all_movies
			show_all_moviesButton.setOnAction( e-> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception p){}
				navigationBody.getChildren().add(1,show_all_moviesContainer);	
				object_Back.show_all_movies();
			});
			
//Navigation Rental * -----------------------------------------------------------------------------------------------------------------------
			rentalButton.setOnAction( e -> {
				navigationBody.getChildren().remove(0);
				navigationBody.getChildren().add(0, rentalContainer);
				try{
					navigationBody.getChildren().remove(1);
					}
					catch(Exception r){
					}
			});
			
			rental_movieButton.setOnAction( e -> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception p){}
				navigationBody.getChildren().add(1,rental_movieContainer);	
			});
			rental_rentalButton.setOnAction( e -> object_Back.finalRentalMovie());
			
//Navigation Movies.Return_back_movie --------------------------------------------------------------------------------------------------------------------
			return_back_movieButton.setOnAction( e -> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception p){}
				navigationBody.getChildren().add(1,return_movieContainer);	
			});
			vrati_film_vratiDugme.setOnAction( e -> {
				try {
					object_Back.returnBackMovie();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			});
		 
			
//Navigation Movies.List_of_rental_movies --------------------------------------------------------------------------------------------------------------------
			list_of_rental_moviesButton.setOnAction( e -> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception p){}
				navigationBody.getChildren().add(1,list_of_rental_moviesContainer);
				object_Back.showRentaledMovies();
			});
			
			
//Navigation Properties --------------------------------------------------------------------------------------------------------------------
//			propertiesButton.setOnAction( e -> {
//				navigationBody.getChildren().remove(0);
//				navigationBody.getChildren().add(0,propertiesContainer);
//				try{
//					navigationBody.getChildren().remove(1);
//					}
//					catch(Exception r){
//					}
//			});
//			change_security_codeButton.setOnAction( e -> {
//				try{
//				navigationBody.getChildren().remove(1);
//				}catch(Exception p){}
//				navigationBody.getChildren().add(1,security_codeContainer);	
//			});
//			change_scButton.setOnAction( e -> object_Back.changeSecurityCode());
//			
////Navigation Properties.Change_background --------------------------------------------------------------------------------------------------------------------
//			change_backgroundButton.setOnAction( e -> {
//				try{
//				navigationBody.getChildren().remove(1);
//				}catch(Exception p){}
//				navigationBody.getChildren().add(1,backgroundContainer);	
//			});
//			background1Button.setOnAction( e -> {
//				background="background1";
//				object_Back.changeBackground();
//				backgroundIW.setImage(new Image("file:./Images/Backgrounds/"+background+".jpg"));
//			});
//			background2Button.setOnAction( e -> {
//				background="background2";
//				object_Back.changeBackground();
//				backgroundIW.setImage(new Image("file:./Images/Backgrounds/"+background+".jpg"));
//			});
//			background3Button.setOnAction( e -> {
//				background="background3";
//				object_Back.changeBackground();
//				backgroundIW.setImage(new Image("file:./Images/Backgrounds/"+background+".jpg"));
//			});
			
			
			
//Navigation Informations --------------------------------------------------------------------------------------------------------------------
			informationsButton.setOnAction( e -> {
				navigationBody.getChildren().remove(0);
				navigationBody.getChildren().add(0,informationsContainer);
				try{
					navigationBody.getChildren().remove(1);
					}
					catch(Exception r){
					}
			});
			
			about_programButton.setOnAction( e -> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception p){}
				navigationBody.getChildren().add(1,about_programContainer);	
			});
			
			about_authorButton.setOnAction( e -> {
				try{
				navigationBody.getChildren().remove(1);
				}catch(Exception p){}
				navigationBody.getChildren().add(1,about_authorContainer);	
			});
			
			
		
			
			
			
			
			
			
			
			
//Login page -------------------------------------------------------------------------------------------------------------------------------------			
			Label security_codeL = new Label("Wpisz kod zabezpieczający");
			security_codeL.setStyle("-fx-font-size:20;-fx-text-fill: white");
			
			PasswordField security_codePF = new PasswordField();
			security_codePF.setMaxWidth(190);
			
			Button security_codeButton = new Button("Wejdz");
			
			
			HBox security_code_mContainer = new HBox();
			security_code_mContainer.getChildren().addAll(security_codeL,security_codePF,security_codeButton);
			security_code_mContainer.setAlignment(Pos.CENTER);
			security_code_mContainer.setSpacing(10);
			
			ImageView security_codeBackground = new ImageView(new Image("file:./Images/Backgrounds/login_background.jpg"));
			
			StackPane security_code_mainContainer = new StackPane();
			security_code_mainContainer.getChildren().addAll(security_codeBackground,security_code_mContainer);
			
			
			

			StackPane main_sceneContainer = new StackPane();
			main_sceneContainer.getChildren().addAll(backgroundIW,mainContainer);
			
//Login Scene and Stage --------------------------------------------------------------------------------------------------------------------------------------------------

			security_codeScene = new Scene(security_code_mainContainer,500,350);

			Scene mainScene = new Scene(main_sceneContainer,1000,535);
			
			startingStage.setScene(security_codeScene); 
			startingStage.setTitle("Wypożyczalnia filmów");
			startingStage.setResizable(false);
			startingStage.getIcons().add(new Image("file:./Images/Icons/icon.png"));
			startingStage.show();
			
			//Listening,is Enter key is pressed during entering security code 
			security_codePF.setOnKeyPressed(e ->{
				if(e.getCode().equals(KeyCode.ENTER)){
					if(security_codePF.getText().equals(securityCode)){
						security_codePF.clear();
						startingStage.setScene(mainScene);
						startingStage.centerOnScreen();
					}else{
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Uwaga");
						alert.setHeaderText(null);
						alert.setContentText("Wpisałeś zły kod!");

						alert.showAndWait();
						
						security_codePF.clear();
					}
				}
			});
			
			security_codeButton.setOnAction( e ->{
				if(security_codePF.getText().equals(securityCode)){
					startingStage.setScene(mainScene);
					startingStage.centerOnScreen();
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Uwaga");
					alert.setHeaderText(null);
					alert.setContentText("Wpisałeś zły kod!");

					alert.showAndWait();
				}
				security_codePF.clear();
			});
			
//Navigation Logout * --------------------------------------------------------------------------------------------------------------------
			logoutButton.setOnAction( e -> {
				securityCode = object_Back.returnBackCurrentSecurityCode();
				startingStage.setScene(security_codeScene); 
				startingStage.centerOnScreen();
			});
			
			

			
		
			
		//end of try-block of starting method	
		}
		catch(Exception e){
			System.out.println("Error!");
		}
		
	}


	
	
	public static void main(String[] args) {
		
		launch(args);

	}


}
