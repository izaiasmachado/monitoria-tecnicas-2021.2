intervals = (
    ('dia', 86400),  
    ('hora', 3600),  
    ('minuto', 60),
    ('segundo', 1),
)

def displayTime(seconds):
    result = []

    for name, count in intervals:
        value = seconds // count
        
        if value > 0:
            seconds -= value * count
            if value > 1:
                name += 's'
        
        result.append("{} {}".format(value, name))
    return ', '.join(result)

seconds = int(input("Digite a quantidade de segundos para converter: "))
print(displayTime(seconds))