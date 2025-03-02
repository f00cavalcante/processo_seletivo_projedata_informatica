package Funcionarios;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FuncionariosESeusSalarios {

     private HashMap<String, Map<String, Object>> funcionariosComAumentoSalarial = new LinkedHashMap<>();
     private HashMap<String, Object> funcionariosComMediasDeSalarioMinimo = new LinkedHashMap<>();
     private BigDecimal somaDosSalarios = new BigDecimal(0);
     private BigDecimal valorSalarioMinimo = new BigDecimal(0);

     public FuncionariosESeusSalarios(HashMap<String, Map<String, Object>> Funcionarios, Double PercentualAumento) {

          AumentoSalarial(Funcionarios, PercentualAumento);

          for (Map.Entry<String, Map<String, Object>> funcionario : funcionariosComAumentoSalarial.entrySet()) {

               SomaDosSalarios(new BigDecimal(funcionario.getValue().get("Salário").toString()));
          }
     }

     public HashMap<String, Map<String, Object>> getFuncionariosComAumentoSalarial() {
          return this.funcionariosComAumentoSalarial;
     }

     private void AumentoSalarial(HashMap<String, Map<String, Object>> Funcionarios, Double PercentualAumento) {

          for (HashMap.Entry<String, Map<String, Object>> funcionario : Funcionarios.entrySet()) {

               System.out.printf("Nome: %s | ", funcionario.getKey());

               Map<String, Object> dadosTemporariosAtualizados = new HashMap<>();

               for (Map.Entry<String, Object> funcionarioDados : funcionario.getValue().entrySet()) {

                    switch (funcionarioDados.getKey()) {

                         case "Data Nascimento":
                              dadosTemporariosAtualizados.put("Data Nascimento", funcionarioDados.getValue());

                              break;
                         case "Salário":
                              BigDecimal salarioAntigo = new BigDecimal(funcionarioDados.getValue().toString());
                              BigDecimal salarioAtualizado = salarioAntigo.multiply(BigDecimal.valueOf(PercentualAumento));

                              System.out.printf("Salário antigo: %.2f, Salário novo: %.2f \n", salarioAntigo, salarioAtualizado);

                              dadosTemporariosAtualizados.put("Salário", salarioAtualizado);

                              break;
                         case "Função":
                              dadosTemporariosAtualizados.put("Função", funcionarioDados.getValue());

                              break;
                    }
               }

               funcionario.setValue(dadosTemporariosAtualizados);

               this.funcionariosComAumentoSalarial.put(funcionario.getKey(), funcionario.getValue());
          }
     }

     public BigDecimal getSomaDosSalarios() {
          return this.somaDosSalarios;
     }

     private void SomaDosSalarios(BigDecimal salarioDoFuncionario) {

          this.somaDosSalarios = somaDosSalarios.add(new BigDecimal(salarioDoFuncionario.toString()));
     }

     public HashMap<String, Object> getfuncionariosComMediasDeSalarioMinimo() {

          funcionariosComMediasDeSalarioMinimo();
          return this.funcionariosComMediasDeSalarioMinimo;
     }

     public void setValorSalarioMinimo(BigDecimal valorSalarioMinimo) {
          this.valorSalarioMinimo = new BigDecimal(valorSalarioMinimo.toString());
     }

     private void funcionariosComMediasDeSalarioMinimo() {

          for (Map.Entry<String, Map<String, Object>> funcionario : this.funcionariosComAumentoSalarial.entrySet()) {

               BigDecimal salarioDoFuncionario = new BigDecimal(funcionario.getValue().get("Salário").toString());
               BigDecimal quantidadeDeSalarioMinimo = salarioDoFuncionario.divide(this.valorSalarioMinimo, 2);
               this.funcionariosComMediasDeSalarioMinimo.put(
                         funcionario.getKey(),
                         quantidadeDeSalarioMinimo
               );
          }
     }
}
