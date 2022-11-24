package com.practice.moduleapi.dto;

import com.practice.modulecommon.Notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NotificationResponse {

    private Long notificationId;
    private String content;

    public NotificationResponse(Notification notification) {
        this.notificationId = notification.getId();
        this.content = notification.getContent();
    }
}
