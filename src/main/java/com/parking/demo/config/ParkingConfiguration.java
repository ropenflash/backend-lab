package com.parking.demo.config;

import com.parking.demo.model.ParkingSlot;
import com.parking.demo.model.VehicleType;
import com.parking.demo.repository.ParkingSlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParkingConfiguration {

    @Bean
    public CommandLineRunner initializeSlots(
            ParkingSlotRepository parkingSlotRepository) {

        return args -> {

            parkingSlotRepository.save(
                    new ParkingSlot("C1", VehicleType.CAR));

            parkingSlotRepository.save(
                    new ParkingSlot("C2", VehicleType.CAR));

            parkingSlotRepository.save(
                    new ParkingSlot("B1", VehicleType.BIKE));

            parkingSlotRepository.save(
                    new ParkingSlot("B2", VehicleType.BIKE));

            parkingSlotRepository.save(
                    new ParkingSlot("T1", VehicleType.TRUCK));
        };
    }
}
