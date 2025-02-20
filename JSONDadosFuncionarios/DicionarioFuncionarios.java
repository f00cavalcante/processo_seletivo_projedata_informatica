package JSONDadosFuncionarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DicionarioFuncionarios {

     public static HashMap<String, Map<String, String>> Funcionarios = new HashMap<>();

     public DicionarioFuncionarios() throws FileNotFoundException, JSONException {

          BufferedReader arquivoJSON = new BufferedReader(new FileReader("JSONDadosFuncionarios/DadosDosFuncionarios.json"));
          StringBuilder arquivoJSONEmString = new StringBuilder();
          // Converter as linhas do arquivo JSON em String para leitura do JSONArray
          arquivoJSON.lines().forEach(arquivoJSONEmString::append);

          JSONArray extracaoListaDosFuncionarios = new JSONArray(arquivoJSONEmString.toString());

          for (int i = 0; i < extracaoListaDosFuncionarios.length(); i++) {

               JSONObject funcionario = new JSONObject(extracaoListaDosFuncionarios.get(i).toString());

               String nomeFuncionario = funcionario.get("nome").toString();

               Map<String, String> dadosDoFuncionario = new HashMap<>(Map.of(
                         "Data Nascimento", funcionario.get("data_nascimento").toString(),
                         "Salário", funcionario.get("salario").toString(),
                         "Função", funcionario.get("funcao").toString()
               ));

               Funcionarios.put(nomeFuncionario, dadosDoFuncionario);
          }
     }
}
