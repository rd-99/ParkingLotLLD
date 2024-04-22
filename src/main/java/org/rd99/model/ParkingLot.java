package org.rd99.model;

import org.rd99.exception.ParkingLotException;
import org.rd99.exception.SlotAlreadyOccupiedException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Map<Integer , Slot> slots;
    private int capacity;
    private static final int MAX_CAPACITY = 10_000;

    public ParkingLot(int capacity){
        if(capacity <= 0 || capacity > MAX_CAPACITY){
            throw new ParkingLotException();
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }
    public Map<Integer,Slot> getSlots(){
        return slots;
    }

    private Slot getSlot(final Integer slotNumber){
        if(slotNumber <= 0 || slotNumber > MAX_CAPACITY){
            throw new ParkingLotException();
        }
        final Map<Integer , Slot> slots = getSlots();
        if(slots.containsKey(slotNumber)){
            return slots.get(slotNumber);
        }
        else{
            slots.put(slotNumber, new Slot(slotNumber));
        }
        return slots.get(slotNumber);
    }

    public Slot park(final Car car ,Integer slotNumber){
        final Slot slot = getSlot(slotNumber);
        if(!slot.isSlotFree()){
            throw new SlotAlreadyOccupiedException();
        }
        slot.assignCar(car);
        return slot;
    }

    public Slot makeSlotFree(Integer slotNumber){
        final Slot slot = getSlot(slotNumber);
        slot.unassignCar();
        return slot;
    }


    public int getCapacity() {
        return capacity;
    }
}
