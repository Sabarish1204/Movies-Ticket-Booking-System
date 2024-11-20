package MovieTicketBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Booking {
    static int id=1;
    String movieName;
    int movieTime;
    int allotedId;
    ArrayList<Booking> list=new ArrayList<>(); //Conatins all the Bookings
    static HashMap<Integer,Booking> map=new HashMap<>();  //To Store and Identify the Booking with the ID
    static HashMap<Integer,int[]> mapTickets=new HashMap<>(); //To Store and Identify the Booked Tickets Details
    public Booking(String movieName,int movieTime){

        this.movieName=movieName;
        this.movieTime=movieTime;
        this.allotedId=id;
    }
    public void book(ArrayList<Movie> movies){
        Scanner s=new Scanner(System.in);
        for(Movie m : movies){
            if(m.getMovieName().equalsIgnoreCase(movieName) && movieTime==m.getMovieTime()){
                System.out.println("Enter number of tickets : ");
                int n=s.nextInt();
                int available=m.getAvailableseats();
                if(n>available){
                    System.out.println(available+" Tickets are available");
                    return;
                }
                else{
                    m.display();
                    int[] tickets=new int[n];
                    System.out.println("Enter the seat Number : ");
                    for(int i=0;i<n;i++){
                        tickets[i]=s.nextInt();
                    }
                    m.setSeats(tickets);
                    available=available-n;
                    m.setAvailableseats(available);
                    System.out.println(n+" Tickets Successfully Booked.Your Ticket id is "+allotedId);
                    list.add(new Booking(movieName,movieTime));
                    map.put(allotedId,new Booking(movieName,movieTime));
                    mapTickets.put(allotedId,tickets);
                    id++;
                }
            }
        }
    }

    public static void cancelTicket(int id,ArrayList<Movie> movies){
        Booking b=map.get(id);
        int[] t=mapTickets.get(id);
        Movie req=null;
        for(Movie m : movies){
            if(m.getMovieName().equalsIgnoreCase(b.movieName) && m.getMovieTime()==b.movieTime){
                req=m;
            }
        }
        req.cancelSeats(t);
        int avail=req.getAvailableseats();
        avail+= t.length;
        req.setAvailableseats(avail);
        System.out.println(t.length+" Tickets "+ Arrays.toString(t)+ " for "+b.movieName+" at "+b.movieTime+"AM is cancelled.");
    }
    public static void display(String movieName,int movieTime,ArrayList<Movie> movies){
        Movie req=null;
        for(Movie m : movies){
            if(m.getMovieName().equalsIgnoreCase(movieName) && m.getMovieTime()==movieTime){
                req=m;
            }
        }
        req.display();
        System.out.println("Available Tickets : "+req.getAvailableseats());
    }
}
