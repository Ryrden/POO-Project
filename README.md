#### UNIVERSIDADE DE SÃO PAULO

#### INSTITUTO DE CIÊNCIAS MATEMÁTICAS E DE COMPUTAÇÃO

#### DEPARTAMENTO DE CIÊNCIAS DE COMPUTAÇÃO

### Prof. José Fernando Rodrigues Júnior 

## SCC 0504 – Programação Orientada a Objetos

# Projeto Jogo - Adventure of Lolo 2 - especificação

Projeto do jogo Adventure of Lolo 2.
- Projeto em dupla;
- Implemente as 3 fases do jogo Adventure of Lolo 2, assim como se pode observar no video ["Adventures of Lolo 2 (NES)"](https://www.youtube.com/watch?v=PjmBAGOGIU4)
- Uma versão bem simplificada da interface já está disponível na página da disciplina.
Requisitos:
1. o jogo deve funcionar de acordo com o original, a aparência não precisa ser a mesma.
Sugere-se criar screenshots do jogo original e usar um editor simples como o paint brush para extrair partes da imagem (como os personagens e o background) e reproduzir a aparência do original.

2. estude o jogo antes de implementar, e implemente todos os elementos do original.
   
3. controle do jogo – número de vidas, início, fim, reinício, passagem para uma nova fase, assim como no original. Opcional: ao se terminar a 3 ª. fase, coloque uma mensagem de fim de jogo com o nome dos criadores, e mais o que quiser.

4. Implemente uma classe abstrata Elemento. Esta classe, por ser abstrata, não pode ser instanciada, mas contém tudo aquilo que é
comum às outras classes. Principalmente, nesta classe estão definidos os métodos abstratos que deverão ser sobrescritos (polimorfismo) nas subclasses. Como exemplo temos o desenho(), move(), pegaPosicao(), atira(), etc. Crie as subclasses de Elemento; um possível projeto é ter subclasses Estatico e Animado, e assim por diante. *Obs.: outros projetos (jogos) são aceitos, consulte o professor.*

5. Crie uma classe Fase que será composta por um conjunto de elementos desenhados no início de cada nova Fase; dessa maneira, trocar de fase significa apenas substituir o objeto fase atual.

6. Altere o código para que personagens possam ser adicionados a qualquer momento a partir de arquivos serializados, um personagem por arquivo.

Faça o melhor jogo que puder, exercitando sua criatividade, e explorando os recursos da programação orientada a objetos.