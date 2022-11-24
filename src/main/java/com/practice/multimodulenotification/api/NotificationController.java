package com.practice.multimodulenotification.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multimodulenotification.api.dto.NotificationRequest;
import com.practice.multimodulenotification.api.dto.NotificationResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationApiService notificationService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NotificationRequest request) {
        Long notificationId = notificationService.create(request);
        return ResponseEntity.created(URI.create("/notifications/" + notificationId))
            .build();
    }

    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getCompleted() {
        return ResponseEntity.ok(notificationService.findAllCompleted());
    }
}


