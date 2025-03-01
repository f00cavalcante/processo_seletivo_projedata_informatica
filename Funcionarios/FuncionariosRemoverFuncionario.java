package Funcionarios;

import java.util.HashMap;
import java.util.Map;

public class FuncionariosRemoverFuncionario {

     public HashMap<String, Map<String, Object>> FuncionariosRemoverFuncionario(HashMap<String, Map<String, Object>> Funcionarios, String NomeDoFuncionario) {

          for (Map.Entry<String, Map<String, Object>> funcionario : Funcionarios.entrySet()) {

               if (funcionario.getKey().equals(NomeDoFuncionario)) {
                    Funcionarios.remove(funcionario.getKey());
                    break;
               }
          }

          return Funcionarios;
     }
}
