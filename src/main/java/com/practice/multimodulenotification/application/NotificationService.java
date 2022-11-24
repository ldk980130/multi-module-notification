package com.practice.multimodulenotification.application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.multimodulenotification.dto.NotificationRequest;
import com.practice.multimodulenotification.dto.NotificationResponse;
import com.practice.multimodulenotification.domain.Notification;
import com.practice.multimodulenotification.domain.NotificationRepository;
import com.practice.multimodulenotification.domain.PushStatus;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Transactional
    public Long create(NotificationRequest request) {
        Notification notification = notificationRepository.save(request.toEntity());
        return notification.getId();
    }

    public List<NotificationResponse> findAllCompleted() {
        return notificationRepository.findByPushStatus(PushStatus.COMPLETED)
            .stream()
            .map(NotificationResponse::new)
            .collect(Collectors.toList());
    }

    public List<Notification> findAllInCompleted(LocalDateTime time) {
        return notificationRepository.findByPushStatusAndPushTimeIsBefore(PushStatus.IN_COMPLETED, time);
    }

    @Transactional
    public void completeAll(List<Notification> notifications) {
        List<Long> ids = notifications.stream()
            .map(Notification::getId)
            .collect(Collectors.toList());
        notificationRepository.completeAll(ids);
    }
}
