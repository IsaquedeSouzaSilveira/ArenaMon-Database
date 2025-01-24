README Arenamoon-Database

1. Classe DatabaseConnection
Esta classe é responsável por gerenciar a conexão com o banco de dados SQLite.

  1.Atributos e Constantes:
      1.DB_FILE: Define o caminho relativo para o arquivo do banco de dados (arena_moon.db). Ele está localizado no diretório src/main/java/ArenamoonDatabase/.
      2.URL: Constrói a URL de conexão ao banco no formato exigido pelo driver JDBC do SQLite (jdbc:sqlite:<caminho_do_arquivo>). Essa constante utiliza o método getDatabasePath para obter o caminho absoluto.
      
  2.Método getDatabasePath:
      1.Combina o diretório atual do sistema (System.getProperty("user.dir")) com o caminho relativo do banco de dados (DB_FILE).
      2.Garante que o código possa funcionar em diferentes sistemas operacionais e ambientes de execução.
      
  3.Método connect:
      1.Cria e retorna uma conexão com o banco de dados usando o DriverManager, que é o ponto central de gerenciamento de conexões JDBC.
      2.Caso ocorra um erro (como caminho inválido ou arquivo ausente), ele lança uma exceção SQLException.
      
Resumo: Essa classe encapsula toda a lógica necessária para conectar-se ao banco de dados, permitindo reutilização e centralização do código de conexão.

3. Classe ArenaMoonDatabase
Esta é a classe principal que coordena a execução do programa. Aqui, os dados são carregados do banco e exibidos.

  1.Fluxo de Execução no main:
    Conexão com o banco:
        1.Estabelece uma conexão usando o método estático connect da classe DatabaseConnection.
        2.O bloco try-with-resources é usado, o que garante que a conexão será fechada automaticamente no final (mesmo em caso de erro).
        
    Carregamento de Dados:
        1.Os métodos da classe DataLoader são usados para carregar os dados das tabelas do banco: 
        2.loadPokemons: Carrega informações sobre Pokémon.
        3.loadAtaques: Carrega informações sobre os ataques.
        4.loadTipos: Carrega os diferentes tipos de Pokémon/ataques.
        5.Cada método retorna uma lista (List) de objetos representando os dados carregados.
        
    Exibição dos Dados:
        1.Cada lista carregada é percorrida com um laço for, e os dados são exibidos formatados no console usando System.out.printf.
        
  2.Tratamento de Erros:
        1.Se algum erro relacionado ao banco de dados ocorrer, como falha na conexão ou erro na execução da consulta SQL, ele é capturado e a pilha de execução é exibida com e.printStackTrace().
        
Resumo: Essa classe é o ponto de entrada do programa, onde a lógica de carregamento e exibição é implementada de forma clara e sequencial.

3. Classe Pokemon
Esta classe representa os Pokémon carregados do banco de dados.
  1.Atributos:
      1.id: Identificador único do Pokémon (inteiro).
      2.nome: Nome do Pokémon (string).
      3.vida: Pontos de vida (inteiro), representando o quanto de dano ele pode suportar.
      4.tipo: Identificador do tipo associado ao Pokémon.
   
  2.Construtor:
      1.Inicializa os atributos da classe, garantindo que um objeto Pokemon seja criado com os valores necessários.
    
  3.  Getters e Setters:
      1.Métodos para acessar (get) e modificar (set) os atributos da classe, permitindo encapsulamento e controle.
      
  5. Método toString:
      1.Retorna uma representação textual do objeto, útil para depuração ou exibição.
     
Resumo: Essa classe organiza as informações de um Pokémon, tornando mais simples manipulá-las no código.


4. Classe Ataque
Essa classe modela os ataques que os Pokémon podem realizar.
  Atributos:
      1.id: Identificador único do ataque.
      2.nome: Nome do ataque.
      3.dano: Quantidade de dano causado pelo ataque.
      4.effect: Efeito especial do ataque (ex.: paralisar, queimar).
      5.tipo: Tipo do ataque, relacionado aos tipos de Pokémon.
  Construtor e Métodos:
      1.Semelhante à classe Pokemon, ela possui: 
      1.Um construtor para inicializar os atributos.
      2.Getters e setters para acessar e modificar os atributos.
   
Resumo: Essa classe encapsula as informações de ataques, permitindo sua manipulação de forma organizada.

6. Classe Tipo
Representa os tipos (ou categorias) que podem ser atribuídos tanto aos Pokémon quanto aos ataques.
  Atributos:
      1.id: Identificador único do tipo.
      2.tipo: Nome ou descrição do tipo (ex.: Fogo, Água, Elétrico).
   
  Métodos:
      1.Semelhante às outras classes, com getters e um método toString.
      
Resumo: Essa classe abstrai os tipos de Pokémon/ataques, permitindo operações relacionadas a categorizações.

8. Classe DataLoader
Essa classe é responsável por carregar dados do banco de dados e criar objetos em memória.
  Métodos:

   1.loadPokemons: 
        1.Executa uma consulta SQL que combina duas tabelas (pokemon e tipo_pokemon) para obter informações completas de cada Pokémon.
        2.Usa um laço while para percorrer os resultados (ResultSet) e cria objetos Pokemon, que são adicionados a uma lista.
   
   2.loadAtaques: 
        1.Executa uma consulta na tabela ataque para carregar informações de ataques.
        2.Similar ao método anterior, cria objetos Ataque e os armazena em uma lista.
   
   3.loadTipos: 
        1.Executa uma consulta na tabela tipos para carregar os tipos disponíveis.
        2.Cria objetos Tipo e os adiciona a uma lista.
   
   Uso de PreparedStatement e ResultSet:
        1.PreparedStatement: Evita problemas de SQL Injection ao preparar consultas parametrizadas.
        2.ResultSet: Permite iterar sobre os dados retornados pela consulta SQL.
   
Resumo: Essa classe abstrai o acesso ao banco de dados, transformando os resultados das consultas SQL em objetos Java manipuláveis.

Resumo Geral
    Organização: O código está bem estruturado, com responsabilidades bem definidas para cada classe.
    Uso de Padrões: Reutilização de métodos e encapsulamento de lógica.
    Leitura de Dados: A classe DataLoader encapsula o acesso ao banco, tornando o carregamento de dados robusto e reutilizável.
    Exibição: A formatação com printf torna a saída amigável para o usuário.
