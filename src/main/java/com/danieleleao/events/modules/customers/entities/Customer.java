package com.danieleleao.events.modules.customers.entities;

import com.danieleleao.events.shared.entities.BaseEntityUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "customers")
public class Customer extends BaseEntityUser {


    private String name;
    private String document;
    private String phone;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
