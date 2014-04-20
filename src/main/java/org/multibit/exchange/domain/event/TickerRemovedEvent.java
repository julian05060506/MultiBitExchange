package org.multibit.exchange.domain.event;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.multibit.exchange.domain.model.CurrencyPair;
import org.multibit.exchange.infrastructure.adaptor.eventapi.ExchangeId;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * <p>Event used to indicate that a {@link CurrencyPair} was removed from an Exchange.</p>
 *
 * @since 0.0.1
 *  
 */
public class TickerRemovedEvent {

  @TargetAggregateIdentifier
  private final ExchangeId exchangeId;

  private final String tickerSymbol;

  public TickerRemovedEvent(ExchangeId exchangeId, CurrencyPair currencyPair) {
    this(exchangeId, currencyPair.getTicker().getSymbol());
  }

  public TickerRemovedEvent(ExchangeId exchangeId, String tickerSymbol) {
    checkNotNull(exchangeId, "exchangeId must not be null");
    checkNotNull(tickerSymbol, "tickerSymbol must not be null");

    this.exchangeId = exchangeId;
    this.tickerSymbol = tickerSymbol;
  }

  public ExchangeId getExchangeId() {
    return exchangeId;
  }

  public String getTickerSymbol() {
    return tickerSymbol;
  }

  @Override
  public String toString() {
    return "CurrencyPairRegisteredEvent{" +
        "exchangeId=" + exchangeId +
        ", tickerSymbol=" + tickerSymbol +
        '}';
  }
}
