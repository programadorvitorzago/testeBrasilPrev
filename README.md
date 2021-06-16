# testeBrasilPrev
API RESTfull para entidade Cliente

## Execução
A API está desenvolvido utilizando SpringBoot.
Para inniciar, execute o arquivo jar na pasta TARGET testeBrasilPrev-0.0.1-SNAPSHOT.jar
```
java -jar testeBrasilPrev-0.0.1-SNAPSHOT.jar
```

## Para utilizar a API
Métodos:
 - **/API/IsAlive**
   - Retorna "OK" para qualquer requisiçao. Útil para verificar se a API está on-line.
   
 - **/cliente/**
   - API RESTFull para CRUD de cliente.
   
Exemplos:
Verificar se a API está on-line:
```
curl -X POST "http://localhost:8080/API/IsAlive"
```
   - Retorna "OK" para qualquer chamada.
   
Cadastrar novo cliente
```
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/cliente --data '{
  "nome": "Vitor Zago"
  , "cpf": "000000000-00"
  , "endereco": "Este enredeço"
}'
```
   - Retorna no corpo da resposta um JSON do novo cliente cadastrado.
   
Lista todos os clientes
```
curl -X GET -H 'Content-Type: application/json' -i http://localhost:8080/cliente
```
   - Retorna no corpo da resposta um JSON com a lista de todos os clientes.
   
Lista os dados do cliente de ID = 2
```
curl -X GET -H 'Content-Type: application/json' -i http://localhost:8080/cliente/2
```
   - Retorna no corpo da resposta um JSON com os detalhes do cliente.

   
Atualiza os valores do cliente de ID = 1 com os novos valores enviados pela requisição de entrada
```
curl -X PUT -H 'Content-Type: application/json' -i http://localhost:8080/cliente/1 --data '{
  "nome": "Vitor Augusto Zago"
  , "cpf": "111111111-11"
  , "endereco": "Novo endereço"
}'
```
   - Retorna no corpo da resposta um JSON com os novos valores do cliente.
   
Remove o cliente de ID = 1 
```
curl -X DELETE -H 'Content-Type: application/json' -i http://localhost:8080/cliente/1
```
   - Retorna status 204, informando que a deleção ocorreu corretamente.


