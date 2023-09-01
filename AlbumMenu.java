import java.util.Scanner;

import javax.management.InvalidApplicationException;

public class AlbumMenu {
    private static AlbumDao dao;
    static {
        try {
            dao = new AlbumDaoImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Album Management Menu");
            System.out.println("1 - Add Album\n2 - List Albums\n3 - Find Album by Title"
            		+ "\n4 - Find Albums by Artist\n5 - Find Albums by Genre "
            		+ "\n6 - Update an Album\n7 - Delete Album\n8 - Exit");
            System.out.println("Enter Choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    addAlbum();
                    break;
                case 2:
                	listAlbums();
                    break;
                case 3:
                    findAlbumByTitle();
                    break;
                case 4:
                	findAlbumByArtist();
                	break;
                case 5:
                	findAlbumByGenre();
                	break;
                case 6:
                	updateAlbum();
                    break;
                case 7:
                	deleteAlbum();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }


	private static void addAlbum() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Album Title: ");
        String title = scan.nextLine();
        System.out.println("Enter Artist Name: ");
        String artist = scan.nextLine();
        System.out.println("Enter Genre: ");
        String genre = scan.nextLine();

        Album album = new Album(title, artist, genre);
        dao.persist(album);
    }

    private static void deleteAlbum() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Album Title: ");
        String title = console.nextLine();
        try {
            boolean deleted = dao.delete(title);
            if (deleted) {
                System.out.println("Album deleted successfully.");
            } else {
                System.out.println("Album not found or deletion failed.");
            }
        } catch (InvalidApplicationException e) {
            System.out.println("Invalid album: " + e.getMessage());
        }
    }

    private static void listAlbums() {
        dao.list().forEach(System.out::println);
    }

    private static void findAlbumByGenre() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Album Genre: ");
        String genre = console.nextLine();
			dao.findByGenre(genre).forEach(System.out::println);
    }

    private static void findAlbumByArtist() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Album Artist: ");
        String artist = console.nextLine();
			dao.findByArtist(artist).forEach(System.out::println);
    }

    private static void findAlbumByTitle() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Album Title: ");
        String title = console.nextLine();
        try {
            Album album = dao.findByTitle(title);
            if (album != null) {
                System.out.println(album);
            } else {
                System.out.println("Album not found.");
            }
        } catch (InvalidApplicationException e) {
            System.out.println("Invalid album: " + e.getMessage());
        }
    }

    private static void updateAlbum() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Album Title: ");
        String title = scan.nextLine();
        System.out.println("Enter New Artist Name: ");
        String newArtist = scan.nextLine();
        System.out.println("Enter New Genre: ");
        String newGenre = scan.nextLine();

        Album updatedAlbum = new Album(title, newArtist, newGenre);

            boolean updated = dao.update(updatedAlbum);
            if (updated) {
                System.out.println("Album updated successfully.");
            } else {
                System.out.println("Album not found or update failed.");
            }
    }
}
