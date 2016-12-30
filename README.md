# GUARDIAN [![Build Status](https://travis-ci.org/bluesoft/guardian.svg?branch=master)](https://travis-ci.org/bluesoft/guardian) [![Coverage Status](https://coveralls.io/repos/github/bluesoft/guardian/badge.svg?branch=master)](https://coveralls.io/github/bluesoft/guardian?branch=master)


Projeto para centralizar e padronizar ambientes e frameworks de testes entre os projetos java da Bluesoft.


## Guardian Modules

* **guardian-core:**
Frameworks e setups basicos para os testes. Tudo que pode ser compartilhado independente do ambiente.


* **guardian-faker**
Framework de geração da dados faker. Um fork do projeto [java-faker](https://github.com/DiUS/java-faker) que podemos alterar e modificar para atender as necessidades de negócio da Bluesoft.


* **guardian-fixture**
Framework de geração de fixtures. Um conjunto de classes que facilitam a geração de objetos em grandes volumes e com herança.


* **guardian-spring**
Configurações e facilitadores para criar testes de integração em um ambiente spring.


* **sample**
Diretório com projetos de exemplo utilizando o Guardian.


# DEPLOY
Para gerar uma nova versão, basta commitar suas alterações e executar `./bin/deploy.sh`
