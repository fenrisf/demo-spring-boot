package com.example;

import com.example.service.NotificationService;
import com.example.service.impl.NotificationServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by albertomartinez on 15/03/17.
 */
public class NotificationServiceImplTest {
    @Mock
    NotificationServiceImpl.NotificationDef notificationDefinition;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    NotificationService sut;

    @Before
    public void init(){
        sut = new NotificationServiceImpl();
    }
    @Test
    public void ShouldReturnSendResultOnNotificationDefSending(){
        //given
        when(notificationDefinition.getTo()).thenReturn("pepe");

        //when - then
        assertThat(sut.sendNotification(notificationDefinition)).isFalse();

    }
}
