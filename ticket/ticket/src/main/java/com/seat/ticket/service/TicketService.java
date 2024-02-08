package com.seat.ticket.service;

import com.seat.ticket.entity.TicketEntity;
import com.seat.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketEntity purchaseTicket(TicketEntity ticketEntity) {
        String section = ticketEntity.getSeat() <= 50 ? "A" : "B"; // Assuming 50 seats in each section
        int seatNumber = ticketEntity.getSeat() <= 50 ? ticketEntity.getSeat() : ticketEntity.getSeat() - 50;
        ticketEntity.setSection(section);
        ticketEntity.setSeat(seatNumber);
        ticketEntity.setPricePaid(20);
        return ticketRepository.save(ticketEntity);
    }

    public List<TicketEntity> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<TicketEntity> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public List<TicketEntity> getTicketsBySection(String section) {
        return ticketRepository.findBySection(section);
    }

    public void removeTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public TicketEntity modifySeat(Long id, String section, int seat) {
        Optional<TicketEntity> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            TicketEntity ticket = optionalTicket.get();
            ticket.setSection(section);
            ticket.setSeat(seat);
            return ticketRepository.save(ticket);
        }
        return null;
    }

}
