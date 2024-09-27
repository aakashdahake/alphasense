import models.Release;
import releaseLogic.ReleaseManager;

import java.util.List;

import static releaseLogic.ReleaseManager.findMaxReleases;
import static releaseLogic.ReleaseManager.readReleases;

public class ApplicationRun {
    public static void main(String[] args) {

        final String inputFilePath = "resource/input/releases.txt";
        final String outputFileName = "resource/output/solution.txt";

        List<Release> releases = readReleases(inputFilePath);

        List<Release> maxReleases = findMaxReleases(releases);

        /* Print result */
        maxReleases.forEach(release -> System.out.println(release.getDay() + " " + release.getDayValidateRelease()));

        ReleaseManager.writeSolution(outputFileName, maxReleases);

    }

}