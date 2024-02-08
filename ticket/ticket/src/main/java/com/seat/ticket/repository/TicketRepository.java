package com.seat.ticket.repository;

import com.seat.ticket.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity,Long> {

    List<TicketEntity> findBySection(String section);
}
