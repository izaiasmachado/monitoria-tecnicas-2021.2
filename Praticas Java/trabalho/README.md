# Trabalho - Java - Técnicas de Programação
Consiste em um sistema para simular contas de um banco, suas variações e interações entre si. 

```
Disciplina      : ECO0015 - Técnicas de Programação
Professor       : Wendley Souza da Silva
Descrição       : Trabalho - Java
Autor(a)        : Izaias Machado Pessoa Neto
Data de Entrega : 12/03/2021
```

---

## Execução
Provavelmente você já recebeu o arquivo .jar, então siga os seguintes passos de acordo com seu sistema operacional.

### Se no Windows
Abra a pasta bin e clique duas vezes no arquivo Trabalho1.jar presente na pasta bin e pronto!

### Se no Linux (também deve funcionar no MacOS)
Navegue até a raíz da pasta e digite `chmod +x bin/Trabalho.jar` para marcar como executável,
e depois, basta abrir a pasta bin e clicar duas vezes para executar ou digite no terminal o seguinte 
`java -jar bin/Trabalho.jar`

## Disclaimer
A compilação que está sendo enviada foi feita utilizando JDK 8 (Máquina Linux). E funcionou sem recompilar no Java SE 8 do Windows 10.
```
java version "1.8.0_281"                                                                                                
Java(TM) SE Runtime Environment (build 1.8.0_281-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.281-b09, mixed mode)        
```
Se você possui uma versão mais antiga do Java, certifique de instalar o Java SE 8 (ou mais nova) para conseguir executar esse programa.
Se houver algum erro e se você não conseguir executar apenas clicando no arquivo, siga os seguintes passos para gerar o arquivo `.jar`.

## Gerar Arquivo .jar
Certifique-se que você tem o JDK 8 ou mais novo. E execute os seguintes comandos que transformam os arquivos .java em .class
e depois geram o arquivo .jar na pasta bin. Ou execute tudo em uma linha, dependendo so seu sistema operacional, como será
detalhado mais abaixo.

### Comandos
```sh
cd build # Entra na pasta build
javac -d . ../src/*.java # Compila os arquivos para .java para .class e salva na pasta build
jar cfm ../bin/Trabalho.jar META-INF/MANIFEST.MF trabalho/*.class # Transforma os arquivos .class em um único .jar na pasta bin
cd .. # Sai da pasta build
```

Navegue até a raíz do projeto utilizando o Terminal ou CMD e execute os seguintes comandos, de acordo com seu
sistema operacional.

### Linux e MacOS
```sh
cd build && javac -d . ../src/*.java && jar cfm ../bin/Trabalho.jar META-INF/MANIFEST.MF trabalho/*.class && cd ..
```

### Windows (Usando CMD)
```sh
cd build && javac -d . ..\src\*.java && jar cfm ..\bin\Trabalho.jar META-INF\MANIFEST.MF trabalho\*.class && cd ..
```

Agora, você possui um arquivo .jar que está pronto para ser executado.

## Árvore de Diretórios
Se houver alguma dúvida sobre as pastas e sua disposição, abaixo temos um esquema ilustrando
a organização dos arquivos.
```
.
├── bin
│   ├── Banco.class
│   ├── ContaEspecial.class
│   ├── ContaPoupanca.class
│   ├── Contas.class
│   ├── Principal.class
│   ├── Telas.class
│   └── Trabalho.jar
├── build
│   ├── META-INF
│   │   └── MANIFEST.MF
│   └── trabalho
│       ├── Banco.class
│       ├── ContaEspecial.class
│       ├── ContaPoupanca.class
│       ├── Contas.class
│       ├── Principal.class
│       └── Telas.class
├── README.md
└── src
    ├── Banco.java
    ├── ContaEspecial.java
    ├── ContaPoupanca.java
    ├── Contas.java
    ├── Principal.java
    └── Telas.java
```