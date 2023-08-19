package com.danieleleao.events.modules.events.entities;

import com.danieleleao.events.modules.organizers.entities.Organizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String address;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String description;
    private BigDecimal price;
    private int quantity;
    private int availableQuantity;

    @ManyToOne()
    @JoinColumn(name = "organizer_id", insertable = false, updatable = false)
    private Organizer organizer;

    @Column(name = "organizer_id")
    private UUID organizerId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
