# Demo de Spring Data com Redis.

Redis é um banco de dados chave -> valor <K,V> que armazena estruturas de dados em memória para obter melhor desempenho.

https://redis.io/

Junto com Spring Data o exemplo foi desenvolvido para demonstrar a abstração do uso do banco de dados e servir como base para um treinamento interno.

Os dados inseridos no banco são mapeados em diferents tipos, até mesmo Enum, com um campo representando o TTL (Time to Live):

https://redis.io/commands/ttl


Uma classe é anotada com @Configuration, o spring a utliza para as configurações de execução e a porta utlizada pode ser *setada por esse meio.

Para executar, basta inicializar a classe Main.java pelo método padrão.
