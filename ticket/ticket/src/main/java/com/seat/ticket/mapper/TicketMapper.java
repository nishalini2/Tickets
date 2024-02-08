package com.seat.ticket.mapper;

import com.seat.ticket.dto.TicketDto;
import com.seat.ticket.entity.TicketEntity;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketDto toDto(TicketEntity ticketEntity) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setFirstName(ticketEntity.getFirstName());
        ticketDto.setLastName(ticketEntity.getLastName());
        ticketDto.setEmail(ticketEntity.getEmail());
        ticketDto.setSection(ticketEntity.getSection());
        ticketDto.setSeat(ticketEntity.getSeat());
        return ticketDto;
    }

    public TicketEntity toEntity(TicketDto ticketDto) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setFirstName(ticketDto.getFirstName());
        ticketEntity.setLastName(ticketDto.getLastName());
        ticketEntity.setEmail(ticketDto.getEmail());
        ticketEntity.setSection(ticketDto.getSection());
        ticketEntity.setSeat(ticketDto.getSeat());
        return ticketEntity;

    }
}
