package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ViewStoreController {
    private Store store;
    public ViewStoreController(Store store) {
        this.store = store;
    }

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
                Media currentMedia = store.getItemsInStore().get(i);
                System.out.println(currentMedia.getTitle());
                ItemController itemController = new ItemController(currentMedia);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = fxmlLoader.load();
                itemController.setData(currentMedia);

                if (column == 3) {
                    column = 0;
                    row++;
                }
                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10 ,10));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {

    }

}
