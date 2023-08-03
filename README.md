# Projeto AtmzStore
AtmzStore - Produtos de A a Z.

Ideias de projeto podem vir de: 
 * (https://www.amazon.com.br/)
 * (https://www.magazineluiza.com.br/)


## Integrantes do grupo 
 * Lucas Matias da Silva - Lucasmatiassilva2022@gmail.com
 * Jeane Vitória Félix da Silva - jeanevitoria994@gmail.com
 * Camila de Almeida Silva - camila.almeidasilva@ufrpe.br 
 * Lucas Xavier de Almeida - lucasxavierdealmeida@gmail.com

## Descrição geral do projeto 

<h3>1-Finalidade</h3>

A principal funcionalidade do sistema AtmzStore é permitir que os usuários comprem artigos eletrônicos por meio de uma plataforma de vendas.

<h3>2-Usuários</h3> 
Compradores comuns que desejam buscar, visualizar e comprar artigos eletrônicos disponíveis na loja.
Administradores responsáveis por gerenciar o catálogo de produtos, clientes e suas informações.

<h3>2.1-Tipos de Usuário</h3> 

--> Compradores comuns:

- Buscar produtos.
- Colocar produtos no carrinho.
- Comprar produtos.

--> Administradores:

- Gerenciar catálogo de produtos (adicionar, remover e editar produtos).
- Gerenciar clientes (adicionar e remover clientes, atualizar suas informações).

<h3>3-Serviços</h3>

- Buscar produtos: Os usuários devem poder pesquisar e visualizar informações sobre os produtos disponíveis na loja.
- Colocar produtos no carrinho: Os clientes devem ser capazes de adicionar produtos de interesse ao carrinho de compras.
- Comprar produtos: Os clientes devem ter a opção de finalizar a compra dos produtos selecionados.
- Gerenciar catálogo de produtos: Os administradores precisam poder adicionar, remover e editar informações sobre os produtos disponíveis para venda.
- Gerenciar clientes: Os administradores devem ter a capacidade de adicionar e remover clientes, bem como atualizar suas informações.

## Requisitos do projeto

* **REQ1** - O sistema deve controlar o acesso através de login e senha. Os usuários do sistema serão do tipo administrador e cliente.
* **REQ2** - O sistema deve permitir a venda de produtos previamente cadastrados e salvá-los como em um histórico de vendas por cliente. Cada venda de produto deve ser associada a um cliente único.
* **REQ3** - O sistema deve permitir o gerenciamento (Create, Recover, Update e Delete - CRUD) de clientes e produtos e essa ação pode ser feita por administradores.
* **REQ4** - O Repositório de Produtos não deve permitir o  cadastro de produtos com o mesmo ID.
* **REQ5** - O Repositório de Clientes deve validar a idade do cliente antes de adicioná-lo à ArrayList de Clientes, não permitindo o cadastro de menores de 18 anos.
* **REQ6** - O sistema deve ser estruturado em camadas, de acordo com o estilo arquitetural MVC.
* **REQ7** - A classe Controlador deve seguir o padrão Singleton.
* **REQ8** - A GUI deve apresentar uma tela de detalhes do produto, na qual deve ser exibida a descrição do produto selecionado.
* **REQ9** - A classe Produto deverá apresentar o método equals e o método toString para todos os seus atributos.
* **REQ10** - O Controlador não pode permitir que clientes comprem produtos que estão fora de estoque.
* **REQ11** - A GUI deve exibir, para o cliente, os ítens que foram adicionados ao seu carrinho de compras, bem como o preço total de todos os produtos presentes.
* **REQ12** - A GUI deve apresentar uma tela de finalização de compra, na qual o cliente deve informar o tipo de pagamento, confirmar os seus dados pessoais e a compra do produto.
* **REQ13** - A GUI deve apresentar uma tela de busca de produtos, na qual o cliente poderá procurar os produtos da loja por nome, ID ou categoria.
* **REQ14** - O Repositório de Clientes não deve permitir o cadastro de clientes com o mesmo email.
* **REQ15** - O controlador não deve permitir outras formas de pagamento além de boleto e cartão de credito.


<div style="display: inline-block">
  <img align="center" height="30" width="40" src="https://drive.google.com/file/d/1S3KBHhZy_M3l_8QCXsiiWwLB9AmCdmls/view?usp=drivesdk">