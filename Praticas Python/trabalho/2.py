"""
   Disciplina  : ECO0015 - Técnicas de Programação
   Professor   : Wendley Souza da Silva
   Descrição   : Questão 02 - Trabalho - Python
   Autor(a)    : Izaias Machado Pessoa Neto
   Data atual  : 31/03/2021
"""

class Crypto:
    """    
        O construtor dessa função gera uma tabela, que seria a "tradução" das palavras
        originais para a lingua criptografada.
    """
    def __init__ (self):
        self.table = self.__generateTable()

    """
        Transforma nossa mensagem que é uma string em um array de inteiros.
    """
    def __toList (self, number):
        return [int(x) for x in str(number)]

    """
        Aqui, os digitos, que vem de um array de inteiros em uma string única.
    """
    def __toStr (self, digits):
        message = ''
        for digit in digits:
            message += str(digit)

        return message
    
    """
        Essa função gera o dicionário de tradução de zero a nove, ou seja, para cada
        algarismo possível.
    """
    def __generateTable (self):
        return [{ 'k': i, 'v': (i + 6) % 10 } for i in range(10)]

    """
        O nosso dicionário de tradução é invertido se necessário, para descriptografar.
    """
    def __inverseTable (self):
        self.table = [{ 'k': self.table[i]['v'], 'v': i } for i in range(len(self.table))]

    """
        Essa função retorna a tradução de um algarismo específico, de acordo com a tabela.
    """
    def __getFromDictionary (self, digit):
        for i in self.table:
            if digit == i['k']:
                return i['v']

    """
        Retorna um array embaralhado, onde a primeira posição é trocada com a terceira e a segunda
        com a quarta.
    """
    def __scramble (self, message):
        positions = [2, 3, 0, 1]
        return [message[i] for i in positions]

    """
        De acordo com um array de inteiros (digitos), retorna a tradução da "palavra".
    """
    def __translate (self, digits):
        hashed = []
        for digit in digits:
            value = self.__getFromDictionary(digit)
            hashed.append(value)
        return hashed

    """
        Transforma a string mensagem recebida em um array de inteiros com os digitos.
        Depois, é feita a tradução dos digitos. 
        Após isso, as os digitos traduzidos são embaralhados.
        Por fim, o array de digitos é transformado em uma string única.
    """
    def encrypt (self, message):
        digits = self.__toList(message)
        translated = self.__translate(digits)
        scrambled = self.__scramble(translated)
        hashed = self.__toStr(scrambled)    
        return hashed

    """
        Os passos para a descriptografia são exatamento os mesmo da criptografia, porém,
        é necessário a inverter o dicionário de tradução.
    """
    def decrypt (self, hashed):
        self.__inverseTable()
        message = self.encrypt(hashed)
        return message


class Screen:
    """
        O construtor da classe de telas, inicialmente define as opções e a respectiva ação.
    """
    def __init__ (self):
        self.exit = False
        self.options = [
            { 'number': 1, 'display': 'Criptografar', 'action': self.__encrypt },
            { 'number': 2, 'display': 'Descriptografar', 'action': self.__decrypt},
            { 'number': 0, 'display': 'Sair', 'action': self.__setupExit }
        ]

        self.__displayOptions()

    """
        Função que recebe o input do usuário e verifica se é válido.
    """
    def __getUserInput(self, message):
        valid = True
        try:
            user_input = str(input(message))
            number = int(user_input)
            valid = ((len(user_input) == 4) and (number > 0 and number < 10000))
        except:
            valid = False

        if not(valid):
            print('Você digitou um inválido para a senha. Tente novamente!')
            user_input = False
            return self.__displayOptions()
    
        return user_input
    
    """
        Mostra as opções declaradas no início e valida o input do usuário.
        Ao fim, se a variável de saida não for verdadeira, é exibido a tela de
        opções novamento. Caso contrário, o programa é finalizado.
    """
    def __displayOptions(self):
        print('========== Opções ==========')
        for i in range(len(self.options)):
            option = self.options[i]
            number = option['number']
            display = option['display']
            print(' {} - {}'.format(number, display))
        print('============================')

        choosen_option = -1
        valid = True

        try:
            choosen_option = int(input('Digite a opção desejada: '))
            valid = (choosen_option >= 0 and choosen_option <= 2) 
        except:
            valid = False

        if not(valid):
            print('Opção inválida, tente novamente.')

        for i in range(len(self.options)):
            option = self.options[i]
            number = option['number']
            action = option['action']

            if number == choosen_option:
                action()

        if not(self.exit): 
            return self.__displayOptions() 

    """
        Tela que pede números para criptografia e mostra o output.
    """
    def __encrypt(self):
        crypto = Crypto()

        input_value = self.__getUserInput('Digite um número para criptografar (Digite uma senha de quatro algarismos, ex: 0123): ')
        if input_value:
            encrypted = crypto.encrypt(input_value)
            print('{} criptografado é {}'.format(input_value, encrypted))

    """
        Tela que pede números para descriptografia e mostra o resultado.
    """
    def __decrypt(self):
        crypto = Crypto()
        input_value = self.__getUserInput('Digite um número para descriptografar (Digite uma senha de quatro algarismos, ex: 8967): ')
        if input_value:
            decrypted = crypto.decrypt(input_value)
            print('{} descriptografado é {}'.format(input_value, decrypted))

    """
        Mostra a tela de saida e muda o estado da variável de saida para verdadeiro.
    """
    def __setupExit(self):
        self.exit = True
        print('Obrigado por usar o programa, até a próxima ;)')

Screen()
