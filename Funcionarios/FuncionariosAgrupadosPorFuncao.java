package Funcionarios;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FuncionariosAgrupadosPorFuncao {

     private HashMap<String, List<String>> FuncionariosAgrupadosPorFuncao = new LinkedHashMap<>();

     public HashMap<String, List<String>> FuncionariosAgrupadosPorFuncao(HashMap<String, Map<String, Object>> Funcionarios) {

          List<String> listaDasFuncoes = CriarListaDasFuncoes(Funcionarios);

          for (String funcao : listaDasFuncoes) {

               System.out.printf("%s: ", funcao);

               List<String> nomeDosFuncionarios = new ArrayList<>();

               for (Map.Entry<String, Map<String, Object>> funcionario : Funcionarios.entrySet()) {

                    if (funcionario.getValue().get("Função").equals(funcao)) {

                         System.out.printf("%s ", funcionario.getKey());
                         nomeDosFuncionarios.add(funcionario.getKey());
                    }
               }

               System.out.print("\n");

               Collections.sort(nomeDosFuncionarios);

               FuncionariosAgrupadosPorFuncao.put(funcao, nomeDosFuncionarios);
          }

          return this.FuncionariosAgrupadosPorFuncao;
     }

     private List<String> CriarListaDasFuncoes(HashMap<String, Map<String, Object>> Funcionarios) {

          List<String> listaDasFuncoes = new ArrayList<>();

          for (Map.Entry<String, Map<String, Object>> funcionario : Funcionarios.entrySet()) {

               if (!listaDasFuncoes.contains(funcionario.getValue().get("Função").toString())) listaDasFuncoes.add(funcionario.getValue().get("Função").toString());
          }

          Collections.sort(listaDasFuncoes);

          return listaDasFuncoes;
     }
}