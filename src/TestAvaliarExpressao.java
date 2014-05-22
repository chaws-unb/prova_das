import static org.junit.Assert.*;

import org.junit.Test;


public class TestAvaliarExpressao {

	@Test
	public void testArmazenarMaisDeUmCaractere() throws IllegalArgumentException {
		String infixo = "3 + 2 * 1 / 0 ( ) -";
		AvaliarExpressao expressao1 = new AvaliarExpressao(infixo);
		
		assertEquals("-", expressao1.pop());
		assertEquals(")", expressao1.pop());
		assertEquals("(", expressao1.pop());
		assertEquals("0", expressao1.pop());
		assertEquals("/", expressao1.pop());
		assertEquals("1", expressao1.pop());
		assertEquals("*", expressao1.pop());
		assertEquals("2", expressao1.pop());
		assertEquals("+", expressao1.pop());
		assertEquals("3", expressao1.pop());
	}
	
	@Test
	public void testConversaoPostfix() throws IllegalArgumentException{
		String infixo = "( 2 + 2 ) / ( 1 + 1 )";
		AvaliarExpressao expressao1 = new AvaliarExpressao(infixo);
		assertEquals("2 2 + 1 1 + / ", expressao1.converterPostFix());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidarExpressao() throws IllegalArgumentException{
		String infixo = "( 2 + 2 ) / ( 1 + 1 ) l";
		AvaliarExpressao expressao1 = new AvaliarExpressao(infixo);
	}
	
	
	@Test
	public void testVerificarResultado(){
		String infixo = "( 2 + 2 ) / ( 1 + 1 )";
		AvaliarExpressao expressao1 = new AvaliarExpressao(infixo);
		String postfixo = expressao1.converterPostFix();
		assertEquals(2.0, expressao1.calcularExpressao(postfixo), 0.1);
		
		infixo = "( 2 - 2 ) / ( 1 + 1 )";
		expressao1 = new AvaliarExpressao(infixo);
		postfixo = expressao1.converterPostFix();
		assertEquals(0.0, expressao1.calcularExpressao(postfixo), 0.1);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testVerificarResultadoComExcecao() throws IllegalArgumentException{
		String infixo = "( 2 + 2 ) / ( 1 + 1 )";
		AvaliarExpressao expressao1 = new AvaliarExpressao(infixo);
		expressao1.calcularExpressao(infixo);
				
	}
		
	@Test(expected=ArithmeticException.class)
	public void testValidarExpressaoDivisaoPorZero() throws ArithmeticException{
		String infixo = "( 2 + 2 ) / ( 1 - 1 )";
		AvaliarExpressao expressao1 = new AvaliarExpressao(infixo);
		String postfixo = expressao1.converterPostFix();
		expressao1.calcularExpressao(postfixo);
	}
}
