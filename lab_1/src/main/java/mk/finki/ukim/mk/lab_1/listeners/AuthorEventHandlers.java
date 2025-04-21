package mk.finki.ukim.mk.lab_1.listeners;

import mk.finki.ukim.mk.lab_1.model.domain.Author;
import mk.finki.ukim.mk.lab_1.model.events.AuthorCreatedEvent;
import mk.finki.ukim.mk.lab_1.service.domain.AuthorService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuthorEventHandlers {

    private final AuthorService authorService;

    public AuthorEventHandlers(AuthorService authorService) {
        this.authorService = authorService;
    }

    @EventListener
    public void onAuthorCreated(AuthorCreatedEvent event) {
        authorService.refreshMaterializedView();
    }

}
