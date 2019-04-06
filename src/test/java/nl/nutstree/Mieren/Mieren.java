package nl.nutstree.Mieren;

public class Mieren {
    private String links;
    private String rechts;

    public Mieren(String links, String rechts) {
        this.links = links;
        this.rechts = rechts;
    }

    public String tijdStap(int stappen) {
        String result = links + rechts;

        for (int j = 0; j < stappen; j++) {
            result = stap(result);
        }
        return result;
    }

    private String stap(String mierenInput) {
        String[] mieren = mierenInput.split("");
        String result = "";

        for (int i = 0; i < mieren.length; i++) {
            if (isErNogEenMier(mieren, i) && isSpringSituatie(mieren[i], mieren[i + 1])) {
                result += mieren[i + 1] + mieren[i];
                i++;
                continue;
            }

            result += mieren[i];
        }
        return result;
    }

    private boolean isErNogEenMier(String[] mieren, int positie) {
        return positie + 1 < mieren.length;
    }

    private boolean isSpringSituatie(String linkerMier, String rechterMier) {
        return links.contains(linkerMier) && rechts.contains(rechterMier);
    }
}
