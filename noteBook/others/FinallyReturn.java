public class FinallyReturn {
    /** This method finally returns false */
    private static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
