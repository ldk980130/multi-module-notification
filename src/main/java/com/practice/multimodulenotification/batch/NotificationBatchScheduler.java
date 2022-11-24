package com.practice.multimodulenotification.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationBatchScheduler {

    private final NotificationBatch notificationBatch;

    @Scheduled(fixedDelay = 5000)
    public void execute() {
        notificationBatch.sendNotifications();
    }
}
