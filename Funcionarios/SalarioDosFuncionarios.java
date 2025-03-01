package Funcionarios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.text.NumberFormat;

public class SalarioDosFuncionarios {

     public BigDecimal SomaTotalDosSalariosDosFuncionarios = new BigDecimal(0);
     public String SomaTotalDosSalariosDosFuncionariosFormatado;

     public Map<String, BigDecimal> QuantidadeDeSalarioMinimoPorFuncionario = new HashMap<>();

     public SalarioDosFuncionarios(List<Map<String, Map<String, String>>> ListaDosFuncionarios) {

          Map<String, BigDecimal> DadosDoSalarioDoFuncionario = new HashMap<>();

          for (Map<String, Map<String, String>> funcionario : ListaDosFuncionarios) {

               for (Map<String, String> dados : funcionario.values()) {

                    BigDecimal salario = new BigDecimal(dados.get("Salário").toString());
                    DadosDoSalarioDoFuncionario.put(funcionario.keySet().toString(), salario);
               }
          }

          SomaTotalDosSalariosDosFuncionariosFormatado(DadosDoSalarioDoFuncionario);
          QuantidadeDeSalarioMinimoPorFuncionario(DadosDoSalarioDoFuncionario);
     }

     private void SomaTotalDosSalariosDosFuncionariosFormatado(Map<String, BigDecimal> dadosDoSalarioDoFuncionario) {

          for (String funcionario : dadosDoSalarioDoFuncionario.keySet()) {

               BigDecimal salario = new BigDecimal(dadosDoSalarioDoFuncionario.get(funcionario).toString());
               SomaTotalDosSalariosDosFuncionarios = SomaTotalDosSalariosDosFuncionarios.add(new BigDecimal(salario.toString()));
               SomaTotalDosSalariosDosFuncionariosFormatado = NumberFormat.getNumberInstance(new Locale("pt", "BR")).format(SomaTotalDosSalariosDosFuncionarios);
          }
     }

     private void QuantidadeDeSalarioMinimoPorFuncionario(Map<String, BigDecimal> dadosDoSalarioDoFuncionario) {

          BigDecimal valorSalarioMinimo = new BigDecimal(1212);

          for (String funcionario : dadosDoSalarioDoFuncionario.keySet()) {

               BigDecimal salario = new BigDecimal(dadosDoSalarioDoFuncionario.get(funcionario).toString());
               BigDecimal quantidadeDeSalarioMinimo = new BigDecimal(salario.divide(valorSalarioMinimo, 2, RoundingMode.CEILING).toString());

               QuantidadeDeSalarioMinimoPorFuncionario.put(funcionario, quantidadeDeSalarioMinimo);
          }
     }
}
