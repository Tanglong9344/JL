public class FinallyReturnExit {
    /**  return false*/
    private static boolean finallyRetuen() {
        try {
            return true;
        } finally {
            return false;
        }
    }

    /** return noting */
    private static boolean finallyExit() {
        try {
            // return true;
            System.exit(0);
        } finally {
            return false;
        }
    }
}
