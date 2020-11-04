module com.mycompany.scenebuilderpractice {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.base;

    opens com.mycompany.scenebuilderpractice to javafx.fxml;
    exports com.mycompany.scenebuilderpractice;
}
