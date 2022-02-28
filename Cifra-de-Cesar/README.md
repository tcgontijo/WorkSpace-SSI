# Cifra de Cesar

Programa desenvolvido em Java para realizar a criptografia e a descriptografia de uma mensagem utilizando um pradrão do tipo **Cifra de Cesar**.

Este programa recebe uma mensagem de A-z, incluindo Çç, e a criptografa com os seguintes métodos:
1. Transforma cada caracter da mensagem escrita em números correspondentes a um alfabeto criado com base na tabela ASCII;
2. Realiza a soma, a cada 5 caracteres, da `key = { 10, 8, 4, 11, 2}`, previamente estabelecida;
3. Captura a nova sequência numérica e retorna ao estado de letras conforme alfabeto* previamente criado;
*para situações em que o valor numérico estrapole o maior índice do alfabeto, retorna-se o valor numérico


## Exemplo:


### Encrypter:
-> Entrada: `TULIO CESAR GONTIJO`

-> Saída: `3029ptqjki30c28hkzp30qnzb`

### Dencrypter:
-> Entrada: `3029ptqjki30c28hkzp30qnzb`

-> Saída: `TULIO CESAR GONTIJO`
