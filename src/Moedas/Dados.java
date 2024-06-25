package Moedas;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Dados {

    // ------------------- Declarando as variáveis
    protected String pesquisaDeURL;
    protected String json;
    protected Gson gson;
    protected MoedasExchangeRates moedaConvertida;

    protected float usd; // United States Dollar
    protected float brl; // Brazilian Real
    protected float ars; // Argentine Peso
    protected float eur; // European Union Euro
    protected float jpy; // Japanese Yen
    protected float krw; // South Korea Won
    protected float cny; // Chinese Renminbi

    protected Map<String, Float> conjuntoDeMoedas;
    protected String parametro;

    // -------------------- Construtores
    public Dados() {
        this.gson = new Gson();
    }

    public Dados(MoedasExchangeRates moedaConvertida) {
        this.parametro = moedaConvertida.base_code();
        this.conjuntoDeMoedas = moedaConvertida.conversion_rates();

        this.usd = moedaConvertida.conversion_rates().get("USD");
        this.brl = moedaConvertida.conversion_rates().get("BRL");
        this.ars = moedaConvertida.conversion_rates().get("ARS");
        this.eur = moedaConvertida.conversion_rates().get("EUR");
        this.jpy = moedaConvertida.conversion_rates().get("JPY");
        this.krw = moedaConvertida.conversion_rates().get("KRW");
        this.cny = moedaConvertida.conversion_rates().get("CNY");
    }

    // -------------------- Acessando a API
    public HttpResponse<String> getResponse() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(pesquisaDeURL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        this.json = response.body();
        moedaConvertida = gson.fromJson(json, MoedasExchangeRates.class);
        return response;
    }

    // -------------------  GETTERs and SETTERs

    public void setPesquisaDeURL(String pesquisaDeURL) {
        this.pesquisaDeURL = "https://v6.exchangerate-api.com/v6/d4eeaeccf2593e79326e17f2/latest/" + pesquisaDeURL;
    }

    public MoedasExchangeRates getMoedaConvertida() {
        return moedaConvertida;
    }

    public String getParametro() {
        return parametro;
    }

    public float getUsd() {
        return usd;
    }

    public float getBrl() {
        return brl;
    }

    public float getEur() {
        return eur;
    }

    public float getArs() {
        return ars;
    }

    public float getJpy() {
        return jpy;
    }

    public float getKrw() {
        return krw;
    }

    public float getCny() {
        return cny;
    }

    // -------------------- toString
    @Override
    public String toString() {
        return "Base do Código = " + parametro + " - USD: " + usd + " - Taxas de Câmbio = " + conjuntoDeMoedas;
    }
}
