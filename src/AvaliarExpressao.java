import java.util.Stack;


public class AvaliarExpressao {

	private String entrada; 
	private Stack<String> pilha = new Stack();
	
	public AvaliarExpressao(String entrada) throws IllegalArgumentException {
		this.entrada = entrada;
		this.separarExpressao();
		validarExpressao();
	}

	public String pop() {
		return pilha.pop();
	}
	
	private void separarExpressao()
	{
		String[] expressao = this.entrada.split(" ");
		for (int i = 0; i < expressao.length; i++){
			pilha.push(expressao[i]);
		}
		
	}

	public String converterPostFix() {
		Stack<String> temporaria = new Stack();
		String postfixo = "";
		String charAtual = "";
		int quantosInteiros = 0;
		
		for(int i = 0; i < pilha.size(); i++){
			charAtual = pilha.get(i);
			if (charAtual.equals("(")){
				temporaria.push(charAtual);
			}
			else if( charAtual.equals(")") ){
				postfixo += temporaria.pop() + " ";
				temporaria.pop();
			}
			else if ("+-/*".contains(charAtual)){
				temporaria.push(charAtual);
							}
			else {
				postfixo += charAtual + " ";
				quantosInteiros++;
			}
			
			if (pilha.size() - 1 == i){
				postfixo += temporaria.pop() + " ";
			}
		}
		
		return postfixo;
	}
	
	private void validarExpressao() throws IllegalArgumentException{
		for(int i = 0; i < pilha.size(); i++){
			if(!"0123456789()+-*/".contains(pilha.get(i)))
				throw new IllegalArgumentException("Apenas numeros, operadores e parenteses");
		}
		
	}

	public double calcularExpressao(String postfixo) throws ArithmeticException {
		Stack<Double> resultado = new Stack();
		String[] tokens = postfixo.split(" ");
		for(int i = 0; i < tokens.length; i++){
			if (!"+-/*".contains(tokens[i])){
				resultado.push(Double.parseDouble(tokens[i]));
			}
			else {
				double numero1, numero2, result;
				numero2 = resultado.pop();
				numero1 = resultado.pop();
				if (tokens[i].equals("+")){
					result = numero1 + numero2;
					resultado.push(result);
				}
				else if (tokens[i].equals("-")){
					result = numero1 - numero2;
					resultado.push(result);
				}
				else if (tokens[i].equals("*")){
					result = numero1 * numero2;
					resultado.push(result);
				}
				else if (tokens[i].equals("/")){
					if(numero2 == 0)
						throw new ArithmeticException("Divisor nao pode ser zero");
					result = numero1 / numero2;
					resultado.push(result);
				}
			}
		}
		return resultado.pop();
	}
	
}
