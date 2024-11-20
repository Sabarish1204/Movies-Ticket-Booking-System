package MovieTicketBooking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Movie> movies=new ArrayList<>();  //Movies Details
        movies.add(new Movie("Amaran",9,100,10));
        movies.add(new Movie("Amaran",12,100,10));
        movies.add(new Movie("Kanguva",9,100,10));
        movies.add(new Movie("LuckyBaskar",12,100,10));

        System.out.println("------ Available Movie Shows ------");
        for(Movie m: movies){
            m.shows();
        }

        Scanner s=new Scanner(System.in);
        boolean flag=true;

        while(flag){
            System.out.println("------------");
            System.out.println("Select the Option\n1.Book Ticket\n2.Available Shows\n3.Cancel Ticket\n4.Exit");
            System.out.println("------------");
            int n=s.nextInt();

            switch (n){
                case 1:
                    System.out.println("Enter Movie Name : ");
                    String name=s.next();
                    System.out.println("Enter Movie Time :");
                    int time=s.nextInt();
                    Booking b=new Booking(name,time);
                    b.book(movies);
                    break;

                case 2:
                    System.out.println("Enter Movie Name :");
                    String view=s.next();
                    System.out.println("Enter Movie Time :");
                    int vtime=s.nextInt();
                    Booking.display(view,vtime,movies);
                    break;

                case 3:
                    System.out.println("Enter the Ticket ID : ");
                    int id=s.nextInt();
                    Booking.cancelTicket(id,movies);
                    break;

                case 4:
                    flag=false;
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }
    }
}
