import static org.junit.Assert.*;

import org.junit.Test;


public class TestAvaliarExpressao {

	@Test
	public void testArmazenarMaisDeUmToken() {
		String entrada = "3 + 2 * 1 / 0 ( ) -";
		AvaliarExpressao expressao1 = new AvaliarExpressao(entrada);
		
		assertEquals('-', expressao1.pop());
		assertEquals(')', expressao1.pop());
		assertEquals('(', expressao1.pop());
		assertEquals('0', expressao1.pop());
		assertEquals('/', expressao1.pop());
		assertEquals('1', expressao1.pop());
		assertEquals('*', expressao1.pop());
		assertEquals('2', expressao1.pop());
		assertEquals('+', expressao1.pop());
		assertEquals('3', expressao1.pop());
	}

}
