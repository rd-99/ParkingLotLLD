package org.rd99.model.ParkingStrategy;

public interface ParkingStrategy {
    public void addSlot(Integer slotNumber);

    public void removeSlot(Integer slotNumber);

    public int nextSlot();
}
