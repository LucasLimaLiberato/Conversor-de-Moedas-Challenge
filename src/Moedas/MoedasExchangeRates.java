package Moedas;

import java.util.Map;

public record MoedasExchangeRates (String base_code, Map<String, Float> conversion_rates) {
}
