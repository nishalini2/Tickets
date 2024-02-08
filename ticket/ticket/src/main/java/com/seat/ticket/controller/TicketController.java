package com.seat.ticket.controller;

import com.seat.ticket.entity.TicketEntity;
import com.seat.ticket.mapper.TicketMapper;
import com.seat.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketMapper ticketMapper;

    @PostMapping("/purchase")
    public ResponseEntity<TicketEntity> purchaseTicket(@RequestBody TicketEntity ticketEntity) {
        TicketEntity createdTicket = ticketService.purchaseTicket(ticketEntity);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketEntity>> getAllTickets() {
        List<TicketEntity> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketEntity> getTicketById(@PathVariable Long id) {
        Optional<TicketEntity> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/section/{section}")
    public ResponseEntity<List<TicketEntity>> getTicketsBySection(@PathVariable String section) {
        List<TicketEntity> tickets = ticketService.getTicketsBySection(section);
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTicket(@PathVariable Long id) {
        ticketService.removeTicket(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketEntity> modifySeat(@PathVariable Long id,
                                                   @RequestParam String section,
                                                   @RequestParam int seat) {
        TicketEntity updatedTicket = ticketService.modifySeat(id, section, seat);
        if (updatedTicket != null) {
            return ResponseEntity.ok(updatedTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Implement other controller methods
}
