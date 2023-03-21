package code;

import java.io.IOException;
import java.util.*;

public class cote {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] companies = new String[]{"A abc 2", "B abc 1"};
        String[] applicants = new String[]{"a AB 1", "b AB 1", "c AB 1"};

        HashMap<String, Integer> intake = getTake(companies);
        HashMap<String, String> priority = getPriority(companies);

        HashMap<String, List<String>> companiesHashmap = companiesToMap(companies);
        HashMap<String, Queue<String>> applicantsHashmap = applicantsToMap(applicants);

        Set<String> passed = new HashSet<>();

        boolean whileFlag = true;
        while (whileFlag) {
            supply(passed, companiesHashmap, applicantsHashmap);
            leave(intake, priority, companiesHashmap);
            makePassed(companiesHashmap, passed);

            whileFlag = checkWhileFlag(passed, applicantsHashmap);
        }

        System.out.println(Arrays.toString(makeAnswer(companiesHashmap)));
    }

    private static String[] makeAnswer(HashMap<String, List<String>> companiesHashmap) {
        return companiesHashmap.keySet().stream().sorted().map(el -> {
            String[] sortValue = companiesHashmap.get(el).stream().sorted().toArray(String[]::new);
            return el + "_" + String.join("", sortValue);
        }).toArray(String[]::new);
    }

    private static void makePassed(HashMap<String, List<String>> companiesHashmap, Set<String> passed) {
        passed.clear();
        companiesHashmap.values().forEach(passed::addAll);
    }

    private static void supply(Set<String> passed, HashMap<String, List<String>> companiesHashmap, HashMap<String, Queue<String>> applicantsHashmap) {
        applicantsHashmap.forEach((k, v) -> {
            if(passed.contains(k)) {
                return;
            }

            String applyCompany = v.poll();
            if (applyCompany == null) {
                return;
            }

            List<String> applicantList = companiesHashmap.get(applyCompany);
            applicantList.add(k);
            companiesHashmap.put(applyCompany, applicantList);
        });
    }

    private static HashMap<String, Integer> getTake(String[] companies) {
        HashMap<String, Integer> intake = new HashMap<>();
        Arrays.stream(companies).forEach(company -> {
            String[] splitCompany = company.split(" ");
            intake.put(splitCompany[0], Integer.parseInt(splitCompany[2]));
        });
        return intake;
    }

    private static HashMap<String, String> getPriority(String[] companies) {
        HashMap<String, String> priority = new HashMap<>();
        Arrays.stream(companies).forEach(company -> {
            String[] splitCompany = company.split(" ");
            priority.put(splitCompany[0], splitCompany[1]);
        });
        return priority;
    }

    private static void leave(HashMap<String, Integer> intake, HashMap<String, String> priority, HashMap<String, List<String>> companiesHashmap) {
        companiesHashmap.forEach((k, v) -> {
            if (v.size() < intake.get(k)) {
                return;
            }

            String applicantsPriority = priority.get(k); // cebdfa
            int leaveCount = v.size() - intake.get(k);
            int nowLeaveCount = 0;

            for (int i=applicantsPriority.length()-1; 0<=i; i--) {
                String s = applicantsPriority.split("")[i];
                if (v.contains(s)) {
                    v.remove(s);
                    nowLeaveCount++;
                }

                if (leaveCount == nowLeaveCount) {
                    return;
                }
            }
        });
    }

    private static boolean checkWhileFlag(Set<String> passed, HashMap<String, Queue<String>> applicantsHashmap) {
        return applicantsHashmap.keySet().stream()
                .filter(el-> !passed.contains(el))
                .map(applicantsHashmap::get)
                .anyMatch(el -> el.size() > 0);
    }

    private static HashMap<String, List<String>> companiesToMap(String[] companies) {
        HashMap<String, List<String>> applicantsHashmap = new HashMap<>();
        Arrays.stream(companies).forEach(company ->
                applicantsHashmap.put(company.split(" ")[0], new ArrayList<String>())
        );
        return applicantsHashmap;
    }

    private static HashMap<String, Queue<String>> applicantsToMap(String[] applicants) {
        HashMap<String, Queue<String>> applicantsHashmap = new HashMap<>();
        Arrays.stream(applicants).forEach(applicant -> {
            String[] splitApplicant = applicant.split(" ");
            Queue<String> like = new LinkedList<>(Arrays.asList(splitApplicant[1].substring(0, Integer.parseInt(splitApplicant[2])).split("")));

            applicantsHashmap.put(
                    splitApplicant[0],
                    like
            );
        });
        return applicantsHashmap;
    }
}

