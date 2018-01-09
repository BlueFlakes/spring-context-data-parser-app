package scc.models;

import scc.interfaces.Flag;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgsInterpreter {
    public String[] args;
    private final int separationIndex = 2;

    public ArgsInterpreter(String[] args) {
        this.args = args;
    }

    public List<String> getBasicSettings() {
        int lowerBound = 0;
        int upperBound = this.args.length >= this.separationIndex ? this.separationIndex : this.args.length;

        return retrieveSettingsFromBounds(lowerBound, upperBound);
    }

    public List<String> getAdditionalSettings() {
        int lowerBound = this.separationIndex;
        int upperBound = this.args.length;

        return retrieveSettingsFromBounds(lowerBound, upperBound);
    }

    public <T extends Enum<T> & Flag> T get(Class<T> deliveredEnumClass, String providedFlag) {
        if (deliveredEnumClass.isEnum()) {
            T[] enumConstantsContainer = deliveredEnumClass.getEnumConstants();

            for (T enumValue : enumConstantsContainer) {
                String foundFlag = enumValue.getEnumFlag();

                if (foundFlag.equals(providedFlag)) {
                    return enumValue;
                }
            }
        }

        return null;
    }

    private List<String> retrieveSettingsFromBounds(int lowerBound, int upperBound) {
        return IntStream.range(lowerBound, upperBound)
                        .mapToObj(idx -> this.args[idx])
                        .collect(Collectors.toList());
    }
}
