import static org.junit.Assert.*;

import org.junit.Test;


public class TestAvaliarExpressao {

	@Test
	public void testArmazenarMaisDeUmToken() throws IllegalArgumentException {
		String entrada = "3 + 2 * 1 / 0 ( ) -";
		AvaliarExpressao expressao1 = new AvaliarExpressao(entrada);
		
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

}
