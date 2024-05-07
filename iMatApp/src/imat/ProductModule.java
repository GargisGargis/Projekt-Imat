package imat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductDetail;


import java.io.FileNotFoundException;
import java.io.IOException;
public class ProductModule extends AnchorPane {
    Product product;
    private Model model = Model.getInstance();

    @FXML
    ImageView productModuleImage;
    Label productModuleLabel;
    private final static double kImageWidth = 100.0;
    private final static double kImageRatio = 0.75;

        public ProductModule(Product product) throws FileNotFoundException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("productModule.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
            this.product = product;
            productModuleLabel.setText(product.getName());
            //priceModuleLabel.setText(Double.valueOf(product.getPrice()).toString());
            //prizeLabel.setText(String.format("%.2f", product.getPrice()) + " " + product.getUnit());
            productModuleImage.setImage(model.getImage(product, kImageWidth, kImageWidth*kImageRatio));

        }

    }