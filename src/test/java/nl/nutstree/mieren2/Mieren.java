package nl.nutstree.mieren2;

public class Mieren {
    private final String links;
    private final String rechts;

    public Mieren(String links, String rechts) {
        this.links = links;
        this.rechts = rechts;
    }

    public String stappen(int aantal) {
        if (aantal == 1) {
            if (links.length() > 1) {
                return "" + links.charAt(0) + rechts.charAt(0) + links.charAt(1);
            }
            return rechts + links;
        }
        return links + rechts;
    }
}
