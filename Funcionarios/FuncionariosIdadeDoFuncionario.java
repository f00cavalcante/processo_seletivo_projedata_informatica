package Funcionarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FuncionariosIdadeDoFuncionario {

     private DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("yyy-MM-dd");

     private HashMap<String, Integer> IdadeDosFuncionarios = new HashMap<>();

     private HashMap<String, LocalDate> dicionarioTemporarioComDataDeNascimentoDosFuncionarios = new HashMap<>();
     private List<Integer> ListaDosMesesDeNascimento = new ArrayList<>();
     private String FuncionarioMaisVelho = new String();

     public FuncionariosIdadeDoFuncionario(HashMap<String, Map<String, Object>> Funcionarios) {

          for (Map.Entry<String, Map<String, Object>> funcionario : Funcionarios.entrySet()) {

               this.dicionarioTemporarioComDataDeNascimentoDosFuncionarios.put(funcionario.getKey(), LocalDate.parse(funcionario.getValue().get("Data Nascimento").toString(), formatarData));
          }
     }

     public HashMap<String, Integer> getIdadeDosFuncionarios() {
          IdadeDosFuncionarios(this.dicionarioTemporarioComDataDeNascimentoDosFuncionarios);
          return this.IdadeDosFuncionarios;
     }

     private void IdadeDosFuncionarios(HashMap<String, LocalDate> Funcionarios) {

          for (Map.Entry<String, LocalDate> funcionario : Funcionarios.entrySet()) {

               long idadeDoFuncionario = funcionario.getValue().until(LocalDate.now(), ChronoUnit.YEARS);

               this.IdadeDosFuncionarios.put(funcionario.getKey(), Math.toIntExact(idadeDoFuncionario));
          }
     }

     public String getFuncionarioMaisVelho() {
          FuncionarioMaisVelho(this.IdadeDosFuncionarios);
          return this.FuncionarioMaisVelho;
     }

     private void FuncionarioMaisVelho(HashMap<String, Integer> Funcionarios) {

          Integer idadeFuncionarioMaisVelho = 0;
          String nomeDoFuncionarioMaisVelho = new String();

          for (Map.Entry<String, Integer> funcionario : Funcionarios.entrySet()) {

               if (funcionario.getValue() > idadeFuncionarioMaisVelho) {

                    idadeFuncionarioMaisVelho = funcionario.getValue();
                    nomeDoFuncionarioMaisVelho = funcionario.getKey();
               }
          }

          this.FuncionarioMaisVelho = nomeDoFuncionarioMaisVelho;
     }

     public List<String> getListaDosMesesDeNascimento() {
          return MesDeNascimentoDoFuncionario(dicionarioTemporarioComDataDeNascimentoDosFuncionarios, this.ListaDosMesesDeNascimento);
     }

     public void setListaDosMesesDeNascimento(List<Integer> listaDosMesesDeNascimento) {
          this.ListaDosMesesDeNascimento = listaDosMesesDeNascimento;
     }

     private List<String> MesDeNascimentoDoFuncionario(HashMap<String, LocalDate> Funcionarios, List<Integer> listaDosMesesDeNascimento) {

          List<String> nomeDosFuncionariosNoMesDeNascimentoSolicitado = new ArrayList<>();

          for (Map.Entry<String, LocalDate> funcionario : Funcionarios.entrySet()) {

               if (listaDosMesesDeNascimento.contains(
                         LocalDate.parse(funcionario.getValue().toString(), formatarData).getMonthValue()
               )) {
                    nomeDosFuncionariosNoMesDeNascimentoSolicitado.add(funcionario.getKey());
               }
          }

          return nomeDosFuncionariosNoMesDeNascimentoSolicitado;
     }
}