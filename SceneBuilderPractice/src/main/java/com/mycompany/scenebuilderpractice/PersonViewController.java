package com.mycompany.scenebuilderpractice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class PersonViewController implements Initializable {
    
    private Person selectedPerson;
    
    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;
    @FXML private ImageView photo;
    
    private FileChooser fileChooser;
    private File filePath;
    
    /**
     * This method will allow the user to change the image on the screen
     */
    public void chooseImageButtonPushed(ActionEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        fileChooser  = new FileChooser();
        fileChooser.setTitle("Open image");
        
        //Set to user's directory or go to the default C drive if cannot access
        String userDirectoryString = System.getProperty("user.home") + "\\Pictures";
        File userDirectory = new File(userDirectoryString);
        
        if (!userDirectory.canRead())
            userDirectory = new File("c:/");
        
        fileChooser.setInitialDirectory(userDirectory);
        
        this.filePath = fileChooser.showOpenDialog(stage);
        
        //Try to update the image by loading the new image
        try{
            //BufferedImage bufferedImage = ImageIO.read(filePath);
            //Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            //selectedPerson.setImage(image);
            Image image = new Image(filePath.toURI().toURL().toString());
            selectedPerson.setImage(image);
            photo.setImage(selectedPerson.getImage());
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    /**
     * This method accepts a person to initialize the view
     */
    public void initData(Person person){
        selectedPerson = person;
        firstNameLabel.setText(selectedPerson.getFirstName());
        lastNameLabel.setText(selectedPerson.getLastName());
        birthdayLabel.setText(selectedPerson.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedPerson.getAge()));
        photo.setImage(selectedPerson.getImage());
    }
    
        /**
     * When this method is called, it will change the Scene to
     * a TableView example
     */
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ExampleOfTableView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}
