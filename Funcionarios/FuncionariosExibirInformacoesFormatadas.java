package Funcionarios;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FuncionariosExibirInformacoesFormatadas {

     public FuncionariosExibirInformacoesFormatadas(HashMap<String, Map<String, Object>> Funcionarios) {

          for (Map.Entry<String, Map<String, Object>> funcionario : Funcionarios.entrySet()) {

               System.out.printf(
                         "Nome: %s | Data Nascimento: %s | Salário: R$ %s \n",
                         funcionario.getKey(),
                         DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format((TemporalAccessor) funcionario.getValue().get("Data Nascimento")),
                         NumberFormat.getNumberInstance(new Locale("pt", "BR")).format(funcionario.getValue().get("Salário"))
               );
          }
     }
}
