import Funcionarios.FuncionariosAgrupadosPorFuncao;
import Funcionarios.FuncionariosESeusSalarios;
import Funcionarios.FuncionariosExibirInformacoesFormatadas;
import Funcionarios.FuncionariosIdadeDoFuncionario;
import Funcionarios.FuncionariosRelacao;
import Funcionarios.FuncionariosRemoverFuncionario;

import org.json.JSONException;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

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
          System.out.println("Nesta terceira etapa, as execuções serão realizadas na classe Principal, relacionadas à manipulação nos dados dos Funcionários criados no dicionário 'funcionarios'.");
          System.out.println("A seguir, todas as execuções relacionadas às opções para a questão 03, e suas opções.");

          System.out.print("\n");
          System.out.println("3.1 - Inserir os funcionários na mesma ordem que são apresentados na tabela.");
          System.out.println("Desta forma, optei por utilizar a criação do HashMap utilizando o LinkedHashMap. A apresentação ocorreu, conforme demonstrado anteriormente.");

          System.out.print("\n");
          System.out.println("3.2 - Remover o funcionário João.");
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
          System.out.println("3.3 - Efetuar a apresentação das informações dos funcionários de maneira formatada.");
          System.out.println("Pois muito bem... Neste processo optei por efetuar a criação de uma classe, para melhor organizar o código, e destinar a execução desta Princiapl apenas para texto e invocar as funções. " +
                    "\nAssim, crio um novo método, enviando o dicionário 'funcionários', o qual irá imprimir apenas o nome, data e salários formatados, no padrão estabelecido. Para data, opotei por algo bastante verboso." +
                    "\nSegue:");
          new FuncionariosExibirInformacoesFormatadas(funcionarios);

          System.out.print("\n");
          System.out.println("3.4 - Atualização salarial em 10%");
          System.out.println(
                    "O processo de atualização salarial consistiu basicamente em efetuar a criação de um novo BigDecimal, e reenviar todos os valores das chaves contidas no HashMap. " +
                              "\nAproveitei a oportunidade, para que a prórpia função retorne os valores antigos e atualizados, conforme cada interação do loop ocorre. Posteriormente, ocorre a soma total dos salários."
          );

          FuncionariosESeusSalarios atualizacaoSalarialDosFuncionarios = new FuncionariosESeusSalarios(funcionarios, 1.10);
          funcionarios = atualizacaoSalarialDosFuncionarios.getFuncionariosComAumentoSalarial();

          System.out.print("\n");
          System.out.printf(
                    "Desta forma, a soma total dos salários ocorrerá por meio da execução de uma função, alimentando a variável específica para isto. \n" +
                              "Optei então, por efetuar sua invocação direta neste prinf, uma vez que o intuito seria apenas apontar a soma dos valores. Assim, o total dos salários é: %s. \n",
                    NumberFormat.getNumberInstance(new Locale("pt", "BR")).format(atualizacaoSalarialDosFuncionarios.getSomaDosSalarios())
          );

          System.out.print("\n");
          System.out.println("3.5 & 3.6 - Agrupamento por função, e exibir a lista dos funcionários");
          System.out.println(
                    "Para efetuar esta questão, optei por percorrer todo o dicionário dos funcionários, extraindo o nome das funções, e criando uma listagem, garantindo que os dados não sejam repetidos. \n" +
                              "Após, para cada índice da nova lista de funções, percorria o dicionário, validando quais funcionários correspondiam aos dados, e assim, foi criado um Map, com a key sendo os nomes das funções, e a chave, a listagem dos funcionários"
          );

          FuncionariosAgrupadosPorFuncao funcionariosAgrupadosPorFuncao = new FuncionariosAgrupadosPorFuncao(funcionarios);

          System.out.print("\n");
          System.out.println("3.8 - Funcionários com nascimento nos meses 10 e 12");

          FuncionariosIdadeDoFuncionario idadeDosFuncionarios = new FuncionariosIdadeDoFuncionario(funcionarios);

          System.out.println("Uma vez solicitado para validar os funcionários com nascimento nestes meses, e o exercício posterior será para validar o funcionário mais velho, criei uma classe para tratar todos os assuntos relacionados à idade.");
          System.out.println("Neste caso, basicamente, extraí o mês correspondente da data de nascimento dos funcinários (em valor), e validei no processo.");

          idadeDosFuncionarios.setListaDosMesesDeNascimento(List.of(10, 12));
          System.out.print("Retornando o nome dos funcionários que nasceram nos meses de Outubro e Dezembro: ");
          idadeDosFuncionarios.getListaDosMesesDeNascimento().forEach(nomeDoFuncionario -> System.out.printf("%s | ", nomeDoFuncionario));

          System.out.print("\n");
          System.out.print("\n");
          System.out.println("3.9 - Funcionário mais velho");
          System.out.println("Em complemento ao exercício anterior, para a mesma classe, efetuei a apuração de todos estes dados, e a idade dos funcionários.");

          idadeDosFuncionarios.getIdadeDosFuncionarios().forEach((nomeFuncionario, idadeFuncionario) -> System.out.printf("Nome: %s | Idade: %s \n", nomeFuncionario, idadeFuncionario.toString()));
          System.out.print("\n");
          System.out.printf("Desta forma, é possível validar que o funcionário mais velho refere-se ao %s, pois possui %s anos de idade. \n", idadeDosFuncionarios.getFuncionarioMaisVelho(), idadeDosFuncionarios.getIdadeDosFuncionarios().get(idadeDosFuncionarios.getFuncionarioMaisVelho()));

          System.out.print("\n");
          System.out.println("3.10 - Exibir a lista dos nomes em ordem alfabética");
          System.out.println("Para este processo, optei por apenas efetuar a invocação dos métodos que são acessíveis para a extração das chaves (keys) do dicionário dos funcionários, exibí-los, ordernar pelo método sorted, e criar uma interação com forEach.");
          funcionarios.keySet().stream().sorted().forEach(nomeDoFuncionario -> System.out.printf("%s | ", nomeDoFuncionario));

          System.out.print("\n");
          System.out.println("3.11 - Exibir a soma total dos salários dos funcionários");
          System.out.println("Uma vez que concentrei todas as informações relacionadas aos salários na classe FuncionariosESeusSalarios, basta executar seu método getSomaDosSalarios");
          System.out.printf("Desta forma, a soma dos salários é R$ %s. \n", NumberFormat.getNumberInstance(new Locale("pt", "BR")).format(atualizacaoSalarialDosFuncionarios.getSomaDosSalarios()));

          System.out.print("\n");
          System.out.println("3.12 - Exibir a quantidade de salários mínimos por funcionários");
          System.out.println(
                    "Para exibir esta quantidade, no exercício foi passado que o valor do salário mínimo a ser considerado será de 1212. \n" +
                              "Desta forma, na classe relacionada ao tratamento dos salários dos funcionários, apenas foi invocado este método, e inserido o valor correspondente ao salário mínimo estipulado"
          );

          atualizacaoSalarialDosFuncionarios.setValorSalarioMinimo(new BigDecimal(1212));
          atualizacaoSalarialDosFuncionarios.getfuncionariosComMediasDeSalarioMinimo().forEach(
                    (nomeDoFuncionario, mediaSalarioMinimo)
                              -> System.out.printf("Nome: %s | Média Salário Mínimo: %s \n", nomeDoFuncionario, mediaSalarioMinimo)
          );

          System.out.println("\n");
          System.out.println("E com isto, chegamos ao final de todo o teste prático. =)");
     }
}