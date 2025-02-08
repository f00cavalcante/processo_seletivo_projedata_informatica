import Funcionarios.Funcionarios;

import org.json.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.util.*;


public class Principal {


    public static void main(String[] args) throws JSONException, ParseException {
        System.out.println("Olá Mundo! \n");
        System.out.println("Para dar sorte. 🙂 \n");
        System.out.println("Respostas: \n");
        System.out.println("1 - Criado classe com nome Pessoa - OK");
        System.out.println("2 - Criado classe com nome Funcionarios estendida da classe Pessoas - OK");
        System.out.println("3 - Abaixo, dados com a lista criada:");

        List<List> listaFuncionarios = new ArrayList<>();

        String dadosFuncionariosJSON = "[\n" +
                "  {\n" +
                "    \"nome\": \"Maria\",\n" +
                "    \"data_nascimento\": \"2000-10-18\",\n" +
                "    \"salario\": 2009.44,\n" +
                "    \"funcao\": \"Operador\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"João\",\n" +
                "    \"data_nascimento\": \"1990-05-12\",\n" +
                "    \"salario\": 2284.38,\n" +
                "    \"funcao\": \"Operador\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Caio\",\n" +
                "    \"data_nascimento\": \"1961-05-02\",\n" +
                "    \"salario\": 9836.14,\n" +
                "    \"funcao\": \"Coordenador\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Miguel\",\n" +
                "    \"data_nascimento\": \"1988-10-14\",\n" +
                "    \"salario\": 19119.88,\n" +
                "    \"funcao\": \"Diretor\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Alice\",\n" +
                "    \"data_nascimento\": \"1995-01-05\",\n" +
                "    \"salario\": 1582.72,\n" +
                "    \"funcao\": \"Operador\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Heitor\",\n" +
                "    \"data_nascimento\": \"1999-11-19\",\n" +
                "    \"salario\": 2009.44,\n" +
                "    \"funcao\": \"Operador\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Arthur\",\n" +
                "    \"data_nascimento\": \"1993-03-31\",\n" +
                "    \"salario\": 4071.84,\n" +
                "    \"funcao\": \"Contador\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Laura\",\n" +
                "    \"data_nascimento\": \"1994-07-08\",\n" +
                "    \"salario\": 3017.45,\n" +
                "    \"funcao\": \"Gerente\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Heloísa\",\n" +
                "    \"data_nascimento\": \"2003-05-24\",\n" +
                "    \"salario\": 1606.85,\n" +
                "    \"funcao\": \"Eletricista\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"nome\": \"Helena\",\n" +
                "    \"data_nascimento\": \"1996-09-02\",\n" +
                "    \"salario\": 2799.93,\n" +
                "    \"funcao\": \"Gerente\"\n" +
                "  }\n" +
                "]";


//        A partir deste ponto começam as respostas da questão 03

        JSONArray dadosFuncionarios = new JSONArray(dadosFuncionariosJSON);

        for (int i = 0; i < dadosFuncionarios.length(); i++) {

            List listaFuncionarioTemporaria = new ArrayList<>();

            Funcionarios funcionarioTemporario = new Funcionarios();

            funcionarioTemporario.Nome = dadosFuncionarios.getJSONObject(i).get("nome").toString();
            funcionarioTemporario.DataNascimento = LocalDate.parse(dadosFuncionarios.getJSONObject(i).get("data_nascimento").toString());
            funcionarioTemporario.Salario = new BigDecimal(dadosFuncionarios.getJSONObject(i).get("salario").toString());
            funcionarioTemporario.Funcao = dadosFuncionarios.getJSONObject(i).get("funcao").toString();

            listaFuncionarioTemporaria.add(funcionarioTemporario.Nome);
            listaFuncionarioTemporaria.add(funcionarioTemporario.DataNascimento);
            listaFuncionarioTemporaria.add(funcionarioTemporario.Salario);
            listaFuncionarioTemporaria.add(funcionarioTemporario.Funcao);

            listaFuncionarios.add(listaFuncionarioTemporaria);

        }
        System.out.println("3.1 - Lista inserida com todos os funcionários = " + listaFuncionarios.toString());

        for (int i = 0; i < listaFuncionarios.size(); i++) {

            if (listaFuncionarios.get(i).toString().contains("João")) {
                listaFuncionarios.remove(i);
            }
        }
        System.out.println("3.2 - Lista sem o funcionário João = " + listaFuncionarios.toString());

        System.out.println("3.3 - Todos os funcionários com dados formatados:");

        for (List<List> funcionario : listaFuncionarios) {

            DecimalFormat salarioFormatado = new DecimalFormat("#,###,##0.00");

            System.out.print("" +
                    "Nome: " + funcionario.get(0) + " | " +
                    "Data Nascimento: " + funcionario.get(1) + " | " +
                    "Salario: " + salarioFormatado.format((funcionario.get(2))) + " | " +
                    "Função: " + funcionario.get(3) + "\n"
            );
        }

        for (int i = 0; i < listaFuncionarios.size(); i++) {

            BigDecimal percentualAumento = new BigDecimal(1.10);
            BigDecimal salarioAtual = new BigDecimal(listaFuncionarios.get(i).get(2).toString());
            BigDecimal novoSalario = salarioAtual.multiply(percentualAumento).round(MathContext.DECIMAL32);

            listaFuncionarios.get(i).set(2, novoSalario);
        }

        System.out.println("3.4 - Lista com os valores salariais atualizados: " + listaFuncionarios.toString());

        System.out.print("3.8 - Funcionários com aniversário meses 10 e 12: ");
        for (int i = 0; i < listaFuncionarios.size(); i++) {

            LocalDate dataNascimento = LocalDate.parse(listaFuncionarios.get(i).get(1).toString());
            Month mesAniversario = dataNascimento.getMonth();

            if (mesAniversario.toString() == "OCTOBER" || mesAniversario.toString() == "December") {

                System.out.print(listaFuncionarios.get(i).get(0) + " ");
            }

        }
        System.out.println("");

        System.out.print("3.9 – Funcionário com maior idade: ");

        int maiorIdade = 2025;
        int idade = 0;
        String nomeFuncionarioMaisVelho = "";

        for (int i = 0; i < listaFuncionarios.size(); i++) {

            LocalDate dataNascimento = LocalDate.parse(listaFuncionarios.get(i).get(1).toString());
            int anoNascimento = dataNascimento.getYear();

            if (anoNascimento < maiorIdade) {
                maiorIdade = anoNascimento;
                nomeFuncionarioMaisVelho = listaFuncionarios.get(i).get(0).toString();
                idade = LocalDate.now().getYear() - maiorIdade;
            }
        }
        
        System.out.println(nomeFuncionarioMaisVelho + " | " + idade);

        System.out.print("3.11 - Quantidade total dos salários: ");
        BigDecimal somaTotalDosSalarios = new BigDecimal(0);

        for (int i = 0; i < listaFuncionarios.size(); i++) {

            //Neste ponto, seguiria a lógica para efetuar o incremento dos valores à variavel que receberá a soma total
            //Porém, no Java, ao reiniciar o loop, o valor da soma total está sendo reiniciado
            //Confesso que neste ponto, gastei um pouco de tempo para tentar resolver, mas não consegui ainda
            BigDecimal salarioAtual = new BigDecimal(listaFuncionarios.get(i).get(2).toString());
            somaTotalDosSalarios.add(salarioAtual);
        }

        System.out.println(somaTotalDosSalarios);

        System.out.println("3.12 - Quantos salários mínimos cada funcionário recebe:");
        for (int i = 0; i < listaFuncionarios.size(); i++) {

            BigDecimal salarioAtual = new BigDecimal(listaFuncionarios.get(i).get(2).toString());
            BigDecimal valorSalarioMinimo = new BigDecimal("1212.00");
            BigDecimal quantidadeSalariosMinimos = salarioAtual.divide(valorSalarioMinimo, 3, RoundingMode.CEILING);

            System.out.println("Nome: " + listaFuncionarios.get(i).get(0) + " | " + "Qnt. Salário Min.: " + quantidadeSalariosMinimos);
        }
    }
}