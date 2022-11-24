package com.practice.multimodulenotification.batch;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.practice.multimodulenotification.application.NotificationService;
import com.practice.multimodulenotification.domain.Notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class NotificationBatch {

    private final NotificationService notificationService;

    @Transactional
    public void sendNotifications() {
        List<Notification> notifications = notificationService.findAllInCompleted(LocalDateTime.now());

        log.info("[알림 전송 시작]");
        for (Notification notification : notifications) {
            log.info("[알림 전송] {}", notification.getContent());
        }
        log.info("[알림 전송 종료]");

        notificationService.completeAll(notifications);
    }
}
