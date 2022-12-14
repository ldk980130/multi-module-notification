package com.practice.multimodulenotification.dto;

import java.time.LocalDateTime;

import com.practice.multimodulenotification.domain.Notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NotificationRequest {

    private String content;
    private LocalDateTime pushTime;

    public Notification toEntity() {
        return Notification.create(content, pushTime);
    }
}
