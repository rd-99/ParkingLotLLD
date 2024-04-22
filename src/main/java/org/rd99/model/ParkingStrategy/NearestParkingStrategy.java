package org.rd99.model.ParkingStrategy;

import org.rd99.exception.SlotAlreadyOccupiedException;
import org.rd99.model.ParkingLot;
import org.rd99.model.Slot;

import java.util.Map;
import java.util.TreeSet;

public class NearestParkingStrategy implements ParkingStrategy{
    TreeSet<Integer> slotsSet;
    NearestParkingStrategy(){
        this.slotsSet = new TreeSet<>();
    }
    @Override
    public void addSlot(Integer slotNum){
        if(this.slotsSet.contains(slotNum)){
            throw new SlotAlreadyOccupiedException();
        }
        this.slotsSet.add(slotNum);
    }

    @Override
    public void removeSlot(Integer slotNum) {
        this.slotsSet.remove(slotNum);
    }

    @Override
    public int nextSlot() {
        return this.slotsSet.first();
    }


}
