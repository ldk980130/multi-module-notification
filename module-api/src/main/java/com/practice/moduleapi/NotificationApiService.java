package com.practice.moduleapi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.moduleapi.dto.NotificationRequest;
import com.practice.moduleapi.dto.NotificationResponse;
import com.practice.modulecommon.Notification;
import com.practice.modulecommon.PushStatus;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NotificationApiService {

    private final NotificationApiRepository notificationRepository;

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
}
