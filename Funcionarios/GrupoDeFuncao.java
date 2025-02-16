package Funcionarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrupoDeFuncao {

     public static List<String> ListaDasFuncoes = new ArrayList<>();
     public Map<String, List<Map<String, String>>> DicionarioDeFuncionariosPorFuncao = new HashMap<>();

     public GrupoDeFuncao(List<Map<String, Map<String, String>>> ListaDosFuncionarios) {

          CriarListaDasFuncoes(ListaDosFuncionarios);

          for (String funcao : ListaDasFuncoes) {

               List<Map<String, String>> ListaTemporariaComDadosDosFuncionarios = new ArrayList<>();

               for (int i = 0; i < ListaDosFuncionarios.size(); i++) {

                    Map<String, String> DicionarioTemporarioComDadosDoFuncionario = new HashMap<>();

                    for (Map<String, String> funcionarioDados : ListaDosFuncionarios.get(i).values()) {

                         if (funcionarioDados.get("Função").equals(funcao)) {

                              DicionarioTemporarioComDadosDoFuncionario.put("Nome", ListaDosFuncionarios.get(i).keySet().toString());
                              DicionarioTemporarioComDadosDoFuncionario.put("Data Nascimento", funcionarioDados.get("Data Nascimento"));
                              DicionarioTemporarioComDadosDoFuncionario.put("Salário", funcionarioDados.get("Salário"));

                              ListaTemporariaComDadosDosFuncionarios.add(DicionarioTemporarioComDadosDoFuncionario);
                         }
                    }
               }

               DicionarioDeFuncionariosPorFuncao.put(funcao, ListaTemporariaComDadosDosFuncionarios);
          }
     }

     private void CriarListaDasFuncoes(List<Map<String, Map<String, String>>> ListaDosFuncionarios) {

          for (Map<String, Map<String, String>> funcionario : ListaDosFuncionarios) {

               for (Map<String, String> funcionarioFuncao : funcionario.values()) {

                    if (!ListaDasFuncoes.contains(funcionarioFuncao.get("Função"))) ListaDasFuncoes.add(funcionarioFuncao.get("Função"));
               }
          }
     }
}
