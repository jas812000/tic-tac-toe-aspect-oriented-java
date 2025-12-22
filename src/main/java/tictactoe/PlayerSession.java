package tictactoe;

/**
 * Stores player names across restarts so we can optionally reuse them.
 * This is intentionally simple static state for a CLI app.
 */
public final class PlayerSession {

    private PlayerSession() {}

    private static String lastPlayer1Name;
    private static String lastPlayer2Name;

    // If true, next game should reuse last names (one-shot)
    private static boolean reuseNextGame = false;

    public static void remember(String p1, String p2) {
        lastPlayer1Name = p1;
        lastPlayer2Name = p2;
    }

    public static boolean hasPlayers() {
        return lastPlayer1Name != null && lastPlayer2Name != null;
    }

    public static String player1() {
        return lastPlayer1Name;
    }

    public static String player2() {
        return lastPlayer2Name;
    }

    public static void reuseOnNextGame(boolean reuse) {
        reuseNextGame = reuse;
    }

    public static boolean consumeReuseFlag() {
        boolean r = reuseNextGame;
        reuseNextGame = false; // one-shot
        return r;
    }
}
