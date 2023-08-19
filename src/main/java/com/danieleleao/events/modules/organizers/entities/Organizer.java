package com.danieleleao.events.modules.organizers.entities;

import com.danieleleao.events.shared.entities.BaseEntityUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "organizers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organizer  extends BaseEntityUser {


    private String address;
    private String responsible;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
