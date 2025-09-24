package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(name = "event_date")
    private String date;   // 👉 use getDate(), setDate()

    @Column(name = "event_time")
    private String time;   // 👉 use getTime(), setTime()

    @Column(name = "event_type")
    private String type;   // 👉 use getType(), setType()

    private String location;
}
