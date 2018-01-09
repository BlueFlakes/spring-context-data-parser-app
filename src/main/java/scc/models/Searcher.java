package scc.models;

import scc.interfaces.Flag;

import java.util.List;

public class Searcher<T extends Enum<T> & Flag> {
    private final Class<T> deliveredEnumClass;
    private List<String> additionalSettings;

    public Searcher(Class<T> deliveredEnumClass, List<String> additionalSettings) {
        this.additionalSettings = additionalSettings;
        this.deliveredEnumClass = deliveredEnumClass;
    }

    public T findEnumByFlag() {
        if (this.deliveredEnumClass.isEnum()) {
            T[] enumConstantsContainer = this.deliveredEnumClass.getEnumConstants();

            for (String providedFlag : this.additionalSettings) {
                for (T enumValue : enumConstantsContainer) {
                    String foundFlag = enumValue.getEnumFlag();

                    if (foundFlag.equals(providedFlag)) {
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
