package Funcionarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class IdadeDosFuncionarios {

     public Map<String, Map<String, String>> DicionarioDataNascimentoFuncionario = new HashMap<>();

     public IdadeDosFuncionarios(List<Map<String, Map<String, String>>> ListaDosFuncionarios) {

          for (Map<String, Map<String, String>> funcionario : ListaDosFuncionarios) {

               Map<String, String> dadosDoNascimentoDoFuncionarioTemporario = new HashMap<>();

               DateTimeFormatter formatarDataDeNascimento = DateTimeFormatter.ofPattern("yyyy-MM-dd");

               for (Map.Entry<String, Map<String, String>> dados : funcionario.entrySet()) {

                    Set<Map.Entry<String, String>> dadosDoFuncionario = dados.getValue().entrySet();

                    for (Map.Entry<String, String> dadosDoFuncionarioNascimento : dadosDoFuncionario) {

                         if (dadosDoFuncionarioNascimento.getKey().equals("Data Nascimento")) {

                              LocalDate dataNascimentoFuncionario = LocalDate.parse(dadosDoFuncionarioNascimento.getValue().toString(), formatarDataDeNascimento);
                              long idadeDoFuncionario = dataNascimentoFuncionario.until(LocalDate.now(), ChronoUnit.YEARS);

                              dadosDoNascimentoDoFuncionarioTemporario.put("Data Nascimento", dataNascimentoFuncionario.toString());
                              dadosDoNascimentoDoFuncionarioTemporario.put("Mês Nascimento", String.valueOf(dataNascimentoFuncionario.getMonthValue()));
                              dadosDoNascimentoDoFuncionarioTemporario.put("Idade", Long.toString(idadeDoFuncionario));

                         }
                    }

                    DicionarioDataNascimentoFuncionario.put(dados.getKey(), dadosDoNascimentoDoFuncionarioTemporario);
               }
          }
     }

     public String FuncionarioMaisVelho() {

          int idadeDoFuncionarioMaisVelho = 0;
          String nomeDoFuncionarioMaisVelho = new String();

          for (String funcionario : DicionarioDataNascimentoFuncionario.keySet()) {

               if (Integer.valueOf(DicionarioDataNascimentoFuncionario.get(funcionario).get("Idade")) > idadeDoFuncionarioMaisVelho) {

                    idadeDoFuncionarioMaisVelho = Integer.valueOf(DicionarioDataNascimentoFuncionario.get(funcionario).get("Idade"));
                    nomeDoFuncionarioMaisVelho = funcionario;
               }
          }

          return nomeDoFuncionarioMaisVelho;
     }
}