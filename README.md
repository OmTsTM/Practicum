# Practicum

Programa desenvolvido por Matteus Takeshi Dias para a vaga de estágio.

## Como executar?
Preparei 3 arquivos a fim de executar em "qualquer" SO (Linux, Windows ou Mac). 

Baixe todos os arquivos do GitHub e deixe-os no mesmo diretório.

* Windows: No Windows é necessário que a pasta bin do JDK esteja configurada nas variáveis de ambiente. Garantindo isto, basta executar o arquivo .bat "executeOnWindows.bat" e uma janela CMD abrirá, pronta para utilizar o programa (o script também compila as classes antes de executar);

* Linux: No Linux é necessário conceder permissões de escrita e leitura ao arquivo shell (.sh) "executeOnLinux.sh". Para fazer isto, abra o terminal do Linux e mude o diretório para onde os arquivos estão. Após isto, execute o comando: chmod +x executeOnLinux.sh 
Já com as permissões concedidas, agora podemos executar o script .sh com o comando: ./executeOnLinux

* Mac: No Mac a única solução que encontrei foi executar o .jar buildado pelo NetBeans (IDE). Portanto, acredito eu, basta abrir um terminal, ir até a pasta (change directory) onde estão os arquivos e executar o comando: ./executeOnMac


## Sobre o Programa:
O programa se encontra em um loop infinito. A única forma de pará-lo é digitando ao invés de "morning, ..." ou "night, ..." o valor -1. Fora isto, o programa funciona exatamente como os exemplos listados no PDF. O código contém vários comentários para facilitar o entendimento do mesmo.
