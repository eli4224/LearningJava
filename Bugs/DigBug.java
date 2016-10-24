import info.gridworld.actor.Bug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class DigBug extends Bug{
  //create digbug w/ random color
  public DigBug() {
    this(generaterandomcolor());
  }
  
  //Creates digbug w/ given color
  public DigBug(Color c) {
    super(c);
  } 
  
  @Override
  public void move() {
    Grid<Actor> gr = getGrid();
    if (gr == null)
      return;
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(getDirection());
    if (gr.isValid(next))
      moveTo(next);
    else
      removeSelfFromGrid();
    Rock flower = new Rock(getColor());
    flower.putSelfInGrid(gr, loc);
  }
  
  public static Color generaterandomcolor() {
    return new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
    
    
  }
  
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld();
    world.add(new Bug());
    world.add(new Rock());
    world.add(new DigBug());
    world.show();
  }
}