package exercise3;

/**
 * This class calculate number of word in a text.
 * 
 * @author Siow Zhe Yi
 *
 */
public class TextLengthCalculator {
	
	/**
	 * This method calculate number of word in a text.
	 * 
	 * @return number of word in a text
	 */
	public int getLengthText(String text) {
		
		int count = 0;
		//Splits each line into words  
        String words[] = text.split("");  
//		System.out.println("text[] is: " + words);

        //Counts each word  
        count += words.length; 
//		System.out.println("count is: " + count);

		return count;
		
	}
}
