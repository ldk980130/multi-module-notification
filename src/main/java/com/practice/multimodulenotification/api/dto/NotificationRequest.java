package com.practice.multimodulenotification.api.dto;

import java.time.LocalDateTime;

import com.practice.multimodulenotification.common.Notification;

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
