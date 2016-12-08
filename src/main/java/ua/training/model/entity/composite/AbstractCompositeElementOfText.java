package ua.training.model.entity.composite;

import ua.training.model.entity.ElementOfText;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents abstract composite
 *
 * @author Roman Prokopenko
 */
public abstract class AbstractCompositeElementOfText implements ElementOfText {

    /**
     * List of sub elements of composite
     * Sub elements must implement {@link ElementOfText}
     */
    protected List<ElementOfText> subElements = new ArrayList<>();

    @Override
    public abstract void parse(String text);

    public List<ElementOfText> getSubElements() {
        return subElements;
    }

    /**
     * Calls toString() of all sub elements
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ElementOfText element :
                subElements) {
            stringBuilder.append(element.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractCompositeElementOfText)) return false;

        AbstractCompositeElementOfText that = (AbstractCompositeElementOfText) o;

        return subElements.equals(that.subElements);

    }

    @Override
    public int hashCode() {
        return subElements.hashCode();
    }
}
