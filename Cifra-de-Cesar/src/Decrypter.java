import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decrypter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		/*
		 * Construção do Alfabeto
		 */

		List<Character> alfabet = new ArrayList<>();

		Character letter;

		alfabet.add(' ');
		for (Integer i = 0; i < 26; i++) {
			letter = Character.toChars(i + 65)[0];
			alfabet.add(letter);
		}
		alfabet.add('Ç');

		Integer[] key = { 10, 8, 4, 11, 2 };

		String encrytedMessage;

		System.out.println("**DECRIPTER**\n");
		System.out.print("Insira a mensagem criptografada → ");

		encrytedMessage = sc.nextLine();

		/*
		 * Convertendo a mensagem decriptada em números
		 */

		List<Integer> decryptStepOne = new ArrayList<>();

		for (int i = 0; i < encrytedMessage.length(); i++) {
			if (Character.isDigit(encrytedMessage.charAt(i))) {
				String num1 = String.valueOf(Character.getNumericValue(encrytedMessage.charAt(i)));
				String num2 = String.valueOf(Character.getNumericValue(encrytedMessage.charAt(i + 1)));
				decryptStepOne.add(Integer.valueOf(num1 + num2));
				i++;
			} else {
				decryptStepOne.add(alfabet.indexOf(encrytedMessage.toUpperCase().charAt(i)));
			}
		}

		/*
		 * Subtraindo a key à mensagem codificada
		 */
		int counter = 5;
		int limitIterator = (decryptStepOne.size() / counter) + 1;
		for (int i = 1; i < limitIterator; i++) {
			counter *= i;
			int k = 0;
			for (int j = counter - 5; j < counter; j++) {
				decryptStepOne.set(j, decryptStepOne.get(j) - key[k]);
				k++;
			}
			counter = 5;
		}


		/*
		 * Gerando a mensagem encriptada
		 */
		String decryptStepTwo = "";

		for (int i = 0; i < decryptStepOne.size(); i++) {
			decryptStepTwo += alfabet.get(decryptStepOne.get(i));
		}
		
		
		System.out.println("\n*****************************\n↓ Mensagem descriptografada: ↓\n*****************************");
		System.err.println("→ " + decryptStepTwo.trim());

		sc.close();

	}

}
