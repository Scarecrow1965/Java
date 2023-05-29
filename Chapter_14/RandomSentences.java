// Exercise 14.5
/*(Random Sentences)
 * Write an application that uses random-number generation to create sentences.
 * Use four arrays of strings called article, noun, verb and preposition.
 * Create a sentence by selecting a word at random from each array in the 
 * following order: article, noun, verb, preposition, article and noun.
 * As each word is picked, concatenate it to the previous words in the sentence.
 * The words should be separated by spaces.
 * When the final sentence is output, it should start with a capital letter and end with a period.
 * The application should generate and display 20 sentences.
 * The article array should contain the articles "the", "a", "one", "some" and "any";
 * the noun array should contain the nouns "boy", "girl", "dog", "town" and "car";
 * the verb array should contain the verbs "drove", "jumped", "ran", "walked" and "skipped";
 * the preposition array should contain the prepositions "to", "from", "over", "under" and "on".
 */

import java.util.Random;

public class RandomSentences
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		String[] article = {"the", "a", "one", "some", "any"};
		String[] noun = {"boy", "girl", "dog", "town", "cat"};
		String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
		String[] preposition = {"to", "from", "over", "under", "on"};
		int sentenceMax = 20;
		int sentenceNumber = 0;

		Random random = new Random();

		for( ; sentenceNumber <= sentenceMax; sentenceNumber++)
		{
//			// Option 1
//			// First pick a random article and place it into the sentence
//			String artic = article[random.nextInt(5)];
//			// now to create the Capital letter for the first character of the article
//			String firstLetter = artic.substring(0, 1);
//			// now Capitalize it
//			firstLetter = firstLetter.toUpperCase();
//			String leftoverLetters = artic.substring(1, artic.length() );
//			String capArt = firstLetter + leftoverLetters;
//
//			// * Create a sentence by selecting a word at random from each array in the 
//			// * following order: article, noun, verb, preposition, article and noun.
//			// So now randomly select rest of sentence 
//			String random1noun = noun[random.nextInt(5)];
//			String randomverb = verb[random.nextInt(5)];
//			String randomprep = preposition[random.nextInt(5)];
//			String randomarticle = article[random.nextInt(5)];
//			String random2noun = noun[random.nextInt(5)];
//			// Combine all parts of the sentence 
//			String sentence = "";
//			sentence = capArt + " " + random1noun + " " + randomverb + " " + randomprep +
//					" " + randomarticle + " " + random2noun + ".";

//			// Option 2
//			String sentence2 = "";
//			sentence2 = article[random.nextInt(5)] + " " + noun[random.nextInt(5)] +
//					" " + verb[random.nextInt(5)] + " " + preposition[random.nextInt(5)] +
//					" " + article[random.nextInt(5)] + " " + noun[random.nextInt(5)] + ".";
//			String output = sentence2.substring(0,1).toUpperCase() + sentence2.substring(1);
			
			// Option 3
			// using the concatenating feature
			String sentence = "";
			String sentence1 = sentence.concat(article[random.nextInt(5)]) + " ";
			String sentence2 = sentence1.concat(noun[random.nextInt(5)]) + " ";
			String sentence3 = sentence2.concat(verb[random.nextInt(5)]) + " ";
			String sentence4 = sentence3.concat(preposition[random.nextInt(5)]) + " ";
			String sentence5 = sentence4.concat(article[random.nextInt(5)]) + " ";
			String sentence6 = sentence5.concat(noun[random.nextInt(5)]) + ".";
			String output = "";
			output = sentence6.substring(0,1).toUpperCase() + sentence6.substring(1);

			// * Create a sentence by selecting a word at random from each array in the 
			// * following order: article, noun, verb, preposition, article and noun.
			System.out.printf("Sentence # %d %n", sentenceNumber);
//			System.out.println("Option 1:");
//			System.out.println(sentence);
//			System.out.println("Option 2:");
//			System.out.println(output);
//			System.out.println("Option 3:");
			System.out.println(output);
//			System.out.println("Option 4:"); // Option 4 works
//			System.out.printf("%s %s %s %s %s %s.%n", capArt, random1noun, randomverb, randomprep, randomarticle, random2noun);
		}

	} //end main method

} // end class RandomSentences
