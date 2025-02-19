package Funcionarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IdadeDosFuncionarios {

     public Map<String, Map<String, String>> DicionarioDataNascimentoFuncionario = new HashMap<>();

     public IdadeDosFuncionarios(List<Map<String, Map<String, String>>> ListaDosFuncionarios) {

          for (Map<String, Map<String, String>> funcionario : ListaDosFuncionarios) {

               for (Map<String, String> dados : funcionario.values()) {

                    DateTimeFormatter formatarDataDeNascimento = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dataNascimentoFuncionario = LocalDate.parse(dados.get("Data Nascimento"), formatarDataDeNascimento);
                    long idadeDoFuncionario = dataNascimentoFuncionario.until(LocalDate.now(), ChronoUnit.YEARS);

                    Map<String, String> dadosDoNascimentoDoFuncionarioTemporario = new HashMap<>();
                    dadosDoNascimentoDoFuncionarioTemporario.put("Data Nascimento", dataNascimentoFuncionario.toString());
                    dadosDoNascimentoDoFuncionarioTemporario.put("Mês Nascimento", String.valueOf(dataNascimentoFuncionario.getMonthValue()));
                    dadosDoNascimentoDoFuncionarioTemporario.put("Idade", Long.toString(idadeDoFuncionario));

                    DicionarioDataNascimentoFuncionario.put(funcionario.keySet().toString(), dadosDoNascimentoDoFuncionarioTemporario);
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