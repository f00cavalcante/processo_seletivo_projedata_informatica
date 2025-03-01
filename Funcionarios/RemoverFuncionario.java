package Funcionarios;

import java.util.List;
import java.util.Map;

public class RemoverFuncionario {

     public static int IndiceDoFuncionario;

     public RemoverFuncionario(List<Map<String, Map<String, String>>> ListaDosFuncionarios, String NomeDoFuncionario) {

          for (int i = 0; i < ListaDosFuncionarios.size(); i++) {

               if (ListaDosFuncionarios.get(i).keySet().contains(NomeDoFuncionario)) {
                    IndiceDoFuncionario = ListaDosFuncionarios.indexOf(ListaDosFuncionarios.get(i));
               }
          }
     }

}
