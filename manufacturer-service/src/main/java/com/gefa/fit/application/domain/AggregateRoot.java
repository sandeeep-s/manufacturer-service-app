package com.gefa.fit.application.domain;

import java.util.ArrayList;
import java.util.List;

import com.gefa.fit.application.domain.events.DomainEvent;

public abstract class AggregateRoot {

	private List<DomainEvent> domainEvents;

	public void addDomainEvent(DomainEvent domainEvent) {
		if (null == domainEvents) {
			domainEvents = new ArrayList<DomainEvent>();
		}

		domainEvents.add(domainEvent);
	}

	public void clearDomainEvents() {
		domainEvents = new ArrayList<DomainEvent>();
	}

	public List<DomainEvent> getDomainEvents() {
		return domainEvents;
	}
}
