package MovieTicketBooking;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
    private String movieName;
    private int movieTime;
    private int availableseats;
    private int[][] seats;

    public Movie(String movieName,int movieTime,int availableseats,int n){
        this.movieName=movieName;
        this.movieTime=movieTime;
        this.availableseats=availableseats;
        this.seats=new int[n][n];
        int c=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                this.seats[i][j]=c;
                c++;
            }
        }
    }
    public String getMovieName(){
        return movieName;
    }
    public int getMovieTime(){
        return movieTime;
    }
    public int getAvailableseats(){
        return availableseats;
    }
    public void setAvailableseats(int n){
        availableseats=n;
    }
    public void setSeats(int[] tickets){

        for(int k=0;k<tickets.length;k++){
            for(int i=0;i<seats.length;i++){
                for (int j = 0; j < seats.length; j++) {
                    if(this.seats[i][j]==tickets[k]){
                        this.seats[i][j]=-1;
                    }
                }
            }
            //this.seats[tickets[i]]=-1;
        }
    }
    public void cancelSeats(int[] tickets){
        for (int k = 0; k < tickets.length; k++) {
            int c=1;
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats.length; j++) {
                    if(c==tickets[k] && this.seats[i][j]==-1){
                        this.seats[i][j]=c;
                    }
                    c++;
                }
            }
            //this.seats[tickets[i]]=tickets[i];
        }
    }
    public void display(){
        System.out.println("------------Screen-------------");
        for (int i = 0; i < seats.length; i++) {
            System.out.println(Arrays.toString(seats[i]));
        }
        System.out.println();
    }
    public void shows(){
        System.out.println("Movie : "+movieName+" -> Time : "+movieTime+"AM");
    }
}
