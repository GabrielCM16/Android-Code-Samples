# QR code com validade

## todos os qr codes geram a mesma foto

para mudar isso é ultilizado o current millis junto com o que se deseja colocar no qr code

## para verificar a validade

para verificar a validade do mesmo, na hora da leitura o qr code possui junto o current millis, sendo necessario comparar o current millis do qr code com o current millis atual (hora em que foi feita a leitura), caso a diferença seja por exemplo, maior que 180.000 milisegundos (3 minutos) o qr code ja pode ser considerado invalido pois se passaram mais de 3 minutos após ele ser gerado comparado com o momento da leitura
