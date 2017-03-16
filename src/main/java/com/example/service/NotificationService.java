package com.example.service;

import com.example.service.impl.NotificationServiceImpl;

/**
 * Created by albertomartinez on 15/03/17.
 */
public interface NotificationService {
    boolean sendNotification(NotificationServiceImpl.NotificationDef definition);

    NotificationServiceImpl.NotificationDefBuilder getNotificationDefBuilder();
}
