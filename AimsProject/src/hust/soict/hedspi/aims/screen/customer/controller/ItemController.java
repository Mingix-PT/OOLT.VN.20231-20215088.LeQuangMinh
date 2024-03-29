package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javax.swing.*;

public class ItemController {
    private Media media;
    private Cart cart;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    public ItemController(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
    }
    public void setData(Media media) {
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost()+"$");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            ((HBox) btnPlay.getParent()).getChildren().remove(btnPlay);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }


    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(null, "The media has been added to the cart", "Add to cart", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Add to cart", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        try {
            String message = ((Playable) media).playMessage();
            JOptionPane.showMessageDialog(null, message, "Play", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (PlayerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Play", JOptionPane.ERROR_MESSAGE);
        }
    }
}
