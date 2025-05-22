# Gestor de tarefas
Esse é um projeto de um sistema web desenvolvido com java

# Descrição
Esse projeto consiste em um sistema de gerenciamento de tarefas, onde o usuário consegue criar, buscar, editar e deletar uma tarefa,
possui apenas 3 paginas, a principal é onde tem uma lista e opções de filtros para fazer uma busca precisa, cada item na lista
tem 2 botões que servem para poder editar ou deletar um produto, acima da lista tem 2 botões um deles serve para aplicar os filtros
e outro para criar/cadastrar uma tarefa

# Itens requisitados para esse projeto
- (a) JavaServerFaces
- (b) Banco de dados PostgreSQL

# Instalação e uso
1. Preparação do tomcat

Clonar repositório e extrair <br>
Abra o Eclipse IDE <br>
Vá em "File > Import..." <br>
No assistente de importação, expanda "General" e selecione "Existing Projects into Workspace" <br>
Clique em "Next" <br>
Clique em "Browse..." e navegue até a pasta raiz do projeto clonado <br>
Certifique-se de que o projeto esteja selecionado na lista "Projects". Se ele for um projeto Dynamic Web válido com os arquivos .project e .classpath, o Eclipse geralmente o reconhecerá e o listará <br>
**Importante:** Marque a caixa "Copy projects into workspace" se você quiser que o Eclipse crie uma cópia dos arquivos do projeto em sua área de trabalho padrão do Eclipse. Se você desmarcar, o projeto será referenciado do local onde você o clonou <br>
Clique em Finish <br>

Após a importação, o projeto deve aparecer no "Package Explorer" (ou Project Explorer) <br>
Clique com o botão direito no projeto e vá em "Properties" <br>
Na janela de "Properties", certifique-se de que as facetas "Dynamic Web Module" e "Java" (e talvez "JavaScript") estejam ativadas e configuradas corretamente <br>
Vá em "Project Facets". Se Dynamic Web Module e Java não estiverem marcados, marque-os. Se o Eclipse pedir para configurar, siga as instruções para selecionar a versão do Servlet/Java EE e do Java <br>

2. Configuração do Tomcat

Na aba "Servers" (se não estiver visível, vá em "Window > Show View > Servers"), clique com o botão direito e selecione "New > Server" <br>
Expanda Apache e selecione "Apache Tomcat v8.5 Server" <br>
Clique em "Next" <br>
Em "Tomcat installation directory", clique em "Browse..." e selecione a pasta onde você descompactou o Tomcat <br>
Clique em "Finish" <br>

3. Adicionar projeto ao servidor Tomcat

Na aba "Servers", clique com o botão direito no seu servidor Tomcat recém-criado <br>
Selecione "Add and Remove..." <br>
Na janela "Add and Remove", selecione o projeto  na lista "Available" e clique em "Add >" <br>
Certifique-se de que ele aparece na lista "Configured" <br>
Clique em "Finish" <br>
