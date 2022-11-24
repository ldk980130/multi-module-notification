package com.practice.modulebatch;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.modulecommon.Notification;
import com.practice.modulecommon.PushStatus;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NotificationBatchService {

    private final NotificationBatchRepository notificationRepository;

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