/*
 * City.java
 * Models a city
 */

package sa;

import java.util.ArrayList;

public  class City {
    int city_id;
    int x;
    int y;


    public City(){
    }

    // Constructs a city at chosen x, y location
    public City(int id, int x, int y){
        this.city_id = id;
        this.x = x;
        this.y = y;
    }

    public int getCity_id(){
        return this.city_id;
    }

    // Gets city's x coordinate
    public int getX(){
        return this.x;
    }

    // Gets city's y coordinate
    public int getY(){
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Gets the distance to given city
//    public double distanceTo(City city){
//        int xDistance = Math.abs(getX() - city.getX());
//        int yDistance = Math.abs(getY() - city.getY());
//        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
//
//        return distance;
//    }

    @Override
    public String toString(){
        return getCity_id() + ", " + getX()+", "+getY() ;
    }
}