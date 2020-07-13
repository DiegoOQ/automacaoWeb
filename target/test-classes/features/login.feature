#language: pt
Funcionalidade: Anuncios iCarros

  @iCarros @teste1
  Cenário: criar um arquivo de dados com informações dos veículos
    Dado que estou logado na aplicação
    Quando preencho dados da pesquisa
    Então valido valor à vista dos anuncios
    E Crio um arquivo de dados contendo marca, modelo, ano, km, cor, câmbio e valor à vista de cada veiculo retornado
    
    @iCarros @teste2
    Cenário: Validar informações do canal com arquivo de massa
    Dado que estou logado na aplicação
    Quando preencho dados da pesquisa
    Então Valido informações do canal com arquivo de massa
