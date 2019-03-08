package memy.memy.tagspictures;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 60000 ) //1 minute
    public void updatePictures() {

    }
}