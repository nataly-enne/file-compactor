# File Compactor
Projeto de implementação de um _heap_ e uma _binary tree_ para criar um programa que comprima e descomprima arquivos de 
textos utilizando um algoritmo chamado "Codificação de Huffman" para a Disciplina de Estruturas de Dados Básicas II, ministrada 
pelo professor Waldson Patricio, no Instituto Metrópole Digital na Universidade Federal do Rio Grande do Norte.

# What is it?
A ideia do algoritmo é ao invés de utilizar a tabela ASCII, criar uma tabela própria onde os caracteres mais utilizados são representados por menos bits do que
os caracteres mais utilizados. A ideia se baseia no fato de que se um texto não
utiliza todos os 256 caracteres, não é necessário utilizar 8 bits para cada um dos
caracteres da mensagem. Se, por exemplo, a letra “a” é mais utilizada em uma mensagem, eu posso atribuir um código que utiliza poucos bits para a letra “a”. Já os
caracteres menos utilizados recebem código com uma quantidade maior de bits,
pois são utilizados com menor frequência.

#### Há um arquivo .pdf com a descrição completa do projeto.

### Compilação:
#### Para comprimir: 
```bash
    java -jav projeto.jar compress <local do aquivo de texto> <local e novo nome para aquivo binario> <local e novo nome para arquivo de chave>
```
#### Para extrair:
```bash
    java -jav projeto.jar compress <local aquivo binario> <local arquivo de chave> <local e novo nome aquivo de texto>
```



