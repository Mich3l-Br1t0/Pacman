package ClassesGerais;

import java.awt.Graphics;
import java.util.ArrayList;

import ClassesInterface.HUD;
import ClassesTabuleiro.Mapa;

public class Controle {
	public ArrayList<ObjetoJogo> objetos = new ArrayList<ObjetoJogo>();
	public double xPacman, yPacman;
	public double xRedGhost, yRedGhost;
	public char direcaoPacman = 'R';
	public Mapa mapa;
	public Jogo jogo;
	public int numeroPastilhas = 0;

	public Controle(Jogo jogo) {
		this.jogo = jogo;
		this.mapa = jogo.mapa;
	}

	public void tick() {
		for (int i = 0; i < objetos.size(); i++) {
			ObjetoJogo temp = objetos.get(i);
			temp.tick();
			if (temp.id == ID.Pacman) {
				if (numeroPastilhas == 0) {
					HUD.nivel++;
					objetos.clear();
					mapa = new Mapa(true, this, jogo, jogo.fabrica);
					try {
						mapa.constroiTabuleiro();
					} catch (Exception e) {
						
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < objetos.size(); i++) {
			ObjetoJogo temp = objetos.get(i);
			temp.render(g);
		}
	}

	public void addObjeto(ObjetoJogo o) {
		this.objetos.add(o);
	}

	public void removeObjeto(ObjetoJogo o) {
		this.objetos.remove(o);
	}

	public void setPosicaoPacman(double x, double y) {
		xPacman = x;
		yPacman = y;
	}
}
