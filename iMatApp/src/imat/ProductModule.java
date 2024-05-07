package imat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javax.swing.text.html.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;


import java.io.FileNotFoundException;
import java.io.IOException;
public class ProductModule extends AnchorPane {
    @FXML
    ImageView priceModuleImage;
    Label priceModuleLabel;

        public void productModule(Product product) throws FileNotFoundException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("productModule.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }

            priceModuleLabel.setText(Double.valueOf(product.getPrice()).toString());

        }

    }