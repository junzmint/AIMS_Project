package hust.soict.dsai.aims.Aims;
import java.util.Scanner;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

public class AIMS {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("---------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();
        initializeData(store);

        while (true) {
            showMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                viewStore(store, cart);
            }
            if (choice == 2) {
                updateStore(store);
            }
            if (choice == 3) {
                cart.viewCart();
                handleCartMenu(cart);
            }
            if (choice == 0) {
                System.exit(0);
            }
        }
    }

    private static void updateStore(Store store) {
        System.out.println("Delete a media from store");
        System.out.print("Enter title of media: ");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        Media result = store.searchStore(title);
        if (result != null) {
            store.removeMedia(result);
            System.out.println(result.getTitle() + " deleted");
        } else {
            System.out.println("Not found");
        }
    }

    private static void initializeData(Store store) {
        Book book1 = new Book();
        book1.setTitle("Minna no Nihongo");
        book1.setCategory("Learing");
        book1.setCost(26f);
        book1.addAuthor("bmd");
        Book book2 = new Book();
        book2.setTitle("Shinkanzen");
        book2.setCategory("Learning");
        book2.setCost(29f);
        book2.addAuthor("dct");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc();
        dvd1.setTitle("Avatar");
        dvd1.setCategory("Fantasy");
        dvd1.setDirector("James Cameron");
        dvd1.setLength(203);
        dvd1.setCost(190f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc();
        dvd2.setTitle("The Lion king");
        dvd2.setCategory("Animation");
        dvd2.setDirector("A. Pepter");
        dvd2.setLength(120);
        dvd2.setCost(20.0f);

        CompactDisc cd1 = new CompactDisc();
        cd1.setTitle("Loving");
        cd1.setCategory("Many kinds");
        cd1.setCost(180f);
        cd1.setDirector("bmd");
        cd1.setLength(cd1.getLength());
        cd1.setArtist("dct");
        cd1.addTrack(new Track("Midnight rain", 20));
        cd1.addTrack(new Track("Snow on the beach", 15));

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);
    }

    private static void handleDetailsMenu(Media media, Cart cart) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " added to cart");
        }
        if (choice == 2) {
            media.play();
        }
        if (choice == 0) {
            System.out.println("Exit media details view");
        }
    }

    private static void handleCartMenu(Cart cart) {
        while (true) {
            cartMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Filter medias in cart by id/title ? (0:1): ");
                int option = input.nextInt();
                if (option == 1) {
                    System.out.print("Enter title: ");
                    input.nextLine();
                    String title = input.nextLine();
                    cart.searchByTitle(title);
                } else {
                }
            }
            if (choice == 2) {
                System.out.print("Sort medias in cart by title/cost ? (0:1): ");
                int option = input.nextInt();
                if (option == 1) {
                    cart.sortCartByCost();
                    cart.viewCart();
                } else {
                    cart.sortCartByTitle();
                    cart.viewCart();
                }
            }
            if (choice == 3) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = cart.searchCart(title);
                if (result != null) {
                    cart.removeMedia(result);
                    System.out.println("Deleted " + result.getTitle());
                    cart.viewCart();
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 4) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = cart.searchCart(title);
                if (result != null) {
                    result.play();
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 5) {
                System.out.println("An order is created!");
                cart.clearCart();
            }
            if (choice == 0) {
                System.out.println("Exit cart view");
                break;
            }
        }
    }

    private static void viewStore(Store store, Cart cart) {
        store.viewStoreList();
        while (true) {
            storeMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = store.searchStore(title);

                if (result == null) {
                    System.out.println("Can not found media");
                } else {
                    System.out.println(result.toString());
                    mediaDetailsMenu();
                    handleDetailsMenu(result, cart);
                }
            }
            if (choice == 2) {
                System.out.println("Enter title of media");
                input.nextLine();
                String title = input.nextLine();
                Media result = store.searchStore(title);
                if (result != null) {
                    cart.addMedia(result);
                    System.out.println(result.getTitle() + " added to cart");
                    System.out.println("Quantity ordered: " + cart.getQtyOrdered() + " media");
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 3) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = store.searchStore(title);
                if (result != null) {
                    result.play();
                } else {
                    System.out.println("Can not found media");
                }
            }
            if (choice == 4) {
                cart.viewCart();
            }
            if (choice == 0) {
                System.out.println("Exit Store view");
                break;
            }
        }
    }
}