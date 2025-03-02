package Funcionarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FuncionariosAgrupadosPorFuncao {

     private List<String> listaDasFuncoes = new ArrayList<>();
     private HashMap<String, List<String>> FuncionariosAgrupadosPorFuncao = new LinkedHashMap<>();

     public HashMap<String, List<String>> getFuncionariosAgrupadosPorFuncao() {
          return this.FuncionariosAgrupadosPorFuncao;
     }

     public FuncionariosAgrupadosPorFuncao(HashMap<String, Map<String, Object>> Funcionarios) {

          CriarListaDasFuncoes(Funcionarios);

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
     }

     private List<String> CriarListaDasFuncoes(HashMap<String, Map<String, Object>> Funcionarios) {

          for (Map.Entry<String, Map<String, Object>> funcionario : Funcionarios.entrySet()) {

               if (!this.listaDasFuncoes.contains(funcionario.getValue().get("Função").toString())) this.listaDasFuncoes.add(funcionario.getValue().get("Função").toString());
          }

          Collections.sort(this.listaDasFuncoes);

          return this.listaDasFuncoes;
     }
}