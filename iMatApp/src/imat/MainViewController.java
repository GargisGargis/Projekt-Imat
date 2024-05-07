
package imat;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;

public class MainViewController implements Initializable {

    Model model = new Model();
    @FXML
    Label pathLabel;
    AnchorPane productArea;

    IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();

    public void initialize(URL url, ResourceBundle rb) {

        String iMatDirectory = iMatDataHandler.imatDirectory();
        pathLabel.setText(iMatDirectory);

        try {
            updateProductArea(model.getProducts());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public void updateProductArea(List<Product> products) throws FileNotFoundException {
        productArea.getChildren().clear();

        for(Product product : products){
            productArea.getChildren().add(new ProductModule(product));

        }
    }

}