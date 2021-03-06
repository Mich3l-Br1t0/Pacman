package ClassesPersonagens;

import ClassesGerais.Controle;
import ClassesGerais.ID;

public class FantasmaAssustado extends DecoratorFantasma {
	int posicaoControle;
	
	FantasmaAssustado(int x, int y, ID id, Controle controle, String cruzamento, int VxFantasma, int VyFantasma, Fantasmas fantaDecorado, int posicaoControle) {
		super(x, y, id, controle, cruzamento, VxFantasma, VyFantasma, fantaDecorado);
		
		setImage("Classic/Assustado1.png");
		this.comestivel = true;
		this.comido = false;
		this.posicaoControle = posicaoControle;
	}
	
	@Override
	public void tick() {
		super.tick();
		
		if (fantaDecorado.segundosAssustado == 5) {
			
			Fantasmas temp= fantaDecorado;
			if (temp instanceof FantasmaAzul) {
				chase = new ChaseBlue(controle,this);
			} else if (temp instanceof FantasmaVermelho) {
				chase = new ChaseRed(controle,this);
			} else if (temp instanceof FantasmaLaranja) {
				chase = new ChaseOrange(controle,this);
			} else if (temp instanceof FantasmaRosa) {
				chase = new ChasePink(controle,this);
			}
			
			this.comestivel = false;
			this.up = fantaDecorado.up;
			this.down = fantaDecorado.down;
			this.left = fantaDecorado.left;
			this.right = fantaDecorado.right;
			if (fantaDecorado.Vx>0) {
				this.setImage(fantaDecorado.right);
			} else if (fantaDecorado.Vx<0) {
				this.setImage(fantaDecorado.left);
			}else if (fantaDecorado.Vy>0) {
				this.setImage(fantaDecorado.down);
			}else if (fantaDecorado.Vy<0) {
				this.setImage(fantaDecorado.up);
			}
		}
		
		
	}
	
}
