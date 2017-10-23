package utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import persistance.entities.Account;
import dataObjects.Player;
import dataObjects.Room;


public class RoomsManager {

    private static RoomsManager instance;

    /**
     * singleton method
     * @return the manager instance
     */
    public static RoomsManager instance() {
	if (instance == null) {
	    instance = new RoomsManager();
        }
		return instance;
    }

    /**
         * class members
         */
    private ConcurrentMap<Integer, Room> rooms = new ConcurrentHashMap<Integer, Room>();
    private AtomicInteger id = new AtomicInteger(2);

    /**
         * class c'tor
         */
    private RoomsManager() {

    }

    /**
     * create a new room and add it into the rooms list
     * @param name - the new room name
     * @return the new room
     */
    public Room createRoom(int id, String name, String roomType) {
        Room r = null;
	if (roomGame.equalsIgnoreCase("TYPE1")) {
	    r = new Room(id, name);
	}

	this.rooms.put(id, r);
	return r;
    }
	
    /**
     * remove a room from the system
     * @param roomId - the room id to remove
     */
    public void deleteRoom(int roomId) {
	this.rooms.remove(roomId);
    }
	
    public int getNextRoomId() {
	return this.id.incrementAndGet();
    }

    /**
     * fetch all the rooms 
     * @return list of rooms
     */
    public Collection<Room> getRooms() {
	return this.rooms.values();
    }

    /**
     * fetch a room by room id 
     * @param id  - the id to search
     * @return Room instance
    */
    public Room getRoom(int id) {
	return this.rooms.get(id);
    }
}