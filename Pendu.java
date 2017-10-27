import java.util.Scanner;

/**
 * 
 * 
 * @author quentin
 *
 *Homework:
 *1)Case insensitive
 *2) Show to the user the letter already tried and failed
 *
 */


public class Pendu {
	
	//Check if there is only lower cases
	private static boolean trueWord(String inString){
		boolean flag = true;
		int sizeWord = inString.length();
		char[] chars = inString.toCharArray();
		for(int ii=0; ii<sizeWord; ii++){
			int a = chars[ii];
			if(a<97 || a>122){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	//Check if the letter is in the word
	private static boolean checkLetter(String inString, char inLetter){
		boolean flag = false;
		char[] chars = inString.toCharArray();
		int sizeWord = inString.length();
		for(int ii=0; ii<sizeWord; ii++){
			if(chars[ii] == inLetter){
				flag = true;
			}
		}
		return flag;
	}
	
	//Replace the letter in the word	
	private static void writeLetter(char[] chars, String inString2, char inLetter){
		int sizeWord = inString2.length();
		char[] chars2 = inString2.toCharArray();
		for(int ii=0; ii<sizeWord; ii++){
			if(chars2[ii] == inLetter){
				chars[ii] = inLetter;
			}
		}
	}
	
	//Display the word on the screen
	private static void display(char[] chars, int size){
		for(int ii=0; ii<size; ii++){
			System.out.print(chars[ii]);			
		}
		System.out.println();
	}
	
	//Count the number of letters in the word
	private static int countLetter(String inString, char inLetter){
		int count = 0;
		char[] chars = inString.toCharArray();
		int sizeWord = inString.length();
		for(int ii=0; ii<sizeWord; ii++){
			if(chars[ii] == inLetter){
				count++;
			}
		}		
		return count;
	}
	
	
	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		Scanner myScanner2 = new Scanner(System.in);
		
		String word;
		
		//Le programme demande un mot et si il n'est pas en minuscule il réitère la demande
		while(true){
			System.out.println("Please enter an only lower case word");
			String s = myScanner.nextLine();
			if(trueWord(s) == true){
				word = s;
				break;
			}
		}	
		
		//Le programme calcule la taille du mot et initialise l'affichage console
		int sizeWord = word.length();
		char[] affichage = new char[sizeWord];		
		for(int ii=0; ii<sizeWord; ii++){
			affichage[ii]='-';
		}
		
		int nbLives = 5;
		int count = sizeWord;
		display(affichage, sizeWord);
		while(true){
			System.out.println("Please choose a letter");
			String stringLetter = myScanner2.nextLine();	
			char[] glass = stringLetter.toCharArray();
			if(glass.length != 0){			
				char letter = glass[0];		
				if(checkLetter(word, letter) == true){
					writeLetter(affichage, word, letter);
					count = count - countLetter(word, letter);
				}else if(checkLetter(word, letter) == false){
					nbLives--;
					System.out.println("You now have " + nbLives + " tries");
					if(nbLives == 0){
						System.out.println("You lose!");
						break;
					}
				}
				if(count == 0){
					System.out.println("You win!");
					break;
				}
				display(affichage, sizeWord);			
			}
		}		
		System.out.print("Game over");
		
		myScanner.close();
		myScanner2.close();

	}
}
