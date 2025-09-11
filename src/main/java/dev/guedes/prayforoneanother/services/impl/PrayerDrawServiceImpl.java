package dev.guedes.prayforoneanother.services.impl;

import dev.guedes.prayforoneanother.mappers.PersonMapper;
import dev.guedes.prayforoneanother.models.Person;
import dev.guedes.prayforoneanother.models.PrayerPair;
import dev.guedes.prayforoneanother.services.PrayerDrawService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implementation of {@link PrayerDrawService} that generates prayer assignments
 * for a list of people. Ensures that each person prays for someone else
 * and handles special cases for small groups.
 *
 * @author João Guedes
 */
public class PrayerDrawServiceImpl implements PrayerDrawService {
    @Override
    public List<PrayerPair> drawPrayerAssignments(List<String> names) {
        List<Person> people = PersonMapper.toPeople(names);

        if (people.isEmpty()) {
            return List.of();
        }
        if (people.size() == 1) {
            return createSelfPrayerAssignment(people.get(0));
        }

        return generatePrayerPairs(people);
    }

    private List<PrayerPair> createSelfPrayerAssignment(Person person) {
        return List.of(new PrayerPair(person, person));
    }

    private List<PrayerPair> generatePrayerPairs(List<Person> people) {
        List<PrayerPair> prayerPairs = new ArrayList<>(people.size());
        List<Integer> availableReceiverIndices = createAvailableReceiverIndices(people.size());

        assignRegularPrayerPairs(people, prayerPairs, availableReceiverIndices);
        assignLastTwoPairs(people, prayerPairs, availableReceiverIndices);

        return prayerPairs;
    }

    private List<Integer> createAvailableReceiverIndices(int peopleCount) {
        List<Integer> receiversIndices = IntStream.range(0, peopleCount)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(receiversIndices);
        return receiversIndices;
    }

    private void assignRegularPrayerPairs(List<Person> people, List<PrayerPair> prayerPairs, List<Integer> availableReceiverIndices) {
        int giverIndex = 0;
        int reciverIndex = 0;

        while (availableReceiverIndices.size() > 2) {
            Person giver = people.get(giverIndex);
            Person receiver = people.get(availableReceiverIndices.get(reciverIndex));

            if (giver != receiver) {
                prayerPairs.add(new PrayerPair(giver, receiver));
                availableReceiverIndices.remove(reciverIndex);

                giverIndex++;
                reciverIndex = 0;
            } else {
                reciverIndex++;
            }
        }
    }

    private void assignLastTwoPairs(List<Person> people, List<PrayerPair> prayerPairs, List<Integer> availableReceiverIndices) {
        int firstIndex = availableReceiverIndices.get(0);
        int secondIndex = availableReceiverIndices.get(1);

        int lastIndex = people.size() - 1;
        int secondLastIndex = people.size() - 2;

        if ((secondLastIndex == firstIndex) || (lastIndex == secondIndex)) {
            prayerPairs.add(new PrayerPair(people.get(secondLastIndex), people.get(secondIndex)));
            prayerPairs.add(new PrayerPair(people.get(lastIndex), people.get(firstIndex)));
        } else {
            prayerPairs.add(new PrayerPair(people.get(secondLastIndex), people.get(firstIndex)));
            prayerPairs.add(new PrayerPair(people.get(lastIndex), people.get(secondIndex)));
        }
    }

    public static PrayerDrawService getInstance() { return InstanceHolder.INSTANCE; }

    private static class InstanceHolder {
        private static final PrayerDrawService INSTANCE = new PrayerDrawServiceImpl();
    }
}
