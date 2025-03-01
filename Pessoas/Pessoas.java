package Pessoas;

import java.time.LocalDate;

public class Pessoas {

     private String Nome = new String();
     private LocalDate DataNascimento;

     public String getNome() {

          return this.Nome;
     }

     public LocalDate getDataNascimento() {
          return this.DataNascimento;
     }

     public void setNome(String nome) {
          this.Nome = nome;
     }

     public void setDataNascimento(LocalDate dataNascimento) {
          this.DataNascimento = dataNascimento;
     }
}
