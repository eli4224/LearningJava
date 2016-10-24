import info.gridworld.actor.Bug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

import java.util.ArrayList;

public class Arrow extends Actor{
  
  public Arrow() {
    this(new Color(0,0,255));
  }
  
  
  public Arrow(Color c) {
    super();
    setColor(c);
  }
  
  
  @Override
  public void act() {
    Location objectlocation = getLocation();
    int smallestdistance = Integer.MAX_VALUE;
    Grid<Actor> gr = super.getGrid();
    ArrayList<Location> locs = gr.getOccupiedLocations();
    if (locs.isEmpty()) {
      return;
    }
    for(int i = 0; i < locs.size(); i++) {
      Location other = locs.get(i);
      if(other.equals(super.getLocation())) 
           continue;
      int banana = distanceBetween(super.getLocation(), other);
      if (smallestdistance > banana) {
        objectlocation = other;
        smallestdistance = banana;
      }
    }
    super.setDirection(getLocation().getDirectionToward(objectlocation)); 
    
  }
  
  public static int distanceBetween(Location a, Location b) {
    return Math.max(Math.abs(a.getCol() - b.getCol()), Math.abs(a.getRow() - b.getRow()));
  }
  
}