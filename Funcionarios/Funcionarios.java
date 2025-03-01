package Funcionarios;

import JSONDadosFuncionarios.DicionarioFuncionarios;
import Pessoas.Pessoas;

import java.math.BigDecimal;

public class Funcionarios extends Pessoas {

     private BigDecimal Salario = new BigDecimal(0);
     private String Funcao = new String();

     public void Funcionarios(String[] args) {

          System.out.println("Alguma coisa a ser retornado");
     }

     public BigDecimal getSalario() {
          return this.Salario;
     }

     public String getFuncao() {
          return this.Funcao;
     }

     public void setSalario(BigDecimal salario) {
          this.Salario = salario;
     }

     public void setFuncao(String funcao) {
          this.Funcao = funcao;
     }
}