package com.gefa.manufacturer.application.infrastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.gefa.manufacturer.application.domain.events.ManufacturerCreatedEvent;
import com.gefa.manufacturer.application.domain.events.DomainEvent;
import com.gefa.manufacturer.application.domain.events.handlers.DomainEventHandler;


@Singleton
public class DomainEventsDispatcher {

	private Map<Class<? extends DomainEvent>, List<DomainEventHandler>> handlerMap = new HashMap<Class<? extends DomainEvent>, List<DomainEventHandler>>();

	@Inject
	public DomainEventsDispatcher(@Any Instance<DomainEventHandler> handlerList) {
		System.out.println("handlerList isUnsatisfied="+handlerList.isUnsatisfied());

		Iterator<DomainEventHandler> handlerIterator = handlerList.iterator();
		while (handlerIterator.hasNext()) {
			DomainEventHandler handler = handlerIterator.next();
			System.out.println("handler.getClass()="+handler.getClass());
		}
	}

	public void addHandler(Class<? extends DomainEvent> eventType, DomainEventHandler domainEventHandler) {
		List<DomainEventHandler> domainEventHandlers = handlerMap.get(eventType);

		if (null == domainEventHandlers) {
			domainEventHandlers = new ArrayList<DomainEventHandler>();
		}
		domainEventHandlers.add(domainEventHandler);
		handlerMap.put(eventType, domainEventHandlers);
	}

	public void dispatch(DomainEvent domainEvent) {
		System.out.println("domainEvent.getClass()=" + domainEvent.getClass());
		List<DomainEventHandler> handlers = handlerMap.get(domainEvent.getClass());
		System.out.println("handlerMap.size()=" + handlerMap.size());
		System.out.println("handlers="+handlers.size());
		
		for (DomainEventHandler handler : handlers) {
			handler.handle(domainEvent);
		}
	}

}
