"""
   Disciplina  : ECO0015 - Técnicas de Programação
   Professor   : Wendley Souza da Silva
   Descrição   : Exemplo 2 - Prática 03 - Python
   Autor(a)    : Izaias Machado Pessoa Neto
   Data atual  : 22/03/2021
"""
import os
import math

filename = 'resultados.txt'
working_dir = os.getcwd() + '/'
file_path = working_dir + filename

"""
    Função que recebe o input do usuário e verifica se é inteiro.
"""
def askForInput():
    try:
        number = int(input('Digite um número inteiro: '))
        return number
    except:
        return False

"""
    Funçào que gera as mensagens de erro/sucesso de acordo com o número.
"""
def generateStatusMessages(number):
    status_messages = [
        'O número digitado não é inteiro ou é menor que zero, tente novamente com um número válido.',
        'Não foi possível calcular o fatorial de {}, tente novamente com um número menor ;)'.format(number),
        'Ocorreu um erro ao salvar, verifique se você tem permissão para alterar o arquivo {}'.format(file_path),
        'O resultado da sua operação foi adicionado ao arquivo {} com sucesso!'.format(file_path)
    ]
    return status_messages

"""
    Valida o número recebido.
"""
def isNumberValid(number):
    return (number >= 0 and number != False)

"""
    Computa o fatorial e do número recebido por parâmetro e
    se não houver erro, retorna o resultado. Caso contrário,
    retorna falso.
"""
def computeFactorial(number):
    try:
        return math.factorial(number)
    except: 
        return False

"""
    Essa função recebe o número e o resultado do fatorial,
    depois é adicionado uma linha indicando o número e o
    seu respectivo fatorial.

    Se houver erro, retorna falso, se ocorrer tudo bem,
    retorna verdadeiro.
"""
def appendToFile(number, factorial):
    try:
        if (factorial != False):
            text = 'O fatorial de {} é {}\n'.format(number, factorial)
            file = open(file_path, 'a')
            file.write(text)
            file.close()
        return True
    except:
        return False

"""
    Essa função chama as anteriormente declaradas e salva
    seus resultados em um array result.

    É feita a iteraçào de todos os resultados e é retornado
    UMA mensagem do respectivo resultado.

    O array resultado é gerado apartir da função 
    generateStatusMessages.
"""
def handleNumbers(number):
    status_messages = generateStatusMessages(number)
    result_number_validation = isNumberValid(number)
    result_factorial = computeFactorial(number)
    file_append_status = appendToFile(number, result_factorial)
    results = [result_number_validation, result_factorial, file_append_status, False]

    for status in range(len(results)):
        not_result = not(results[status])
        message = status_messages[status]

        if (not_result):
            return message

"""
    Aqui, chamamos a função askForInput e armazenamos o resultado.
    
    Depois, passamos esse resultado para a funçào handleNumbers e
    armazenamos a mensagem de retorno.

    Por fim, imprimimos a mensagem armazenada.
"""
number = askForInput()
message = handleNumbers(number)
print(message)
