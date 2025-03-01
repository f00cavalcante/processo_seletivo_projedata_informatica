import Funcionarios.FuncionariosAgrupadosPorFuncao;
import Funcionarios.FuncionariosESeusSalarios;
import Funcionarios.FuncionariosIdadeDoFuncionario;
import Funcionarios.FuncionariosRelacao;
import Funcionarios.FuncionariosRemoverFuncionario;

import org.json.JSONException;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Principal {

     public static void main(String[] args) throws FileNotFoundException, JSONException, ParseException {

          HashMap<String, Map<String, Object>> funcionarios = new HashMap<>();

          System.out.println("Olá Mundo!");
          System.out.println("Para dar sorte. 🙂");

          System.out.println("\nAbaixo, encontram-se as respostas para o teste prático à vaga de Desenvolvedor oferecida pela Projedata Informática. Cada resposta estará identificada conforme o enunciado das questões, sendo três (3) ao todo.\n");

          // Questão 01 - Criação da Classe Pessoas
          System.out.println("Questão 01 - Criar uma Class com o nome Pessoas, e esta, deverá receber os atributos 'nome' e data de nascimento'.");
          System.out.println("Para este processo, optei por efetuar a criação de uma Classe com o nome especificado, e métodos para inserir nome e data de nascimento aos novos objetos criados a partir dela, isto é, as novas pessoas, assim, com o método 'set' os dados poderão ser inseridos, e 'get', consultados.\n\n");

          // Questão 02 - Criação da Classe Funcionario estendida da Classe Pessoas
          System.out.println("Questão 02 - Criar uma Classe Funcionario, estendida da Classe Pessoas, com os atributos 'salario' e algo mais que não recordo.");
          System.out.println("Seguindo o mesmo princípio, foi criada a Classe Funcionarios, sendo uma estenção da Classe Pessoas, com métodos para inserir valores, e também os consultar.");
          System.out.println("Então, para demonstração, abaixo segue o conteúdo do dicionário criado, tendo como chave (keys) o nome de cada funcionário:");

          funcionarios = new FuncionariosRelacao().getFuncionariosRelacao();

          funcionarios.forEach(
                    (funcionario, dadosDoFuncionario)
                              ->
                              System.out.printf("Nome: %s | Data Nascimento: %s, Salário: %s, Função: %s \n", funcionario, dadosDoFuncionario.get("Data Nascimento"), dadosDoFuncionario.get("Salário"), dadosDoFuncionario.get("Função"))
          );

          System.out.println("\n");

          // Questão 03 - A partir deste ponto, será tratado a resolução da questão 03, e as suas subquestões. Desta forma, após, haverá a revisão do processo ao ser reenviado para avaliação da empresa.
          System.out.println("Questão 03");
          System.out.println("A seguir, todas as execuções relacionadas às opções para a questão 03, e suas opções.");

          System.out.println("Removendo funcionário.");
          System.out.println("Executando o processo de remoção do funcionário. Neste caso, será efetuado a remoção do 'João' conforme solicitado. Optei por, criar uma função separada, a qual, retornará o dicionário com a chave (key) relacionada a este colaborador excluída, e com isto, a variável 'funcionarios' receberá um novo HashMap().");
          System.out.println("A nova relação dos funcionários:");
          // Neste processo, optei por efetuar a criação de um Objeto separado para retornar a lista com a remoção do funcionário determinado, apenas para melhor organização do código, não poluindo o main executando processos
          funcionarios = new FuncionariosRemoverFuncionario().FuncionariosRemoverFuncionario(funcionarios, "João");
          funcionarios.forEach(
                    (funcionario, dadosDoFuncionario)
                              ->
                              System.out.printf("Nome: %s | Data Nascimento: %s, Salário: %s, Função: %s \n", funcionario, dadosDoFuncionario.get("Data Nascimento"), dadosDoFuncionario.get("Salário"), dadosDoFuncionario.get("Função"))
          );
          System.out.print("\n");
          System.out.println("Atualização salarial");
          System.out.println("O processo de atualização salarial consistiu basicamente em efetuar a criação de um novo BigDecimal, e atualizar todos os valores das chaves contidas no HashMap. Aproveitei a oportunidade, para que a prórpia função retorne os valores antigos e atualizados, conforme cada interação do loop ocorre. Posteriormente, ocorre a soma total dos salários.");
          FuncionariosESeusSalarios atualizacaoSalarialDosFuncionarios = new FuncionariosESeusSalarios(funcionarios, 1.10);
          funcionarios = atualizacaoSalarialDosFuncionarios.getFuncionariosComAumentoSalarial();
          System.out.printf(
                    "Desta forma, a soma total dos salários ocorrerá por meio da execução de uma função, alimentando a variável específica para isto. \n" +
                              "Optei então, por efetuar sua invocação direta neste prinf, uma vez que o intuito seria apenas apontar a soma dos valores. Assim, o total dos salários é: %s. \n",
                    NumberFormat.getNumberInstance(new Locale("pt", "BR")).format(atualizacaoSalarialDosFuncionarios.getSomaDosSalarios())
          );

          System.out.print("\n");
          System.out.println("Agrupamento por função");

          new FuncionariosAgrupadosPorFuncao().FuncionariosAgrupadosPorFuncao(funcionarios);

          System.out.print("\n");
          System.out.println("Idade dos funcionários");

          FuncionariosIdadeDoFuncionario idadeDosFuncionarios = new FuncionariosIdadeDoFuncionario(funcionarios);

          idadeDosFuncionarios.getIdadeDosFuncionarios().forEach((nomeFuncionario, idadeFuncionario) -> System.out.printf("Nome: %s | Idade: %s \n", nomeFuncionario, idadeFuncionario.toString()));
          System.out.printf("O funcionário mais velho: %s. \n", idadeDosFuncionarios.getFuncionarioMaisVelho());

          idadeDosFuncionarios.setListaDosMesesDeNascimento(List.of(10, 12));
          System.out.print("Retornando o nome dos funcionários que nasceram nos meses de Outubro e Dezembro: ");
          idadeDosFuncionarios.getListaDosMesesDeNascimento().forEach(nomeDoFuncionario -> System.out.printf("%s | ", nomeDoFuncionario));
     }
}