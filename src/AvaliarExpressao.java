import java.util.Stack;


public class AvaliarExpressao {

	private String entrada; 
	private Stack<Integer> pilha = new Stack();
	
	public AvaliarExpressao(String entrada) {
		this.entrada = entrada;
		this.separarExpressao();
	}

	public int pop() {
		return pilha.pop();
	}
	
	private void separarExpressao()
	{
		String[] expressao = this.entrada.split(" ");
		for (int i = 0; i < expressao.length; i++){
			char caractere = expressao[i].charAt(0); 
			pilha.push((int)caractere);
		}
		
	}
	
}
