package Funcionarios;

import JSONDadosFuncionarios.DicionarioFuncionarios;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FuncionariosRelacao {

     private HashMap<String, Map<String, Object>> funcionariosRelacao = new LinkedHashMap<>();

     public FuncionariosRelacao() throws FileNotFoundException, JSONException {

          HashMap<String, Map<String, String>> funcionarios = new DicionarioFuncionarios().Funcionarios;

          for (Map.Entry<String, Map<String, String>> f : funcionarios.entrySet()) {

               Funcionarios cadastrarFuncionario = new Funcionarios();

               cadastrarFuncionario.setNome(f.getKey());
               cadastrarFuncionario.setDataNascimento(LocalDate.parse(f.getValue().get("Data Nascimento"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
               cadastrarFuncionario.setSalario(new BigDecimal(f.getValue().get("Salário")));
               cadastrarFuncionario.setFuncao(f.getValue().get("Função"));

               funcionariosRelacao.put(
                         cadastrarFuncionario.getNome(),
                         Map.of(
                                   "Data Nascimento", cadastrarFuncionario.getDataNascimento(),
                                   "Salário", cadastrarFuncionario.getSalario(),
                                   "Função", cadastrarFuncionario.getFuncao()
                         )
               );
          }
     }

     public HashMap<String, Map<String, Object>> getFuncionariosRelacao() {
          return this.funcionariosRelacao;
     }
}
