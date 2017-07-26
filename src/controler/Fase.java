package controler;

public class Fase {
	private String nome;
	private Personagem[] personagens = new Personagem[6];
	private int personagemAtual;
	
	public Fase(String nome, Inimigo a, Inimigo b, Inimigo c, Jogador j)
	{
		this.nome = nome;
		personagens[0] = a;
		personagens[1] = b;
		personagens[2] = c;
		personagens[3]= j.getHerois(0);
		personagens[4]= j.getHerois(1);
		personagens[5]= j.getHerois(2);
		personagemAtual = 2;
		
		
	}
	
	public boolean estaVivo(int i)
	{
		if(personagens[i].getVidaAtual() > 0)
		{
			return true;
		}
		return false;
	}
	
	public int vezJogador()	{
		while(true)
		{
			personagemAtual++;
			
			if(personagemAtual > 5)
				personagemAtual = 0;
			
			if(personagens[personagemAtual].getVidaAtual() > 0)
				return personagemAtual;
		}
	}
	
	public boolean timeInimigoVivo()
	{
		for(int i=0; i<3; i++)
		{
			if(estaVivo(i))
				return true;
		}
		return false;
	}
	
	public boolean timeHeroiVivo()
	{
		for(int i=3; i<6; i++)
		{
			if(estaVivo(i))
				return true;
		}
		return false;
	}
	
	public int combateJogadores(int vezJogador)
	{
		int jogadorAlvo = 0;
		// Vez do Inimigo?
		//System.out.println("AEHOO");
		if(vezJogador < 3)
		{
			for(int i=5; i>=3; i--)
			{
				if(estaVivo(i))
				{
					jogadorAlvo = i;
				}
			}
			personagens[jogadorAlvo].perderVida(personagens[vezJogador].getDano());
			personagens[vezJogador].getAnimacao().attack();
			
			System.out.println(personagens[vezJogador].getNome() + " causou " + personagens[vezJogador].getDano()+ "de dano a " + personagens[jogadorAlvo].getNome());
			if(!estaVivo(jogadorAlvo))
			{
				System.out.println(personagens[jogadorAlvo].getNome() + " Morreu");
				personagens[jogadorAlvo].getAnimacao().morreu();
				return jogadorAlvo;
			}
			return jogadorAlvo;
		}
		// Vez Aliado
		else
		{
			//System.out.println("Escolha o alvo da ação:");
			for(int i=0; i<3;i++)
			{
				if(estaVivo(i))
				{
					jogadorAlvo = i;
				}
			}
			personagens[jogadorAlvo].perderVida(personagens[vezJogador].getDano());
			personagens[vezJogador].getAnimacao().attack();
			System.out.println(personagens[vezJogador].getNome() + " causou " + personagens[vezJogador].getDano()+ "de dano a" + personagens[jogadorAlvo].getNome());
			if(!estaVivo(jogadorAlvo))
			{
				System.out.println(personagens[jogadorAlvo].getNome() + " Morreu");
				return jogadorAlvo;
			}
			return jogadorAlvo;
		}
	}

	public Personagem getPersonagens(int i) {
		return personagens[i];
	}

	
}
