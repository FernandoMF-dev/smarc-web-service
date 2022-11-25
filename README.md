# SMARC - Web Service

Configuração de uma comunicação entre Web Services para um sistema **SMARC (Sistema Multiagente Avaliador de Risco Cardíaco)**.<br>
Atividade proposta pelo professor **Vanderson José Idelfonso Silva** no curso de **Bacharelado de Sistemas de Informação**.<br>
Desenvolvida pelos alunos: **Fernando Martins** e **Mateus Padovan**.

**Instituto Federal de Educação, Ciência e Tecnologia do Espírito Santo (IFES). Campus Colatina**

<hr>
<hr>

## Compilando Projeto

Para compilar o projeto e gerar os arquivos `.jar` executáveis, entre no diretório do projeto (a pasta onde este arquivo deveria estar localizado) e digite este comando **Maven** no terminal:

```aidl 
$ mvn clean install -DskipTests -U
```

Tenha certeza de estar conectado a Internet.
Caso seja a primeira vez compilando esse projeto, precisará espera um pouco até que o **Maven** baixe as dependências necessárias.

Após o término com sucesso da compilação, o arquivos `.jar` estarão localizados dentro da pasta `target` em seus respectivos serviços.

Lembre-se de sempre recompilar o projeto sempre que fizer alguma alteração no código, ao menos que sua IDE já faça isso por você.
