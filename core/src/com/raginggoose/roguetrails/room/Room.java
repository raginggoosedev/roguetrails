package com.raginggoose.roguetrails.room;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public abstract class Room {

    //width and height
    public abstract int getWidth();
    public abstract int getHeight();

    //adjacent rooms
    public abstract Room getNorth();
    public abstract Room getEast();
    public abstract Room getSouth();
    public abstract Room getWest();
    public abstract void setNorth(Room room);
    public abstract void setEast(Room room);
    public abstract void setSouth(Room room);
    public abstract void setWest(Room room);

    //room type
    public abstract RoomType getRoomType();

    //to draw
    public abstract void draw(int x, int y, ShapeRenderer shape); //to draw room

}
