public class Roman2Arabic {
    /**
     *
     * @param a
     * @return
     */
    // it takes a char and return the Arabic value of it, if it's not a roman numeral it throws an error.
    public static int convertSingleNumeral(char a) {
        int val = 0;
        if (a == 'I') val = 1;
        else if (a == 'V') val = 5;
        else if (a == 'X') val = 10;
        else if (a == 'L') val = 50;
        else if (a == 'C') val = 100;
        else if (a == 'D') val = 500;
        else if (a == 'M') val = 1000;
        else throw new RomanNumeralException("Invalid");

        return val;
    }

    /**
     *
     * @param s
     * @return
     */
    // This takes a Roman numeral string and checks for the rules and throws an error if needed and returns the Arabic value.
    public static int convertWholeNumeral(String s) {
        int val = 0, I = 0, X = 0, C = 0, M = 0, V = 0, L = 0, D = 0;
        int total = 0;

        ArrayStack<Character> stack = new ArrayStack<Character>();
        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c) == 'I') {
                I += 1;
                X = 0;
                C = 0;
                M = 0;
            } else if (s.charAt(c) == 'V') {
                V += 1;
                I = 0;
                X = 0;
                C = 0;
                M = 0;
            } else if (s.charAt(c) == 'X') {
                X += 1;
                I = 0;
                C = 0;
                M = 0;
            } else if (s.charAt(c) == 'L') {
                L += 1;
                I = 0;
                X = 0;
                C = 0;
                M = 0;
            } else if (s.charAt(c) == 'C') {
                C += 1;
                I = 0;
                X = 0;
                M = 0;
            } else if (s.charAt(c) == 'D') {
                D += 1;
                I = 0;
                X = 0;
                C = 0;
                M = 0;
            } else if (s.charAt(c) == 'M') {
                M += 1;
                I = 0;
                X = 0;
                C = 0;

            }
            // checking the rules
            if (I > 3 || X > 3 || C > 3 || M > 3) {
                throw new RomanNumeralException("Invalid");
            }
            if (V > 1 || L > 1 || D > 1) {
                throw new RomanNumeralException("Invalid");
            }
            if (stack.isEmpty()) {
                stack.push(s.charAt(c));
            } else {
                if (convertSingleNumeral(s.charAt(c)) <= convertSingleNumeral(stack.peek())) {
                    stack.push(s.charAt(c));

                } else {
                    val = convertSingleNumeral(s.charAt(c)) - convertSingleNumeral(stack.pop());
                }
            }

            total += val;
            val = 0;
        }
        // while loop to add whatever is still in the stack
        while (!stack.isEmpty()) {
            total += convertSingleNumeral(stack.pop());
        }
        return total;
    }
}
