import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encrypter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		/*
		 * Construção do Alfabeto
		 */

		List<Character> alfabet = new ArrayList<>();

		Character letter;

		alfabet.add(' ');
		for (int i = 0; i < 26; i++) {
			letter = Character.toChars(i + 65)[0];
			alfabet.add(letter);
		}
		alfabet.add('Ç');

		/*
		 * Imprime Alfabeto
		 */
//		for (char l : alfabet) {
//			System.out.println(alfabet.indexOf(l) + ": " + l);
//		}

		Integer[] key = { 10, 8, 4, 11, 2 };

		String message;

		System.out.println("**ENCRYPTER**\n");
		System.out.print("Insira a mensagem a ser cifrada → ");

		message = sc.nextLine().toUpperCase();

		List<Integer> messageNumered = new ArrayList<>();
		;

		/*
		 * Conversão da mensagem em números conforme o alfabeto supra criado
		 */
		for (int i = 0; i < message.length(); i++) {
			messageNumered.add(alfabet.indexOf(message.charAt(i)));
		}

		/*
		 * Ajustando o tamanho da messageEconded para multiplo de 5 e acrescentando
		 * zeros para completar
		 */
		if (!(messageNumered.size() % 5 == 0)) {
			Integer newMessageSize = (int) (Math.ceil((messageNumered.size() / 5) + 1) * 5);
			Integer differenceSize = newMessageSize - messageNumered.size();
			for (int i = 0; i < differenceSize; i++) {
				messageNumered.add(0);
			}

		}

		/*
		 * Somando a key à mensagem codificada
		 */
		int counter = 5;
		int limitIterator = (messageNumered.size() / counter) + 1;
		for (int i = 1; i < limitIterator; i++) {
			counter *= i;
			int k = 0;
			for (int j = counter - 5; j < counter; j++) {
				messageNumered.set(j, messageNumered.get(j) + key[k]);
				k++;
			}
			counter = 5;
		}

		/*
		 * Gerando a mensagem encriptada
		 */
		String messageEnconded = "";

		for (int i = 0; i < messageNumered.size(); i++) {
			if (messageNumered.get(i) > (alfabet.size() - 1))
				messageEnconded += messageNumered.get(i);
			else {
				messageEnconded += alfabet.get(messageNumered.get(i));
			}
		}

		System.out.println("\n***************************\n↓ Mensagem criptografada: ↓\n***************************");
		System.err.println("→ " + messageEnconded.toLowerCase());
		
		sc.close();
	}

}
