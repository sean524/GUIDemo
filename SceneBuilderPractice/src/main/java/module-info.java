module com.mycompany.scenebuilderpractice {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.scenebuilderpractice to javafx.fxml;
    exports com.mycompany.scenebuilderpractice;
}
