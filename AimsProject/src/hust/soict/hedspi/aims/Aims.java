package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.menu.MenuAction;
import hust.soict.hedspi.aims.menu.MenuDisplay;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;

import java.util.Scanner;


public class Aims {
    public static void main(String[] args) {
        int choice;
        while (true) {
            Cart cart = new Cart();
            Store store = new Store();
            MenuDisplay.showMenu();
            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            switch (choice) {
                case 0:
                    MenuDisplay.clrscr();
                    System.out.println("Thanks for using our application!");
                    System.out.println("Exiting...");
                    System.exit(0);
                case 1:
                    MenuAction.storeMenuAction(cart, store);
                    break;
                case 2:
                    MenuAction.updateStore(store);
                    break;
                case 3:
                    MenuDisplay.cartMenu();
                    break;
                default:
                    MenuDisplay.clrscr();
                    System.out.println("Invalid choice! Please choose again!");
                    break;
            }
        }
    }
}
