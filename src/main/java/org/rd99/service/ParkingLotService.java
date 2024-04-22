package org.rd99.service;

import org.rd99.exception.ParkingLotException;
import org.rd99.model.Car;
import org.rd99.model.ParkingLot;
import org.rd99.model.ParkingStrategy.ParkingStrategy;
import org.rd99.model.Slot;

import java.util.List;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public ParkingLotService(ParkingLot parkingLot , ParkingStrategy parkingStrategy){
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
    }

    public void createParkingLot(final ParkingLot parkingLot ,final ParkingStrategy parkingStrategy){
        if(this.parkingLot != null){
            throw new ParkingLotException();
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= parkingLot.getCapacity(); i++){
            parkingStrategy.addSlot(i);
        }
    }

    /**
     * Parks a {@link Car} into the parking lot. {@link ParkingStrategy} is used to decide the slot
     * number and then the car is parked into the {@link ParkingLot} into that slot number.
     *
     * @param car Car to be parked.
     * @return Slot number in which the car is parked.
     */
    public int park(final Car car) throws Exception {
        doesParkingLotExists();
        final Integer nextFreeSlot = parkingStrategy.nextSlot();
        parkingLot.park(car,nextFreeSlot);
        parkingStrategy.removeSlot(nextFreeSlot);
        return nextFreeSlot;
    }

    public List<Slot> getSlotsFOrColor(final String color){
        final List<Slot> occupiedSLots = ge
    }

    public void doesParkingLotExists() throws Exception {
        if(parkingLot == null){
            throw  new Exception("Parking Lot does not exist");
        }
    }
}
