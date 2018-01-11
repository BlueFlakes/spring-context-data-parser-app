package scc.models;

import scc.exception.InvalidArgumentCombinationException;
import scc.interfaces.Flag;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgsInterpreter {
    private String[] args;
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

    private List<String> retrieveSettingsFromBounds(int lowerBound, int upperBound) {
        return IntStream.range(lowerBound, upperBound)
                        .mapToObj(idx -> this.args[idx])
                        .collect(Collectors.toList());
    }

    public <T extends Enum<T> & Flag> ArgsSearcher<T> getSearcher(Class<T> deliveredEnumClass) {
        return new ArgsSearcher<>(deliveredEnumClass, getAdditionalSettings());
    }

    public static class ArgsSearcher<T extends Enum<T> & Flag> {
        private final Class<T> deliveredEnumClass;
        private List<String> additionalSettings;

        private ArgsSearcher(Class<T> deliveredEnumClass, List<String> additionalSettings) {
            this.additionalSettings = additionalSettings;
            this.deliveredEnumClass = deliveredEnumClass;
        }

        public String findFlagWhichStartsWith(String prefix) throws InvalidArgumentCombinationException {
            for (String providedFlag : this.additionalSettings) {
                if (providedFlag.startsWith(prefix)) {
                    return providedFlag;
                }
            }

            String errorMessage = "Given prefix: " + prefix + " | didn't use pre command";
            throw new InvalidArgumentCombinationException(errorMessage);
        }

        public T findEnumByFlag() {
            if (this.deliveredEnumClass.isEnum()) {
                T[] enumConstantsContainer = this.deliveredEnumClass.getEnumConstants();

                for (String providedFlag : this.additionalSettings) {
                    for (T enumValue : enumConstantsContainer) {
                        String enumFlag = enumValue.getEnumFlag();

                        if (enumFlag != null && enumFlag.equals(providedFlag)) {
                            return enumValue;
                        }
                    }
                }
            }

            return null;
        }

        public boolean isEnumWithGivenOptionAvailable() {
            return findEnumByFlag() != null;
        }
    }
}
