package states;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import animacoes.Button;
import controler.Save;

public class NewGameState extends BasicGameState{

	private Image[] escolhas = new Image[3];
	private Image[] warrior = new Image[4];
	private Image[] mage = new Image[4];
	private Image[] archer = new Image[4];
	private Button direita;
	private Button esquerda;
	private Button continuar;
	
	private Image escolha;
	private Image personagemImage;
	private int posX, posY;
	private int estagio = 0;
	private int personagem = 0;
	
	private int timePress;
	private int[] escolhasPersonagem = new int[3];
	private Save save;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		escolhas[0] = new Image("customize/olaf.png"); 
		escolhas[1] = new Image("customize/erik.png"); 
		escolhas[2] = new Image("customize/baelog.png");

		for(int i=0; i<4; i++)
		{
			warrior[i] = new Image("warrior/"+(i+1)+"/attack/attack_1.png");
			mage[i] = new Image("mage/"+(i+1)+"/attack/attack_1.png");
			archer[i]= new Image("archer/"+(i+1)+"/attack/attack_1.png");
		}


		escolha = escolhas[0];
		personagemImage = warrior[0];
			
		esquerda = new Button("esquerda", 160, 300);
		direita = new Button ("direita", 620, 300);
		continuar = new Button ("Continuar", 310, 180);
		timePress = 0;
		estagio = 0;
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame sbg, int delta) throws SlickException {
		posX = Mouse.getX();
		posY = Mouse.getY();
		timePress+=delta;
		if(estagio == 0){
			if(esquerda.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					personagem --;
					if(personagem <0)
						personagem = 3;
					personagemImage = warrior[personagem];
				}
			}
			
			if(direita.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					personagem++;
					if(personagem >3)
						personagem = 0;
					personagemImage = warrior[personagem];
				}
			}
			
			if(continuar.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					escolha = escolhas[1];
					personagemImage = mage[0];
					escolhasPersonagem[0] = personagem;
					personagem = 0;
					estagio++;
				}
			}
		}
		else if(estagio == 1){
			if(esquerda.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					personagem --;
					if(personagem <0)
						personagem = 3;
					personagemImage = mage[personagem];
				}
			}
			
			if(direita.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					personagem++;
					if(personagem >3)
						personagem = 0;
					personagemImage = mage[personagem];
				}
			}
			if(continuar.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					escolha = escolhas[2];
					personagemImage = archer[0];
					escolhasPersonagem[1] = personagem;
					personagem = 0;
					estagio++;
				}
			}
		}
		else if(estagio == 2){
			if(esquerda.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					personagem --;
					if(personagem <0)
						personagem = 3;
					personagemImage = archer[personagem];
				}
			}
			
			if(direita.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					timePress = 0;
					personagem++;
					if(personagem >3)
						personagem = 0;
					personagemImage = archer[personagem];
				}
			}
			if(continuar.inArea(posX, posY)){	
				if(Mouse.isButtonDown(0) && timePress > 200){
					escolhasPersonagem[2] = personagem;
					save = new Save(escolhasPersonagem[0]+1, escolhasPersonagem[1]+1, escolhasPersonagem[2]+1);
					save.createSave();
					sbg.enterState(9);
				}
			}
			
		}
		
	}
	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		escolha.draw(0,0);
		personagemImage.draw(280,200);
		esquerda.getButton().draw(esquerda.getX(),600-esquerda.getY());
		direita.getButton().draw(direita.getX(),600-direita.getY());
		continuar.getButton().draw(continuar.getX(),600-continuar.getY(), 189, 63);
		
		
	}



	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 8;
	}

}
