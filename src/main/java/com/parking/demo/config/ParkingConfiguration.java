package com.parking.demo.config;

import com.parking.demo.model.ParkingFloor;
import com.parking.demo.model.ParkingLot;
import com.parking.demo.model.ParkingSlot;
import com.parking.demo.model.VehicleType;
import com.parking.demo.repository.ParkingLotRepository;
import com.parking.demo.repository.ParkingSlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ParkingConfiguration {

    @Bean
    public CommandLineRunner initializeSlots(
            ParkingLotRepository parkingLotRepository) {

        return args -> {

            List<ParkingSlot>slots= List.of(new ParkingSlot("C1", VehicleType.CAR),new ParkingSlot("C2", VehicleType.CAR), new ParkingSlot("B1", VehicleType.BIKE), new ParkingSlot("B2", VehicleType.BIKE), new ParkingSlot("T1", VehicleType.TRUCK) );

            ParkingFloor f1= new ParkingFloor("F1", slots );

            parkingLotRepository.save(new ParkingLot("L1", List.of(f1)));
        };
    }
}
