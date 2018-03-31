package com.gefa.manufacturer.application.domain.events.handlers;

import com.gefa.manufacturer.application.domain.events.DomainEvent;

public interface DomainEventHandler {

	void handle(DomainEvent domainEvent);

}
