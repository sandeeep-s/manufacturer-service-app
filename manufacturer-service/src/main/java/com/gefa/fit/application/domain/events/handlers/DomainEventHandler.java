package com.gefa.fit.application.domain.events.handlers;

import com.gefa.fit.application.domain.events.DomainEvent;

public interface DomainEventHandler {

	void handle(DomainEvent domainEvent);

}
