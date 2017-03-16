package com.example.service.impl;

import com.example.service.NotificationService;
import org.springframework.stereotype.Service;

/**
 * Created by albertomartinez on 15/03/17.
 */
@Service
public class NotificationServiceImpl implements NotificationService{

    public class NotificationDef{
        private String to;
        protected NotificationDef (String to){
            this.to = to;
        }

        public String getTo() {
            return to;
        }
    }

    public class NotificationDefBuilder{
        private String to;

        public NotificationDefBuilder withTo(String to){
            this.to = to;
            return this;
        }

        public NotificationDef build(){
            return new NotificationDef(this.to);
        }
    }

    @Override
    public boolean sendNotification(NotificationDef definition){
        return false;
    }

    @Override
    public NotificationDefBuilder getNotificationDefBuilder(){
        return new NotificationDefBuilder();
    }
}
