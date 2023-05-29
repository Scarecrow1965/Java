// Exercise 2.33
// Create a BMI calculator that reads the user’s weight in pounds
// and height in inches (or, if you prefer, the user’s weight in kilograms
// and height in meters), then calculates and displays the user’s body mass index.

import java.util.Scanner; // program uses class Scanner

public class Exercise2_33 {
	 // main method begins execution of Java application
	public static void main(String[] args) {

	    // create Scanner to obtain input from command line
	    Scanner input = new Scanner(System.in);

	    System.out.print("In order to calculate your BMI, which method would you like to use?\n");
	    System.out.print("Enter 1 for Standard (Pounds, Feet and Inches); or\n");
	    System.out.print("Enter 2 for Metric (Kilos, meters)\n");
	    int scale = input.nextInt(); // read first number from user 
	    
	    if(scale==1) { // if standard, then follow this route}
	    	System.out.print("Enter your weight? (lbs)"); // prompt #1
	    	float weightInPounds = input.nextInt(); // read first number from user 

	    	System.out.print("Enter your height? (ft)"); // prompt #2
	    	float heightInFeet = input.nextInt(); // read second number from user 
	      
	    	System.out.print("Enter your height? (in)"); // prompt #3
	    	float heightInInches1 = input.nextInt(); // read third number from user
	    
	    	float heightInInches = (heightInFeet * 12) + heightInInches1; // to calculate total heightInInches
	    	
	    	float BMIStandard = ((weightInPounds * 703) / (heightInInches * heightInInches));
	    	System.out.printf("Your BMI is: %.1f%n%n", BMIStandard);
	    } // end if BMIStandard
	    
	    if(scale==2) { // if metric, then follow this route)
	    	System.out.print("Enter your weight? (kg)"); // prompt #1
	    	float weightInKilos = input.nextInt(); // read first number from user 

	    	System.out.print("Enter your height? (cm)"); // prompt #2
	    	float heightInCms = input.nextInt(); // read second number from user 
	    	
	    	float heightInMeters = heightInCms / 100;
	    	
	    	float BMIMetric = weightInKilos / (heightInMeters * heightInMeters);
	    	System.out.printf("Your BMI is: %.1f%n%n", BMIMetric);
	    } // end if BMIMetric
	    
	    System.out.println("BMI Categories:"); 
	    System.out.println("Underweight = <18.5");
	    System.out.println("Normal weight = 18.5–24.9"); 
	    System.out.println("Overweight = 25–29.9"); 
	    System.out.println("Obesity = BMI of 30 or greater\n");
	    System.out.println("Source: https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm");

	    /*
	    System.out.println("BMI Table 1");
	    System.out.println("BMI\t 19\t 20\t 21\t 22\t 23\t 24\t 25\t 26\t 27\t 28\t 29\t 30\t 31\t 32\t 33\t 34\t 35");
	    System.out.println("Height");
	    System.out.println("(inches)\t \t \t \t	Body Weight (pounds)");
	    System.out.println("58\t 91\t 96\t 100\t 105\t 110\t 115\t 119\t 124\t 129\t 134\t 138\t 143\t 148\t 153\t 158\t 162\t 167");
	    System.out.println("59\t 94\t 99\t 104\t 109\t 114\t 119\t 124\t 128\t 133\t 138\t 143\t 148\t 153\t 158\t 163\t 168\t 173");
	    System.out.println("60\t 97\t 102\t 107\t 112\t 118\t 123\t 128\t 133\t 138\t 143\t 148\t 153\t 158\t 163\t 168\t 174\t 179");
	    System.out.println("61\t 100\t 106\t 111\t 116\t 122\t 127\t 132\t 137\t 143\t 148\t 153\t 158\t 164\t 169\t 174\t 180\t 185");
	    System.out.println("62\t 104\t 109\t 115\t 120\t 126\t 131\t 136\t 142\t 147\t 153\t 158\t 164\t 169\t 175\t 180\t 186\t 191");
	    System.out.println("63\t 107\t 113\t 118\t 124\t 130\t 135\t 141\t 146\t 152\t 158\t 163\t 169\t 175\t 180\t 186\t 191\t 197");
	    System.out.println("64\t 110\t 116\t 122\t 128\t 134\t 140\t 145\t 151\t 157\t 163\t 169\t 174\t 180\t 186\t 192\t 197\t 204");
	    System.out.println("65\t 114\t 120\t 126\t 132\t 138\t 144\t 150\t 156\t 162\t 168\t 174\t 180\t 186\t 192\t 198\t 204\t 210");
		System.out.println("66\t 118\t 124\t 130\t 136\t 142\t 148\t 155\t 161\t 167\t 173\t 179\t 186\t 192\t 198\t 204\t 210\t 216");
		System.out.println("67\t 121\t 127\t 134\t 140\t 146\t 153\t 159\t 166\t 172\t 178\t 185\t 191\t 198\t 204\t 211\t 217\t 223");
		System.out.println("68\t 125\t 131\t 138\t 144\t 151\t 158\t 164\t 171\t 177\t 184\t 190\t 197\t 203\t 210\t 216\t 223\t 230");
		System.out.println("69\t 128\t 135\t 142\t 149\t 155\t 162\t 169\t 176\t 182\t 189\t 196\t 203\t 209\t 216\t 223\t 230\t 236");
		System.out.println("70\t 132\t 139\t 146\t 153\t 160\t 167\t 174\t 181\t 188\t 195\t 202\t 209\t 216\t 222\t 229\t 236\t 243");
		System.out.println("71\t 136\t 143\t 150\t 157\t 165\t 172\t 179\t 186\t 193\t 200\t 208\t 215\t 222\t 229\t 236\t 243\t 250");
		System.out.println("72\t 140\t 147\t 154\t 162\t 169\t 177\t 184\t 191\t 199\t 206\t 213\t 221\t 228\t 235\t 242\t 250\t 258");
		System.out.println("73\t 144\t 151\t 159\t 166\t 174\t 182\t 189\t 197\t 204\t 212\t 219\t 227\t 235\t 242\t 250\t 257\t 265");
		System.out.println("74\t 148\t 155\t 163\t 171\t 179\t 186\t 194\t 202\t 210\t 218\t 225\t 233\t 241\t 249\t 256\t 264\t 272");
		System.out.println("75\t 152\t 160\t 168\t 176\t 184\t 192\t 200\t 208\t 216\t 224\t 232\t 240\t 248\t 256\t 264\t 272\t 279");
		System.out.println("76\t 156\t 164\t 172\t 180\t 189\t 197\t 205\t 213\t 221\t 230\t 238\t 246\t 254\t 263\t 271\t 279\t 287");
		System.out.println("Sources: https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi_tbl.htm \n");
		
		System.out.println("BMI Table 2");
		System.out.println("BMI\t 36\t 37\t 38\t 39\t 40\t 41\t 42\t 43\t 44\t 45\t 46\t 47\t 48\t 49\t 50\t 51\t 52\t 53\t 54");
		System.out.println("Height");
		System.out.println("(inches) \t \t \t \t Body Weight (pounds)");
		System.out.println("58\t 172\t 177\t 181\t 186\t 191\t 196\t 201\t 205\t 210\t 215\t 220\t 224\t 229\t 234\t 239\t 244\t 248\t 253\t 258");
		System.out.println("59\t 178\t 183\t 188\t 193\t 198\t 203\t 208\t 212\t 217\t 222\t 227\t 232\t 237\t 242\t 247\t 252\t 257\t 262\t 267");
		System.out.println("60\t 184\t 189\t 194\t 199\t 204\t 209\t 215\t 220\t 225\t 230\t 235\t 240\t 245\t 250\t 255\t 261\t 266\t 271\t 276");
		System.out.println("61\t 190\t 195\t 201\t 206\t 211\t 217\t 222\t 227\t 232\t 238\t 243\t 248\t 254\t 259\t 264\t 269\t 275\t 280\t 285");
		System.out.println("62\t 196\t 202\t 207\t 213\t 218\t 224\t 229\t 235\t 240\t 246\t 251\t 256\t 262\t 267\t 273\t 278\t 284\t 289\t 295");
		System.out.println("63\t 203\t 208\t 214\t 220\t 225\t 231\t 237\t 242\t 248\t 254\t 259\t 265\t 270\t 278\t 282\t 287\t 293\t 299\t 304");
		System.out.println("64\t 209\t 215\t 221\t 227\t 232\t 238\t 244\t 250\t 256\t 262\t 267\t 273\t 279\t 285\t 291\t 296\t 302\t 308\t 314");
		System.out.println("65\t 216\t 222\t 228\t 234\t 240\t 246\t 252\t 258\t 264\t 270\t 276\t 282\t 288\t 294\t 300\t 306\t 312\t 318\t 324");
		System.out.println("66\t 223\t 229\t 235\t 241\t 247\t 253\t 260\t 266\t 272\t 278\t 284\t 291\t 297\t 303\t 309\t 315\t 322\t 328\t 334");
		System.out.println("67\t 230\t 236\t 242\t 249\t 255\t 261\t 268\t 274\t 280\t 287\t 293\t 299\t 306\t 312\t 319\t 325\t 331\t 338\t 344");
		System.out.println("68\t 236\t 243\t 249\t 256\t 262\t 269\t 276\t 282\t 289\t 295\t 302\t 308\t 315\t 322\t 328\t 335\t 341\t 348\t 354");
		System.out.println("69\t 243\t 250\t 257\t 263\t 270\t 277\t 284\t 291\t 297\t 304\t 311\t 318\t 324\t 331\t 338\t 345\t 351\t 358\t 365");
		System.out.println("70\t 250\t 257\t 264\t 271\t 278\t 285\t 292\t 299\t 306\t 313\t 320\t 327\t 334\t 341\t 348\t 355\t 362\t 369\t 376");
		System.out.println("71\t 257\t 265\t 272\t 279\t 286\t 293\t 301\t 308\t 315\t 322\t 329\t 338\t 343\t 351\t 358\t 365\t 372\t 379\t 386");
		System.out.println("72\t 265\t 272\t 279\t 287\t 294\t 302\t 309\t 316\t 324\t 331\t 338\t 346\t 353\t 361\t 368\t 375\t 383\t 390\t 397");
		System.out.println("73\t 272\t 280\t 288\t 295\t 302\t 310\t 318\t 325\t 333\t 340\t 348\t 355\t 363\t 371\t 378\t 386\t 393\t 401\t 408");
		System.out.println("74\t 280\t 287\t 295\t 303\t 311\t 319\t 326\t 334\t 342\t 350\t 358\t 365\t 373\t 381\t 389\t 396\t 404\t 412\t 420");
		System.out.println("75\t 287\t 295\t 303\t 311\t 319\t 327\t 335\t 343\t 351\t 359\t 367\t 375\t 383\t 391\t 399\t 407\t 415\t 423\t 431");
		System.out.println("76\t 295\t 304\t 312\t 320\t 328\t 336\t 344\t 353\t 361\t 369\t 377\t 385\t 394\t 402\t 410\t 418\t 426\t 435\t 443");
		System.out.println("Sources: https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi_tbl2.htm \n");
		*/
		
	} // end method main

}// end class Exercise2_33
