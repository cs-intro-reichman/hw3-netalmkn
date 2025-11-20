/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(preProcess("What? No way!!!"));
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		String str = "1234567";
		Boolean pass = true;
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	
	public static boolean isAnagram(String str1, String str2) {
    String s1 = preProcess(str1);
    String s2 = preProcess(str2);

    if (s1.length() != s2.length()) {
        return false;
    }

    for (int i = 0; i < s1.length(); i++) {
        char c = s1.charAt(i);
        int index = s2.indexOf(c);
        if (index == -1) {
            return false;
        }
        s2 = s2.substring(0, index) + s2.substring(index + 1);
    }

    return s2.length() == 0;
	}

	   
	public static String preProcess(String s) {
    String result = "";  

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);   

        if (c == ' ') {
            result = result + " ";
        } else if (c >= 'A' && c <= 'Z') {
            char lower = (char) (c - 'A' + 'a');
            result = result + lower;
        } else if (c >= 'a' && c <= 'z') {
            result = result + c;
        }
    }

    return result;
}

	   
	public static String randomAnagram(String str) {
    	String shuffled = "";
    	while (str.length() > 0) {
        	int randomIndex = (int)(Math.random() * str.length());
        	shuffled += str.charAt(randomIndex);
        	str = str.substring(0, randomIndex) + str.substring(randomIndex + 1);
    	} 
    	return shuffled;
	}
}
