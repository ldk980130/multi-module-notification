package com.practice.modulecommon;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime pushTime;

    @Enumerated(EnumType.STRING)
    private PushStatus pushStatus;

    private Notification(String content, LocalDateTime pushTime, PushStatus pushStatus) {
        this.content = content;
        this.pushTime = pushTime;
        this.pushStatus = pushStatus;
    }

    public static Notification create(String content, LocalDateTime pushTime) {
        return new Notification(content, pushTime, PushStatus.IN_COMPLETED);
    }
}
