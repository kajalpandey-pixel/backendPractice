package com.example.demo.services;


import com.example.demo.model.Flight;
import com.example.demo.repositories.FlightRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {


    private final FlightRepository flightRepository  ;




    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository ;
    }


    public List<Flight> getAllFlightInfo() {
        return flightRepository.findAll(); // Calls the repository method
    }

    public Flight addFlightInfo(Flight flight){
        return flightRepository.save(flight) ;
    }

    public Flight updateFlightDetails(Long id , Flight flight){
          Flight prevFlight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"))  ;
          prevFlight.setSource(flight.getSource());
        prevFlight.setDestination(flight.getDestination());
         prevFlight.setDepartureTime(flight.getDepartureTime());
        prevFlight.setTotalSeats(flight.getTotalSeats());
        prevFlight.setTicketPrice(flight.getTicketPrice());
        prevFlight.setBooked(flight.isBooked());

        return flightRepository.save(prevFlight);
    }

}
