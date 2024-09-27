package releaseLogic;

import models.Release;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReleaseManager {

    public static List<Release> readReleases(String filename) {
        List<Release> releases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int day = Integer.parseInt(parts[0]);

                if (day < 1 || day > 10) {
                    System.err.println("Invalid release day: " + day + ". Skipping this release.");
                    continue;
                }

                int duration = Integer.parseInt(parts[1]);
                if (duration < 1 || duration > 10) {
                    System.err.println("Invalid release duration: " + duration + ". Skipping this release.");
                    continue;
                }
                releases.add(new Release(day, duration));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return releases;
    }

    public static List<Release> findMaxReleases(List<Release> releases) {

        Collections.sort(releases, Comparator.comparingInt(r -> r.getDayValidateRelease()));

        List<Release> maxReleases = new ArrayList<>();
        int lastValidDay = 0;

        for (Release release : releases) {
            if (release.getDay() > lastValidDay && release.getDayValidateRelease() <= 10) {
                maxReleases.add(release);
                lastValidDay = release.getDayValidateRelease();
            }
        }
        return maxReleases;
    }

    public static void writeSolution(String filename, List<Release> solution) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(solution.size() + "\n"); // Write the number of releases
            for (Release release : solution) {
                bw.write(release.getDay() + " " + release.getDayValidateRelease() + "\n"); // Write start and end days
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }



}
