package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import jdk.jfr.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Media media;

    protected Container cp = getContentPane();

    protected String title;
    protected String category;
    protected float cost;
    protected TextField tfTitle = new TextField();
    protected TextField tfCategory = new TextField();
    protected TextField tfCost = new TextField();
    protected Label lbTitle = new Label("Title: ");
    protected Label lbCategory = new Label("Category: ");
    protected Label lbCost = new Label("Cost: ");

    protected void setMediaTitle (String title) {
        this.title = title;
    }

    protected void setMediaCategory (String category) {
        this.category = category;
    }

    protected void setMediaCost (float cost) {
        this.cost = cost;
    }


    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View Store"));

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 0)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 0)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(8, 2));
        center.add(lbTitle);
        center.add(tfTitle);
        center.add(lbCategory);
        center.add(tfCategory);
        center.add(lbCost);
        center.add(tfCost);
        return center;
    }

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);

        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    protected class TitleInputListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            setMediaTitle(tfTitle.getText());
//            tfTitle.setText("");
//        }
//    }
//
//    protected class CategoryInputListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            setMediaCategory(tfCategory.getText());
//            tfCategory.setText("");
//        }
//    }
//
//    protected class CostInputListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            setMediaCost(Float.parseFloat(tfCost.getText()));
//            tfCost.setText("");
//        }
//    }
}
