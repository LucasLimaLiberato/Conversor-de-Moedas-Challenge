package Principal;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;
import Moedas.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String ligado = "";



        System.out.println("""
                    ╔═╗╔══╗╔═╦═╗╔══╗╔══╗╔═╗  ╔═╗╔═╗╔═╦╗╔╗─╔╗╔═╗╔═╗╔══╗╔═╗╔═╗
                    ║╔╝║╔╗║║║║║║║╔╗║╚║║╝║║║  ║╔╝║║║║║║║║╚╦╝║║╦╝║╬║║══╣║║║║╬║
                    ║╚╗║╠╣║║║║║║║╔╗║╔║║╗║║║  ║╚╗║║║║║║║╚╗║╔╝║╩╗║╗╣╠══║║║║║╗╣
                    ╚═╝╚╝╚╝╚╩═╩╝╚══╝╚══╝╚═╝  ╚═╝╚═╝╚╩═╝─╚═╝─╚═╝╚╩╝╚══╝╚═╝╚╩╝
                    ───────────────────────  ───────────────────────────────""");

        System.out.println("""
                    BEM VINDO AO CAMBIO CONVERSOR!
                    
                    Aqui você pode indicar qual moeda você quer converter um valor e ela irá ser convertida por algumas 
                    das moedas mais importantes do mercado mundial!
                    """);

        while (ligado!="SAIR") {
            System.out.println(String.format("""
                    Digite uma moeda em que você deseja converter o valor. Algumas sugestões aqui:
                    ---------------------
                    ARS - Peso Argentino
                    USD - Dolar dos Estados Unidos
                    BRL - Real Brasileiro
                    JPY	- Yen Japonês
                    EUR	- Euro
                    CNY	- Renminbi Chinês
                    KRW	- Won sul-coreano
                    
                    Você pode visitar a documentação para consultar as moedas suportadas no nosso programa:
                    
                    https://www.exchangerate-api.com/docs/supported-currencies
                    
                    Ou digite SAIR para encerrar o programa:
                    """));

            Dados dados = new Dados();
            Scanner escrita = new Scanner(System.in);
            var pesquisa = escrita.nextLine();

            if (pesquisa.equals("SAIR")) {
                break;
            }

            dados.setPesquisaDeURL(pesquisa);
            HttpResponse<String> responseTest = dados.getResponse();
            Dados minhaPesquisa = new Dados(dados.getMoedaConvertida());

            System.out.println(String.format("""
                    ------------------ VALORES DA MOEDA %s ----------------
                    
                    ARS - Peso Argentino.....................%.4f
                    USD - Dolar dos Estados Unidos...........%.4f
                    BRL - Real Brasileiro....................%.4f
                    JPY	- Yen Japonês........................%.4f
                    EUR	- Euro...............................%.4f
                    CNY	- Renminbi Chinês....................%.4f
                    KRW	- Won sul-coreano....................%.4f
                   
                    """, minhaPesquisa.getParametro(), minhaPesquisa.getArs(), minhaPesquisa.getUsd(),
                    minhaPesquisa.getBrl(), minhaPesquisa.getJpy(), minhaPesquisa.getEur(), minhaPesquisa.getCny(),
                    minhaPesquisa.getKrw()));

            System.out.println("""
                    Agora digite o valor que deseja converter:
                    """);
            Scanner entradaValor = new Scanner(System.in);
            var valorDigitado = entradaValor.nextFloat();

            float valorConvertidoARS = valorDigitado * minhaPesquisa.getArs();
            float valorConvertidoUSD = valorDigitado * minhaPesquisa.getUsd();
            float valorConvertidoBRL = valorDigitado * minhaPesquisa.getBrl();
            float valorConvertidoJPY = valorDigitado * minhaPesquisa.getJpy();
            float valorConvertidoEUR = valorDigitado * minhaPesquisa.getEur();
            float valorConvertidoCNY = valorDigitado * minhaPesquisa.getCny();
            float valorConvertidoKRW = valorDigitado * minhaPesquisa.getKrw();

            System.out.println(String.format("""
                    ------------------ VALORES CONVERTIDOS %s ----------------
                    
                    ARS - Peso Argentino.....................%.4f
                    USD - Dolar dos Estados Unidos...........%.4f
                    BRL - Real Brasileiro....................%.4f
                    JPY	- Yen Japonês........................%.4f
                    EUR	- Euro...............................%.4f
                    CNY	- Renminbi Chinês....................%.4f
                    KRW	- Won sul-coreano....................%.4f
                   
                    """, minhaPesquisa.getParametro(), valorConvertidoARS, valorConvertidoUSD,
                    valorConvertidoBRL, valorConvertidoJPY, valorConvertidoEUR, valorConvertidoCNY,
                    valorConvertidoKRW));

        }

    }
}