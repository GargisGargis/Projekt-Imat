package imat;

import javafx.scene.image.Image;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private static Model instance = null;
    private IMatDataHandler iMatDataHandler;

    private final ArrayList<String> availableCardTypes = new ArrayList<>(Arrays.asList("MasterCard", "Visa"));
    private final ArrayList<String> months = new ArrayList<>(Arrays.asList("1","2","3","4","5","6"));
    private final ArrayList<String> years = new ArrayList<>();

    protected Model(){}

    public static Model getInstance(){
        if(instance == null){
            instance = new Model();
            instance.init();
        }
        return instance;
    }

    private void init() {
        iMatDataHandler = IMatDataHandler.getInstance();
    }
    public List<Product> getProducts(){
        return iMatDataHandler.getProducts();
    }
    public Product getProduct(int productID){return iMatDataHandler.getProduct(productID);}
    public List<Product> findProducts(String s ){return iMatDataHandler.findProducts(s);}
    public Image getImage(Product p, double width, double height){return iMatDataHandler.getFXImage(p,width,height);}

}
