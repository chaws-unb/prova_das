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

	public String converterPostFix() {
		Stack<Integer> temporaria = new Stack();
		String postfixo = "";
		Integer charAtual = ' ';
		
		for(int i = 0; i < pilha.size(); i++){
			charAtual = pilha.get(i);
			if('0' <= charAtual && charAtual <= '9'){
				postfixo += String.valueOf(charAtual) + " ";
			}
			else if (charAtual == '('){
				temporaria.push(charAtual);
			}
			else if (charAtual == ')'){
				postfixo += temporaria.pop() + " ";
			}
			else {
				temporaria.push(charAtual);
			}
			if (pilha.size()-1 == i){
				postfixo += temporaria.pop() + " ";
			}
			
		}
		
		return postfixo;
	}
	
}
