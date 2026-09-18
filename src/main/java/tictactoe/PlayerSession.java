package tictactoe;

/**
 * Stores player-session information between games so player names can
 * optionally be reused after a restart.
 * <p>
 * The restart preference is one-shot state: once it is consumed by the next
 * game, it automatically resets to {@code false}.
 * <p>
 * This class uses simple static state because the application maintains only
 * one active CLI game session at a time.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public final class PlayerSession {

    private static String lastPlayer1Name;
    private static String lastPlayer2Name;
    private static boolean reuseNextGame = false;

    /**
     * Prevents instantiation of this utility class.
     */
    private PlayerSession() {
    }

    /**
     * Stores the player names from the current game.
     *
     * @param player1Name the first player's name
     * @param player2Name the second player's name
     */
    public static void remember(String player1Name, String player2Name) {
        lastPlayer1Name = player1Name;
        lastPlayer2Name = player2Name;
    }

    /**
     * Determines whether names from a previous game are available.
     *
     * @return {@code true} if both player names have been stored;
     *         otherwise {@code false}
     */
    public static boolean hasPlayers() {
        return lastPlayer1Name != null && lastPlayer2Name != null;
    }

    /**
     * Returns the stored first player's name.
     *
     * @return the first player's name, or {@code null} if none has been stored
     */
    public static String player1() {
        return lastPlayer1Name;
    }

    /**
     * Returns the stored second player's name.
     *
     * @return the second player's name, or {@code null} if none has been stored
     */
    public static String player2() {
        return lastPlayer2Name;
    }

    /**
     * Sets whether the next game should reuse the stored player names.
     *
     * @param reuse {@code true} to reuse the stored names in the next game;
     *              otherwise {@code false}
     */
    public static void reuseOnNextGame(boolean reuse) {
        reuseNextGame = reuse;
    }

    /**
     * Returns the current player-name reuse preference and immediately resets
     * it so the preference applies to only one game.
     *
     * @return {@code true} if the next game should reuse the stored player
     *         names; otherwise {@code false}
     */
    public static boolean consumeReuseFlag() {
        boolean reuse = reuseNextGame;
        reuseNextGame = false;
        return reuse;
    }
}
