Changes:

-Moved all methods and fields except getBoard() to abstract class AbstractSolitaireModel, which was then used for EuropeanSolitaireModelImpl and TriangleSolitaireModelImpl

-Changed fields from private to public

-Added new tests for MarbleSolitaireModelImpl including tests for constructors and illegal moves

-Added on to the java doc for the move method in AbstractSolitaireModel