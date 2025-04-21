package mk.finki.ukim.mk.lab_1.model.events;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.LocalDateTime;

@Getter
public class AuthorCreatedEvent extends ApplicationEvent {

    private final LocalDateTime when;

    public AuthorCreatedEvent(Object source) {
        super(source);
        this.when = LocalDateTime.now(Clock.systemUTC());
    }

    public AuthorCreatedEvent(Object source, LocalDateTime when) {
        super(source);
        this.when = when;
    }

}
