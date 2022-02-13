import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandAnalyzer {

    List<Card> hand = new ArrayList<>();

    public HandAnalyzer() {
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    /*
    sort the hand by suit(ascending order)
     */
    private List<String> sortSuit() {
        List<String> suits = new ArrayList<>();
        for (Card card : hand) {
            suits.add(card.getSuit());
        }
        Collections.sort(suits);
        //System.out.println(suits);
        return suits;
    }

    /*
    sort the hand by faces(ascending order)
     */
    private List<Integer> sortFaces() {
        List<Integer> faces = new ArrayList<>();
        for (Card card : hand) {
            faces.add(card.getFace());
        }
        Collections.sort(faces);
        //System.out.println(faces);

        return faces;
    }

    private boolean isFlush() {
        /*
        Check if the first and the last card are the same after they are ordered
         */
        List<String> suits = sortSuit();
        return suits.get(0).equals(suits.get(4));
    }

    private boolean isStraight() {
        List<Integer> faces = sortFaces();

        if (faces.get(4) == 14) {
             /* ------------------------------------------------------
             Check for: straight with ace: ace 2 3 4 5 or 10 11 12 13 ace
	         ------------------------------------------------------- */
            boolean a = faces.get(0) == 2 && faces.get(1) == 3 &&
                    faces.get(2) == 4 && faces.get(3) == 5;
            boolean b = faces.get(0) == 10 && faces.get(1) == 11 &&
                    faces.get(2) == 12 && faces.get(3) == 13;

            return (a || b);
        } else {
             /* ------------------------------------------------------
             Check for 5 different values that are increasing
             ------------------------------------------------------- */
            int card = faces.get(0) + 1;

            for (int i = 1; i < 5; i++) {
                if (faces.get(i) != card)
                    return (false);

                card++;
            }

            return (true);
        }
    }

    private boolean isFourOfAKind() {

        List<Integer> faces = sortFaces();

         /* ------------------------------------------------------
         Check for: x x x x y
	     ------------------------------------------------------- */

        boolean case1 = faces.get(0).equals(faces.get(1)) &&
                faces.get(1).equals(faces.get(2)) &&
                faces.get(2).equals(faces.get(3));
         /* ------------------------------------------------------
         Check for: y x x x x
	     ------------------------------------------------------- */

        boolean case2 = faces.get(1).equals(faces.get(2)) &&
                faces.get(2).equals(faces.get(3)) &&
                faces.get(3).equals(faces.get(4));

        return (case1 || case2);
    }

    private boolean isFullHouse() {
        List<Integer> faces = sortFaces();

         /* ------------------------------------------------------
         Check for: x x x y y
	     ------------------------------------------------------- */

        boolean case1 = faces.get(0).equals(faces.get(1)) &&
                faces.get(1).equals(faces.get(2)) &&
                faces.get(3).equals(faces.get(4));

         /* ------------------------------------------------------
         Check for: x x y y y
	     ------------------------------------------------------- */
        boolean case2 = faces.get(0).equals(faces.get(1)) &&
                faces.get(2).equals(faces.get(3)) &&
                faces.get(3).equals(faces.get(4));

        return (case1 || case2);
    }


    private boolean isThreeOfAKind() {
        List<Integer> faces = sortFaces();

         /* ------------------------------------------------------
         Check for: x x x a b
	     ------------------------------------------------------- */
        boolean case1 = faces.get(0).equals(faces.get(1)) &&
                faces.get(1).equals(faces.get(2)) &&
                !faces.get(3).equals(faces.get(0)) &&
                !faces.get(4).equals(faces.get(0)) &&
                !faces.get(3).equals(faces.get(4));

         /* ------------------------------------------------------
         Check for: a x x x b
	     ------------------------------------------------------- */
        boolean case2 = faces.get(1).equals(faces.get(2)) &&
                faces.get(2).equals(faces.get(3)) &&
                !faces.get(0).equals(faces.get(1)) &&
                !faces.get(4).equals(faces.get(1)) &&
                !faces.get(0).equals(faces.get(4));

         /* ------------------------------------------------------
         Check for: a b x x x
	     ------------------------------------------------------- */
        boolean case3 = faces.get(2).equals(faces.get(3)) &&
                faces.get(3).equals(faces.get(4)) &&
                !faces.get(0).equals(faces.get(2)) &&
                !faces.get(1).equals(faces.get(2)) &&
                !faces.get(0).equals(faces.get(1));

        return (case1 || case2 || case3);
    }

    private boolean isTwoPairs() {

        if (isFourOfAKind() || isThreeOfAKind() || isFullHouse()) return false;

        List<Integer> faces = sortFaces();

         /* --------------------------------
         Checking: a a  b b x
	    -------------------------------- */
        boolean case1 = faces.get(0).equals(faces.get(1)) &&
                faces.get(2).equals(faces.get(3));

         /* ------------------------------
         Checking: a a x  b b
	    ------------------------------ */
        boolean case2 = faces.get(0).equals(faces.get(2)) &&
                faces.get(3).equals((faces.get(4)));

         /* ------------------------------
         Checking: x a a  b b
	     ------------------------------ */
        boolean case3 = faces.get(1).equals(faces.get(2)) &&
                faces.get(3).equals(faces.get(4));

        return (case1 || case2 || case3);
    }

    private boolean isPair() {
        if (isFourOfAKind() || isThreeOfAKind() || isFullHouse() || isTwoPairs()) return false;

        List<Integer> faces = sortFaces();

         /* --------------------------------
         Checking: a a x y z
	     -------------------------------- */
        boolean case1 = faces.get(0).equals((faces.get(1)));
        ;

         /* --------------------------------
         Checking: x a a y z
	     -------------------------------- */
        boolean case2 = faces.get(1).equals((faces.get(2)));
        ;

        /* --------------------------------
         Checking: x y a a z
	    -------------------------------- */
        boolean case3 = faces.get(2).equals((faces.get(3)));
        ;

        /* --------------------------------
         Checking: x y z a a
	    -------------------------------- */
        boolean case4 = faces.get(3).equals((faces.get(4)));


        return (case1 || case2 || case3 || case4);

    }

    /* creates a ranking buy what is the best hand starting with 0 being the best score and 6 the worst
     100 meaning no combo achieved */
    public int getScore() {
        ArrayList<Boolean> values = new ArrayList<>();
        values.add(isFlush());
        values.add(isStraight());
        values.add(isFourOfAKind());
        values.add(isFullHouse());
        values.add(isThreeOfAKind());
        values.add(isTwoPairs());
        values.add(isPair());

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i)) return i;
        }
        return 100;
    }

}
